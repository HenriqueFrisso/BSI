"""
Nome: Henrique Frisso Oliveira
Turma V06
Exercício 10
Escreva um programa para calcular a redução do tempo de vida de um fumante. Pergunte 
a quantidade de cigarros fumados por dia e quantos anos ele já fumou. Considere que um 
fumante perde 10 minutos de vida a cada cigarro, calcule quantos dias de vida um fumante 
perderá. Exiba o total de dias. 
"""

quantidade = int(input("Digite a quantidade de cigarros que você fuma por dia: "))
anos = int(input("Digite a quanidade de anos que você fuma: "))
dias = (quantidade*(anos*365)*10)/1440
print("Você já perdeu %d dias de vida" %dias)
