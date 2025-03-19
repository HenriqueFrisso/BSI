"""
Nome: Henrique Frisso Oliveira
Turma V06
Exercício 2
Faça um programa que peça o nome do aluno e suas 4 notas bimestrais e mostre o nome 
do aluno e a média.
"""

nome = str(input("Digite seu nome: "))
n1 = int(input("Digite a nota do primeiro bimestre: "))
n2 = int(input("Digite a nota do segundo bimestre: "))
n3 = int(input("Digite a nota do terceiro bimestre: "))
n4 = int(input("Digite a nota do quarto bimestre: "))
media = (n1+n2+n3+n4)/4
print ("O aluno %s teve a média igual a: %.2f" %(nome, media))
