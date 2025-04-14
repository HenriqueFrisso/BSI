from menu import Menu
from pratos import FileMignon, PratoFeitoA

class RestauranteA(Menu):

    def pratoPrincipal(self):
        return FileMignon()

    def pratoFeito(self):
        return PratoFeitoA()
