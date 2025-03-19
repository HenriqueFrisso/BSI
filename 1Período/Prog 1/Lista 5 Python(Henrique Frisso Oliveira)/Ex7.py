"""
Nome: Henrique Frisso Oliveira
Turma: V06
Exercicio 7
Uma grande emissora de televisão quer fazer uma enquete entre os seus telespectadores
para saber qual o melhor jogador após cada jogo. Para isto, faz-se necessário o
desenvolvimento de um programa, que será utilizado pelas telefonistas, para a
computação dos votos. Sua equipe foi contratada para desenvolver este programa,
utilizando a linguagem de programação Python. Para computar cada voto, a telefonista
digitará um número, entre 1 e 25, correspondente ao número da camisa do jogador. Um
número de jogador igual zero, indica que a votação foi encerrada. Se um número inválido
for digitado, o programa deve ignorá-lo, mostrando uma breve mensagem de aviso, e
voltando a pedir outro número. Após o final da votação, o programa deverá exibir:
 O total de votos computados;
 Os números e respectivos votos de todos os jogadores que receberam votos;
 O percentual de votos de cada um destes jogadores;
 O número do jogador escolhido como o melhor jogador da partida, juntamente com
o número de votos e o percentual de votos dados a ele.
DICA 1: Utilize um vetor para armazenar os votos. O índice do vetor é o número do
jogador. Então quando um jogador recebe um voto, o elemento do vetor
correspondente a essa posição soma mais um.
DICA 2: Esse vetor deve ser inicializado com ZERO nas 25 posições.
OBS: Observe que os votos inválidos e o zero final não devem ser computados como
votos. O resultado aparece ordenado pelo número do jogador. O programa deve fazer
uso de vetores. O programa deverá executar o cálculo do percentual de cada jogador
através de uma função. Esta função receberá dois parâmetros: o número de votos de
um jogador e o total de votos. A função calculará o percentual e retornará o valor
calculado. Abaixo segue uma tela de exemplo.


Enquete: Quem foi o melhor jogador?

Número do jogador (0=fim): 9
Número do jogador (0=fim): 10
Número do jogador (0=fim): 9
Número do jogador (0=fim): 10
Número do jogador (0=fim): 11
Número do jogador (0=fim): 10
Número do jogador (0=fim): 50
Informe um valor entre 1 e 25 ou 0 para sair!
Número do jogador (0=fim): 9
Número do jogador (0=fim): 9
Número do jogador (0=fim): 0

Resultado da votação:

Foram computados 8 votos.

Jogador Votos %
9 4 50,0%
10 3 37,5%
11 1 12,5%
O melhor jogador foi o número 9, com 4 votos, correspondendo a
50% do total de votos.
"""

def criarVetor(vetor):
    for h in range (25):
        vetor.append(0)
        
def validarVotos(vetor):
    voto=int(input("Número do jogador (0=fim): "))
    while voto!=0:
        if (voto>25) or (voto<0):
            print ("Informe um valor entre 1 e 25 ou 0 para sair!")
        else:
            vetor[voto]+=1
        voto=int(input("Número do jogador (0=fim): "))

def totalVotos(vetor):
    soma=0
    for h in range (len(vetor)):
        soma+=vetor[h]
    return soma

def porcentagem(total,votos):
    pc = 100*(votos/total)
    return pc

def melhorJogador(vetor,total):
    maior=0
    melhor=-1
    for h in range(len(vetor)):
        if vetor[h]>maior:
            maior=vetor[h]
            melhor=h
    pc=porcentagem(total,maior)
    return melhor,maior,pc

def imprimir(vetor):
    poc="%"
    print("Enquete: Quem foi o melhor jogador?\n")
    validarVotos(vetor)
    print("\nResultado da votação:\n")
    total = totalVotos(vetor)
    print("Foram computados %d votos." %total)
    print("Jogador      Votos       %s" %poc)
    for h in range (len(vetor)):
        if vetor[h]!=0:
            pc=porcentagem(total,vetor[h])
            if h<10:
                print("0%d            %d        %.2f%s" %(h, vetor[h], pc, poc))
            else:
                print("%d            %d        %.2f%s" %(h, vetor[h], pc,poc))
    melhor,votosMelhor,pcMelhor=melhorJogador(vetor,total)
    print ("\nO melhor jogador foi o número %d, com %d votos, correspondendo a %.2f%s do total de votos." %(melhor,votosMelhor,pcMelhor,poc))
    
def main():
    vetorJogadores=[]
    criarVetor(vetorJogadores)
    imprimir(vetorJogadores)

main()
