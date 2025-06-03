
package domain;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

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
    public static boolean isDouble(String str) {
        try {
            Double.valueOf(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    private static Color azul = new Color(230,240,255);
    private static Color vermelho = new Color(255, 200, 200);
    public static boolean validarCampo(JTextField campo, boolean condicaoValida) {
        if (condicaoValida) {
            campo.setBackground(azul); // ou a cor padrão
            return true;
        } else {
            campo.setBackground(vermelho); // marca como inválido
            return false;
        }
    }

    public static boolean validarCampoSenha(JPasswordField campo, boolean condicaoValida) {
        if (condicaoValida) {
            campo.setBackground(azul);
            return true;
        } else {
            campo.setBackground(vermelho);
            return false;
        }
    }
    public static boolean validarLabel(JLabel campo, boolean condicaoValida) {
        if (condicaoValida) {
            campo.setBorder(BorderFactory.createLineBorder(new Color(200, 230, 255), 2)); // azul se válido
            return true;
        } else {
            campo.setBorder(BorderFactory.createLineBorder(new Color(255, 102, 102), 2)); // vermelho se inválido
            return false;
        }
    }
    public static boolean validarImagemLabel(JLabel label) {
        if (label.getIcon() != null) {
            label.setBorder(BorderFactory.createLineBorder(new Color(200, 230, 255), 2)); // azul se válido
            return true;
        } else {
            label.setBorder(BorderFactory.createLineBorder(new Color(255, 102, 102), 2)); // vermelho se inválido
            return false;
        }
    }
    
    public static byte[] converterImagemParaBytes(ImageIcon icon) {
        if (icon == null) return null;

        try {
            // 1. Converter ImageIcon para BufferedImage
            java.awt.Image img = icon.getImage();
            BufferedImage bufferedImage = new BufferedImage(
                    img.getWidth(null),
                    img.getHeight(null),
                    BufferedImage.TYPE_INT_ARGB // ou TYPE_INT_RGB se não quiser transparência
            );
            bufferedImage.getGraphics().drawImage(img, 0, 0, null);

            // 2. Escrever a imagem em um ByteArrayOutputStream
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "png", baos); // ou "jpg" dependendo do formato
            baos.flush();
            byte[] imageInBytes = baos.toByteArray();
            baos.close();

            return imageInBytes;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static ImageIcon converterBytesParaImageIcon(byte[] img){
        try{
            ByteArrayInputStream bais = new ByteArrayInputStream(img);
            Image imagem = ImageIO.read(bais);
            return new ImageIcon(imagem);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public static ImageIcon converterParaImageIconRedimensionado(byte[] bytesImagem, int largura, int altura) {
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(bytesImagem);
            BufferedImage imagemOriginal = ImageIO.read(bais);

            Image imagemRedimensionada = imagemOriginal.getScaledInstance(largura, altura, Image.SCALE_SMOOTH);
            return new ImageIcon(imagemRedimensionada);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
