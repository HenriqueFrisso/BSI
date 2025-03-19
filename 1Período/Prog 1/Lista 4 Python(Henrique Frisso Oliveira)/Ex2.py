"""
Nome: Henrique Frisso Oliveira
Turma: V06
Exercicio 2
Altere o exercício 2 da Lista 3 para usar funções. Será necessária uma função para cada
informação a ser lida.
"""
def validarNome():
    nome = str(input("Digite seu nome: "))
    while (len(nome)<=3):
        nome = str(input("Digite um nome com mais de 3 caracteres: "))
    return (nome)

def validarIdade():
    idade = int(input("Digite sua idade: "))
    while ((idade<0) or (idade>150)):
        idade = int(input("Digite uma idade entre 0 e 150: "))
    return (idade)

def validarSalario():
    salario = float(input("Digite seu salário: R$"))
    while (salario<=0):
        salario = float(input("Digite um salário maior que zero: R$"))
    return (salario)

def validarSexo():
    sexo = str(input("Digite o sexo: ")).upper()
    while((sexo!="F") and (sexo!="M")):
        sexo = str(input("Digite o sexo (f/m): ")).upper()
    return (sexo)

def validarEC():
    estadoCivil = str(input("Digite o estado civil: ")).upper()
    while ((estadoCivil!="S")and(estadoCivil!="C")and(estadoCivil!="V")and(estadoCivil!="D")):
        estadoCivil = str(input("Digite o estado civil (s/c/v/d): ")).upper()
    return (estadoCivil)

def main():  
    nome = validarNome()
    idade = validarIdade()
    salario = validarSalario()
    sexo = validarSexo()
    estadoCivil = validarEC()
    print ("Nome - %s\nIdade - %d\nSalario R$ %.2f\nSexo - %s\nEstado Civil - %s" %(nome,idade,salario,sexo,estadoCivil))

main()
