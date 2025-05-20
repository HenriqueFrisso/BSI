package com.mycompany.trabalhopoo;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity(name="produto_carrinho")
@Data
@AllArgsConstructor
public class ProdutoCarrinho {
    @EmbeddedId
    private ProdutoCarrinhoId fk;
    @Column
    private int qtd;
    
}
