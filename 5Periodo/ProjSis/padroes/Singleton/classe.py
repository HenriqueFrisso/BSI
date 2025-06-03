class Single:
    instancia = None

    def __new__(cls):
        if cls.instancia is None:
            cls.instancia = super().__new__(cls)
        return cls.instancia

    def mudarTexto(self, txt):
        self.texto = txt

    def __str__(self):
        return self.texto
