"""
Nome: Henrique Frisso Oliveira
Turma: V06
Exercicio 5
Supondo que a população de um país A seja da ordem de 80000 habitantes com uma taxa
anual de crescimento de 3% e que a população de B seja 200000 habitantes com uma
taxa de crescimento de 1.5%. Faça um programa que calcule e escreva o número de anos
necessários para que a população do país A ultrapasse ou iguale a população do país B,
mantidas as taxas de crescimento.
"""
popA = 80000
popB = 200000
taxaA = 3/100
taxaB = 1.5/100
ano=0
while (popA<popB):
    popA = popA+(popA*taxaA)
    popB = popB+(popB*taxaB)
    ano+=1
print("A população do país A demorou %d anos para ultrapassar ou igualar a população do país B" %ano)
