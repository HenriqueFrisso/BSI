"""
Nome: Henrique Frisso Oliveira
Turma: V06
Exercicio 6
Faça um programa com uma função chamada somaImposto. A função possui dois 
parâmetros formais: taxaImposto, que é a quantia de imposto sobre vendas expressa em 
porcentagem; e valorCusto, que é o custo de um item antes do imposto. A função retorna 
o valor de custo acrescentado com o imposto sobre vendas
"""

def somaImposto(taxaImposto, valorCusto):
    vt = valorCusto + (valorCusto * taxaImposto)
    return vt

def main():
    taxaImposto = float(input("Digite a quantidade de imposto sobre as vendas: "))
    valorCusto = float(input("Digite o custo do item antes do imposto: "))
    vt = somaImposto((taxaImposto/100), valorCusto)
    print("O valor de custo acrescentado com o imposto sobre vendas é de: %.2f" %vt)

main()
