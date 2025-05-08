from restaurantes import *

def prepararPrato(restaurante, prato):
    try:
        rest = restaurante()
        pratoPreparado = getattr(rest, prato)()
    except AttributeError:
        print(f"Erro: O restaurante '{restaurante.__name__}' não possui o prato '{prato}'.")
    except NotImplementedError as e:
        print(f"Erro: O restaurante '{restaurante.__name__}' não implementou '{e}'.")
    else:
        if pratoPreparado is None:
            print(f"Erro: O prato '{prato}' não está disponível.")
            return None
        return pratoPreparado

def comerPratos(caloria, prato):
    if prato:
        caloria += prato.comer()
        print(f"Comendo {prato.__class__.__name__}...")
        print(f"QuiloCalorias(kcal): {caloria:.2f}")
    return caloria

def imprimirPratos(prato):
    if prato:
        print(f"Prato: {prato.__class__.__name__}")
        print(f"Valor: R$ {float(prato):.2f}")
        print(f"QuiloCalorias(kcal): {prato.comer():.2f}")

def addDict(dict, prato):
    if prato:
        dict[prato.__class__.__bases__[0].__name__] = prato

if __name__ == '__main__':
    #====================================================================
    # Criando pratos
    prato1 = prepararPrato(RestauranteA, "pratoFeito")
    prato2 = prepararPrato(RestauranteB, "pratoPrincipal")
    prato3 = prepararPrato(RestauranteC, "sobremesa")
    print("")

    #====================================================================
    # Pratos criados
    if prato1:
        print(f"Prato feito: {prato1}, R$: {float(prato1):.2f}")
    if prato2:
        print(f"Prato principal: {prato2()}, R$: {(prato2.__float__()):.2f}")
    if prato3:
        print(f"Sobremesa: {prato3()}, R$: {(prato3.__float__()):.2f}")
    # imprimirPratos(prato1)
    # imprimirPratos(prato2)
    # imprimirPratos(prato3)
    print("")

    #====================================================================
    # Comendo pratos
    caloria = 0.0

    print("Comendo pratos...")
    caloria = comerPratos(caloria, prato1)
    caloria = comerPratos(caloria, prato2)
    caloria = comerPratos(caloria, prato3)
    print("")

    #====================================================================
    # Pratos criados em dicionário
    dict = {
    }
    addDict(dict, prato1)
    addDict(dict, prato2)
    addDict(dict, prato3)
    for chave, valor in dict.items():
        print(f"{chave}: {valor}")