from enum import Enum, auto
from random import uniform

# === Enum de Ataques Jaeger ===
class AtaquesJaeger(Enum):
    PUNHO_ENERGIZADO = auto()
    CANHAO_PLASMA = auto()
    RAMPA_DE_ENERGIA = auto()

# === Funções de ataque Jaeger ===
def ataque_punho_energizado(atacante, alvo):
    dano = round(uniform(85, 125), 2)
    alvo.atacado(dano)
    return f"{atacante} desfere um punho energizado contra {alvo}! Dano: {dano}"

def ataque_canhao_plasma(atacante, alvo):
    dano = round(uniform(95, 135), 2)
    alvo.atacado(dano)
    return f"{atacante} dispara o canhão de plasma em {alvo}! Dano: {dano}"

def ataque_rampa_de_energia(atacante, alvo):
    dano = round(uniform(80, 115), 2)
    alvo.atacado(dano)
    return f"{atacante} utiliza a rampa de energia para atacar {alvo}! Dano: {dano}"

# === Dicionário de ataques Jaeger ===
ataques_jaeger = {
    AtaquesJaeger.PUNHO_ENERGIZADO: ("Punho Energizado", ataque_punho_energizado),
    AtaquesJaeger.CANHAO_PLASMA: ("Canhão de Plasma", ataque_canhao_plasma),
    AtaquesJaeger.RAMPA_DE_ENERGIA: ("Rampa de Energia", ataque_rampa_de_energia),
}

# === Atualizando a classe Jaeger para usar os ataques Jaeger ===
class Jaeger:
    def __init__(self, nome: str,
                 forca: int = 70,
                 durabilidade: int = 80,
                 inteligencia: int = 80,
                 agressividade: int = 70):
        self.nome = nome
        self.forca = forca
        self.durabilidade = durabilidade
        self.inteligencia = inteligencia
        self.agressividade = agressividade
        self.vida = 100
        self.ativo = True

    def atacar(self, ataque_enum: AtaquesJaeger, alvo) -> str:
        if not self.ativo:
            return f"{self} está incapacitado e não pode atacar."
        if ataque_enum not in ataques_jaeger:
            return f"{self} não conhece esse ataque!"
        _, ataque_func = ataques_jaeger[ataque_enum]
        return ataque_func(self, alvo)
    
    def __str__(self):
        return self.nome
    
    def atacado(self, dano: float):
        self.vida -= dano / (self.durabilidade / 100)
        if self.vida <= 0:
            self.vida = 0
            self.ativo = False
        return self.vida

    def calcular_bonus(self):
        bonus_inteligencia = self.inteligencia * 1.8
        bonus_agressividade = self.agressividade * 0.9
        return bonus_inteligencia, bonus_agressividade
