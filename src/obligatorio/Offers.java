/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package obligatorio;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import static obligatorio.Dashboard.content;

/**
 *
 * @author Faus
 */
public class Offers extends javax.swing.JPanel {

    /**
     * Creates new form OfferScreen
     */
    Connect conn;
    Connection reg;
    private DefaultTableModel tableModelProducts;
    private DefaultTableModel tableModelOffers;
    private final String[] offerProductFields = {"Ofertas recibidas"};
    private final String[] offerFields = {"Ofertas creadas"};
    private final String IdUser = Dashboard.user.getId();
    private final Dashboard dashboardFrame;

    public Offers(Dashboard frame) {
        initComponents();
        conn = new Connect();
        reg = conn.getConnection();
        this.initTableModelProduct();
        this.FetchProductsOffer();
        this.initTableModelOffer();
        this.FetchOffer();
        this.dashboardFrame = frame;
    }

    private ResultSet getProductOffer() {
        String query = "SELECT \"Producto\".\"IdProducto\", \"Producto\".\"Nombre\",\"Producto\".\"Precio\",\"Producto\".\"DescripcionProducto\" FROM \"Producto\" WHERE \"IdUsuario\" = "+IdUser+" AND EXISTS (SELECT * FROM \"TruequeExterno\" WHERE (\"Producto\".\"IdProducto\" = \"TruequeExterno\".\"IdProducto\" AND \"TruequeExterno\".\"Estado\" = 'sinaccion'));";
        Statement st;
        try {
            st = reg.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet offerSet = st.executeQuery(query);
            return offerSet;
        } catch (SQLException ex) {
            Logger.getLogger(Offers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private void FetchProductsOffer() {
        try {
            ResultSet resultSet = this.getProductOffer();
            this.tableModelProducts.setRowCount(0);

            while (resultSet.next()) {
                this.tableModelProducts.addRow(new String[]{resultSet.getString("Nombre")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(Offers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initTableModelProduct() {
        this.tableModelProducts = new DefaultTableModel(offerProductFields, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        this.TableProducts.setModel(this.tableModelProducts);
    }

    private int getSelectedRowProductId() {
        int idcell = TableProducts.getSelectedRow();

        ResultSet counter;
        try {
            counter = this.getProductOffer();
            int count = 0;
            while (counter.next()) {
                count++;
            }
            String list[][] = new String[count][3];
            int i = 0;
            counter.beforeFirst();
            while (counter.next()) {
                list[i][0] = counter.getString("IdProducto");
                i++;
            }
            return Integer.parseInt(list[idcell][0]);
        } catch (SQLException ex) {
            Logger.getLogger(Offers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    
    private String getSelectedRowProductDesc() {
        int idcell = TableProducts.getSelectedRow();

        ResultSet counter;
        try {
            counter = this.getProductOffer();
            int count = 0;
            while (counter.next()) {
                count++;
            }
            String list[][] = new String[count][3];
            int i = 0;
            counter.beforeFirst();
            while (counter.next()) {
                list[i][0] = counter.getString("DescripcionProducto");
                i++;
            }
            return list[idcell][0];
        } catch (SQLException ex) {
            Logger.getLogger(Offers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    private int getSelectedRowProductPrice() {
        int idcell = TableProducts.getSelectedRow();

        ResultSet counter;
        try {
            counter = this.getProductOffer();
            int count = 0;
            while (counter.next()) {
                count++;
            }
            String list[][] = new String[count][3];
            int i = 0;
            counter.beforeFirst();
            while (counter.next()) {
                list[i][0] = counter.getString("Precio");
                i++;
            }
            return Integer.parseInt(list[idcell][0]);
        } catch (SQLException ex) {
            Logger.getLogger(Offers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    

    private ResultSet getOffer() {
        String query = "SELECT \"ProductoOfrecido\".\"IdTrueque\",\"ProductoOfrecido\".\"IdProducto\",\"Producto\".\"Nombre\",\"Producto\".\"Precio\",\"Producto\".\"DescripcionProducto\"  FROM \"ProductoOfrecido\" JOIN \"Producto\" ON (\"ProductoOfrecido\".\"IdProducto\" =\"Producto\".\"IdProducto\" ) WHERE \"Producto\".\"IdUsuario\"="+IdUser+";";
        Statement st;
        try {
            st = reg.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet offerSet = st.executeQuery(query);
            return offerSet;
        } catch (SQLException ex) {
            Logger.getLogger(Offers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private void FetchOffer() {
        try {
            ResultSet resultSet = this.getOffer();
            this.tableModelOffers.setRowCount(0);

            while (resultSet.next()) {
                this.tableModelOffers.addRow(new String[]{resultSet.getString("Nombre")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(Offers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initTableModelOffer() {
        this.tableModelOffers = new DefaultTableModel(offerFields, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        this.TableOffers.setModel(this.tableModelOffers);
    }
    
    private int getSelectedRowOfferId() {
        int idcell = TableOffers.getSelectedRow();

        ResultSet counter;
        try {
            counter = this.getOffer();
            int count = 0;
            while (counter.next()) {
                count++;
            }
            String list[][] = new String[count][3];
            int i = 0;
            counter.beforeFirst();
            while (counter.next()) {
                list[i][0] = counter.getString("IdProducto");
                i++;
            }
            return Integer.parseInt(list[idcell][0]);
        } catch (SQLException ex) {
            Logger.getLogger(Offers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableProducts = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableOffers = new javax.swing.JTable();

        setMaximumSize(new java.awt.Dimension(758, 413));
        setMinimumSize(new java.awt.Dimension(758, 413));
        setPreferredSize(new java.awt.Dimension(758, 413));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Ofertas recibidas");

        TableProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null}
            },
            new String [] {
                "Producto"
            }
        ));
        TableProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TableProductsMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableProductsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableProducts);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jLabel2)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Ofertas creadas");

        TableOffers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null}
            },
            new String [] {
                "Oferta"
            }
        ));
        TableOffers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableOffersMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TableOffers);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jLabel3)))
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TableProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableProductsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TableProductsMouseClicked

    private void TableProductsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableProductsMousePressed
        // TODO add your handling code here:
        MyOffersDetails offerDetailsPanel;
        offerDetailsPanel = new MyOffersDetails(TableProducts.getValueAt(TableProducts.getSelectedRow(), 0).toString(),Integer.toString(getSelectedRowProductPrice()),getSelectedRowProductDesc(),Integer.toString(getSelectedRowProductId()));
        offerDetailsPanel.setSize(750, 430);
        offerDetailsPanel.setLocation(0, 0);
        content.removeAll();
        content.add(offerDetailsPanel, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();

    }//GEN-LAST:event_TableProductsMousePressed

    private void TableOffersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableOffersMouseClicked
        // TODO add your handling code here:
        CreateOfferPanel createOfferPanel;
        createOfferPanel = new CreateOfferPanel(dashboardFrame,Integer.toString(getSelectedRowOfferId()));
        createOfferPanel.setSize(750, 430);
        createOfferPanel.setLocation(0, 0);
        content.removeAll();
        content.add(createOfferPanel, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }//GEN-LAST:event_TableOffersMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableOffers;
    private javax.swing.JTable TableProducts;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

}
