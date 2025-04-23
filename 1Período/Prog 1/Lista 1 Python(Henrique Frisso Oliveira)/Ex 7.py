"""
Nome: Henrique Frisso Oliveira
Turma V06
Exercício 7
Converta uma temperatura digitada em Celsius para Fahrenheit. F = 9*C/5 + 32.
"""

celsius = float(input("Digite a temperatura em Celsius: "))
fahrenheit = float(9*celsius/5 + 32)
print ("A temperatura digitada equivale a %.1f Fahrenheit" %fahrenheit)
