package trabpoo.classes.Tipos;
/*
Valquíria: é uma espécie de amazona montada num cavalo branco. Possuem poder de cura e
seu ataque retira 20 pontos de energia. Após atacar, o aliado que estiver após ela, na fila,
recupera 20 pontos de energia.
*/
import trabpoo.Jogo;
import trabpoo.Questoes;
import trabpoo.classes.*;

public class Valquiria extends Nordico{
    @Override
    public void agirGN(int pos){
        switch (pos) {
            case 1 -> {
                if (Jogo.getLista11().size() > 1) {atacar(Jogo.getLista21().getFirst(), Jogo.getLista11().get(1));}
                else{atacar(Jogo.getLista21().getFirst());}
            }
            case 2 -> {
                if (Jogo.getLista12().size() > 1) {atacar(Jogo.getLista22().getFirst(), Jogo.getLista12().get(1));}
                else{atacar(Jogo.getLista22().getFirst());}
            }
            case 3 -> {
                if (Jogo.getLista13().size() > 1) {atacar(Jogo.getLista23().getFirst(), Jogo.getLista13().get(1));}
                else{atacar(Jogo.getLista23().getFirst());}
            }
            case 4 -> {
                if (Jogo.getLista14().size() > 1) {atacar(Jogo.getLista24().getFirst(), Jogo.getLista14().get(1));}
                else{atacar(Jogo.getLista24().getFirst());}
            }
        }
    }
    private void atacar(Guerreiro guerreiro){
        Questoes.auxE(this, guerreiro);
        guerreiro.setEnergia(guerreiro.getEnergia() - 20);
    }
    private void atacar(Guerreiro guerreiro, Guerreiro aliado){
        Questoes.auxE(this, guerreiro);
        guerreiro.setEnergia(guerreiro.getEnergia() - 20);
        aliado.setEnergia(aliado.getEnergia() + 20);
    }
}
