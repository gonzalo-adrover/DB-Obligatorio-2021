package obligatorio;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import static obligatorio.Dashboard.user;

public class HistoryPanel extends javax.swing.JPanel {
    private Dashboard dashboard;
    private DefaultTableModel tableModel;
    private final String[] barterFields = {"IdTrueque", "IdProducto", "Nombre", "ExtraUCUCoins", "Fecha"};
    private final OfferAdministrator offerAdministrator;
    
    public HistoryPanel(Dashboard dashboard) {
        this.dashboard = dashboard;
        this.offerAdministrator = new OfferAdministrator();
        
        initComponents();
        initTableModel();
        
        this.LoadOffers();
    }
    
    private void initTableModel() {
        this.tableModel = new DefaultTableModel(barterFields, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        this.tbl_Barters.setModel(this.tableModel);
        this.tbl_Barters.removeColumn(this.tbl_Barters.getColumnModel().getColumn(0));
        this.tbl_Barters.removeColumn(this.tbl_Barters.getColumnModel().getColumn(0));
    }
    
    private void LoadOffers(){
        this.tableModel.setRowCount(0);

        try {
            ResultSet resultSet = this.offerAdministrator.ExcecuteSelectAcceptedOffers(user.getId());

            while (resultSet.next()) {
                this.tableModel.addRow(this.offerAdministrator.MapOffer(resultSet, this.barterFields));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HistoryPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Title = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Barters = new javax.swing.JTable();
        btn_productDetails = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        Title.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Title.setText("Historial");

        tbl_Barters.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbl_Barters);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_productDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Title))
                        .addGap(0, 170, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Title)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_productDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_productDetailsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_productDetailsMouseEntered
        this.setColorButton(btn_productDetails);
    }//GEN-LAST:event_btn_productDetailsMouseEntered

    private void btn_productDetailsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_productDetailsMouseExited
        resetColorButton(btn_productDetails);
    }//GEN-LAST:event_btn_productDetailsMouseExited

    void setColorButton(JPanel panel) {
        panel.setBackground(new Color(21, 101, 192));
    }

    void resetColorButton(JPanel panel) {
        panel.setBackground(new Color(18, 90, 173));
    }
    
    private void btn_productDetailsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_productDetailsMousePressed
        int column = 0;
        int row = this.tbl_Barters.getSelectedRow();
        if (row == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Debe seleccionar un trueque\n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        } else {
            String offerId = this.tbl_Barters.getModel().getValueAt(row, column).toString();
            String productId = this.tbl_Barters.getModel().getValueAt(row, 1).toString();
            String UCA = this.tbl_Barters.getModel().getValueAt(row, 3).toString();
            System.out.println(offerId + productId + UCA);
            BarterHistoryDetailPanel detailsPanel = new BarterHistoryDetailPanel(this.dashboard, offerId, productId, UCA);
            this.dashboard.btn_openPanel(detailsPanel);
        }
    }//GEN-LAST:event_btn_productDetailsMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Title;
    private javax.swing.JPanel btn_productDetails;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_Barters;
    // End of variables declaration//GEN-END:variables
}
