"""
Nome: Henrique Frisso Oliveira
Turma: V06
Exercicio 4
Faça um programa, usando funções, para imprimir:
 1
 1 2
 1 2 3
 .....
 1 2 3 4 ... n
para um n informado pelo usuário. Use uma função para ler e validar o valor n (inteiro e
positivo), uma função para imprimir apenas uma linha e outra função para imprimir até a nésima linha, ou seja, chamar a função “imprimir linha” n vezes.
"""
def validarNumero():
    n = int(input("Digite um número: "))
    while (n < 0):
        n = int(input("Digite um número inteiro e positivo: "))
    return (n)

def imprimirLinha(n):
    for h in range(1,(n+1)):
        print (" %d" %h, end="")
        
def imprimir(n):
    for h in range (1,(n+1)):
        imprimirLinha(h)
        print ("")
        
def main():
    n = validarNumero()
    imprimir(n)
    
main()
