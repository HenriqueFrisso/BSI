package domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.*;


@AllArgsConstructor
@Embeddable
public class ProdutoCarrinhoId implements Serializable{

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }
    @ManyToOne
    @JoinColumn(name = "produtoId")
    private Produto produto;
    @ManyToOne
    @JoinColumn(name = "carrinhoId")
    private Carrinho carrinho;
}
