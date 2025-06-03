package viewer;

import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author Henrique
 */

public class Tela extends javax.swing.JFrame {
    
    Dimension d = new Dimension(400, 300);
    PainelInicio inicio = new PainelInicio(this);
    PainelCadastro cadastro =  new PainelCadastro(this);
    PainelCadastrarEnderecos cadastrarEnderecos = new PainelCadastrarEnderecos(this);
    PainelPerfil perfil = new PainelPerfil(this);
    PainelProcurar procurar = new PainelProcurar(this);
    PainelLoja loja = new PainelLoja(this);
    PainelComprar comprar = new PainelComprar(this);
    PainelCarrinho carrinho = new PainelCarrinho(this);
    PainelGerenciarEnderecos gerenciarEnderecos = new PainelGerenciarEnderecos(this);
    PainelGerenciarProdutos gerenciarProdutos = new PainelGerenciarProdutos(this);
    PainelConfirmarCodigo confirmarCodigo = new PainelConfirmarCodigo(this);
    PainelRecuperarCredenciais recuperarCredenciais = new PainelRecuperarCredenciais(this);

    public Tela() {
        initComponents();
        this.setSize(400,300);
        this.setResizable(false);
        setVisible(true);
        iniciar();
        inicio.setVisible(true);
    }
    private void iniciar(){
        criarPainel(inicio);
        criarPainel(cadastro);
        criarPainel(cadastrarEnderecos);
        criarPainel(perfil);
        criarPainel(procurar);
        criarPainel(recuperarCredenciais);
        criarPainel(loja);
        criarPainel(comprar);
        criarPainel(carrinho);
        criarPainel(gerenciarEnderecos);
        criarPainel(gerenciarProdutos);
        criarPainel(confirmarCodigo);
    }
    private void criarPainel(JPanel painel){
        add(painel);
        painel.setVisible(false);
    }
    public void alterarPainel(JPanel esconder, JPanel mostrar){
        esconder.setVisible(false);
        mostrar.setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
