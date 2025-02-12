package trabpoo;


import java.util.ArrayList;
import trabpoo.classes.Guerreiro;
/*
a) (5 pontos) Exiba os dados de ambos lados.
b) (5 pontos) A soma dos pesos de ambos lados.
c) (5 pontos) O guerreiro mais velho e sua idade (se houver empate, pode mostrar
apenas o primeiro)
d) (15 pontos) O lado vencedor (“Gregos e Nórdicos” ou “Atlantes e Egípcios”?).
e) (5 pontos) Os dados do último membro do lado perdedor
f) (5 pontos) Os dados do guerreiro, do lado vencedor, que transferiu o último
ataque no último guerreiro do lado perdedor.
*/
public class Questoes {
    
    private static Guerreiro atacante;
    private static Guerreiro defensor;
    
    
    public static void questA(){
        /*
        a) (5 pontos) Exiba os dados de ambos os lados.
        */
        ArrayList<Guerreiro> ls11 = Jogo.getLista11();
        ArrayList<Guerreiro> ls12 = Jogo.getLista12();
        ArrayList<Guerreiro> ls13 = Jogo.getLista13();
        ArrayList<Guerreiro> ls14 = Jogo.getLista14();
        
        ArrayList<Guerreiro> ls21 = Jogo.getLista21();
        ArrayList<Guerreiro> ls22 = Jogo.getLista22();
        ArrayList<Guerreiro> ls23 = Jogo.getLista23();
        ArrayList<Guerreiro> ls24 = Jogo.getLista24();
        System.out.println("");
        System.out.println("LADO 1:");
        System.out.println("Fila 1:");
        for (int i = 0; i< ls11.size();i++){System.out.print(" -- ");System.out.println(ls11.get(i).getClass().getSimpleName() + ": " + ls11.get(i).getNome() + ", " + ls11.get(i).getIdade() + " anos, " + ls11.get(i).getPeso() + "kilos");}
        System.out.println("Fila 2:");
        for (int i = 0; i< ls12.size();i++){System.out.print(" -- ");System.out.println(ls12.get(i).getClass().getSimpleName() + ": " + ls12.get(i).getNome() + ", " + ls12.get(i).getIdade() + " anos, " + ls12.get(i).getPeso() + "kilos");}
        System.out.println("Fila 3:");
        for (int i = 0; i< ls13.size();i++){System.out.print(" -- ");System.out.println(ls13.get(i).getClass().getSimpleName() + ": " + ls13.get(i).getNome() + ", " + ls13.get(i).getIdade() + " anos, " + ls13.get(i).getPeso() + "kilos");}
        System.out.println("Fila 4:");
        for (int i = 0; i< ls14.size();i++){System.out.print(" -- ");System.out.println(ls14.get(i).getClass().getSimpleName() + ": " + ls14.get(i).getNome() + ", " + ls14.get(i).getIdade() + " anos, " + ls14.get(i).getPeso() + "kilos");}
        System.out.println("");
        System.out.println("LADO 2:");
        System.out.println("Fila 1:");
        for (int i = 0; i< ls21.size();i++){System.out.print(" -- ");System.out.println(ls21.get(i).getClass().getSimpleName() + ": " + ls21.get(i).getNome() + ", " + ls21.get(i).getIdade() + " anos, " + ls21.get(i).getPeso() + "kilos");}
        System.out.println("Fila 2:");
        for (int i = 0; i< ls22.size();i++){System.out.print(" -- ");System.out.println(ls22.get(i).getClass().getSimpleName() + ": " + ls22.get(i).getNome() + ", " + ls22.get(i).getIdade() + " anos, " + ls22.get(i).getPeso() + "kilos");}
        System.out.println("Fila 3:");
        for (int i = 0; i< ls23.size();i++){System.out.print(" -- ");System.out.println(ls23.get(i).getClass().getSimpleName() + ": " + ls23.get(i).getNome() + ", " + ls23.get(i).getIdade() + " anos, " + ls23.get(i).getPeso() + "kilos");}
        System.out.println("Fila 4:");
        for (int i = 0; i< ls24.size();i++){System.out.print(" -- ");System.out.println(ls24.get(i).getClass().getSimpleName() + ": " + ls24.get(i).getNome() + ", " + ls24.get(i).getIdade() + " anos, " + ls24.get(i).getPeso() + "kilos");}
    }
    
    private static int auxB(ArrayList<Guerreiro> lista){
        int peso = 0;
        for(int i = 0; i < lista.size(); i++){
            peso += lista.get(i).getPeso();
        }
        return peso;
    }
    
    public static void questB(){
        /*
        b) (5 pontos) A soma dos pesos de ambos os lados.
        */
        int pesoGN = 0;
        int pesoAE = 0;
        
        pesoGN += auxB(Jogo.getLista11());
        pesoGN += auxB(Jogo.getLista12());
        pesoGN += auxB(Jogo.getLista13());
        pesoGN += auxB(Jogo.getLista14());
        
        pesoAE += auxB(Jogo.getLista21());
        pesoAE += auxB(Jogo.getLista22());
        pesoAE += auxB(Jogo.getLista23());
        pesoAE += auxB(Jogo.getLista24());
        
        System.out.println("");
        System.out.println("Gregos e Nórdicos pesam " + pesoGN + " kilos.");
        System.out.println("Atlantes e Egípcios pesam " + pesoAE + " kilos.");
        
    }
    
    private static Guerreiro auxC(ArrayList<Guerreiro> lista, Guerreiro guerreiro){
        for(int i = 0; i < lista.size(); i++){
            if (lista.get(i).getIdade() > guerreiro.getIdade()){
                guerreiro = lista.get(i);
            }
        }
        return guerreiro;
    }
    
