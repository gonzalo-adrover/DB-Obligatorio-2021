/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class MyOffersDetails extends javax.swing.JPanel {

    Connect conn;
    Connection reg;
    private DefaultTableModel tableModelProductsOffered;
    private DefaultTableModel tableModelUsers;
    private DefaultTableModel tableModelUCUCoins;
    private final String[] usersFields = {"Nombre usuario"};
    private final String[] UCUCoinsFields = {"Agregado en UCU Coins"};
    private final String[] offeredProductFields = {"Te ofrecieron el producto:", "El precio en UCUCoins:", "Diferencia en UCUCoins:"};
    String nameProduct;
    String priceProduct;
    String description;
    String idProducto;
    String idTrueque;
    String idBarter;
    LinkedList<String> productsOfferedId = new LinkedList<>();
    String productsOfferedIdUser;
    private final String IdUser = Dashboard.user.getId();

    /**
     * Creates new form MyOffersDetails
     */
    public MyOffersDetails(String nameProduct, String priceProduct, String description, String idProducto) {
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
        this.initTableModel();
        this.FetchUsers();
    }

    private ResultSet getProductOffered(String idUsuario, String idBarter) {
        String query = "SELECT \"Producto\".\"IdProducto\",\"Producto\".\"Nombre\",\"Producto\".\"Precio\",\"Producto\".\"IdUsuario\" FROM \"TruequeExterno\" JOIN \"ProductoOfrecido\" ON (\"TruequeExterno\".\"IdTrueque\" = \"ProductoOfrecido\".\"IdTrueque\") JOIN \"Producto\" ON (\"Producto\".\"IdProducto\" = \"ProductoOfrecido\".\"IdProducto\")  WHERE (\"TruequeExterno\".\"IdProducto\"=" + idProducto + " AND \"Producto\".\"Estado\" = true AND \"Producto\".\"IdUsuario\"=" + idUsuario + " AND \"TruequeExterno\".\"Estado\" = 'sinaccion' AND \"TruequeExterno\".\"IdTrueque\"=" + idBarter + ") ;";

        Statement st;
        try {
            st = reg.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet offerSet = st.executeQuery(query);
            return offerSet;
        } catch (SQLException ex) {
            Logger.getLogger(MyOffersDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private ResultSet getUsers() {
        String query = "SELECT \"Trueque\".\"IdUsuario\",\"Usuario\".\"Nombre\",\"Trueque\".\"IdTrueque\" FROM \"TruequeExterno\" JOIN \"Trueque\" ON (\"TruequeExterno\".\"IdTrueque\" = \"Trueque\".\"IdTrueque\") JOIN \"Usuario\" ON (\"Trueque\".\"IdUsuario\" = \"Usuario\".\"IdUsuario\" ) WHERE (\"TruequeExterno\".\"IdProducto\"=" + idProducto + " AND \"TruequeExterno\".\"Estado\" = 'sinaccion') ;";
        Statement st;
        try {
            st = reg.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet offerSet = st.executeQuery(query);
            return offerSet;
        } catch (SQLException ex) {
            Logger.getLogger(MyOffersDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private ResultSet getUCUCoins(String idUser, String idBarter) {
        String query = "SELECT \"TruequeExterno\".\"ExtraUCUCoins\",\"Trueque\".\"IdTrueque\",\"Trueque\".\"IdUsuario\" FROM \"TruequeExterno\" JOIN \"Trueque\" ON (\"TruequeExterno\".\"IdTrueque\" = \"Trueque\".\"IdTrueque\") WHERE (\"TruequeExterno\".\"IdProducto\"=" + idProducto + "  AND \"Trueque\".\"IdUsuario\"=" + idUser + " AND \"TruequeExterno\".\"Estado\" = 'sinaccion' AND \"TruequeExterno\".\"IdTrueque\"=" + idBarter + ") ;";
        Statement st;
        try {
            st = reg.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet offerSet = st.executeQuery(query);
            return offerSet;
        } catch (SQLException ex) {
            Logger.getLogger(MyOffersDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private void FetchUsers() {
        ResultSet resultSet = this.getUsers();
        if (resultSet != null) {
            this.tableModelUsers.setRowCount(0);
            try {
                while (resultSet.next()) {
                    this.tableModelUsers.addRow(new String[]{resultSet.getString("Nombre")});
                }
            } catch (SQLException ex) {
                Logger.getLogger(MyOffersDetails.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private void FetchProductsOffered(String idUser, String idBarter) {
        ResultSet resultSet = this.getProductOffered(idUser, idBarter);
        if (resultSet != null) {
            this.tableModelProductsOffered.setRowCount(0);
            try {
                while (resultSet.next()) {
                    this.tableModelProductsOffered.addRow(new String[]{resultSet.getString("Nombre"), resultSet.getString("Precio")});
                    productsOfferedId.add(resultSet.getString("IdProducto"));
                    productsOfferedIdUser = resultSet.getString("IdUsuario");
                }
            } catch (SQLException ex) {
                Logger.getLogger(MyOffersDetails.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private void FetchUCUCoins(String idUser, String idBarter) {
        ResultSet resultSet = this.getUCUCoins(idUser, idBarter);
        if (resultSet != null) {
            this.tableModelUCUCoins.setRowCount(0);
            try {
                while (resultSet.next()) {
                    this.tableModelUCUCoins.addRow(new String[]{resultSet.getString("ExtraUCUCoins")});
                    this.idBarter = resultSet.getString("IdTrueque");
                }
            } catch (SQLException ex) {
                Logger.getLogger(MyOffersDetails.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private void initTableModel() {
        this.tableModelUsers = new DefaultTableModel(usersFields, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        this.TableUsers.setModel(this.tableModelUsers);

        this.tableModelProductsOffered = new DefaultTableModel(offeredProductFields, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        this.TableOffers1.setModel(this.tableModelProductsOffered);

        this.tableModelUCUCoins = new DefaultTableModel(UCUCoinsFields, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        this.TableUCUCoins.setModel(this.tableModelUCUCoins);
    }

    public void executeUpdateBarterAccept() {
        try {
            conn.getConnection().setAutoCommit(false);
            Statement stm1 = reg.createStatement();
            stm1.executeUpdate("UPDATE \"TruequeExterno\" SET \"Estado\"='aceptado' WHERE \"IdTrueque\"= " + idBarter + ";");
            Statement stm2 = reg.createStatement();
            stm2.executeUpdate("UPDATE \"Producto\" SET \"Estado\"='false', \"IdUsuario\"= " + productsOfferedIdUser + " WHERE \"IdProducto\"= " + idProducto + ";");
            Statement stm4 = reg.createStatement();
            stm4.executeUpdate("UPDATE \"TruequeExterno\" SET \"Estado\"='rechazado' WHERE \"IdTrueque\"<>" + idBarter + " AND \"IdProducto\"= " + idProducto + ";");
            for (String productOffered : productsOfferedId) {
                Statement stm3 = reg.createStatement();
                stm3.executeUpdate("UPDATE \"Producto\" SET \"Estado\"='false', \"IdUsuario\"= " + IdUser + "WHERE \"IdProducto\"= " + productOffered + ";");
            }
            conn.getConnection().commit();
            conn.getConnection().setAutoCommit(true);

        } catch (SQLException ex) {
            Logger.getLogger(MyOffersDetails.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void executeUpdateBarterReject() {
        try {
            Statement stm1 = reg.createStatement();
            stm1.executeUpdate("UPDATE \"TruequeExterno\" SET \"Estado\"='rechazado' WHERE \"IdTrueque\"= " + idBarter + ";");
        } catch (SQLException ex) {
            Logger.getLogger(MyOffersDetails.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private int getSelectedRowUserId() {
        int idcell = TableUsers.getSelectedRow();

        ResultSet counter;
        try {
            counter = this.getUsers();
            int count = 0;
            while (counter.next()) {
                count++;
            }
            String list[][] = new String[count][3];
            int i = 0;
            counter.beforeFirst();
            while (counter.next()) {
                list[i][0] = counter.getString("IdUsuario");
                i++;
            }
            return Integer.parseInt(list[idcell][0]);
        } catch (SQLException ex) {
            Logger.getLogger(Offers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    private int getSelectedRowBarterId() {
        int idcell = TableUsers.getSelectedRow();

        ResultSet counter;
        try {
            counter = this.getUsers();
            int count = 0;
            while (counter.next()) {
                count++;
            }
            String list[][] = new String[count][3];
            int i = 0;
            counter.beforeFirst();
            while (counter.next()) {
                list[i][0] = counter.getString("IdTrueque");
                i++;
            }
            return Integer.parseInt(list[idcell][0]);
        } catch (SQLException ex) {
            Logger.getLogger(Offers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
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
        NameProduct1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableUsers = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableOffers1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        TableUCUCoins = new javax.swing.JTable();
        btnAccept = new javax.swing.JButton();
        btnReject = new javax.swing.JButton();

        jCheckBox1.setText("jCheckBox1");

        setMaximumSize(new java.awt.Dimension(750, 430));
        setMinimumSize(new java.awt.Dimension(750, 430));
        setPreferredSize(new java.awt.Dimension(750, 430));

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

        NameProduct1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        NameProduct1.setText("Nombre producto:");

        TableUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Usuario que realizo la oferta"
            }
        ));
        TableUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TableUsersMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableUsersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableUsers);

        TableOffers1.setModel(new javax.swing.table.DefaultTableModel(
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
        TableOffers1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TableOffers1MousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableOffers1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TableOffers1);
        if (TableOffers1.getColumnModel().getColumnCount() > 0) {
            TableOffers1.getColumnModel().getColumn(1).setHeaderValue("Precio en UCUCoins");
        }

        TableUCUCoins.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Agregado en UCUCoins"
            }
        ));
        TableUCUCoins.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TableUCUCoinsMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableUCUCoinsMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TableUCUCoins);

        btnAccept.setText("Aceptar");
        btnAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptActionPerformed(evt);
            }
        });

        btnReject.setText("Rechazar");
        btnReject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRejectActionPerformed(evt);
            }
        });

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(NameProduct1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(NameProduct))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(Price)
                                    .addGap(18, 18, 18)
                                    .addComponent(Price1)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(btnAccept)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnReject))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(Title)
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NameProduct)
                            .addComponent(NameProduct1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Price)
                            .addComponent(Price1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Detail)
                            .addComponent(Detail1))
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnAccept)
                                    .addComponent(btnReject)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    private void TableUsersMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableUsersMousePressed

    }//GEN-LAST:event_TableUsersMousePressed

    private void TableUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableUsersMouseClicked
        // TODO add your handling code here:
        productsOfferedId.clear();
        int idUser = getSelectedRowUserId();
        int idBarter1 = getSelectedRowBarterId();
        FetchProductsOffered(Integer.toString(idUser), Integer.toString(idBarter1));
        FetchUCUCoins(Integer.toString(idUser), Integer.toString(idBarter1));

    }//GEN-LAST:event_TableUsersMouseClicked

    private void TableOffers1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableOffers1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_TableOffers1MousePressed

    private void TableOffers1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableOffers1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TableOffers1MouseClicked

    private void TableUCUCoinsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableUCUCoinsMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_TableUCUCoinsMousePressed

    private void TableUCUCoinsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableUCUCoinsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TableUCUCoinsMouseClicked

    private void btnAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptActionPerformed
        // TODO add your handling code here:
        if (productsOfferedIdUser != "") {
            executeUpdateBarterAccept();
            initTableModel();
            FetchUsers();
            productsOfferedId.clear();
            productsOfferedIdUser = "";
        }

    }//GEN-LAST:event_btnAcceptActionPerformed

    private void btnRejectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRejectActionPerformed
        // TODO add your handling code here:
        if (productsOfferedIdUser != "") {
            executeUpdateBarterReject();
            initTableModel();
            FetchUsers();
        }
    }//GEN-LAST:event_btnRejectActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Detail;
    private javax.swing.JLabel Detail1;
    private javax.swing.JLabel NameProduct;
    private javax.swing.JLabel NameProduct1;
    private javax.swing.JLabel Price;
    private javax.swing.JLabel Price1;
    private javax.swing.JTable TableOffers1;
    private javax.swing.JTable TableUCUCoins;
    private javax.swing.JTable TableUsers;
    private javax.swing.JLabel Title;
    private javax.swing.JButton btnAccept;
    private javax.swing.JButton btnReject;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
