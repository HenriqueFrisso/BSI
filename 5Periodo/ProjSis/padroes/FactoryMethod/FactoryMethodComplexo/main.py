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

def comerPratos(nutricao, prato):
    if prato:
        nutricao += prato.comer()
        print(f"Comendo {prato.__class__.__name__}...")
        print(f"Nutrição: {nutricao:.2f}")
    return nutricao

def imprimirPratos(prato):
    if prato:
        print(f"Prato: {prato.__class__.__name__}")
        print(f"Valor: R$ {float(prato):.2f}")
        print(f"Nutrição: {prato.comer():.2f}")

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
    nutricao = 0.0

    print("Comendo pratos...")
    nutricao = comerPratos(nutricao, prato1)
    nutricao = comerPratos(nutricao, prato2)
    nutricao = comerPratos(nutricao, prato3)
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