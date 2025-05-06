from random import randint
from magias import estrategias_por_magia, Magias

class ConjuradorBom:
    def __init__(self,inteligencia, concentracao, magia: Magias):
        self.inteligencia = inteligencia
        self.concentracao = concentracao
        self.magia = magia
        self.estrategia = estrategias_por_magia[magia]

    def __str__(self):
        (f"Magia utilizada: {self.magia.name}\n")
        self.estrategia.info(self.inteligencia, self.concentracao)
        return 
    
    def alterarMagia(self, magia: Magias):
        self.magia = magia
        self.estrategia = estrategias_por_magia[magia]
        print(f"Magia alterada para: {self.magia.name}\n")

    def atacar(self):
        dano, chance = self.estrategia.atacar(self.inteligencia, self.concentracao)
        print(f"Um ataque foi realizado com a magia {self.magia.name}!")
        if(randint(0,10000) <= (chance * 100)):
            print(f"Acertou! Dano causado: {dano}\n")
        else:
            dano = 0
            print(f"Errou a magia! Dano causado: {dano}\n")
        return dano
    
#================ Implementação do Conjurador sem o padrão Strategy ================
class ConjuradorRuim:
    def __init__(self, inteligencia, concentracao, magia: Magias):
        self.inteligencia = inteligencia
        self.concentracao = concentracao
        self.magia = magia

    def __str__(self):
        self.info()
        return f"Magia utilizada: {self.magia.name}\n"

    def alterar_magia(self, magia: Magias):
        self.magia = magia
        print(f"Magia alterada para: {self.magia.name}")
        self.info()

    def info(self):
        if self.magia == Magias.FOGO:
            dano = self.inteligencia * 2
            chance = self.concentracao * 0.7
        elif self.magia == Magias.GELO:
            dano = self.inteligencia * 1.5
            chance = self.concentracao * 0.7
        elif self.magia == Magias.VENENO:
            dano = self.inteligencia * 2.5
            chance = self.concentracao * 0.4
        elif self.magia == Magias.VENTO:
            dano = self.inteligencia * 1.7
            chance = self.concentracao * 0.6
        elif self.magia == Magias.TROVAO:
            dano = self.inteligencia * 0.9
            chance = self.concentracao * 1.2
        else:
            dano = 0
            chance = 0

        print(f"Dano ao acertar: {dano:.2f}")
        print(f"Chance de acertar: {chance:.2f} %")

    def atacar(self):
        if self.magia == Magias.FOGO:
            dano = self.inteligencia * 2
            chance = self.concentracao * 0.7
        elif self.magia == Magias.GELO:
            dano = self.inteligencia * 1.5
            chance = self.concentracao * 0.7
        elif self.magia == Magias.VENENO:
            dano = self.inteligencia * 2.5
            chance = self.concentracao * 0.4
        elif self.magia == Magias.VENTO:
            dano = self.inteligencia * 1.7
            chance = self.concentracao * 0.6
        elif self.magia == Magias.TROVAO:
            dano = self.inteligencia * 0.9
            chance = self.concentracao * 1.2
        else:
            dano = 0
            chance = 0

        if randint(0, 10000) <= (chance * 100):
            print(f"Acertou! Dano causado: {dano}")
        else:
            print("Errou a magia! Dano causado: 0")
            dano = 0

        return dano
