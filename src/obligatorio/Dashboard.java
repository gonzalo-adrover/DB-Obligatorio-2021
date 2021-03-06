package obligatorio;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import obligatorio.Entities.User;

public class Dashboard extends javax.swing.JFrame {

    int xMouse;
    int yMouse;
    Connect conn;
    Connection reg;
    public static User user;

    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        initComponents();
        conn = new Connect();
        reg = conn.getConnection();

        Principal p1 = new Principal();
        p1.setSize(750, 430);
        p1.setLocation(0, 0);

        content.removeAll();
        content.add(p1, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
        btn_principal.setEnabled(false);
        btn_searchProduct.setEnabled(false);
        btn_lookOffers.setEnabled(false);
        btn_myProducts.setEnabled(false);
        btn_internalBarter.setEnabled(false);
        btn_comodin.setEnabled(false);
    }

    public void btn_openPanel(JPanel panel) {
        panel.setSize(750, 430);
        panel.setLocation(0, 0);

        content.removeAll();
        content.add(panel, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Background = new javax.swing.JPanel();
        Menu = new javax.swing.JPanel();
        btn_principal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_searchProduct = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btn_lookOffers = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_myProducts = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btn_internalBarter = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btn_comodin = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        app_name = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        Header = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        btn_register = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        Title = new javax.swing.JPanel();
        red_squr = new javax.swing.JPanel();
        exit = new javax.swing.JLabel();
        content = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        Background.setBackground(new java.awt.Color(255, 255, 255));
        Background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Menu.setBackground(new java.awt.Color(13, 71, 161));
        Menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_principal.setBackground(new java.awt.Color(21, 101, 192));
        btn_principal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_principal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_principalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_principalMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_principalMousePressed(evt);
            }
        });
        btn_principal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/obligatorio/images/home-outline.png"))); // NOI18N
        btn_principal.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 30, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Principal");
        btn_principal.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, 30));

        Menu.add(btn_principal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 270, 50));

        btn_searchProduct.setBackground(new java.awt.Color(18, 90, 173));
        btn_searchProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_searchProduct.setPreferredSize(new java.awt.Dimension(270, 51));
        btn_searchProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_searchProductMousePressed(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_searchProductMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_searchProductMouseEntered(evt);
            }
        });
        btn_searchProduct.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/obligatorio/images/calendar-plus.png"))); // NOI18N
        btn_searchProduct.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 30, 30));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Buscar Producto");
        btn_searchProduct.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, 30));

        Menu.add(btn_searchProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, -1, -1));

        btn_lookOffers.setBackground(new java.awt.Color(18, 90, 173));
        btn_lookOffers.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_lookOffers.setPreferredSize(new java.awt.Dimension(270, 51));
        btn_lookOffers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_lookOffersMousePressed(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_lookOffersMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_lookOffersMouseEntered(evt);
            }
        });
        btn_lookOffers.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/obligatorio/images/calendar-multiple-check.png"))); // NOI18N
        btn_lookOffers.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 30, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ver Ofertas");
        btn_lookOffers.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, 30));

        Menu.add(btn_lookOffers, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, -1, -1));

        btn_myProducts.setBackground(new java.awt.Color(18, 90, 173));
        btn_myProducts.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_myProducts.setPreferredSize(new java.awt.Dimension(270, 51));
        btn_myProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_myProductsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_myProductsMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_myProductsMousePressed(evt);
            }
        });
        btn_myProducts.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/obligatorio/images/account-multiple.png"))); // NOI18N
        btn_myProducts.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 30, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Mis Productos");
        btn_myProducts.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, 30));

        Menu.add(btn_myProducts, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, -1, -1));

        btn_internalBarter.setBackground(new java.awt.Color(18, 90, 173));
        btn_internalBarter.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_internalBarter.setPreferredSize(new java.awt.Dimension(270, 51));
        btn_internalBarter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_internalBarterMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_internalBarterMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_internalBarterMousePressed(evt);
            }
        });
        btn_internalBarter.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/obligatorio/images/book-open-page-variant.png"))); // NOI18N
        btn_internalBarter.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 30, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Obtener UCUCoins");
        btn_internalBarter.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, 30));

        Menu.add(btn_internalBarter, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, -1, -1));

        btn_comodin.setBackground(new java.awt.Color(18, 90, 173));
        btn_comodin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_comodin.setPreferredSize(new java.awt.Dimension(270, 51));
        btn_comodin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_comodinMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_comodinMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_comodinMousePressed(evt);
            }
        });
        btn_comodin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/obligatorio/images/file-chart.png"))); // NOI18N
        btn_comodin.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 30, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Historial");
        btn_comodin.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, 30));

        Menu.add(btn_comodin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, -1, -1));

        app_name.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        app_name.setForeground(new java.awt.Color(255, 255, 255));
        app_name.setText("UCUTrade");
        Menu.add(app_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, -1));

        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 5));
        Menu.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 190, 20));

        Background.add(Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 640));

        Header.setBackground(new java.awt.Color(25, 118, 210));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("La manera m??s facil de trocar!");

        title.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("UCUTrade");

        btn_register.setBackground(new java.awt.Color(51, 145, 32));
        btn_register.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_register.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_registerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_registerMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_registerMousePressed(evt);
            }
        });
        btn_register.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Cerrar sesi??n");
        jLabel6.setToolTipText("");
        btn_register.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, -1));

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(title))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 303, Short.MAX_VALUE)
                .addComponent(btn_register, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderLayout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_register, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(HeaderLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33))
        );

        jLabel2.getAccessibleContext().setAccessibleName("La forma m??s facil de trocar!");
        jLabel2.getAccessibleContext().setAccessibleDescription("");

        Background.add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 750, 150));

        Title.setBackground(new java.awt.Color(255, 255, 255));
        Title.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                TitleMouseDragged(evt);
            }
        });
        Title.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TitleMousePressed(evt);
            }
        });

        red_squr.setBackground(new java.awt.Color(255, 255, 255));
        red_squr.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        red_squr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                red_squrMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                red_squrMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                red_squrMousePressed(evt);
            }
        });

        exit.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        exit.setForeground(new java.awt.Color(102, 102, 102));
        exit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exit.setText("X");
        exit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exitMousePressed(evt);
            }
        });

        javax.swing.GroupLayout red_squrLayout = new javax.swing.GroupLayout(red_squr);
        red_squr.setLayout(red_squrLayout);
        red_squrLayout.setHorizontalGroup(
            red_squrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        red_squrLayout.setVerticalGroup(
            red_squrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout TitleLayout = new javax.swing.GroupLayout(Title);
        Title.setLayout(TitleLayout);
        TitleLayout.setHorizontalGroup(
            TitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TitleLayout.createSequentialGroup()
                .addGap(0, 984, Short.MAX_VALUE)
                .addComponent(red_squr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        TitleLayout.setVerticalGroup(
            TitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(red_squr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Background.add(Title, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, -1));

        content.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );

        Background.add(content, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, 750, 460));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    private void TitleMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TitleMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_TitleMouseDragged

    private void TitleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TitleMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_TitleMousePressed

    private void exitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMousePressed
        System.exit(0);
    }//GEN-LAST:event_exitMousePressed

    private void btn_principalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_principalMousePressed
        setColor(btn_principal);
        resetColor(btn_searchProduct);
        resetColor(btn_lookOffers);
        resetColor(btn_myProducts);
        resetColor(btn_internalBarter);
        resetColor(btn_comodin);

        if (user == null) {
            Principal p1 = new Principal();
            p1.setSize(750, 430);
            p1.setLocation(0, 0);
            content.removeAll();
            content.add(p1, BorderLayout.CENTER);
            content.revalidate();
            content.repaint();
        } else {
            try {
                MyInfo p1 = new MyInfo();
                p1.setSize(750, 430);
                p1.setLocation(0, 0);
                content.removeAll();
                content.add(p1, BorderLayout.CENTER);
                content.revalidate();
                content.repaint();
            } catch (SQLException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_principalMousePressed

    private void btn_searchProductMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_searchProductMousePressed
        resetColor(btn_principal);
        setColor(btn_searchProduct);
        resetColor(btn_lookOffers);
        resetColor(btn_myProducts);
        resetColor(btn_internalBarter);
        resetColor(btn_comodin);

        if (user != null) {
            SearchProductsPanel panel = new SearchProductsPanel(this);
            panel.setSize(750, 430);
            panel.setLocation(0, 0);
            content.removeAll();
            content.add(panel, BorderLayout.CENTER);
            content.revalidate();
            content.repaint();
        } else {
            UserNotLogged notLogged = new UserNotLogged();
            notLogged.setSize(750, 430);
            notLogged.setLocation(0, 0);
            content.removeAll();
            content.add(notLogged, BorderLayout.CENTER);
            content.revalidate();
            content.repaint();
        }
    }//GEN-LAST:event_btn_searchProductMousePressed

    private void btn_lookOffersMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_lookOffersMousePressed
        resetColor(btn_principal);
        resetColor(btn_searchProduct);
        setColor(btn_lookOffers);
        resetColor(btn_myProducts);
        resetColor(btn_internalBarter);
        resetColor(btn_comodin);
        //ToDo: Abrir secci??n LookOffers()
        Offers offerPanel = new Offers(this);
        offerPanel.setSize(750, 430);
        offerPanel.setLocation(0,0);
        content.removeAll();
        content.add(offerPanel, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();

    }//GEN-LAST:event_btn_lookOffersMousePressed
   
    private void btn_myProductsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_myProductsMousePressed
        resetColor(btn_principal);
        resetColor(btn_searchProduct);
        resetColor(btn_lookOffers);
        setColor(btn_myProducts);
        resetColor(btn_internalBarter);
        resetColor(btn_comodin);
        MyProducts p1;
        try {
            if (user != null) {
                p1 = new MyProducts();
                p1.setSize(750, 430);
                p1.setLocation(0, 0);

                content.removeAll();
                content.add(p1, BorderLayout.CENTER);
                content.revalidate();
                content.repaint();
            } else {
                UserNotLogged notLogged = new UserNotLogged();
                notLogged.setSize(750, 430);
                notLogged.setLocation(0, 0);
                content.removeAll();
                content.add(notLogged, BorderLayout.CENTER);
                content.revalidate();
                content.repaint();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn_myProductsMousePressed

    private void btn_internalBarterMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_internalBarterMousePressed
        resetColor(btn_principal);
        resetColor(btn_searchProduct);
        resetColor(btn_lookOffers);
        resetColor(btn_myProducts);
        setColor(btn_internalBarter);
        resetColor(btn_comodin);
        InternalBarter p1;
        try {
            p1 = new InternalBarter();
            p1.setSize(750, 430);
            p1.setLocation(0, 0);
            content.removeAll();
            content.add(p1, BorderLayout.CENTER);
            content.revalidate();
            content.repaint();
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_internalBarterMousePressed

    private void btn_comodinMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_comodinMousePressed
        resetColor(btn_principal);
        resetColor(btn_searchProduct);
        resetColor(btn_lookOffers);
        resetColor(btn_myProducts);
        resetColor(btn_internalBarter);
        setColor(btn_comodin);
        if (user != null) {

            HistoryPanel historyPanel = new HistoryPanel(this);
            historyPanel.setSize(750, 430);
            historyPanel.setLocation(0, 0);

            content.removeAll();
            content.add(historyPanel, BorderLayout.CENTER);
            content.revalidate();
            content.repaint();
        } else {
            UserNotLogged notLogged = new UserNotLogged();
            notLogged.setSize(750, 430);
            notLogged.setLocation(0, 0);
            content.removeAll();
            content.add(notLogged, BorderLayout.CENTER);
            content.revalidate();
            content.repaint();
        }
    }//GEN-LAST:event_btn_comodinMousePressed

    private void red_squrMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_red_squrMousePressed
        System.exit(0);
    }//GEN-LAST:event_red_squrMousePressed

    private void btn_searchProductMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_searchProductMouseEntered
        if (btn_searchProduct.getBackground().getRGB() == -15574355)
            setColor(btn_searchProduct);
    }//GEN-LAST:event_btn_searchProductMouseEntered

    private void btn_searchProductMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_searchProductMouseExited
        if (btn_principal.getBackground().getRGB() != -15574355 || btn_lookOffers.getBackground().getRGB() != -15574355
                || btn_myProducts.getBackground().getRGB() != -15574355 || btn_internalBarter.getBackground().getRGB() != -15574355 || btn_comodin.getBackground().getRGB() != -15574355)
            resetColor(btn_searchProduct);
    }//GEN-LAST:event_btn_searchProductMouseExited

    private void btn_principalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_principalMouseEntered
        if (btn_principal.getBackground().getRGB() == -15574355)
            setColor(btn_principal);
    }//GEN-LAST:event_btn_principalMouseEntered

    private void btn_principalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_principalMouseExited
        if (btn_searchProduct.getBackground().getRGB() != -15574355 || btn_lookOffers.getBackground().getRGB() != -15574355
                || btn_myProducts.getBackground().getRGB() != -15574355 || btn_internalBarter.getBackground().getRGB() != -15574355 || btn_comodin.getBackground().getRGB() != -15574355)
            resetColor(btn_principal);
    }//GEN-LAST:event_btn_principalMouseExited

    private void btn_lookOffersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_lookOffersMouseEntered
        if (btn_lookOffers.getBackground().getRGB() == -15574355)
            setColor(btn_lookOffers);
    }//GEN-LAST:event_btn_lookOffersMouseEntered

    private void btn_lookOffersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_lookOffersMouseExited
        if (btn_searchProduct.getBackground().getRGB() != -15574355 || btn_principal.getBackground().getRGB() != -15574355
                || btn_myProducts.getBackground().getRGB() != -15574355 || btn_internalBarter.getBackground().getRGB() != -15574355 || btn_comodin.getBackground().getRGB() != -15574355)
            resetColor(btn_lookOffers);
    }//GEN-LAST:event_btn_lookOffersMouseExited

    private void btn_myProductsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_myProductsMouseEntered
        if (btn_myProducts.getBackground().getRGB() == -15574355)
            setColor(btn_myProducts);
    }//GEN-LAST:event_btn_myProductsMouseEntered

    private void btn_myProductsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_myProductsMouseExited
        if (btn_searchProduct.getBackground().getRGB() != -15574355 || btn_principal.getBackground().getRGB() != -15574355
                || btn_lookOffers.getBackground().getRGB() != -15574355 || btn_internalBarter.getBackground().getRGB() != -15574355 || btn_comodin.getBackground().getRGB() != -15574355)
            resetColor(btn_myProducts);
    }//GEN-LAST:event_btn_myProductsMouseExited

    private void btn_internalBarterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_internalBarterMouseEntered
        if (btn_internalBarter.getBackground().getRGB() == -15574355)
            setColor(btn_internalBarter);
    }//GEN-LAST:event_btn_internalBarterMouseEntered

    private void btn_internalBarterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_internalBarterMouseExited
        if (btn_searchProduct.getBackground().getRGB() != -15574355 || btn_principal.getBackground().getRGB() != -15574355
                || btn_lookOffers.getBackground().getRGB() != -15574355 || btn_myProducts.getBackground().getRGB() != -15574355 || btn_comodin.getBackground().getRGB() != -15574355)
            resetColor(btn_internalBarter);
    }//GEN-LAST:event_btn_internalBarterMouseExited

    private void btn_comodinMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_comodinMouseEntered
        if (btn_comodin.getBackground().getRGB() == -15574355)
            setColor(btn_comodin);
    }//GEN-LAST:event_btn_comodinMouseEntered

    private void btn_comodinMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_comodinMouseExited
        if (btn_searchProduct.getBackground().getRGB() != -15574355 || btn_principal.getBackground().getRGB() != -15574355
                || btn_lookOffers.getBackground().getRGB() != -15574355 || btn_myProducts.getBackground().getRGB() != -15574355 || btn_internalBarter.getBackground().getRGB() != -15574355)
            resetColor(btn_comodin);
    }//GEN-LAST:event_btn_comodinMouseExited

    private void red_squrMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_red_squrMouseEntered
        red_squr.setBackground(new Color(204, 0, 0));
        exit.setForeground(Color.white);
    }//GEN-LAST:event_red_squrMouseEntered

    private void red_squrMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_red_squrMouseExited
        red_squr.setBackground(new Color(255, 255, 255));
        exit.setForeground(new Color(102, 102, 102));
    }//GEN-LAST:event_red_squrMouseExited

    private void exitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseEntered
        red_squr.setBackground(new Color(204, 0, 0));
        exit.setForeground(Color.white);
    }//GEN-LAST:event_exitMouseEntered

    private void exitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseExited
        red_squr.setBackground(new Color(255, 255, 255));
        exit.setForeground(new Color(102, 102, 102));
    }//GEN-LAST:event_exitMouseExited

    private void btn_registerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_registerMouseEntered
    }//GEN-LAST:event_btn_registerMouseEntered

    private void btn_registerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_registerMouseExited
    }//GEN-LAST:event_btn_registerMouseExited

    private void btn_registerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_registerMousePressed
        this.user = null;
        Principal p1 = new Principal();
        p1.setSize(750, 430);
        p1.setLocation(0, 0);
        content.removeAll();
        content.add(p1, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }//GEN-LAST:event_btn_registerMousePressed

    void setColor(JPanel panel) {
        panel.setBackground(new Color(21, 101, 192));
    }

    void resetColor(JPanel panel) {
        panel.setBackground(new Color(18, 90, 173));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JPanel Header;
    private javax.swing.JPanel Menu;
    private javax.swing.JPanel Title;
    private javax.swing.JLabel app_name;
    private javax.swing.JPanel btn_comodin;
    private javax.swing.JPanel btn_internalBarter;
    private javax.swing.JPanel btn_lookOffers;
    private javax.swing.JPanel btn_myProducts;
    private javax.swing.JPanel btn_principal;
    private javax.swing.JPanel btn_register;
    private javax.swing.JPanel btn_searchProduct;
    public static javax.swing.JPanel content;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel red_squr;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
