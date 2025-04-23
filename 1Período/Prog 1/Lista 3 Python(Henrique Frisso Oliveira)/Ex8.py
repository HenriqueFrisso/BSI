"""
Nome: Henrique Frisso Oliveira
Turma: V06
Exercicio 8
O Sr. Manoel Joaquim expandiu seus negócios para além dos negócios de 1,99 e agora 
possui uma loja de conveniências. Faça um programa que implemente uma caixa 
registradora rudimentar. O programa deverá receber o valor de cada produto comprado. 
Um valor zero deve ser informado pelo operador para indicar o final da compra. O 
programa deve então mostrar o total da compra e perguntar o valor em dinheiro que o 
cliente forneceu, para então calcular e mostrar o valor do troco. Após esta operação, o 
programa deverá voltar ao ponto inicial, para registrar a próxima compra. Abaixo está um 
exemplo da execução, onde o preço de cada produto será digitado. Não precisa ficar igual 
a essa saída, isso é apenas um exemplo.
"""

valor = 1
produto = 0
total = 0
while (valor!=0):
    produto+=1
    valor = float(input("Produto %d: R$ " %produto))
    while (valor < 0):
        valor = float(input("Produto %d novamente: R$ " %produto))
    total = total+valor
produto -=1
print ("Valor total: R$ %.2f\nReferente a %d itens." %(total,produto))
dinheiro = float(input("Dinheiro R$ : "))
while (dinheiro < total):
    print("Valor insuficiente.")
    dinheiro = float(input("Dinheiro R$ : "))
troco = dinheiro - total
print("Troco: R$ %.2f" %troco)
