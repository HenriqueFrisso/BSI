package com.mycompany.trabalhopoo;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;


@Entity(name="carrinho")
@Data
public class Carrinho {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Date dataPedido;
    @Column
    private int precoTotal;
    @OneToMany(mappedBy = "fk.carrinho")
    private List<ProdutoCarrinho> listaProdutosCarrinho;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usurioId")
    private Usuario usuario;

}
