"""
Nome: Henrique Frisso Oliveira
Turma: V06
Exercicio 2
Utilize a função acima para gerar 50 números aleatórios entre 1 e 100 (min=1 e max=100)
e armazene em um vetor. Faça outra função que percorra esse vetor e coloque os
números pares em um vetor chamado pares e os números ímpares em outro vetor
chamado ímpares (essa função receberá três vetores como parâmetros: o principal com
todos os números, o vetor de pares e o vetor de ímpares). Imprima os três vetores.
DICA: Você só precisará de uma função imprimir. Chame ela três vezes, uma vez para
cada vetor.
"""

import random
# Gerar um número aleatório entre MIN a MAX
def gerarNumAleatorio(min,max):
    return random.randint(min,max)

def armazenarNumeros(vetor):
    for h in range (50):
        vetor.append(gerarNumAleatorio(1,100))
    
def percorrerVetor(vetNum,vetPar,vetImpar):
    for h in range (len(vetNum)):
        if (vetNum[h]%2)==0:
            vetPar.append(vetNum[h])
        else:
            vetImpar.append(vetNum[h])

def imprimir(vetor):
    for h in range(len(vetor)):
        print (vetor[h], end=" ")
        
def main():
    vetNumeros=[]
    vetPares=[]
    vetImpares=[]
    armazenarNumeros(vetNumeros)
    percorrerVetor(vetNumeros,vetPares,vetImpares)
    print ("Os números sorteados foram:", end=" ")
    imprimir(vetNumeros)
    print ("\n\nOs números pares são:", end=" ")
    imprimir(vetPares)
    print ("\n\nOs números pares são:", end=" ")
    imprimir(vetImpares)

main()
