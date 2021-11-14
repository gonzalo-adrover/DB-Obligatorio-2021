package obligatorio;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
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
    private final String[] productFields = {"IdProducto", "Nombre", "Precio", "DescripcionProducto", "NombreCategoria"};

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

    private void loadProduct(String idProducto) {
        try {
            ResultSet resultSet = this.productAdministrator.ExecuteFetchProductQuery(idProducto);
            this.showProduct(resultSet);
        } catch (SQLException ex) {
            Logger.getLogger(ProductDetailPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void showProduct(ResultSet resultSet) throws SQLException {
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
                for (int row : selectedRows) {
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

    void setColorLogin(JPanel panel) {
        panel.setBackground(new Color(21, 101, 192));
    }

    void resetColorLogin(JPanel panel) {
        panel.setBackground(new Color(18, 90, 173));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        lab_productDetails = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        tf_ucuCoinsOffer = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_myProducts = new javax.swing.JTable();
        btn_return = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btn_seeUserPreferences = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        saldoUCUCoins = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        saldoUCUCoins1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        btn_makeOffer = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lab_productDetails.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lab_productDetails.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lab_productDetails.setText("Product");
        add(lab_productDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 320, 20));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 640, 10));

        tf_ucuCoinsOffer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ucuCoinsOfferActionPerformed(evt);
            }
        });
        add(tf_ucuCoinsOffer, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, 70, 20));

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

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 640, 180));

        btn_return.setBackground(new java.awt.Color(18, 90, 173));
        btn_return.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_return.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_returnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_returnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_returnMousePressed(evt);
            }
        });
        btn_return.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("<");
        jLabel3.setToolTipText("");
        btn_return.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 20));

        add(btn_return, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 30, 30));

        btn_seeUserPreferences.setBackground(new java.awt.Color(18, 90, 173));
        btn_seeUserPreferences.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_seeUserPreferences.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_seeUserPreferencesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_seeUserPreferencesMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_seeUserPreferencesMousePressed(evt);
            }
        });
        btn_seeUserPreferences.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Ver preferencias");
        jLabel4.setToolTipText("");
        btn_seeUserPreferences.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 20));

        add(btn_seeUserPreferences, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 290, 170, 40));

        saldoUCUCoins.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        saldoUCUCoins.setText("X");
        add(saldoUCUCoins, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, 40, 20));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Producto selecionado a trocar:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 190, 20));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Valuación del Producto:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 150, 20));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("UCUCoins");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, 80, 20));

        saldoUCUCoins1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        saldoUCUCoins1.setText("X");
        add(saldoUCUCoins1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 300, 40, 20));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Neto total por producto seleccionado:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 240, 20));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("UCUCoins");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 300, 80, 20));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Saldo actual:");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 80, 20));

        jSeparator2.setForeground(new java.awt.Color(0, 153, 255));
        jSeparator2.setPreferredSize(new java.awt.Dimension(200, 10));
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, 320, 10));

        jSeparator3.setForeground(new java.awt.Color(0, 153, 255));
        jSeparator3.setPreferredSize(new java.awt.Dimension(200, 10));
        add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 320, 10));

        jSeparator4.setForeground(new java.awt.Color(0, 153, 255));
        jSeparator4.setPreferredSize(new java.awt.Dimension(200, 10));
        add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 320, 10));

        btn_makeOffer.setBackground(new java.awt.Color(18, 90, 173));
        btn_makeOffer.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_makeOffer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_makeOfferMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_makeOfferMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_makeOfferMousePressed(evt);
            }
        });
        btn_makeOffer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Realizar oferta");
        jLabel10.setToolTipText("");
        btn_makeOffer.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 20));

        add(btn_makeOffer, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 370, 160, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void tf_ucuCoinsOfferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ucuCoinsOfferActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_ucuCoinsOfferActionPerformed

    private void btn_returnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_returnMouseEntered
        setColorLogin(btn_return);
    }//GEN-LAST:event_btn_returnMouseEntered

    private void btn_returnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_returnMouseExited
        resetColorLogin(btn_return);
    }//GEN-LAST:event_btn_returnMouseExited

    private void btn_returnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_returnMousePressed
        ProductDetailPanel detailsPanel = new ProductDetailPanel(this.dashboardFrame, idProducto);

        this.dashboardFrame.btn_openPanel(detailsPanel);
    }//GEN-LAST:event_btn_returnMousePressed

    private void btn_seeUserPreferencesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_seeUserPreferencesMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_seeUserPreferencesMouseEntered

    private void btn_seeUserPreferencesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_seeUserPreferencesMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_seeUserPreferencesMouseExited

    private void btn_seeUserPreferencesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_seeUserPreferencesMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_seeUserPreferencesMousePressed

    private void btn_makeOfferMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_makeOfferMouseEntered
        setColorLogin(btn_return);
    }//GEN-LAST:event_btn_makeOfferMouseEntered

    private void btn_makeOfferMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_makeOfferMouseExited
        resetColorLogin(btn_return);
    }//GEN-LAST:event_btn_makeOfferMouseExited

    private void btn_makeOfferMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_makeOfferMousePressed
        int[] selectedRows = this.tbl_myProducts.getSelectedRows();
        ArrayList<String> productIds = new ArrayList<>();
        for (int row : selectedRows) {
            productIds.add(this.tbl_myProducts.getModel().getValueAt(row, 0).toString());
        }

        this.offerAdministrator.InsertOffer(loggedUserId, idProducto, this.tf_ucuCoinsOffer.getText(), productIds.toArray(new String[productIds.size()]));
    }//GEN-LAST:event_btn_makeOfferMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btn_makeOffer;
    private javax.swing.JPanel btn_return;
    private javax.swing.JPanel btn_seeUserPreferences;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lab_productDetails;
    private javax.swing.JLabel saldoUCUCoins;
    private javax.swing.JLabel saldoUCUCoins1;
    private javax.swing.JTable tbl_myProducts;
    private javax.swing.JTextField tf_ucuCoinsOffer;
    // End of variables declaration//GEN-END:variables
}
