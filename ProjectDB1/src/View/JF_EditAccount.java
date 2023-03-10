/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Objects.Account;
import java.awt.Image;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

/**
 *
 * @author Isaac
 */
public class JF_EditAccount extends javax.swing.JFrame {

    /**
     * Creates new form JF_Stats
     */
    
    public Account information = new Account();
    
    public JF_EditAccount() {
        initComponents();
        this.setLocationRelativeTo(this);
        loadInfoFromAccount();
    }
    
    public void UpdateInfo(Account infoToShow){
        this.information = infoToShow;
        this.loadInfoFromAccount();
        this.repaint();
    }
    
    public void setImageLabel(String photoUrl){
        String imageToShow = "src/Images/avatar.png";
        
        File source = new File(photoUrl);
        
        if(source.exists()){
            imageToShow = photoUrl;
        }
        
        ImageIcon image = new ImageIcon(imageToShow);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(this.lblPicture.getWidth(), this.lblPicture.getHeight(), Image.SCALE_SMOOTH));
        this.lblPicture.setIcon(icon);
    }
    
    public void loadInfoFromAccount(){
        this.lblEditAccountName.setText(this.information.getFirstName());
        this.textFieldUsername.setText(this.information.getUsername());
        this.textFieldPassword.setText(this.information.getPassword());
        this.textFieldName1.setText(this.information.getFirstName());
        
        if("N/A".equals(this.information.getSndName())){
            this.textFieldName2.setText("");
        }else if(!"N/A".equals(this.information.getSndName())){
            this.textFieldName2.setText(this.information.getSndName());
        }

        this.textFieldLastName1.setText(this.information.getFirstLastName());
        
        if("N/A".equals(this.information.getSndLastName())){
            this.textFieldLastName2.setText("");
        }else if(!"N/A".equals(this.information.getSndLastName())){
            this.textFieldLastName2.setText(this.information.getSndLastName());
        }
                
        this.cmbGender.setSelectedItem(this.information.getGender());
        this.textFieldMail.setText(this.information.getEmail());
        Integer ID = this.information.getIdentification();
        this.textFieldIdentification.setText(ID.toString());
        Integer phoneNumber = this.information.getPhoneNumber();
        this.textFieldPhone.setText(phoneNumber.toString());
        this.setImageLabel(this.information.getPhotoUrl());
    }

    public JButton getBtnBack() {
        return btnBack;
    }

    public JButton getBtnConfirm() {
        return btnConfirm;
    }

    public JButton getBtnLoadPicture() {
        return btnLoadPicture;
    }

    public JFormattedTextField getTextFieldIdentification() {
        return textFieldIdentification;
    }

    public JTextField getTextFieldLastName1() {
        return textFieldLastName1;
    }

    public JTextField getTextFieldLastName2() {
        return textFieldLastName2;
    }

    public JTextField getTextFieldMail() {
        return textFieldMail;
    }

    public JTextField getTextFieldName1() {
        return textFieldName1;
    }

    public JTextField getTextFieldName2() {
        return textFieldName2;
    }

    public JTextField getTextFieldPassword() {
        return textFieldPassword;
    }

    public JFormattedTextField getTextFieldPhone() {
        return textFieldPhone;
    }

    public JTextField getTextFieldUsername() {
        return textFieldUsername;
    }

    public JComboBox<String> getCmbGender() {
        return cmbGender;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMyAccount = new javax.swing.JPanel();
        lblLogoMyAccount = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        lblMyAccountName1 = new javax.swing.JLabel();
        lblEditAccountName = new javax.swing.JLabel();
        lblMyAccountName4 = new javax.swing.JLabel();
        lblMyAccountName6 = new javax.swing.JLabel();
        lblMyAccountName10 = new javax.swing.JLabel();
        lblMyAccountName11 = new javax.swing.JLabel();
        lblMyAccountName12 = new javax.swing.JLabel();
        lblMyAccountName16 = new javax.swing.JLabel();
        lblMyAccountName17 = new javax.swing.JLabel();
        btnConfirm = new javax.swing.JButton();
        lblPicture = new javax.swing.JLabel();
        textFieldUsername = new javax.swing.JTextField();
        textFieldPassword = new javax.swing.JTextField();
        textFieldLastName2 = new javax.swing.JTextField();
        textFieldMail = new javax.swing.JTextField();
        textFieldName1 = new javax.swing.JTextField();
        textFieldName2 = new javax.swing.JTextField();
        textFieldLastName1 = new javax.swing.JTextField();
        lblMyAccountName14 = new javax.swing.JLabel();
        lblMyAccountName15 = new javax.swing.JLabel();
        lblMyAccountName18 = new javax.swing.JLabel();
        btnLoadPicture = new javax.swing.JButton();
        textFieldPhone = new javax.swing.JFormattedTextField();
        textFieldIdentification = new javax.swing.JFormattedTextField();
        cmbGender = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1285, 752));

        panelMyAccount.setBackground(new java.awt.Color(86, 4, 44));
        panelMyAccount.setPreferredSize(new java.awt.Dimension(1285, 752));
        panelMyAccount.setLayout(null);

        lblLogoMyAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo.png"))); // NOI18N
        panelMyAccount.add(lblLogoMyAccount);
        lblLogoMyAccount.setBounds(1070, 10, 200, 130);

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/back.png"))); // NOI18N
        btnBack.setBorderPainted(false);
        btnBack.setContentAreaFilled(false);
        btnBack.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/backPressed.png"))); // NOI18N
        panelMyAccount.add(btnBack);
        btnBack.setBounds(70, 80, 46, 40);

        lblMyAccountName1.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 36)); // NOI18N
        lblMyAccountName1.setForeground(new java.awt.Color(255, 255, 255));
        lblMyAccountName1.setText("Bienvenido/a");
        panelMyAccount.add(lblMyAccountName1);
        lblMyAccountName1.setBounds(180, 80, 210, 48);

        lblEditAccountName.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 36)); // NOI18N
        lblEditAccountName.setForeground(new java.awt.Color(255, 255, 255));
        lblEditAccountName.setText("Isaac");
        panelMyAccount.add(lblEditAccountName);
        lblEditAccountName.setBounds(400, 80, 250, 50);

        lblMyAccountName4.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblMyAccountName4.setForeground(new java.awt.Color(255, 255, 255));
        lblMyAccountName4.setText("Usuario:");
        panelMyAccount.add(lblMyAccountName4);
        lblMyAccountName4.setBounds(180, 170, 90, 32);

        lblMyAccountName6.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblMyAccountName6.setForeground(new java.awt.Color(255, 255, 255));
        lblMyAccountName6.setText("Contrase??a:");
        panelMyAccount.add(lblMyAccountName6);
        lblMyAccountName6.setBounds(180, 230, 130, 32);

        lblMyAccountName10.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        lblMyAccountName10.setForeground(new java.awt.Color(255, 255, 255));
        lblMyAccountName10.setText("Segundo Apellido:");
        panelMyAccount.add(lblMyAccountName10);
        lblMyAccountName10.setBounds(650, 290, 160, 30);

        lblMyAccountName11.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblMyAccountName11.setForeground(new java.awt.Color(255, 255, 255));
        lblMyAccountName11.setText("G??nero:");
        panelMyAccount.add(lblMyAccountName11);
        lblMyAccountName11.setBounds(180, 450, 220, 32);

        lblMyAccountName12.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblMyAccountName12.setForeground(new java.awt.Color(255, 255, 255));
        lblMyAccountName12.setText("Identificaci??n:");
        panelMyAccount.add(lblMyAccountName12);
        lblMyAccountName12.setBounds(180, 380, 220, 32);

        lblMyAccountName16.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblMyAccountName16.setForeground(new java.awt.Color(255, 255, 255));
        lblMyAccountName16.setText("Email:");
        panelMyAccount.add(lblMyAccountName16);
        lblMyAccountName16.setBounds(180, 520, 220, 32);

        lblMyAccountName17.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblMyAccountName17.setForeground(new java.awt.Color(255, 255, 255));
        lblMyAccountName17.setText("Tel??fono:");
        panelMyAccount.add(lblMyAccountName17);
        lblMyAccountName17.setBounds(180, 590, 220, 32);

        btnConfirm.setBackground(new java.awt.Color(86, 4, 44));
        btnConfirm.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        btnConfirm.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirm.setText("Confirmar");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });
        panelMyAccount.add(btnConfirm);
        btnConfirm.setBounds(960, 640, 160, 40);

        lblPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/avatar.png"))); // NOI18N
        lblPicture.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        panelMyAccount.add(lblPicture);
        lblPicture.setBounds(950, 250, 170, 230);

        textFieldUsername.setText("Prueba");
        textFieldUsername.setEnabled(false);
        textFieldUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldUsernameActionPerformed(evt);
            }
        });
        panelMyAccount.add(textFieldUsername);
        textFieldUsername.setBounds(520, 180, 280, 30);

        textFieldPassword.setText("Prueba");
        textFieldPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldPasswordActionPerformed(evt);
            }
        });
        panelMyAccount.add(textFieldPassword);
        textFieldPassword.setBounds(520, 240, 280, 30);

        textFieldLastName2.setText("Prueba");
        textFieldLastName2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldLastName2ActionPerformed(evt);
            }
        });
        panelMyAccount.add(textFieldLastName2);
        textFieldLastName2.setBounds(650, 320, 150, 30);

        textFieldMail.setText("Prueba");
        textFieldMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldMailActionPerformed(evt);
            }
        });
        panelMyAccount.add(textFieldMail);
        textFieldMail.setBounds(520, 520, 280, 30);

        textFieldName1.setText("Prueba");
        textFieldName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldName1ActionPerformed(evt);
            }
        });
        panelMyAccount.add(textFieldName1);
        textFieldName1.setBounds(180, 320, 140, 30);

        textFieldName2.setText("Prueba");
        textFieldName2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldName2ActionPerformed(evt);
            }
        });
        panelMyAccount.add(textFieldName2);
        textFieldName2.setBounds(330, 320, 150, 30);

        textFieldLastName1.setText("Prueba");
        textFieldLastName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldLastName1ActionPerformed(evt);
            }
        });
        panelMyAccount.add(textFieldLastName1);
        textFieldLastName1.setBounds(490, 320, 150, 30);

        lblMyAccountName14.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        lblMyAccountName14.setForeground(new java.awt.Color(255, 255, 255));
        lblMyAccountName14.setText("Primer Apellido:");
        panelMyAccount.add(lblMyAccountName14);
        lblMyAccountName14.setBounds(500, 290, 140, 30);

        lblMyAccountName15.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        lblMyAccountName15.setForeground(new java.awt.Color(255, 255, 255));
        lblMyAccountName15.setText("Primer Nombre:");
        panelMyAccount.add(lblMyAccountName15);
        lblMyAccountName15.setBounds(180, 290, 140, 30);

        lblMyAccountName18.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        lblMyAccountName18.setForeground(new java.awt.Color(255, 255, 255));
        lblMyAccountName18.setText("Segundo Nombre:");
        panelMyAccount.add(lblMyAccountName18);
        lblMyAccountName18.setBounds(330, 290, 150, 30);

        btnLoadPicture.setText("Cargar Foto");
        btnLoadPicture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadPictureActionPerformed(evt);
            }
        });
        panelMyAccount.add(btnLoadPicture);
        btnLoadPicture.setBounds(970, 500, 130, 23);

        try {
            textFieldPhone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        textFieldPhone.setText("0000-0000");
        textFieldPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldPhoneActionPerformed(evt);
            }
        });
        panelMyAccount.add(textFieldPhone);
        textFieldPhone.setBounds(520, 600, 280, 30);

        try {
            textFieldIdentification.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#-####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        textFieldIdentification.setText("0-0000-0000");
        textFieldIdentification.setEnabled(false);
        textFieldIdentification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldIdentificationActionPerformed(evt);
            }
        });
        panelMyAccount.add(textFieldIdentification);
        textFieldIdentification.setBounds(520, 380, 280, 30);

        cmbGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        panelMyAccount.add(cmbGender);
        cmbGender.setBounds(520, 452, 280, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMyAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMyAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void textFieldUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldUsernameActionPerformed

    private void textFieldPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldPasswordActionPerformed

    private void textFieldMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldMailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldMailActionPerformed

    private void textFieldLastName2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldLastName2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldLastName2ActionPerformed

    private void textFieldName1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldName1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldName1ActionPerformed

    private void textFieldName2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldName2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldName2ActionPerformed

    private void textFieldLastName1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldLastName1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldLastName1ActionPerformed

    private void btnLoadPictureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadPictureActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLoadPictureActionPerformed

    private void textFieldPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldPhoneActionPerformed

    private void textFieldIdentificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldIdentificationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldIdentificationActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JF_EditAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_EditAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_EditAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_EditAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JF_EditAccount().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnLoadPicture;
    private javax.swing.JComboBox<String> cmbGender;
    private javax.swing.JLabel lblEditAccountName;
    private javax.swing.JLabel lblLogoMyAccount;
    private javax.swing.JLabel lblMyAccountName1;
    private javax.swing.JLabel lblMyAccountName10;
    private javax.swing.JLabel lblMyAccountName11;
    private javax.swing.JLabel lblMyAccountName12;
    private javax.swing.JLabel lblMyAccountName14;
    private javax.swing.JLabel lblMyAccountName15;
    private javax.swing.JLabel lblMyAccountName16;
    private javax.swing.JLabel lblMyAccountName17;
    private javax.swing.JLabel lblMyAccountName18;
    private javax.swing.JLabel lblMyAccountName4;
    private javax.swing.JLabel lblMyAccountName6;
    private javax.swing.JLabel lblPicture;
    private javax.swing.JPanel panelMyAccount;
    private javax.swing.JFormattedTextField textFieldIdentification;
    private javax.swing.JTextField textFieldLastName1;
    private javax.swing.JTextField textFieldLastName2;
    private javax.swing.JTextField textFieldMail;
    private javax.swing.JTextField textFieldName1;
    private javax.swing.JTextField textFieldName2;
    private javax.swing.JTextField textFieldPassword;
    private javax.swing.JFormattedTextField textFieldPhone;
    private javax.swing.JTextField textFieldUsername;
    // End of variables declaration//GEN-END:variables
}
