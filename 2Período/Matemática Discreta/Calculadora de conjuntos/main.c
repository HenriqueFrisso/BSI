#include <stdio.h>
#include <stdlib.h>

int opcoes(){ //Verifica a opção escolhida
  int op;
  do{
    printf("\n\nCALCULADORA DE CONJUNTOS\n\n");
    printf("0 - SAIR\n1 - Inserir os conjuntos A e B\n2 - A U B \n3 - A ∩ B \n4 - A – B \n5 - B – A \n6 - A ∆ B \n7 - A x B \n\nDigite a opção desejada: ");
    scanf("%d",&op);
    printf("\n");
  } while ((op<0)||(op>7));
  return op;
}

int lerElemento(int i){ //Lê os elementos do conjunto
  int e;
  printf("Digite o elemento %dº do conjunto: ",i+1);
  scanf("%d", &e);
  return e;
}

int verificarConjunto(int *vet, int qtd,int elemento){ //Verifica se há elementos repetidos no conjunto
  for (int i=0;i<qtd;i++){
    if (vet[i]==elemento){      
      return 1;
    }
  }
  return 0;
}

void organizarConjunto(int *vet, int qtd) { //Organiza os elementos de um conjunto em ordem crescente
  int menor,maior,i,h,troca;
  for (i = 0; i < qtd - 1; i++) { //Analisa cada posição e seu elemento
    menor = i;
    for (h = i + 1; h < qtd; h++) { //Verifica se algum proximo elemento do vetor é menor que o elemento analisado
      if (vet[h] < vet[menor]) {
        menor = h;
      }
    }
    if (menor != i) { //Caso tenha um elemento menor a frente do elemento analisado eles trocam de posição
      troca = vet[i];
      vet[i] = vet[menor];
      vet[menor] = troca;
    }
  }
}

void adicionarConjunto(int **vet, int *qtd){ //cria um array para armazenar o conjunto
  int elemento,verificador,i;
  scanf("%d", qtd); //Lê a quantidade de elementos do conjunto
  *vet = (int *)malloc(*qtd * sizeof(int)); //Aloca um espaço na memória com o tamanho do novo array
  for(i=0; i<*qtd;i++){ //Lê e adiciona a quantidade de elementos do conjunto
    do{
      elemento=lerElemento(i); //Lê o elemento digitado
      verificador = verificarConjunto(*vet,i,elemento); //Verifica se o elemento ja está incluido no conjunto
      if (verificador==1){
        printf("Elemento já existente no conjunto\n");
      }
    } while(verificador==1); //loop para não repetir elementos no conjunto
    (*vet)[i]=elemento; //adiciona o elemento ao conjunto
  }
}

void adicionarElemento(int vet[], int qtd, int novoElemento, int *qtdNova, int **novoVet) {
    *qtdNova = qtd + 1; //quantidades de elementos já existentes no array +1
    *novoVet = (int*)malloc(*qtdNova * sizeof(int)); //Aloca um espaço na memória com o tamanho do novo array
    for (int i = 0; i < qtd; i++) {//Passa os elementos do antigo array para o novo
        (*novoVet)[i] = vet[i];
    }
    (*novoVet)[qtd] = novoElemento; //Adiciona o novo elemento ao array
}

void imprimirConjunto(int vet[], int qtd){
  printf("{");
  for (int i=0;i<qtd;i++){
    printf("%d",vet[i]);
    if (i<(qtd-1)){
      printf(", ");
    }
  }
  printf("}");
}

