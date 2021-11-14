/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class MyOffersDetails extends javax.swing.JPanel {

    Connect conn;
    Connection reg;
    private DefaultTableModel tableModelProductsOffered;
    private final String[] offeredProductFields = {"Nombre Producto Publicado", "Precio en UCUCoins"};
    String nameProduct;
    String priceProduct;
    String description;
    String idProducto;
    String idTrueque;

    /**
     * Creates new form MyOffersDetails
     */
    public MyOffersDetails(String nameProduct, String priceProduct, String description, String idProducto, String idTrueque) {
        initComponents();
        conn = new Connect();
        reg = conn.getConnection();
        this.NameProduct.setText(nameProduct);
        this.Price1.setText(priceProduct);
        this.Detail1.setText(description);
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.description = description;
        this.idProducto = idProducto;
        this.idTrueque = idTrueque;
        this.initTableModelProductOffered();
        this.FetchProductsOffered();
    }

    private ResultSet getProductOffered() throws SQLException {
        System.out.println(idTrueque);
        String query = "SELECT \"ProductoOfrecido\".\"IdProducto\", \"Producto\".\"Nombre\", \"Producto\".\"Precio\" FROM \"ProductoOfrecido\" JOIN \"Producto\" ON (\"ProductoOfrecido\".\"IdProducto\" =\"Producto\".\"IdProducto\" )  WHERE (\"ProductoOfrecido\".\"IdTrueque\"=" + idTrueque + ");";
        Statement st = reg.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet offerSet = st.executeQuery(query);
        return offerSet;
    }

    private void FetchProductsOffered() {
        try {
            ResultSet resultSet = this.getProductOffered();
            this.tableModelProductsOffered.setRowCount(0);

            while (resultSet.next()) {
                this.tableModelProductsOffered.addRow(new String[]{resultSet.getString("Nombre"), resultSet.getString("Precio")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(Offers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initTableModelProductOffered() {
        this.tableModelProductsOffered = new DefaultTableModel(offeredProductFields, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        this.TableOffers.setModel(this.tableModelProductsOffered);
    }
    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        Title = new javax.swing.JLabel();
        NameProduct = new javax.swing.JLabel();
        Price = new javax.swing.JLabel();
        Detail = new javax.swing.JLabel();
        Price1 = new javax.swing.JLabel();
        Detail1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableOffers = new javax.swing.JTable();

        jCheckBox1.setText("jCheckBox1");

        Title.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Title.setText("Detalles de la Oferta");

        NameProduct.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        NameProduct.setText("jLabel2");

        Price.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Price.setText("Precio:");

        Detail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Detail.setText("Descripcion:");

        Price1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Price1.setText("jLabel2");

        Detail1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Detail1.setText("jLabel2");

        TableOffers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Te ofrecieron", "Precio en UCUCoins"
            }
        ));
        TableOffers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TableOffersMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableOffersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableOffers);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Title)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Detail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Detail1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Price)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Price1))
                    .addComponent(NameProduct))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(Title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(NameProduct)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Price)
                    .addComponent(Price1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Detail)
                    .addComponent(Detail1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    
    private void TableOffersMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableOffersMousePressed
     
    }//GEN-LAST:event_TableOffersMousePressed

    private void TableOffersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableOffersMouseClicked
        // TODO add your handling code here:
        int result = JOptionPane.showConfirmDialog(this, "¿Desea aceptar esta oferta?");
        System.out.println(result);
    }//GEN-LAST:event_TableOffersMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Detail;
    private javax.swing.JLabel Detail1;
    private javax.swing.JLabel NameProduct;
    private javax.swing.JLabel Price;
    private javax.swing.JLabel Price1;
    private javax.swing.JTable TableOffers;
    private javax.swing.JLabel Title;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
