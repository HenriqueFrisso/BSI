"""
Nome: Henrique Frisso Oliveira
Turma: V06
Exercicio 10
Criar um programa que a partir da idade e peso do paciente calcule a dosagem de
determinado medicamento e imprima a receita informando quantas gotas do medicamento
o paciente deve tomar por dose. Considere que o medicamento em questão possui 500 mg
por ml, e que cada ml corresponde a 20 gotas.

 Adultos ou adolescentes desde 12 anos, inclusive, se tiverem peso igual ou acima de
60 quilos devem tomar 1000 mg; com peso abaixo de 60 quilos, devem tomar 875 mg.
 Para crianças e adolescentes abaixo de 12 anos, a dosagem é calculada pelo peso
corpóreo conforme a tabela a seguir:

Peso Dosagem
5 kg a 9 kg 125 mg
9.1 kg a 16 kg 250 mg
16.1 kg a 24 kg 375 mg
24.1 kg a 30 kg 500 mg
Acima de 30 kg 750 mg
"""

idade = int(input("Digite sua idade: "))
peso = float(input("Digite seu peso: "))

if (idade<0 or peso<5):
    print ("Informações inválidas")
else:
    if (idade>=12):
        if (peso >=60):
            ml=1000
        else:
            ml=875
    else:
        if (peso<9):
            ml=125
        elif (peso<16):
            ml=250
        elif (peso<24):
            ml=375
        elif (peso<30):
            ml=500
        else:
            ml=750
    gotas = ml/500*20

    print("O paciente deve tomar %d gotas" %gotas)
    
