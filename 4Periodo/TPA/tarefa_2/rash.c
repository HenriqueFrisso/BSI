#include "TAD_RASH.h"

/*
Aluno: Henrique Frisso Oliveira e Jõao Carlos Xavier
Tarefa 02
*/

int main(void){
  
  srand(time(NULL));
  
  double aux = tamanhoVetor();
  TAM = calcularPrimo((lerTamanhoArquivo(ARQUIVO)/2)*(aux/100));
  A = numeroAleatorio(1,999);
  TLista *lista[TAM];
  ORDENACAO = menuOrdenacao();
  alocarMemoria(lista, TAM);
  menu(lista);
  return 0;
}

int numeroAleatorio(int n1,int n2){
  int n = rand() % (n2 - n1);

  return n;
}
int tamanhoVetor(){
  int i, status;
  char p = '%';
  printf("Opções de tamanho para o vetor:\n1 para 100%c\n2 para 120%c\n3 para 150%c\nDigite a opção desejada: ", p, p, p);
  do{
    status = scanf("%d", &i);
    if (status == 0 || i>3 || i<1){
      printf("Opção invalida!!\nDigite uma opção válida: ");
    }
  } while (status == 0 || i>3 || i<1);
  if (i == 1){
    return 100;
  } else if(i == 2){
    return 120;
  } else{
    return 150;
  }
}
int calcularPrimo(int num){
  int i, aux, resto, primo = num+1;
  do{
    aux = 0;
    for(i=1; i<=primo; i++){
      resto = primo % i;
      if(resto == 0){
        aux+=1;
      }
    }
    if (aux>2){primo +=1;}
  }while(aux>2);
  return primo;
}//Funcionando

