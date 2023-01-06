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

    public JButton getBtnCargarFoto() {
        return btnCargarFoto;
    }

    public JButton getBtnVerificarRegistro() {
        return btnVerificarRegistro;
    }
    
    //------------------------------------------------------------------------------------------------------
      
    public String getTxtNombre() {
        return txtNombre.getText();
    }    
     
    public String getTxtSegundoNombre() {
        return txtSegundoNombre.getText();
    }
    
    public String getTxtPrimerApellido() {
        return txtPrimerApellido.getText();
    }
    
    public String getTxtSegundoApellido() {
        return txtSegundoApellido.getText();
    }
    
    public String getSelectedTypeIdentification() {
        String tipoIdentificacion = (String)cmbTipoIdentificacion.getSelectedItem();
        return tipoIdentificacion;
    }

    public JComboBox<String> getCmbTipoIdentificacion() {
        return cmbTipoIdentificacion;
    }

    public int getTxtIdentificacion() {
        String cadena =  txtIdentificacion.getText();
        String combinacion = cadena.substring(0, 1) + cadena.substring(2, 6)+ cadena.substring(7);
        int identification = Integer.parseInt(combinacion);
        return identification;
    }

    public String getTxtUsername() {
        return txtUsername.getText();
    }
    
    public String getTxtPassword() {
        String password = new String(txtPassword.getPassword());
        return password;
    }
 
    public int getTxtTelefono() {
        String cadena =  txtTelefono.getText();
        String combinacion = cadena.substring(0, 4) + cadena.substring(5);
        int phone = Integer.parseInt(combinacion);
        return phone;
    }

    public String getSelectedGender() {
        String genero = (String)cmbGenero.getSelectedItem();
        return genero;
    }

    public JComboBox<String> getCmbGenero() {
        return cmbGenero;
    }
    
    public String getSelectedCountry() {
        String country = (String)cmbPais.getSelectedItem();
        return country;
    }

    public JComboBox<String> getCmbPais() {
        return cmbPais;
    }
 
    public String getSelectedProvince() {
        String province = (String)cmbProvincia.getSelectedItem();
        return province;
    }

    public JComboBox<String> getCmbProvincia() {
        return cmbProvincia;
    }
    
    
    public String getSelectedCanton() {
        String canton = (String)cmbCanton.getSelectedItem();
        return canton;
    }

    public JComboBox<String> getCmbCanton() {
        return cmbCanton;
    }
        
    public String getSelectedDistrict() {
        String distrito = (String)cmbDistrito.getSelectedItem();
        return distrito;
    }

    public JComboBox<String> getCmbDistrito() {
        return cmbDistrito;
    }
    
    public String getTxtCorreo() {
        return txtCorreo.getText();
    }
    
    public String getTxtDireccionExacta() {
        return txtDireccionExacta.getText();
    }
    
    public JLabel getLblAvatar() {
        return lblAvatar;
    }
    
    //------------------------------------------------------------------------------------------------------
    
