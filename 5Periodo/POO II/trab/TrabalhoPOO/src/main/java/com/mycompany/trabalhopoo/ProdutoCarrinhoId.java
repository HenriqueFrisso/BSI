package com.mycompany.trabalhopoo;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Embeddable
public class ProdutoCarrinhoId {
    @ManyToOne
    @JoinColumn(name = "produtoId")
    private Produto produto;
    @ManyToOne
    @JoinColumn(name = "carrinhoId")
    private Carrinho carrinho;
}
