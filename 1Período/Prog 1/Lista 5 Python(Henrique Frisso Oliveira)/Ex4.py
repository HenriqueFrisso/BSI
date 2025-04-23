"""
Nome: Henrique Frisso Oliveira
Turma: V06
Exercicio 4
Utilize a função criada nos exercícios anteriores para gerar agora um vetor com 100
números aleatórios. Faça uma função que receba como parâmetro esse vetor e dois
índices (início e fim) e retorne a soma dos números apenas do intervalo entre os índices
[início, fim]. Lembre-se de fazer a validação: início >= 0, fim < 100 e início <= fim.
"""

import random
# Gerar um número aleatório entre MIN a MAX
def gerarNumAleatorio(min,max):
    return random.randint(min,max)

def armazenarNumeros(vetor,qtd,min,max):
    for h in range (qtd):
        vetor.append(gerarNumAleatorio(min,max))
    
def percorrerVetor(vetNum,min,max):
    soma = 0
    for h in range (len(vetNum)):
        if (vetNum[h]>=min) and (vetNum[h]<=max):
            soma += vetNum[h]
    return soma
        
def imprimir(vetor):
    for h in range(len(vetor)):
        print (vetor[h], end=" ")

def verificarIntervalo():
    verificador = False
    while verificador == False:
        min=int(input("Digite o valor minimo do intervalo: "))
        if (min<0) or (min>100):
            min=int(input("Digite o valor minimo (entre 0 e 100): "))
        max=int(input("Digite o valor maximo do intervalo: "))
        if (max<0) or (max>100):
            max=int(input("Digite o valor maximo (entre 0 e 100): "))
        if min<max:
            verificador = True
        else:
            print ("Invalido!")
    return min,max

def main():
    vetNumeros=[]
    armazenarNumeros(vetNumeros,100,1,100)
    min,max = verificarIntervalo()
    soma = percorrerVetor(vetNumeros,min,max)
    print ("Os números do vetor foram: ",end ="")
    imprimir(vetNumeros)
    print ("\nA soma dos números dentro do intervalo (%d,%d) é: %d" %(min,max,soma))
main()

