"""
Nome: Henrique Frisso Oliveira
Turma: V06
Exercicio 3
Faça um programa para ler o nome do aluno e suas três notas. Valide cada nota. Calcule a
média final do aluno e imprima: “APROVADO” se a média for maior ou igual a 7;
“REPROVADO” se a média for menor que 6; e “PROVA FINAL” se a média estiver entre 6
e 7. Imprima também as notas na ordem decrescente.

"""
x = 1
media = 0
maior = 0
menor = 10
meio = 0
nome = str(input("Digite o nome do aluno: "))
while (x<=3):
    nota = int(input("Digite a nota %d: " %x))
    while (nota<0 or nota>10):
        nota = int(input("Digite uma nota entre 0 e 10: "))
    media = media + nota
    x+=1
    if (nota > maior):
        if menor < meio:
            menor = meio
        meio = maior
        maior = nota      
    elif (nota < menor):
        maior = meio
        meio = menor
        menor = nota
media = media/3
if (nota<6):
    print ("REPROVADO")
elif (nota<7):
    print ("PROVA FINAL")
else:
    print ("APROVADO")

print ("%d, %d, %d" %(maior,meio,menor))
