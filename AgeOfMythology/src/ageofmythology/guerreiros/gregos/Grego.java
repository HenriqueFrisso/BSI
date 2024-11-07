package ageofmythology.guerreiros.gregos;

import ageofmythology.guerreiros.Guerreiro;

public abstract class Grego extends Guerreiro{
    
    @Override
    public void setEnergia(int energia){
        this.energia = energia;
        if (this.energia > 100){this.energia = 100;}
        morrer();
    }

}
