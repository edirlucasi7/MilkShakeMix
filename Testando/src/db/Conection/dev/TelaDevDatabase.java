
package db.Conection.dev;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author caio
 */
public class TelaDevDatabase extends javax.swing.JFrame {

    ConexaoConfigDatabase config = new ConexaoConfigDatabase();
    ConexaoConfigTables table = new ConexaoConfigTables();
    
    /**
     * Creates new form Teste
     */
    public TelaDevDatabase() {
        try {
            initComponents();
            this.setResizable(false);
            this.setLocationRelativeTo(null);
            
            boolean bancoCriado = config.DatabaseCriated();
            
            if(bancoCriado == true){
                buttonCreateDatabase.setEnabled(false);
                buttonDeleteDatabase.setEnabled(true);
            }else{
                buttonDeleteDatabase.setEnabled(true);
                buttonCreateDatabase.setEnabled(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TelaDevDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        buttonCreateDatabase = new javax.swing.JButton();
        buttonDeleteDatabase = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        buttonTableUser = new javax.swing.JButton();
        buttonDeleteTableUser = new javax.swing.JButton();
        buttonCreateTableProduto = new javax.swing.JButton();
        buttonDeletarTableProduto = new javax.swing.JButton();
        buttonProdutoDiverso = new javax.swing.JButton();
        buttonDeletarTableProdutoDiverso = new javax.swing.JButton();
        buttonCreateTableVendas = new javax.swing.JButton();
        buttonDeleteTableVendas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(78, 179, 255));

        jLabel1.setFont(new java.awt.Font("Droid Naskh Shift Alt", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(1, 1, 1));
        jLabel1.setText("Banco de dados");

        buttonCreateDatabase.setText("Criar database");
        buttonCreateDatabase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCreateDatabaseActionPerformed(evt);
            }
        });

        buttonDeleteDatabase.setText("Deletar Database");
        buttonDeleteDatabase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteDatabaseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(buttonCreateDatabase)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonDeleteDatabase)
                .addGap(66, 66, 66))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonDeleteDatabase)
                    .addComponent(buttonCreateDatabase))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(251, 252, 254));

        jLabel2.setFont(new java.awt.Font("Droid Naskh Shift Alt", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(1, 1, 1));
        jLabel2.setText("Tabelas");

        buttonTableUser.setText("Tabela usuário");
        buttonTableUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTableUserActionPerformed(evt);
            }
        });

        buttonDeleteTableUser.setText("Deletar tabela usuário");
        buttonDeleteTableUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteTableUserActionPerformed(evt);
            }
        });

        buttonCreateTableProduto.setText("Tabela Produtos");
        buttonCreateTableProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCreateTableProdutoActionPerformed(evt);
            }
        });

        buttonDeletarTableProduto.setText("Deletar tabela produtos");
        buttonDeletarTableProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeletarTableProdutoActionPerformed(evt);
            }
        });

        buttonProdutoDiverso.setText("Tabela Produto Diverso");
        buttonProdutoDiverso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonProdutoDiversoActionPerformed(evt);
            }
        });

        buttonDeletarTableProdutoDiverso.setText("Deletar tabela Produto Diverso");
        buttonDeletarTableProdutoDiverso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeletarTableProdutoDiversoActionPerformed(evt);
            }
        });

        buttonCreateTableVendas.setText("Tabela de vendas");
        buttonCreateTableVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCreateTableVendasActionPerformed(evt);
            }
        });

        buttonDeleteTableVendas.setText("Deletar tabela Vendas");
        buttonDeleteTableVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteTableVendasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonCreateTableProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonTableUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonDeleteTableUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonDeletarTableProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(46, 46, 46))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(buttonProdutoDiverso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonDeletarTableProdutoDiverso)
                .addGap(21, 21, 21))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(205, 205, 205)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(buttonCreateTableVendas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonDeleteTableVendas)
                .addGap(59, 59, 59))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonDeleteTableUser)
                    .addComponent(buttonTableUser))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCreateTableProduto)
                    .addComponent(buttonDeletarTableProduto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonProdutoDiverso)
                    .addComponent(buttonDeletarTableProdutoDiverso))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCreateTableVendas)
                    .addComponent(buttonDeleteTableVendas))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCreateDatabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCreateDatabaseActionPerformed

        config.CreateDatabase();

        buttonCreateDatabase.setEnabled(false);
        buttonDeleteDatabase.setEnabled(true);

    }//GEN-LAST:event_buttonCreateDatabaseActionPerformed

    private void buttonDeleteDatabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteDatabaseActionPerformed

        
        config.DeleteDatabase();

        buttonCreateDatabase.setEnabled(true);
        buttonDeleteDatabase.setEnabled(false);
    }//GEN-LAST:event_buttonDeleteDatabaseActionPerformed

    private void buttonTableUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTableUserActionPerformed
        
        try {
            table.CreateTableUser();
            table.CadastrarUsuarioAdmin();
            buttonTableUser.setEnabled(false);
            buttonDeleteTableUser.setEnabled(true);
        } catch (SQLException ex) {
            Logger.getLogger(TelaDevDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_buttonTableUserActionPerformed

    private void buttonDeleteTableUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteTableUserActionPerformed

        table.DeleteTableUser();
        buttonDeleteTableUser.setEnabled(false);
        buttonTableUser.setEnabled(true);

    }//GEN-LAST:event_buttonDeleteTableUserActionPerformed

    private void buttonCreateTableProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCreateTableProdutoActionPerformed

        table.CreateTableProduto();
        buttonCreateTableProduto.setEnabled(false);
        buttonDeletarTableProduto.setEnabled(true);

    }//GEN-LAST:event_buttonCreateTableProdutoActionPerformed

    private void buttonDeletarTableProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeletarTableProdutoActionPerformed

        table.DeleteTableProduto();
        buttonDeletarTableProduto.setEnabled(false);
        buttonCreateTableProduto.setEnabled(true);

    }//GEN-LAST:event_buttonDeletarTableProdutoActionPerformed

    private void buttonProdutoDiversoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonProdutoDiversoActionPerformed
        table.CreateTableProdutoDiverso();
        buttonProdutoDiverso.setEnabled(false);
        buttonDeletarTableProdutoDiverso.setEnabled(true);
        
    }//GEN-LAST:event_buttonProdutoDiversoActionPerformed

    private void buttonDeletarTableProdutoDiversoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeletarTableProdutoDiversoActionPerformed

        table.DeleteTableProdutoDiverso();
        buttonDeletarTableProdutoDiverso.setEnabled(false);
        buttonProdutoDiverso.setEnabled(true);

    }//GEN-LAST:event_buttonDeletarTableProdutoDiversoActionPerformed

    private void buttonCreateTableVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCreateTableVendasActionPerformed

        table.CreateTableVenda();
        buttonCreateTableVendas.setEnabled(false);
        buttonDeleteTableVendas.setEnabled(true);

    }//GEN-LAST:event_buttonCreateTableVendasActionPerformed

    private void buttonDeleteTableVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteTableVendasActionPerformed
        
        table.DeleteTableVendas();
        buttonDeleteTableVendas.setEnabled(false);
        buttonCreateTableVendas.setEnabled(true);

    }//GEN-LAST:event_buttonDeleteTableVendasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaDevDatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDevDatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDevDatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDevDatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDevDatabase().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCreateDatabase;
    private javax.swing.JButton buttonCreateTableProduto;
    private javax.swing.JButton buttonCreateTableVendas;
    private javax.swing.JButton buttonDeletarTableProduto;
    private javax.swing.JButton buttonDeletarTableProdutoDiverso;
    private javax.swing.JButton buttonDeleteDatabase;
    private javax.swing.JButton buttonDeleteTableUser;
    private javax.swing.JButton buttonDeleteTableVendas;
    private javax.swing.JButton buttonProdutoDiverso;
    private javax.swing.JButton buttonTableUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
