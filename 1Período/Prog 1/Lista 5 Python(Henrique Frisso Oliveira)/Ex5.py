"""
Nome: Henrique Frisso Oliveira
Turma: V06
Exercicio 5
Faça um programa que peça as três notas de um aluno, calcule e armazene num vetor
apenas a média desse aluno. Repita isso para vários alunos, até o usuário desejar
encerrar. Imprima somente as médias que são maiores ou igual a 7.0
"""

def validarNotas(vetor):
    media=0
    aluno=len(vetor)+1
    print ("Aluno %d" %aluno)
    for h in range (3):
        nota=int(input("Digite uma nota: "))
        while (nota<0) or (nota>10):
            nota=int(input("Digite uma nota entre 0 e 10: "))
        media+=nota
    media=media/3
    vetor.append(media)
    
def imprimir(vetor):
    print ("As médias maiores que 7 foram:")
    for h in range (len(vetor)):
        if vetor[h]>=7:
            print ("Aluno %d: " %(h+1), end="")
            print ("%.2f" %(vetor[h]))

def main():
    vetMedia=[]
    continuar=""
    while continuar=="":
        validarNotas(vetMedia)
        continuar=input("Para contiuar pressione enter, para encerrar o programa escreva algo: ")
    imprimir(vetMedia)

main()
