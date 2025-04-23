"""
Nome: Henrique Frisso Oliveira
Turma: V06
Exercicio 2
Faça um programa que leia e valide as seguintes informações:
Nome: maior que 3 caracteres;
Idade: entre 0 e 150;
Salário: maior que zero;
Sexo: 'f' ou 'm';
Estado Civil: 's', 'c', 'v', 'd'; (maiúsculas e minúsculas)
Se alguma informação estiver errada, informar o erro e continuar pedindo a informação
certa. No final imprima todos os dados.
"""
nome = str(input("Digite seu nome: "))
while (len(nome)<=3):
    nome = str(input("Digite um nome com mais de 3 caracteres: "))
idade = int(input("Digite sua idade: "))
while ((idade<0) or (idade>150)):
    idade = int(input("Digite uma idade entre 0 e 150: "))
salario = float(input("Digite seu salário: R$"))
while (salario<=0):
    salario = float(input("Digite um salário maior que zero: R$"))
sexo = str(input("Digite o sexo: ")).upper()
while((sexo!="F") and (sexo!="M")):
    sexo = str(input("Digite o sexo (f/m): ")).upper()
estadoCivil = str(input("Digite o estado civil: ")).upper()
while ((estadoCivil!="S")and(estadoCivil!="C")and(estadoCivil!="V")and(estadoCivil!="D")):
    estadoCivil = str(input("Digite o estado civil (s/c/v/d): ")).upper()
