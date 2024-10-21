package trabpoo.classes.Tipos;
/*
Homem escorpião: metade homem e metade escorpião. Seu ataque é de 20 pontos,
entretanto envenena o inimigo. Inimigos envenenados sofrem dano de 5 pontos de energia
toda vez que promovem um ataque. O veneno do homem escorpião não tem cura, ou seja,
até que a unidade inimiga morra, toda vez que atacar ela vai perder 5 pontos de energia. Um
novo envenenamento não gera qualquer efeito sobre uma unidade inimiga, ou seja, o efeito
de retirar 5 pontos de energia continua até a morte do adversário, mas sem acréscimo de taxa
de morte.
*/
import trabpoo.Jogo;
import trabpoo.Questoes;
import trabpoo.classes.*;

public class HomemEscorpiao extends Egipcio{
    
    @Override
    public void atacar(int pos){
        switch (pos){
            case(1) -> atacar(Jogo.getLista11().get(0));
            case(2) -> atacar(Jogo.getLista12().get(0));
            case(3) -> atacar(Jogo.getLista13().get(0));
            case(4) -> atacar(Jogo.getLista14().get(0));
        }
    }
    private void atacar(Guerreiro guerreiro){
        Questoes.auxE(this, guerreiro);
        guerreiro.setEnergia(guerreiro.getEnergia() - 20);
        guerreiro.setEnvenenado(true);
    }
}
