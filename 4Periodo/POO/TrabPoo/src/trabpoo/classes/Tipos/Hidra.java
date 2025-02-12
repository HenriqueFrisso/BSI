package trabpoo.classes.Tipos;
/*
Hidra: parece um dinossauro aquático, ganha uma cabeça para cada inimigo que mata. Seu
ataque inicial é de 50 pontos de energia, mas ganha mais 5 pontos de ataque para cada
cabeça nova gerada, além de mais 20 pontos de recuperação de energia para si mesmo (se a
hidra não tiver sido atacada ainda, ou seja, tiver os 100 pontos de energia, nada acontece).
*/
import trabpoo.Jogo;
import trabpoo.Questoes;
import trabpoo.classes.*;

public class Hidra extends Grego{
    private int abates = 0;
    
    @Override
    protected void agirGN(int pos){
        switch (pos){
            case(1) -> atacar(Jogo.getLista21().getFirst());
            case(2) -> atacar(Jogo.getLista22().getFirst());
            case(3) -> atacar(Jogo.getLista23().getFirst());
            case(4) -> atacar(Jogo.getLista24().getFirst());
        }
    }
    private void atacar(Guerreiro guerreiro){
        Questoes.auxE(this, guerreiro);
        guerreiro.setEnergia(guerreiro.getEnergia() - (50+(5 * this.abates)));
        if (guerreiro.getEnergia() <= 0){
            abates++;
            this.setEnergia(this.getEnergia()+20);
        }
    }
}
