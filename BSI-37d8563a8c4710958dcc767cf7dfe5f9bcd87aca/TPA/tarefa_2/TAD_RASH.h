#ifndef TAD_RASH
#define TAD_RASH

/*
Aluno: Henrique Frisso Oliveira e Jõao Carlos Xavier
Tarefa 02
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

typedef char string[100];


typedef struct ELEMENTO {
  string nome;
  long int matricula;
  struct ELEMENTO *prox;
} TElemento;

typedef struct LISTA {
  struct ELEMENTO *prim;
  struct ELEMENTO *fim;
  int total;
} TLista;


TElemento *lerElemento();
long int lerMatricula();
TElemento *criarElemento(string nome, long int matricula);

int encontrarPosicao(long int matricula, int total);
int buscarElemento(TLista *lista, long int valor);
void buscarMatricula(TLista *lista[]);
void inserirLista(TLista *lista, TElemento *elemento);
void inserir(TLista *lista[], TElemento *elemento);
void remover(TLista *lista[], TElemento *elemento);

int lerTamanhoArquivo(string nome);
void lerArquivo(TLista *lista[], string nome);
void salvarArquivo(string nomeArquivo, TLista *lista[], int tam);

void alocarMemoria(TLista *lista[], int tam);

int menuOrdenacao();
void menu(TLista *lista[]);

void imprimir(TLista *lista[], int tam);
void total(TLista *lista[], int tam);

int tamanhoVetor();
int calcularPrimo(int num);

int numeroAleatorio(int n1, int n2);

string ARQUIVO = "lista_matricula.txt";
int TAM = 8;
int ORDENACAO = 0;
double A = 0;

#endif