from enum import IntEnum
from random import uniform

# ========== Enum com os tipos de magia ==========
class Magias(IntEnum):
    FOGO = 1
    GELO = 2
    VENENO = 3
    VENTO = 4
    TROVAO = 5

# ========== Funções de estratégia ==========
def bola_de_fogo(inteligencia, concentracao):
    return inteligencia * 2, concentracao * 0.7

def cristais_de_gelo(inteligencia, concentracao):
    return inteligencia * 1.5, concentracao * 0.7

def bomba_venenosa(inteligencia, concentracao):
    return inteligencia * 2.5, concentracao * 0.4

def tornado_da_furia(inteligencia, concentracao):
    return inteligencia * 1.7, concentracao * 0.6

def tempestade_de_trovao(inteligencia, concentracao):
    return inteligencia * 0.9, concentracao * 1.2

# Dicionário com as funções e informações
estrategias = {
    Magias.FOGO: ("Bola de Fogo", bola_de_fogo),
    Magias.GELO: ("Cristais de Gelo", cristais_de_gelo),
    Magias.VENENO: ("Bomba Venenosa", bomba_venenosa),
    Magias.VENTO: ("Tornado da Fúria", tornado_da_furia),
    Magias.TROVAO: ("Tempestade de Trovão", tempestade_de_trovao),
}

# ========== Conjurador com funções como estratégia ==========
class ConjuradorFuncional:
    def __init__(self, nome, inteligencia, concentracao, magia: Magias):
        self.nome = nome
        self.inteligencia = inteligencia
        self.concentracao = concentracao
        self.setMagia(magia)

    def setMagia(self, magia: Magias):
        self.magia = magia
        self.nome_magia, self.estrategia = estrategias[magia]
        print(f"({self.nome}) Magia selecionada: {self.nome_magia}")

    def atacar(self):
        print(f"\n({self.nome}) Conjurando {self.nome_magia}...")
        dano, chance = self.estrategia(self.inteligencia, self.concentracao)
        if uniform(0, 100) <= chance:
            print(f"Acertou! Dano causado: {dano:.2f}\n")
        else:
            print("Errou! Nenhum dano causado.\n")
            dano = 0
        return dano

    def infoMagia(self):
        print(f"\n--- Informações da Magia de {self.nome} ---")
        dano, chance = self.estrategia(self.inteligencia, self.concentracao)
        print(f"[{self.nome_magia}] Dano: {dano:.2f}, Chance: {chance:.2f}%")

    def __str__(self):
        return f"\n{self.nome} (Inteligência: {self.inteligencia}, Concentração: {self.concentracao}, Magia: {self.nome_magia})"


if __name__ == "__main__":
    mago = ConjuradorFuncional("Aeryn", 50, 80, Magias.FOGO)
    mago.infoMagia()
    mago.atacar()

    mago.setMagia(Magias.TROVAO)
    mago.infoMagia()
    mago.atacar()