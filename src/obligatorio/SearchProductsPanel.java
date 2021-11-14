package obligatorio;

import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import static obligatorio.Dashboard.user;

public class SearchProductsPanel extends javax.swing.JPanel {

    Connect conn;
    Connection reg;

    private final Dashboard dashboardFrame;
    private final ProductAdministrator productAdministrator;
    private DefaultTableModel tableModel;
    private final String[] productFields = {"IdProducto", "Nombre", "Precio", "DescripcionProducto", "NombreCategoria"};
    private Map<String, String> categoriesMap;

    public SearchProductsPanel(Dashboard frame) {
        this.dashboardFrame = frame;
        this.productAdministrator = new ProductAdministrator();
        this.initComponents();
        this.initConnection();
        this.initTableModel();
        this.initOrderByCB();
        this.initCategoryCB();
    }

    private void initConnection() {
        this.conn = new Connect();
        this.reg = this.conn.getConnection();
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

    private void initOrderByCB() {
        this.cb_orderBy.removeAllItems();

        for (String field : this.productFields) {
            this.cb_orderBy.addItem(field);
        }

        this.cb_orderBy.removeItemAt(0);
    }

    private void initCategoryCB() {
        this.cb_category.removeAllItems();
        try {
            this.FetchCategories();
        } catch (SQLException ex) {
            Logger.getLogger(SearchProductsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void FetchCategories() throws SQLException {
        ResultSet resultSet = this.ExecuteFetchCategoriesQuery();
        categoriesMap = new HashMap<>() {
        };
        this.cb_category.addItem("All");
        categoriesMap.put("All", "1\' OR \'1\'=\'1");

        while (resultSet.next()) {
            this.cb_category.addItem(resultSet.getString("NombreCategoria"));
            categoriesMap.put(resultSet.getString("NombreCategoria"), resultSet.getString("IdCategoria"));
        }
    }

    private final String SQL_QUERY_CATEGORIES = "SELECT * FROM \"Categoria\"";

    private ResultSet ExecuteFetchCategoriesQuery() throws SQLException {
        Statement statement = reg.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String sql = this.SQL_QUERY_CATEGORIES;
        ResultSet resultSet = statement.executeQuery(sql);

        return resultSet;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tf_titleQuery = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_products = new javax.swing.JTable();
        cb_category = new javax.swing.JComboBox<>();
        cb_orderBy = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_productDetails = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        btn_search = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tf_titleQuery.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tf_titleQuery.setForeground(new java.awt.Color(102, 102, 102));
        tf_titleQuery.setText("Buscar por nombre o descripción");
        tf_titleQuery.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tf_titleQueryMousePressed(evt);
            }
        });
        tf_titleQuery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_titleQueryActionPerformed(evt);
            }
        });
        add(tf_titleQuery, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 430, 30));

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
        tbl_products.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbl_products.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbl_products.setShowVerticalLines(false);
        jScrollPane4.setViewportView(tbl_products);

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 550, 180));

        cb_category.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(cb_category, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 100, -1));

        cb_orderBy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_orderBy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_orderByActionPerformed(evt);
            }
        });
        add(cb_orderBy, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 100, -1));

        jLabel1.setText("Ordenar por:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 70, -1));

        jLabel2.setText("Categoria:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 54, -1));

        btn_productDetails.setBackground(new java.awt.Color(18, 90, 173));
        btn_productDetails.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_productDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_productDetailsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_productDetailsMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_productDetailsMousePressed(evt);
            }
        });
        btn_productDetails.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Ver detalles");
        jLabel10.setToolTipText("");
        btn_productDetails.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 110, 20));

        add(btn_productDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, 210, 40));

        btn_search.setBackground(new java.awt.Color(18, 90, 173));
        btn_search.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_searchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_searchMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_searchMousePressed(evt);
            }
        });
        btn_search.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Buscar");
        jLabel11.setToolTipText("");
        btn_search.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 60, -1));

        add(btn_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, 100, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void tf_titleQueryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_titleQueryActionPerformed

    }//GEN-LAST:event_tf_titleQueryActionPerformed

    private void cb_orderByActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_orderByActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_orderByActionPerformed

    private void tf_titleQueryMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_titleQueryMousePressed
        if (tf_titleQuery.getText().equals("Buscar por nombre o descripción")) {
            tf_titleQuery.setText("");
        }
    }//GEN-LAST:event_tf_titleQueryMousePressed

    private void btn_productDetailsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_productDetailsMouseEntered
        setColorButton(btn_productDetails);
    }//GEN-LAST:event_btn_productDetailsMouseEntered

    private void btn_productDetailsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_productDetailsMouseExited
        resetColorButton(btn_productDetails);
    }//GEN-LAST:event_btn_productDetailsMouseExited

    private void btn_productDetailsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_productDetailsMousePressed
        int column = 0;
        int row = this.tbl_products.getSelectedRow();
        if (row == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Debe seleccionar un producto por el cual trocar \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        } else {
            String value = this.tbl_products.getModel().getValueAt(row, column).toString();
            ProductDetailPanel detailsPanel = new ProductDetailPanel(this.dashboardFrame, value);
            this.dashboardFrame.btn_openPanel(detailsPanel);
        }
    }//GEN-LAST:event_btn_productDetailsMousePressed

    private void btn_searchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_searchMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_searchMouseEntered

    private void btn_searchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_searchMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_searchMouseExited

    private void btn_searchMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_searchMousePressed
        try {
            this.FetchProducts();
        } catch (SQLException ex) {
            Logger.getLogger(SearchProductsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_searchMousePressed

    private void FetchProducts() throws SQLException {
        String title = this.tf_titleQuery.getText();
        String selectedCategoryId = this.categoriesMap.get(this.cb_category.getSelectedItem());
        String column = this.cb_orderBy.getSelectedItem().toString();
        ResultSet resultSet = this.productAdministrator.ExecuteFetchProductsQuery(title, selectedCategoryId, column);
        this.tableModel.setRowCount(0);

        while (resultSet.next()) {
            if (!user.getId().equals(resultSet.getString("IdUsuario"))) {
                this.tableModel.addRow(this.productAdministrator.MapProduct(resultSet, this.productFields));
            }
        }
    }

    void setColorButton(JPanel panel) {
        panel.setBackground(new Color(21, 101, 192));
    }

    void resetColorButton(JPanel panel) {
        panel.setBackground(new Color(18, 90, 173));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btn_productDetails;
    private javax.swing.JPanel btn_search;
    private javax.swing.JComboBox<String> cb_category;
    private javax.swing.JComboBox<String> cb_orderBy;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tbl_products;
    private javax.swing.JTextField tf_titleQuery;
    // End of variables declaration//GEN-END:variables
}
