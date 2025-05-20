package com.mycompany.trabalhopoo;

import java.util.List;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;


@Entity(name="produto")
@Data
@AllArgsConstructor
public class Produto {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @Column
    private double preco;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lojaId")
    private Loja loja;
    @OneToMany(mappedBy = "fk.produto")
    private List<ProdutoCarrinho> listaProdutosCarrinho;
    
}
