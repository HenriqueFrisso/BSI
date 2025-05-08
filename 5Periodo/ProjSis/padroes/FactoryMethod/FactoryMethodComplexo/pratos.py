from abc import ABC, abstractmethod

class Prato(ABC):

    @abstractmethod
    def __str__(self) -> str:
        # Descrição do prato
        pass

    @abstractmethod
    def __call__(self) -> str:
        # Nome do prato
        pass

    @abstractmethod
    def __float__(self) -> float:
        # Preço do prato
        pass

#===================================================================
# Pratos Concretos
#===================================================================

class FileMignon(Prato):
    def __str__(self):
        return "Filé mignon com arroz e legumes"
    def __call__(self):
        return "Filé mignon"
    def __float__(self):
        return 49.90

class PratoFeitoA(Prato):
    def __str__(self):
        return "Arroz, feijão, bife acebolado e batata frita"
    def __call__(self):
        return "Prato feito com bife acebolado"
    def __float__(self):
        return 29.90

class Pudim(Prato):
    def __str__(self):
        return "Pudim de leite condensado com calda de caramelo"
    def __call__(self):
        return "Pudim"
    def __float__(self):
        return 12.90

class LasanhaBolonhesa(Prato):
    def __str__(self):
        return "Lasanha à bolonhesa com queijo gratinado"
    def __call__(self):
        return "Lasanha à bolonhesa"
    def __float__(self):
        return 34.90

class PratoFeitoB(Prato):
    def __str__(self):
        return "Arroz, feijão, frango grelhado e salada"
    def __call__(self):
        return "Prato feito com frango"
    def __float__(self):
        return 27.90

class MousseChocolate(Prato):
    def __str__(self):
        return "Mousse de chocolate meio amargo"
    def __call__(self):
        return "Mousse de chocolate"
    def __float__(self):
        return 15.90

class SalmaoGrelhado(Prato):
    def __str__(self):
        return "Salmão grelhado com risoto de limão siciliano"
    def __call__(self):
        return "Salmão grelhado"
    def __float__(self):
        return 59.90

class PratoFeitoC(Prato):
    def __str__(self):
        return "Arroz integral, lentilha, peito de frango e legumes"
    def __call__(self):
        return "Prato feito saudável"
    def __float__(self):
        return 32.90

class Tiramisu(Prato):
    def __str__(self):
        return "Tiramisu com café e cacau em pó"
    def __call__(self):
        return "Tiramisu"
    def __float__(self):
        return 18.90