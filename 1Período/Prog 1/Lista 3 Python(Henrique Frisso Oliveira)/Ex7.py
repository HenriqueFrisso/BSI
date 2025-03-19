"""
Nome: Henrique Frisso Oliveira
Turma: V06
Exercicio 7
A sequência de Fibonacci é a seguinte: 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, ... Sua regra de
formação é simples: os dois primeiros elementos são 1; a partir de então, cada
elemento é a soma dos dois anteriores. Faça um algoritmo que leia um número inteiro
e calcule a sequência de Fibonacci. Por exemplo, se o usuário informar o número 10,
então mostrar os 10 primeiros números da sequência.
"""
n1,n2,n = 1,1,int(input("Digite um número: "))
while (n>0):
    if (n1<n2):
        print(n1)
        n1 = n1+n2
    else:
        print(n2)
        n2 = n1+n2
    n-=1
