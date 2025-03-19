package com.mycompany.javaswing;

import javax.swing.table.DefaultTableModel;

public class Tela extends javax.swing.JFrame {

    public static void main(String args[]) {
    }
    public Tela() {
        initComponents();
        iniciar();
        setTitle("Tela");
        setLocationRelativeTo(null);
        this.setSize(445, 475);
    }
    private void iniciar(){
        carregarNome();
        carregarCidades();
        resetarRadio();
        carregarVersao("");
        carregarHD();
        carregarMemoriaRAM();
    }
    
    private void carregarNome(){
    jTextFieldNome.setText("");
    }
    private void carregarCidades(){
        String[] cidades = {"Aracruz", "Colatina", "Serra", "Vitória"};
        jComboBoxCidades.removeAllItems();
        for (String cidade : cidades){
            jComboBoxCidades.addItem(cidade);
        }
        jComboBoxCidades.setSelectedItem("Colatina");
    }
    private void resetarRadio(){
        sistemas.clearSelection();
        processador.clearSelection();
    }
    private void carregarVersao(String version){
        jComboBoxVersao.setEnabled(true);
        String[] windows = {"XP", "Win7", "Win8", "2003 Server", "2008 Server"};
        String[] linux = {"Ubuntu", "Fedora", "Red Hat", "Suse", "Debian"};
        jComboBoxVersao.removeAllItems();
        if (version.equals("Windows")){
            for (String versao : windows){
                jComboBoxVersao.addItem(versao);
            }
            jComboBoxVersao.setSelectedItem("Win8");
        }else if (version.equals("Linux")){
            for (String versao : linux){
                jComboBoxVersao.addItem(versao);
            }
            jComboBoxVersao.setSelectedItem("Ubuntu");
        }else{
            jComboBoxVersao.setEnabled(false);
        }
    }
    private void carregarHD(){
        jCheckBox320GB.setSelected(false);
        jCheckBox500GB.setSelected(true);
        jCheckBox1TB.setSelected(false);
    }
    private void carregarMemoriaRAM(){
        String[] memorias = {"Menos que 1GB", "2GB", "3GB", "4GB", "Mais que 4GB"};
        jListMemoriaRAM.setListData(memorias);
    }
    private void adicionarNaTabela(String nome, String cidade, String so, String versao, String processador, String hd, String memoria) {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.addRow(new Object[]{nome, cidade, so, versao, processador, hd, memoria});
    }
    private void cadastrar() {
        String nome, cidade, so, versao, proc, hd, memoria = "";
        nome = jTextFieldNome.getText();
        cidade = jComboBoxCidades.getSelectedItem().toString();
        so = jRadioButtonWin.isSelected() ? "Windows" : "Linux";
        versao = jComboBoxVersao.getSelectedItem().toString();
        proc = jRadioButtonIntel.isSelected() ? "Intel" : "AMD";

        hd = "";
        if (jCheckBox320GB.isSelected()) hd += "320GB ";
        if (jCheckBox500GB.isSelected()) hd += "500GB ";
        if (jCheckBox1TB.isSelected()) hd += "1TB ";

        memoria = jListMemoriaRAM.getSelectedValue();
        adicionarNaTabela(nome, cidade, so, versao, proc, hd, memoria);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sistemas = new javax.swing.ButtonGroup();
        processador = new javax.swing.ButtonGroup();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        deletar = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jRadioButtonWin = new javax.swing.JRadioButton();
        jRadioButtonLin = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxCidades = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxVersao = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jRadioButtonIntel = new javax.swing.JRadioButton();
        jRadioButtonAMD = new javax.swing.JRadioButton();
        jPanel6 = new javax.swing.JPanel();
        jCheckBox320GB = new javax.swing.JCheckBox();
        jCheckBox500GB = new javax.swing.JCheckBox();
        jCheckBox1TB = new javax.swing.JCheckBox();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListMemoriaRAM = new javax.swing.JList<>();
        jButtonCadastrar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();

        deletar.setText("jMenuItem1");
        deletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(deletar);

        jMenuItem3.setText("jMenuItem3");
        jPopupMenu1.add(jMenuItem3);

        jMenuItem4.setText("jMenuItem4");
        jPopupMenu1.add(jMenuItem4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 255)), "Sis. Operacional", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        sistemas.add(jRadioButtonWin);
        jRadioButtonWin.setText("Windows");
        jRadioButtonWin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonWinActionPerformed(evt);
            }
        });

        sistemas.add(jRadioButtonLin);
        jRadioButtonLin.setText("Linux");
        jRadioButtonLin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonLinActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonWin, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButtonLin, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButtonWin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonLin)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 72, 140, 90));

        jLabel1.setText("Nome");

        jTextFieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 180, 60));

        jLabel2.setText("Cidade");

        jComboBoxCidades.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxCidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCidadesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jComboBoxCidades, 0, 134, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxCidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 140, 60));

        jLabel3.setText("Versão");

        jComboBoxVersao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jComboBoxVersao, 0, 88, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxVersao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, -1, 60));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 255)), "Processador", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        processador.add(jRadioButtonIntel);
        jRadioButtonIntel.setText("Intel");
        jRadioButtonIntel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonIntelActionPerformed(evt);
            }
        });

        processador.add(jRadioButtonAMD);
        jRadioButtonAMD.setText("AMD");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonIntel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButtonAMD, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButtonIntel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonAMD)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 140, 80));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 255)), "HD", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jCheckBox320GB.setText("320 GB");
        jCheckBox320GB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox320GBActionPerformed(evt);
            }
        });

        jCheckBox500GB.setText("500 GB");

        jCheckBox1TB.setText("1 TB");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox320GB)
                    .addComponent(jCheckBox500GB)
                    .addComponent(jCheckBox1TB))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jCheckBox320GB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox500GB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBox1TB)
                .addContainerGap())
        );

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, -1, 100));

        jLabel4.setText("Memória RAM");

        jListMemoriaRAM.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jListMemoriaRAM);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 130, 130));

        jButtonCadastrar.setText("Cadastrar");
        jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, -1, -1));

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Cidade", "SO", "Versão", "Processador", "HD", "Memória"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setComponentPopupMenu(jPopupMenu1);
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(6).setResizable(false);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 370, 120));

        jLabel5.setText("Relatório");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeActionPerformed

    private void jRadioButtonLinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonLinActionPerformed
    carregarVersao("Linux");        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonLinActionPerformed

    private void jRadioButtonWinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonWinActionPerformed
    carregarVersao("Windows");        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonWinActionPerformed

    private void jRadioButtonIntelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonIntelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonIntelActionPerformed

    private void jCheckBox320GBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox320GBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox320GBActionPerformed

    private void jComboBoxCidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCidadesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCidadesActionPerformed

    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarActionPerformed
        cadastrar();
        iniciar();        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCadastrarActionPerformed

    private void deletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deletarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem deletar;
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JCheckBox jCheckBox1TB;
    private javax.swing.JCheckBox jCheckBox320GB;
    private javax.swing.JCheckBox jCheckBox500GB;
    private javax.swing.JComboBox<String> jComboBoxCidades;
    private javax.swing.JComboBox<String> jComboBoxVersao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<String> jListMemoriaRAM;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JRadioButton jRadioButtonAMD;
    private javax.swing.JRadioButton jRadioButtonIntel;
    private javax.swing.JRadioButton jRadioButtonLin;
    private javax.swing.JRadioButton jRadioButtonWin;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.ButtonGroup processador;
    private javax.swing.ButtonGroup sistemas;
    // End of variables declaration//GEN-END:variables
}