void inserirLista(TLista *lista, TElemento *elemento) { //Insere um elemento na lista
  if (buscarElemento(lista, elemento->matricula) == 1) { // Verifica se já existe
    return;
  }
  TElemento *aux;
  if (lista->total == 0) {//Primeiro Elemento
    lista->prim = elemento;
    lista->fim = elemento;
  } else if (lista->prim->matricula > elemento->matricula) {//Menor elemento
    elemento->prox = lista->prim;
    lista->prim = elemento;
  } else if (lista->fim->matricula < elemento->matricula) {//Maior elemento
    lista->fim->prox = elemento;
    lista->fim = elemento;
  } else {//Insere na lista
    aux = lista->prim;
    while (aux->prox->matricula < elemento->matricula) { // Procura a posição
      aux = aux->prox;
    }
    elemento->prox = aux->prox;
    aux->prox = elemento;
  }
  lista->total += 1;
}//Funcionando
void lerArquivo(TLista *lista[], string nome){ //Lê e cadastra os alunos de um arquivo
  FILE *arq;
  string auxS;
  long int aux;
  int tam = lerTamanhoArquivo(ARQUIVO);
  TElemento *elemento;
  arq = fopen(nome, "r");
  if(arq == NULL){
    printf("\n\nErro, não foi possivel abrir o arquivo\n\n");
  }else{
    int i = 0;
    while(i < tam){
      fscanf(arq, "%[^\n]s", auxS);
      fscanf(arq, "%ld", &aux);
      elemento = criarElemento(auxS, aux);
      int pos = encontrarPosicao(elemento->matricula, TAM);
      inserirLista(lista[pos], elemento);
      i++;
    }
  }
} //Funcionando
void alocarMemoria(TLista *lista[], int tam){ //Aloca memória para cada lista do vetor
  for (int i=0; i<tam; i++){
    lista[i] = (TLista *)malloc(sizeof(TLista));
    lista[i]->prim = NULL;
    lista[i]->fim = NULL;
    lista[i]->total = 0;
  }
}//Funcionando
void imprimir(TLista *lista[],int tam) { //Imprime na tela os alunos cadastrados
  TElemento *aux = (TElemento *)malloc(sizeof(TElemento));
  TElemento *aux2 = (TElemento *)malloc(sizeof(TElemento));
  TLista *auxLista = (TLista *)malloc(sizeof(TLista));
  auxLista->prim = NULL;
  auxLista->fim = NULL;
  auxLista->total = 0;
  int i = 1;
  int iv;
  printf("\n\nOs alunos cadastrados são:\n\n");
  /*
  for (iv = 0; iv < tam; iv++){
    aux = lista[iv]->prim;
    while (aux != NULL) {
      aux2 = criarElemento(aux->nome, aux->matricula);
      inserirLista(auxLista, aux2);
      aux = aux->prox;
    }
  }
  aux = auxLista->prim;
  while (aux != NULL) {
    printf("\nAluno (%d)\nNome: %s\nMatrícula: %ld\n", i++, aux->nome,aux->matricula);
    aux = aux->prox;
  }
  */
  for (iv = 0; iv < tam; iv++){
    printf("\n---------------------\nVetor %d\n", iv);
    aux = lista[iv]->prim;
    while (aux != NULL) {
      printf("\nAluno (%d)\nNome: %s\nMatrícula: %ld\n", i++, aux->nome,aux->matricula);
      aux = aux->prox;
    }
  }
}//Funcionando
int lerTamanhoArquivo(string nome){ //Lê o tamanho do arquivo
  FILE *arq;
  long int aux;
  string auxS;
  int total=0;
  arq = fopen(nome, "r"); // Abre o arquivo
  if (arq == NULL) {             // Tratamento de erro ao abrir arquivo
    printf("\n\nErro, não foi possivel abrir o arquivo\n\n");
  }
  while (fgets(auxS, 256, arq) != NULL) {
    total+=1;
  } 
  fclose(arq);
  return total;
}//Funcionando
TElemento *lerElemento() { //Lê nome e matricula e returna um elemento
  TElemento *novoElemento = (TElemento *)malloc(sizeof(TElemento));
  long int aux;
  string auxS;
  int status;

  printf("\nDigite o nome do aluno: ");
  scanf("%[^\n]s", auxS);
  while (getchar()!='\n');

  aux = lerMatricula();

  return criarElemento(auxS, aux);
}//Funcionando
TElemento *criarElemento(string nome, long int matricula){ //Recebe nome e matricula e retorna um elemento
  TElemento *novoElemento = (TElemento *)malloc(sizeof(TElemento));

  strcpy(novoElemento->nome, nome);
  novoElemento->matricula = matricula;
  novoElemento->prox = NULL;

  return novoElemento;
}//Funcionando
int encontrarPosicao(long int matricula, int total){ //Encontra o index no vetor de listas
  int posicao;
  double aux;
  if (ORDENACAO == 1){
    posicao = matricula % total;
  }else{
    aux = matricula/A;
    aux = aux - ((int)aux);
    posicao = total*(aux);
  }
  return posicao;
}//Funcionando
int buscarElemento(TLista *lista, long int valor) { // Busca um elemento na lista, se encontra retorna 1, se não retorna 0
  TElemento *aux;
  aux = lista->prim;
  while (aux != NULL) {
    if (aux->matricula == valor) {
      return 1;
    }
    aux = aux->prox;
  }
  return 0;
}//Funcionando
void inserir(TLista *lista[], TElemento *elemento) { //Insere um elemento no vetor de listas na posição correta
  int pos = encontrarPosicao(elemento->matricula, TAM);
  if(buscarElemento(lista[encontrarPosicao(elemento->matricula, TAM)], elemento->matricula) == 1){
    printf("\nMatrícula já cadastrada!\n");
  }else{
    printf("\nMatrícula cadastrada com sucesso!\n");
  }
  inserirLista(lista[pos], elemento);
}//Funcionando
void total(TLista *lista[], int tam){ //Exibe o total de alunos cadastrados
  int total = 0;
  for(int i=0; i<tam; i++){
    total += lista[i]->total;
  }
  printf("\n\nO total de alunos cadastrados é: %d", total);
  printf("\nA quantidade de listas no vetor é: %d\n", TAM);
}//Funcionando
long int lerMatricula(){
  long int matricula; 
  int status;
  do{
    printf("\nDigite o número da matrícula: ");
    status = scanf("%ld", &matricula);
    if(status!=1){
      printf("\nErro, digite um número válido.\n");
    }
    while (getchar()!='\n');
  } while(status != 1);
  return matricula;
}//Funcionando
void remover(TLista *lista[], TElemento *elemento) {
  int i = encontrarPosicao(elemento->matricula, TAM);
  if (buscarElemento(lista[i], elemento->matricula) == 0) { // Verifica se o elemento está na lista
    printf("Nenhuma matrícula encontrada!\n");
    return;
  }
  TElemento *aux;
  if (lista[i]->total == 1) { // Unico elemento na lista
    lista[i]->prim = NULL;
    lista[i]->fim = NULL;
  } else if (lista[i]->prim->matricula == elemento->matricula) { // Primeiro elemento
    lista[i]->prim = lista[i]->prim->prox;
  } else if (lista[i]->fim->matricula == elemento->matricula) { // Ultimo elemento
    aux = lista[i]->prim;
    while (aux->prox->prox != NULL) {
      aux = aux->prox;
    }
    aux->prox = NULL;
    lista[i]->fim = aux;
  } else { // Remove um elemento
    aux = lista[i]->prim;
    while (aux->prox != elemento) {
      aux = aux->prox;
    }
    aux->prox = elemento->prox;
  }
  free(elemento);
  printf("\nMatrícula removida com sucesso!\n");
  lista[i]->total -= 1;
}//Funcionando
void buscarMatricula(TLista *lista[]){
  TElemento *auxEle = (TElemento *)malloc(sizeof(TElemento));
  int aux1;
  int aux2;
  long int matricula = lerMatricula();
  aux1 = encontrarPosicao(matricula, TAM);
  aux2 = buscarElemento(lista[aux1], matricula);
  auxEle = lista[aux1]->prim;
  for(int i=0; i<lista[aux1]->total; i++){
    if(matricula == auxEle->matricula){
      printf("\n\nAluno: %s\nMatricula: %ld\n", auxEle->nome, auxEle->matricula);
      return;
    }else{
      auxEle = auxEle->prox;
    }
  }
  printf("\nMatricula não encontrada!!\n");

}//Funcionando
void salvarArquivo(string nomeArquivo, TLista *lista[], int tam) {
  FILE *arq;
  arq = fopen(nomeArquivo, "w");
  TElemento *aux = (TElemento *)malloc(sizeof(TElemento));
  TElemento *aux2 = (TElemento *)malloc(sizeof(TElemento));
  TLista *auxLista = (TLista *)malloc(sizeof(TLista));
  auxLista->prim = NULL;
  auxLista->fim = NULL;
  auxLista->total = 0;
  int i = 1;
  int iv;
  for (iv = 0; iv < tam; iv++){
    aux = lista[iv]->prim;
    while (aux != NULL) {
      aux2 = criarElemento(aux->nome, aux->matricula);
      inserirLista(auxLista, aux2);
      aux = aux->prox;
    }
  }
  aux = auxLista->prim;
  while (aux != NULL) {
    fprintf(arq, "%s\n", aux->nome);
    fprintf(arq, "%ld\n", aux->matricula);
    aux = aux->prox;
  }
}//Funcionando

