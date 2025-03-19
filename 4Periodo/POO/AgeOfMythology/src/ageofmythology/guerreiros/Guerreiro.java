package ageofmythology.guerreiros;

import ageofmythology.Arena;

public abstract class Guerreiro {
    
    private String nome;
    private int idade;
    private int peso;
    protected int energia = 100;
    
    private boolean envenenado = false;
    
    public String getNome(){return this.nome;}
    public void setNome(String nome){this.nome = nome;}
    public int getIdade(){return this.idade;}
    public void setIdade(int idade){this.idade = idade;}
    public int getPeso(){return this.peso;}
    public void setPeso(int peso){this.peso = peso;}
    public int getEnergia(){return this.energia;}
    public void setEnergia(int energia){
        this.energia = energia;
        morrer();
    }
    
    
    protected  void morrer(){
        if (morto()){
        }
    }
    public boolean morto(){
        return(this.energia<=0);
    }
    
    private void envenenado(){
        if (this.envenenado){
            this.setEnergia(energia - 5);
        }
    }
    public void setEnvenenado(){this.envenenado = true;}
    
    public void agir(){
        envenenado();
        if (morto()){
            return;
        }
        int pos = Arena.getIndexFila(this);
        atacar(pos);
    }
    public abstract void atacar(int pos);
}
