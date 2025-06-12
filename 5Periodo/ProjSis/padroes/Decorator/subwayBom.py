class Sanduiche:
    def __init__(self, nome="Sanduíche", preco=5):
        self.nome = nome
        self.preco = preco

    def __str__(self):
        return f"{self.nome} custa R${self.preco:.2f}"


def queijo(func):
    def interna():
        sanduiche = func()
        sanduiche.nome += " + Queijo"
        sanduiche.preco += 4
        return sanduiche
    return interna

def presunto(func):
    def interna():
        sanduiche = func()
        sanduiche.nome += " + Presunto"
        sanduiche.preco += 5
        return sanduiche
    return interna

def alface(func):
    def interna():
        sanduiche = func()
        sanduiche.nome += " + Alface"
        sanduiche.preco += 1
        return sanduiche
    return interna


def tomate(func):
    def interna():
        sanduiche = func()
        sanduiche.nome += " + Tomate"
        sanduiche.preco += 1.5
        return sanduiche
    return interna



def sanduiche():
    return Sanduiche()


sanduiche_pronto = queijo(sanduiche)
sanduiche_pronto = presunto(sanduiche_pronto)
sanduiche_pronto = alface(sanduiche_pronto)

print(sanduiche_pronto())


@queijo
@presunto
@alface
def sanduiche():
    return Sanduiche()


sanduiche_pronto = sanduiche()

print(sanduiche_pronto)



ingredientes = [queijo, presunto, alface, tomate]

def montar_base():
    return Sanduiche()

def aplicar_ingredientes(base_func, lista_decoradores):
    func = base_func
    for decorador in reversed(lista_decoradores): 
        func = decorador(func)
    return func()

sanduiche_pronto = aplicar_ingredientes(montar_base, ingredientes)
print(sanduiche_pronto)


