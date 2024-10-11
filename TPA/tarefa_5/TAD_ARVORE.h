#ifndef TAD_ARVORE
#define TAD_ARVORE

/*
 Aluno: Henrique Frisso Oliveira e Alexsander Benica
 Tarefa 05
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

typedef char string[100];

typedef struct ELEMENTO {
    string nome;
    long long int matricula;
} TElemento;

typedef struct NO {
    TElemento aluno;
    struct NO *esquerda;
    struct NO *direita;
} TNo;

void lerArquivo(TNo **raiz, string arquivo);
TNo* criarNo(long long int matricula, char nome[]);
TNo* inserir(TNo* raiz, long long int matricula, char nome[]);
TNo* buscar(TNo* raiz, long long int matricula);
TNo* remover(TNo* raiz, long long int matricula);
void salvarEmArquivo(TNo* raiz, FILE *file);
void imprimirPreOrdem(TNo* raiz);
void imprimirEmOrdem(TNo* raiz);
void imprimirPosOrdem(TNo* raiz);
void menu(TNo **raiz);
TNo* menorValor(TNo* raiz);

const string ARQUIVO = "lista_matricula.txt";

#endif
