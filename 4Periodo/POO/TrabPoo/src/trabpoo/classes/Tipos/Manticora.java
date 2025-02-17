package trabpoo.classes.Tipos;
/*
Mantícora: possui uma cabeça humana e corpo de leão com espinhos em seu rabo. Promove
um ataque que acerta inimigos não só na mesma linha, mas também nas proximidades. Se
estiver numa fila 1, acerta o inimigo da fila 1 e da fila 2. Se estiver na fila 2, acerta o inimigo
da fila 2 e das filas 1 e 3. Se estiver na fila 3, acerta o inimigo da fila 3 e os inimigos das
filas 2 e 4. Se estiver na fila 4, acerta o inimigo da fila 4 e da fila 3. O inimigo atacado na
mesma linha recebe dano de 30, os inimigos das linhas próximas recebem dano de 15.
*/
import trabpoo.Jogo;
import trabpoo.Questoes;
import trabpoo.classes.*;

public class Manticora extends Grego{

    @Override
    protected void agirGN(int pos) {
        switch (pos) {
            case 1 -> {
                if (Jogo.getLista22().isEmpty()) {atacar(Jogo.getLista21().getFirst());} 
                else{atacar(Jogo.getLista21().getFirst(), Jogo.getLista22().getFirst());}
            }case 2 -> {
                if (Jogo.getLista21().isEmpty() && Jogo.getLista23().isEmpty()) {atacar(Jogo.getLista22().getFirst());}
                else if(Jogo.getLista21().isEmpty()){atacar(Jogo.getLista22().getFirst(), Jogo.getLista23().getFirst());}
                else if(Jogo.getLista23().isEmpty()){atacar(Jogo.getLista22().getFirst(), Jogo.getLista21().getFirst());}
                else{atacar(Jogo.getLista22().getFirst(), Jogo.getLista21().getFirst(), Jogo.getLista23().getFirst());}
            }case 3 -> {
                if (Jogo.getLista22().isEmpty() && Jogo.getLista24().isEmpty()) {atacar(Jogo.getLista23().getFirst());} 
                else if(Jogo.getLista22().isEmpty()){atacar(Jogo.getLista23().getFirst(), Jogo.getLista24().getFirst());} 
                else if(Jogo.getLista24().isEmpty()){atacar(Jogo.getLista23().getFirst(), Jogo.getLista22().getFirst());} 
                else{atacar(Jogo.getLista23().getFirst(), Jogo.getLista22().getFirst(), Jogo.getLista24().getFirst());}
            }case 4 -> {
                if (Jogo.getLista23().isEmpty()) {atacar(Jogo.getLista24().getFirst());}
                else{atacar(Jogo.getLista24().getFirst(), Jogo.getLista23().getFirst());}
            }
        }
    }
    private void atacar(Guerreiro guerreiro){
        Questoes.auxE(this, guerreiro);
        guerreiro.setEnergia(guerreiro.getEnergia()-30);
    }
    private void atacar(Guerreiro guerreiro1,Guerreiro guerreiro2){
        Questoes.auxE(this, guerreiro1);
        guerreiro1.setEnergia(guerreiro1.getEnergia()-30);
        guerreiro2.setEnergia(guerreiro2.getEnergia()-15);
    }
    private void atacar(Guerreiro guerreiro1,Guerreiro guerreiro2,Guerreiro guerreiro3){
        Questoes.auxE(this, guerreiro1);
        guerreiro1.setEnergia(guerreiro1.getEnergia()-30);
        guerreiro2.setEnergia(guerreiro2.getEnergia()-15);
        guerreiro3.setEnergia(guerreiro3.getEnergia()-15);
    }
    
}
