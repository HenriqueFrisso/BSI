package com.mycompany.trabalhopoo;

public class Loja {
    private String nome;
    private String cnpj;

    public Loja(String nome, String cnpj, String codigo){
        this.nome = nome;
        this.cnpj = cnpj;
        this.codigo = codigo;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
    private String codigo;
    
    
    
}