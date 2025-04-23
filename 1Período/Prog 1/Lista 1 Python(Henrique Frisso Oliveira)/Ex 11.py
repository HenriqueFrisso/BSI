"""
Nome: Henrique Frisso Oliveira
Turma V06
Exercício 11
Sabendo que str( ) converte valores numéricos para string, calcule quantos dígitos há em 2 
elevado a um milhão.
"""

numero = pow(2,1000000)
tamanho = len(str(numero))
print ("O numero 2 elevado a um milhão possui %d digitos" %tamanho)
