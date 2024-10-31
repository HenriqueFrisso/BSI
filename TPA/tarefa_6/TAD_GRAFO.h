#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_NOME 50

/*
Alunos: Alexsander, Henrique
*/

typedef struct Vizinho {
    char nome[MAX_NOME];
    int distancia;
    struct Vizinho *prox;
} Vizinho;

typedef struct Cidade {
    char nome[MAX_NOME];
    Vizinho *vizinhos;
    struct Cidade *prox;
} Cidade;

typedef struct Grafo {
    Cidade *cidades;
} Grafo;


Grafo* criarGrafo();
Cidade* criarCidade(char *nome);
Vizinho* criarVizinho(char *nome, int distancia);
Cidade* buscarCidade(Grafo *grafo, char *nome);
void inserirCidade(Grafo *grafo, char *nome, char *vizinhoNome, int distancia);
void removerCidade(Grafo *grafo, char *nome);
void imprimirCidade(Grafo *grafo, char *nome);
void imprimirGrafo(Grafo *grafo);
void lerArquivo(Grafo *grafo, const char *nomeArquivo);
void menu(Grafo *grafo);
int main();