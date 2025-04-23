"""
Nome: Henrique Frisso Oliveira
Turma V06
Exercício 9
Escreva um programa que pergunte a quantidade de km percorridos por um carro alugado 
pelo usuário, assim como a quantidade de dias pelos quais o carro foi alugado. Calcule o 
preço a pagar, sabendo que o carro custa R$ 60,00 por dia e R$ 0,15 por km rodado.
"""

distancia = int(input("digite a quantidade de Km que foram percorridos: "))
dia = int(input("Digite a quantidade de dias que o carro foi alugado: "))
preco = dia*60 + 0.15*distancia
print ("O preço total a pagar é de: R$%.2f" %preco)
