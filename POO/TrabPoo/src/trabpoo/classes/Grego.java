package trabpoo.classes;

import trabpoo.Jogo;

public abstract class Grego extends Guerreiro{
    
    
    private void envenenado(){
        if (getEnvenenado()){this.setEnergia(this.energia - 5);}
    }
    @Override
    public void setEnergia(int energia){
        this.energia = energia;
        if (this.energia > 100){this.energia = 100;}
        morrer();
    }
    @Override
    public void agir(int pos){
        pos = Jogo.verificarFilas(pos, 1);
        envenenado();
        atacar(pos);
    }
}
