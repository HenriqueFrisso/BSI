class Single:
    instancia = None
    texto = " aa "

    def __new__(cls):
        if cls.instancia is None:
            cls.instancia = super().__new__(cls)
        return cls.instancia

    def mudarTexto(self, txt):
        self.texto = txt

    def __str__(self):
        return self.texto

a = Single()
a.mudarTexto("a")
print(a)

b = Single()
b.mudarTexto("b")
print(a)
print(b)  # Deve imprimir "teste", pois é a mesma instância
