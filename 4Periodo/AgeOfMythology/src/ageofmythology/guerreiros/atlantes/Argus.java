package ageofmythology.guerreiros.atlantes;

import ageofmythology.Arena;
import ageofmythology.guerreiros.Guerreiro;

/*
Argus: guerreiro atlante monstruoso, ele ataca com uma bolha de ácido que mata o inimigo
imediatamente independente da energia do inimigo. Argus também é frágil e sua energia
começa em 60 pontos
*/
public class Argus extends Atlante{
    
    public Argus(){
        this.setEnergia(60);
    }
    
    @Override
    public void atacar(int pos) {
        Guerreiro alvo = null;
        dano(alvo);
    }
    
    private void dano(Guerreiro alvo){
        alvo.setEnergia(0);
    }
    
}
