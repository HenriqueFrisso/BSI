package trabpoo.classes.Tipos;
/*
Argus: guerreiro atlante monstruoso, ele ataca com uma bolha de ácido que mata o inimigo
imediatamente independente da energia do inimigo. Argus também é frágil e sua energia
começa em 60 pontos
*/
import trabpoo.Questoes;
import trabpoo.classes.*;

public class Argus extends Atlante{
    
    public Argus(){
        this.setEnergia(60);
    }

    @Override
    public void agirAE(int pos){
        switch (pos){
            case(1) -> atacar(Guerreiro.getLista11().getFirst());
            case(2) -> atacar(Guerreiro.getLista12().getFirst());
            case(3) -> atacar(Guerreiro.getLista13().getFirst());
            case(4) -> atacar(Guerreiro.getLista14().getFirst());
        }
    }
    private void atacar(Guerreiro guerreiro){
        Questoes.auxE(this, guerreiro);
        guerreiro.setEnergia(0);
    }
    
}
