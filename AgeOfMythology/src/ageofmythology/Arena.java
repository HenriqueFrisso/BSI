package ageofmythology;

import ageofmythology.guerreiros.Guerreiro;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Arena {
    private static final List<String> arquivosLado1 = List.of("lado11.txt", "lado12.txt", "lado13.txt", "lado14.txt");
    private static final List<String> arquivosLado2 = List.of("lado21.txt", "lado22.txt", "lado23.txt", "lado24.txt");
    
    
    
    private static final ArrayList<LinkedList<Guerreiro>> lado1 = new ArrayList<>();
    private static final ArrayList<LinkedList<Guerreiro>> lado2 = new ArrayList<>();
    
    public static void iniciarArena(){
        LeitorArquivo.iniciarLados(lado1, arquivosLado1, 1);
     
    }
    
    public static int verificarFila(int pos){
    return pos;
    }
    
}
