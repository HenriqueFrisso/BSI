package domain;


import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.*;



@Entity(name="loja")
@AllArgsConstructor
public class Loja implements Serializable{

    public Loja(){}
    public Loja(String nome, String cnpj, String codigo) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.codigo = codigo;
    }
    public Loja(String nome, String telefone, String cnpj, String codigo, byte[] img) {
        this.nome = nome;
        this.telefone = telefone;
        this.cnpj = cnpj;
        this.codigo = codigo;
        this.logo = img;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public List<Endereco> getEndereco() {
        return endereco;
    }

    public void setEndereco(List<Endereco> endereco) {
        this.endereco = endereco;
    }

    public List<Produto> getProduto() {
        return produto;
    }

    public void setProduto(List<Produto> produto) {
        this.produto = produto;
    }
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @Column
    private String telefone;
    @Column
    private String cnpj;
    @Column
    private String codigo;
    @Lob
    private byte[] logo;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "loja_id")
    private List<Endereco> endereco;
    @OneToMany(mappedBy = "loja", fetch = FetchType.LAZY)
    private List<Produto> produto;
    
    
    
}