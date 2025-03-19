"""
Nome: Henrique Frisso Oliveira
Turma: V06
Exercicio 3
Faça um programa, usando funções, para imprimir:
 1
 2 2
 3 3 3
 .....
 n n n n n n ... n
para um n informado pelo usuário. Use uma função para ler e validar o valor n (inteiro e
positivo), uma função para imprimir apenas uma linha e outra função para imprimir até a nésima linha, ou seja, chamar a função “imprimir linha” n vezes.
"""
def validarNumero():
    n = int(input("Digite um número: "))
    while (n < 0):
        n = int(input("Digite um número inteiro e positivo: "))
    return (n)

def imprimirLinha(n):
    for h in range(n):
        print (" %d" %n, end="")
        
def imprimir(n):
    for h in range (1,(n+1)):
        imprimirLinha(h)
        print ("")
        
def main():
    n = validarNumero()
    imprimir(n)
    
main()
