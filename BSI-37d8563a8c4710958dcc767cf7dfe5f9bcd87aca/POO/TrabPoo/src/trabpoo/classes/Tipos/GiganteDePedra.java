package trabpoo.classes.Tipos;
/*
Gigante de Pedra: são guerreiros de pedra muito resistentes a ataques pois possuem,
inicialmente, 300 pontos de energia. Quando atacam promovem o dano de 30 pontos de
energia. Quando é o primeiro a atacar força o lado adversário a atacá-lo, independente das
filas dos adversários. Se 2 Gigantes de Pedra ativarem a habilidade (em filas diferentes) o
último a ativar é o que será atacado.
*/
import trabpoo.Questoes;
import trabpoo.classes.*;

public class GiganteDePedra extends Nordico{

    public GiganteDePedra(){
        this.setEnergia(300);
    }
    
    @Override
    public void agirGN(int pos){
        switch (pos) {
            case 1 -> {atacar(Guerreiro.getLista21().get(0));}
            case 2 -> {atacar(Guerreiro.getLista22().get(0));}
            case 3 -> {atacar(Guerreiro.getLista23().get(0));}
            case 4 -> {atacar(Guerreiro.getLista24().get(0));}
        }
    }
    private void atacar(Guerreiro guerreiro){
        Questoes.auxE(this, guerreiro);
        guerreiro.setEnergia(guerreiro.getEnergia() - 30);
    }
    
}
