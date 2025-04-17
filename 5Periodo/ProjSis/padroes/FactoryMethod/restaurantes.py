from pratos import *

class Restaurante:
    def pratoPrincipal(self) -> str:
        raise NotImplementedError("pratoPrincipal().")

    def pratoFeito(self) -> str:
        raise NotImplementedError("pratoFeito().")

    def sobremesa(self) -> str:
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
