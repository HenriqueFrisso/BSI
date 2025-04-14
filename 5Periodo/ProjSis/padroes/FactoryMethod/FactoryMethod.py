from imports import *

def prepararPrato(restaurante, prato):
    try:
        pratoPreparado = getattr(restaurante(), prato)()
    except AttributeError:
        print(f"Erro: O restaurante '{restaurante.__name__}' não possui o prato '{prato}'.")
    except NotImplementedError as e:
        print(f"Erro: O restaurante '{restaurante.__name__}' não implementou '{e}'.")
    else:
        return pratoPreparado


if __name__ == '__main__':
    print("Factory Method Pattern")
    p1 = prepararPrato(RestauranteB, "pratoFeito")
    p2 = prepararPrato(RestauranteA, "pratoPrincipal")
    p3 = prepararPrato(RestauranteA, "sobremesa")
    print("")
    if p1:
        print(f"Prato feito: {p1()}")
    if p2:
        print(f"Prato principal: {p2()}")
    if p3:
        print(f"Sobremesa: {p3()}")