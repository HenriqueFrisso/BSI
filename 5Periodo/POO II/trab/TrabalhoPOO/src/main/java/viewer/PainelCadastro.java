package viewer;

import DAO.LojaDAO;
import DAO.UsuarioDAO;
import domain.Util;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PainelCadastro extends javax.swing.JPanel {
    int cadastroAtivo = 0;
    Tela tela;

    public PainelCadastro(Tela tela) {
        this.tela = tela;
        this.setBounds(0, 0, 400, 310);
        initComponents();
        iniciar();
    }
    @Override
    public void setVisible(boolean aFlag) {
        super.setVisible(aFlag);
        if (aFlag == true){
            tela.setSize(410,330);
        }
    }
    protected void iniciar(){
        jPanel2.setVisible(true);
        jPanel3.setVisible(false);
        carregarRadio();
        carregarUsuario();
        carregarLoja();
    }
    private void carregarRadio(){
        radioUsuario.setSelected(true);
        jRadioButton2.setSelected(false);
    }
    private void carregarUsuario(){
        nomeUsuario.setText("");
        nomeUsuario.setBackground(new Color(230,240,255));
        email.setText("");
        email.setBackground(new Color(230,240,255));
        cpf.setText("");
        cpf.setBackground(new Color(230,240,255));
        dataNasc.setText("");
        dataNasc.setBackground(new Color(230,240,255));
        senha.setText("");
        senha.setBackground(new Color(230,240,255));
        confirmarSenha.setText("");
        confirmarSenha.setBackground(new Color(230,240,255));
    }
    private void carregarLoja(){
        nomeLoja.setText("");
        nomeLoja.setBackground(new Color(230,240,255));
        telefone.setText("");
        telefone.setBackground(new Color(230,240,255));
        cnpj.setText("");
        cnpj.setBackground(new Color(230,240,255));
        lblLogo.setIcon(null);
        lblLogo.setBorder(BorderFactory.createLineBorder(new Color(200,230,255), 2));
        codigo.setText("Gerar Código");
        codigo.setBorder(BorderFactory.createLineBorder(new Color(200,230,255), 2));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        radioUsuario = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nomeUsuario = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        cpf = new javax.swing.JTextField();
        dataNasc = new javax.swing.JTextField();
        senha = new javax.swing.JPasswordField();
        confirmarSenha = new javax.swing.JPasswordField();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        nomeLoja = new javax.swing.JTextField();
        telefone = new javax.swing.JTextField();
        cnpj = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        codigo = new javax.swing.JLabel();
        btnUpload = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(200, 230, 255));

        radioUsuario.setBackground(new java.awt.Color(200, 230, 255));
        buttonGroup1.add(radioUsuario);
        radioUsuario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        radioUsuario.setForeground(new java.awt.Color(255, 140, 0));
        radioUsuario.setText("Usuário");
        radioUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioUsuarioActionPerformed(evt);
            }
        });

        jRadioButton2.setBackground(new java.awt.Color(200, 230, 255));
        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(255, 140, 0));
        jRadioButton2.setText("Loja");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 140, 0));
        jLabel1.setText("Selecione o tipo de conta");

        jPanel2.setBackground(new java.awt.Color(200, 230, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 140, 0));
        jLabel2.setText("Nome");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 140, 0));
        jLabel3.setText("E-Mail");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 140, 0));
        jLabel4.setText("CPF");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 140, 0));
        jLabel5.setText("Data de nascimento");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 140, 0));
        jLabel6.setText("Senha");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 140, 0));
        jLabel7.setText("Confirmar Senha");

        nomeUsuario.setBackground(new java.awt.Color(230, 240, 255));

        email.setBackground(new java.awt.Color(230, 240, 255));

        cpf.setBackground(new java.awt.Color(230, 240, 255));
        cpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cpfKeyReleased(evt);
            }
        });

        dataNasc.setBackground(new java.awt.Color(230, 240, 255));
        dataNasc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dataNascKeyReleased(evt);
            }
        });

        senha.setBackground(new java.awt.Color(230, 240, 255));

        confirmarSenha.setBackground(new java.awt.Color(230, 240, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nomeUsuario))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(email))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cpf))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataNasc))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(confirmarSenha))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(senha)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(dataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(confirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(200, 230, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(0, 175));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 140, 0));
        jLabel8.setText("Nome");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 140, 0));
        jLabel9.setText("Telefone");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 140, 0));
        jLabel10.setText("CNPJ");

        nomeLoja.setBackground(new java.awt.Color(230, 240, 255));

        telefone.setBackground(new java.awt.Color(230, 240, 255));
        telefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                telefoneKeyReleased(evt);
            }
        });

        cnpj.setBackground(new java.awt.Color(230, 240, 255));
        cnpj.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cnpjKeyReleased(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 140, 0));
        jLabel11.setText("Código de Acesso:");

        codigo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        codigo.setText("Gerar Código");
        codigo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                codigoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                codigoMouseEntered(evt);
            }
        });

        btnUpload.setBackground(new java.awt.Color(230, 240, 255));
        btnUpload.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUpload.setForeground(new java.awt.Color(255, 140, 0));
        btnUpload.setText("Selecionar Imagem");
        btnUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(230, 240, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 140, 0));
        jButton2.setText("Copiar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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
                        .addComponent(btnUpload)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 186, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cnpj)
                            .addComponent(nomeLoja)
                            .addComponent(telefone)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(nomeLoja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUpload, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(codigo)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        jButton1.setBackground(new java.awt.Color(230, 240, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 140, 0));
        jButton1.setText("Cadastrar Endereços");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radioUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioUsuario)
                    .addComponent(jRadioButton2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    private void radioUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioUsuarioActionPerformed
        jPanel2.setVisible(true);
        jPanel3.setVisible(false);
        if (cadastroAtivo == 1){
            carregarUsuario();
            cadastroAtivo = 0;
        }
    }//GEN-LAST:event_radioUsuarioActionPerformed
    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        jPanel3.setVisible(true);
        jPanel2.setVisible(false);
        if (cadastroAtivo == 0){
            carregarLoja();
            cadastroAtivo = 1;
        }
    }//GEN-LAST:event_jRadioButton2ActionPerformed
    private void cpfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cpfKeyReleased
        String texto = cpf.getText().replaceAll("\\D", "");
        int tam = texto.length();
        if (tam > 11) {
            texto = texto.substring(0, 11);
        }
        if (tam >= 4 && tam <= 6) {
            texto = String.format("%s.%s",
                texto.substring(0, 3),
                texto.substring(3));
        }
        else if (tam >= 7 && tam <= 9) {
            texto = String.format("%s.%s.%s",
                texto.substring(0, 3),
                texto.substring(3, 6),
                texto.substring(6));
        }
        else if (tam >= 10) {
            texto = String.format("%s.%s.%s-%s",
                texto.substring(0, 3),
                texto.substring(3, 6),
                texto.substring(6, 9),
                texto.substring(9));
        }
        cpf.setText(texto);
    }//GEN-LAST:event_cpfKeyReleased
    private void dataNascKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dataNascKeyReleased
        String texto = dataNasc.getText().replaceAll("\\D", "");
        int tam = texto.length();
        if (tam > 8) {
            texto = texto.substring(0, 8);
        }
        if (tam >= 3 && tam <= 4) {
            texto = String.format("%s/%s",
                texto.substring(0, 2),
                texto.substring(2));
        }
        else if (tam >=5) {
            texto = String.format("%s/%s/%s",
                texto.substring(0, 2),
                texto.substring(2, 4),
                texto.substring(4));
        }
        dataNasc.setText(texto);
    }//GEN-LAST:event_dataNascKeyReleased
    private void telefoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefoneKeyReleased
        String texto = telefone.getText().replaceAll("\\D", "");
        int tam = texto.length();
        if (tam > 11) {
            texto = texto.substring(0, 11);
        }
        if (tam >= 3 && tam <= 6) {
            texto = String.format("(%s) %s",
                texto.substring(0, 2),
                texto.substring(2));
        }
        else if (tam >= 7 && tam <= 10) {
            texto = String.format("(%s) %s-%s",
                texto.substring(0, 2),
                texto.substring(2, 6),
                texto.substring(6));
        }
        else if (tam >= 10) {
            texto = String.format("(%s) %s %s-%s",
                texto.substring(0, 2),
                texto.substring(2, 3),
                texto.substring(3, 7),
                texto.substring(7));
        }
        telefone.setText(texto);
    }//GEN-LAST:event_telefoneKeyReleased
    private void cnpjKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cnpjKeyReleased
        String texto = cnpj.getText().replaceAll("\\D", "");
        int tam = texto.length();
        if (tam > 14) {
            texto = texto.substring(0, 14);
        }
        if (tam >= 3 && tam <= 5) {
            texto = String.format("%s.%s",
                texto.substring(0, 2),
                texto.substring(2));
        }
        else if (tam >= 6 && tam <= 8) {
            texto = String.format("%s.%s.%s",
                texto.substring(0, 2),
                texto.substring(2, 5),
                texto.substring(5));
        }
        else if (tam >= 9 && tam <= 12) {
            texto = String.format("%s.%s.%s/%s",
                texto.substring(0, 2),
                texto.substring(2, 5),
                texto.substring(5, 8),
                texto.substring(8));
        }
        else if (tam >= 13) {
            texto = String.format("%s.%s.%s/%s-%s",
                texto.substring(0, 2),
                texto.substring(2, 5),
                texto.substring(5, 8),
                texto.substring(8,12),
                texto.substring(12));
        }
        cnpj.setText(texto);
    }//GEN-LAST:event_cnpjKeyReleased
    private void codigoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_codigoMouseClicked
        if (codigo.getText().equals("Gerar Código")){
            codigo.setText(Util.gerarCodigo(12));
            codigo.setCursor(Cursor.getDefaultCursor());
        }
    }//GEN-LAST:event_codigoMouseClicked
    private void codigoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_codigoMouseEntered
        if (codigo.getText().equals("Gerar Código")){
            codigo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        }
    }//GEN-LAST:event_codigoMouseEntered
    private void btnUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Imagens", "jpg", "jpeg", "png", "gif"));
        int retorno = fileChooser.showOpenDialog(this);

        if (retorno == JFileChooser.APPROVE_OPTION) {
            File arquivo = fileChooser.getSelectedFile();
            ImageIcon imagem = new ImageIcon(arquivo.getAbsolutePath());
            Image img = imagem.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_SMOOTH);
            lblLogo.setIcon(new ImageIcon(img));
        }
    }//GEN-LAST:event_btnUploadActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (this.radioUsuario.isSelected() == true){
            String nome = this.nomeUsuario.getText().trim();
            String email = this.email.getText().trim();
            String cpf = this.cpf.getText().trim();
            String dataNasc = this.dataNasc.getText().trim();
            String senha = new String(this.senha.getPassword());
            String confirmarSenha = new String(this.confirmarSenha.getPassword());
            boolean nomeValido = Util.validarCampo(this.nomeUsuario, nome.length() >= 4);
            boolean emailValido = Util.validarCampo(this.email, email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$"));
            boolean cpfValido = Util.validarCampo(this.cpf, cpf.matches("^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$"));
            boolean dataValida = Util.validarCampo(this.dataNasc, dataNasc.matches("^\\d{2}/\\d{2}/\\d{4}$"));
            boolean senhaValida = Util.validarCampoSenha(this.senha, senha.length() >= 6);
            boolean confirmarSenhaValida = Util.validarCampoSenha(this.confirmarSenha, senha.equals(confirmarSenha) && senhaValida);
            
            StringBuilder mensagensErro = new StringBuilder();

            if (!nomeValido) mensagensErro.append("• Nome deve conter pelo menos 4 caracteres.\n");
            if (!emailValido) mensagensErro.append("• Email inválido. Ex: nome@dominio.com\n");
            if (!cpfValido) mensagensErro.append("• CPF inválido. Use o formato 000.000.000-00\n");
            if (!dataValida) mensagensErro.append("• Data de nascimento inválida. Use o formato dd/mm/aaaa\n");
            if (!senhaValida) mensagensErro.append("• Senha deve conter pelo menos 6 caracteres.\n");
            if (!confirmarSenhaValida) mensagensErro.append("• Senha e Confirmar Senha devem ser iguais.\n");

            if ((nomeValido && emailValido && cpfValido && dataValida && senhaValida && confirmarSenhaValida) && (UsuarioDAO.getUsuario(email) == null)) {
                tela.alterarPainel(this, tela.cadastrarEnderecos);
            } else {
                if (UsuarioDAO.getUsuario(email) == null){
                    JOptionPane.showMessageDialog(null, mensagensErro.toString(), "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "E-Mail já cadastrado.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                }
            }
        }else{
            String nome = this.nomeLoja.getText().trim();
            String telefone = this.telefone.getText().trim();
            String cnpj = this.cnpj.getText().trim();
            String codigo = this.codigo.getText();
            boolean nomeValido = Util.validarCampo(this.nomeLoja, nome.length() >= 4);
            boolean telefoneValido = Util.validarCampo(this.telefone, telefone.matches("^\\(\\d{2}\\) \\d \\d{4}-\\d{4}$"));
            boolean cnpjValido = Util.validarCampo(this.cnpj, cnpj.matches("^\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}$"));
            boolean codigoValido = Util.validarLabel(this.codigo, !(codigo.equals("Gerar Código")));
            boolean imagemValido = Util.validarImagemLabel(this.lblLogo);
            
            StringBuilder mensagensErro = new StringBuilder();

            if (!nomeValido) mensagensErro.append("• Nome da loja deve conter pelo menos 4 caracteres.\n");
            if (!telefoneValido) mensagensErro.append("• Telefone inválido. Ex: (11) 9 1234-5678\n");
            if (!cnpjValido) mensagensErro.append("• CNPJ inválido. Use o formato 00.000.000/0000-00\n");
            if (!codigoValido) mensagensErro.append("• Código da loja não foi gerado.\n");
            if (!imagemValido) mensagensErro.append("• Logo da loja não foi selecionado.\n");

            if ((nomeValido && telefoneValido && cnpjValido && codigoValido && imagemValido) && (LojaDAO.getLoja(cnpj) == null)) {
                tela.alterarPainel(this, tela.cadastrarEnderecos);
            } else {
                if (LojaDAO.getLoja(cnpj) == null){
                    JOptionPane.showMessageDialog(null, mensagensErro.toString(), "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "CNPJ já cadastrado.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                }
            }
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Util.copiarParaClipboard(codigo.getText());
    }//GEN-LAST:event_jButton2ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUpload;
    private javax.swing.ButtonGroup buttonGroup1;
    protected javax.swing.JTextField cnpj;
    protected javax.swing.JLabel codigo;
    private javax.swing.JPasswordField confirmarSenha;
    protected javax.swing.JTextField cpf;
    protected javax.swing.JTextField dataNasc;
    protected javax.swing.JTextField email;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton2;
    protected javax.swing.JLabel lblLogo;
    protected javax.swing.JTextField nomeLoja;
    protected javax.swing.JTextField nomeUsuario;
    protected javax.swing.JRadioButton radioUsuario;
    protected javax.swing.JPasswordField senha;
    protected javax.swing.JTextField telefone;
    // End of variables declaration//GEN-END:variables
}
