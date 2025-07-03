package domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.*;

@Entity(name="produto_carrinho")
@AllArgsConstructor
public class ProdutoCarrinho implements Serializable{

    
    public ProdutoCarrinho(){}
    public ProdutoCarrinho(ProdutoCarrinhoId fk, int qtd) {
        this.fk = fk;
        this.qtd = qtd;
}
    
    public ProdutoCarrinhoId getFk() {
        return fk;
    }

    public void setFk(ProdutoCarrinhoId fk) {
        this.fk = fk;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
    @EmbeddedId
    private ProdutoCarrinhoId fk;
    @Column
    private int qtd;
    
}
