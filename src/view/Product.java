package view;

import controller.ProductController;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;
import javax.swing.JOptionPane;
import model.DisplaySearchRecord;
import model.ProductRecord;

public class Product extends javax.swing.JFrame {

    ProductController productController = new ProductController();
    DisplaySearchRecord productRecord;

    /**
     * Creates new form Product
     */
    public Product() {
        initComponents();

    }

    // search product
    public void searchProduct(String productUniqueCode) throws FileNotFoundException, IOException, Exception {
        productRecord = productController.viewOneProduct(productUniqueCode);

        if (productRecord.isExist()) {
            Product product = new Product();
            product.setVisible(true);

            product.lblProductUniqueCode.setText(productRecord.significantRecord().productUniqueCode());
            product.lblProductName.setText(productRecord.productRecord().get().productName());
            product.lblProductDescription.setText(productRecord.productRecord().get().productDescription());
            product.lblIngredient.setText(productRecord.productRecord().get().ingredient());
            product.lblNutrition.setText(productRecord.productRecord().get().nutrition());
            product.lblWeight.setText(productRecord.productRecord().get().weight());
            product.lblPrice.setText(String.valueOf(productRecord.productRecord().get().price()));

            product.lblExpiryDate.setText(productRecord.significantRecord().expiryDate());
            product.lblHarvestDate.setText(productRecord.significantRecord().harvestDate());
            product.lblFarmLocation.setText(productRecord.significantRecord().farmLocation());
            product.lblProductionDate.setText(productRecord.significantRecord().productionDate());
            product.lblProoductionLocation.setText(productRecord.significantRecord().productionLocation());
            product.lblStorageDate.setText(productRecord.significantRecord().storageDate());
            product.lblStorageLocation.setText(productRecord.significantRecord().storageLocation());

     


        } else {
            MainScreen mainScreen = new MainScreen();
            mainScreen.setVisible(true);

            JOptionPane.showMessageDialog(null, "Product does not exist!", "Error", JOptionPane.ERROR_MESSAGE);
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

        pnlProduct = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        lblExpiryDate1 = new javax.swing.JLabel();
        lblProductName1 = new javax.swing.JLabel();
        lblProductDescription1 = new javax.swing.JLabel();
        lblIngredient1 = new javax.swing.JLabel();
        lblNutrition1 = new javax.swing.JLabel();
        lblWeight1 = new javax.swing.JLabel();
        lblPrice1 = new javax.swing.JLabel();
        lblProductUniqueCode = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        lblProductName = new javax.swing.JLabel();
        lblProductDescription = new javax.swing.JLabel();
        lblIngredient = new javax.swing.JLabel();
        lblNutrition = new javax.swing.JLabel();
        lblWeight = new javax.swing.JLabel();
        lblProductUniqueCode1 = new javax.swing.JLabel();
        lblExpiryDate = new javax.swing.JLabel();
        lblHarvestDate1 = new javax.swing.JLabel();
        lblFarmLocation1 = new javax.swing.JLabel();
        lblProductionDate1 = new javax.swing.JLabel();
        lblProoductionLocation1 = new javax.swing.JLabel();
        lblStorageDate1 = new javax.swing.JLabel();
        lblStorageLocation1 = new javax.swing.JLabel();
        lblHarvestDate = new javax.swing.JLabel();
        lblFarmLocation = new javax.swing.JLabel();
        lblProductionDate = new javax.swing.JLabel();
        lblProoductionLocation = new javax.swing.JLabel();
        lblStorageDate = new javax.swing.JLabel();
        lblStorageLocation = new javax.swing.JLabel();
        lblProductOriginInformation = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Product Origin Information");

        pnlProduct.setBackground(new java.awt.Color(255, 255, 255));
        pnlProduct.setPreferredSize(new java.awt.Dimension(1500, 800));

        btnBack.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnBack.setText("Back");
        btnBack.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblExpiryDate1.setBackground(new java.awt.Color(255, 255, 255));
        lblExpiryDate1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblExpiryDate1.setText("Expiry Date");

        lblProductName1.setBackground(new java.awt.Color(255, 255, 255));
        lblProductName1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblProductName1.setText("Product Name");

        lblProductDescription1.setBackground(new java.awt.Color(255, 255, 255));
        lblProductDescription1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblProductDescription1.setText("Product Description");

        lblIngredient1.setBackground(new java.awt.Color(255, 255, 255));
        lblIngredient1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblIngredient1.setText("Ingredient");

        lblNutrition1.setBackground(new java.awt.Color(255, 255, 255));
        lblNutrition1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblNutrition1.setText("Nutrition");

        lblWeight1.setBackground(new java.awt.Color(255, 255, 255));
        lblWeight1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblWeight1.setText("Weight");

        lblPrice1.setBackground(new java.awt.Color(255, 255, 255));
        lblPrice1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblPrice1.setText("Price (RM)");

        lblProductUniqueCode.setBackground(new java.awt.Color(255, 255, 255));
        lblProductUniqueCode.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblPrice.setBackground(new java.awt.Color(255, 255, 255));
        lblPrice.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblProductName.setBackground(new java.awt.Color(255, 255, 255));
        lblProductName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblProductDescription.setBackground(new java.awt.Color(255, 255, 255));
        lblProductDescription.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblIngredient.setBackground(new java.awt.Color(255, 255, 255));
        lblIngredient.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblNutrition.setBackground(new java.awt.Color(255, 255, 255));
        lblNutrition.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblWeight.setBackground(new java.awt.Color(255, 255, 255));
        lblWeight.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblProductUniqueCode1.setBackground(new java.awt.Color(255, 255, 255));
        lblProductUniqueCode1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblProductUniqueCode1.setText("Product Unique Code");

        lblExpiryDate.setBackground(new java.awt.Color(255, 255, 255));
        lblExpiryDate.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblHarvestDate1.setBackground(new java.awt.Color(255, 255, 255));
        lblHarvestDate1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblHarvestDate1.setText("Harvest Date");

        lblFarmLocation1.setBackground(new java.awt.Color(255, 255, 255));
        lblFarmLocation1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblFarmLocation1.setText("Farm Location");

        lblProductionDate1.setBackground(new java.awt.Color(255, 255, 255));
        lblProductionDate1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblProductionDate1.setText("Production Date");

        lblProoductionLocation1.setBackground(new java.awt.Color(255, 255, 255));
        lblProoductionLocation1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblProoductionLocation1.setText("Production Location");

        lblStorageDate1.setBackground(new java.awt.Color(255, 255, 255));
        lblStorageDate1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblStorageDate1.setText("Storage Date");

        lblStorageLocation1.setBackground(new java.awt.Color(255, 255, 255));
        lblStorageLocation1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblStorageLocation1.setText("Storage Location");

        lblHarvestDate.setBackground(new java.awt.Color(255, 255, 255));
        lblHarvestDate.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblFarmLocation.setBackground(new java.awt.Color(255, 255, 255));
        lblFarmLocation.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblProductionDate.setBackground(new java.awt.Color(255, 255, 255));
        lblProductionDate.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblProoductionLocation.setBackground(new java.awt.Color(255, 255, 255));
        lblProoductionLocation.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblStorageDate.setBackground(new java.awt.Color(255, 255, 255));
        lblStorageDate.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblStorageLocation.setBackground(new java.awt.Color(255, 255, 255));
        lblStorageLocation.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblProductOriginInformation.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lblProductOriginInformation.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblProductOriginInformation.setText("Product Origin Information");

        javax.swing.GroupLayout pnlProductLayout = new javax.swing.GroupLayout(pnlProduct);
        pnlProduct.setLayout(pnlProductLayout);
        pnlProductLayout.setHorizontalGroup(
            pnlProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlProductLayout.createSequentialGroup()
                        .addGroup(pnlProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlProductLayout.createSequentialGroup()
                                .addComponent(lblProductUniqueCode1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblProductUniqueCode, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlProductLayout.createSequentialGroup()
                                .addComponent(lblProductName1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlProductLayout.createSequentialGroup()
                                .addComponent(lblProductDescription1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblProductDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlProductLayout.createSequentialGroup()
                                .addComponent(lblIngredient1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblIngredient, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlProductLayout.createSequentialGroup()
                                .addComponent(lblWeight1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlProductLayout.createSequentialGroup()
                                .addComponent(lblPrice1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlProductLayout.createSequentialGroup()
                                .addComponent(lblNutrition1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblNutrition, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(100, 100, 100)
                        .addGroup(pnlProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlProductLayout.createSequentialGroup()
                                .addComponent(lblStorageLocation1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblStorageLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlProductLayout.createSequentialGroup()
                                .addComponent(lblStorageDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblStorageDate, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlProductLayout.createSequentialGroup()
                                .addComponent(lblProoductionLocation1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblProoductionLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlProductLayout.createSequentialGroup()
                                .addComponent(lblProductionDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblProductionDate, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlProductLayout.createSequentialGroup()
                                .addComponent(lblFarmLocation1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblFarmLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlProductLayout.createSequentialGroup()
                                .addComponent(lblHarvestDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblHarvestDate, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlProductLayout.createSequentialGroup()
                                .addComponent(lblExpiryDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblExpiryDate, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(lblProductOriginInformation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(150, Short.MAX_VALUE))
        );
        pnlProductLayout.setVerticalGroup(
            pnlProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(lblProductOriginInformation)
                .addGap(50, 50, 50)
                .addGroup(pnlProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblProductUniqueCode, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblExpiryDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblProductUniqueCode1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblExpiryDate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnlProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProductName1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHarvestDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHarvestDate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProductDescription1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProductDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFarmLocation1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFarmLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIngredient1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIngredient, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProductionDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProductionDate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNutrition1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNutrition, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProoductionLocation1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProoductionLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblWeight1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStorageDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStorageDate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrice1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStorageLocation1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStorageLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(256, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 1506, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // back button
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        MainScreen mainScreen = new MainScreen();
        mainScreen.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Product().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel lblExpiryDate;
    private javax.swing.JLabel lblExpiryDate1;
    private javax.swing.JLabel lblFarmLocation;
    private javax.swing.JLabel lblFarmLocation1;
    private javax.swing.JLabel lblHarvestDate;
    private javax.swing.JLabel lblHarvestDate1;
    private javax.swing.JLabel lblIngredient;
    private javax.swing.JLabel lblIngredient1;
    private javax.swing.JLabel lblNutrition;
    private javax.swing.JLabel lblNutrition1;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblPrice1;
    private javax.swing.JLabel lblProductDescription;
    private javax.swing.JLabel lblProductDescription1;
    private javax.swing.JLabel lblProductName;
    private javax.swing.JLabel lblProductName1;
    private javax.swing.JLabel lblProductOriginInformation;
    private javax.swing.JLabel lblProductUniqueCode;
    private javax.swing.JLabel lblProductUniqueCode1;
    private javax.swing.JLabel lblProductionDate;
    private javax.swing.JLabel lblProductionDate1;
    private javax.swing.JLabel lblProoductionLocation;
    private javax.swing.JLabel lblProoductionLocation1;
    private javax.swing.JLabel lblStorageDate;
    private javax.swing.JLabel lblStorageDate1;
    private javax.swing.JLabel lblStorageLocation;
    private javax.swing.JLabel lblStorageLocation1;
    private javax.swing.JLabel lblWeight;
    private javax.swing.JLabel lblWeight1;
    private javax.swing.JPanel pnlProduct;
    // End of variables declaration//GEN-END:variables
}
