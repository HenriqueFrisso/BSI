from kaijus import *
from jaegers import *

if __name__ == "__main__":
    gipsy = Jaeger("Gipsy Danger")
    kaiju1 = Kaiju("SLATTERN")

    print(gipsy.atacar(AtaquesJaeger.PUNHO_ENERGIZADO, kaiju1))
    print(kaiju1.atacar(AtaquesEspeciais.GARRAS, gipsy))
    print(gipsy.atacar(AtaquesJaeger.CANHAO_PLASMA, kaiju1))

    print("Bônus Jaeger:", gipsy.calcular_bonus())
    print("Bônus Kaiju:", kaiju1.calcular_bonus())
