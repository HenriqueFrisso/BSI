from restaurantes import *

if __name__ == '__main__':
    print("Factory Method Pattern")
    restaurante = RestauranteA()
    p1 = restaurante.criarPratoPrincipal()
    restaurante = RestauranteB()
    p2 = restaurante.criarPratoPrincipal()
    restaurante = RestauranteC()
    p3 = restaurante.criarPratoPrincipal()
    print("")
    
    if p1:
        print(f"Prato restaurante A: {p1.getNomePrato()}, R$ {(p1.getPreco()):.2f}")
    if p2:
        print(f"Prato restaurante B: {p2.getNomePrato()}, R$ {(p2.getPreco()):.2f}")
    if p3:
        print(f"Prato restaurante C: {p3.getNomePrato()}, R$ {(p3.getPreco()):.2f}")