//CLEAN Functions
    public void cleanAll() {
       cleanPrimerNombre();
       cleanSegundoNombre();
       cleanPrimerApellido();
       cleanSegundoApellido();
       cleanUsername();
       cleanPassword();
       cleanIdentificacion();
       cleanTelefono();
       cleanCorreo();
       cleanDireccion();
    }
    
    public void cleanPrimerNombre() {
        this.txtNombre.setText("");
    }
    
    public void cleanPrimerApellido() {
        this.txtPrimerApellido.setText("");
    }
    
    public void cleanSegundoNombre() {
        this.txtSegundoNombre.setText("");
    }
    
    public void cleanSegundoApellido() {
        this.txtSegundoApellido.setText("");
    }

    private void cleanIdentificacion() {
        this.txtIdentificacion.setText("");
    }
    
    private void cleanTelefono() {
        this.txtTelefono.setText("");
    }

    public void cleanUsername() {
        this.txtUsername.setText("");
    }
    
    public void cleanPassword() {
        this.txtPassword.setText("");
    }
    
    public void cleanCorreo() {
        this.txtCorreo.setText("");
    }

    public void cleanDireccion() {
        this.txtDireccionExacta.setText("");
    }
    
    
    //---------------------------------------------------------------------------------------
    
    //SETTERS    
    public void setCmbCanton(JComboBox<String> cmbCanton) {
        this.cmbCanton = cmbCanton;
    }

    public void setCmbDistrito(JComboBox<String> cmbDistrito) {
        this.cmbDistrito = cmbDistrito;
    }

    public void setCmbGenero(JComboBox<String> cmbGenero) {
        this.cmbGenero = cmbGenero;
    }

    public void setCmbPais(JComboBox<String> cmbPais) {
        this.cmbPais = cmbPais;
    }

    public void setCmbProvincia(JComboBox<String> cmbProvincia) {
        this.cmbProvincia = cmbProvincia;
    }

    public void setCmbTipoIdentificacion(JComboBox<String> cmbTipoIdentificacion) {
        this.cmbTipoIdentificacion = cmbTipoIdentificacion;
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
        lblCrearUsuarioPassword = new javax.swing.JLabel();
        btnVerificarRegistro = new javax.swing.JButton();
        lblSeleccionarFoto = new javax.swing.JLabel();
        btnCargarFoto = new javax.swing.JButton();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lblAvatar = new javax.swing.JLabel();
        lblGenero = new javax.swing.JLabel();
        cmbGenero = new javax.swing.JComboBox<>();
        lblTelefono = new javax.swing.JLabel();
        lblPais = new javax.swing.JLabel();
        cmbPais = new javax.swing.JComboBox<>();
        lblCanton = new javax.swing.JLabel();
        cmbCanton = new javax.swing.JComboBox<>();
        lblPronvicia = new javax.swing.JLabel();
        cmbProvincia = new javax.swing.JComboBox<>();
        lblDistrito = new javax.swing.JLabel();
        cmbDistrito = new javax.swing.JComboBox<>();
        lblDireccionExacta = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblSegundoNombre = new javax.swing.JLabel();
        lblPrimerApellido = new javax.swing.JLabel();
        lblSegundoApellido = new javax.swing.JLabel();
        lblidentificacion = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtSegundoNombre = new javax.swing.JTextField();
        txtPrimerApellido = new javax.swing.JTextField();
        txtSegundoApellido = new javax.swing.JTextField();
        lblTipoIdentificacion = new javax.swing.JLabel();
        cmbTipoIdentificacion = new javax.swing.JComboBox<>();
        txtTelefono = new javax.swing.JFormattedTextField();
        txtIdentificacion = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDireccionExacta = new javax.swing.JTextArea();

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

        lblCrearUsuarioPassword.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        lblCrearUsuarioPassword.setForeground(new java.awt.Color(255, 255, 255));
        lblCrearUsuarioPassword.setText("Crear un nombre de usuario y una contraseña: ");
        pnlBackground.add(lblCrearUsuarioPassword);
        lblCrearUsuarioPassword.setBounds(40, 550, 360, 25);

        btnVerificarRegistro.setBackground(new java.awt.Color(86, 4, 44));
        btnVerificarRegistro.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        btnVerificarRegistro.setForeground(new java.awt.Color(255, 255, 255));
        btnVerificarRegistro.setText("Registrar");
        btnVerificarRegistro.setBorderPainted(false);
        btnVerificarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarRegistroActionPerformed(evt);
            }
        });
        pnlBackground.add(btnVerificarRegistro);
        btnVerificarRegistro.setBounds(1070, 630, 180, 40);

        lblSeleccionarFoto.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        lblSeleccionarFoto.setForeground(new java.awt.Color(255, 255, 255));
        lblSeleccionarFoto.setText("Seleccionar una fotografía");
        pnlBackground.add(lblSeleccionarFoto);
        lblSeleccionarFoto.setBounds(1040, 400, 200, 30);

        btnCargarFoto.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btnCargarFoto.setText("Cargar foto");
        btnCargarFoto.setAlignmentY(0.0F);
        btnCargarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarFotoActionPerformed(evt);
            }
        });
        pnlBackground.add(btnCargarFoto);
        btnCargarFoto.setBounds(1080, 440, 120, 30);

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
        pnlBackground.add(txtCorreo);
        txtCorreo.setBounds(310, 500, 230, 22);

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

        lblGenero.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblGenero.setForeground(new java.awt.Color(255, 255, 255));
        lblGenero.setText("Género*");
        pnlBackground.add(lblGenero);
        lblGenero.setBounds(620, 190, 110, 30);

        cmbGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbGeneroActionPerformed(evt);
            }
        });
        pnlBackground.add(cmbGenero);
        cmbGenero.setBounds(780, 200, 180, 22);

        lblTelefono.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblTelefono.setForeground(new java.awt.Color(255, 255, 255));
        lblTelefono.setText("Teléfono*");
        pnlBackground.add(lblTelefono);
        lblTelefono.setBounds(620, 130, 110, 40);

        lblPais.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblPais.setForeground(new java.awt.Color(255, 255, 255));
        lblPais.setText("País* ");
        pnlBackground.add(lblPais);
        lblPais.setBounds(620, 250, 100, 30);

        cmbPais.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pnlBackground.add(cmbPais);
        cmbPais.setBounds(780, 260, 180, 22);

        lblCanton.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblCanton.setForeground(new java.awt.Color(255, 255, 255));
        lblCanton.setText("Cantón*");
        pnlBackground.add(lblCanton);
        lblCanton.setBounds(620, 370, 110, 30);

        cmbCanton.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pnlBackground.add(cmbCanton);
        cmbCanton.setBounds(780, 380, 180, 22);

        lblPronvicia.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblPronvicia.setForeground(new java.awt.Color(255, 255, 255));
        lblPronvicia.setText("Provincia*");
        pnlBackground.add(lblPronvicia);
        lblPronvicia.setBounds(620, 310, 120, 30);

        cmbProvincia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbProvincia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbProvinciaItemStateChanged(evt);
            }
        });
        pnlBackground.add(cmbProvincia);
        cmbProvincia.setBounds(780, 320, 180, 22);

        lblDistrito.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblDistrito.setForeground(new java.awt.Color(255, 255, 255));
        lblDistrito.setText("Distrito*");
        pnlBackground.add(lblDistrito);
        lblDistrito.setBounds(620, 430, 110, 30);

        cmbDistrito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pnlBackground.add(cmbDistrito);
        cmbDistrito.setBounds(780, 440, 180, 22);

        lblDireccionExacta.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblDireccionExacta.setForeground(new java.awt.Color(255, 255, 255));
        lblDireccionExacta.setText("Dirección exacta*");
        pnlBackground.add(lblDireccionExacta);
        lblDireccionExacta.setBounds(630, 550, 210, 30);

        lblNombre.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("Nombre*");
        pnlBackground.add(lblNombre);
        lblNombre.setBounds(40, 130, 110, 40);

        lblSegundoNombre.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblSegundoNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblSegundoNombre.setText("Segundo nombre");
        pnlBackground.add(lblSegundoNombre);
        lblSegundoNombre.setBounds(40, 190, 185, 32);

        lblPrimerApellido.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblPrimerApellido.setForeground(new java.awt.Color(255, 255, 255));
        lblPrimerApellido.setText("Primer apellido*");
        pnlBackground.add(lblPrimerApellido);
        lblPrimerApellido.setBounds(40, 250, 172, 32);

        lblSegundoApellido.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblSegundoApellido.setForeground(new java.awt.Color(255, 255, 255));
        lblSegundoApellido.setText("Segundo apellido");
        pnlBackground.add(lblSegundoApellido);
        lblSegundoApellido.setBounds(40, 310, 210, 40);

        lblidentificacion.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblidentificacion.setForeground(new java.awt.Color(255, 255, 255));
        lblidentificacion.setText("Identificación *");
        pnlBackground.add(lblidentificacion);
        lblidentificacion.setBounds(40, 430, 190, 40);

        lblCorreo.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblCorreo.setForeground(new java.awt.Color(255, 255, 255));
        lblCorreo.setText("Correo*");
        pnlBackground.add(lblCorreo);
        lblCorreo.setBounds(40, 490, 110, 30);

        txtUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsernameKeyTyped(evt);
            }
        });
        pnlBackground.add(txtUsername);
        txtUsername.setBounds(310, 600, 230, 22);

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        pnlBackground.add(txtNombre);
        txtNombre.setBounds(310, 140, 230, 22);
        pnlBackground.add(txtSegundoNombre);
        txtSegundoNombre.setBounds(310, 200, 230, 22);
        pnlBackground.add(txtPrimerApellido);
        txtPrimerApellido.setBounds(310, 260, 230, 22);
        pnlBackground.add(txtSegundoApellido);
        txtSegundoApellido.setBounds(310, 320, 230, 22);

        lblTipoIdentificacion.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblTipoIdentificacion.setForeground(new java.awt.Color(255, 255, 255));
        lblTipoIdentificacion.setText("Tipo Identificación*");
        pnlBackground.add(lblTipoIdentificacion);
        lblTipoIdentificacion.setBounds(40, 370, 210, 40);

        cmbTipoIdentificacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbTipoIdentificacion.setMinimumSize(new java.awt.Dimension(80, 22));
        cmbTipoIdentificacion.setPreferredSize(new java.awt.Dimension(80, 22));
        cmbTipoIdentificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoIdentificacionActionPerformed(evt);
            }
        });
        pnlBackground.add(cmbTipoIdentificacion);
        cmbTipoIdentificacion.setBounds(310, 380, 230, 22);

        try {
            txtTelefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        pnlBackground.add(txtTelefono);
        txtTelefono.setBounds(780, 140, 180, 22);

        try {
            txtIdentificacion.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#-####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtIdentificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdentificacionActionPerformed(evt);
            }
        });
        pnlBackground.add(txtIdentificacion);
        txtIdentificacion.setBounds(310, 440, 230, 22);

        txtDireccionExacta.setColumns(20);
        txtDireccionExacta.setRows(5);
        jScrollPane1.setViewportView(txtDireccionExacta);

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

    private void btnVerificarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarRegistroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVerificarRegistroActionPerformed

    private void btnCargarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarFotoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCargarFotoActionPerformed

    private void cmbGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbGeneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbGeneroActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

    }//GEN-LAST:event_btnBackActionPerformed

    private void cmbTipoIdentificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoIdentificacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTipoIdentificacionActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtIdentificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdentificacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdentificacionActionPerformed

    private void txtUsernameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsernameKeyTyped
       if(this.getTxtUsername().length() >= 15){
            evt.consume();
       }
    }//GEN-LAST:event_txtUsernameKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        if(this.getTxtNombre().length() >= 20){
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyTyped
        if(this.getTxtPassword().length() >= 16){
            evt.consume();
        }
    }//GEN-LAST:event_txtPasswordKeyTyped

    private void cmbProvinciaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbProvinciaItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbProvinciaItemStateChanged

    
    
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCargarFoto;
    private javax.swing.JButton btnVerificarRegistro;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cmbCanton;
    private javax.swing.JComboBox<String> cmbDistrito;
    private javax.swing.JComboBox<String> cmbGenero;
    private javax.swing.JComboBox<String> cmbPais;
    private javax.swing.JComboBox<String> cmbProvincia;
    private javax.swing.JComboBox<String> cmbTipoIdentificacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAvatar;
    private javax.swing.JLabel lblCanton;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblCrearUsuarioPassword;
    private javax.swing.JLabel lblDireccionExacta;
    private javax.swing.JLabel lblDistrito;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPais;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPrimerApellido;
    private javax.swing.JLabel lblPronvicia;
    private javax.swing.JLabel lblSegundoApellido;
    private javax.swing.JLabel lblSegundoNombre;
    private javax.swing.JLabel lblSeleccionarFoto;
    private javax.swing.JLabel lblSignUp;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTipoIdentificacion;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblidentificacion;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextArea txtDireccionExacta;
    private javax.swing.JFormattedTextField txtIdentificacion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPrimerApellido;
    private javax.swing.JTextField txtSegundoApellido;
    private javax.swing.JTextField txtSegundoNombre;
    private javax.swing.JFormattedTextField txtTelefono;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