    public static void questC(){
        /*
        c) (5 pontos) O guerreiro mais velho e sua idade (se houver empate, pode mostrar apenas o primeiro)
        */
        Guerreiro aux = new Guerreiro();
        aux = auxC(Jogo.getLista11(), aux);
        aux = auxC(Jogo.getLista12(), aux);
        aux = auxC(Jogo.getLista13(), aux);
        aux = auxC(Jogo.getLista14(), aux);
        
        aux = auxC(Jogo.getLista21(), aux);
        aux = auxC(Jogo.getLista22(), aux);
        aux = auxC(Jogo.getLista23(), aux);
        aux = auxC(Jogo.getLista24(), aux);
        System.out.println("");
        System.out.println("O " + aux.getClass().getSimpleName() + " " + aux.getNome() + " é o mais velho e tem " + aux.getIdade() + " anos");
        System.out.println("");
    }
    
    public static void questD(){
        /*
        d) (15 pontos) O lado vencedor (“Gregos e Nórdicos” ou “Atlantes e Egípcios”?).
        */
        if (Jogo.getLista11().isEmpty() && Jogo.getLista12().isEmpty() && Jogo.getLista13().isEmpty() && Jogo.getLista14().isEmpty()){
            System.out.println("");
            System.out.println("Atlantes e Egípcios venceram.");
            System.out.println("");
        } else if (Jogo.getLista21().isEmpty() && Jogo.getLista22().isEmpty() && Jogo.getLista23().isEmpty() && Jogo.getLista24().isEmpty()){
            System.out.println("");
            System.out.println("Gregos e Nórdicos venceram.");
            System.out.println("");
        } else{
            System.out.println("");
            System.out.println("A guerra não acabou.");
            System.out.println("");
        }
    }
    
    
    public static void auxE(Guerreiro atacante, Guerreiro defensor){
        Questoes.atacante = atacante;
        Questoes.defensor = defensor;
    }
    
    public static void questE(){
        /*
        e) (5 pontos) Os dados do último membro do lado perdedor
        */
        System.out.print("O " + Questoes.defensor.getClass().getSimpleName() + " " + Questoes.defensor.getNome() + " de " + Questoes.defensor.getIdade() + " anos e " + Questoes.defensor.getPeso() + " kilos foi o ultimo a ser derrotado no lado dos ");
        if (Jogo.getLista11().isEmpty() && Jogo.getLista12().isEmpty() && Jogo.getLista13().isEmpty() && Jogo.getLista14().isEmpty()){
            System.out.println("Gregos e Nórdicos");
        } else if (Jogo.getLista21().isEmpty() && Jogo.getLista22().isEmpty() && Jogo.getLista23().isEmpty() && Jogo.getLista24().isEmpty()){
            System.out.println("Atlantes e Egípcios");
        }
    }
    
    public static void questF(){
        /*
        f) (5 pontos) Os dados do guerreiro, do lado vencedor, que transferiu o último
        */
        System.out.println("A " + Questoes.atacante.getClass().getSimpleName() + " " + Questoes.atacante.getNome() + " de " + Questoes.atacante.getIdade() + " anos e " + Questoes.atacante.getPeso() + " kilos transferiu o último ataque no " + Questoes.defensor.getClass().getSimpleName() + " " + Questoes.defensor.getNome() + " de " + Questoes.defensor.getIdade() + " anos e " + Questoes.defensor.getPeso() + " kilos.");
    }
    
    public static void imprimir(){
        ArrayList<Guerreiro> ls11,ls12,ls13,ls14,ls21,ls22,ls23,ls24;
        ls11 = Jogo.getLista11();
        ls12 = Jogo.getLista12();
        ls13 = Jogo.getLista13();
        ls14 = Jogo.getLista14();
        ls21 = Jogo.getLista21();
        ls22 = Jogo.getLista22();
        ls23 = Jogo.getLista23();
        ls24 = Jogo.getLista24();
        System.out.println("----------------------");
        for (int i = 0; i< ls11.size();i++){
            System.out.print(ls11.get(i).getClass().getSimpleName()+"("+ls11.get(i).getEnergia()+"), ");
        }System.out.println("");
        for (int i = 0; i< ls12.size();i++){
            System.out.print(ls12.get(i).getClass().getSimpleName()+"("+ls12.get(i).getEnergia()+"), ");
        }System.out.println("");
        for (int i = 0; i< ls13.size();i++){
            System.out.print(ls13.get(i).getClass().getSimpleName()+"("+ls13.get(i).getEnergia()+"), ");
        }System.out.println("");
        for (int i = 0; i< ls14.size();i++){
            System.out.print(ls14.get(i).getClass().getSimpleName()+"("+ls14.get(i).getEnergia()+"), ");
        }System.out.println("");
        System.out.println("");
        for (int i = 0; i< ls21.size();i++){
            System.out.print(ls21.get(i).getClass().getSimpleName()+"("+ls21.get(i).getEnergia()+"), ");
        }System.out.println("");
        for (int i = 0; i< ls22.size();i++){
            System.out.print(ls22.get(i).getClass().getSimpleName()+"("+ls22.get(i).getEnergia()+"), ");
        }System.out.println("");
        for (int i = 0; i< ls23.size();i++){
            System.out.print(ls23.get(i).getClass().getSimpleName()+"("+ls23.get(i).getEnergia()+"), ");
        }System.out.println("");
        for (int i = 0; i< ls24.size();i++){
            System.out.print(ls24.get(i).getClass().getSimpleName()+"("+ls24.get(i).getEnergia()+"), ");
        }System.out.println("");
    }
}
