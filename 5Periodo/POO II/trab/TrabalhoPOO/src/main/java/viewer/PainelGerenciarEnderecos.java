package viewer;

import Controller.Controller;
import Controller.Controller.Tipo;
import com.mycompany.trabalhopoo.Endereco;
import com.mycompany.trabalhopoo.Util;
import java.util.ArrayList;
import javax.swing.JPanel;

public class PainelGerenciarEnderecos extends javax.swing.JPanel {
    Tela tela;
    int qtd = 0;
    ArrayList<JPanel> paineisCriados = new ArrayList<>();
    
    public PainelGerenciarEnderecos(Tela tela) {
        this.tela = tela;
        initComponents();
        iniciar();
        this.setBounds(0, 0, 420, 300);
    }
    @Override
    public void setVisible(boolean aFlag) {
        super.setVisible(aFlag);
        if (aFlag == true){
            iniciar();
            tela.setSize(430,320);
        }
    }
    private void iniciar(){
        carregarEnderecos();
    }
    public void atualizarEnderecos(){
        this.setVisible(false);
        this.setVisible(true);
    }
    private void carregarEnderecos(){
        adicionarPaineisEnderecos(Controller.getEnderecos());
        jPanel2.setPreferredSize(new java.awt.Dimension(0, (qtd*200)));
    } 
    private void adicionarPaineisEnderecos(ArrayList<Endereco> lista){
        JPanel painel;
        qtd = 0;
        jPanel2.removeAll();
        for (Endereco e : lista){
            painel = criarPainelEnderecos(e);
            iniciarPainel(painel);
            qtd++;
        }
    }
    private void iniciarPainel(JPanel painel){
        this.jPanel2.add(painel);
        painel.setBounds(0, (qtd*190), 400, 200);
        painel.setVisible(true);
    }
    private JPanel criarPainelEnderecos(Endereco endereco){
        EnderecosCadastrados item = new EnderecosCadastrados(tela, endereco);
        paineisCriados.add(item);
        return item;
    }
    protected void desativarEnderecos(boolean flag){
        for (JPanel p : paineisCriados){
            Util.desativarComponentes(p, flag);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();

        jPanel1.setBackground(new java.awt.Color(170, 210, 235));
        jPanel1.setPreferredSize(new java.awt.Dimension(100, 46));

        jButton1.setBackground(new java.awt.Color(230, 240, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 140, 0));
        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(230, 240, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 140, 0));
        jButton2.setText("Confirmar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(200, 230, 255));
        jPanel2.setForeground(new java.awt.Color(200, 230, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 459, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if( Controller.getTipoAtual() == Tipo.USUARIO){
            tela.alterarPainel(this, tela.perfil); 
        }else{
            tela.alterarPainel(this, tela.loja);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if( Controller.getTipoAtual() == Tipo.USUARIO){
            tela.alterarPainel(this, tela.perfil); 
        }else{
            tela.alterarPainel(this, tela.loja);
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    protected javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
