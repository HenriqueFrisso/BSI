package trabpoo.classes.Tipos;
/*
Ciclope: um gigante de um olho só. Promove um ataque que retira 35 pontos de energia e
depois, se foi o primeiro atacar, “joga” o adversário para o final de sua fila (na prática se foi
o primeiro a atacar não vai permitir que o adversário ataque, mas recebe o ataque do
atacante seguinte da fila inimiga).
*/
import java.util.ArrayList;
import trabpoo.Jogo;
import trabpoo.Questoes;
import trabpoo.classes.*;

public class Ciclope extends Grego{
    
    @Override
    public void agirGN(int pos){
        switch (pos) {
            case 1 -> {atacar(Guerreiro.getLista21().getFirst(), Guerreiro.getLista21(), Jogo.getTurno());}
            case 2 -> {atacar(Guerreiro.getLista22().getFirst(), Guerreiro.getLista22(), Jogo.getTurno());}
            case 3 -> {atacar(Guerreiro.getLista23().getFirst(), Guerreiro.getLista23(), Jogo.getTurno());}
            case 4 -> {atacar(Guerreiro.getLista24().getFirst(), Guerreiro.getLista24(), Jogo.getTurno());}
        }
    }
    private void atacar(Guerreiro guerreiro, ArrayList<Guerreiro> ls, int turno){
        Questoes.auxE(this, guerreiro);
        guerreiro.setEnergia(guerreiro.getEnergia() - 35);
        if (turno == 0 && !ls.isEmpty()){
            Guerreiro aux = ls.removeFirst();
            ls.add(aux);
        }
    }
}