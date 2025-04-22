from abc import ABC, abstractmethod
from pratos import *

class Restaurante(ABC):

    @abstractmethod
    def pratoPrincipal(self) -> Prato:
        pass

    @abstractmethod
    def pratoFeito(self) -> Prato:
        pass

    def sobremesa(self) -> Prato:
        raise NotImplementedError("sobremesa().")
    
#===================================================================
# Restaurantes Concretos
#===================================================================

class RestauranteA(Restaurante):

    def pratoPrincipal(self):
        return FileMignon()

    def pratoFeito(self):
        return PratoFeitoA()


class RestauranteB(Restaurante):

    def pratoPrincipal(self):
        return LasanhaBolonhesa()

    def pratoFeito(self):
        return PratoFeitoB()

    def sobremesa(self):
        return MousseChocolate()
    

class RestauranteC(Restaurante):

    def pratoPrincipal(self):
        raise NotImplementedError("pratoPrincipal().")

    def pratoFeito(self):
        return PratoFeitoC()

    def sobremesa(self):
        return Tiramisu()