package trabpoo.classes.Tipos;

/*
Prometeano: são guerreiros de barro que se dividem em 2 quando morrem (cada um com
50% da energia original do prometeano e ambos colocados no final da fila do prometeano
original). Quando um prometeano chega a 1 ponto de energia, quando morre ele
efetivamente é eliminado. O ataque de um prometeano é de 10 unidades de energia. Peso e
idade passam do prometado morto para seus descendentes. Por sua vez, o nome dos
descentes do prometeano é a concatenação no nome do prometeano que o gerou com o
número 1 ou 2 (dependendo se ele é o primeiro ou segundo descendente).
 */
import trabpoo.Questoes;
import trabpoo.classes.*;

public class Prometeano extends Atlante {

    int vidaIni = 100;

    @Override
    public void setEnergia(int energia) {
        this.energia = energia;
        morrer();
    }

    private int encontrarPosicao() {
        if (Guerreiro.getLista21().indexOf(this) != -1) {return 1;}
        else if (Guerreiro.getLista22().indexOf(this) != -1) {return 2;}
        else if (Guerreiro.getLista23().indexOf(this) != -1) {return 3;} 
        else if (Guerreiro.getLista24().indexOf(this) != -1) {return 4;}
        return 0;
    }

    private void setNovo(String nome, int vida, int idade, int peso) {
        this.setNome(nome);
        this.setVida(vida);
        this.setIdade(idade);
        this.setPeso(peso);
    }

    private void setVida(int vida) {
        this.vidaIni = vida;
        this.setEnergia(vida);
    }

    @Override
    protected void morrer() {
        if (this.getEnergia() <= 0 && this.vidaIni > 1) {
            int pos;
            Prometeano aux1 = new Prometeano();
            Prometeano aux2 = new Prometeano();
            aux1.setNovo(this.getNome() + "1", this.vidaIni / 2, this.getIdade(), this.getPeso());
            aux2.setNovo(this.getNome() + "2", this.vidaIni / 2, this.getIdade(), this.getPeso());
            pos = encontrarPosicao();
            switch (pos) {
                case 1 -> {
                    Guerreiro.getLista21().add(aux1);
                    Guerreiro.getLista21().add(aux2);
                    Guerreiro.getLista21().remove(this);
                }
                case 2 -> {
                    Guerreiro.getLista22().add(aux1);
                    Guerreiro.getLista22().add(aux2);
                    Guerreiro.getLista22().remove(this);
                }
                case 3 -> {
                    Guerreiro.getLista23().add(aux1);
                    Guerreiro.getLista23().add(aux2);
                    Guerreiro.getLista23().remove(this);
                }
                case 4 -> {
                    Guerreiro.getLista24().add(aux1);
                    Guerreiro.getLista24().add(aux2);
                    Guerreiro.getLista24().remove(this);
                }
            }
        } else if (this.getEnergia() <= 0) {
            Guerreiro.getLista21().remove(this);
            Guerreiro.getLista22().remove(this);
            Guerreiro.getLista23().remove(this);
            Guerreiro.getLista24().remove(this);
        }
    }

    @Override
    protected void agirAE(int pos) {
        switch (pos) {
            case (1) -> atacar(Guerreiro.getLista11().getFirst());
            case (2) -> atacar(Guerreiro.getLista12().getFirst());
            case (3) -> atacar(Guerreiro.getLista13().getFirst());
            case (4) -> atacar(Guerreiro.getLista14().getFirst());
        }
    }

    private void atacar(Guerreiro guerreiro) {
        Questoes.auxE(this, guerreiro);
        guerreiro.setEnergia(guerreiro.getEnergia() - 10);
    }
}
