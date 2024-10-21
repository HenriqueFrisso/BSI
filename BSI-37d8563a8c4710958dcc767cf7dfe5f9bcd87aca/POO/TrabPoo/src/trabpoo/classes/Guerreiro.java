package trabpoo.classes;

import java.util.ArrayList;
import trabpoo.Jogo;

public class Guerreiro {

    protected String nome;
    protected int idade;
    protected int peso;
    protected int energia = 100;
    
    
    private static ArrayList<Guerreiro> lista11 = new ArrayList<>();
    private static ArrayList<Guerreiro> lista12 = new ArrayList<>();
    private static ArrayList<Guerreiro> lista13 = new ArrayList<>();
    private static ArrayList<Guerreiro> lista14 = new ArrayList<>();
    
    private static ArrayList<Guerreiro> lista21 = new ArrayList<>();
    private static ArrayList<Guerreiro> lista22 = new ArrayList<>();
    private static ArrayList<Guerreiro> lista23 = new ArrayList<>();
    private static ArrayList<Guerreiro> lista24 = new ArrayList<>();
    
    public static ArrayList<Guerreiro> getLista11(){return lista11;}
    public static ArrayList<Guerreiro> getLista12(){return lista12;}
    public static ArrayList<Guerreiro> getLista13(){return lista13;}
    public static ArrayList<Guerreiro> getLista14(){return lista14;}
    
    public static ArrayList<Guerreiro> getLista21(){return lista21;}
    public static ArrayList<Guerreiro> getLista22(){return lista22;}
    public static ArrayList<Guerreiro> getLista23(){return lista23;}
    public static ArrayList<Guerreiro> getLista24(){return lista24;}

    
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
            lista11.remove(this);
            lista12.remove(this);
            lista13.remove(this);
            lista14.remove(this);

            lista21.remove(this);
            lista22.remove(this);
            lista23.remove(this);
            lista24.remove(this);
        }
    }

    public void agir(int pos){}

    public void setEnvenenado(boolean envenenado){}
    
}
