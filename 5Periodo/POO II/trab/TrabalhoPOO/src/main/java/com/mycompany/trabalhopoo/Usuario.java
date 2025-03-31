package com.mycompany.trabalhopoo;

public class Usuario {
    private String nome, senha, email;
    
    public Usuario(String nome, String senha, String email){
        this.nome = nome;
        this.senha = senha;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public String getEmail() {
        return email;
    }
}
