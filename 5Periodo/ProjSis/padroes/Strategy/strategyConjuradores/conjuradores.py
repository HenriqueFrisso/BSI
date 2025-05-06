from random import uniform
from enum import IntEnum
from magias import *

# ========== Enum com os tipos de magia ==========
class Magias(IntEnum):
    FOGO = 1
    GELO = 2
    VENENO = 3
    VENTO = 4
    TROVAO = 5

# ========== Conjurador que usa o Strategy ==========
class ConjuradorBom:
    def __init__(self, nome, inteligencia, concentracao, magia: Magias):
        self.nome = nome
        self.inteligencia = inteligencia
        self.concentracao = concentracao
        self._estrategias = {
            Magias.FOGO: BolaDeFogo(),
            Magias.GELO: CristaisDeGelo(),
            Magias.VENENO: BombaVenenosa(),
            Magias.VENTO: TornadoDaFuria(),
            Magias.TROVAO: TempestadeDeTrovao(),
        }
        self.setMagia(magia)

    def setMagia(self, magia: Magias):
        self.magia = magia
        self.estrategia = self._estrategias[magia]
        print(f"({self.nome}) Magia selecionada: {self.magia.name}")

    def atacar(self):
        dano, chance = self.estrategia.atacar(self.inteligencia, self.concentracao)
        print(f"\n({self.nome}) Conjurando {self.magia.name}...")
        if uniform(0, 100) <= chance:
            print(f"Acertou! Dano causado: {dano:.2f}\n")
        else:
            print("Errou! Nenhum dano causado.\n")
            dano = 0
        return dano

    def infoMagia(self):
        print(f"\n--- Informações da Magia de {self.nome} ---")
        self.estrategia.info(self.inteligencia, self.concentracao)

    def __str__(self):
        return f"\n{self.nome} (Inteligência: {self.inteligencia}, Concentração: {self.concentracao}, Magia: {self.magia.name})"
    

# ========== Conjurador que não usa o Strategy ==========
class ConjuradorRuim:
    def __init__(self, nome, inteligencia, concentracao, magia: Magias):
        self.nome = nome
        self.inteligencia = inteligencia
        self.concentracao = concentracao
        self.setMagia(magia)

    def setMagia(self, magia: Magias):
        self.magia = magia
        print(f"({self.nome}) Magia selecionada: {self.magia.name}")

    def atacar(self):
        print(f"\n({self.nome}) Conjurando {self.magia.name}...")

        if self.magia == Magias.FOGO:
            nome_magia = "Bola de Fogo"
            dano = self.inteligencia * 2
            chance = self.concentracao * 0.7
        elif self.magia == Magias.GELO:
            nome_magia = "Cristais de Gelo"
            dano = self.inteligencia * 1.5
            chance = self.concentracao * 0.7
        elif self.magia == Magias.VENENO:
            nome_magia = "Bomba Venenosa"
            dano = self.inteligencia * 2.5
            chance = self.concentracao * 0.4
        elif self.magia == Magias.VENTO:
            nome_magia = "Tornado da Fúria"
            dano = self.inteligencia * 1.7
            chance = self.concentracao * 0.6
        elif self.magia == Magias.TROVAO:
            nome_magia = "Tempestade de Trovão"
            dano = self.inteligencia * 0.9
            chance = self.concentracao * 1.2
        else:
            nome_magia = "Desconhecida"
            dano = 0
            chance = 0

        if uniform(0, 100) <= chance:
            print(f"[{nome_magia}] Acertou! Dano causado: {dano:.2f}\n")
        else:
            print(f"[{nome_magia}] Errou! Nenhum dano causado.\n")
            dano = 0
        return dano

    def infoMagia(self):
        print(f"\n--- Informações da Magia de {self.nome} ---")

        if self.magia == Magias.FOGO:
            nome_magia = "Bola de Fogo"
            dano = self.inteligencia * 2
            chance = self.concentracao * 0.7
        elif self.magia == Magias.GELO:
            nome_magia = "Cristais de Gelo"
            dano = self.inteligencia * 1.5
            chance = self.concentracao * 0.7
        elif self.magia == Magias.VENENO:
            nome_magia = "Bomba Venenosa"
            dano = self.inteligencia * 2.5
            chance = self.concentracao * 0.4
        elif self.magia == Magias.VENTO:
            nome_magia = "Tornado da Fúria"
            dano = self.inteligencia * 1.7
            chance = self.concentracao * 0.6
        elif self.magia == Magias.TROVAO:
            nome_magia = "Tempestade de Trovão"
            dano = self.inteligencia * 0.9
            chance = self.concentracao * 1.2
        else:
            nome_magia = "Desconhecida"
            dano = 0
            chance = 0

        print(f"[{nome_magia}] Dano: {dano:.2f}, Chance: {chance:.2f}%")

    def __str__(self):
        return f"\n{self.nome} (Inteligência: {self.inteligencia}, Concentração: {self.concentracao}, Magia: {self.magia.name})"
