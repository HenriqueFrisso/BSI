package trabpoo.classes;

import trabpoo.Jogo;

public abstract class Nordico extends Guerreiro{
    
    private void envenenado(){
        if (getEnvenenado()){this.setEnergia(this.energia - 5);}
    }
    @Override
    public void agir(int pos){
        pos = Jogo.verificarFilas(pos, 1);
        envenenado();
        atacar(pos);
    }
}
