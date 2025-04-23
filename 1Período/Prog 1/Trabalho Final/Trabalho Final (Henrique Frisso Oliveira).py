"""
TRABALHO FINAL
Aluno: Henrique Frisso Oliveira
Turma: V06
"""

def menu() :
    op = ""
    while op.isdigit() == False or int(op) < 0 or int(op) > 6:

        print("\n" *30)        
        print("FOLHA DE PAGAMENTO")
        print("1-Inserir funcionário")
        print("2-Pesquisar por matrícula")
        print("3-Aumentar salário")
        print("4-Maior salário")
        print("5-Demitir")
        print("6-Listar")
        print("0-Sair")
        op = input("Escolha sua opção: ")
    return int(op)

    
###### PRINCIPAL ##########
def main():
    vetorMatricula=[]
    vetorSalario=[]
    op = 1
    while op != 0:
        op = menu()
        
        if op == 0:
            print("\n\nFim do programa!!!\n\n")
            
        elif op == 1:
            print("\n\nINSERIR\n\n")
            inserirFuncionario(vetorMatricula,vetorSalario)
            # Chamar a função para Inserir os dados nos vetores

            
        elif op == 2:
            print("\n\nPESQUISAR\n\n")
            repetido,pos = pesquisar(vetorMatricula,vetorSalario,input("Digite a matricula para pesquisa: "))
            if (repetido == False):
                print ("Essa matrícula não está cadastrada.")
            else:
                matricula,salario = buscarDados(vetorMatricula,vetorSalario,pos)
                print("Matricula: %s\nSalário: R$%.2f" %(matricula,salario))
            # Ler a informação para pesquisar
            # Chamar a função para pesquisar no vetor
            # Imprimir os dados se encontrar


        elif op == 3:
            print("\n\nATUALIZAR\n\n")
            repetido,pos = pesquisar(vetorMatricula,vetorSalario,input("Digite a matricula para pesquisa: "))
            if (repetido == False):
                print ("Essa matrícula não está cadastrada.")
            else:
                print ("Aumento de salário realizado.\nO novo salário do funcionário é: R$%.2f" %(atualizarDados(vetorMatricula,vetorSalario,pos)))
            # Ler a informação para pesquisar
            # Chamar a função para pesquisar no vetor
            # Ler os novos dados
            # Se encontrar, então atualizar o vetor, na posição pesquisada,
            #    com os novos dados


        elif op == 4:
            print("\n\nMAIOR\n\n")
            iguais,matricula,salario = maiorSalario(vetorMatricula,vetorSalario)
            if (iguais == 1):
                print ("O funcionário com o maior salário possui a matricula %s, e salário igual à R$%.2f" %(matricula,salario))
            else:
                print ("%d funcionários possuem os maiores salários, suas matriculas são: %s, e possuem salário igual à: R$%.2f" %(iguais,str(matricula),salario))
            # Chamar a função para pesquisar no vetor o maior elemento



        elif op == 5:
            print("\n\nEXCLUIR\n\n")
            repetido,pos = pesquisar(vetorMatricula,vetorSalario,input("Digite a matricula para pesquisa: "))
            if (repetido == False):
                print ("Essa matrícula não está cadastrada.")
            else:
                demitir(vetorMatricula,vetorSalario,pos)
                print ("O funcionário foi demitido.")
            # Ler a informação para pesquisar
            # Chamar a função para pesquisar no vetor
            # Excluir a posição pesquisada, se encontrar


        elif op == 6:
            print("\n\nLISTAR\n\n")
            listar(vetorMatricula,vetorSalario)
            # Listar todos os dados dos vetores


        else:
            print("Opção inválida!")


        input("\nPressione <enter> para continuar ...")



###### INSERIR FUNCIONÁRIOS ##########
def inserirFuncionario(vet1, vet2):
    matricula = input("Digite o número de matrícula do novo funcionário: ")
    repetido,pos = pesquisar(vet1, vet2, matricula)
    while (repetido == True):# MATRÍCULA REPETID
        print("Inválido!")
        print("Essa matrícula já está registrada.")
        matricula = input("Digite o número de matrícula do novo funcionário: ")
        repetido,pos = pesquisar(vet1, vet2, matricula)
    vet1.append(matricula)
    
    salario = float(input("Digite o salário do funcionário: R$"))
    while (salario <= 0):# SALÁRIO MENOR QUE 0
        print("Inválido!")
        print("O salario deve ser maior que 0.")
        salario = float(input("Digite o número de matrícula do novo funcionário: R$"))
    vet2.append(salario)

###### PESQUISAR NO BANCO ##########
def pesquisar(vet1,vet2,matricula):
    repetido = False
    pos = -1
    for h in range(len(vet1)):# VERIFICA A POSIÇÃO DA MATRICULA E RETORNA CASO NÃO EXISTA UMA MATRÍCULA CADASTRADA
        if vet1[h]==matricula:
            repetido = True
            pos = h
    return repetido,pos

###### BUSCAR DADOS NO BANCO ##########
def buscarDados(vet1,vet2,pos):
    matricula = vet1[pos]
    salario = vet2[pos]
    return matricula,salario# RETORNA OS VALORES DE MATRÍCULA E SALÁRIO DE UM FUNCIONÁRIO

###### ATUALIZAR DADOS NO BANCO ##########
def atualizarDados(vet1,vet2,pos):
    aumento = float(input("Digite a porcentagem de aumento: "))
    vet2[pos] += ((vet2[pos]*aumento)/100)# CALCULA E SOMA O AUMENTO AO SALÁRIO
    return vet2[pos]

###### PESQUISAR MAIOR SALÁRIO ##########
def maiorSalario(vet1,vet2):
    maior = 0
    matMaior = ""
    iguais = 1
    for h in range (len(vet2)):
        if (vet2[h] > maior):# VERIFICA O MAIOR SALÁRIO DO VETOR
            maior = vet2[h]
            matMaior = vet1[h]
            iguais = 1
        elif (vet2[h] == maior):# CASO TENHA MAIS DE UMA MATRICULA COM O MESMO SALÁRIO RETORNA TODAS AS MATRICULAS COM O MAIOR SALÁRIO
            iguais += 1
            matMaior = (matMaior,) + (vet1[h],)
    return iguais,matMaior,maior

###### DEMITIR ##########
def demitir(vet1,vet2,pos):# REMOVE DOS VETORES DE ACORDO COM A POSIÇÃO INDICADA
    del vet1[pos]
    del vet2[pos]

###### LISTAR ##########
def listar(vet1,vet2):
    vazio = True
    for h in range (len(vet1)):# LISTA TODOS OS DADOS DO VETOR
        print("Matrícula: %s         Salário: R$%.2f" %(vet1[h],vet2[h]))
        vazio = False
    if (vazio == True):# CASO O VETOR ESTEJA VAZIO RETORNA UMA MENSAGEM DE ERRO
        print("Nenhuma matrícula cadastrada.")
    
main()

        
