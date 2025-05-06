from enum import IntEnum
from abc import ABC, abstractmethod

# ================== Interface da estratégia ==================
class Magia(ABC):
    @abstractmethod
    def atacar(self, inteligencia, concentracao):
        pass
    @abstractmethod
    def info(self, inteligencia, concentracao):
        pass

# ================== Implementações concretas da estratégia ==================
class BolaDeFogo(Magia):
    def atacar(self, inteligencia, concentracao):
        return ((inteligencia * 2), (concentracao * 0.7))

    def info(self, inteligencia, concentracao):
        print(f"Dano ao acertar: {inteligencia * 2:.2f}")
        print(f"Chance de acertar: {concentracao * 0.7:.2f} %")

#=====================================
class CristaisDeGelo(Magia):
    def atacar(self, inteligencia, concentracao):
        return ((inteligencia * 1.5), (concentracao * 0.7))

    def info(self, inteligencia, concentracao):
        print(f"Dano ao acertar: {inteligencia * 1.5:.2f}")
        print(f"Chance de acertar: {concentracao * 0.7:.2f} %")

#=====================================
class BombaVenenosa(Magia):
    def atacar(self, inteligencia, concentracao):
        return ((inteligencia * 2.5), (concentracao * 0.4))

    def info(self, inteligencia, concentracao):
        print(f"Dano ao acertar: {inteligencia * 2.5:.2f}")
        print(f"Chance de acertar: {concentracao * 0.4:.2f} %")

#=====================================
class TornadoDaFuria(Magia):
    def atacar(self, inteligencia, concentracao):
        return ((inteligencia * 1.7), (concentracao * 0.6))

    def info(self, inteligencia, concentracao):
        print(f"Dano ao acertar: {inteligencia * 1.7:.2f}")
        print(f"Chance de acertar: {concentracao * 0.6:.2f} %")

#=====================================
class TempestadeDeTrovao(Magia):
    def atacar(self, inteligencia, concentracao):
        return ((inteligencia * 0.9), (concentracao * 1.2))

    def info(self, inteligencia, concentracao):
        print(f"Dano ao acertar: {inteligencia * 0.9:.2f}")
        print(f"Chance de acertar: {concentracao * 1.2:.2f} %")


# Contexto da estratégia
class Magias(IntEnum):
    FOGO = 1
    GELO = 2
    VENENO = 3
    VENTO = 4
    TROVAO = 5

# Mapeamento de estratégias para magias
estrategias_por_magia = {
    Magias.FOGO: BolaDeFogo(),
    Magias.GELO: CristaisDeGelo(),
    Magias.VENENO: BombaVenenosa(),
    Magias.VENTO: TornadoDaFuria(),
    Magias.TROVAO: TempestadeDeTrovao(),
}