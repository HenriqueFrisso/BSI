from abc import ABC, abstractmethod
from pratos import *

class Restaurante(ABC):

    @abstractmethod
    def criarPratoPrincipal(self) -> Prato:
        pass
    
#===================================================================
# Restaurantes Concretos
#===================================================================

class RestauranteA(Restaurante):

    def criarPratoPrincipal(self):
        return FileMignon()


class RestauranteB(Restaurante):

    def criarPratoPrincipal(self):
        return LasanhaBolonhesa()


class RestauranteC(Restaurante):

    def criarPratoPrincipal(self):
        return SalmaoGrelhado()
