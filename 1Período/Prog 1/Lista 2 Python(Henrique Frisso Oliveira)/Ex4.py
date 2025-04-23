"""
Nome: Henrique Frisso Oliveira
Turma: V06
Exercicio 4
Faça um programa que peça a hora atual e mostre uma mensagem na tela de acordo com
os intervalos abaixo:
0 <= Hora < 5  “VAI DORMIR ...”
5 <= Hora < 12  “BOM DIA”
12 <= Hora < 18  “BOA TARDE”
18 <= Hora < 24  “BOA NOITE”
Outro valor  “HORA INVÁLIDA”
"""

hora = int(input("Digite a hora atual: "))

if ((hora >= 0) and (hora < 5)):
    print ("VAI DORMIR ...")
elif ((hora >= 5) and (hora < 12)):
    print ("BOM DIA")
elif ((hora >= 12) and (hora < 18)):
    print ("BOA TARDE")
elif ((hora >= 18) and (hora < 24)):
    print ("BOA NOITE")
else:
    print ("HORA INVÁLIDA")
