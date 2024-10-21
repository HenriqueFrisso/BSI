package trabpoo.classes.Tipos;
/*
Sátiro: são guerreiros que utilizam lanças para atacar a distância. Quando atacam tiram
apenas 10 pontos de energia, entretanto acertam todos os guerreiros da fila adversária.
*/
import java.util.ArrayList;
import trabpoo.Questoes;
import trabpoo.classes.*;

public class Satiro extends Atlante{
    @Override
    public void agirAE(int pos){
        switch (pos){
            case(1) -> atacar(Guerreiro.getLista11());
            case(2) -> atacar(Guerreiro.getLista12());
            case(3) -> atacar(Guerreiro.getLista13());
            case(4) -> atacar(Guerreiro.getLista14());
        }
    }
    private void atacar(ArrayList<Guerreiro> ls){
        for (int i = 0; i < ls.size();i++) {
            Questoes.auxE(this, ls.get(i));
            ls.get(i).setEnergia(ls.get(i).getEnergia() - 10);
        }
    }
}
