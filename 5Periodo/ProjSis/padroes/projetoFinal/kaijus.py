from enum import IntEnum, Enum, auto
from random import uniform


# ========== Enum de Categorias ==========
class CategoriaKaiju(IntEnum):
    DESCONHECIDA = 0
    I = 1
    II = 2
    III = 3
    IV = 4
    V = 5

# ========== Estratégias por categoria ==========
def estrategia_categoria_I(kaiju):
    return kaiju["inteligencia"] * 2, kaiju["agressividade"] * 0.7

def estrategia_categoria_II(kaiju):
    return kaiju["inteligencia"] * 1.5, kaiju["agressividade"] * 0.7

def estrategia_categoria_III(kaiju):
    return kaiju["inteligencia"] * 2.5, kaiju["agressividade"] * 0.4

def estrategia_categoria_IV(kaiju):
    return kaiju["inteligencia"] * 1.7, kaiju["agressividade"] * 0.6

def estrategia_categoria_V(kaiju):
    return kaiju["inteligencia"] * 0.9, kaiju["agressividade"] * 1.2

def estrategia_desconhecida(kaiju):
    return 0, 0

# ========== Dicionário de estratégias ==========
estrategias_categoria = {
    CategoriaKaiju.DESCONHECIDA: estrategia_desconhecida,
    CategoriaKaiju.I: estrategia_categoria_I,
    CategoriaKaiju.II: estrategia_categoria_II,
    CategoriaKaiju.III: estrategia_categoria_III,
    CategoriaKaiju.IV: estrategia_categoria_IV,
    CategoriaKaiju.V: estrategia_categoria_V,
}


# ========== Enum de Ataques Especiais ==========
class AtaquesEspeciais(Enum):
    GARRAS = auto()
    ÁCIDO = auto()
    EXPLOSIVO = auto()

# ========== Funções de Ataque ==========
def ataque_garras(atacante, alvo):
    dano = round(uniform(80, 120), 2)
    alvo.atacado(dano)
    return f"{atacante} dilacera {alvo} com suas garras! Dano: {dano}"

def ataque_acido(atacante, alvo):
    dano = round(uniform(90, 130), 2)
    alvo.atacado(dano)
    return f"{atacante} cospe ácido em {alvo}! Dano: {dano}"

def ataque_explosivo(atacante, alvo):
    dano = round(uniform(100, 140), 2)
    alvo.atacado(dano)
    return f"{atacante} se lança em uma explosão corporal contra {alvo}! Dano: {dano}"


# ========== Dicionário de Ataques ==========
ataques_especiais = {
    AtaquesEspeciais.GARRAS: ("Garras Cortantes", ataque_garras),
    AtaquesEspeciais.ÁCIDO: ("Cuspe Ácido", ataque_acido),
    AtaquesEspeciais.EXPLOSIVO: ("Explosão Interna", ataque_explosivo),
}


# ========== Dicionário de Kaijus ==========
kaijus = {
    "RAIJU": {
        "categoria": CategoriaKaiju.IV,
        "forca": 85,
        "durabilidade": 70,
        "inteligencia": 65,
        "agressividade": 90
    },
    "SLATTERN": {
        "categoria": CategoriaKaiju.V,
        "forca": 95,
        "durabilidade": 100,
        "inteligencia": 75,
        "agressividade": 85
    },
    "OTACHI": {
        "categoria": CategoriaKaiju.IV,
        "forca": 80,
        "durabilidade": 65,
        "inteligencia": 70,
        "agressividade": 88
    },
    "KNIFEHEAD": {
        "categoria": CategoriaKaiju.III,
        "forca": 78,
        "durabilidade": 60,
        "inteligencia": 60,
        "agressividade": 80
    },
}


# ========== Classe Kaiju ==========
class Kaiju:
    def __init__(self, nome: str, 
                 categoria: CategoriaKaiju = None,
                 forca: int = None,
                 durabilidade: int = None,
                 inteligencia: int = None,
                 agressividade: int = None):
        self.nome = nome
        if nome in kaijus:
            dados = kaijus[nome]
            self.categoria = dados["categoria"]
            self.forca = dados["forca"]
            self.durabilidade = dados["durabilidade"]
            self.inteligencia = dados["inteligencia"]
            self.agressividade = dados["agressividade"]
        else:
            self.categoria = categoria if categoria is not None else CategoriaKaiju.DESCONHECIDA
            self.forca = forca if forca is not None else 50
            self.durabilidade = durabilidade if durabilidade is not None else 50
            self.inteligencia = inteligencia if inteligencia is not None else 50
            self.agressividade = agressividade if agressividade is not None else 50

        self.estrategia = estrategias_categoria[self.categoria]
        self.vida = 100
        self.ativo = True  # <-- atributo para controlar se está vivo/ativo

    def calcular_bonus(self):
        return self.estrategia({
            "forca": self.forca,
            "durabilidade": self.durabilidade,
            "inteligencia": self.inteligencia,
            "agressividade": self.agressividade
        })

    def atacar(self, ataque_enum: AtaquesEspeciais, alvo) -> str:
        if not self.ativo:
            return f"{self} está incapacitado e não pode atacar."
        if ataque_enum not in ataques_especiais:
            return f"{self} não conhece esse ataque!"
        _, ataque_func = ataques_especiais[ataque_enum]
        return ataque_func(self, alvo)
    
    def __str__(self):
        return self.nome
    
    def atacado(self, dano: float):
        self.vida -= dano/(self.durabilidade/100)
        if self.vida <= 0:
            self.vida = 0
            self.ativo = False  # <-- marca como inativo
        return self.vida

# ========== Exemplo de Uso ==========
if __name__ == "__main__":
    # Kaiju conhecido
    slattern = Kaiju("SLATTERN")
    print(slattern.atacar(AtaquesEspeciais.GARRAS, "Gipsy Danger"))
    print("Bônus:", slattern.calcular_bonus())

    # Kaiju desconhecido
    misterioso = Kaiju("KRAKENX")
    print(misterioso.atacar(AtaquesEspeciais.EXPLOSIVO, "Striker Eureka"))
    print("Bônus:", misterioso.calcular_bonus())
