"""
Nome: Henrique Frisso Oliveira
Turma: V06
Exercicio 6
Um posto está vendendo combustíveis com a seguinte tabela de descontos:
 Álcool:
    a. até 20 litros, desconto de 3% por litro.
    b. acima de 20 litros, desconto de 5% por litro.
 Gasolina:
    a. até 20 litros, desconto de 4% por litro.
    b. acima de 20 litros, desconto de 6% por litro
Escreva um programa que leia o número de litros vendidos, o tipo de combustível
(codificado da seguinte forma: A­álcool, G­gasolina), calcule e imprima o valor a ser pago
pelo cliente sabendo­se que o preço do litro da gasolina é R$ 3,90 e o preço do litro do
álcool é R$ 3,20
"""

qtd = int(input("Digite a quantidade de litros: "))
tipo = str(input("Digite o tipo de combustivel, utilize A para álcool e G para gasolina: ")).upper()

if (tipo == "A"):
    if (qtd > 20):
        desconto = float((3.2*qtd)*(5/100))
        valor = float(3.2*qtd - desconto)
    else:
        desconto = float((3.2*qtd)*(3/100))
        valor = float(3.2*qtd - desconto)
    print("O valor a ser pago é de: %.2f" %valor)
elif (tipo == "G"):
    if (qtd > 20):
        desconto = float((3.9*qtd)*(6/100))
        valor = float(3.9*qtd - desconto)
    else:
        desconto = float((3.9*qtd)*(4/100))
        valor = float(3.9*qtd - desconto)
    print("O valor a ser pago é de: %.2f" %valor)
else:
    print ("Tipo invalido")

