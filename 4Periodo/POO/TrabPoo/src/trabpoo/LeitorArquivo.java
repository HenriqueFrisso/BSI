package trabpoo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import trabpoo.classes.*;
import trabpoo.classes.Tipos.*;

public class LeitorArquivo {
    
    public static void lerFilas() throws FileNotFoundException {
        lerArquivo(Jogo.getLista11(), "arquivos/lado11.txt", 1);
        lerArquivo(Jogo.getLista12(), "arquivos/lado12.txt", 1);
        lerArquivo(Jogo.getLista13(), "arquivos/lado13.txt", 1);
        lerArquivo(Jogo.getLista14(), "arquivos/lado14.txt", 1);

        lerArquivo(Jogo.getLista21(), "arquivos/lado21.txt", 2);
        lerArquivo(Jogo.getLista22(), "arquivos/lado22.txt", 2);
        lerArquivo(Jogo.getLista23(), "arquivos/lado23.txt", 2);
        lerArquivo(Jogo.getLista24(), "arquivos/lado24.txt", 2);
    }
    
    private static void lerArquivo(ArrayList<Guerreiro> lista, String arquivo, int lado) throws FileNotFoundException {
        FileInputStream fil = new FileInputStream(arquivo);
        try (Scanner scan = new Scanner(fil)) {
            int aux;
            while (scan.hasNext()) {
                aux = scan.nextInt();
                Guerreiro guerreiro = criarGuerreiro(aux, lado);
                if (guerreiro != null) {
                    configurarGuerreiro(guerreiro, scan);
                    lista.add(guerreiro);
                }
            }
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
