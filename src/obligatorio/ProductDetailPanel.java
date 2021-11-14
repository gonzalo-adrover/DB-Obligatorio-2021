package obligatorio;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import static obligatorio.Dashboard.content;

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

    private void loadProduct(String idProducto) {
        try {
            ResultSet resultSet = this.productAdministrator.ExecuteFetchProductQuery(idProducto);
            this.showProduct(resultSet);
        } catch (SQLException ex) {
            Logger.getLogger(ProductDetailPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void showProduct(ResultSet resultSet) throws SQLException {
        this.lab_idProducto.setText(this.IdProducto);
        resultSet.next();
        this.lab_nombre.setText(resultSet.getString("Nombre"));
        this.lab_precio.setText(resultSet.getString("Precio"));
        this.lab_descripcionProducto.setText(resultSet.getString("DescripcionProducto"));
        this.lab_nombreCategoria.setText(resultSet.getString("NombreCategoria"));
    }

    void setColorButton(JPanel panel) {
        panel.setBackground(new Color(21, 101, 192));
    }

    void resetColorButton(JPanel panel) {
        panel.setBackground(new Color(18, 90, 173));
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
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        btn_makeOffer = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        btn_makeOffer1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("IdProducto:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 97, 20));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Nombre:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 97, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Precio:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 97, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Descripcion:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Categoria:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 120, 20));

        lab_idProducto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lab_idProducto.setText("jLabel7");
        add(lab_idProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 220, 20));

        lab_nombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lab_nombre.setText("jLabel8");
        add(lab_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 220, -1));

        lab_precio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lab_precio.setText("jLabel9");
        add(lab_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 220, -1));

        lab_descripcionProducto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lab_descripcionProducto.setText("jLabel10");
        add(lab_descripcionProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 220, 20));

        lab_nombreCategoria.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lab_nombreCategoria.setText("jLabel12");
        add(lab_nombreCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, 220, 20));

        jSeparator6.setForeground(new java.awt.Color(0, 153, 255));
        jSeparator6.setPreferredSize(new java.awt.Dimension(200, 10));
        add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 360, 20));

        jSeparator7.setForeground(new java.awt.Color(0, 153, 255));
        jSeparator7.setPreferredSize(new java.awt.Dimension(200, 10));
        add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 360, 10));

        jSeparator8.setForeground(new java.awt.Color(0, 153, 255));
        jSeparator8.setPreferredSize(new java.awt.Dimension(200, 10));
        add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 360, 20));

        jSeparator9.setForeground(new java.awt.Color(0, 153, 255));
        jSeparator9.setPreferredSize(new java.awt.Dimension(200, 10));
        add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 360, 20));

        jSeparator10.setForeground(new java.awt.Color(0, 153, 255));
        jSeparator10.setPreferredSize(new java.awt.Dimension(200, 10));
        add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 360, 20));

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
        btn_makeOffer.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 140, -1));

        add(btn_makeOffer, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 160, 200, 50));

        btn_makeOffer1.setBackground(new java.awt.Color(18, 90, 173));
        btn_makeOffer1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_makeOffer1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_makeOffer1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_makeOffer1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_makeOffer1MousePressed(evt);
            }
        });
        btn_makeOffer1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("<");
        jLabel5.setToolTipText("");
        btn_makeOffer1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 20));

        add(btn_makeOffer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 30, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void btn_makeOfferMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_makeOfferMouseEntered
        setColorButton(btn_makeOffer);
    }//GEN-LAST:event_btn_makeOfferMouseEntered

    private void btn_makeOfferMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_makeOfferMouseExited
        resetColorButton(btn_makeOffer);
    }//GEN-LAST:event_btn_makeOfferMouseExited

    private void btn_makeOfferMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_makeOfferMousePressed
        CreateOfferPanel createOfferPanel = new CreateOfferPanel(this.dashboardFrame, this.IdProducto);

        this.dashboardFrame.btn_openPanel(createOfferPanel);
    }//GEN-LAST:event_btn_makeOfferMousePressed

    private void btn_makeOffer1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_makeOffer1MouseEntered
        setColorButton(btn_makeOffer1);
    }//GEN-LAST:event_btn_makeOffer1MouseEntered

    private void btn_makeOffer1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_makeOffer1MouseExited
        resetColorButton(btn_makeOffer1);
    }//GEN-LAST:event_btn_makeOffer1MouseExited

    private void btn_makeOffer1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_makeOffer1MousePressed
        SearchProductsPanel panel;
        panel = new SearchProductsPanel(dashboardFrame);
        panel.setSize(750, 430);
        panel.setLocation(0, 0);
        content.removeAll();
        content.add(panel, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }//GEN-LAST:event_btn_makeOffer1MousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btn_makeOffer;
    private javax.swing.JPanel btn_makeOffer1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel lab_descripcionProducto;
    private javax.swing.JLabel lab_idProducto;
    private javax.swing.JLabel lab_nombre;
    private javax.swing.JLabel lab_nombreCategoria;
    private javax.swing.JLabel lab_precio;
    // End of variables declaration//GEN-END:variables
}
