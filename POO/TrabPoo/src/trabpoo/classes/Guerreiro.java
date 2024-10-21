package trabpoo.classes;

import trabpoo.Jogo;

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
   
    
    protected void morrer(){
        if (this.energia<=0){
            Jogo.getLista11().remove(this);
            Jogo.getLista12().remove(this);
            Jogo.getLista13().remove(this);
            Jogo.getLista14().remove(this);

            Jogo.getLista21().remove(this);
            Jogo.getLista22().remove(this);
            Jogo.getLista23().remove(this);
            Jogo.getLista24().remove(this);
        }
    }

    public abstract void agir(int pos);
    
    public boolean getEnvenenado(){return this.envenenado;}
    
    public void setEnvenenado(boolean envenenado){this.envenenado = true;}
    
    protected abstract void atacar(int pos);
    
}
