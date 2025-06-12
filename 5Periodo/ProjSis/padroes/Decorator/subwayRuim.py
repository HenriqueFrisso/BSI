class Sanduiche:
    def __init__(self, nome="Sanduíche", preco=5):
        self.nome = nome
        self.preco = preco

    def get_info(self):
        return self.nome, self.preco

    def __add__(self, outro):
        novo_nome = self.nome + " + " + outro.nome
        novo_preco = self.preco + outro.preco
        return Sanduiche(novo_nome, novo_preco)

    def __str__(self):
        return f"{self.nome} custa R${self.preco:.2f}"

base = Sanduiche()
pao = Sanduiche("Pão", 1)
presunto = Sanduiche("Presunto", 5)
queijo = Sanduiche("Queijo", 4)
alface = Sanduiche("Alface", 1)
tomate = Sanduiche("Tomate", 1.5)
ovo = Sanduiche("Ovo", 2)
maionese = Sanduiche("Maionese", 1)
bacon = Sanduiche("Bacon", 3)

meu_sanduiche = base + pao + presunto + queijo

print(meu_sanduiche)
