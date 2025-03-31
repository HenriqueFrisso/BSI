
package com.mycompany.trabalhopoo;

public class Endereco {
    String cep, estado, cidade, rua;
    int numero;

    public Endereco(String cep, String estado, String cidade, String rua, int numero) {
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
        this.rua = rua;
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public String getEstado() {
        return estado;
    }

    public String getCidade() {
        return cidade;
    }

    public String getRua() {
        return rua;
    }

    public int getNumero() {
        return numero;
    }
    
}
