"""
Nome: Henrique Frisso Oliveira
Turma: V06
Exercicio 2
Faça um Programa que verifique se uma letra digitada é "F" ou "M". Conforme a letra,
escrever: F ­ Feminino, M ­ Masculino ou Sexo Inválido
"""
letra = str(input("Digite 'F' para Feminino e 'M' para Masculino: "))
if (letra.upper() == "F"):
    print ("F ­ Feminino")
elif (letra.upper() == "M"):
    print ("M ­ Masculino")
else:
    print("Sexo Inválido")
