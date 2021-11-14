package obligatorio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import static obligatorio.Dashboard.user;

public class CreateOfferPanel extends javax.swing.JPanel {
    private Dashboard dashboardFrame;
    private String idProducto;
    private int productPrice;
    private String loggedUserId;
    private final ProductAdministrator productAdministrator;
    private final OfferAdministrator offerAdministrator;
    
    private DefaultTableModel tableModel;
    private final String[] productFields = {"IdProducto","Nombre", "Precio", "DescripcionProducto", "NombreCategoria"};
    
    public CreateOfferPanel(Dashboard frame, String idProducto) {
        this.dashboardFrame = frame;
        this.idProducto = idProducto;
        this.loggedUserId = user.getId();
        this.productAdministrator = new ProductAdministrator();
        this.offerAdministrator = new OfferAdministrator();
                
        initComponents();
        this.loadProduct(idProducto);
        this.initTableModel();
    }
    
    private void loadProduct(String idProducto){
        try {
            ResultSet resultSet = this.productAdministrator.ExecuteFetchProductQuery(idProducto);
            this.showProduct(resultSet);
        } catch (SQLException ex) {
            Logger.getLogger(ProductDetailPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void showProduct(ResultSet resultSet) throws SQLException{
        resultSet.next();
        this.productPrice = Integer.parseInt(resultSet.getString("Precio"));
        
        this.lab_productDetails.setText(resultSet.getString("Nombre") + " - UC$" + productPrice);
        this.tf_ucuCoinsOffer.setText(String.valueOf(productPrice));
    }
    
    private void initTableModel() {
        this.tableModel = new DefaultTableModel(productFields, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        this.tbl_myProducts.setModel(this.tableModel);
        this.tbl_myProducts.removeColumn(this.tbl_myProducts.getColumnModel().getColumn(0));
        try {
            this.FetchMyProducts();
        } catch (SQLException ex) {
            Logger.getLogger(CreateOfferPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.tbl_myProducts.getSelectionModel().addListSelectionListener((ListSelectionEvent lse) -> {
            if (!lse.getValueIsAdjusting()) {
                int[] selectedRows = this.tbl_myProducts.getSelectedRows();
                ArrayList<Integer> productPrices = new ArrayList<>();
                int uca = this.productPrice;
                for(int row : selectedRows){
                    uca -= Integer.parseInt(this.tbl_myProducts.getModel().getValueAt(row, 2).toString());
                }
                this.tf_ucuCoinsOffer.setText(String.valueOf(uca));
            }
        });
    }
    
    private void FetchMyProducts() throws SQLException {
        ResultSet resultSet = this.productAdministrator.ExecuteFetchUserProductsQuery(this.loggedUserId);
        this.tableModel.setRowCount(0);

        while (resultSet.next()) {
            this.tableModel.addRow(this.productAdministrator.MapProduct(resultSet, this.productFields));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        lab_productDetails = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btn_seeUserPreferences = new javax.swing.JButton();
        btn_makeOffer = new javax.swing.JButton();
        tf_ucuCoinsOffer = new javax.swing.JTextField();
        lab_userUCUCoins = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_myProducts = new javax.swing.JTable();

        jButton1.setText("jButton1");

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lab_productDetails.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lab_productDetails.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lab_productDetails.setText("Product");
        add(lab_productDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 312, -1));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 465, 10));

        btn_seeUserPreferences.setText("See user preferences");
        add(btn_seeUserPreferences, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, -1, -1));

        btn_makeOffer.setText("Make offer");
        btn_makeOffer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_makeOfferActionPerformed(evt);
            }
        });
        add(btn_makeOffer, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 310, -1, -1));

        tf_ucuCoinsOffer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ucuCoinsOfferActionPerformed(evt);
            }
        });
        add(tf_ucuCoinsOffer, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, 188, -1));

        lab_userUCUCoins.setText("You currently have 50 UCUCoins");
        add(lab_userUCUCoins, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, -1, -1));

        tbl_myProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_myProducts.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jScrollPane2.setViewportView(tbl_myProducts);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 465, 182));
    }// </editor-fold>//GEN-END:initComponents

    private void btn_makeOfferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_makeOfferActionPerformed
        int[] selectedRows = this.tbl_myProducts.getSelectedRows();
        ArrayList<String> productIds = new ArrayList<>();
        for(int row : selectedRows){
            productIds.add(this.tbl_myProducts.getModel().getValueAt(row, 0).toString());
        }
        
        this.offerAdministrator.InsertOffer(loggedUserId, idProducto, this.tf_ucuCoinsOffer.getText(), productIds.toArray(new String[productIds.size()]));
    }//GEN-LAST:event_btn_makeOfferActionPerformed

    private void tf_ucuCoinsOfferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ucuCoinsOfferActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_ucuCoinsOfferActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_makeOffer;
    private javax.swing.JButton btn_seeUserPreferences;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lab_productDetails;
    private javax.swing.JLabel lab_userUCUCoins;
    private javax.swing.JTable tbl_myProducts;
    private javax.swing.JTextField tf_ucuCoinsOffer;
    // End of variables declaration//GEN-END:variables
}
