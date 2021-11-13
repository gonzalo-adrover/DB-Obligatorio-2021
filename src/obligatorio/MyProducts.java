/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio;

import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.NumberFormatter;
import static obligatorio.Dashboard.user;

/**
 *
 * @author Antonio
 */
public class MyProducts extends javax.swing.JPanel {

    Connect conn;
    Connection reg;

    private Map<String, String> categoriesMap;
    private DefaultTableModel tableModel;
    private final String[] productFields = {"Nombre", "IdCategoria", "Precio", "DescripcionProducto"};

    /**
     * Creates new form Principal
     *
     * @throws java.sql.SQLException
     */
    public MyProducts() throws SQLException {
        initComponents();
        conn = new Connect();
        reg = conn.getConnection();
        this.initTableModel();
        this.fetchCategories();
        this.loadUserProductsTable();
    }

    private void initTableModel() {
        this.tableModel = new DefaultTableModel(productFields, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        this.tbl_products.setModel(this.tableModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Title = new javax.swing.JLabel();
        btn_editProduct = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_products = new javax.swing.JTable();
        btn_addProduct = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        btn_deleteProduct = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        nameTitle = new javax.swing.JLabel();
        input_name = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        priceTitle = new javax.swing.JLabel();
        input_price = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        categoryTitle = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        descriptionTitle = new javax.swing.JLabel();
        input_description = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        cb_category = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(750, 430));
        setPreferredSize(new java.awt.Dimension(750, 430));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Title.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Title.setText("Mis Productos");
        add(Title, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        btn_editProduct.setBackground(new java.awt.Color(18, 90, 173));
        btn_editProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_editProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_editProductMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_editProductMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_editProductMousePressed(evt);
            }
        });
        btn_editProduct.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Editar");
        jLabel10.setToolTipText("");
        btn_editProduct.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 60, -1));

        add(btn_editProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, 100, 50));

        tbl_products.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Categoría", "Precio"
            }
        ));
        tbl_products.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_productsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_products);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 460, 250));

        btn_addProduct.setBackground(new java.awt.Color(18, 90, 173));
        btn_addProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_addProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_addProductMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_addProductMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_addProductMousePressed(evt);
            }
        });
        btn_addProduct.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Agregar nuevo");
        jLabel11.setToolTipText("");
        btn_addProduct.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, -1));

        add(btn_addProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 150, 50));

        btn_deleteProduct.setBackground(new java.awt.Color(18, 90, 173));
        btn_deleteProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_deleteProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_deleteProductMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_deleteProductMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_deleteProductMousePressed(evt);
            }
        });
        btn_deleteProduct.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Borrar");
        jLabel12.setToolTipText("");
        btn_deleteProduct.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 60, -1));

        add(btn_deleteProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 360, 80, 50));

        nameTitle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nameTitle.setText("Nombre:");
        add(nameTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, 60, -1));

        input_name.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        input_name.setBorder(null);
        input_name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                input_nameMousePressed(evt);
            }
        });
        input_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_nameActionPerformed(evt);
            }
        });
        add(input_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 90, 160, 20));

        jSeparator4.setForeground(new java.awt.Color(0, 153, 255));
        jSeparator4.setPreferredSize(new java.awt.Dimension(200, 10));
        add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, 240, 10));

        priceTitle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        priceTitle.setText("Precio:");
        add(priceTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, 40, -1));

        input_price.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        input_price.setBorder(null);
        input_price.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                input_priceMousePressed(evt);
            }
        });
        input_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_priceActionPerformed(evt);
            }
        });
        add(input_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, 160, 20));

        jSeparator2.setForeground(new java.awt.Color(0, 153, 255));
        jSeparator2.setPreferredSize(new java.awt.Dimension(200, 10));
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 160, 240, 10));

        categoryTitle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        categoryTitle.setText("Categoria:");
        add(categoryTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 210, 70, -1));

        jSeparator5.setForeground(new java.awt.Color(0, 153, 255));
        jSeparator5.setPreferredSize(new java.awt.Dimension(200, 10));
        add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 240, 240, 10));

        descriptionTitle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        descriptionTitle.setText("Descripcion:");
        add(descriptionTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 170, 80, -1));

        input_description.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        input_description.setBorder(null);
        input_description.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                input_descriptionMousePressed(evt);
            }
        });
        input_description.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_descriptionActionPerformed(evt);
            }
        });
        add(input_description, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 170, 160, 20));

        jSeparator6.setForeground(new java.awt.Color(0, 153, 255));
        jSeparator6.setPreferredSize(new java.awt.Dimension(200, 10));
        add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 200, 240, 10));

        cb_category.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_categoryActionPerformed(evt);
            }
        });
        add(cb_category, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 210, 100, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btn_editProductMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editProductMouseEntered
        setColorSaveButton(btn_editProduct);
    }//GEN-LAST:event_btn_editProductMouseEntered

    private void btn_editProductMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editProductMouseExited
        resetColorSaveButton(btn_editProduct);
    }//GEN-LAST:event_btn_editProductMouseExited

    private void btn_editProductMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editProductMousePressed
        try {
            executeUpdateProductInfo();
        } catch (SQLException ex) {
            Logger.getLogger(MyProducts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_editProductMousePressed

    private void tbl_productsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_productsMouseClicked
        this.tableModel = (DefaultTableModel) tbl_products.getModel();

        String tblName = tbl_products.getValueAt(tbl_products.getSelectedRow(), 0).toString();
        String tblCategory = tbl_products.getValueAt(tbl_products.getSelectedRow(), 1).toString();
        String tblPrice = tbl_products.getValueAt(tbl_products.getSelectedRow(), 2).toString();
        String tblDescription = tbl_products.getValueAt(tbl_products.getSelectedRow(), 3).toString();

        input_name.setText(tblName);
        input_price.setText(tblPrice);
        input_description.setText(tblDescription);
        cb_category.setSelectedIndex(getKeyByValue(categoriesMap, tblCategory));

    }//GEN-LAST:event_tbl_productsMouseClicked

    private void btn_addProductMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addProductMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_addProductMouseEntered

    private void btn_addProductMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addProductMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_addProductMouseExited

    private void btn_addProductMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addProductMousePressed
        //GOTO Add Product
    }//GEN-LAST:event_btn_addProductMousePressed

    private void btn_deleteProductMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_deleteProductMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_deleteProductMouseEntered

    private void btn_deleteProductMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_deleteProductMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_deleteProductMouseExited

    private void btn_deleteProductMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_deleteProductMousePressed
        try {
            executeDeleteProduct();
        } catch (SQLException ex) {
            Logger.getLogger(MyProducts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_deleteProductMousePressed

    private void input_nameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_input_nameMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_nameMousePressed

    private void input_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_nameActionPerformed

    private void input_priceMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_input_priceMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_priceMousePressed

    private void input_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_priceActionPerformed

    private void input_descriptionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_input_descriptionMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_descriptionMousePressed

    private void input_descriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_descriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_descriptionActionPerformed

    private void cb_categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_categoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_categoryActionPerformed

    private void fetchCategories() throws SQLException {
        ResultSet resultSet = this.executeFetchCategoriesQuery();
        categoriesMap = new HashMap<>() {
        };
        this.cb_category.removeAllItems();

        while (resultSet.next()) {
            this.cb_category.addItem(resultSet.getString("NombreCategoria"));
            categoriesMap.put(resultSet.getString("IdCategoria"), resultSet.getString("NombreCategoria"));
        }
    }

    private ResultSet executeFetchCategoriesQuery() throws SQLException {
        String SQL_QUERY_CATEGORIES = "SELECT * FROM \"Categoria\"";

        Statement statement = reg.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery(SQL_QUERY_CATEGORIES);

        return resultSet;
    }

    public ResultSet executeFetchUserProductsQuery() throws SQLException {
        String SQL_QUERY_PRODUCTS = "SELECT * FROM \"Producto\" WHERE \"IdUsuario\" = " + user.getId() + " AND \"Estado\" = 'True';";

        Statement statement = reg.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery(SQL_QUERY_PRODUCTS);

        return resultSet;
    }

    public void loadUserProductsTable() throws SQLException {
        ResultSet resultSet = this.executeFetchUserProductsQuery();
        this.tableModel.setRowCount(0);
        while (resultSet.next()) {
            this.tableModel.addRow(this.MapProduct(resultSet));
        }
    }

    private Object[] MapProduct(ResultSet resultSet) throws SQLException {
        ArrayList<Object> productFieldsList = new ArrayList<>();
        for (String field : this.productFields) {
            String fieldToAdd = resultSet.getString(field);
            if (field.equals("IdCategoria")) {
                fieldToAdd = categoriesMap.get(fieldToAdd);
            }
            productFieldsList.add(fieldToAdd);
        }

        return productFieldsList.toArray();
    }

    public static <T, E> int getKeyByValue(Map<T, E> map, E value) {
        for (Entry<T, E> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return (Integer.parseInt((String) entry.getKey()) - 1);
            }
        }
        return -1;
    }

    public void executeUpdateProductInfo() throws SQLException {
        Statement stmt = reg.createStatement();

        int idcell = tbl_products.getSelectedRow();
        if (idcell <= -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Debe seleccionar el producto a editar. \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        } else {
            Statement stm = reg.createStatement();
            ResultSet counter = this.executeFetchUserProductsQuery();

            int count = 0;
            while (counter.next()) {
                count++;
            }

            String list[][] = new String[count][6];
            int i = 0;
            counter.beforeFirst();
            while (counter.next()) {
                list[i][0] = counter.getString("IdProducto");
                i++;
            }
            int id = Integer.parseInt(list[idcell][0]);
            if (id <= 0) {
                javax.swing.JOptionPane.showMessageDialog(this, "Debe seleccionar el usuario a borrar. \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            }
            String sqlUsuario = "UPDATE \"Producto\" SET \"Nombre\" = '" + input_name.getText() + "', \"DescripcionProducto\" = '" + input_description.getText() + "', \"Precio\" = '" + input_price.getText() + "', \"IdCategoria\" = " + (cb_category.getSelectedIndex() + 1) + " WHERE \"IdProducto\" = " + id + ";";
            stmt.executeUpdate(sqlUsuario);
            loadUserProductsTable();
        }
    }

    public void executeDeleteProduct() throws SQLException {
        Statement stmt = reg.createStatement();

        int idcell = tbl_products.getSelectedRow();
        if (idcell <= -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Debe seleccionar el producto a eliminar. \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        } else {
            Statement stm = reg.createStatement();
            ResultSet counter = this.executeFetchUserProductsQuery();

            int count = 0;
            while (counter.next()) {
                count++;
            }

            String list[][] = new String[count][6];
            int i = 0;
            counter.beforeFirst();
            while (counter.next()) {
                list[i][0] = counter.getString("IdProducto");
                i++;
            }
            int id = Integer.parseInt(list[idcell][0]);
            if (id <= 0) {
                javax.swing.JOptionPane.showMessageDialog(this, "Debe seleccionar el usuario a eliminar. \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            }
            String sqlUsuario = "UPDATE \"Producto\" SET \"Estado\" = 'False' WHERE \"IdProducto\" = " + id + ";";
            stmt.executeUpdate(sqlUsuario);
            loadUserProductsTable();
        }
    }

    void setColorSaveButton(JPanel panel) {
        panel.setBackground(new Color(21, 101, 192));
    }

    void resetColorSaveButton(JPanel panel) {
        panel.setBackground(new Color(18, 90, 173));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Title;
    private javax.swing.JPanel btn_addProduct;
    private javax.swing.JPanel btn_deleteProduct;
    private javax.swing.JPanel btn_editProduct;
    private javax.swing.JLabel categoryTitle;
    private javax.swing.JComboBox<String> cb_category;
    private javax.swing.JLabel descriptionTitle;
    private javax.swing.JTextField input_description;
    private javax.swing.JTextField input_name;
    private javax.swing.JTextField input_price;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel nameTitle;
    private javax.swing.JLabel priceTitle;
    private javax.swing.JTable tbl_products;
    // End of variables declaration//GEN-END:variables
}
