"""
Nome: Henrique Frisso Oliveira
Turma V06
Exercício 4
Faça um programa que calcule o aumento de um salário. Ele deve solicitar o valor do 
salário e a porcentagem do aumento. Exiba o valor do aumento e do novo salário.
"""

salario = float(input("Digite seu salário: R$ "))
aumento = float(input("Digite a porcentagem do aumento: "))
aumento = salario * (aumento/100)
salario = salario + aumento
print ("O valor do aumento foi de R$%.2f e o novo salário é de R$%.2f" %(aumento, salario))