int menuOrdenacao(){
  int menu;
  do {
    printf("\n\n-------------ORDENAÇÂO-------------");
    printf("\nOpção 1: Resto da divisão");
    printf("\nOpção 2: Método da multiplicação");
    printf("\n\nDigite a opção desejada: ");
    scanf("%d", &menu);
    getchar();
    if (menu < 1 || menu > 2){
      printf("Opção inválida!!\nDigite um valor válido: ");
    }
  } while (menu < 1 || menu > 2);
  return menu;
}
void menu(TLista *lista[]) {
  clock_t t;
  int aux;
  int menu;
  int tam;
  TElemento *auxEle = (TElemento *)malloc(sizeof(TElemento));
  string str;
  strcpy(str, ARQUIVO);

  do {
    printf("\n\n-------------MENU-------------");
    printf("\nOpção 1: Ler arquivo");
    printf("\nOpção 2: Inserir Matrícula");
    printf("\nOpção 3: Remover Matrícula");
    printf("\nOpção 4: Verificar se a Matrícula existe");
    printf("\nOpção 5: Total de Matrículas cadastradas");
    printf("\nOpção 6: Exibir todas as matrículas");
    printf("\nOpção 7: Salvar arquivo");
    printf("\nDigite 0 para sair");
    printf("\n\nDigite a opção desejada: ");
    scanf("%d", &menu);
    getchar();
    switch (menu) {
    case (1):
      t = clock();
      lerArquivo(lista, ARQUIVO);
      t = clock() - t;
      printf("\n\nTempo para ler o arquivo: %.3lf segundos\n", ((double)t)/((CLOCKS_PER_SEC)));
      break;
    case (2):
      inserir(lista, lerElemento());
      break;
    case (3):
      auxEle->matricula = lerMatricula();
      remover(lista, auxEle);
      break;
    case (4):
      buscarMatricula(lista);
      break;
    case (5):
      total(lista, TAM);
      break;
    case (6):
      imprimir(lista, TAM);
      break;
    case (7):
      salvarArquivo(ARQUIVO, lista, TAM);
      break;
    case (0):
      break;
    default:
      printf("Opção inválida");
      break;
      while (getchar() != '\n');
    }
    if (menu==1){
    }
  } while (menu != 0);
}//Funcionando
