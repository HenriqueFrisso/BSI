"""
Nome: Henrique Frisso Oliveira
Turma: V06
Exercicio 5
O número de combinações possíveis de m elementos em grupos de n elementos (n <=
m) é dada pela fórmula de combinação m! / ( (m-n)! . n!).
Escreva um programa que lê dois inteiros m e n e calcula a combinação de m, n a n. Crie
uma função para calcular o fatorial e chame essa função várias vezes.
"""
def validarNumeros():
    n = int(input("Digite o valor de n: "))
    m = int(input("Digite o valor de m: "))
    while (m < n):
        print ("O valor de m deve ser maiorque o valor de n")
        n = int(input("Digite o valor de n: "))
        m = int(input("Digite o valor de m: "))
    return (n,m)

def fatorial(n):
    fac = 1
    for h in range (1,(n+1)):
        fac = fac*h
    return fac

def combinacao(n,m):
    comb = fatorial(m)/(fatorial((m-n))*fatorial(n))
    return comb

def main():
    n,m = validarNumeros()
    comb = combinacao(n,m)
    print("A combinação entre %d e %d é %d" %(n,m,comb))

main()
