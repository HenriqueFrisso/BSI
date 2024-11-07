package ageofmythology.util;

import ageofmythology.guerreiros.Guerreiro;
import java.util.LinkedList;

public class Fila {
    private final LinkedList<Guerreiro> guerreiros;

    public Fila(LinkedList<Guerreiro> lista) {
        this.guerreiros = lista;
    }
}
