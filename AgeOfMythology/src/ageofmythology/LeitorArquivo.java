package ageofmythology;

import ageofmythology.guerreiros.*;
import ageofmythology.guerreiros.nordicos.*;
import ageofmythology.guerreiros.atlantes.*;
import ageofmythology.guerreiros.egipcios.*;
import ageofmythology.guerreiros.gregos.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Henrique
 */
public class LeitorArquivo {
    
    public static void iniciarLados(ArrayList<LinkedList<Guerreiro>> Arraylado, List arquivos, int lado){
        for (int i = 0; i < arquivos.size(); i++) {
            LinkedList<Guerreiro> linkedList = new LinkedList<>();
            lerArquivo(linkedList, (String)arquivos.get(i), lado, i);
            Arraylado.add(linkedList);
        } 
    }
    
    private static void lerArquivo(LinkedList<Guerreiro> lista, String arquivo, int lado, int fila){
        FileInputStream fil;
        Scanner scan;
        try {
            fil = new FileInputStream(arquivo);
            scan = new Scanner(fil);
            int aux;
            while (scan.hasNext()) {
                aux = scan.nextInt();
                Guerreiro guerreiro = criarGuerreiro(aux, lado);
                if (guerreiro != null) {
                    configurarGuerreiro(guerreiro, scan);
                    guerreiro.setFila(fila);
                    lista.add(guerreiro);
                }
            }
        } catch (FileNotFoundException e){
            System.out.println("Arquivo " + arquivo + " não encontrado!!");          
        }
    }
    
    private static Guerreiro criarGuerreiro(int tipo, int lado) {
        if (lado == 2){
            return switch (tipo) {
                case 1 -> new Prometeano();
                case 2 -> new Satiro();
                case 3 -> new Argus();
                case 4 -> new Anubita();
                case 5 -> new HomemEscorpiao();
                case 6 -> new Mumia();
                default -> null;
            };
        } else{
            return switch (tipo) {
                case(1) -> new Ciclope();
                case(2) -> new Manticora();
                case(3) -> new Hidra();
                case(4) -> new Valquiria();
                case(5) -> new LoboDeFenris();
                case(6) -> new GiganteDePedra();
                default -> null;
            };
        }
    }
    
    private static void configurarGuerreiro(Guerreiro guerreiro, Scanner scan) {
        guerreiro.setNome(scan.next());
        guerreiro.setIdade(scan.nextInt());
        guerreiro.setPeso(scan.nextInt());
    }
    
}
