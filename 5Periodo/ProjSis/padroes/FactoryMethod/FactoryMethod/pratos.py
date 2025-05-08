from abc import ABC, abstractmethod

class Prato(ABC):

    @abstractmethod
    def getDescricao(self) -> str:
        # Descrição do prato
        pass

    @abstractmethod
    def getNomePrato(self) -> str:
        # Nome do prato
        pass

    @abstractmethod
    def getPreco(self) -> float:
        # Preço do prato
        pass

#===================================================================
# Pratos Concretos
#===================================================================

class FileMignon(Prato):
    def getDescricao(self):
        return "Filé mignon com arroz e legumes"
    def getNomePrato(self):
        return "Filé mignon"
    def getPreco(self):
        return 49.90

class LasanhaBolonhesa(Prato):
    def getDescricao(self):
        return "Lasanha à bolonhesa com queijo gratinado"
    def getNomePrato(self):
        return "Lasanha à bolonhesa"
    def getPreco(self):
        return 34.90
    
class SalmaoGrelhado(Prato):
    def getDescricao(self):
        return "Salmão grelhado com risoto de limão siciliano"
    def getNomePrato(self):
        return "Salmão grelhado"
    def getPreco(self):
        return 59.90