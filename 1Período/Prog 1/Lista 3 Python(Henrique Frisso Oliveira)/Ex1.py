"""
Nome: Henrique Frisso Oliveira
Turma: V06
Exercicio 1
Faça um programa que leia um nome de usuário e a sua senha. A senha não pode ser
igual ao nome do usuário, nem menor que 6 caracteres. Caso ocorra o erro, mostre a
mensagem de erro e volte a pedir as informações. No final imprima o nome e a senha.
DICA: Use a função “len” para pegar a quantidade de caracteres de uma string.
"""
nome = str(input("Digite o nome de usuário: "))
senha = str(input("Digite a senha: "))
while (senha == nome) or (len(senha) < 6):
    if (senha == nome):
        print ("A senha não pode ser igual ao nome de usuário")
    else:
        print ("A senha deve ter pelo menos 6 caracteres")
    senha = str(input("Digite a senha: "))
print ("O nome de usuário digitado foi: %s\nA senha digitada foi: %s" %(nome,senha))
