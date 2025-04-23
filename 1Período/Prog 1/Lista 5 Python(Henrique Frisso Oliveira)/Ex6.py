"""
Nome: Henrique Frisso Oliveira
Turma: V06
Exercicio 6
Faça um programa que peça o peso e a altura de várias pessoas, armazene cada
informação no seu respectivo vetor (você precisará de dois vetores). Faça outra função
que percorra esses dois vetores e para cada iteração calcule o IMC e armazene-o em um
terceiro vetor (essa função receberá os três vetores como parâmetros).
IMC = peso / (altura * altura)
DICA: utilize o mesmo contador para os dois vetores. 
"""

def validarPeso(vetor):
    peso = float(input("Digite seu peso: "))
    while peso<=0:
        peso = float(input("Digite um peso maior que 0: "))
    vetor.append(peso)
    
def validarAltura(vetor):
    altura = float(input("Digite sua altura: "))
    while altura<=0:
        altura = float(input("Digite uma altura maior que 0: "))
    vetor.append(altura)

def inserirPessoas(vetP,vetA):
    adicionar = ""
    while adicionar == "":
        print ("Pessoa %d" %(len(vetP)+1))
        validarPeso(vetP)
        validarAltura(vetA)
        adicionar = input("Para contiuar pressione enter, para encerrar o programa escreva algo: ")

def calcularIMC(vetP,vetA,vetIMC):
    for h in range (len(vetP)):
        IMC = vetP[h] / (vetA[h] * vetA[h])
        vetIMC.append(IMC)

def imprimir(vetor):
    for h in range (len(vetor)):
        print("pessoa %d: IMC = %.2f" %((h+1),vetor[h]))

def main():
    vetorPesos=[]
    vetorAlturas=[]
    vetorIMC=[]
    inserirPessoas(vetorPesos,vetorAlturas)
    calcularIMC(vetorPesos,vetorAlturas,vetorIMC)
    imprimir(vetorIMC)

main()
    
