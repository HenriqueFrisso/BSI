#include "TAD_GRAFO.h"


Grafo* criarGrafo() {
    Grafo *grafo = (Grafo*)malloc(sizeof(Grafo));
    grafo->cidades = NULL;
    return grafo;
}

Cidade* criarCidade(char *nome) {
    Cidade *cidade = (Cidade*)malloc(sizeof(Cidade));
    strcpy(cidade->nome, nome);
    cidade->vizinhos = NULL;
    cidade->prox = NULL;
    return cidade;
}

Vizinho* criarVizinho(char *nome, int distancia) {
    Vizinho *vizinho = (Vizinho*)malloc(sizeof(Vizinho));
    strcpy(vizinho->nome, nome);
    vizinho->distancia = distancia;
    vizinho->prox = NULL;
    return vizinho;
}

Cidade* buscarCidade(Grafo *grafo, char *nome) {
    Cidade *cidade = grafo->cidades;
    while (cidade != NULL) {
        if (strcmp(cidade->nome, nome) == 0) {
            return cidade;
        }
        cidade = cidade->prox;
    }
    return NULL;
}

void inserirCidade(Grafo *grafo, char *nome, char *vizinhoNome, int distancia) {
    Cidade *cidade = buscarCidade(grafo, nome);
    if (cidade == NULL) {
        cidade = criarCidade(nome);
        cidade->prox = grafo->cidades;
        grafo->cidades = cidade;
    }

    Vizinho *vizinho = criarVizinho(vizinhoNome, distancia);
    vizinho->prox = cidade->vizinhos;
    cidade->vizinhos = vizinho;
}

void removerCidade(Grafo *grafo, char *nome) {
    Cidade *anterior = NULL, *cidade = grafo->cidades;
    while (cidade != NULL && strcmp(cidade->nome, nome) != 0) {
        anterior = cidade;
        cidade = cidade->prox;
    }
    if (cidade == NULL) return;

    if (anterior == NULL) grafo->cidades = cidade->prox;
    else anterior->prox = cidade->prox;

    Vizinho *vizinho = cidade->vizinhos;
    while (vizinho != NULL) {
        Vizinho *temp = vizinho;
        vizinho = vizinho->prox;
        free(temp);
    }
    free(cidade);
}

void imprimirCidade(Grafo *grafo, char *nome) {
    Cidade *cidade = buscarCidade(grafo, nome);
    if (cidade == NULL) {
        printf("Cidade %s não encontrada.\n", nome);
        return;
    }
    printf("Cidade: %s\n", cidade->nome);
    Vizinho *vizinho = cidade->vizinhos;
    while (vizinho != NULL) {
        printf("  Vizinhos: %s - Distância: %d\n", vizinho->nome, vizinho->distancia);
        vizinho = vizinho->prox;
    }
}

void imprimirGrafo(Grafo *grafo) {
    Cidade *cidade = grafo->cidades;
    while (cidade != NULL) {
        printf("Cidade: %s\n", cidade->nome);
        Vizinho *vizinho = cidade->vizinhos;
        while (vizinho != NULL) {
            printf("  Vizinhos: %s - Distância: %d\n", vizinho->nome, vizinho->distancia);
            vizinho = vizinho->prox;
        }
        cidade = cidade->prox;
    }
}

void lerArquivo(Grafo *grafo, const char *nomeArquivo) {
    FILE *file = fopen(nomeArquivo, "r");
    if (!file) {
        printf("Erro ao abrir o arquivo %s.\n", nomeArquivo);
        return;
    }

    char cidadeAtual[MAX_NOME];
    char vizinhoNome[MAX_NOME];
    int distancia;

    while (fscanf(file, " %[^\n]s", cidadeAtual) != EOF) {
        while (fscanf(file, "%d", &distancia) == 1) {
            fscanf(file, " %[^\n]s", vizinhoNome);
            inserirCidade(grafo, cidadeAtual, vizinhoNome, distancia);
        }
        fgetc(file);
    }

    fclose(file);
}

void menu(Grafo *grafo) {
    int opcao;
    char cidade[MAX_NOME], vizinho[MAX_NOME];
    int distancia;

    do {
        printf("\n--- Menu ---\n");
        printf("1. Inserir Cidade e Vizinho\n");
        printf("2. Remover Cidade\n");
        printf("3. Imprimir Cidade e Vizinhos\n");
        printf("4. Imprimir Todo o Grafo\n");
        printf("0. Sair\n");
        printf("Escolha uma opção: ");
        scanf("%d", &opcao);

        switch (opcao) {
            case 1:
                printf("Digite o nome da cidade: ");
                scanf(" %[^\n]s", cidade);
                printf("Digite o nome do vizinho: ");
                scanf(" %[^\n]s", vizinho);
                printf("Digite a distância para o vizinho: ");
                scanf("%d", &distancia);
                inserirCidade(grafo, cidade, vizinho, distancia);
                printf("Cidade e vizinho inseridos com sucesso!\n");
                break;

            case 2:
                printf("Digite o nome da cidade a ser removida: ");
                scanf(" %[^\n]s", cidade);
                removerCidade(grafo, cidade);
                printf("Cidade removida com sucesso!\n");
                break;

            case 3:
                printf("Digite o nome da cidade: ");
                scanf(" %[^\n]s", cidade);
                imprimirCidade(grafo, cidade);
                break;

            case 4:
                printf("Grafo completo:\n");
                imprimirGrafo(grafo);
                break;
            default:
                printf("Opção inválida! Tente novamente.\n");
                break;
        }
    } while (opcao != 0);
}

int main() {
    Grafo *grafo = criarGrafo();
    char nomeArquivo[MAX_NOME];

    lerArquivo(grafo, "cidades.txt");

    menu(grafo);

    return 0;
}
