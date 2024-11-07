package ageofmythology.guerreiros.nordicos;
/*
Gigante de Pedra: são guerreiros de pedra muito resistentes a ataques pois possuem,
inicialmente, 300 pontos de energia. Quando atacam promovem o dano de 30 pontos de
energia. Quando é o primeiro a atacar força o lado adversário a atacá-lo, independente das
filas dos adversários. Se 2 Gigantes de Pedra ativarem a habilidade (em filas diferentes) o
último a ativar é o que será atacado.
*/
public class GiganteDePedra extends Nordico{
    
    public GiganteDePedra(){
        this.setEnergia(300);
    }

    @Override
    public void atacar(int pos) {
    }
    
}
