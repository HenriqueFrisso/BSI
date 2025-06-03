from imports import *

def decorator(func):
    def interna(*args, **kwargs):
        print("Inicio do decorator")
        func(*args, **kwargs)
        print("Fim do decorator")
    return interna

def somar(x, y):
    print(f"A soma de {x} e {y} é: {x + y}")

somar = decorator(somar)
somar(2,3)

'''
def somar(x, y):
    print("Inicio do decorator")
    print(f"A soma de {x} e {y} é: {x + y}")
    print("Fim do decorator")

'''

def singleton(cls):
    instancias = {} # {classeA: instanciaA, classeB: instanciaB}

    def get_instance(*args, **kwargs):
        if cls not in instancias:
            instancias[cls] = cls(*args, **kwargs)
        return instancias[cls]

    return get_instance

@singleton
class Teste:
    def __init__(self, nome):
        self.nome = nome

    def __str__(self):
        return f"{self.nome}"
    
t1 = Teste("A")
t2 = Teste("B")
print(t2 == t1)