void uniao(int vet1[], int vet2[], int **vet3,int qtd1,int qtd2,int *qtd3) {  //Realiza a união de dois conjuntos
  int verificador,i;
  for (i=0;i<qtd1;i++){ //Adiciona todos os elementos do conjunto A ao novo conjunto
    adicionarElemento(*vet3, *qtd3,vet1[i],qtd3,vet3);
  }
  for (i=0;i<qtd2;i++){ //Adiciona ao novo conjunto os elementos de B que não estão contidos em A
    verificador = verificarConjunto(*vet3,*qtd3,vet2[i]);
    if (verificador==0){
      adicionarElemento(*vet3, *qtd3,vet2[i],qtd3,vet3);
    }
  }
}
void intersecao(int vet1[], int vet2[], int **vet3,int qtd1,int qtd2,int *qtd3){  //Realiza a Interseção de dois conjuntos
  int verificador,e1,e2,i,h;
  for (i=0;i<qtd1;i++){ //compara cada elemento do conjunto A com cada elemento do conjunto B
    e1=vet1[i];
    for (h=0;h<qtd2;h++){
      e2=vet2[h];
      if (e1==e2){ //Quando ambos os conjuntos possuem um elemento ele é adicionado ao novo conjunto
        adicionarElemento(*vet3, *qtd3,e1,qtd3,vet3);
      }
    }
  }
}
void diferenca(int vet1[], int vet2[], int **vet3,int qtd1,int qtd2,int *qtd3){  //Realiza a Diferença de dois conjuntos
  int verificador,e1,e2,i,h;
  for (i=0;i<qtd1;i++){ //compara cada elemento do conjunto A com cada elemento do conjunto B
    e1=vet1[i];
    verificador=0; //Verificador para saber se o element de um conjunto está contido no outro
    for (h=0;h<qtd2;h++){
      e2=vet2[h];
      if(e1==e2){ //O elemento está contido nos dois conjuntos
        verificador=1;
      }
    }
    if (verificador==0){ //Quando um elemento contido no primeiro conjunto não está contido no outro conjunto ele é adicionado ao novo conjunto
      adicionarElemento(*vet3, *qtd3,e1,qtd3,vet3);
    }
  }
}
void diferencaSimetrica(int vet1[], int vet2[], int **vet3,int qtd1,int qtd2,int *qtd3){ //Realiza a Diferença Simetrica de dois conjuntos
  int verificador,e1,e2,i,h;
  for (i=0;i<qtd1;i++){ //compara cada elemento do conjunto A com cada elemento do conjunto B
    e1=vet1[i];
    for (h=0;h<qtd2;h++){
      e2=vet2[h];
      if (e1==e2){ //Verifica se o elemento está contido nos dois conjuntos
        verificador=1;
      }
    }
    if (verificador==0){ //Quando um elemento contido no primeiro conjunto não está contido no outro conjunto ele é adicionado ao novo conjunto
      adicionarElemento(*vet3, *qtd3,e1,qtd3,vet3);
    }verificador=0;
  }
  for (i=0;i<qtd2;i++){ //compara cada elemento do conjunto A com cada elemento do conjunto B
    e1=vet2[i];
    for (h=0;h<qtd1;h++){
      e2=vet1[h];
      if (e1==e2){ //Verifica se o elemento está contido nos dois conjuntos
        verificador=1;
      }
    }
    if (verificador==0){ //Quando um elemento contido no primeiro conjunto não está contido no outro conjunto ele é adicionado ao novo conjunto
      adicionarElemento(*vet3, *qtd3,e1,qtd3,vet3);
    }verificador=0;
  }
}
void produtoCartesiano(int vet1[], int vet2[], int **vet3,int qtd1,int qtd2,int *qtd3){
  int e1,e2,i,h;
  for (i=0;i<qtd1;i++){ //percorre o conjunto A
    e1=vet1[i];
    for (h=0;h<qtd2;h++){ //percorre o conjunto B
      e2=vet2[h];
      adicionarElemento(*vet3, *qtd3,e1,qtd3,vet3); //Adiciona os elementos do conjunto A e B para printar em duplas
      adicionarElemento(*vet3, *qtd3,e2,qtd3,vet3);
    }
  }
}

