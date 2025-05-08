from restaurantes import *

def prepararPrato(restaurante, prato):
    try:
        pratoPreparado = getattr(restaurante(), prato)()
    except AttributeError:
        print(f"Erro: O restaurante '{restaurante.__name__}' não possui o método '{prato}'.")
    else:
        return pratoPreparado


if __name__ == '__main__':
    print("Factory Method Pattern")
    p1 = prepararPrato(RestauranteA, "criarPratoPrincipal")
    p2 = prepararPrato(RestauranteB, "criarPratoPrincipal")
    p3 = prepararPrato(RestauranteC, "criarPratoPrincipal")
    print("")
    if p1:
        print(f"Prato restaurante A: {p1.getNomePrato()}, R$ {(p1.getPreco()):.2f}")
    if p2:
        print(f"Prato restaurante B: {p2.getNomePrato()}, R$ {(p2.getPreco()):.2f}")
    if p3:
        print(f"Prato restaurante C: {p3.getNomePrato()}, R$ {(p3.getPreco()):.2f}")