from abc import ABC, abstractmethod

# ========== Interface da estratégia ==========
class Magia(ABC):
    @abstractmethod
    def atacar(self, inteligencia, concentracao):
        pass

    @abstractmethod
    def info(self, inteligencia, concentracao):
        pass

# ========== Estratégias concretas ==========
class BolaDeFogo(Magia):
    def atacar(self, inteligencia, concentracao):
        return (inteligencia * 2, concentracao * 0.7)

    def info(self, inteligencia, concentracao):
        print(f"[Bola de Fogo] Dano: {inteligencia * 2:.2f}, Chance: {concentracao * 0.7:.2f}%")

class CristaisDeGelo(Magia):
    def atacar(self, inteligencia, concentracao):
        return (inteligencia * 1.5, concentracao * 0.7)

    def info(self, inteligencia, concentracao):
        print(f"[Cristais de Gelo] Dano: {inteligencia * 1.5:.2f}, Chance: {concentracao * 0.7:.2f}%")

class BombaVenenosa(Magia):
    def atacar(self, inteligencia, concentracao):
        return (inteligencia * 2.5, concentracao * 0.4)

    def info(self, inteligencia, concentracao):
        print(f"[Bomba Venenosa] Dano: {inteligencia * 2.5:.2f}, Chance: {concentracao * 0.4:.2f}%")

class TornadoDaFuria(Magia):
    def atacar(self, inteligencia, concentracao):
        return (inteligencia * 1.7, concentracao * 0.6)

    def info(self, inteligencia, concentracao):
        print(f"[Tornado da Fúria] Dano: {inteligencia * 1.7:.2f}, Chance: {concentracao * 0.6:.2f}%")

class TempestadeDeTrovao(Magia):
    def atacar(self, inteligencia, concentracao):
        return (inteligencia * 0.9, concentracao * 1.2)

    def info(self, inteligencia, concentracao):
        print(f"[Tempestade de Trovão] Dano: {inteligencia * 0.9:.2f}, Chance: {concentracao * 1.2:.2f}%")
