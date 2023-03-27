package view;

import controller.FarmerController;
import controller.ProductController;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ProductRecord;

public class Farmer extends javax.swing.JFrame {

    FarmerController farmerController = new FarmerController();
    ProductController productController = new ProductController();
    List<ProductRecord> productRecord;
    
    /**
     * Creates new form Farmer
     */
    public Farmer() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        pnlViewProduct.setVisible(true);
        pnlAddFarmData.setVisible(false);
    }

    public Farmer(int farmerID) throws IOException {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        pnlViewProduct.setVisible(true);
        pnlAddFarmData.setVisible(false);
        viewProduct();
    }
    
    // clear input fields
    public void clear() {
        txtHarvestDate.setText("");
        txtFarmLocation.setText("");
    }
    
        // load and view product data
    public void viewProduct() throws IOException {
        btnAddFarmData.setEnabled(false);
        
        productRecord = productController.viewProduct();
        
        // set table column
        String columns[] = { "Product ID", "Product Name", "Product Description", "Ingredient", "Nutrition", "Weight", "Price (RM)",  "Product Unique Code" };
        
        DefaultTableModel defaultTableModel = (DefaultTableModel)tblProduct.getModel();
        defaultTableModel.setColumnIdentifiers(columns);
                
        tblProduct.setModel(defaultTableModel);
        defaultTableModel.setRowCount( 0);
        
        // loop data into table
        for (ProductRecord productRecord : productController.viewProduct()) {
            String[] data = {
                Integer.toString(productRecord.productID()), productRecord.productName(), productRecord.productDescription(), productRecord.ingredient(), productRecord.nutrition(), productRecord.weight(), Double.toString(productRecord.price()), productRecord.productUniqueCode()
            };
            
            defaultTableModel.addRow(data);
        }
        
        // get data from selected row
        tblProduct.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                btnAddFarmData.setEnabled(true);

                int rows = tblProduct.getSelectedRow();
                int row = tblProduct.convertRowIndexToModel(rows);
                
                // get product id
                lblProductID.setText(defaultTableModel.getValueAt(row, 0).toString());
            } 
        });
        
        pnlViewProduct.setVisible(true);
        pnlAddFarmData.setVisible(false);
        clear();
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
        pnlViewProduct = new javax.swing.JPanel();
        btnAddFarmData = new javax.swing.JButton();
        scrpanProduct = new javax.swing.JScrollPane();
        tblProduct = new javax.swing.JTable();
        lblGuide = new javax.swing.JLabel();
        pnlAddFarmData = new javax.swing.JPanel();
        lblHarvestDate = new javax.swing.JLabel();
        lblFarmLocation = new javax.swing.JLabel();
        txtHarvestDate = new javax.swing.JTextField();
        txtFarmLocation = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblAddFarmData = new javax.swing.JLabel();
        lblProductID = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Product Origin Tracer - Farmer");

        pnlContainer.setBackground(new java.awt.Color(255, 255, 255));
        pnlContainer.setPreferredSize(new java.awt.Dimension(1300, 800));

        pnlTopNav.setBackground(new java.awt.Color(245, 245, 245));
        pnlTopNav.setPreferredSize(new java.awt.Dimension(1300, 50));

        lblProductOriginTracer.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lblProductOriginTracer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProductOriginTracer.setText("Product Origin Tracer");

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

        pnlViewProduct.setBackground(new java.awt.Color(255, 255, 255));
        pnlViewProduct.setPreferredSize(new java.awt.Dimension(1300, 700));

        btnAddFarmData.setBackground(new java.awt.Color(73, 161, 236));
        btnAddFarmData.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        btnAddFarmData.setForeground(new java.awt.Color(255, 255, 255));
        btnAddFarmData.setText("Add Farm Data");
        btnAddFarmData.setBorder(null);
        btnAddFarmData.setOpaque(true);
        btnAddFarmData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFarmDataActionPerformed(evt);
            }
        });

        tblProduct.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        )

        { public boolean isCellEditable(int row, int column) { return false; }});
    scrpanProduct.setViewportView(tblProduct);

    lblGuide.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
    lblGuide.setText("Select a row of record to activate Add Farm Data button.");

    javax.swing.GroupLayout pnlViewProductLayout = new javax.swing.GroupLayout(pnlViewProduct);
    pnlViewProduct.setLayout(pnlViewProductLayout);
    pnlViewProductLayout.setHorizontalGroup(
        pnlViewProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnlViewProductLayout.createSequentialGroup()
            .addGap(20, 20, 20)
            .addGroup(pnlViewProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblGuide)
                .addComponent(scrpanProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 1224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnAddFarmData, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(379, Short.MAX_VALUE))
    );
    pnlViewProductLayout.setVerticalGroup(
        pnlViewProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnlViewProductLayout.createSequentialGroup()
            .addGap(20, 20, 20)
            .addComponent(btnAddFarmData, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(20, 20, 20)
            .addComponent(lblGuide)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(scrpanProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(97, Short.MAX_VALUE))
    );

    pnlAddFarmData.setBackground(new java.awt.Color(255, 255, 255));
    pnlAddFarmData.setPreferredSize(new java.awt.Dimension(1300, 700));

    lblHarvestDate.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
    lblHarvestDate.setText("Harvest Date");

    lblFarmLocation.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
    lblFarmLocation.setText("Farm Location");

    txtHarvestDate.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
    txtHarvestDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));

    txtFarmLocation.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
    txtFarmLocation.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));

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

    btnCancel.setBackground(new java.awt.Color(221, 98, 98));
    btnCancel.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    btnCancel.setForeground(new java.awt.Color(255, 255, 255));
    btnCancel.setText("Cancel");
    btnCancel.setToolTipText("");
    btnCancel.setBorder(null);
    btnCancel.setOpaque(true);
    btnCancel.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnCancelActionPerformed(evt);
        }
    });

    lblAddFarmData.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
    lblAddFarmData.setText("Add Farm Data – Product ID: ");

    lblProductID.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N

    javax.swing.GroupLayout pnlAddFarmDataLayout = new javax.swing.GroupLayout(pnlAddFarmData);
    pnlAddFarmData.setLayout(pnlAddFarmDataLayout);
    pnlAddFarmDataLayout.setHorizontalGroup(
        pnlAddFarmDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnlAddFarmDataLayout.createSequentialGroup()
            .addGap(20, 20, 20)
            .addGroup(pnlAddFarmDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlAddFarmDataLayout.createSequentialGroup()
                    .addComponent(lblAddFarmData)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(lblProductID))
                .addGroup(pnlAddFarmDataLayout.createSequentialGroup()
                    .addGroup(pnlAddFarmDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlAddFarmDataLayout.createSequentialGroup()
                            .addGap(198, 198, 198)
                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlAddFarmDataLayout.createSequentialGroup()
                            .addComponent(lblHarvestDate, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtHarvestDate, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlAddFarmDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlAddFarmDataLayout.createSequentialGroup()
                            .addGap(100, 100, 100)
                            .addComponent(lblFarmLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtFarmLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlAddFarmDataLayout.createSequentialGroup()
                            .addGap(298, 298, 298)
                            .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))))
            .addContainerGap(184, Short.MAX_VALUE))
    );
    pnlAddFarmDataLayout.setVerticalGroup(
        pnlAddFarmDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnlAddFarmDataLayout.createSequentialGroup()
            .addGroup(pnlAddFarmDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlAddFarmDataLayout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addGroup(pnlAddFarmDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblAddFarmData)
                        .addComponent(lblProductID))
                    .addGap(492, 492, 492))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAddFarmDataLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(pnlAddFarmDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblHarvestDate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtHarvestDate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblFarmLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtFarmLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(412, 412, 412)))
            .addGroup(pnlAddFarmDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(122, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout pnlContainerLayout = new javax.swing.GroupLayout(pnlContainer);
    pnlContainer.setLayout(pnlContainerLayout);
    pnlContainerLayout.setHorizontalGroup(
        pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(pnlTopNav, javax.swing.GroupLayout.DEFAULT_SIZE, 1623, Short.MAX_VALUE)
        .addComponent(pnlViewProduct, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1623, Short.MAX_VALUE)
        .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContainerLayout.createSequentialGroup()
                .addComponent(pnlAddFarmData, javax.swing.GroupLayout.DEFAULT_SIZE, 1610, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE)))
    );
    pnlContainerLayout.setVerticalGroup(
        pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnlContainerLayout.createSequentialGroup()
            .addComponent(pnlTopNav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(pnlViewProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 744, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
        .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContainerLayout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addComponent(pnlAddFarmData, javax.swing.GroupLayout.PREFERRED_SIZE, 744, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE)))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(pnlContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 1623, Short.MAX_VALUE)
            .addGap(0, 0, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(pnlContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)
            .addGap(0, 0, Short.MAX_VALUE))
    );

    pack();
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        int logoutConfirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Warning", JOptionPane.YES_NO_OPTION);

        if (logoutConfirmation == JOptionPane.YES_OPTION) {
            Login login = new Login();
            login.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnAddFarmDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddFarmDataActionPerformed
        pnlViewProduct.setVisible(false);
        pnlAddFarmData.setVisible(true);
    }//GEN-LAST:event_btnAddFarmDataActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (txtHarvestDate.getText().equals("") || txtFarmLocation.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill in all details!", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                if (farmerController.updateProductUniqueCode(Integer.parseInt(lblProductID.getText()))) {
                    JOptionPane.showMessageDialog(null, "Farm data is added.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    viewProduct();
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to add farm data.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (IOException ex) {
                Logger.getLogger(Farmer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        pnlViewProduct.setVisible(true);
        pnlAddFarmData.setVisible(false);

        try {
            viewProduct();
        } catch (IOException ex) {
            Logger.getLogger(Farmer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCancelActionPerformed

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
            java.util.logging.Logger.getLogger(Farmer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Farmer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Farmer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Farmer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Farmer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddFarmData;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel lblAddFarmData;
    private javax.swing.JLabel lblFarmLocation;
    private javax.swing.JLabel lblGuide;
    private javax.swing.JLabel lblHarvestDate;
    private javax.swing.JLabel lblProductID;
    private javax.swing.JLabel lblProductOriginTracer;
    private javax.swing.JPanel pnlAddFarmData;
    private javax.swing.JPanel pnlContainer;
    private javax.swing.JPanel pnlTopNav;
    private javax.swing.JPanel pnlViewProduct;
    private javax.swing.JScrollPane scrpanProduct;
    private javax.swing.JTable tblProduct;
    private javax.swing.JTextField txtFarmLocation;
    private javax.swing.JTextField txtHarvestDate;
    // End of variables declaration//GEN-END:variables
}
