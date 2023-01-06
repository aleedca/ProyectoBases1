/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import javax.swing.JButton;
import javax.swing.JComboBox;
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
        
    }
    
    //GETTERS
    public JButton getBtnBack() {
        return btnBack;
    }

    public JButton getBtnCheckRegister() {
        return btnCheckRegister;
    }

    public JButton getBtnUploadPhoto() {
        return btnUploadPhoto;
    }
        
    //------------------------------------------------------------------------------------------------------
      
    public String getTxtName() {
        return txtName.getText();
    }    
     
    public String getTxtSecondName() {
        return txtSecondName.getText();
    }
    
    public String getTxtFirstLastName() {
        return txtFirstLastName.getText();
    }
    
    public String getTxtSecondLastName() {
        return txtSecondLastName.getText();
    }
    
    public String getSelectedTypeIdentification() {
        String typeIdentification = (String)cmbTypeIdentification.getSelectedItem();
        return typeIdentification;
    }

    public JComboBox<String> getCmbTypeIdentification() {
        return cmbTypeIdentification;
    }

    public int getTxtIdentification() {
        String chain=  txtIdentification.getText();
        String combination = chain.substring(0, 1) + chain.substring(2, 6)+ chain.substring(7);
        int identification = Integer.parseInt(combination);
        return identification;
    }

    public String getTxtUsername() {
        return txtUsername.getText();
    }
    
    public String getTxtPassword() {
        String password = new String(txtPassword.getPassword());
        return password;
    }
 
    public int getTxtPhone() {
        String chain =  txtPhone.getText();
        String combination = chain.substring(0, 4) + chain.substring(5);
        int phone = Integer.parseInt(combination);
        return phone;
    }

    public String getSelectedGender() {
        String gender = (String)cmbGender.getSelectedItem();
        return gender;
    }

    public JComboBox<String> getCmbGender() {
        return cmbGender;
    }
    
    public String getSelectedCountry() {
        String country = (String)cmbCountry.getSelectedItem();
        return country;
    }

    public JComboBox<String> getCmbCountry() {
        return cmbCountry;
    }
 
    public String getSelectedProvince() {
        String province = (String)cmbProvince.getSelectedItem();
        return province;
    }

    public JComboBox<String> getCmbProvince() {
        return cmbProvince;
    }
    
    
    public String getSelectedCanton() {
        String canton = (String)cmbCanton.getSelectedItem();
        return canton;
    }

    public JComboBox<String> getCmbCanton() {
        return cmbCanton;
    }
        
    public String getSelectedDistrict() {
        String district = (String)cmbDistrict.getSelectedItem();
        return district;
    }

    public JComboBox<String> getCmbDistrict() {
        return cmbDistrict;
    }
    
    public String getTxtMail() {
        return txtMail.getText();
    }
    
    public String getTxtAddress() {
        return txtAddress.getText();
    }
    
    public JLabel getLblAvatar() {
        return lblAvatar;
    }
    
    //------------------------------------------------------------------------------------------------------
    
