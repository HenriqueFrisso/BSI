from abc import ABC, abstractmethod

class PratoPrincipal(ABC):
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

    @abstractmethod
    def comer(self) -> float:
        # Quantidade de nutrição do prato
        pass

class PratoFeito(ABC):
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

    @abstractmethod
    def comer(self) -> float:
        # Quantidade de nutrição do prato
        pass

class Sobremesa(ABC):
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
    
    @abstractmethod
    def comer(self) -> float:
        # Quantidade de nutrição do prato
        pass

#===================================================================
# Pratos Concretos
#===================================================================

class FileMignon(PratoPrincipal):
    def __str__(self):
        return "Filé mignon com arroz e legumes"
    def __call__(self):
        return "Filé mignon"
    def __float__(self):
        return 49.90
    def comer(self):
        return 0.5

class PratoFeitoA(PratoFeito):
    def __str__(self):
        return "Arroz, feijão, bife acebolado e batata frita"
    def __call__(self):
        return "Prato feito com bife acebolado"
    def __float__(self):
        return 29.90
    def comer(self):
        return 0.4

class Pudim(Sobremesa):
    def __str__(self):
        return "Pudim de leite condensado com calda de caramelo"
    def __call__(self):
        return "Pudim"
    def __float__(self):
        return 12.90
    def comer(self):
        return 0.2

class LasanhaBolonhesa(PratoPrincipal):
    def __str__(self):
        return "Lasanha à bolonhesa com queijo gratinado"
    def __call__(self):
        return "Lasanha à bolonhesa"
    def __float__(self):
        return 34.90
    def comer(self):
        return 0.6

class PratoFeitoB(PratoFeito):
    def __str__(self):
        return "Arroz, feijão, frango grelhado e salada"
    def __call__(self):
        return "Prato feito com frango"
    def __float__(self):
        return 27.90
    def comer(self):
        return 0.4

class MousseChocolate(Sobremesa):
    def __str__(self):
        return "Mousse de chocolate meio amargo"
    def __call__(self):
        return "Mousse de chocolate"
    def __float__(self):
        return 15.90
    def comer(self):
        return 0.3

class SalmaoGrelhado(PratoPrincipal):
    def __str__(self):
        return "Salmão grelhado com risoto de limão siciliano"
    def __call__(self):
        return "Salmão grelhado"
    def __float__(self):
        return 59.90
    def comer(self):
        return 0.7

class PratoFeitoC(PratoFeito):
    def __str__(self):
        return "Arroz integral, lentilha, peito de frango e legumes"
    def __call__(self):
        return "Prato feito saudável"
    def __float__(self):
        return 32.90
    def comer(self):
        return 0.5

class Tiramisu(Sobremesa):
    def __str__(self):
        return "Tiramisu com café e cacau em pó"
    def __call__(self):
        return "Tiramisu"
    def __float__(self):
        return 18.90
    def comer(self):
        return 0.4