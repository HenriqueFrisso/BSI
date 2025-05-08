from abc import ABC, abstractmethod
from pratos import *

class Restaurante(ABC):

    @abstractmethod
    def pratoPrincipal(self):
        pass

    @abstractmethod
    def pratoFeito(self):
        pass

    def sobremesa(self):
        pass
    
#===================================================================
# Restaurantes Concretos
#===================================================================

class RestauranteA(Restaurante):

    def pratoPrincipal(self):
        return FileMignon()

    def pratoFeito(self):
        return PratoFeitoA()
    
    def sobremesa(self):
        return Pudim()

class RestauranteB(Restaurante):

    def pratoPrincipal(self):
        return LasanhaBolonhesa()

    def pratoFeito(self):
        return PratoFeitoB()

    def sobremesa(self):
        return None
    

class RestauranteC(Restaurante):

    def pratoPrincipal(self):
        raise NotImplementedError("pratoPrincipal()")

    def pratoFeito(self):
        return PratoFeitoC()

    def sobremesa(self):
        return Tiramisu()