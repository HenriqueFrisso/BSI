package trabpoo.classes;

import trabpoo.Jogo;

public abstract class Atlante extends Guerreiro{
    
    
    @Override
    public void agir(int pos){
        pos = Jogo.verificarFilas(pos, 2);
        if (Jogo.getTurno() == 0){pos = Jogo.provocar(pos);}
        agirAE(pos);
    }
    protected abstract void agirAE(int pos);
}
