package view;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ProductionWorker extends javax.swing.JFrame {
    
    /**
     * Creates new form ProductionWorker
     */
    public ProductionWorker() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        pnlAddProductionData.setVisible(true);
    }

    public ProductionWorker(int productionWorkerID) throws IOException {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        pnlAddProductionData.setVisible(true);
    }
    
    // clear input fields
    public void reset() {
        txtProductUniqueCode.setText("");
        txtHarvestDate.setText("");
        txtFarmLocation.setText("");
        txtProductionDate.setText("");
        txtProductionDate.setEnabled(false);
        txtProductionDate.setBackground(new java.awt.Color(250, 250, 250));
        txtProductionLocation.setText("");
        txtProductionLocation.setEnabled(false);
        txtProductionLocation.setBackground(new java.awt.Color(250, 250, 250));
        txtExpiryDate.setText("");
        txtExpiryDate.setEnabled(false);
        txtExpiryDate.setBackground(new java.awt.Color(250, 250, 250));
        txtProductID.setText("");
        txtProductID.setEnabled(false);
        txtProductID.setBackground(new java.awt.Color(250, 250, 250));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlContainer = new javax.swing.JPanel();
        pnlTopNav = new javax.swing.JPanel();
        lblProductOriginTracer = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        pnlAddProductionData = new javax.swing.JPanel();
        lblHarvestDate = new javax.swing.JLabel();
        lblFarmLocation = new javax.swing.JLabel();
        lblProductionDate = new javax.swing.JLabel();
        lblProductionLocation = new javax.swing.JLabel();
        lblExpiryDate = new javax.swing.JLabel();
        lblProductID = new javax.swing.JLabel();
        txtHarvestDate = new javax.swing.JTextField();
        txtFarmLocation = new javax.swing.JTextField();
        txtProductionDate = new javax.swing.JTextField();
        txtProductionLocation = new javax.swing.JTextField();
        txtExpiryDate = new javax.swing.JTextField();
        txtProductID = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        lblAddProductionData = new javax.swing.JLabel();
        txtProductUniqueCode = new javax.swing.JTextField();
        lblProductUniqueCode = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Product Origin Tracer - Production Worker");

        pnlContainer.setBackground(new java.awt.Color(255, 255, 255));
        pnlContainer.setPreferredSize(new java.awt.Dimension(1300, 800));

        pnlTopNav.setBackground(new java.awt.Color(245, 245, 245));
        pnlTopNav.setPreferredSize(new java.awt.Dimension(1300, 50));

        lblProductOriginTracer.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lblProductOriginTracer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProductOriginTracer.setText("Product Origin Tracer - Production");

        btnLogout.setBackground(new java.awt.Color(221, 98, 98));
        btnLogout.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout.setText("Log Out");
        btnLogout.setBorder(null);
        btnLogout.setOpaque(true);
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTopNavLayout = new javax.swing.GroupLayout(pnlTopNav);
        pnlTopNav.setLayout(pnlTopNavLayout);
        pnlTopNavLayout.setHorizontalGroup(
            pnlTopNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTopNavLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(lblProductOriginTracer, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(279, 279, 279))
        );
        pnlTopNavLayout.setVerticalGroup(
            pnlTopNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTopNavLayout.createSequentialGroup()
                .addGroup(pnlTopNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProductOriginTracer, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(112, 112, 112))
        );

        pnlAddProductionData.setBackground(new java.awt.Color(255, 255, 255));
        pnlAddProductionData.setPreferredSize(new java.awt.Dimension(1300, 700));

        lblHarvestDate.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblHarvestDate.setText("Harvest Date");

        lblFarmLocation.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblFarmLocation.setText("Farm Location");

        lblProductionDate.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblProductionDate.setText("Production Date");

        lblProductionLocation.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblProductionLocation.setText("Production Location");

        lblExpiryDate.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblExpiryDate.setText("Expiry Date");

        lblProductID.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblProductID.setText("Product ID");

        txtHarvestDate.setBackground(new java.awt.Color(250, 250, 250));
        txtHarvestDate.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtHarvestDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));
        txtHarvestDate.setEnabled(false);

        txtFarmLocation.setBackground(new java.awt.Color(250, 250, 250));
        txtFarmLocation.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtFarmLocation.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));
        txtFarmLocation.setEnabled(false);

        txtProductionDate.setBackground(new java.awt.Color(250, 250, 250));
        txtProductionDate.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtProductionDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));
        txtProductionDate.setEnabled(false);

        txtProductionLocation.setBackground(new java.awt.Color(250, 250, 250));
        txtProductionLocation.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtProductionLocation.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));
        txtProductionLocation.setEnabled(false);

        txtExpiryDate.setBackground(new java.awt.Color(250, 250, 250));
        txtExpiryDate.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtExpiryDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));
        txtExpiryDate.setEnabled(false);

        txtProductID.setBackground(new java.awt.Color(250, 250, 250));
        txtProductID.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtProductID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));
        txtProductID.setEnabled(false);

        btnSave.setBackground(new java.awt.Color(73, 161, 236));
        btnSave.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Save");
        btnSave.setBorder(null);
        btnSave.setOpaque(true);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnReset.setBackground(new java.awt.Color(221, 98, 98));
        btnReset.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setText("Reset");
        btnReset.setToolTipText("");
        btnReset.setBorder(null);
        btnReset.setOpaque(true);
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        lblAddProductionData.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lblAddProductionData.setText("Add Production Data");

        txtProductUniqueCode.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtProductUniqueCode.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));

        lblProductUniqueCode.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblProductUniqueCode.setText("Product Unique Code");

        btnSearch.setBackground(new java.awt.Color(73, 161, 236));
        btnSearch.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Search");
        btnSearch.setBorder(null);
        btnSearch.setOpaque(true);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlAddProductionDataLayout = new javax.swing.GroupLayout(pnlAddProductionData);
        pnlAddProductionData.setLayout(pnlAddProductionDataLayout);
        pnlAddProductionDataLayout.setHorizontalGroup(
            pnlAddProductionDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddProductionDataLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlAddProductionDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAddProductionData)
                    .addGroup(pnlAddProductionDataLayout.createSequentialGroup()
                        .addGroup(pnlAddProductionDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblHarvestDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblProductionDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblExpiryDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblProductUniqueCode, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlAddProductionDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHarvestDate, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtProductionDate, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtExpiryDate, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtProductUniqueCode, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(100, 100, 100)
                        .addGroup(pnlAddProductionDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlAddProductionDataLayout.createSequentialGroup()
                                .addComponent(lblProductID, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtProductID, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlAddProductionDataLayout.createSequentialGroup()
                                .addGap(198, 198, 198)
                                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlAddProductionDataLayout.createSequentialGroup()
                                .addGroup(pnlAddProductionDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblFarmLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblProductionLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pnlAddProductionDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtProductionLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFarmLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(475, Short.MAX_VALUE))
        );
        pnlAddProductionDataLayout.setVerticalGroup(
            pnlAddProductionDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddProductionDataLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblAddProductionData)
                .addGap(40, 40, 40)
                .addGroup(pnlAddProductionDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProductUniqueCode, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProductUniqueCode, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(pnlAddProductionDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFarmLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFarmLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHarvestDate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHarvestDate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(pnlAddProductionDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProductionDate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProductionDate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProductionLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProductionLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlAddProductionDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblExpiryDate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtExpiryDate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProductID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProductID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(250, 250, 250)
                .addGroup(pnlAddProductionDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(105, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlContainerLayout = new javax.swing.GroupLayout(pnlContainer);
        pnlContainer.setLayout(pnlContainerLayout);
        pnlContainerLayout.setHorizontalGroup(
            pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTopNav, javax.swing.GroupLayout.DEFAULT_SIZE, 1597, Short.MAX_VALUE)
            .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlContainerLayout.createSequentialGroup()
                    .addComponent(pnlAddProductionData, javax.swing.GroupLayout.DEFAULT_SIZE, 1591, Short.MAX_VALUE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnlContainerLayout.setVerticalGroup(
            pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContainerLayout.createSequentialGroup()
                .addComponent(pnlTopNav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(750, 750, 750))
            .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContainerLayout.createSequentialGroup()
                    .addContainerGap(54, Short.MAX_VALUE)
                    .addComponent(pnlAddProductionData, javax.swing.GroupLayout.PREFERRED_SIZE, 744, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 1597, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // logout button
    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        int logoutConfirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Warning", JOptionPane.YES_NO_OPTION);

        if (logoutConfirmation == JOptionPane.YES_OPTION) {
            Login login = new Login();
            login.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

    // search product unique code button
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        if (txtProductUniqueCode.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill in a product unique code!", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            // search product unique code method
            txtHarvestDate.setText("");
            txtFarmLocation.setText("");
            txtProductionDate.setEnabled(true);
            txtProductionDate.setBackground(new java.awt.Color(255, 255, 255));
            txtProductionLocation.setEnabled(true);
            txtProductionLocation.setBackground(new java.awt.Color(255, 255, 255));
            txtExpiryDate.setEnabled(true);
            txtExpiryDate.setBackground(new java.awt.Color(255, 255, 255));
            txtProductID.setEnabled(true);
            txtProductID.setBackground(new java.awt.Color(255, 255, 255));
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    // add production data save button
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (txtProductionDate.getText().equals("") || txtProductionLocation.getText().equals("") || txtExpiryDate.getText().equals("") || txtProductID.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill in all details!", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            // blockchain method
            reset();
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    // reset input fields button
    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
       reset();
    }//GEN-LAST:event_btnResetActionPerformed

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
            java.util.logging.Logger.getLogger(ProductionWorker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductionWorker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductionWorker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductionWorker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductionWorker().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel lblAddProductionData;
    private javax.swing.JLabel lblExpiryDate;
    private javax.swing.JLabel lblFarmLocation;
    private javax.swing.JLabel lblHarvestDate;
    private javax.swing.JLabel lblProductID;
    private javax.swing.JLabel lblProductOriginTracer;
    private javax.swing.JLabel lblProductUniqueCode;
    private javax.swing.JLabel lblProductionDate;
    private javax.swing.JLabel lblProductionLocation;
    private javax.swing.JPanel pnlAddProductionData;
    private javax.swing.JPanel pnlContainer;
    private javax.swing.JPanel pnlTopNav;
    private javax.swing.JTextField txtExpiryDate;
    private javax.swing.JTextField txtFarmLocation;
    private javax.swing.JTextField txtHarvestDate;
    private javax.swing.JTextField txtProductID;
    private javax.swing.JTextField txtProductUniqueCode;
    private javax.swing.JTextField txtProductionDate;
    private javax.swing.JTextField txtProductionLocation;
    // End of variables declaration//GEN-END:variables
}
