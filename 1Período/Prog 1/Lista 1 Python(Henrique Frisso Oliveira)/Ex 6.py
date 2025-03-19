"""
Nome: Henrique Frisso Oliveira
Turma V06
Exercício 6
Calcule o tempo de uma viagem de carro. Pergunte a distância a percorrer e a velocidade 
média esperada para a viagem
"""

distancia = float(input("Digite a distancia a ser percorrida em Km: "))
velocidade = float(input("Digite a velocidade média esperada para a viagem em Km/h: "))
tempo = distancia/velocidade
horas = int(tempo)
minutos = (tempo % 1)*60
print ("O tempo estimado para essa viagem é de %d horas e %d minutos" %(horas, minutos))

