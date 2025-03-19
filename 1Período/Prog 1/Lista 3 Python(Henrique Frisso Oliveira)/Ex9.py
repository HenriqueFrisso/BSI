"""
Nome: Henrique Frisso Oliveira
Turma: V06
Exercicio 9
Uma academia deseja fazer um senso entre seus clientes para descobrir o mais alto, o 
mais baixo, o mais gordo e o mais magro. Para isto você deve fazer um programa que 
pergunte a cada um dos clientes da academia seu código, sua altura e seu peso. Ao 
encerrar o programa devem ser informados os códigos e valores do cliente mais alto, do 
mais baixo, do mais gordo e do mais magro, além da média das alturas e dos pesos dos 
clientes.
"""
alturaMedia = 0
pesoMedio = 0
x = 1
cod = int(input("Digite o código do cliente 1: "))
altura = float(input("Digite a altura do cliente: "))
peso = float(input("Digite o peso do cliente: "))

codMaior = cod
alturaMaior = altura
pesoMaior = peso

codMenor = cod
alturaMenor = altura
pesoMenor = peso

codMagro = cod
alturaMagro = altura
pesoMagro = peso

codGordo = cod
alturaGordo = altura
pesoGordo = peso

alturaMedia += altura
pesoMedio += peso

while (cod!=0):
    x+=1
    cod = int(input("Digite o código do cliente %d (para terminar digite 0): " %x))
    if (cod != 0):
        altura = float(input("Digite a altura do cliente: "))
        peso = float(input("Digite o peso do cliente: "))

        if (altura > alturaMaior):
            codMaior = cod
            alturaMaior = altura
            pesoMaior = peso
        elif (altura < alturaMenor):
            codMenor = cod
            alturaMenor = altura
            pesoMenor = peso
        if (peso < pesoMagro):
            codMagro = cod
            alturaMagro = altura
            pesoMagro = peso
        elif (peso> pesoGordo):
            codGordo = cod
            alturaGordo = altura
            pesoGordo = peso
        alturaMedia += altura
        pesoMedio +=peso
x -= 1
alturaMedia = alturaMedia/x
pesoMedio = pesoMedio/x

print ("\nO código do cliente mais alto é: %d\nA altura do cliente mais alto é: %.2f m\nO peso do cliente mais alto é: %.2f Kg" %(codMaior,alturaMaior,pesoMaior))
print ("\nO código do cliente mais baixo é: %d\nA altura do cliente mais baixo é: %.2f m\nO peso do cliente mais baixo é: %.2f Kg" %(codMenor,alturaMenor,pesoMenor))
print ("\nO código do cliente mais gordo é: %d\nA altura do cliente mais gordo é: %.2f m\nO peso do cliente mais gordo é: %.2f Kg" %(codGordo,alturaGordo,pesoGordo))
print ("\nO código do cliente mais magro é: %d\nA altura do cliente mais magro é: %.2f m\nO peso do cliente mais magro é: %.2f Kg" %(codMagro,alturaMagro,pesoMagro))
print ("\nA média das alturas dos clientes é: %.2f m\nA media dos pesos dos clientes é: %.2f Kg" %(alturaMedia, pesoMedio))
