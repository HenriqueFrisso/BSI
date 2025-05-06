from random import randint
from enum import IntEnum
from magias import *

# ========== Enum com os tipos de magia ==========
class Magias(IntEnum):
    FOGO = 1
    GELO = 2
    VENENO = 3
    VENTO = 4
    TROVAO = 5

# ========== Contexto que usa o Strategy ==========
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
        if randint(0, 10000) <= chance * 100:
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
    