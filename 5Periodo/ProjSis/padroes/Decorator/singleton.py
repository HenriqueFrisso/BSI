def singleton(cls):
    instancias = {}

    def get_instance(*args, **kwargs):
        if cls not in instancias:
            instancias[cls] = cls(*args, **kwargs)
        return instancias[cls]

    return get_instance

class Guerreiro:
    def __init__(self, nome, forca=10, vida=100):
        self.nome = nome
        self.forca = forca
        self.vida = vida

    def __str__(self):
        return f"Guerreiro: {self.nome}\nForça: {self.forca}\nVida: {self.vida}"
    
    def atacar(self, outro):
        if self.vida > 0:
            outro.vida -= self.forca
            print(f"{self.nome} atacou {outro.nome} e causou {self.forca} de dano!")
        else:
            print(f"{self.nome} não pode atacar porque está morto!")

class Arqueiro(Guerreiro):
    def __init__(self, nome, forca=20, vida=50):
        super().__init__(nome, forca, vida)

    def atacar(self, outro):
        if self.vida > 0:
            outro.vida -= self.forca
            print(f"{self.nome} atacou {outro.nome} com seu arco e causou {self.forca} de dano!")
        else:
            print(f"{self.nome} não pode atacar porque está morto!")

@singleton
class Legolas(Guerreiro):
    def __init__(self):
        super().__init__("Legolas", 40, 150)

    def atacar(self, outro):
        if self.vida > 0:
            outro.vida -= self.forca
            print(f"{self.nome} atacou {outro.nome} com seu arco e causou {self.forca} de dano!")
        else:
            print(f"{self.nome} não pode atacar porque está morto!")


# ========== Exemplo de Uso ==========
if __name__ == "__main__":
    # Criando guerreiros
    guerreiro1 = Guerreiro("Guerreiro 1", forca=15, vida=100)
    guerreiro2 = Guerreiro("Guerreiro 2", forca=10, vida=80)
    
    # Criando arqueiros
    arqueiro1 = Arqueiro("Arqueiro 1", forca=20, vida=50)
    arqueiro2 = Arqueiro("Arqueiro 2", forca=25, vida=60)
    
    # Atacando entre guerreiros
    guerreiro1.atacar(guerreiro2)
    print(guerreiro2)
    print("")
    # Atacando entre arqueiros
    arqueiro1.atacar(arqueiro2)
    print(arqueiro2)
    print("")
    # Usando o singleton
    legolas1 = Legolas()
    arqueiro1.atacar(legolas1)
    legolas2 = Legolas()
    
    print(legolas1)
    print(legolas2)  # Deve ser a mesma instância que legolas1