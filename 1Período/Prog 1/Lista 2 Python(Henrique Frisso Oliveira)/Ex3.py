"""
Nome: Henrique Frisso Oliveira
Turma: V06
Exercicio 3
Faça um programa para a leitura de duas notas parciais de um aluno. O programa deve
calcular a média alcançada por aluno e apresentar a mensagem:
­ "Aprovado", se a média alcançada for maior ou igual a sete;
­ "Reprovado", se a média for menor do que sete;
­ "Aprovado com Distinção", se a média for igual a dez
"""

n1 = float(input("Digite a primeira parcial: "))
n2 = float(input("Digite a segunda parcial: "))
media = (n1+n2)/2
if (media == 10):
    print ("Aprovado com Distinção")
elif (media >= 7):
    print("Aprovado")
elif (media < 7):
    print ("Reprovado")
