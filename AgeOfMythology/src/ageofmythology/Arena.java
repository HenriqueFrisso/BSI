package ageofmythology;

import ageofmythology.guerreiros.Guerreiro;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Arena {
    private static final List<String> arquivosLado1 = List.of("lado11.txt", "lado12.txt", "lado13.txt", "lado14.txt");
    private static final List<String> arquivosLado2 = List.of("lado21.txt", "lado22.txt", "lado23.txt", "lado24.txt");
    
    public static final ArrayList<LinkedList<Guerreiro>> lado1 = new ArrayList<>();
    public static final ArrayList<LinkedList<Guerreiro>> lado2 = new ArrayList<>();
    
    private int turno;
    
    public int getTurno(){
        return this.turno;
    }
    
    public static void iniciarArena(){
        LeitorArquivo.iniciarLados(lado1, arquivosLado1, 1);
    }
    
    public static int verificarFila(int pos){
    return pos;
    }

    public static Guerreiro getGuerreiro(int lado,int iFila) {
        Guerreiro aux;
        if(lado == 2){
            aux = lado1.get(iFila).peekFirst();
        } else{
            aux = lado2.get(iFila).peekFirst();
        }
        return aux;
    }   
    
    
    public static LinkedList<Guerreiro> getFila(int lado, int iFila){ //Retorna a lista do outro lado que recebe por parametro
        LinkedList<Guerreiro> fila;
        if(lado == 2){
            fila = lado1.get(iFila);
        } else{
            fila = lado2.get(iFila);
        }
        return fila;
    }
}
