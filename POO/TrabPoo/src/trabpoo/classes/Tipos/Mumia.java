package trabpoo.classes.Tipos;
/*
Múmia: são antigos faraós mortos. Possuem ataque de 50 pontos de energia. Quando mata
um adversário gera um morto vivo e acrescenta em sua fila. Esse morto vivo possui ataque
de 5 pontos de energia e começa com 100 pontos de energia (assim como a maioria dos
guerreiros). Quando uma Múmia morre ela invoca 4 Anubitas para vinga-la (sendo
colocadas no final da fila de seus aliados). O morto-vivo “nasce” com o nome, idade e peso
do guerreiro adversário morto. Já os Anubitas vingadores “nascem” com o nome da múmia
morta, idade = 0 e peso = 60.
*/
import trabpoo.Questoes;
import trabpoo.classes.*;

public class Mumia extends Egipcio{

    @Override
    public void setEnergia(int energia) {
        this.energia = energia;
        morrer();
    }
    @Override
    protected void morrer() {
        if (this.getEnergia() <= 0) {
            Anubita aux1 = new Anubita();
            Anubita aux2 = new Anubita();
            Anubita aux3 = new Anubita();
            Anubita aux4 = new Anubita();
            
            aux1.setNovo(this.getNome(), 0, 60);
            aux2.setNovo(this.getNome(), 0, 60);
            aux3.setNovo(this.getNome(), 0, 60);
            aux4.setNovo(this.getNome(), 0, 60);
            
            Guerreiro.getLista21().add(aux1);
            Guerreiro.getLista22().add(aux2);
            Guerreiro.getLista23().add(aux3);
            Guerreiro.getLista24().add(aux4);
            
            int pos = encontrarPosicao();
            switch (pos) {
            case 1 -> Guerreiro.getLista21().remove(this);
            case 2 -> Guerreiro.getLista22().remove(this);
            case 3 -> Guerreiro.getLista23().remove(this);
            case 4 -> Guerreiro.getLista24().remove(this);
            }
        }
    }
    private int encontrarPosicao() {
        if (Guerreiro.getLista21().indexOf(this) != -1) {return 1;}
        else if (Guerreiro.getLista22().indexOf(this) != -1) {return 2;}
        else if (Guerreiro.getLista23().indexOf(this) != -1) {return 3;} 
        else if (Guerreiro.getLista24().indexOf(this) != -1) {return 4;}
        return 0;
    }
    
    private void matou(Guerreiro guerreiro){
        MortoVivo morto = new MortoVivo();
        int pos = encontrarPosicao();
        morto.setNovo(guerreiro.getNome(),guerreiro.getIdade(),guerreiro.getPeso());
        switch (pos) {
            case 1 -> Guerreiro.getLista21().add(morto);
            case 2 -> Guerreiro.getLista22().add(morto);
            case 3 -> Guerreiro.getLista23().add(morto);
            case 4 -> Guerreiro.getLista24().add(morto);
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
        guerreiro.setEnergia(guerreiro.getEnergia() - 50);
        if (guerreiro.getEnergia()<=0){
            matou(guerreiro);
        }
    }
    
}