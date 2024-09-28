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
import trabpoo.Questoes;
import trabpoo.classes.*;

public class HomemEscorpiao extends Egipcio{
    
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
        guerreiro.setEnergia(guerreiro.getEnergia() - 20);
        guerreiro.setEnvenenado(true);
    }
}
