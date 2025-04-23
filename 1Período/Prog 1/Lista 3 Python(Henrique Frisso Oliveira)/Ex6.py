"""
Nome: Henrique Frisso Oliveira
Turma: V06
Exercicio 6
Ler dois números inteiros positivos e determinar o máximo divisor comum entre eles.
DICA: Repita de 1 até chegar a um dos dois números lidos. A cada iteração verificar se
esse contador divide os dois números. Se dividir, guarde ele em uma variável. Um número
é divisível por outro se o resto da divisão for zero.
"""
n1 = int(input("Digite um número: "))
n2 = int(input("Digite outro número: "))
x = 1
while (x<n1 and x<n2):
    if ((n1%x) == 0) and ((n2%x) == 0):
        mdc = x
    x+=1
print ("O máximo divisor comum entre %d e %d é %d" %(n1,n2,mdc))
