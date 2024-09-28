package trabpoo.classes.Tipos;
/*
Valquíria: é uma espécie de amazona montada num cavalo branco. Possuem poder de cura e
seu ataque retira 20 pontos de energia. Após atacar, o aliado que estiver após ela, na fila,
recupera 20 pontos de energia.
*/
import trabpoo.Questoes;
import trabpoo.classes.*;

public class Valquiria extends Nordico{
    @Override
    public void agirGN(int pos){
        switch (pos) {
            case 1 -> {
                if (Guerreiro.getLista11().size() > 1) {atacar(Guerreiro.getLista21().getFirst(), Guerreiro.getLista11().get(1));}
                else{atacar(Guerreiro.getLista21().getFirst());}
            }
            case 2 -> {
                if (Guerreiro.getLista12().size() > 1) {atacar(Guerreiro.getLista22().getFirst(), Guerreiro.getLista12().get(1));}
                else{atacar(Guerreiro.getLista22().getFirst());}
            }
            case 3 -> {
                if (Guerreiro.getLista13().size() > 1) {atacar(Guerreiro.getLista23().getFirst(), Guerreiro.getLista13().get(1));}
                else{atacar(Guerreiro.getLista23().getFirst());}
            }
            case 4 -> {
                if (Guerreiro.getLista14().size() > 1) {atacar(Guerreiro.getLista24().getFirst(), Guerreiro.getLista14().get(1));}
                else{atacar(Guerreiro.getLista24().getFirst());}
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
