/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

/**
 *
 * @author icety
 */
import java.sql.*;
import db.Conection.Conexao;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import com.placeholder.PlaceHolder;
import java.awt.Color;
import java.awt.Component;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class TelaProdutoDiverso extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    Conexao con = new Conexao();
    
    DefaultTableModel modelo;
    PlaceHolder placeholder;

    /**
     * Creates new form TelaUsuario
     */
    public TelaProdutoDiverso() {
        initComponents();
        txtProdutoPreco.setDocument(new SoNumeroEPontos());
        try {
            conexao = Conexao.conector();
            PlaceHolder placeholder = new PlaceHolder(txtProdutoPesquisar, "Digite o nome do produto..");
        } catch (SQLException ex) {
            Logger.getLogger(TelaProdutoDiverso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void RefreshTable(){
        
        
        
        try {
            ((DefaultTableModel) tblProdutoDiverso.getModel()).setNumRows(0);
            tblProdutoDiverso.updateUI();
            conexao = Conexao.conector();
            ResultSet rs = con.ConsultarAllProdutoDiverso();
            
            int id = 0;
             String _nomeproduto = null, _preco = null, _quantidade = null;
            
            while (rs.next()) {
                    id = rs.getInt("id");
                    _nomeproduto = rs.getString("nomeproduto");
                    _preco = rs.getString("preco");
                    _quantidade = rs.getString("quantidade");

                    modelo = (DefaultTableModel) tblProdutoDiverso.getModel();
                    modelo.addRow(new Object[]{"" + id, _nomeproduto, _preco, _quantidade});

                }
            
            
            tblProdutoDiverso.repaint();
            
            txtProdutoNome.setText("");
            txtProdutoPreco.setText("");
            cboProdutoQuantidade.setSelectedIndex(0);
                    
            
                 int ultimaLinha = tblProdutoDiverso.getModel().getRowCount() -1;
                 
                 tblProdutoDiverso.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
                @Override
                public Component getTableCellRendererComponent(JTable jtable, Object o,
                        boolean isSelected, boolean hasFocus , int row, int column) {
                    Component comp =  super.getTableCellRendererComponent(jtable, o, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
                    
                    //Pintando linha                   
                    comp.setBackground(row == tblProdutoDiverso.getRowCount() -1 ? Color.YELLOW : null);
                    
                   
            
                    return comp;
                    
                }
                     
                 });
                 
                 tblProdutoDiverso.scrollRectToVisible(tblProdutoDiverso.getCellRect(ultimaLinha, 0, false));
                 
                  
            
        } catch (SQLException ex) {
            Logger.getLogger(TelaCadastroProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void cadastrarProdutoDiverso() {
        String sql;
        sql = "insert into produtosdiversos(nomeproduto, preco, quantidade, data) values (?, ?, ?, ?)";
        try {
            
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtProdutoNome.getText());
            pst.setString(2, txtProdutoPreco.getText());
            pst.setString(3, (String) cboProdutoQuantidade.getSelectedItem());
            pst.setString(4, txtDataInsumo.getText());

            if (txtProdutoNome.getText().isEmpty() || txtProdutoPreco.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
            } else {

                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso");
                    txtProdutoNome.setText(null);
                    txtProdutoPreco.setText(null);
                }
            }
            
            int ultimaLinha = tblProdutoDiverso.getModel().getRowCount() -1;
            
            tblProdutoDiverso.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
                @Override
                public Component getTableCellRendererComponent(JTable jtable, Object o,
                        boolean isSelected, boolean hasFocus , int row, int column) {
                    Component comp =  super.getTableCellRendererComponent(jtable, o, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
                    
                    //Pintando linha                   
                    comp.setBackground(row == tblProdutoDiverso.getRowCount() -1 ? Color.YELLOW : null);
                    
                   
            
                    return comp;
                    
                }
                     
                });
            
            tblProdutoDiverso.scrollRectToVisible(tblProdutoDiverso.getCellRect(ultimaLinha, 0, false));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    private void pesquisarProdutoDiverso() {
//        String sql = "select * from produtosdiversos where nomeproduto like ?";
//        try {
//            pst = conexao.prepareStatement(sql);
//            pst.setString(1, txtProdutoPesquisar.getText() + "%");
//            rs = pst.executeQuery();
//            
//            // usando a biblioteca importada.
//            tblProdutoDiverso.setModel(DbUtils.resultSetToTableModel(rs));
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
        
        try {
            ((DefaultTableModel) tblProdutoDiverso.getModel()).setNumRows(0);
            tblProdutoDiverso.updateUI();
            conexao = Conexao.conector();
            ResultSet rs = con.ConsultarProdutoDiverso(txtProdutoPesquisar.getText());
             int id = 0;
             String _nome = null, _preco = null, _quantidade = null;
             
             while (rs.next()) {
                    id = rs.getInt("id");
                    _nome = rs.getString("nomeproduto");
                    _preco = rs.getString("preco");
                    _quantidade = rs.getString("quantidade");

                    modelo = (DefaultTableModel) tblProdutoDiverso.getModel();
                    modelo.addRow(new Object[]{"" + id, _nome, _preco, _quantidade});

                }
            
        } catch (SQLException ex) {
            Logger.getLogger(TelaCadastroProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void setar_campos() {
        
        txtProdutoId.setText(tblProdutoDiverso.getValueAt((tblProdutoDiverso.getSelectedRow()), 0).toString());
        txtProdutoNome.setText(tblProdutoDiverso.getValueAt((tblProdutoDiverso.getSelectedRow()), 1).toString());
        txtProdutoPreco.setText(tblProdutoDiverso.getValueAt((tblProdutoDiverso.getSelectedRow()), 2).toString());
        String quantidade = tblProdutoDiverso.getValueAt((tblProdutoDiverso.getSelectedRow()), 3).toString();
        cboProdutoQuantidade.setSelectedItem(quantidade);
        
        
        
        btnProdutoCadastrar.setEnabled(false);
        
        JOptionPane.showMessageDialog(null, "Os dados do produto estão no formulário", "Atenção", JOptionPane.INFORMATION_MESSAGE);
       
    }
    
    private void alterarProdutoDiverso() {
        String sql = "update produtosdiversos set nomeproduto=?, quantidade=?, preco=?, data=? where id=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtProdutoNome.getText());
            pst.setString(2, (String) cboProdutoQuantidade.getSelectedItem());
            pst.setString(3, txtProdutoPreco.getText());
            pst.setString(4, txtDataInsumo.getText());
            pst.setString(5, txtProdutoId.getText());
            
            if(txtProdutoNome.getText().isEmpty() || txtProdutoPreco.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
            } else {                            
            
                int adicionado = pst.executeUpdate();
                if(adicionado > 0){
                    JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso");
                    txtProdutoId.setText(null);
                    txtProdutoNome.setText(null);
                    txtProdutoPreco.setText(null);
                    txtDataInsumo.setText(null);
                    
                    btnProdutoCadastrar.setEnabled(true);
                }
              }  
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void removerProdutoDiverso() {
        
        int index = tblProdutoDiverso.getSelectedRow();
        
        if(index < 0){
           JOptionPane.showMessageDialog(null, "Você precisa selecionar algum produto na tabela para deletar", "", JOptionPane.ERROR_MESSAGE); 
        } else {
        
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir este produto consumido?", "Atenção", JOptionPane.YES_NO_OPTION);
        if(confirma==JOptionPane.YES_OPTION) {
            String sql = "delete from produtosdiversos where id=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txtProdutoId.getText());
                int removido = pst.executeUpdate();
                if(removido > 0) {
                    btnProdutoCadastrar.setEnabled(true);
                    JOptionPane.showMessageDialog(null, "Produto removido com sucesso");
                    txtProdutoId.setText(null);
                    txtProdutoNome.setText(null);
                    txtProdutoPreco.setText(null);
                    txtDataInsumo.setText(null);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtProdutoNome = new javax.swing.JTextField();
        txtProdutoPreco = new javax.swing.JTextField();
        cboProdutoQuantidade = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        btnProdutoAtualizar = new javax.swing.JButton();
        btnProdutoDeletar = new javax.swing.JButton();
        btnProdutoCadastrar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtProdutoPesquisar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProdutoDiverso = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtProdutoId = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtDataInsumo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setPreferredSize(new java.awt.Dimension(691, 524));

        jPanel1.setBackground(new java.awt.Color(27, 247, 247));

        jLabel1.setFont(new java.awt.Font("Fira Code", 1, 28)); // NOI18N
        jLabel1.setText("Cadastro de Insumo");

        jLabel2.setFont(new java.awt.Font("Fira Code Light", 1, 14)); // NOI18N
        jLabel2.setText("*Nome");

        jLabel3.setFont(new java.awt.Font("Fira Code Light", 1, 14)); // NOI18N
        jLabel3.setText("*Preço");

        txtProdutoNome.setFont(new java.awt.Font("Fira Code", 0, 12)); // NOI18N
        txtProdutoNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProdutoNomeActionPerformed(evt);
            }
        });

        txtProdutoPreco.setFont(new java.awt.Font("Fira Code", 0, 12)); // NOI18N

        cboProdutoQuantidade.setFont(new java.awt.Font("Fira Code", 0, 13)); // NOI18N
        cboProdutoQuantidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        cboProdutoQuantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboProdutoQuantidadeActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Fira Code Light", 1, 14)); // NOI18N
        jLabel5.setText("*Quantidade");

        btnProdutoAtualizar.setBackground(new java.awt.Color(124, 38, 253));
        btnProdutoAtualizar.setFont(new java.awt.Font("Fira Code Light", 1, 12)); // NOI18N
        btnProdutoAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/iconfinder_update_172618.png"))); // NOI18N
        btnProdutoAtualizar.setText("Atualizar");
        btnProdutoAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdutoAtualizarActionPerformed(evt);
            }
        });

        btnProdutoDeletar.setBackground(new java.awt.Color(249, 26, 2));
        btnProdutoDeletar.setFont(new java.awt.Font("Fira Code Light", 1, 12)); // NOI18N
        btnProdutoDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/iconfinder_Streamline-70_185090 (1).png"))); // NOI18N
        btnProdutoDeletar.setText("Deletar");
        btnProdutoDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdutoDeletarActionPerformed(evt);
            }
        });

        btnProdutoCadastrar.setBackground(new java.awt.Color(27, 50, 247));
        btnProdutoCadastrar.setFont(new java.awt.Font("Fira Code Light", 1, 12)); // NOI18N
        btnProdutoCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/iconfinder_dashboard__Add_2877013.png"))); // NOI18N
        btnProdutoCadastrar.setText("Cadastrar");
        btnProdutoCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdutoCadastrarActionPerformed(evt);
            }
        });

        jLabel7.setText("(*)Campos obrigatórios");

        txtProdutoPesquisar.setFont(new java.awt.Font("Fira Code", 0, 12)); // NOI18N
        txtProdutoPesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtProdutoPesquisar.setMinimumSize(new java.awt.Dimension(22, 38));
        txtProdutoPesquisar.setPreferredSize(new java.awt.Dimension(196, 35));
        txtProdutoPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProdutoPesquisarActionPerformed(evt);
            }
        });
        txtProdutoPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtProdutoPesquisarKeyReleased(evt);
            }
        });

        tblProdutoDiverso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Preço", "Quantidade"
            }
        ));
        tblProdutoDiverso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProdutoDiversoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProdutoDiverso);

        jLabel6.setBackground(new java.awt.Color(12, 246, 86));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/iconfinder_search_172546.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Fira Code Light", 1, 14)); // NOI18N
        jLabel9.setText("#Identificador");

        txtProdutoId.setFont(new java.awt.Font("Fira Code SemiBold", 1, 12)); // NOI18N
        txtProdutoId.setEnabled(false);

        jLabel8.setText("(#)Preenchimento automático");

        jLabel10.setFont(new java.awt.Font("Fira Code Light", 1, 14)); // NOI18N
        jLabel10.setText("*Data");

        txtDataInsumo.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        txtDataInsumo.setPreferredSize(new java.awt.Dimension(204, 35));

        jLabel11.setFont(new java.awt.Font("Fira Code Light", 1, 14)); // NOI18N
        jLabel11.setText("Ex: 05/09/20");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(btnProdutoCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(btnProdutoAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btnProdutoDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtProdutoPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addGap(95, 95, 95)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(179, 179, 179)
                                .addComponent(jLabel5))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(txtProdutoId, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(txtProdutoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtDataInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel11))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtProdutoPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(cboProdutoQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8))
                    .addComponent(txtProdutoPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtProdutoId, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtProdutoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDataInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboProdutoQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProdutoPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProdutoCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProdutoAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProdutoDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(108, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(192, 192, 192))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setBounds(0, 0, 716, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void btnProdutoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdutoCadastrarActionPerformed
        cadastrarProdutoDiverso();
        RefreshTable();
    }//GEN-LAST:event_btnProdutoCadastrarActionPerformed

    private void btnProdutoAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdutoAtualizarActionPerformed
        alterarProdutoDiverso();
        RefreshTable();
    }//GEN-LAST:event_btnProdutoAtualizarActionPerformed

    private void cboProdutoQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboProdutoQuantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboProdutoQuantidadeActionPerformed

    private void txtProdutoNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProdutoNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProdutoNomeActionPerformed

    private void btnProdutoDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdutoDeletarActionPerformed
        removerProdutoDiverso();
        RefreshTable();
    }//GEN-LAST:event_btnProdutoDeletarActionPerformed

    private void txtProdutoPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProdutoPesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProdutoPesquisarActionPerformed

    private void txtProdutoPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProdutoPesquisarKeyReleased
        pesquisarProdutoDiverso();
    }//GEN-LAST:event_txtProdutoPesquisarKeyReleased

    private void tblProdutoDiversoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProdutoDiversoMouseClicked
        setar_campos();
    }//GEN-LAST:event_tblProdutoDiversoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProdutoAtualizar;
    private javax.swing.JButton btnProdutoCadastrar;
    private javax.swing.JButton btnProdutoDeletar;
    private javax.swing.JComboBox<String> cboProdutoQuantidade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProdutoDiverso;
    private javax.swing.JTextField txtDataInsumo;
    private javax.swing.JTextField txtProdutoId;
    private javax.swing.JTextField txtProdutoNome;
    private javax.swing.JTextField txtProdutoPesquisar;
    private javax.swing.JTextField txtProdutoPreco;
    // End of variables declaration//GEN-END:variables
}
