from restaurantes import *

def prepararPrato(restaurante, prato):
    try:
        pratoPreparado = getattr(restaurante(), prato)()
    except AttributeError:
        print(f"Erro: O restaurante '{restaurante.__name__}' não possui o prato '{prato}'.")
    except NotImplementedError as e:
        print(f"Erro: O restaurante '{restaurante.__name__}' não implementou '{e}'.")
    else:
        if pratoPreparado is None:
            print(f"Erro: O prato '{prato}' não está disponível.")
            return None
        return pratoPreparado


if __name__ == '__main__':
    print("Factory Method Pattern")
    p1 = prepararPrato(RestauranteC, "pratoFeito")
    p2 = prepararPrato(RestauranteC, "pratoPrincipal")
    p3 = prepararPrato(RestauranteA, "sobremesa")
    print("")
    if p1:
        print(f"Prato feito: {p1()}, R$: {float(p1)}")
    if p2:
        print(f"Prato principal: {p2()}, R$: {p2.__float__()}")
    if p3:
        print(f"Sobremesa: {p3()}, R$: {p3.__float__()}")