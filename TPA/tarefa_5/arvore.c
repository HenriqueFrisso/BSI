#include "TAD_ARVORE.h"

/*
 Aluno: Henrique Frisso Oliveira e Alexsander Benica
 Tarefa 05
*/

int main(void) {
    TNo* raiz = NULL;
    menu(&raiz); 
    return 0;
}

void lerArquivo(TNo** raiz, string arquivo) {
    FILE *file = fopen(arquivo, "r");
    if (file == NULL) {
        printf("Erro ao abrir o arquivo!\n");
        return;
    }
    printf("\naaa\n");
    long long int matricula;
    string nome;

    while (fscanf(file, "%[^\n]s", nome) != EOF) {
        fscanf(file, "%lld", &matricula);
        *raiz = inserir(*raiz, matricula, nome);
    }

    fclose(file);
}

TNo* criarNo(long long int matricula, char nome[]) {
    TNo* novoNo = (TNo*) malloc(sizeof(TNo));
    if (novoNo != NULL) {
        novoNo->aluno.matricula = matricula;
        strcpy(novoNo->aluno.nome, nome);
        novoNo->esquerda = NULL;
        novoNo->direita = NULL;
    }
    return novoNo;
}

TNo* inserir(TNo* raiz, long long int matricula, char nome[]) {
    if (raiz == NULL) {
        return criarNo(matricula, nome);
    }
    if (matricula < raiz->aluno.matricula) {
        raiz->esquerda = inserir(raiz->esquerda, matricula, nome);
    } else if (matricula > raiz->aluno.matricula) {
        raiz->direita = inserir(raiz->direita, matricula, nome);
    }
    return raiz;
}

TNo* buscar(TNo* raiz, long long int matricula) {
    if (raiz == NULL || raiz->aluno.matricula == matricula) {
        return raiz;
    }
    if (matricula < raiz->aluno.matricula) {
        return buscar(raiz->esquerda, matricula);
    } else {
        return buscar(raiz->direita, matricula);
    }
}
TNo* menorValor(TNo* raiz) {
    TNo* atual = raiz;

    while (atual != NULL && atual->esquerda != NULL) {
        atual = atual->esquerda;
    }

    return atual;
}
TNo* remover(TNo* raiz, long long int matricula) {
    if (raiz == NULL) {
        return raiz;
    }
    if (matricula < raiz->aluno.matricula) {
        raiz->esquerda = remover(raiz->esquerda, matricula);
    } else if (matricula > raiz->aluno.matricula) {
        raiz->direita = remover(raiz->direita, matricula);
    } else {
        if (raiz->esquerda == NULL) {
            TNo* temp = raiz->direita;
            free(raiz);
            return temp;
        } else if (raiz->direita == NULL) {
            TNo* temp = raiz->esquerda;
            free(raiz);
            return temp;
        }
        TNo* temp = menorValor(raiz->direita);
        raiz->aluno.matricula = temp->aluno.matricula;
        strcpy(raiz->aluno.nome, temp->aluno.nome);
        raiz->direita = remover(raiz->direita, temp->aluno.matricula);
    }
    return raiz;
}

void salvarEmArquivo(TNo* raiz, FILE *file) {
    if (raiz != NULL) {
        fprintf(file, "%lld %s\n", raiz->aluno.matricula, raiz->aluno.nome);
        salvarEmArquivo(raiz->esquerda, file);
        salvarEmArquivo(raiz->direita, file);
    }
}

void imprimirPreOrdem(TNo* raiz) {
    if (raiz != NULL) {
        printf("%lld %s\n", raiz->aluno.matricula, raiz->aluno.nome);
        imprimirPreOrdem(raiz->esquerda);
        imprimirPreOrdem(raiz->direita);
    }
}
void imprimirEmOrdem(TNo* raiz) {
    if (raiz != NULL) {
        imprimirEmOrdem(raiz->esquerda);
        printf("%lld %s\n", raiz->aluno.matricula, raiz->aluno.nome);
        imprimirEmOrdem(raiz->direita);
    }
}
void imprimirPosOrdem(TNo* raiz) {
    if (raiz != NULL) {
        imprimirPosOrdem(raiz->esquerda);
        imprimirPosOrdem(raiz->direita);
        printf("%lld %s\n", raiz->aluno.matricula, raiz->aluno.nome);
    }
}

void menu(TNo **raiz) {
    int opcao;
    string arquivo;
    strcpy(arquivo, ARQUIVO);
    lerArquivo(raiz, arquivo);
    do {
        printf("\n\n-------------MENU-------------");
        printf("\nOpção 1: Inserir aluno");
        printf("\nOpção 2: Remover aluno");
        printf("\nOpção 3: Buscar aluno");
        printf("\nOpção 4: Salvar dados em arquivo");
        printf("\nOpção 5: Imprimir em Pré-Ordem");
        printf("\nOpção 6: Imprimir Em-ordem");
        printf("\nOpção 7: Imprimir em Pós-ordem");
        printf("\nDigite 0 para sair");
        printf("\n\nDigite a opção desejada: ");
        scanf("%d", &opcao);
        getchar();

        switch (opcao) {
        case 1:
            long long int matricula;
            string nome;
            printf("Digite o nome do aluno: ");
            scanf("%[^\n]s", nome);
            printf("Digite a matrícula do aluno: ");
            scanf("%lld", &matricula);
            *raiz = inserir(*raiz, matricula, nome);
            break;
        case 2: {
            long long int matricula;
            printf("Digite a matrícula do aluno para remover: ");
            scanf("%lld", &matricula);
            *raiz = remover(*raiz, matricula);
            break;
        }
        case 3: {
            long long int matricula;
            printf("Digite a matrícula do aluno para buscar: ");
            scanf("%lld", &matricula);
            TNo* aluno = buscar(*raiz, matricula);
            if (aluno != NULL) {
                printf("Aluno encontrado: %lld %s\n", aluno->aluno.matricula, aluno->aluno.nome);
            } else {
                printf("Aluno não encontrado!\n");
            }
            break;
        }
        case 4: {
            FILE *file = fopen(arquivo, "w");
            if (file != NULL) {
                salvarEmArquivo(*raiz, file);
                fclose(file);
                printf("Dados salvos com sucesso!\n");
            } else {
                printf("Erro ao salvar dados!\n");
            }
            break;
        }
        case 5:
            imprimirPreOrdem(*raiz);
            break;
        case 6:
            imprimirEmOrdem(*raiz);
            break;
        case 7:
            imprimirPosOrdem(*raiz);
            break;
        case 0:
            break;
        default:
            printf("Opção inválida!\n");
        }
    } while (opcao != 0);
}
