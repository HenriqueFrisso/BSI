"""
Nome: Henrique Frisso Oliveira
Turma: V06
Exercicio 3
Faça um programa que gere dois vetores com 20 números aleatórios em cada (utilize a
função implementada nos exercícios anteriores). Faça uma função que gere um terceiro
vetor de 40 elementos, cujos valores deverão ser compostos pelos elementos intercalados
dos dois outros vetores (essa função receberá os três vetores como parâmetros). Imprima
os três vetores (faça somente uma função imprimir e chame-a três vezes).
"""

import random
# Gerar um número aleatório entre MIN a MAX
def gerarNumAleatorio(min,max):
    return random.randint(min,max)

def armazenarNumeros(vetor,qtd,min,max):
    for h in range (qtd):
        vetor.append(gerarNumAleatorio(min,max))
    
def percorrerVetor(vet1,vet2,vetNum):
    for h in range (20):
        vetNum.append(vet1[h])
        vetNum.append(vet2[h])
        
def imprimir(vetor):
    for h in range(len(vetor)):
        print (vetor[h], end=" ")
        
def main():
    vetNumeros1=[]
    vetNumeros2=[]
    vetNumeros3=[]
    armazenarNumeros(vetNumeros1,20,1,100)
    armazenarNumeros(vetNumeros2,20,1,100)
    percorrerVetor(vetNumeros1,vetNumeros2,vetNumeros3)
    print ("Os números sorteados no primeiro vetor foram:", end=" ")
    imprimir(vetNumeros1)
    print ("\n\nOs números sorteados no segundo vetor foram:", end=" ")
    imprimir(vetNumeros2)
    print ("\n\nOs números intercalados são:", end=" ")
    imprimir(vetNumeros3)

main()
