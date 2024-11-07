package ageofmythology.guerreiros.gregos;

import ageofmythology.Arena;
import ageofmythology.guerreiros.Guerreiro;
import java.util.LinkedList;

/*
Ciclope: um gigante de um olho só. Promove um ataque que retira 35 pontos de energia e
depois, se foi o primeiro atacar, “joga” o adversário para o final de sua fila (na prática se foi
o primeiro a atacar não vai permitir que o adversário ataque, mas recebe o ataque do
atacante seguinte da fila inimiga).
*/
public class Ciclope extends Grego{

    @Override
    public void atacar(int pos) {
        Guerreiro alvo = Arena.getGuerreiro(getLado(),pos);
        dano(alvo);
        if (!alvo.morto()){
            arremessar(Arena.getFila(getLado(), pos));
        }
    }
    
    private void arremessar(LinkedList<Guerreiro> fila){
        fila.addLast(fila.pollFirst());
    }
    
    private void dano(Guerreiro alvo){
        alvo.setEnergia(alvo.getEnergia() - 35);
    }
}
