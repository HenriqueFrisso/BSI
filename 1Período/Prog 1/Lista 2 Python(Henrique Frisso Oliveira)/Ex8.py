"""
Nome: Henrique Frisso Oliveira
Turma: V06
Exercicio 8
Em uma competição de ginástica, cada atleta recebe votos de cinco jurados. As notas são
de 0 a 10. A melhor e a pior nota são eliminadas. A sua nota fica sendo a média dos votos
restantes. Você deve fazer um programa que receba o nome do ginasta e as notas dos
cinco jurados alcançadas pelo atleta em sua apresentação e depois informe a sua média,
conforme a descrição acima informada (retirar a melhor e a pior nota e depois calcular a
média com as notas restantes). As notas não são informadas ordenadas. Ao final mostrar
o nome do atleta, sua média, a maior e a menor nota
"""
nome = str(input("Digite seu nome: "))
n1 = int(input("Dgite a primeira nota: "))
n2 = int(input("Dgite a segunda nota: "))
n3 = int(input("Dgite a terceira nota: "))
n4 = int(input("Dgite a quarta nota: "))
n5 = int(input("Dgite a quinta nota: "))

if (n1>=n2 and n1>=n3 and n1>=n4 and n1>=n5):
    maior = n1
elif (n2>=n3 and n2>=n4 and n2>=n5):
    maior = n2
elif (n3>=n4 and n3>=n5):
    maior = n3
elif (n4>=n5):
    maior = n4
else:
    maior = n5

if (n1<=n2 and n1<=n3 and n1<=n4 and n1<=n5):
    menor = n1
elif (n2<=n3 and n2<=n4 and n2<=n5):
    menor = n2
elif (n3<=n4 and n3<=n5):
    menor = n3
elif (n4<=n5):
    menor = n4
else:
    menor = n5

media = float((n1+n2+n3+n4+n5-maior-menor)/3)
print ("Atleta: %s\nMédia: %.2f\nMaior nota: %d\nMenor Nota: %d" %(nome,media,maior,menor))
