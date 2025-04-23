#include <EEPROM.h>
#include <TimerOne.h>

#define TRIG_PIN 13
#define ECHO_PIN 12
volatile int MODO = 0;
volatile int piscar = 0;


void interruptHandler() {
    if (MODO == 0){
      if (piscar ==0){
        digitalWrite(7, HIGH);
      }else{
        digitalWrite(7, LOW);
      }
    }else if(MODO == 1){
      if (piscar ==0 or piscar ==3){
        digitalWrite(7, HIGH);
      }else{
        digitalWrite(7, LOW);
      }
    }else if(MODO == 2){
      if (piscar ==0 or piscar ==3 or piscar ==6){
        digitalWrite(7, HIGH);
      }else{
        digitalWrite(7, LOW);
      }
    }else if(MODO == 3){
      digitalWrite(7, LOW);
    }
    piscar++;
    piscar = piscar%20;
}

void salvarCor(int mem, int cor){
  EEPROM.write(mem, cor);
}

void carregarCor(int collors[], int pins[]){
  for (int i = 0; i < 3; i++){
    collors[i] = EEPROM.read(i);
    analogWrite(pins[i], collors[i]);  
    }
}

int delta(int num){
  return (num - 5);  // Ajuste para dar um "delta" no valor
}

int mudarCor(int anal){
  return (anal / 100);  // Divide o valor lido para normalizar
}

int selPin(int pin){
  pin += 1;  // Aumenta o valor do pino
  return (pin % 3);  // Garante que o valor fique dentro de 0, 1, 2
}

void iluminar(int collors[], int maxcolors[], int dist){
  int valdist = -(dist*10);
  for (int i = 0; i<3;i++){
    maxcolors[i] = 255 + valdist;
    if (maxcolors[i] > collors[i] ){
      maxcolors[i] = collors[i];
    } else if(maxcolors[i] < 0){
      maxcolors[i] = 0;  
    }
  }
}
void interrupcao() {
  MODO += 1;
  MODO = MODO%4;
}
int pins[3] = {3, 5, 6};  // Pinos para controle de cor (RGB)
int r = 0, g = 0, b = 0;
int pin = 0;
int green[3] = {0, 128, 0};
int red[3] = {255, 0, 0};
int yellow[3] = {255, 255, 0};
int collors[3] = {0, 0, 0};  // Armazena o valor das cores
int mem[3] = {0,1,2};
int maxcolors[3] = {0,0,0};
int pinLed = 7;
int pinSensorLase = 9;

const int button = 8;  // Pino do botão
int buttonstate = 0;    // Estado do botão
int lastButtonState = HIGH; // Variável para debouncing
const int botaoSimples = 2;

void setup() {
  pinMode(pinLed, OUTPUT);
  pinMode(pinSensorLase, INPUT);
  pinMode(6, OUTPUT);
  pinMode(5, OUTPUT);
  pinMode(3, OUTPUT);
  pinMode(A5, INPUT);
  pinMode(button, INPUT);
  pinMode(botaoSimples, INPUT);
  pinMode(TRIG_PIN, OUTPUT);
  pinMode(ECHO_PIN, INPUT);
  Serial.begin(9600);  // Inicializa a comunicação serial uma vez no setup
  attachInterrupt(digitalPinToInterrupt(botaoSimples), interrupcao, RISING);
  carregarCor(collors, pins);
  Timer1.initialize(100000);
  Timer1.attachInterrupt(interruptHandler);
  
}
void alterarCor(){
  int buttonstate = digitalRead(button);
  int estadobotao = digitalRead(botaoSimples);

  // Verifica se o botão foi pressionado (debounce simples)
  if (buttonstate == LOW && lastButtonState == HIGH) {
    salvarCor(mem[pin],collors[pin]);
    pin = selPin(pin);  // Muda o pino
    
    while (digitalRead(button) == LOW) {
      delay(10);  // Aguarda a liberação do botão para evitar "bouncing"
    }
  }

  
  if (buttonstate == LOW && lastButtonState == HIGH) {
    salvarCor(mem[pin], collors[pin]);
    pin = selPin(pin);  // Muda o pino
    
    delay(50);  // Pequeno atraso para debounce
    while (digitalRead(button) == LOW); // Aguarda a liberação
  }
  lastButtonState = buttonstate; // Atualiza estado do botão


  // Lê o valor do pino analógico A5
  int valorAnalogico = analogRead(A5); 

  // Processa o valor lido
  int deltas = delta(mudarCor(valorAnalogico));
  
  // Imprime os valores no monitor serial para depuração


  // Atualiza a cor no índice escolhido por 'pin'
  collors[pin] += deltas;

  // Garante que os valores de coloração não ultrapassem o limite de 255
  collors[pin] = constrain(collors[pin], 0, 255);

  // Aplica a cor no pino correspondente
  //analogWrite(pins[pin], collors[pin]);

  // Armazena o estado do botão atual para o debounce
  lastButtonState = buttonstate;

  
  // Limpar o pino TRIG
  digitalWrite(TRIG_PIN, LOW);
  delayMicroseconds(2);

  // Enviar um pulso de 10 microssegundos para o pino TRIG
  digitalWrite(TRIG_PIN, HIGH);
  delayMicroseconds(10);
  digitalWrite(TRIG_PIN, LOW);

  // Medir o tempo que o som levou para ir e voltar
  long duration = pulseIn(ECHO_PIN, HIGH);

  // Calcular a distância com base na velocidade do som (aproximadamente 343 metros por segundo)
  long distance = duration * 0.0344 / 2;


  // Exibir a distância no monitor serial
  //Serial.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
  Serial.print("RGB: ");
  Serial.print(collors[0]);
  Serial.print(", ");
  Serial.print(collors[1]);
  Serial.print(", ");
  Serial.println(collors[2]);
  
  Serial.print("RGB esperado: ");
  Serial.print(maxcolors[0]);
  Serial.print(", ");
  Serial.print(maxcolors[1]);
  Serial.print(", ");
  Serial.println(maxcolors[2]);

  
  Serial.print("Distância: ");
  Serial.print(distance);
  Serial.println(" cm");
  iluminar(collors, maxcolors, distance);
  for (int i =0; i<3; i++){
  analogWrite(pins[i], maxcolors[i]);  
  analogWrite(pins[i], maxcolors[i]);  
  analogWrite(pins[i], maxcolors[i]);  
  }
  
  // Aguardar um pouco antes de medir novamente
  delay(100);
}

void aproximacao(){
  
}

void distancia(){
  int estado = digitalRead(pinSensorLase); 
  
  if (estado == LOW) {  
        // Se detectar um obstáculo, muda a cor do LED para vermelho
        analogWrite(pins[0], 255);  // Vermelho máximo
        analogWrite(pins[1], 0);    // Verde apagado
        analogWrite(pins[2], 0);    // Azul apagado
    } else {
        // Se não detectar nada, mantém a cor azul como padrão (pode alterar)
        analogWrite(pins[0], 0);
        analogWrite(pins[1], 255);
        analogWrite(pins[2], 0);
    }
}

void loop() {
  if (MODO == 0){
    alterarCor();
  }else if (MODO == 1){
    aproximacao();
  }else{
    distancia();
  }
  
  
}
