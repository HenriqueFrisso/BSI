package com.mycompany.trabalhopoo.telas;

import javax.swing.JPanel;
/**
 *
 * @author Henrique
 */
public class Tela extends javax.swing.JFrame {
    PainelInicio inicio = new PainelInicio(this);
    PainelCadastro cadastro =  new PainelCadastro(this);
    PainelEndereco endereco = new PainelEndereco(this);
    PainelPerfil perfil = new PainelPerfil(this);
    PainelProcurar procurar = new PainelProcurar(this);
    PainelEsqueciSenha esqueciSenha = new PainelEsqueciSenha(this);
    PainelLoja loja = new PainelLoja(this);

    public Tela() {
        initComponents();
        this.setResizable(false);
        setVisible(true);
        criarPainel(inicio);
        criarPainel(cadastro);
        criarPainel(endereco);
        criarPainel(perfil);
        criarPainel(procurar);
        criarPainel(esqueciSenha);
        criarPainel(loja);
        this.setSize(400,300);
        inicio.setVisible(true);
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
