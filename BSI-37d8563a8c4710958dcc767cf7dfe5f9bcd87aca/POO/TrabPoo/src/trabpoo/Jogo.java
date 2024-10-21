package trabpoo;

import static java.lang.Math.random;
import java.util.ArrayList;
import trabpoo.classes.Guerreiro;
import trabpoo.classes.Tipos.GiganteDePedra;



public class Jogo {
    static int turno;
    
    public static int provocar(int pos) {
        if (!Guerreiro.getLista11().isEmpty() && (Guerreiro.getLista11().get(0).getClass() == GiganteDePedra.class)) {return 1;}
        else if (!Guerreiro.getLista12().isEmpty() && (Guerreiro.getLista12().get(0).getClass() == GiganteDePedra.class)) {return 2;}
        else if (!Guerreiro.getLista13().isEmpty() && (Guerreiro.getLista13().get(0).getClass() == GiganteDePedra.class)) {return 3;}
        else if (!Guerreiro.getLista14().isEmpty() && (Guerreiro.getLista14().get(0).getClass() == GiganteDePedra.class)) {return 4;}
        else {return pos;}
    }
    
    public static int verificarFilas(int pos, int lado) {
        ArrayList<Guerreiro> lista1, lista2, lista3, lista4;

        if (lado == 1) {
            lista1 = Guerreiro.getLista21();
            lista2 = Guerreiro.getLista22();
            lista3 = Guerreiro.getLista23();
            lista4 = Guerreiro.getLista24();
        } else {
            lista1 = Guerreiro.getLista11();
            lista2 = Guerreiro.getLista12();
            lista3 = Guerreiro.getLista13();
            lista4 = Guerreiro.getLista14();
        }

        return verificarPosicao(pos, lista1, lista2, lista3, lista4);
    }
    private static int verificarPosicao(int pos, ArrayList<Guerreiro> lista1, ArrayList<Guerreiro> lista2, ArrayList<Guerreiro> lista3, ArrayList<Guerreiro> lista4) {
        switch (pos) {
            case 1 ->{pos = verificarPosicaoLoop(pos, lista1, lista2, lista3, lista4);}
            case 2 ->{pos = verificarPosicaoLoop(pos, lista2, lista3, lista4, lista1);}
            case 3 ->{pos = verificarPosicaoLoop(pos, lista3, lista4, lista1, lista2);}
            case 4 ->{pos = verificarPosicaoLoop(pos, lista4, lista1, lista2, lista3);}
        }
        if (pos!=0){
            pos = (pos%4)+1;
        }
        return (pos);
    }
    private static int verificarPosicaoLoop(int pos, ArrayList<Guerreiro> lista1, ArrayList<Guerreiro> lista2, ArrayList<Guerreiro> lista3, ArrayList<Guerreiro> lista4) {
        if (lista1.isEmpty()) {
            if (lista2.isEmpty()) {
                if (lista3.isEmpty()) {
                    if (lista4.isEmpty()){
                        return 0;
                    }
                    return pos+2;
                }
                return pos+1;
            }
            return pos;
        }
        return pos+3;
    }
    
    
    private static void setTurno(){turno = (int) ((random()*10)%2);}
    public static int getTurno(){return turno;}
    
    private static void rodadaGN(){
        if (!Guerreiro.getLista11().isEmpty() && !fim()){Guerreiro.getLista11().get(0).agir(1);}
        if (!Guerreiro.getLista12().isEmpty() && !fim()){Guerreiro.getLista12().get(0).agir(2);}
        if (!Guerreiro.getLista13().isEmpty() && !fim()){Guerreiro.getLista13().get(0).agir(3);}
        if (!Guerreiro.getLista14().isEmpty() && !fim()){Guerreiro.getLista14().get(0).agir(4);}
        
        if (!Guerreiro.getLista21().isEmpty() && !fim()){Guerreiro.getLista21().get(0).agir(1);}
        if (!Guerreiro.getLista22().isEmpty() && !fim()){Guerreiro.getLista22().get(0).agir(2);}
        if (!Guerreiro.getLista23().isEmpty() && !fim()){Guerreiro.getLista23().get(0).agir(3);}
        if (!Guerreiro.getLista24().isEmpty() && !fim()){Guerreiro.getLista24().get(0).agir(4);}
    }
    
    private static void rodadaAE(){
        if (!Guerreiro.getLista21().isEmpty() && !fim()){Guerreiro.getLista21().get(0).agir(1);}
        if (!Guerreiro.getLista22().isEmpty() && !fim()){Guerreiro.getLista22().get(0).agir(2);}
        if (!Guerreiro.getLista23().isEmpty() && !fim()){Guerreiro.getLista23().get(0).agir(3);}
        if (!Guerreiro.getLista24().isEmpty() && !fim()){Guerreiro.getLista24().get(0).agir(4);}
        
        if (!Guerreiro.getLista11().isEmpty() && !fim()){Guerreiro.getLista11().get(0).agir(1);}
        if (!Guerreiro.getLista12().isEmpty() && !fim()){Guerreiro.getLista12().get(0).agir(2);}
        if (!Guerreiro.getLista13().isEmpty() && !fim()){Guerreiro.getLista13().get(0).agir(3);}
        if (!Guerreiro.getLista14().isEmpty() && !fim()){Guerreiro.getLista14().get(0).agir(4);}
    }private static void fimRodada(){
        Guerreiro aux;
        if (!Guerreiro.getLista11().isEmpty() && !fim()){aux = Guerreiro.getLista11().remove(0);Guerreiro.getLista11().add(aux);}
        if (!Guerreiro.getLista12().isEmpty() && !fim()){aux = Guerreiro.getLista12().remove(0);Guerreiro.getLista12().add(aux);}
        if (!Guerreiro.getLista13().isEmpty() && !fim()){aux = Guerreiro.getLista13().remove(0);Guerreiro.getLista13().add(aux);}
        if (!Guerreiro.getLista14().isEmpty() && !fim()){aux = Guerreiro.getLista14().remove(0);Guerreiro.getLista14().add(aux);}
        
        if (!Guerreiro.getLista21().isEmpty() && !fim()){aux = Guerreiro.getLista21().remove(0);Guerreiro.getLista21().add(aux);}
        if (!Guerreiro.getLista22().isEmpty() && !fim()){aux = Guerreiro.getLista22().remove(0);Guerreiro.getLista22().add(aux);}
        if (!Guerreiro.getLista23().isEmpty() && !fim()){aux = Guerreiro.getLista23().remove(0);Guerreiro.getLista23().add(aux);}
        if (!Guerreiro.getLista24().isEmpty() && !fim()){aux = Guerreiro.getLista24().remove(0);Guerreiro.getLista24().add(aux);}
    }
    private static boolean fim(){
        if (
            (Guerreiro.getLista11().isEmpty()
            && Guerreiro.getLista12().isEmpty()
            && Guerreiro.getLista13().isEmpty()
            && Guerreiro.getLista14().isEmpty())
            ||(Guerreiro.getLista21().isEmpty()
            && Guerreiro.getLista22().isEmpty()
            && Guerreiro.getLista23().isEmpty()
            && Guerreiro.getLista24().isEmpty())
            ){
            return true;
        }
        return false;
    }
    private static void rodada(){
        if (!fim()){
            setTurno();
            if (getTurno() == 0){rodadaGN();} 
            else{rodadaAE();}
            fimRodada();
        }
    }
    public static void jogar(){
        while (!fim()){
            rodada();
        }
    }
}
