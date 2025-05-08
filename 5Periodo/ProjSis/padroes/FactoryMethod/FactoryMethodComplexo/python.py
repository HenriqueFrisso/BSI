"""
==================================
Factory Method
==================================
"""

from restaurantes import RestauranteB

try:
    restaurante = RestauranteB()
except TypeError as e:
    print(f"Erro: {e}")
else:
    print(f"Restaurante: {restaurante.__class__.__name__}")
    print(f"Prato feito: {restaurante.pratoFeito()}")
    print(f"Prato principal: {restaurante.pratoPrincipal()}")
    print(f"Sobremesa: {restaurante.sobremesa()}")
