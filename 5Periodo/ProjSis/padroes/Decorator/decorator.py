"""
Python oferece suporte nativo a decoradores,
que são funções que podem modificar o comportamento de outras funções ou métodos. 
Decoradores são frequentemente usados para adicionar funcionalidades a funções existentes, 
como autenticação, registro de logs, verificação de permissões, entre outros.

# Para usar um decorador, você simplesmente o aplica a uma função usando o símbolo "@" antes da definição da função.
# Isso é equivalente a passar a função para o decorador como argumento.

"""

def decoratorIterator(func):
    def interna(*args):
        print("Iteradores originais:")
        for arg in args:
            print(f"Argumento: {arg}")
        print("")
        print("Iteradores modificados:")
        for arg in args:
            print(f"Invertido: {func(arg)}")
    return interna

def inverter(iterador):
    return iterador[::-1]

inverterDecorada = decoratorIterator(inverter)

inverterDecorada("Python", "Java", "C++", "JavaScript", "PHP")