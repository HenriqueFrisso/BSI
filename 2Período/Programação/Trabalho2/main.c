#include <stdio.h>

#define MAX 100

int lerTamanho(char vetor[]) { //Lê o tamanho de uma string
  int strlen = 0;
  while (vetor[strlen] != '\0') { //Adiciona 1 ao contador até encontrar o \n na string
    strlen++;
  }
  return strlen; //Retorna o tamanho da string
}

void lerString(char vet[]) { //Lê uma string digitada
  printf("Digite a string: ");
  fgets(vet, MAX, stdin);
  int qtd = lerTamanho(vet); //Lê o tamanho da string digitada
  vet[qtd - 1] = '\0'; //Altera o "\n" por "\0" no final da string
}

void inverterString(char vet[], int qtd) { //Inverte uma string (asd)->(dsa)
  char inverso[MAX]; //Cria um vetor para armazenar o inverso da string
  int i, j;
  for (i = 0; i < qtd; i++) { //Copia a string para o novo vetor
    inverso[i] = vet[i];
  }
  for (i = 0, j = (qtd - 1); i < qtd; i++, j--) { //Inverte a string
    vet[i] = inverso[j];
  }
}

void primeiraEtapa(char vet1[], char vet2[], int qtd) { //Primeira etapa da criptografia
  char c;
  int i;
  for (i = 0; i < qtd; i++) { //Adiciona ao vetor a mesma string mas com as devidas alterações
    c = vet1[i];
    switch (c) {
      case ('o'):
        vet2[i] = '0';
        break;
      case ('0'):
        vet2[i] = 'o';
        break;
      case ('a'):
        vet2[i] = '@';
        break;
      case ('@'):
        vet2[i] = 'a';
        break;
      default:
        vet2[i] = c;
    }
  }
}

void segundaEtapa(char vetString[], char vet1[], char vet2[], int qtd, int *qtd1, int *qtd2) { //Segunda etapa da criptografia
  int c = 0, i;
  for (i = 0; i < qtd; i += 2) { //Adiciona os caracteres em posições impares ao primeiro string
    vet1[c] = vetString[i];
    c++;
  }
  *qtd1 = c;
  c = 0;
  for (i = 1; i < qtd; i += 2) { //Adiciona os caracteres em posições pares ao segundo string
    vet2[c] = vetString[i];
    c++;
  }
  *qtd2 = c;
  inverterString(vet2, *qtd2); //Inverte o segundo string
}

void terceiraEtapa(char criptografia[], char vet1[], char vet2[], int qtd, int qtd1, int qtd2) { //Terceira etapa da criptografia
  int c = 0, c1 = 0, c2 = 0;
  do { //Utiliza um contador para contar quantos caracteres possuem a string origial e as duas strings que foram divididas na etapa anterior, adicionando as alternadamente até que ambas terminem
    if (c1 < qtd1) { //Verificador para saber se todos os elementos da primeira string foram adicionados
      criptografia[c] = vet1[c1];
      c++;
      c1++;
    }
    if (c2 < qtd2) { //Verificador para saber se todos os elementos da segunda string foram adicionados
      criptografia[c] = vet2[c2];
      c++;
      c2++;
    }
  } while (c < qtd); //Verificador para saber se a string criptografada possui o mesmo tamanho da original
}

void imprimirEtapas(char criptografia1[],char criptografiaFinal[],char str1[],char str2[], int tamanho,int qtd1,int qtd2){ //Imprimi os resultados de cada etapa do processo
  printf("\nPrimeira etapa: %s\n",criptografia1); //Primeira etapa: Substituir os "o" por "0", "a" por "@", "0" por "o", "@" por "a"
  printf("Segunda etapa:\n%s\n%s\n",str1,str2); //Segunda etapa: Dividir a string original em duas e inverter a segunda
  printf("Terceira etapa: %s\n",criptografiaFinal); //Terceira etapa: Intercalar as duas strings geradas na etapa anterior
}

void imprimirResultado(char criptografiaFinal[], int tamanho){ //Imprimi o resultado da criptografia
  printf("\nMensagem criptografada: %s\n",criptografiaFinal); //Mensagem criptografada
}

int main(void) {
  char string[MAX], criptografia1[MAX], criptografiaFinal[MAX], str1[MAX], str2[MAX];
  int tamanho,qtd1,qtd2;
  lerString(string);
  tamanho = lerTamanho(string);
  primeiraEtapa(string, criptografia1, tamanho);
  segundaEtapa(criptografia1, str1, str2, tamanho, &qtd1, &qtd2);
  terceiraEtapa(criptografiaFinal, str1, str2, tamanho, qtd1, qtd2);
  //imprimirEtapas(criptografia1, criptografiaFinal, str1, str2, tamanho, qtd1, qtd2);
  imprimirResultado(criptografiaFinal, tamanho);
  return 0;
}