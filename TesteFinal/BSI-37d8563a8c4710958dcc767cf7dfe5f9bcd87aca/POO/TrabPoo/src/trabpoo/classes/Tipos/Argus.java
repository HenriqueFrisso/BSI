package trabpoo.classes.Tipos;
/*
Argus: guerreiro atlante monstruoso, ele ataca com uma bolha de ácido que mata o inimigo
imediatamente independente da energia do inimigo. Argus também é frágil e sua energia
começa em 60 pontos
*/
import trabpoo.Jogo;
import trabpoo.Questoes;
import trabpoo.classes.*;

public class Argus extends Atlante{
    
    public Argus(){
        this.setEnergia(60);
    }

    @Override
    public void agirAE(int pos){
        switch (pos){
            case(1) -> atacar(Jogo.getLista11().get(0));
            case(2) -> atacar(Jogo.getLista12().get(0));
            case(3) -> atacar(Jogo.getLista13().get(0));
            case(4) -> atacar(Jogo.getLista14().get(0));
        }
    }
    private void atacar(Guerreiro guerreiro){
        Questoes.auxE(this, guerreiro);
        guerreiro.setEnergia(0);
    }
    
}