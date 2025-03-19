"""
Nome: Henrique Frisso Oliveira
Turma: V06
Exercicio 7
Faça um programa para uma loja de tintas. O programa deverá pedir o tamanho em metros
quadrados da área a ser pintada. Considere que a cobertura da tinta é de 1 litro para cada
3 metros quadrados e que a tinta é vendida em latas de 18 litros, que custam R$ 80,00.
Informe ao usuário a quantidades de latas de tinta a serem compradas e o preço total.
Obs. : somente são vendidos um número inteiro de latas
"""

tamanho = int(input("Digite a o tamanho da área a ser pintada em metros quadrados: "))
tinta = tamanho/3
if (tamanho%3 != 0):
    tinta = tinta+1
latas = tinta/18
if (tinta%18 != 0):
    latas = int(latas+1)
valor = latas*80
print ("Serão utilizadas %d latas e custará R$%.2f" %(latas, valor))
