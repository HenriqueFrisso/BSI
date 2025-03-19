"""
Nome: Henrique Frisso Oliveira
Turma: V06
Exercicio 1
Altere o exercício 1 da Lista 3 para usar funções. Será necessária uma função para ler e
validar o nome e outra função para ler e validar a senha.
"""

def validarSenha(senha, nome):
    if ((senha == nome) or (len(senha) < 6)):
        print ("Erro...")
        return False
    else:
        return True

def main():
    nome = str(input("Digite o nome de usuário: "))
    senha = str(input("Digite a senha: "))
    while validarSenha(senha,nome)!= True:
        nome = str(input("Digite o nome de usuário: "))
        senha = str(input("Digite a senha: "))
    print ("O nome de usuário digitado foi: %s\nA senha digitada foi: %s" %(nome,senha))

main()
