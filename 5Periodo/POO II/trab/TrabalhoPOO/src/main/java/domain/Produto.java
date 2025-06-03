package domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.*;


@Entity(name="produto")
@AllArgsConstructor
public class Produto implements Serializable{

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(double qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public List<ProdutoCarrinho> getListaProdutosCarrinho() {
        return listaProdutosCarrinho;
    }

    public void setListaProdutosCarrinho(List<ProdutoCarrinho> listaProdutosCarrinho) {
        this.listaProdutosCarrinho = listaProdutosCarrinho;
    }
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @Column
    private double preco;
    @Column
    private double qtdEstoque;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lojaId")
    private Loja loja;
    @OneToMany(mappedBy = "fk.produto")
    private List<ProdutoCarrinho> listaProdutosCarrinho;
    
    
    
}
