package ageofmythology;

import ageofmythology.guerreiros.Guerreiro;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Arena {
    List<String> arquivosLado1 = List.of("lado11.txt", "lado12.txt", "lado13.txt", "lado14.txt");
    List<String> arquivosLado2 = List.of("lado21.txt", "lado22.txt", "lado23.txt", "lado24.txt");
    
    
    
    ArrayList<LinkedList<Guerreiro>> lado1 = new ArrayList<>();
    ArrayList<LinkedList<Guerreiro>> lado2 = new ArrayList<>();
    
      
    private void iniciarLados(ArrayList<LinkedList<Guerreiro>> Arraylado, List arquivos, int lado){
        for (int i = 0; i < arquivos.size(); i++) {
            LinkedList<Guerreiro> linkedList = new LinkedList<>();
            lerArquivo(linkedList);
            Arraylado.add(linkedList);
        } 
    }
    
}
