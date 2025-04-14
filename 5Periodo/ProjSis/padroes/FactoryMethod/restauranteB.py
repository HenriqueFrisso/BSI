from menu import Menu
from pratos import LasanhaBolonhesa, PratoFeitoB, MousseChocolate

class RestauranteB(Menu):

    def pratoPrincipal(self):
        return LasanhaBolonhesa()

    def pratoFeito(self):
        return PratoFeitoB()

    def sobremesa(self):
        return MousseChocolate()
