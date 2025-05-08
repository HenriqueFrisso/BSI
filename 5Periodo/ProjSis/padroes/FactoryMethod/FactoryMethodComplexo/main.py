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
    nutricao += prato.comer()
    print(f"Comendo {prato.__class__.__name__}...")
    print(f"Nutrição: {nutricao:.2f}")
    return nutricao

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
    print("")

    #====================================================================
    # Comendo pratos
    print("Comendo pratos...")
    nutricao = 0.0
    if prato1:
        nutricao = comerPratos(nutricao, prato1)
    if prato2:
        nutricao = comerPratos(nutricao, prato2)
    if prato3:
        nutricao = comerPratos(nutricao, prato3)
    print("")

    #====================================================================
    # Pratos criados em dicionário
    dict = {
        prato1.__class__.__bases__[0].__name__: prato1,
        prato2.__class__.__bases__[0].__name__: prato2,
        prato3.__class__.__bases__[0].__name__: prato3
    }
    for chave, valor in dict.items():
        print(f"{chave}: {valor}")