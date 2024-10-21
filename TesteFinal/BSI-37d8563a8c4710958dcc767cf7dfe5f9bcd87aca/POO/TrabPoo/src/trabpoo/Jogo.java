package trabpoo;

import static java.lang.Math.random;
import java.util.ArrayList;
import trabpoo.classes.Guerreiro;
import trabpoo.classes.Tipos.GiganteDePedra;



public class Jogo {
    static int turno;
    
    
    private static ArrayList<Guerreiro> lista11 = new ArrayList<>();
    private static ArrayList<Guerreiro> lista12 = new ArrayList<>();
    private static ArrayList<Guerreiro> lista13 = new ArrayList<>();
    private static ArrayList<Guerreiro> lista14 = new ArrayList<>();
    
    private static ArrayList<Guerreiro> lista21 = new ArrayList<>();
    private static ArrayList<Guerreiro> lista22 = new ArrayList<>();
    private static ArrayList<Guerreiro> lista23 = new ArrayList<>();
    private static ArrayList<Guerreiro> lista24 = new ArrayList<>();
    
    public static ArrayList<Guerreiro> getLista11(){return lista11;}
    public static ArrayList<Guerreiro> getLista12(){return lista12;}
    public static ArrayList<Guerreiro> getLista13(){return lista13;}
    public static ArrayList<Guerreiro> getLista14(){return lista14;}
    
    public static ArrayList<Guerreiro> getLista21(){return lista21;}
    public static ArrayList<Guerreiro> getLista22(){return lista22;}
    public static ArrayList<Guerreiro> getLista23(){return lista23;}
    public static ArrayList<Guerreiro> getLista24(){return lista24;}

    
    public static int provocar(int pos) {
        if (!getLista11().isEmpty() && (getLista11().get(0).getClass() == GiganteDePedra.class)) {return 1;}
        else if (!getLista12().isEmpty() && (getLista12().get(0).getClass() == GiganteDePedra.class)) {return 2;}
        else if (!getLista13().isEmpty() && (getLista13().get(0).getClass() == GiganteDePedra.class)) {return 3;}
        else if (!getLista14().isEmpty() && (getLista14().get(0).getClass() == GiganteDePedra.class)) {return 4;}
        else {return pos;}
    }
    
    public static int verificarFilas(int pos, int lado) {
        ArrayList<Guerreiro> lista1, lista2, lista3, lista4;

        if (lado == 1) {
            lista1 = getLista21();
            lista2 = getLista22();
            lista3 = getLista23();
            lista4 = getLista24();
        } else {
            lista1 = getLista11();
            lista2 = getLista12();
            lista3 = getLista13();
            lista4 = getLista14();
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
        if (!getLista11().isEmpty() && !fim()){getLista11().get(0).agir(1);}
        if (!getLista12().isEmpty() && !fim()){getLista12().get(0).agir(2);}
        if (!getLista13().isEmpty() && !fim()){getLista13().get(0).agir(3);}
        if (!getLista14().isEmpty() && !fim()){getLista14().get(0).agir(4);}
        
        if (!getLista21().isEmpty() && !fim()){getLista21().get(0).agir(1);}
        if (!getLista22().isEmpty() && !fim()){getLista22().get(0).agir(2);}
        if (!getLista23().isEmpty() && !fim()){getLista23().get(0).agir(3);}
        if (!getLista24().isEmpty() && !fim()){getLista24().get(0).agir(4);}
    }
    
    private static void rodadaAE(){
        if (!getLista21().isEmpty() && !fim()){getLista21().get(0).agir(1);}
        if (!getLista22().isEmpty() && !fim()){getLista22().get(0).agir(2);}
        if (!getLista23().isEmpty() && !fim()){getLista23().get(0).agir(3);}
        if (!getLista24().isEmpty() && !fim()){getLista24().get(0).agir(4);}
        
        if (!getLista11().isEmpty() && !fim()){getLista11().get(0).agir(1);}
        if (!getLista12().isEmpty() && !fim()){getLista12().get(0).agir(2);}
        if (!getLista13().isEmpty() && !fim()){getLista13().get(0).agir(3);}
        if (!getLista14().isEmpty() && !fim()){getLista14().get(0).agir(4);}
    }private static void fimRodada(){
        Guerreiro aux;
        if (!getLista11().isEmpty() && !fim()){aux = getLista11().remove(0);getLista11().add(aux);}
        if (!getLista12().isEmpty() && !fim()){aux = getLista12().remove(0);getLista12().add(aux);}
        if (!getLista13().isEmpty() && !fim()){aux = getLista13().remove(0);getLista13().add(aux);}
        if (!getLista14().isEmpty() && !fim()){aux = getLista14().remove(0);getLista14().add(aux);}
        
        if (!getLista21().isEmpty() && !fim()){aux = getLista21().remove(0);getLista21().add(aux);}
        if (!getLista22().isEmpty() && !fim()){aux = getLista22().remove(0);getLista22().add(aux);}
        if (!getLista23().isEmpty() && !fim()){aux = getLista23().remove(0);getLista23().add(aux);}
        if (!getLista24().isEmpty() && !fim()){aux = getLista24().remove(0);getLista24().add(aux);}
    }
    private static boolean fim(){
        if (
            (getLista11().isEmpty()
            && getLista12().isEmpty()
            && getLista13().isEmpty()
            && getLista14().isEmpty())
            ||(getLista21().isEmpty()
            && getLista22().isEmpty()
            && getLista23().isEmpty()
            && getLista24().isEmpty())
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
