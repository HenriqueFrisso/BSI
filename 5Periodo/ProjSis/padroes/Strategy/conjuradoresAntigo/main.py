from imports import *

if __name__ == "__main__":
    Conjurador1 = ConjuradorBom(45, 100, Magias.GELO)
    Conjurador2 = ConjuradorBom(95, 46, Magias.TROVAO)
    Conjurador3 = ConjuradorBom(48, 95, Magias.VENENO)
    Conjurador4 = ConjuradorBom(65, 84, Magias.FOGO)
    Conjurador5 = ConjuradorBom(60, 86, Magias.VENTO)


    print(Conjurador2)
    Conjurador2.atacar()
    Conjurador2.setMagia(Magias.GELO)
    print(Conjurador2)
    Conjurador2.atacar()