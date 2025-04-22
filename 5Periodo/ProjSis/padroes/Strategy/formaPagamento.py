from enum import IntEnum
from abc import ABC, abstractmethod

# Enum para formas de pagamento
class FormaPagamento(IntEnum):
    PIX = 1
    CARTAO_DEBITO = 2
    CARTAO_CREDITO = 3
    DINHEIRO = 4
    BOLETO = 5
    CHEQUE = 6

# Interface da estratégia
class EstrategiaTaxa(ABC):
    @abstractmethod
    def calcular_taxa(self) -> float:
        pass

# Estratégias concretas
class TaxaZero(EstrategiaTaxa):
    def calcular_taxa(self):
        return 0.0

class Taxa05(EstrategiaTaxa):
    def calcular_taxa(self):
        return 0.005
    
class Taxa1(EstrategiaTaxa):
    def calcular_taxa(self):
        return 0.01

class Taxa2(EstrategiaTaxa):
    def calcular_taxa(self):
        return 0.02

class Taxa3(EstrategiaTaxa):
    def calcular_taxa(self):
        return 0.03


# Mapeamento entre formas de pagamento e estratégias
estrategias_por_forma = {
    FormaPagamento.PIX: TaxaZero(),
    FormaPagamento.CARTAO_DEBITO: Taxa2(),
    FormaPagamento.CARTAO_CREDITO: Taxa3(),
    FormaPagamento.DINHEIRO: Taxa1(),
    FormaPagamento.BOLETO: Taxa05(),
    FormaPagamento.CHEQUE: Taxa1(),
}

# Contexto
class Pagamento:
    def __init__(self, forma: FormaPagamento):
        self.forma = forma
        self.estrategia = estrategias_por_forma[forma]

    def __str__(self):
        return f"Forma de pagamento: {self.forma.name} ({self.forma.value})"
    
    def taxa(self):
        return self.estrategia.calcular_taxa()

    def pagar(self, valor: float) -> float:
        taxa = self.taxa()
        return valor + (valor * taxa)
    