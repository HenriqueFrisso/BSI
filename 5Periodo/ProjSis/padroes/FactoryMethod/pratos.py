class Prato:
    def __str__(self):
        return "Pratos do dia"

    def __call__(self):
        return "Pratos do dia"

#===================================================================
# Pratos Concretos
#===================================================================

class FileMignon(Prato):
    def __str__(self):
        return "Filé mignon com arroz e legumes"
    def __call__(self):
        return "Filé mignon"

class PratoFeitoA(Prato):
    def __str__(self):
        return "Arroz, feijão, bife acebolado e batata frita"
    def __call__(self):
        return "Prato feito com bife acebolado"

class Pudim(Prato):
    def __str__(self):
        return "Pudim de leite condensado com calda de caramelo"
    def __call__(self):
        return "Pudim"

class LasanhaBolonhesa(Prato):
    def __str__(self):
        return "Lasanha à bolonhesa com queijo gratinado"
    def __call__(self):
        return "Lasanha à bolonhesa"

class PratoFeitoB(Prato):
    def __str__(self):
        return "Arroz, feijão, frango grelhado e salada"
    def __call__(self):
        return "Prato feito com frango"

class MousseChocolate(Prato):
    def __str__(self):
        return "Mousse de chocolate meio amargo"
    def __call__(self):
        return "Mousse de chocolate"

class SalmaoGrelhado(Prato):
    def __str__(self):
        return "Salmão grelhado com risoto de limão siciliano"
    def __call__(self):
        return "Salmão grelhado"

class PratoFeitoC(Prato):
    def __str__(self):
        return "Arroz integral, lentilha, peito de frango e legumes"
    def __call__(self):
        return "Prato feito saudável"

class Tiramisu(Prato):
    def __str__(self):
        return "Tiramisu com café e cacau em pó"
    def __call__(self):
        return "Tiramisu"