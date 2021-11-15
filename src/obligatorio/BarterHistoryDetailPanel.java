package obligatorio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import static obligatorio.Dashboard.user;

public class BarterHistoryDetailPanel extends javax.swing.JPanel {

    private Dashboard dashboard;
    private String barterId;
    private String productId;
    private String UCA;
    private final ProductAdministrator productAdministrator;
    private DefaultTableModel tableModel;
    private final String[] productFields = {"IdProducto", "Nombre", "Precio", "DescripcionProducto"};

    public BarterHistoryDetailPanel(Dashboard dashboard, String barterId, String productId, String UCA) {
        this.dashboard = dashboard;
        this.barterId = barterId;
        this.productId = productId;
        this.UCA = UCA;
        this.productAdministrator = new ProductAdministrator();

        initComponents();
        initTableModel();
        this.loadProduct();
        this.loadProducts();
    }

    private void initTableModel() {
        this.tableModel = new DefaultTableModel(productFields, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        this.tbl_products.setModel(this.tableModel);
        this.tbl_products.removeColumn(this.tbl_products.getColumnModel().getColumn(0));
    }

    private void loadProduct() {
        try {
            ResultSet resultSet = this.productAdministrator.ExecuteFetchProductQuery(this.productId);
            resultSet.next();
            this.lab_product.setText(resultSet.getString("Nombre"));
        } catch (SQLException ex) {
            Logger.getLogger(ProductDetailPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadProducts() {
        try {
            ResultSet resultSet = this.productAdministrator.ExecuteFetchBarterProductsQuery(this.barterId);
            this.tableModel.setRowCount(0);

            while (resultSet.next()) {
                this.tableModel.addRow(this.productAdministrator.MapProduct(resultSet, this.productFields));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDetailPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Title = new javax.swing.JLabel();
        lab_product = new javax.swing.JLabel();
        Title2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_products = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        Title.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Title.setText("Producto principal");

        lab_product.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lab_product.setText("p1");

        Title2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Title2.setText("Productos ofrecidos");

        tbl_products.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbl_products);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(Title2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lab_product, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Title)
                .addGap(18, 18, 18)
                .addComponent(lab_product)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Title2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Title;
    private javax.swing.JLabel Title2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lab_product;
    private javax.swing.JTable tbl_products;
    // End of variables declaration//GEN-END:variables
}
