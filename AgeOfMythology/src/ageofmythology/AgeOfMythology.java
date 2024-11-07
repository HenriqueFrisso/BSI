package ageofmythology;

import ageofmythology.guerreiros.Guerreiro;
import ageofmythology.guerreiros.atlantes.*;
import ageofmythology.guerreiros.gregos.*;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Henrique
 */
public class AgeOfMythology {

    public static void main(String[] args) {
        
        
        
        LinkedList<Guerreiro> fila11 = new LinkedList<>();
        LinkedList<Guerreiro> fila12 = new LinkedList<>();
        LinkedList<Guerreiro> fila13 = new LinkedList<>();
        LinkedList<Guerreiro> fila14 = new LinkedList<>();
        
        LinkedList<Guerreiro> fila21 = new LinkedList<>();
        LinkedList<Guerreiro> fila22 = new LinkedList<>();
        LinkedList<Guerreiro> fila23 = new LinkedList<>();
        LinkedList<Guerreiro> fila24 = new LinkedList<>();
        
        Arena.lado1.add(fila11);
        Arena.lado1.add(fila12);
        Arena.lado1.add(fila13);
        Arena.lado1.add(fila14);
        
        Arena.lado2.add(fila21);
        Arena.lado2.add(fila22);
        Arena.lado2.add(fila23);
        Arena.lado2.add(fila24);
        
        
        Guerreiro guerreiro1 = new Argus();
        guerreiro1.setLado(1);
        guerreiro1.setFila(0);
        
        
        Guerreiro guerreiro2 = new Argus();
        guerreiro2.setLado(1);
        guerreiro2.setFila(0);
        
        Guerreiro guerreiro3 = new Ciclope();
        guerreiro3.setLado(2);
        guerreiro3.setFila(0);
        
        fila11.add(guerreiro1);
                
        fila11.add(guerreiro2);
        
        fila21.add(guerreiro3);
        
        System.out.println(Arena.lado1.get(0));
        System.out.println(Arena.lado2.get(0));
        
        System.out.println(guerreiro1.getEnergia());
        guerreiro3.agir();
        System.out.println(guerreiro1.getEnergia());
        
        System.out.println(Arena.lado1.get(0));
        System.out.println(Arena.lado2.get(0));
    }
    
}
