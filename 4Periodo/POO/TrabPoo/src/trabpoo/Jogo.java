package trabpoo;

import static java.lang.Math.random;
import java.util.ArrayList;
import trabpoo.classes.Guerreiro;
import trabpoo.classes.Tipos.GiganteDePedra;



public class Jogo {
    static int turno;
    
    private static final ArrayList<Guerreiro> lista11 = new ArrayList<>();
    private static final ArrayList<Guerreiro> lista12 = new ArrayList<>();
    private static final ArrayList<Guerreiro> lista13 = new ArrayList<>();
    private static final ArrayList<Guerreiro> lista14 = new ArrayList<>();
    
    private static final ArrayList<Guerreiro> lista21 = new ArrayList<>();
    private static final ArrayList<Guerreiro> lista22 = new ArrayList<>();
    private static final ArrayList<Guerreiro> lista23 = new ArrayList<>();
    private static final ArrayList<Guerreiro> lista24 = new ArrayList<>();
    
    public static ArrayList<Guerreiro> getLista11(){return lista11;}
    public static ArrayList<Guerreiro> getLista12(){return lista12;}
    public static ArrayList<Guerreiro> getLista13(){return lista13;}
    public static ArrayList<Guerreiro> getLista14(){return lista14;}
    
    public static ArrayList<Guerreiro> getLista21(){return lista21;}
    public static ArrayList<Guerreiro> getLista22(){return lista22;}
    public static ArrayList<Guerreiro> getLista23(){return lista23;}
    public static ArrayList<Guerreiro> getLista24(){return lista24;}
    
    public static int provocar(int pos) {
        if (!lista11.isEmpty() && (lista11.getFirst().getClass() == GiganteDePedra.class)) {return 1;}
        else if (!lista12.isEmpty() && (lista12.getFirst().getClass() == GiganteDePedra.class)) {return 2;}
        else if (!lista13.isEmpty() && (lista13.getFirst().getClass() == GiganteDePedra.class)) {return 3;}
        else if (!lista14.isEmpty() && (lista14.getFirst().getClass() == GiganteDePedra.class)) {return 4;}
        else {return pos;}
    }
    
    public static int verificarFilas(int pos, int lado) {
        ArrayList<Guerreiro> lista1, lista2, lista3, lista4;

        if (lado == 1) {
            lista1 = lista21;
            lista2 = lista22;
            lista3 = lista23;
            lista4 = lista24;
        } else {
            lista1 = lista11;
            lista2 = lista12;
            lista3 = lista13;
            lista4 = lista14;
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
        if (!lista11.isEmpty() && !fim()){lista11.getFirst().agir(1);}
        if (!lista12.isEmpty() && !fim()){lista12.getFirst().agir(2);}
        if (!lista13.isEmpty() && !fim()){lista13.getFirst().agir(3);}
        if (!lista14.isEmpty() && !fim()){lista14.getFirst().agir(4);}
        
        if (!lista21.isEmpty() && !fim()){lista21.getFirst().agir(1);}
        if (!lista22.isEmpty() && !fim()){lista22.getFirst().agir(2);}
        if (!lista23.isEmpty() && !fim()){lista23.getFirst().agir(3);}
        if (!lista24.isEmpty() && !fim()){lista24.getFirst().agir(4);}
    }
    
    private static void rodadaAE(){
        if (!lista21.isEmpty() && !fim()){lista21.getFirst().agir(1);}
        if (!lista22.isEmpty() && !fim()){lista22.getFirst().agir(2);}
        if (!lista23.isEmpty() && !fim()){lista23.getFirst().agir(3);}
        if (!lista24.isEmpty() && !fim()){lista24.getFirst().agir(4);}
        
        if (!lista11.isEmpty() && !fim()){lista11.getFirst().agir(1);}
        if (!lista12.isEmpty() && !fim()){lista12.getFirst().agir(2);}
        if (!lista13.isEmpty() && !fim()){lista13.getFirst().agir(3);}
        if (!lista14.isEmpty() && !fim()){lista14.getFirst().agir(4);}
    }
    private static void fimRodada(){
        Guerreiro aux;
        if (!lista11.isEmpty() && !fim()){aux = lista11.removeFirst();lista11.add(aux);}
        if (!lista12.isEmpty() && !fim()){aux = lista12.removeFirst();lista12.add(aux);}
        if (!lista13.isEmpty() && !fim()){aux = lista13.removeFirst();lista13.add(aux);}
        if (!lista14.isEmpty() && !fim()){aux = lista14.removeFirst();lista14.add(aux);}
        
        if (!lista21.isEmpty() && !fim()){aux = lista21.removeFirst();lista21.add(aux);}
        if (!lista22.isEmpty() && !fim()){aux = lista22.removeFirst();lista22.add(aux);}
        if (!lista23.isEmpty() && !fim()){aux = lista23.removeFirst();lista23.add(aux);}
        if (!lista24.isEmpty() && !fim()){aux = lista24.removeFirst();lista24.add(aux);}
    }
    private static boolean fim(){
        if (
            (lista11.isEmpty()
            && lista12.isEmpty()
            && lista13.isEmpty()
            && lista14.isEmpty())
            ||(lista21.isEmpty()
            && lista22.isEmpty()
            && lista23.isEmpty()
            && lista24.isEmpty())
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
