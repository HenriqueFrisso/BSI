from time import time

def decoratorIterator(func):
    def interna(*args):
        print("Iteradores originais:")
        for arg in args:
            print(f"Argumento: {arg}")
        print("")
        print("Iteradores modificados:")
        for arg in args:
            print(f"Invertido: {func(arg)}")
    return interna

@decoratorIterator
def inverter(iterador):
    return iterador[::-1]

def decoratorContarTempo(func):
    def interna(lista):
        tempoIni = time()
        listaOrdenada = func(lista.copy())
        tempoFim = time()
        print(f"O tempo gasto para execução da função foi de {(tempoFim - tempoIni):.4f} segundos")
        return listaOrdenada
    return interna

@decoratorContarTempo
def bubbleSort(lista):
    n = len(lista)
    for i in range(n):
        for j in range(0, n - i - 1):
            if lista[j] > lista[j + 1]:
                lista[j], lista[j + 1] = lista[j + 1], lista[j]
    return lista

@decoratorContarTempo
def shellSort(lista):
    n = len(lista)
    gap = n // 2
    while gap > 0:
        for i in range(gap, n):
            temp = lista[i]
            j = i
            while j >= gap and lista[j - gap] > temp:
                lista[j] = lista[j - gap]
                j -= gap
            lista[j] = temp
        gap //= 2
    return lista

@decoratorContarTempo
def insertionSort(lista):
    for i in range(1, len(lista)):
        chave = lista[i]
        j = i - 1
        while j >= 0 and lista[j] > chave:
            lista[j + 1] = lista[j]
            j -= 1
        lista[j + 1] = chave
    return lista

