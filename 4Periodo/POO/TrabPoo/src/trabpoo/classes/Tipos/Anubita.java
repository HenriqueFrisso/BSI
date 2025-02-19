package trabpoo.classes.Tipos;
/*
Anubita: possui ataque de 15 pontos de energia, mas ataca 2 vezes. Ataca o primeiro
guerreiro e depois salta para o final da fila e ataca o último guerreiro da fila adversária.
*/
import trabpoo.Jogo;
import trabpoo.Questoes;
import trabpoo.classes.*;

public class Anubita extends Egipcio{
    protected void setNovo(String nome, int idade, int peso) {
        this.setNome(nome);
        this.setIdade(idade);
        this.setPeso(peso);
    }
    
    @Override
    public void agirAE(int pos){
        switch (pos){
            case(1) -> atacar(Jogo.getLista11().getFirst(),Jogo.getLista11().getLast());
            case(2) -> atacar(Jogo.getLista12().getFirst(),Jogo.getLista12().getLast());
            case(3) -> atacar(Jogo.getLista13().getFirst(),Jogo.getLista13().getLast());
            case(4) -> atacar(Jogo.getLista14().getFirst(),Jogo.getLista14().getLast());
        }
    }
    private void atacar(Guerreiro guerreiro1, Guerreiro guerreiro2){
        Questoes.auxE(this, guerreiro1);
        guerreiro1.setEnergia(guerreiro1.getEnergia()-15);
        guerreiro2.setEnergia(guerreiro2.getEnergia()-15);
    }
    
}
