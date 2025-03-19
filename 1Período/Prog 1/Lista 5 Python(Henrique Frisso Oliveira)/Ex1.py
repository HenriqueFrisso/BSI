"""
Nome: Henrique Frisso Oliveira
Turma: V06
Exercicio 1
Utilize a função abaixo para gerar 50 números aleatórios entre 1 e 100 (min=1 e max=100)
e armazene em um vetor. Faça outra função para percorrer esse vetor e contar a
quantidade de números pares e ímpares que foram gerados. Mostre essas quantidades na
tela.

import random
# Gerar um número aleatório entre MIN a MAX
def gerarNumAleatorio(min,max):
    return random.randint(min,max)

"""

import random
# Gerar um número aleatório entre MIN a MAX
def gerarNumAleatorio(min,max):
    return random.randint(min,max)

def armazenarNumeros(vetor):
    for h in range (50):
        vetor.append(gerarNumAleatorio(1,100))
    
def percorrerVetor(vetor):
    par = 0
    impar = 0
    for h in range (len(vetor)):
        if (vetor[h]%2)==0:
            par+=1
        else:
            impar+=1
    return par,impar

def main():
    vetNumeros=[]
    armazenarNumeros(vetNumeros)
    par,impar = percorrerVetor(vetNumeros)
    print ("A quantidade de números pares é de: %d" %par)
    print ("A quantidade de números impares é de: %d" %impar)

main()
