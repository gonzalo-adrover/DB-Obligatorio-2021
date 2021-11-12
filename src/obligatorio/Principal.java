/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio;

import java.awt.BorderLayout;
import obligatorio.Entities.User;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JPanel;
import static obligatorio.Dashboard.content;
import static obligatorio.Dashboard.user;

/**
 *
 * @author Antonio
 */
public class Principal extends javax.swing.JPanel {

    Connect conn;

    Connection reg;
//    User user;

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        conn = new Connect();
        reg = conn.getConnection();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        body = new javax.swing.JPanel();
        Title = new javax.swing.JLabel();
        Text1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Image = new javax.swing.JLabel();
        input_username = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        input_password = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        btn_login = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btn_register = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(750, 430));
        setPreferredSize(new java.awt.Dimension(750, 430));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        body.setBackground(new java.awt.Color(255, 255, 255));
        body.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(body, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Title.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Title.setText("Bienvenido");
        add(Title, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        Text1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Text1.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras quis ");
        add(Text1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("mattis lorem volutpat. Aenean at sagittis nibh. Praesent aliquet ");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        Image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/obligatorio/images/336799ebb339821f342bc5a13386aff2.jpg"))); // NOI18N
        add(Image, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, -1, -1));

        input_username.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        input_username.setForeground(new java.awt.Color(102, 102, 102));
        input_username.setText("Ingrese nombre de usuario");
        input_username.setBorder(null);
        input_username.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                input_usernameMousePressed(evt);
            }
        });
        input_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_usernameActionPerformed(evt);
            }
        });
        add(input_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 260, 30));

        jSeparator1.setForeground(new java.awt.Color(0, 153, 255));
        jSeparator1.setPreferredSize(new java.awt.Dimension(200, 10));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 260, 10));

        jSeparator2.setForeground(new java.awt.Color(0, 153, 255));
        jSeparator2.setPreferredSize(new java.awt.Dimension(200, 10));
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 260, 10));

        input_password.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        input_password.setForeground(new java.awt.Color(102, 102, 102));
        input_password.setText("Ingrese contraseña");
        input_password.setBorder(null);
        input_password.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                input_passwordMousePressed(evt);
            }
        });
        input_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_passwordActionPerformed(evt);
            }
        });
        add(input_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 260, 30));

        jSeparator3.setForeground(new java.awt.Color(0, 153, 255));
        jSeparator3.setPreferredSize(new java.awt.Dimension(200, 10));
        add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 260, 10));

        btn_login.setBackground(new java.awt.Color(18, 90, 173));
        btn_login.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_loginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_loginMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_loginMousePressed(evt);
            }
        });
        btn_login.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Iniciar sesión");
        jLabel3.setToolTipText("");
        btn_login.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 120, -1));

        add(btn_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 260, 50));

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

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Crear cuenta nueva");
        jLabel2.setToolTipText("");
        btn_register.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 170, -1));

        add(btn_register, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 190, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void input_usernameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_input_usernameMousePressed
        if (input_username.getText().equals("Ingrese nombre de usuario")) {
            input_username.setText("");
        }
        if (input_password.getText().equals("") || input_username.getText() == null || input_username.getText().equals(" "))
            input_password.setText("Ingrese contraseña");
    }//GEN-LAST:event_input_usernameMousePressed

    private void input_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_usernameActionPerformed

    private void input_passwordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_input_passwordMousePressed
        if (input_password.getText().equals("Ingrese contraseña")) {
            input_password.setText("");
        }
        if (input_username.getText().equals("") || input_username.getText() == null || input_username.getText().equals(" "))
        input_username.setText("Ingrese nombre de usuario");    }//GEN-LAST:event_input_passwordMousePressed

    private void input_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_passwordActionPerformed

    private void btn_registerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_registerMouseEntered
        setColorRegister(btn_register);
    }//GEN-LAST:event_btn_registerMouseEntered

    private void btn_registerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_registerMouseExited
        resetColorRegister(btn_register);
    }//GEN-LAST:event_btn_registerMouseExited

    private void btn_registerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_registerMousePressed
        //GOTO register screen
    }//GEN-LAST:event_btn_registerMousePressed

    private void btn_loginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_loginMouseEntered
        setColorLogin(btn_login);
    }//GEN-LAST:event_btn_loginMouseEntered

    private void btn_loginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_loginMouseExited
        resetColorLogin(btn_login);
    }//GEN-LAST:event_btn_loginMouseExited

    private void btn_loginMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_loginMousePressed
        String userS = input_username.getText();
        String password = input_password.getText();

        // Conditions
        if (userS.equals("") || password.equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Debe llenar todos los campos \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            input_username.requestFocus();
        } else {
            try {
                this.loginUser(Integer.parseInt(userS), password, "Usuario");
                if (user == null) {
                    javax.swing.JOptionPane.showMessageDialog(this, "El usuario o contraseña no son validos \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                    input_username.requestFocus();
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "Usuario loggeado! \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                    input_username.requestFocus();
                    MyInfo p1 = new MyInfo();
                    p1.setSize(750, 430);
                    p1.setLocation(0, 0);
                    content.removeAll();
                    content.add(p1, BorderLayout.CENTER);
                    content.revalidate();
                    content.repaint();
                }
            } catch (Exception ex) {
                javax.swing.JOptionPane.showMessageDialog(this, ex, "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                input_username.requestFocus();
            }
        }
    }//GEN-LAST:event_btn_loginMousePressed

    void setColorLogin(JPanel panel) {
        panel.setBackground(new Color(21, 101, 192));
    }

    void resetColorLogin(JPanel panel) {
        panel.setBackground(new Color(18, 90, 173));
    }

    void setColorRegister(JPanel panel) {
        panel.setBackground(new Color(66, 183, 42));
    }

    void resetColorRegister(JPanel panel) {
        panel.setBackground(new Color(51, 145, 32));
    }

    public void loginUser(int id, String password, String table) throws SQLException {
        String list[][] = new String[1][7];

        Statement statement = reg.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String sql = "SELECT * FROM \"" + table + "\" WHERE \"IdUsuario\" = " + id + " AND \"Contraseña\" = '" + password + "';";
        ResultSet re = statement.executeQuery(sql);

        int i = 0;
        while (re.next()) {
            list[i][0] = re.getString("IdUsuario");
            list[i][1] = re.getString("Nombre");
            list[i][2] = re.getString("Apellido");
            list[i][3] = re.getString("Contraseña");
            list[i][4] = re.getString("Telefono");
            list[i][5] = re.getString("Mail");
            list[i][6] = re.getString("IdDireccion");
            i++;
        }

        //validates only one line returned => user credentials are valid
        int size;
        re.last();
        size = re.getRow();
        if (size == 1) {
            user = new User(list[0][0], list[0][1], list[0][2], list[0][3], list[0][4], list[0][5], list[0][6]);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Image;
    private javax.swing.JLabel Text1;
    private javax.swing.JLabel Title;
    private javax.swing.JPanel body;
    private javax.swing.JPanel btn_login;
    private javax.swing.JPanel btn_register;
    private javax.swing.JTextField input_password;
    private javax.swing.JTextField input_username;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
