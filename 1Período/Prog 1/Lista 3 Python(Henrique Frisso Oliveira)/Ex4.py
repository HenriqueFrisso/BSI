"""
Nome: Henrique Frisso Oliveira
Turma: V06
Exercicio 4
Faça um programa para ler vários números positivos entre 1 e 1000, validar e só parar
quando o usuário digitar -1. No final imprima o maior número, a quantidade de números
pares e a quantidade de números ímpares, a média dos números pares e a média dos
números ímpares e a soma total de todos os números lidos
"""
numero = 0
maior = 0
par = 0
impar = 0
mediaPar = 0
mediaImpar = 0
total = 0
while (numero != -1):
    numero = int(input("Digite um número entre 1 e 1000, para parar dgite -1: "))
    if ((numero>0)and(numero<=1000)):
        if (numero>maior):
            maior = numero
        if (numero%2 == 0):
            par+=1
            mediaPar = mediaPar + numero
        else:
            impar+=1
            mediaImpar = mediaImpar + numero
        total = total + numero
mediaPar = mediaPar/par
mediaImpar = mediaImpar/impar

print ("O maior número digitado foi: %d\nA quantidade de números pares digitados foi: %d\nA quantidade de números impares digitados foi: %d\nA média dos números pares digitados é: %.2f\nA média dos números impares digitados foi: %.2f\nA soma total dos números digitados é: %d" %(maior,par,impar,mediaPar,mediaImpar,total))
