
package trabpoo.classes.Tipos;

import trabpoo.Jogo;
import trabpoo.Questoes;
import trabpoo.classes.*;

public class MortoVivo extends Egipcio{
    
    protected void setNovo(String nome, int idade, int peso) {
        this.setNome(nome);
        this.setIdade(idade);
        this.setPeso(peso);
    }
    
    @Override
    public void agirAE(int pos){
        switch (pos){
            case(1) -> atacar(Jogo.getLista11().getFirst());
            case(2) -> atacar(Jogo.getLista12().getFirst());
            case(3) -> atacar(Jogo.getLista13().getFirst());
            case(4) -> atacar(Jogo.getLista14().getFirst());
        }
    }
    private void atacar(Guerreiro guerreiro){
        Questoes.auxE(this, guerreiro);
        guerreiro.setEnergia(guerreiro.getEnergia() - 5);
    }
    
}
