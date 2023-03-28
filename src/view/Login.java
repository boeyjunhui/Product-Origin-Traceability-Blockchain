package view;

import controller.SuperAdminController;
import controller.FarmerController;
import controller.ProductionWorkerController;
import controller.WarehouseWorkerController;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.AuthRecord;

public class Login extends javax.swing.JFrame {

    /**
     * Creates new form AdminLogin
     */
    public Login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlAdminLogin = new javax.swing.JPanel();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        lblLogin = new javax.swing.JLabel();
        cboUserRole = new javax.swing.JComboBox<>();
        lblUserRole = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);

        pnlAdminLogin.setBackground(new java.awt.Color(255, 255, 255));
        pnlAdminLogin.setPreferredSize(new java.awt.Dimension(800, 550));

        lblUsername.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lblUsername.setText("Username");

        lblPassword.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lblPassword.setText("Password");

        btnBack.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnBack.setText("Back");
        btnBack.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnLogin.setBackground(new java.awt.Color(73, 161, 236));
        btnLogin.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Log In");
        btnLogin.setBorder(null);
        btnLogin.setOpaque(true);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        txtUsername.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtUsername.setText("superadmin");
        txtUsername.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));

        txtPassword.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtPassword.setText("superadmin");
        txtPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));

        lblLogin.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lblLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogin.setText("Login");

        cboUserRole.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        cboUserRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select User Role", "Super Admin", "Farmer", "Production Worker", "Warehouse Worker" }));
        cboUserRole.setSelectedIndex(3);

        lblUserRole.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lblUserRole.setText("User Role");

        javax.swing.GroupLayout pnlAdminLoginLayout = new javax.swing.GroupLayout(pnlAdminLogin);
        pnlAdminLogin.setLayout(pnlAdminLoginLayout);
        pnlAdminLoginLayout.setHorizontalGroup(
            pnlAdminLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAdminLoginLayout.createSequentialGroup()
                .addGroup(pnlAdminLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAdminLoginLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlAdminLoginLayout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addGroup(pnlAdminLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPassword)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUsername)
                            .addComponent(lblLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboUserRole, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUserRole))))
                .addContainerGap(250, Short.MAX_VALUE))
        );
        pnlAdminLoginLayout.setVerticalGroup(
            pnlAdminLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAdminLoginLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lblLogin)
                .addGap(60, 60, 60)
                .addComponent(lblUsername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblUserRole)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboUserRole, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlAdminLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlAdminLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // back button
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        MainScreen mainScreen = new MainScreen();
        mainScreen.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    // login button
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        if (txtUsername.getText().equals("") || txtPassword.getPassword().length == 0 || cboUserRole.getSelectedItem().equals("Select User Role")) {
            JOptionPane.showMessageDialog(null, "Please fill in all details!", "Warning", JOptionPane.WARNING_MESSAGE);
            
            // super admin
        } else if (cboUserRole.getSelectedItem().equals("Super Admin")) {
            SuperAdminController superAdminController = new SuperAdminController();
            
            try {
                AuthRecord authRecord = superAdminController.login(txtUsername.getText(), txtPassword.getText());

                if (authRecord.auth()) {
                    JOptionPane.showMessageDialog(null, "Login successful!", "Login Successful", JOptionPane.INFORMATION_MESSAGE);
                    new SuperAdmin(authRecord.userID()).setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to login! Incorrect username or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
                }
            } catch (FileNotFoundException ex) {
                
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            // farmer
        } else if (cboUserRole.getSelectedItem().equals("Farmer")) {
            FarmerController farmerController = new FarmerController();
            
            try {
                AuthRecord authRecord = farmerController.login(txtUsername.getText(), txtPassword.getText());

                if (authRecord.auth()) {
                    JOptionPane.showMessageDialog(null, "Login successful!", "Login Successful", JOptionPane.INFORMATION_MESSAGE);
                    new Farmer(authRecord.userID()).setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to login! Incorrect username or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
                }
            } catch (FileNotFoundException ex) {
                
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            // production worker
        } else if (cboUserRole.getSelectedItem().equals("Production Worker")) {
            ProductionWorkerController productWorkerController = new ProductionWorkerController();
            
            try {
                AuthRecord authRecord = productWorkerController.login(txtUsername.getText(), txtPassword.getText());

                if (authRecord.auth()) {
                    JOptionPane.showMessageDialog(null, "Login successful!", "Login Successful", JOptionPane.INFORMATION_MESSAGE);
                    new ProductionWorker(authRecord.userID()).setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to login! Incorrect username or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
                }
            } catch (FileNotFoundException ex) {
                
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            // warehouse worker
        } else if (cboUserRole.getSelectedItem().equals("Warehouse Worker")) {
            WarehouseWorkerController warehouseWorkerController = new WarehouseWorkerController();
            
            try {
                AuthRecord authRecord = warehouseWorkerController.login(txtUsername.getText(), txtPassword.getText());

                if (authRecord.auth()) {
                    JOptionPane.showMessageDialog(null, "Login successful!", "Login Successful", JOptionPane.INFORMATION_MESSAGE);
                    new WarehouseWorker(authRecord.userID()).setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to login! Incorrect username or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
                }
            } catch (FileNotFoundException ex) {
                
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnLoginActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnLogin;
    private javax.swing.JComboBox<String> cboUserRole;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUserRole;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPanel pnlAdminLogin;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
