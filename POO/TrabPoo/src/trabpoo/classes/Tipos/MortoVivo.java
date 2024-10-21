
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
            case(1) -> atacar(Jogo.getLista11().get(0));
            case(2) -> atacar(Jogo.getLista12().get(0));
            case(3) -> atacar(Jogo.getLista13().get(0));
            case(4) -> atacar(Jogo.getLista14().get(0));
        }
    }
    private void atacar(Guerreiro guerreiro){
        Questoes.auxE(this, guerreiro);
        guerreiro.setEnergia(guerreiro.getEnergia() - 5);
    }
    
}
