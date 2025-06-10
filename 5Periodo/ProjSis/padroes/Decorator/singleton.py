
def singleton(cls):
    instancias = {} # {classeA: instanciaA, classeB: instanciaB}

    def get_instance(*args, **kwargs):
        if cls not in instancias:
            instancias[cls] = cls(*args, **kwargs)
        return instancias[cls]
    get_instance._instancias = instancias
    return get_instance

@singleton
class Pessoa:
    def __init__(self, nome):
        self.nome = nome

    def __str__(self):
        return f"{self.nome}"
    

@singleton
class Animal:
    def __init__(self, nome):
        self.nome = nome

    def __str__(self):
        return f"{self.nome}"
    

