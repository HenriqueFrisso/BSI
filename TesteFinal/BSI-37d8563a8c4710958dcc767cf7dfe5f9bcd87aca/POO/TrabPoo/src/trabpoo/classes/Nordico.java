package trabpoo.classes;

import trabpoo.Jogo;

public abstract class Nordico extends Guerreiro{
    private boolean envenenado = false;
    
    @Override
    public void setEnvenenado(boolean envenenado){this.envenenado = envenenado;}
    public boolean getEnvenenado(){return this.envenenado;}
    private void envenenado(){
        if (envenenado == true){this.setEnergia(this.energia - 5);}
    }
    @Override
    public void agir(int pos){
        pos = Jogo.verificarFilas(pos, 1);
        envenenado();
        agirGN(pos);
    }
    protected abstract void agirGN(int pos);
}
