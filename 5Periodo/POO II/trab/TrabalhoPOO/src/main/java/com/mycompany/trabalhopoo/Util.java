
package com.mycompany.trabalhopoo;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.Random;
import javax.swing.JPanel;

public class Util {
    public static String gerarCodigo(int tamanho) {
        Random random = new Random();
        StringBuilder sequencia = new StringBuilder();

        for (int i = 0; i < tamanho; i++) {
            int digito = random.nextInt(10); 
            sequencia.append(digito);
        }
        return sequencia.toString();
    }
    public static void copiarParaClipboard(String texto) {
        StringSelection selecao = new StringSelection(texto);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selecao, null);
    }
    public static void desativarComponentes(JPanel panel, boolean estado) {
        for (java.awt.Component comp : panel.getComponents()) {
            comp.setEnabled(estado);
            if (comp instanceof JPanel) {
                desativarComponentes((JPanel) comp, estado); // Chama recursivamente para subpainéis
            }
        }  
    }
}
