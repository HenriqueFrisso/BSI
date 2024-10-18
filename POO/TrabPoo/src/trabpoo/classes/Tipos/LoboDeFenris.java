package trabpoo.classes.Tipos;
/*
Lobo de Fenris: são lobos gigantes ferozes. Seu ataque é de 40 pontos de energia. Entretanto
seu ataque aumenta 8 pontos de energia para cada Lobo de Fenris que estiver atrás dele. Ou
seja, se houverem 2 lobos na sequência na fila, o Lobo atual ganha mais 16 pontos de ataque
(8 para cada lobo) totalizando 56 pontos de ataque. É importante notar que essa mudança é
dinâmica, ou seja, se um lobo morre o processo precisa ser recalculado.
*/
import java.util.ArrayList;
import trabpoo.Jogo;
import trabpoo.Questoes;
import trabpoo.classes.*;

public class LoboDeFenris extends Nordico{
    @Override
    public void agirGN(int pos){
        switch (pos){
            case(1) -> atacar(Jogo.getLista21().getFirst(),Jogo.getLista11());
            case(2) -> atacar(Jogo.getLista22().getFirst(),Jogo.getLista12());
            case(3) -> atacar(Jogo.getLista23().getFirst(),Jogo.getLista13());
            case(4) -> atacar(Jogo.getLista24().getFirst(),Jogo.getLista14());
        }
    }
    private void atacar(Guerreiro guerreiro, ArrayList<Guerreiro> lista){
        Questoes.auxE(this, guerreiro);
        guerreiro.setEnergia(guerreiro.getEnergia() - 40);
        int i = 1;
        while (i<lista.size()) {
            if (lista.get(i++).getClass()==this.getClass()){
            guerreiro.setEnergia(guerreiro.getEnergia() - 8);
            } else{
                break;
            }
        }
    }
}
