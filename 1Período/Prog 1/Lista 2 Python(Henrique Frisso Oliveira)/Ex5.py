"""
Nome: Henrique Frisso Oliveira
Turma: V06
Exercicio 5
Faça um Programa que leia três números e mostre o maior, o menor e mostre‐os em
ordem decrescente.
"""

n1 = int(input("Digite o primeiro numero: "))
n2 = int(input("Digite o segundo numero: "))
n3 = int(input("Digite o terceiro numero: "))

if (n1>=n2 and n1>=n3):
    maior = n1
    if(n2>=n3):
        menor = n3
        meio = n2
    else:
        menor = n2
        meio = n3
elif(n2>=n1 and n2>=n3):
    maior = n2
    if(n1>=n3):
        menor = n3
        meio = n1
    else:
        menor = n1
        meio = n3
elif(n3>=n1 and n3>=n2):
    maior = n3
    if(n1>=n2):
        menor = n2
        meio = n1
    else:
        menor = n1
        meio = n2
print ("O maior número é: %d" %maior)
print ("O menor número é: %d" %menor)
print ("A ordem decrescente dos numeros é: %d, %d, %d" %(maior,meio,menor))
