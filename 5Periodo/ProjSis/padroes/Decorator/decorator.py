from imports import *

def decorator(func):
    def interna(*args, **kwargs):
        print("Inicio do decorator")
        func(*args, **kwargs)
        print("Fim do decorator")
    return interna

def somar(x, y):
    print(f"A soma de {x} e {y} é: {x + y}")

# somar = decorator(somar)
# somar(2,3)

'''
def somar(x, y):
    print("Inicio do decorator")
    print(f"A soma de {x} e {y} é: {x + y}")
    print("Fim do decorator")

'''

p1 = Pessoa("Henrique")
p2 = Pessoa("Alex")
print(f"Nome p1: {p1}")
print(f"Nome p2: {p2}")
print(p2 == p1)
print("")
a1 = Animal("Bob")
a2 = Animal("Rex")
print(f"Nome a2: {a2}")
print(f"Nome a1: {p1}")
print(a1 == p1)
print("")
print(Pessoa._instancias)
print(Animal._instancias)