//CLEAN Functions
    public void cleanAll() {
       cleanFirstName();
       cleanSecondName();
       cleanFirstLastName();
       cleanSecondLastName();
       cleanUsername();
       cleanPassword();
       cleanIdentification();
       cleanPhone();
       cleanMail();
       cleanAddress();
    }
    
    public void cleanFirstName() {
        this.txtName.setText("");
    }
    
    public void cleanFirstLastName() {
        this.txtFirstLastName.setText("");
    }
    
    public void cleanSecondName() {
        this.txtSecondName.setText("");
    }
    
    public void cleanSecondLastName() {
        this.txtSecondLastName.setText("");
    }

    private void cleanIdentification() {
        this.txtIdentification.setText("");
    }
    
    private void cleanPhone() {
        this.txtPhone.setText("");
    }

    public void cleanUsername() {
        this.txtUsername.setText("");
    }
    
    public void cleanPassword() {
        this.txtPassword.setText("");
    }
    
    public void cleanMail() {
        this.txtMail.setText("");
    }

    public void cleanAddress() {
        this.txtAddress.setText("");
    }
    
    
    //---------------------------------------------------------------------------------------
    
    //SETTERS    
    public void setCmbCanton(JComboBox<String> cmbCanton) {
        this.cmbCanton = cmbCanton;
    }

    public void setCmbDistrict(JComboBox<String> cmbDistrict) {
        this.cmbDistrict = cmbDistrict;
    }

    public void setCmbGender(JComboBox<String> cmbGender) {
        this.cmbGender = cmbGender;
    }

    public void setCmbCountry(JComboBox<String> cmbCountry) {
        this.cmbCountry = cmbCountry;
    }

    public void setCmbProvince(JComboBox<String> cmbProvince) {
        this.cmbProvince = cmbProvince;
    }

    public void setCmbTypeIdentification(JComboBox<String> cmbTypeIdentification) {
        this.cmbTypeIdentification = cmbTypeIdentification;
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
        lblCreateUsernamePassword = new javax.swing.JLabel();
        btnCheckRegister = new javax.swing.JButton();
        lblSelectPhoto = new javax.swing.JLabel();
        btnUploadPhoto = new javax.swing.JButton();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtMail = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lblAvatar = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        cmbGender = new javax.swing.JComboBox<>();
        lblPhone = new javax.swing.JLabel();
        lblCountry = new javax.swing.JLabel();
        cmbCountry = new javax.swing.JComboBox<>();
        lblCanton = new javax.swing.JLabel();
        cmbCanton = new javax.swing.JComboBox<>();
        lblProvince = new javax.swing.JLabel();
        cmbProvince = new javax.swing.JComboBox<>();
        lblDistrict = new javax.swing.JLabel();
        cmbDistrict = new javax.swing.JComboBox<>();
        lblAddress = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblSecondName = new javax.swing.JLabel();
        lblFirstLastName = new javax.swing.JLabel();
        lblSecondLastName = new javax.swing.JLabel();
        lblidentification = new javax.swing.JLabel();
        lblMail = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtSecondName = new javax.swing.JTextField();
        txtFirstLastName = new javax.swing.JTextField();
        txtSecondLastName = new javax.swing.JTextField();
        lblTypeIdentification = new javax.swing.JLabel();
        cmbTypeIdentification = new javax.swing.JComboBox<>();
        txtPhone = new javax.swing.JFormattedTextField();
        txtIdentification = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();

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

        lblCreateUsernamePassword.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        lblCreateUsernamePassword.setForeground(new java.awt.Color(255, 255, 255));
        lblCreateUsernamePassword.setText("Crear un nombre de usuario y una contraseña: ");
        pnlBackground.add(lblCreateUsernamePassword);
        lblCreateUsernamePassword.setBounds(40, 550, 360, 25);

        btnCheckRegister.setBackground(new java.awt.Color(86, 4, 44));
        btnCheckRegister.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        btnCheckRegister.setForeground(new java.awt.Color(255, 255, 255));
        btnCheckRegister.setText("Registrar");
        btnCheckRegister.setBorderPainted(false);
        btnCheckRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckRegisterActionPerformed(evt);
            }
        });
        pnlBackground.add(btnCheckRegister);
        btnCheckRegister.setBounds(1070, 630, 180, 40);

        lblSelectPhoto.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        lblSelectPhoto.setForeground(new java.awt.Color(255, 255, 255));
        lblSelectPhoto.setText("Seleccionar una fotografía");
        pnlBackground.add(lblSelectPhoto);
        lblSelectPhoto.setBounds(1040, 400, 200, 30);

        btnUploadPhoto.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btnUploadPhoto.setText("Cargar foto");
        btnUploadPhoto.setAlignmentY(0.0F);
        btnUploadPhoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadPhotoActionPerformed(evt);
            }
        });
        pnlBackground.add(btnUploadPhoto);
        btnUploadPhoto.setBounds(1080, 440, 120, 30);

        lblUsername.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername.setText("Username*");
        pnlBackground.add(lblUsername);
        lblUsername.setBounds(40, 590, 130, 32);

        lblPassword.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(255, 255, 255));
        lblPassword.setText("Password*");
        pnlBackground.add(lblPassword);
        lblPassword.setBounds(40, 640, 120, 30);
        pnlBackground.add(txtMail);
        txtMail.setBounds(310, 500, 230, 22);

        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPasswordKeyTyped(evt);
            }
        });
        pnlBackground.add(txtPassword);
        txtPassword.setBounds(310, 650, 230, 22);
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

        lblGender.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblGender.setForeground(new java.awt.Color(255, 255, 255));
        lblGender.setText("Género*");
        pnlBackground.add(lblGender);
        lblGender.setBounds(620, 190, 110, 30);

        cmbGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbGenderActionPerformed(evt);
            }
        });
        pnlBackground.add(cmbGender);
        cmbGender.setBounds(780, 200, 180, 22);

        lblPhone.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblPhone.setForeground(new java.awt.Color(255, 255, 255));
        lblPhone.setText("Teléfono*");
        pnlBackground.add(lblPhone);
        lblPhone.setBounds(620, 130, 110, 40);

        lblCountry.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblCountry.setForeground(new java.awt.Color(255, 255, 255));
        lblCountry.setText("País* ");
        pnlBackground.add(lblCountry);
        lblCountry.setBounds(620, 250, 100, 30);

        cmbCountry.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCountryActionPerformed(evt);
            }
        });
        pnlBackground.add(cmbCountry);
        cmbCountry.setBounds(780, 260, 180, 22);

        lblCanton.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblCanton.setForeground(new java.awt.Color(255, 255, 255));
        lblCanton.setText("Cantón*");
        pnlBackground.add(lblCanton);
        lblCanton.setBounds(620, 370, 110, 30);

        cmbCanton.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pnlBackground.add(cmbCanton);
        cmbCanton.setBounds(780, 380, 180, 22);

        lblProvince.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblProvince.setForeground(new java.awt.Color(255, 255, 255));
        lblProvince.setText("Provincia*");
        pnlBackground.add(lblProvince);
        lblProvince.setBounds(620, 310, 120, 30);

        cmbProvince.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbProvince.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbProvinceItemStateChanged(evt);
            }
        });
        pnlBackground.add(cmbProvince);
        cmbProvince.setBounds(780, 320, 180, 22);

        lblDistrict.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblDistrict.setForeground(new java.awt.Color(255, 255, 255));
        lblDistrict.setText("Distrito*");
        pnlBackground.add(lblDistrict);
        lblDistrict.setBounds(620, 430, 110, 30);

        cmbDistrict.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pnlBackground.add(cmbDistrict);
        cmbDistrict.setBounds(780, 440, 180, 22);

        lblAddress.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblAddress.setForeground(new java.awt.Color(255, 255, 255));
        lblAddress.setText("Dirección exacta*");
        pnlBackground.add(lblAddress);
        lblAddress.setBounds(630, 550, 210, 30);

        lblName.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblName.setForeground(new java.awt.Color(255, 255, 255));
        lblName.setText("Nombre*");
        pnlBackground.add(lblName);
        lblName.setBounds(40, 130, 110, 40);

        lblSecondName.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblSecondName.setForeground(new java.awt.Color(255, 255, 255));
        lblSecondName.setText("Segundo nombre");
        pnlBackground.add(lblSecondName);
        lblSecondName.setBounds(40, 190, 185, 32);

        lblFirstLastName.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblFirstLastName.setForeground(new java.awt.Color(255, 255, 255));
        lblFirstLastName.setText("Primer apellido*");
        pnlBackground.add(lblFirstLastName);
        lblFirstLastName.setBounds(40, 250, 172, 32);

        lblSecondLastName.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblSecondLastName.setForeground(new java.awt.Color(255, 255, 255));
        lblSecondLastName.setText("Segundo apellido");
        pnlBackground.add(lblSecondLastName);
        lblSecondLastName.setBounds(40, 310, 210, 40);

        lblidentification.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblidentification.setForeground(new java.awt.Color(255, 255, 255));
        lblidentification.setText("Identificación *");
        pnlBackground.add(lblidentification);
        lblidentification.setBounds(40, 430, 190, 40);

        lblMail.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblMail.setForeground(new java.awt.Color(255, 255, 255));
        lblMail.setText("Correo*");
        pnlBackground.add(lblMail);
        lblMail.setBounds(40, 490, 110, 30);

        txtUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsernameKeyTyped(evt);
            }
        });
        pnlBackground.add(txtUsername);
        txtUsername.setBounds(310, 600, 230, 22);

        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNameKeyTyped(evt);
            }
        });
        pnlBackground.add(txtName);
        txtName.setBounds(310, 140, 230, 22);
        pnlBackground.add(txtSecondName);
        txtSecondName.setBounds(310, 200, 230, 22);
        pnlBackground.add(txtFirstLastName);
        txtFirstLastName.setBounds(310, 260, 230, 22);
        pnlBackground.add(txtSecondLastName);
        txtSecondLastName.setBounds(310, 320, 230, 22);

        lblTypeIdentification.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblTypeIdentification.setForeground(new java.awt.Color(255, 255, 255));
        lblTypeIdentification.setText("Tipo Identificación*");
        pnlBackground.add(lblTypeIdentification);
        lblTypeIdentification.setBounds(40, 370, 210, 40);

        cmbTypeIdentification.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbTypeIdentification.setMinimumSize(new java.awt.Dimension(80, 22));
        cmbTypeIdentification.setPreferredSize(new java.awt.Dimension(80, 22));
        cmbTypeIdentification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTypeIdentificationActionPerformed(evt);
            }
        });
        pnlBackground.add(cmbTypeIdentification);
        cmbTypeIdentification.setBounds(310, 380, 230, 22);

        try {
            txtPhone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneActionPerformed(evt);
            }
        });
        pnlBackground.add(txtPhone);
        txtPhone.setBounds(780, 140, 180, 22);

        try {
            txtIdentification.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#-####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtIdentification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdentificationActionPerformed(evt);
            }
        });
        pnlBackground.add(txtIdentification);
        txtIdentification.setBounds(310, 440, 230, 22);

        txtAddress.setColumns(20);
        txtAddress.setRows(5);
        jScrollPane1.setViewportView(txtAddress);

        pnlBackground.add(jScrollPane1);
        jScrollPane1.setBounds(630, 590, 340, 86);

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

    private void btnCheckRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckRegisterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCheckRegisterActionPerformed

    private void btnUploadPhotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadPhotoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUploadPhotoActionPerformed

    private void cmbGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbGenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbGenderActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

    }//GEN-LAST:event_btnBackActionPerformed

    private void cmbTypeIdentificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTypeIdentificationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTypeIdentificationActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void txtPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneActionPerformed

    private void txtIdentificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdentificationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdentificationActionPerformed

    private void txtUsernameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsernameKeyTyped
       if(this.getTxtUsername().length() >= 15){
            evt.consume();
       }
    }//GEN-LAST:event_txtUsernameKeyTyped

    private void txtNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyTyped
        if(this.getTxtName().length() >= 20){
            evt.consume();
        }
    }//GEN-LAST:event_txtNameKeyTyped

    private void txtPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyTyped
        if(this.getTxtPassword().length() >= 16){
            evt.consume();
        }
    }//GEN-LAST:event_txtPasswordKeyTyped

    private void cmbProvinceItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbProvinceItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbProvinceItemStateChanged

    private void cmbCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCountryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCountryActionPerformed

    
    
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCheckRegister;
    private javax.swing.JButton btnUploadPhoto;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cmbCanton;
    private javax.swing.JComboBox<String> cmbCountry;
    private javax.swing.JComboBox<String> cmbDistrict;
    private javax.swing.JComboBox<String> cmbGender;
    private javax.swing.JComboBox<String> cmbProvince;
    private javax.swing.JComboBox<String> cmbTypeIdentification;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblAvatar;
    private javax.swing.JLabel lblCanton;
    private javax.swing.JLabel lblCountry;
    private javax.swing.JLabel lblCreateUsernamePassword;
    private javax.swing.JLabel lblDistrict;
    private javax.swing.JLabel lblFirstLastName;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblMail;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblProvince;
    private javax.swing.JLabel lblSecondLastName;
    private javax.swing.JLabel lblSecondName;
    private javax.swing.JLabel lblSelectPhoto;
    private javax.swing.JLabel lblSignUp;
    private javax.swing.JLabel lblTypeIdentification;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblidentification;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextField txtFirstLastName;
    private javax.swing.JFormattedTextField txtIdentification;
    private javax.swing.JTextField txtMail;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JFormattedTextField txtPhone;
    private javax.swing.JTextField txtSecondLastName;
    private javax.swing.JTextField txtSecondName;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
