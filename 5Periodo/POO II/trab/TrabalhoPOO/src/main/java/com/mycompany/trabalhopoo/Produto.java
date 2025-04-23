package com.mycompany.trabalhopoo;

public class Produto {
    private String nome;
    private double preco;
    private Loja loja;
    
    public Produto(String nome, double preco, Loja loja){
        this.nome = nome;
        this.preco = preco;
        this.loja = loja;
    }
    public Produto(String nome, double preco){
        this.loja = null;
        this.nome = nome;
        this.preco = preco;
    }
    public String getNome(){
        return nome;
    }
    public double getPreco(){
        return preco;
    }
}
