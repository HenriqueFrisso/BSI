package trabpoo;

import java.io.FileNotFoundException;

//Aluno: Henrique Frisso Oliveira

public class TrabPoo {
    public static void main(String[] args) throws FileNotFoundException {
        LeitorArquivo.lerFilas();
        Questoes.questA();
        Questoes.questB();
        Questoes.questC();
        Jogo.jogar();
        Questoes.questD();
        Questoes.questE();
        Questoes.questF();
        
    }
}
