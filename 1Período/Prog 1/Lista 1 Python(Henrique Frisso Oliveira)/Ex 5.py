"""
Nome: Henrique Frisso Oliveira
Turma V06
Exercício 5
Solicite o nome, a quantidade e o preço de um produto e o percentual de desconto. Exiba o 
nome do produto, o valor do desconto e o preço a pagar.
"""

nome = str(input("Digite o nome do produto: "))
quantidade = int(input("Digite a quantidade de produtos: "))
preco = float(input("Digite o preço do produto: R$"))
desconto = float(input("Digite a porcentagem do desconto: "))
desconto = preco * (desconto/100)
preco = (preco - desconto)* quantidade
print ("Nome: %s\nDesconto: R$%.2f\nPreço final: R$%.2f" %(nome, desconto, preco))
