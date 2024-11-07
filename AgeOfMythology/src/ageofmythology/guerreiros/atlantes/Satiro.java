package ageofmythology.guerreiros.atlantes;

import java.util.ArrayList;
/*
Sátiro: são guerreiros que utilizam lanças para atacar a distância. Quando atacam tiram
apenas 10 pontos de energia, entretanto acertam todos os guerreiros da fila adversária.
*/
public class Satiro extends Atlante{
    
    @Override
    public void agir(int pos){
        super.agir(pos);
        switch (pos){
            case(1) -> atacar(Jogo.getLista11());
            case(2) -> atacar(Jogo.getLista12());
            case(3) -> atacar(Jogo.getLista13());
            case(4) -> atacar(Jogo.getLista14());
        }
    }
    private void atacar(ArrayList<Guerreiro> ls){
        for (int i = 0; i < ls.size();i++) {
            Questoes.auxE(this, ls.get(i));
            ls.get(i).setEnergia(ls.get(i).getEnergia() - 10);
        }
    }
}
