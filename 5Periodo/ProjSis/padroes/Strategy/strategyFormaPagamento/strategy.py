from imports import *

pag1 = Pagamento(FormaPagamento.PIX)
pag2 = Pagamento(FormaPagamento.CARTAO_DEBITO)
pag3 = Pagamento(FormaPagamento.BOLETO)


print(pag1, "- Taxa:", pag1.taxa())
print(pag2, "- Taxa:", pag2.taxa())
print(pag3, "- Taxa:", pag3.taxa())
print("")
print(pag1, "- Valor a pagar com taxa:", pag1.pagar(100))
print(pag2, "- Valor a pagar com taxa:", pag2.pagar(100))
print(pag3, "- Valor a pagar com taxa:", pag3.pagar(100))
