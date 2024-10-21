package trabpoo.classes.Tipos;
/*
Anubita: possui ataque de 15 pontos de energia, mas ataca 2 vezes. Ataca o primeiro
guerreiro e depois salta para o final da fila e ataca o último guerreiro da fila adversária.
*/
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
            case(1) -> atacar(Guerreiro.getLista11().get(0),Guerreiro.getLista11().get(Guerreiro.getLista11().size()-1));
            case(2) -> atacar(Guerreiro.getLista12().get(0),Guerreiro.getLista12().get(Guerreiro.getLista12().size()-1));
            case(3) -> atacar(Guerreiro.getLista13().get(0),Guerreiro.getLista13().get(Guerreiro.getLista13().size()-1));
            case(4) -> atacar(Guerreiro.getLista14().get(0),Guerreiro.getLista14().get(Guerreiro.getLista14().size()-1));
        }
    }
    private void atacar(Guerreiro guerreiro1, Guerreiro guerreiro2){
        Questoes.auxE(this, guerreiro1);
        guerreiro1.setEnergia(guerreiro1.getEnergia()-15);
        guerreiro2.setEnergia(guerreiro2.getEnergia()-15);
    }
    
}
