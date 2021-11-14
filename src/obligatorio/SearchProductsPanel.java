package obligatorio;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import obligatorio.Entities.User;

public class SearchProductsPanel extends javax.swing.JPanel {
    Connect conn;
    Connection reg;
    User user;
    
    private final Dashboard dashboardFrame;
    private final ProductAdministrator productAdministrator;
    private DefaultTableModel tableModel;
    private final String[] productFields = {"IdProducto","Nombre", "Precio", "DescripcionProducto", "NombreCategoria"};
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
    
    private void initOrderByCB(){
        this.cb_orderBy.removeAllItems();
        
        for(String field : this.productFields){
            this.cb_orderBy.addItem(field);
        }
        
        this.cb_orderBy.removeItemAt(0);
    }
    
    private void initCategoryCB(){
        this.cb_category.removeAllItems();
        try {
            this.FetchCategories();
        } catch (SQLException ex) {
            Logger.getLogger(SearchProductsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void FetchCategories() throws SQLException {
        ResultSet resultSet = this.ExecuteFetchCategoriesQuery();
        categoriesMap = new HashMap<>() {};
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
        btn_search = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_products = new javax.swing.JTable();
        cb_category = new javax.swing.JComboBox<>();
        cb_orderBy = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_productDetails = new javax.swing.JButton();

        tf_titleQuery.setText("search via title or description");

        btn_search.setText("Search");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

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

        cb_category.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cb_orderBy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("orderBy:");

        jLabel2.setText("category:");

        btn_productDetails.setText("Open Product");
        btn_productDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_productDetailsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_titleQuery)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cb_category, 0, 100, Short.MAX_VALUE)
                                    .addComponent(cb_orderBy, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_productDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_titleQuery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_search))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_orderBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cb_category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_productDetails))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        try {
            this.FetchProducts();
        } catch (SQLException ex) {
            Logger.getLogger(SearchProductsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_searchActionPerformed

    private void btn_productDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_productDetailsActionPerformed
        int column = 0;
        int row = this.tbl_products.getSelectedRow();
        String value = this.tbl_products.getModel().getValueAt(row, column).toString();
        ProductDetailPanel detailsPanel = new ProductDetailPanel(this.dashboardFrame, value);
        
        this.dashboardFrame.btn_openPanel(detailsPanel);
    }//GEN-LAST:event_btn_productDetailsActionPerformed

    private void FetchProducts() throws SQLException {
        String title = this.tf_titleQuery.getText();
        String selectedCategoryId = this.categoriesMap.get(this.cb_category.getSelectedItem());
        String column = this.cb_orderBy.getSelectedItem().toString();
        ResultSet resultSet = this.productAdministrator.ExecuteFetchProductsQuery(title, selectedCategoryId, column);
        this.tableModel.setRowCount(0);

        while (resultSet.next()) {
            this.tableModel.addRow(this.productAdministrator.MapProduct(resultSet, this.productFields));
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_productDetails;
    private javax.swing.JButton btn_search;
    private javax.swing.JComboBox<String> cb_category;
    private javax.swing.JComboBox<String> cb_orderBy;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tbl_products;
    private javax.swing.JTextField tf_titleQuery;
    // End of variables declaration//GEN-END:variables
}
