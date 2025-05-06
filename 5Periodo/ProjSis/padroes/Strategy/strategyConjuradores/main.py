from conjuradores import *

if __name__ == "__main__":
    Conjurador1 = ConjuradorBom("Conjurador1", 45, 100, Magias.GELO)
    Conjurador2 = ConjuradorRuim("Conjurador2", 95, 46, Magias.TROVAO)
    Conjurador3 = ConjuradorBom("Conjurador3", 48, 95, Magias.VENENO)
    Conjurador4 = ConjuradorBom("Conjurador4", 65, 84, Magias.FOGO)
    Conjurador5 = ConjuradorBom("Conjurador5", 60, 86, Magias.VENTO)
    Conjurador6 = ConjuradorBom("Conjurador6", 89, 72, Magias.TROVAO)


    print(Conjurador2)
    Conjurador2.infoMagia()
    Conjurador6.infoMagia()
    Conjurador2.atacar()