package domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.*;


@Entity(name="usuario")
@AllArgsConstructor
public class Usuario implements Serializable {
    
    public Usuario(){}
    
    public Usuario (String nome, String email, String senha, String cpf, Date dataNasc){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
    }
    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public List<Carrinho> getListaCarrinho() {
        return listaCarrinho;
    }

    public void setListaCarrinho(List<Carrinho> listaCarrinho) {
        this.listaCarrinho = listaCarrinho;
    }

    public List<Endereco> getEndereco() {
        return endereco;
    }

    public void setEndereco(List<Endereco> endereco) {
        this.endereco = endereco;
    }
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @Column
    private String email;
    @Column
    private String senha;
    @Column
    private String cpf;
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNasc;
    @OneToMany(mappedBy = "usuario")
    private List<Carrinho> listaCarrinho;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    private List<Endereco> endereco;
    
}