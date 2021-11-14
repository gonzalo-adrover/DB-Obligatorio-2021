package obligatorio;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductDetailPanel extends javax.swing.JPanel {
    private Dashboard dashboardFrame;
    private String IdProducto;
    private final ProductAdministrator productAdministrator;
    
    public ProductDetailPanel(Dashboard frame, String idProducto) {
        this.dashboardFrame = frame;
        this.IdProducto = idProducto;
        this.productAdministrator = new ProductAdministrator();

        initComponents();
        this.loadProduct(idProducto);
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
        this.lab_idProducto.setText(this.IdProducto);
        resultSet.next();
        this.lab_nombre.setText(resultSet.getString("Nombre"));
        this.lab_precio.setText(resultSet.getString("Precio"));
        this.lab_descripcionProducto.setText(resultSet.getString("DescripcionProducto"));
        this.lab_nombreCategoria.setText(resultSet.getString("NombreCategoria"));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lab_idProducto = new javax.swing.JLabel();
        lab_nombre = new javax.swing.JLabel();
        lab_precio = new javax.swing.JLabel();
        lab_descripcionProducto = new javax.swing.JLabel();
        lab_nombreCategoria = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jLabel1.setText("IdProducto");

        jLabel2.setText("Nombre");

        jLabel3.setText("Precio");

        jLabel4.setText("DescripcionProducto");

        jLabel6.setText("NombreCategoria");

        lab_idProducto.setText("jLabel7");

        lab_nombre.setText("jLabel8");

        lab_precio.setText("jLabel9");

        lab_descripcionProducto.setText("jLabel10");

        lab_nombreCategoria.setText("jLabel12");

        jButton1.setText("Make Offer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lab_descripcionProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lab_nombreCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lab_precio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lab_nombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lab_idProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(235, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lab_idProducto))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lab_nombre))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lab_precio))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lab_descripcionProducto))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lab_nombreCategoria))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(106, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CreateOfferPanel createOfferPanel = new CreateOfferPanel(this.dashboardFrame, this.IdProducto);
        
        this.dashboardFrame.btn_openPanel(createOfferPanel);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lab_descripcionProducto;
    private javax.swing.JLabel lab_idProducto;
    private javax.swing.JLabel lab_nombre;
    private javax.swing.JLabel lab_nombreCategoria;
    private javax.swing.JLabel lab_precio;
    // End of variables declaration//GEN-END:variables
}
