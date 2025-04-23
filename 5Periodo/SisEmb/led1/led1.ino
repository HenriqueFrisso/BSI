const int led = 4;
const int button = 3;
int buttonstate = 0;
bool ligado = false;

void setup() {
  pinMode(led, OUTPUT);
  pinMode(button, INPUT); // Changed to INPUT to read the button state
}

void loop() {
  buttonstate = digitalRead(button);
  
  if (buttonstate == LOW) {
    if (ligado == true) {
      ligado = false;
    } else {
      ligado = true;
    }

    // Wait for button release (to avoid bouncing)
    while (digitalRead(button) == LOW) {
      delay(10); // Debounce delay
    }
  }

  if (ligado == false) {
    digitalWrite(led, LOW);
  } else {
    digitalWrite(led, HIGH);
  }
}
