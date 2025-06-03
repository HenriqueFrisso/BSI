package viewer;

import DAO.EnderecoDAO;
import DAO.LojaDAO;
import DAO.UsuarioDAO;
import domain.Endereco;
import domain.Loja;
import domain.Usuario;
import domain.Util;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PainelCadastrarEnderecos extends javax.swing.JPanel {
    Tela tela;
    ArrayList<Endereco> enderecos = new ArrayList<>();

    public PainelCadastrarEnderecos(Tela tela) {
        this.tela = tela;
        this.setBounds(0, 0, 463, 362);
        initComponents();
        iniciar();
    }
    @Override
    public void setVisible(boolean aFlag) {
        super.setVisible(aFlag);
        if (aFlag == true){
            enderecos.clear();
            iniciar();
            tela.setSize(463,362);
        }
    }
    private void iniciar(){
        carregarEnderecosNaTabela(this.tabelaEnderecos, enderecos);
        carregarTextos();
        carregarCombo();
    }
    private void carregarTextos(){
        cep.setText("");
        cep.setBackground(new Color(230,240,255));
        numero.setText("");
        numero.setBackground(new Color(230,240,255));
        cidade.setText("");
        cidade.setBackground(new Color(230,240,255));
        rua.setText("");
        rua.setBackground(new Color(230,240,255));
    }
    private void carregarCombo() {
        String[] estados = {
            "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", 
            "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"
        };
        cmbEstados.removeAllItems();
        for (String estado : estados) {
            cmbEstados.addItem(estado);
        }
        cmbEstados.setSelectedItem("ES");
    }
    
    
    public void carregarEnderecosNaTabela(JTable tabela, ArrayList<Endereco> enderecos) {
        String[] colunas = { "CEP", "Número", "Estado", "Cidade", "Rua" };
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0); // 0 linhas inicialmente

        for (Endereco e : enderecos) {
            Object[] linha = {
                e.getCep(),
                e.getNumero(),
                e.getEstado(),
                e.getCidade(),
                e.getRua()
            };
            modelo.addRow(linha);
        }

        tabela.setModel(modelo);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cep = new javax.swing.JTextField();
        cidade = new javax.swing.JTextField();
        rua = new javax.swing.JTextField();
        cmbEstados = new javax.swing.JComboBox<>();
        numero = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaEnderecos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jMenuItem1.setText("Alterar");
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setText("Excluir");
        jPopupMenu1.add(jMenuItem2);

        jPanel1.setBackground(new java.awt.Color(200, 230, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 140, 0));
        jLabel1.setText("Endereços");

        jPanel2.setBackground(new java.awt.Color(200, 230, 255));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 140, 0));
        jLabel2.setText("CEP");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 140, 0));
        jLabel3.setText("Estado");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 140, 0));
        jLabel4.setText("Cidade");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 140, 0));
        jLabel5.setText("Rua");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 140, 0));
        jLabel6.setText("Num");

        cep.setBackground(new java.awt.Color(230, 240, 255));
        cep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cepKeyReleased(evt);
            }
        });

        cidade.setBackground(new java.awt.Color(230, 240, 255));

        rua.setBackground(new java.awt.Color(230, 240, 255));

        cmbEstados.setBackground(new java.awt.Color(230, 240, 255));
        cmbEstados.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        numero.setBackground(new java.awt.Color(230, 240, 255));
        numero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                numeroKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cep, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbEstados, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numero, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cidade, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rua)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cmbEstados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(cidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabelaEnderecos.setBackground(new java.awt.Color(230, 240, 255));
        tabelaEnderecos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "CEP", "Estado", "Cidade", "Rua", "Num"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabelaEnderecos.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tabelaEnderecos);

        jButton1.setBackground(new java.awt.Color(230, 240, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 140, 0));
        jButton1.setText("Finalizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(230, 240, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 140, 0));
        jButton2.setText("Voltar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(230, 240, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 140, 0));
        jButton3.setText("Cadastrar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(12, Short.MAX_VALUE))
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
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Usuario usuario = null;
        Loja loja = null;
        if (this.tela.cadastro.radioUsuario.isSelected() == true){
            String nome = this.tela.cadastro.nomeUsuario.getText();
            String email = this.tela.cadastro.email.getText();
            char[] senhaChars = this.tela.cadastro.senha.getPassword();
            String senha = new String(senhaChars);
            String cpf = this.tela.cadastro.cpf.getText();
            String dataTexto = this.tela.cadastro.dataNasc.getText();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date data = null;
            try {
                data = formato.parse(dataTexto);
            } catch (ParseException ex) {
                Logger.getLogger(PainelCadastrarEnderecos.class.getName()).log(Level.SEVERE, null, ex);
            }
            usuario = new Usuario(nome, email, senha, cpf, data);
            UsuarioDAO.cadastrarUsuario(usuario);
        }else{
            String nome = this.tela.cadastro.nomeLoja.getText().trim();
            String telefone = this.tela.cadastro.telefone.getText().trim();
            String cnpj = this.tela.cadastro.cnpj.getText().trim();
            String codigo = this.tela.cadastro.codigo.getText();
            ImageIcon icon = (ImageIcon) this.tela.cadastro.lblLogo.getIcon();
            byte[] imagemBytes = Util.converterImagemParaBytes(icon);
            
            loja = new Loja(nome, telefone, cnpj, codigo, imagemBytes);
            LojaDAO.cadastrarLoja(loja);

        }
        System.out.println("aaaaaaa");
        for (Endereco endereco : enderecos) {
            if (usuario != null){
                EnderecoDAO.adicionarEndereco(endereco, usuario);
            }else{
                EnderecoDAO.adicionarEndereco(endereco, loja);
            }
        }
        System.out.println("aaaaaaa");
        tela.alterarPainel(this, tela.inicio);
        tela.cadastro.iniciar();
    }//GEN-LAST:event_jButton1ActionPerformed
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        tela.alterarPainel(this, tela.cadastro);
    }//GEN-LAST:event_jButton2ActionPerformed
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String cep = this.cep.getText().trim();
        String num = this.numero.getText().trim();
        String estado = (this.cmbEstados.getSelectedItem()).toString();
        String cidade = this.cidade.getText().trim();
        String rua = this.rua.getText().trim();
        
        boolean cepValido = Util.validarCampo(this.cep, cep.matches("^\\d{5}\\-\\d{3}$"));
        boolean numValido = Util.validarCampo(this.numero, !(num.equals("")));
        boolean cidadeValido = Util.validarCampo(this.cidade, cidade.length() >= 4);
        boolean ruaValido = Util.validarCampo(this.rua, rua.length() >= 4);
        
        StringBuilder mensagensErro = new StringBuilder();

        if (!cepValido) mensagensErro.append("• CEP inválido. Ex: 00000-000\n");
        if (!numValido) mensagensErro.append("• Número não pode ser vazio\n");
        if (!cidadeValido) mensagensErro.append("• Cidade deve conter pelo menos 4 caracteres.\n");
        if (!ruaValido) mensagensErro.append("• Rua deve conter pelo menos 4 caracteres.\n");

        if (cepValido && numValido && cidadeValido && ruaValido) {
            Endereco endereco = new Endereco(estado, cidade, rua, num, cep);
            enderecos.add(endereco);
            iniciar();
        } else {
            JOptionPane.showMessageDialog(null, mensagensErro.toString(), "Erro de Validação", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed
    private void cepKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cepKeyReleased
        String texto = cep.getText().replaceAll("\\D", "");
        int tam = texto.length();
        if (tam > 8) {
            texto = texto.substring(0, 8);
        }
        if (tam >= 5) {
            texto = String.format("%s-%s",
                texto.substring(0, 5),
                texto.substring(5));
        }
        cep.setText(texto);
    }//GEN-LAST:event_cepKeyReleased
    private void numeroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numeroKeyReleased
        String texto = numero.getText().replaceAll("\\D", "");
        numero.setText(texto);
    }//GEN-LAST:event_numeroKeyReleased
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cep;
    private javax.swing.JTextField cidade;
    private javax.swing.JComboBox<String> cmbEstados;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField numero;
    private javax.swing.JTextField rua;
    private javax.swing.JTable tabelaEnderecos;
    // End of variables declaration//GEN-END:variables
}
