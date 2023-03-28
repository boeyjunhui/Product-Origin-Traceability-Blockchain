package view;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MainScreen extends javax.swing.JFrame {
    
    /**
     * Creates new form SearchAndLogin
     */
    public MainScreen() {
        initComponents();
        
        // create file if files do not exist
        try {
            FileWriter admin = new FileWriter("SuperAdmin.txt", true);
            admin.close();

            FileWriter farmer = new FileWriter("Farmer.txt", true);
            farmer.close();
            
            FileWriter productionWorker = new FileWriter("ProductionWorker.txt", true);
            productionWorker.close();
            
            FileWriter warehouseWorker = new FileWriter("WarehouseWorker.txt", true);
            warehouseWorker.close();
            
            FileWriter product = new FileWriter("Product.txt", true);
            product.close();
        } catch (IOException e) {
            
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

        pnlMainScreen = new javax.swing.JPanel();
        lblProductUniqueCode = new javax.swing.JLabel();
        txtProductUniqueCode = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();
        lblProductOriginTracer = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Product Origin Tracer");
        setResizable(false);

        pnlMainScreen.setBackground(new java.awt.Color(255, 255, 255));
        pnlMainScreen.setPreferredSize(new java.awt.Dimension(700, 500));

        lblProductUniqueCode.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lblProductUniqueCode.setText("Product Unique Code");

        txtProductUniqueCode.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtProductUniqueCode.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));

        btnSearch.setBackground(new java.awt.Color(73, 161, 236));
        btnSearch.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Search");
        btnSearch.setBorder(null);
        btnSearch.setOpaque(true);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnLogin.setBackground(new java.awt.Color(245, 245, 245));
        btnLogin.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));
        btnLogin.setOpaque(true);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        lblProductOriginTracer.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lblProductOriginTracer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProductOriginTracer.setText("Product Origin Tracer");
        lblProductOriginTracer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlMainScreenLayout = new javax.swing.GroupLayout(pnlMainScreen);
        pnlMainScreen.setLayout(pnlMainScreenLayout);
        pnlMainScreenLayout.setHorizontalGroup(
            pnlMainScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainScreenLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(pnlMainScreenLayout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addGroup(pnlMainScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblProductOriginTracer, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProductUniqueCode, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProductUniqueCode))
                .addContainerGap(200, Short.MAX_VALUE))
        );
        pnlMainScreenLayout.setVerticalGroup(
            pnlMainScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainScreenLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(lblProductOriginTracer)
                .addGap(90, 90, 90)
                .addComponent(lblProductUniqueCode)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtProductUniqueCode, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(134, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlMainScreen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMainScreen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // admin login button
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        Login adminLogin = new Login();
        adminLogin.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnLoginActionPerformed

    // search product button
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        Product product = new Product();
        
        try {
            if (txtProductUniqueCode.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill in the product unique code!", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                product.searchProduct(txtProductUniqueCode.getText());
                this.dispose();
            }
        } catch (IOException ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

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
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel lblProductOriginTracer;
    private javax.swing.JLabel lblProductUniqueCode;
    private javax.swing.JPanel pnlMainScreen;
    private javax.swing.JTextField txtProductUniqueCode;
    // End of variables declaration//GEN-END:variables
}
