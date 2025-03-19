"""
Nome: Henrique Frisso Oliveira
Turma V06
Exercício 3
Escreva um programa que leia a quantidade de dias, horas, minutos e segundos do 
usuário. Calcule o total em segundos.
"""

dias = int(input("Digite a quantidade de dias: "))
horas = int(input("Digite a quantidade de horas: "))
minutos = int(input("Digite a quantidade de minutos: "))
segundos = int(input("Digite a quantidade de segundos: "))

total = segundos+(minutos*60)+(horas*60*60)+(dias*60*60*24)

print ("A quantidade total de segundos é: %d" %total)
