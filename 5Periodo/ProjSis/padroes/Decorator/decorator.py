from imports import *

"""
Python oferece suporte nativo a decoradores,
que são funções que podem modificar o comportamento de outras funções ou métodos. 
Decoradores são frequentemente usados para adicionar funcionalidades a funções existentes, 
como autenticação, registro de logs, verificação de permissões, entre outros.

# Para usar um decorador, você simplesmente o aplica a uma função usando o símbolo "@" antes da definição da função.
# Isso é equivalente a passar a função para o decorador como argumento.

"""

lista = []
for i in range (9999):
    lista.append(randint(0,100000))

shellSort(lista)
bubbleSort(lista)
insertionSort(lista)



inverter("Python", "Java", "C++", "JavaScript", "PHP")