int main(void){
  int i,op, qtd1,qtd2,qtd3;
  int *vet1=NULL;
  int *vet2=NULL;
  int *vet3=NULL;
  do{
    op=opcoes();
    switch(op){
      case (1): //Opção 1 - Inserir os conjuntos A e B
        free(vet1); //Libera o espaço de memória que estava sendo utilizado para alocar outro endereço de memória par aos vetores
        free(vet2);
        printf("Digite a quantidade de elementos do conjunto A: ");
        adicionarConjunto(&vet1,&qtd1);
        printf("Digite a quantidade de elementos do conjunto B: ");
        adicionarConjunto(&vet2,&qtd2);
        organizarConjunto(vet1, qtd1);
        organizarConjunto(vet2, qtd2);
      break;
      
      case(2): //opção 2 - A U B
        uniao(vet1,vet2,&vet3,qtd1,qtd2,&qtd3);
        organizarConjunto(vet3, qtd3);
        printf("A união dos conjuntos A=");
        imprimirConjunto(vet1,qtd1);
        printf(" e B=");
        imprimirConjunto(vet2,qtd2);
        printf(" tem como resultado o conjunto A U B=");
        imprimirConjunto(vet3,qtd3);
      break;
      
      case(3): //opção 3 - A ∩ B
        intersecao(vet1,vet2,&vet3,qtd1,qtd2,&qtd3);
        printf("A interseção dos conjuntos A=");
        imprimirConjunto(vet1,qtd1);
        printf(" e B=");
        imprimirConjunto(vet2,qtd2);
        printf(" tem como resultado o conjunto A ∩ B=");
        imprimirConjunto(vet3,qtd3);
      break;
      
      case(4): //opção 4 - A – B
        diferenca(vet1,vet2,&vet3,qtd1,qtd2,&qtd3);
        printf("A diferença dos conjuntos A=");
        imprimirConjunto(vet1,qtd1);
        printf(" e B=");
        imprimirConjunto(vet2,qtd2);
        printf(" tem como resultado o conjunto A – B=");
        imprimirConjunto(vet3,qtd3);
      break;
      
      case(5): //opção 5 - B – A 
        diferenca(vet2,vet1,&vet3,qtd2,qtd1,&qtd3);
        printf("A diferença dos conjuntos B=");
        imprimirConjunto(vet1,qtd1);
        printf(" e A=");
        imprimirConjunto(vet2,qtd2);
        printf(" tem como resultado o conjunto B – A=");
        imprimirConjunto(vet3,qtd3);
      break;
      
      case(6): //opção 6 - A ∆ B
        diferencaSimetrica(vet1,vet2,&vet3,qtd1,qtd2,&qtd3);
        organizarConjunto(vet3, qtd3);
        printf("A diferença simétrica dos conjuntos A=");
        imprimirConjunto(vet1,qtd1);
        printf(" e B=");
        imprimirConjunto(vet2,qtd2);
        printf(" tem como resultado o conjunto A – B=");
        imprimirConjunto(vet3,qtd3);
      break;
      
      case(7): //opção 7 - A x B
        produtoCartesiano(vet1,vet2,&vet3,qtd1,qtd2,&qtd3);
        printf("O produto cartesiano dos conjuntos A=");
        imprimirConjunto(vet1,qtd1);
        printf(" e B=");
        imprimirConjunto(vet2,qtd2);
        printf(" tem como resultado o conjunto A x B={");
        for (i=0;i<qtd3;i+=2){
          printf("(%d.%d)",vet3[i],vet3[i+1]);
          if (i<(qtd3-2)){
            printf(", ");
          }
        }printf("}");
      break;
      defalt:
      break;
    }
    free(vet3); //desaloca um espaço na memória para criar um novo array com o conjunto da operação escolhida
    vet3 = NULL;
    qtd3 = 0;
  }while(op!=0);
  
  free(vet1);
  free(vet2);
  free(vet3);
  return 0;
}