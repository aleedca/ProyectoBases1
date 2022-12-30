/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Nahomy
 */
public class JF_Register extends javax.swing.JFrame {

    /**
     * Creates new form JF_Register
     */
    public JF_Register() {
        initComponents();
        this.setLocationRelativeTo(this);
        setImageLabel(lblAvatar, "src/Images/avatar.png");
    }
    
    private void setImageLabel(JLabel labelName, String imageDirectory){
        ImageIcon image = new ImageIcon(imageDirectory);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT));
        labelName.setIcon(icon);
        System.out.println("Entré aquí");
        this.repaint();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        pnlBackground = new javax.swing.JPanel();
        lblSignUp = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lblAvatar = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtUsername1 = new javax.swing.JTextField();
        txtUsername2 = new javax.swing.JTextField();
        txtUsername3 = new javax.swing.JTextField();
        txtUsername4 = new javax.swing.JTextField();
        txtUsername5 = new javax.swing.JTextField();
        txtUsername6 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jComboBox7 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1285, 752));
        setResizable(false);

        pnlBackground.setBackground(new java.awt.Color(86, 4, 44));
        pnlBackground.setMaximumSize(new java.awt.Dimension(1280, 720));
        pnlBackground.setMinimumSize(new java.awt.Dimension(1280, 720));
        pnlBackground.setLayout(null);

        lblSignUp.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 36)); // NOI18N
        lblSignUp.setForeground(new java.awt.Color(255, 255, 255));
        lblSignUp.setText("Registro");
        pnlBackground.add(lblSignUp);
        lblSignUp.setBounds(100, 30, 140, 50);

        btnBack.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/back.png"))); // NOI18N
        btnBack.setContentAreaFilled(false);
        btnBack.setOpaque(true);
        btnBack.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/backPressed.png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        pnlBackground.add(btnBack);
        btnBack.setBounds(40, 40, 46, 40);
        pnlBackground.add(jLabel1);
        jLabel1.setBounds(19, 44, 0, 0);

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Crear un nombre de usuario y una contraseña: ");
        pnlBackground.add(jLabel2);
        jLabel2.setBounds(40, 550, 360, 25);

        jButton1.setBackground(new java.awt.Color(86, 4, 44));
        jButton1.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Registrar");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        pnlBackground.add(jButton1);
        jButton1.setBounds(1070, 630, 130, 40);

        jLabel16.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Seleccionar una fotografía");
        pnlBackground.add(jLabel16);
        jLabel16.setBounds(1040, 400, 200, 30);

        jButton2.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jButton2.setText("Cargar foto");
        jButton2.setAlignmentY(0.0F);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        pnlBackground.add(jButton2);
        jButton2.setBounds(1080, 440, 120, 30);

        lblUsername.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername.setText("Username");
        pnlBackground.add(lblUsername);
        lblUsername.setBounds(40, 590, 130, 32);

        lblPassword.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(255, 255, 255));
        lblPassword.setText("Password");
        pnlBackground.add(lblPassword);
        lblPassword.setBounds(40, 640, 120, 30);
        pnlBackground.add(txtUsername);
        txtUsername.setBounds(310, 500, 230, 22);

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });
        pnlBackground.add(jPasswordField1);
        jPasswordField1.setBounds(310, 650, 230, 22);
        pnlBackground.add(jLabel17);
        jLabel17.setBounds(582, 44, 0, 0);
        pnlBackground.add(jLabel19);
        jLabel19.setBounds(19, 44, 0, 0);

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo.png"))); // NOI18N
        pnlBackground.add(jLabel18);
        jLabel18.setBounds(1070, 10, 200, 125);

        lblAvatar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAvatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/avatar.png"))); // NOI18N
        lblAvatar.setAlignmentX(0.5F);
        lblAvatar.setMaximumSize(new java.awt.Dimension(180, 230));
        lblAvatar.setMinimumSize(new java.awt.Dimension(180, 230));
        lblAvatar.setPreferredSize(new java.awt.Dimension(180, 230));
        pnlBackground.add(lblAvatar);
        lblAvatar.setBounds(1050, 160, 180, 230);

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Género");
        pnlBackground.add(jLabel9);
        jLabel9.setBounds(630, 250, 110, 30);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        pnlBackground.add(jComboBox1);
        jComboBox1.setBounds(790, 260, 180, 22);

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Teléfono");
        pnlBackground.add(jLabel10);
        jLabel10.setBounds(630, 190, 100, 40);
        pnlBackground.add(jTextField7);
        jTextField7.setBounds(790, 200, 180, 22);

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("País ");
        pnlBackground.add(jLabel11);
        jLabel11.setBounds(630, 310, 100, 30);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pnlBackground.add(jComboBox2);
        jComboBox2.setBounds(790, 320, 180, 22);

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Cantón");
        pnlBackground.add(jLabel13);
        jLabel13.setBounds(630, 430, 110, 30);

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pnlBackground.add(jComboBox4);
        jComboBox4.setBounds(790, 440, 180, 22);

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Provincia");
        pnlBackground.add(jLabel12);
        jLabel12.setBounds(630, 370, 120, 30);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pnlBackground.add(jComboBox3);
        jComboBox3.setBounds(790, 380, 180, 22);

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Distrito");
        pnlBackground.add(jLabel14);
        jLabel14.setBounds(630, 490, 110, 30);

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pnlBackground.add(jComboBox5);
        jComboBox5.setBounds(790, 500, 180, 22);

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Dirección exacta:");
        pnlBackground.add(jLabel15);
        jLabel15.setBounds(630, 550, 190, 30);
        pnlBackground.add(jTextField8);
        jTextField8.setBounds(630, 590, 350, 80);

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre*");
        pnlBackground.add(jLabel3);
        jLabel3.setBounds(40, 130, 110, 40);

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Segundo nombre");
        pnlBackground.add(jLabel4);
        jLabel4.setBounds(40, 190, 185, 32);

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Primer apellido*");
        pnlBackground.add(jLabel5);
        jLabel5.setBounds(40, 250, 172, 32);

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Segundo apellido");
        pnlBackground.add(jLabel6);
        jLabel6.setBounds(40, 310, 210, 40);

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Identificación *");
        pnlBackground.add(jLabel7);
        jLabel7.setBounds(40, 430, 190, 40);

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Correo*");
        pnlBackground.add(jLabel8);
        jLabel8.setBounds(40, 490, 110, 30);
        pnlBackground.add(txtUsername1);
        txtUsername1.setBounds(310, 600, 230, 22);
        pnlBackground.add(txtUsername2);
        txtUsername2.setBounds(310, 140, 230, 22);
        pnlBackground.add(txtUsername3);
        txtUsername3.setBounds(310, 200, 230, 22);
        pnlBackground.add(txtUsername4);
        txtUsername4.setBounds(310, 260, 230, 22);
        pnlBackground.add(txtUsername5);
        txtUsername5.setBounds(310, 320, 230, 22);
        pnlBackground.add(txtUsername6);
        txtUsername6.setBounds(310, 440, 230, 22);

        jLabel20.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 20)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Tipo Teléfono");
        pnlBackground.add(jLabel20);
        jLabel20.setBounds(630, 140, 130, 30);

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox6ActionPerformed(evt);
            }
        });
        pnlBackground.add(jComboBox6);
        jComboBox6.setBounds(790, 150, 180, 22);

        jLabel21.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Tipo Identificación");
        pnlBackground.add(jLabel21);
        jLabel21.setBounds(40, 370, 210, 40);

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox7.setMinimumSize(new java.awt.Dimension(80, 22));
        jComboBox7.setPreferredSize(new java.awt.Dimension(80, 22));
        jComboBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox7ActionPerformed(evt);
            }
        });
        pnlBackground.add(jComboBox7);
        jComboBox7.setBounds(310, 380, 230, 22);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
       JF_Principal principal = new JF_Principal();
       principal.setVisible(true); 
       
       this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void jComboBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox6ActionPerformed

    private void jComboBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox7ActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JLabel lblAvatar;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblSignUp;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JTextField txtUsername1;
    private javax.swing.JTextField txtUsername2;
    private javax.swing.JTextField txtUsername3;
    private javax.swing.JTextField txtUsername4;
    private javax.swing.JTextField txtUsername5;
    private javax.swing.JTextField txtUsername6;
    // End of variables declaration//GEN-END:variables
}
