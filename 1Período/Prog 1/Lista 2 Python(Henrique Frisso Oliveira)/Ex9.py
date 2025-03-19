"""
Nome: Henrique Frisso Oliveira
Turma: V06
Exercicio 9
Faça um programa que receba o código e a quantidade de um produto comprado. Calcule
e mostre:
 O preço unitário do produto comprado, conforme Tabela 1;
 O valor total da nota;
 O valor de desconto, conforme Tabela 2, e aplicado sobre o valor total;
 O valor total depois do desconto

TABELA 1
Código Preço
1 a 10 R$ 10,00
11 a 20 R$ 15,00
21 a 30 R$ 20,00
31 a 40 R$ 30,0

TABELA 2
Valor total (R$) Desconto
Até 250 5%
Entre 250,00 e 500 10%
De 500
"""

cod = int(input("Digite o código: "))
qtd = int(input("Digite a quantidade: "))

if (cod<1 or cod>40 or qtd<1):
    print ("Informações inválidas")
else:
    if (cod<11):
        valorU = 10
        valorT = valorU*qtd
    elif (cod<21):
        valorU = 15
        valorT = valorU*qtd
    elif (cod<31):
        valorU = 20
        valorT = valorU*qtd
    else:
        valorU = 30
        valorT = valorU*qtd
    print("O Preço unitário do produto é de R$%.2f\nO Valor total da nota é de: R$%.2f" %(valorU,valorT))
    if (valorT<=250):
        desconto = valorT*(5/100)
        valorT = valorT-desconto
    elif (valorT<500):
        desconto = valorT*(10/100)
        valorT = valorT-desconto
    else:
        desconto = valorT*(15/100)
        valorT = valorT-desconto
    print("O valor do desconto foi de R$%.2f\nO valor total com desconto é de: R$%.2f" %(desconto,valorT))
