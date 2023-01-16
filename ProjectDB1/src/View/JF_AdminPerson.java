/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Alexia
 */
public class JF_AdminPerson extends javax.swing.JFrame {

    /**
     * Creates new form JF_AdminNews
     */
    public JF_AdminPerson() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupAdmiPersonas = new javax.swing.ButtonGroup();
        pnlAdminPersonas = new javax.swing.JPanel();
        lblAdmiPersonas = new javax.swing.JLabel();
        btnBackAdminPerson = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();
        cmbPersona = new javax.swing.JComboBox<>();
        lblPersona = new javax.swing.JLabel();
        rbtnEdit = new javax.swing.JRadioButton();
        rbtnAdd = new javax.swing.JRadioButton();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtSegNombre = new javax.swing.JTextField();
        lblSegNombre = new javax.swing.JLabel();
        lblPrimerAp = new javax.swing.JLabel();
        txtPrimerAp = new javax.swing.JTextField();
        lblSegAp = new javax.swing.JLabel();
        txtSegAp = new javax.swing.JTextField();
        lblTipoIden = new javax.swing.JLabel();
        cmbEquipo = new javax.swing.JComboBox<>();
        lblIden = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        lblTipoPosicion = new javax.swing.JLabel();
        lblGenero = new javax.swing.JLabel();
        cmbGenero = new javax.swing.JComboBox<>();
        lblPais = new javax.swing.JLabel();
        cmbPais = new javax.swing.JComboBox<>();
        lblProvin = new javax.swing.JLabel();
        cmbProvin = new javax.swing.JComboBox<>();
        lblCanton = new javax.swing.JLabel();
        cmbCanton = new javax.swing.JComboBox<>();
        lblFechaNac = new javax.swing.JLabel();
        cmbDistrito = new javax.swing.JComboBox<>();
        lblNumCamisa = new javax.swing.JLabel();
        lblAvatar = new javax.swing.JLabel();
        lblSelecFoto = new javax.swing.JLabel();
        btnLoadPhoto = new javax.swing.JButton();
        btnAccept = new javax.swing.JButton();
        lblDistrito = new javax.swing.JLabel();
        cmbTipoIden = new javax.swing.JComboBox<>();
        lblEquipo = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        spnNumCamisa = new javax.swing.JSpinner();
        lblDireccion = new javax.swing.JLabel();
        txtIden = new javax.swing.JFormattedTextField();
        txtTelef = new javax.swing.JFormattedTextField();
        txtDireccion = new javax.swing.JTextArea();
        cmbTipoPosicion = new javax.swing.JComboBox<>();
        lblTelef = new javax.swing.JLabel();
        txtDateOfBirth = new javax.swing.JFormattedTextField();
        lblCreateUsernamePassword = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 720));

        pnlAdminPersonas.setBackground(new java.awt.Color(86, 4, 44));
        pnlAdminPersonas.setMaximumSize(new java.awt.Dimension(1280, 720));
        pnlAdminPersonas.setMinimumSize(new java.awt.Dimension(1280, 720));
        pnlAdminPersonas.setPreferredSize(new java.awt.Dimension(1280, 720));
        pnlAdminPersonas.setLayout(null);

        lblAdmiPersonas.setFont(new java.awt.Font("Yu Gothic UI", 1, 36)); // NOI18N
        lblAdmiPersonas.setForeground(new java.awt.Color(255, 255, 255));
        lblAdmiPersonas.setText("Administrar Personas");
        pnlAdminPersonas.add(lblAdmiPersonas);
        lblAdmiPersonas.setBounds(100, 30, 521, 48);

        btnBackAdminPerson.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btnBackAdminPerson.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/back.png"))); // NOI18N
        btnBackAdminPerson.setContentAreaFilled(false);
        btnBackAdminPerson.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/backPressed.png"))); // NOI18N
        btnBackAdminPerson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackAdminPersonActionPerformed(evt);
            }
        });
        pnlAdminPersonas.add(btnBackAdminPerson);
        btnBackAdminPerson.setBounds(40, 40, 46, 40);

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo.png"))); // NOI18N
        pnlAdminPersonas.add(lblLogo);
        lblLogo.setBounds(1070, 10, 200, 125);

        cmbPersona.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        cmbPersona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Iteam1" }));
        cmbPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPersonaActionPerformed(evt);
            }
        });
        pnlAdminPersonas.add(cmbPersona);
        cmbPersona.setBounds(230, 110, 346, 31);

        lblPersona.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        lblPersona.setForeground(new java.awt.Color(255, 255, 255));
        lblPersona.setText("Tipo persona:");
        pnlAdminPersonas.add(lblPersona);
        lblPersona.setBounds(60, 110, 165, 32);

        rbtnEdit.setBackground(new java.awt.Color(86, 4, 44));
        btnGroupAdmiPersonas.add(rbtnEdit);
        rbtnEdit.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        rbtnEdit.setForeground(new java.awt.Color(255, 255, 255));
        rbtnEdit.setText("Editar");
        rbtnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnEditActionPerformed(evt);
            }
        });
        pnlAdminPersonas.add(rbtnEdit);
        rbtnEdit.setBounds(790, 100, 100, 37);

        rbtnAdd.setBackground(new java.awt.Color(86, 4, 44));
        btnGroupAdmiPersonas.add(rbtnAdd);
        rbtnAdd.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        rbtnAdd.setForeground(new java.awt.Color(255, 255, 255));
        rbtnAdd.setText("Agregar");
        rbtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnAddActionPerformed(evt);
            }
        });
        pnlAdminPersonas.add(rbtnAdd);
        rbtnAdd.setBounds(630, 100, 150, 37);
        rbtnAdd.setSelected(true);

        lblNombre.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("Nombre*");
        pnlAdminPersonas.add(lblNombre);
        lblNombre.setBounds(60, 170, 110, 40);

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        pnlAdminPersonas.add(txtNombre);
        txtNombre.setBounds(290, 180, 230, 22);
        pnlAdminPersonas.add(txtSegNombre);
        txtSegNombre.setBounds(290, 240, 230, 22);

        lblSegNombre.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblSegNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblSegNombre.setText("Segundo nombre");
        pnlAdminPersonas.add(lblSegNombre);
        lblSegNombre.setBounds(60, 230, 210, 32);

        lblPrimerAp.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblPrimerAp.setForeground(new java.awt.Color(255, 255, 255));
        lblPrimerAp.setText("Primer apellido*");
        pnlAdminPersonas.add(lblPrimerAp);
        lblPrimerAp.setBounds(60, 290, 172, 32);

        txtPrimerAp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrimerApActionPerformed(evt);
            }
        });
        pnlAdminPersonas.add(txtPrimerAp);
        txtPrimerAp.setBounds(290, 300, 230, 22);

        lblSegAp.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblSegAp.setForeground(new java.awt.Color(255, 255, 255));
        lblSegAp.setText("Segundo apellido");
        pnlAdminPersonas.add(lblSegAp);
        lblSegAp.setBounds(60, 350, 210, 40);
        pnlAdminPersonas.add(txtSegAp);
        txtSegAp.setBounds(290, 360, 230, 22);

        lblTipoIden.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblTipoIden.setForeground(new java.awt.Color(255, 255, 255));
        lblTipoIden.setText("Tipo Identificación*");
        pnlAdminPersonas.add(lblTipoIden);
        lblTipoIden.setBounds(60, 410, 210, 40);

        cmbEquipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbEquipo.setMinimumSize(new java.awt.Dimension(80, 22));
        cmbEquipo.setPreferredSize(new java.awt.Dimension(80, 22));
        cmbEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEquipoActionPerformed(evt);
            }
        });
        pnlAdminPersonas.add(cmbEquipo);
        cmbEquipo.setBounds(290, 600, 230, 22);

        lblIden.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblIden.setForeground(new java.awt.Color(255, 255, 255));
        lblIden.setText("Identificación *");
        pnlAdminPersonas.add(lblIden);
        lblIden.setBounds(60, 470, 190, 40);

        lblCorreo.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblCorreo.setForeground(new java.awt.Color(255, 255, 255));
        lblCorreo.setText("Correo*");
        pnlAdminPersonas.add(lblCorreo);
        lblCorreo.setBounds(60, 530, 110, 30);

        lblTipoPosicion.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblTipoPosicion.setForeground(new java.awt.Color(255, 255, 255));
        lblTipoPosicion.setText("Tipo Posición*");
        pnlAdminPersonas.add(lblTipoPosicion);
        lblTipoPosicion.setBounds(590, 170, 170, 40);

        lblGenero.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblGenero.setForeground(new java.awt.Color(255, 255, 255));
        lblGenero.setText("Género*");
        pnlAdminPersonas.add(lblGenero);
        lblGenero.setBounds(590, 290, 110, 30);

        cmbGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbGeneroActionPerformed(evt);
            }
        });
        pnlAdminPersonas.add(cmbGenero);
        cmbGenero.setBounds(770, 300, 180, 22);

        lblPais.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblPais.setForeground(new java.awt.Color(255, 255, 255));
        lblPais.setText("País* ");
        pnlAdminPersonas.add(lblPais);
        lblPais.setBounds(590, 350, 100, 30);

        cmbPais.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pnlAdminPersonas.add(cmbPais);
        cmbPais.setBounds(770, 360, 180, 22);

        lblProvin.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblProvin.setForeground(new java.awt.Color(255, 255, 255));
        lblProvin.setText("Provincia*");
        pnlAdminPersonas.add(lblProvin);
        lblProvin.setBounds(590, 410, 120, 30);

        cmbProvin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pnlAdminPersonas.add(cmbProvin);
        cmbProvin.setBounds(770, 420, 180, 22);

        lblCanton.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblCanton.setForeground(new java.awt.Color(255, 255, 255));
        lblCanton.setText("Cantón*");
        pnlAdminPersonas.add(lblCanton);
        lblCanton.setBounds(590, 470, 110, 30);

        cmbCanton.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pnlAdminPersonas.add(cmbCanton);
        cmbCanton.setBounds(770, 480, 180, 22);

        lblFechaNac.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblFechaNac.setForeground(new java.awt.Color(255, 255, 255));
        lblFechaNac.setText("Fecha Nacimiento*");
        pnlAdminPersonas.add(lblFechaNac);
        lblFechaNac.setBounds(60, 650, 250, 30);

        cmbDistrito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pnlAdminPersonas.add(cmbDistrito);
        cmbDistrito.setBounds(770, 540, 180, 22);

        lblNumCamisa.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblNumCamisa.setForeground(new java.awt.Color(255, 255, 255));
        lblNumCamisa.setText("Num Camisa*");
        pnlAdminPersonas.add(lblNumCamisa);
        lblNumCamisa.setBounds(1000, 180, 150, 40);

        lblAvatar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAvatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/avatar.png"))); // NOI18N
        lblAvatar.setAlignmentX(0.5F);
        lblAvatar.setMaximumSize(new java.awt.Dimension(180, 230));
        lblAvatar.setMinimumSize(new java.awt.Dimension(180, 230));
        lblAvatar.setPreferredSize(new java.awt.Dimension(180, 230));
        pnlAdminPersonas.add(lblAvatar);
        lblAvatar.setBounds(1050, 250, 180, 230);

        lblSelecFoto.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        lblSelecFoto.setForeground(new java.awt.Color(255, 255, 255));
        lblSelecFoto.setText("Seleccionar una fotografía");
        pnlAdminPersonas.add(lblSelecFoto);
        lblSelecFoto.setBounds(1040, 490, 200, 30);

        btnLoadPhoto.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btnLoadPhoto.setText("Cargar foto");
        btnLoadPhoto.setAlignmentY(0.0F);
        btnLoadPhoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadPhotoActionPerformed(evt);
            }
        });
        pnlAdminPersonas.add(btnLoadPhoto);
        btnLoadPhoto.setBounds(1080, 530, 120, 30);

        btnAccept.setBackground(new java.awt.Color(86, 4, 44));
        btnAccept.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        btnAccept.setForeground(new java.awt.Color(255, 255, 255));
        btnAccept.setText("Aceptar");
        btnAccept.setBorderPainted(false);
        btnAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptActionPerformed(evt);
            }
        });
        pnlAdminPersonas.add(btnAccept);
        btnAccept.setBounds(1070, 650, 130, 40);

        lblDistrito.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblDistrito.setForeground(new java.awt.Color(255, 255, 255));
        lblDistrito.setText("Distrito*");
        pnlAdminPersonas.add(lblDistrito);
        lblDistrito.setBounds(590, 530, 110, 30);

        cmbTipoIden.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbTipoIden.setMinimumSize(new java.awt.Dimension(80, 22));
        cmbTipoIden.setPreferredSize(new java.awt.Dimension(80, 22));
        cmbTipoIden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoIdenActionPerformed(evt);
            }
        });
        pnlAdminPersonas.add(cmbTipoIden);
        cmbTipoIden.setBounds(290, 420, 230, 22);

        lblEquipo.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblEquipo.setForeground(new java.awt.Color(255, 255, 255));
        lblEquipo.setText("Equipo*");
        pnlAdminPersonas.add(lblEquipo);
        lblEquipo.setBounds(60, 590, 110, 30);
        pnlAdminPersonas.add(txtCorreo);
        txtCorreo.setBounds(290, 540, 230, 22);

        spnNumCamisa.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        spnNumCamisa.setModel(new javax.swing.SpinnerNumberModel(1, 1, 999, 1));
        pnlAdminPersonas.add(spnNumCamisa);
        spnNumCamisa.setBounds(1160, 180, 90, 40);

        lblDireccion.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblDireccion.setForeground(new java.awt.Color(255, 255, 255));
        lblDireccion.setText("Dirección exacta*:");
        pnlAdminPersonas.add(lblDireccion);
        lblDireccion.setBounds(590, 580, 230, 40);

        try {
            txtIden.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#-####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        pnlAdminPersonas.add(txtIden);
        txtIden.setBounds(290, 480, 230, 22);

        try {
            txtTelef.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        pnlAdminPersonas.add(txtTelef);
        txtTelef.setBounds(770, 240, 180, 22);

        txtDireccion.setColumns(20);
        txtDireccion.setLineWrap(true);
        txtDireccion.setRows(4);
        txtDireccion.setPreferredSize(new java.awt.Dimension(232, 100));
        pnlAdminPersonas.add(txtDireccion);
        txtDireccion.setBounds(590, 620, 360, 80);

        cmbTipoPosicion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbTipoPosicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoPosicionActionPerformed(evt);
            }
        });
        pnlAdminPersonas.add(cmbTipoPosicion);
        cmbTipoPosicion.setBounds(770, 180, 180, 22);

        lblTelef.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblTelef.setForeground(new java.awt.Color(255, 255, 255));
        lblTelef.setText("Teléfono*");
        pnlAdminPersonas.add(lblTelef);
        lblTelef.setBounds(590, 230, 120, 40);

        try {
            txtDateOfBirth.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        pnlAdminPersonas.add(txtDateOfBirth);
        txtDateOfBirth.setBounds(290, 660, 230, 22);

        lblCreateUsernamePassword.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        lblCreateUsernamePassword.setForeground(new java.awt.Color(255, 255, 255));
        lblCreateUsernamePassword.setText("Crear un nombre de usuario y una contraseña: ");
        pnlAdminPersonas.add(lblCreateUsernamePassword);
        lblCreateUsernamePassword.setBounds(60, 580, 360, 25);

        lblUsername.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername.setText("Username*");
        pnlAdminPersonas.add(lblUsername);
        lblUsername.setBounds(60, 620, 130, 32);

        txtUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsernameKeyTyped(evt);
            }
        });
        pnlAdminPersonas.add(txtUsername);
        txtUsername.setBounds(290, 630, 230, 22);

        lblPassword.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(255, 255, 255));
        lblPassword.setText("Password*");
        pnlAdminPersonas.add(lblPassword);
        lblPassword.setBounds(590, 180, 120, 30);

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
        pnlAdminPersonas.add(txtPassword);
        txtPassword.setBounds(770, 180, 180, 22);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlAdminPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 1296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAdminPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   public boolean validarTextField(JTextField text){
       return text.getText().equals("");
   }
   
   
   public void showPlayerOptions(boolean flag){
       lblNombre.setVisible(flag);
       txtNombre.setVisible(flag);
       lblSegNombre.setVisible(flag);
       txtSegNombre.setVisible(flag);
       lblPrimerAp.setVisible(flag);
       txtPrimerAp.setVisible(flag);
       lblSegAp.setVisible(flag);
       txtSegAp.setVisible(flag);
       lblTipoIden.setVisible(flag);
       cmbTipoIden.setVisible(flag);
       lblIden.setVisible(flag);
       txtIden.setVisible(flag);
       lblCorreo.setVisible(flag);
       txtCorreo.setVisible(flag);
       
       lblEquipo.setVisible(flag);
       cmbEquipo.setVisible(flag);
       lblFechaNac.setVisible(flag);
       this.txtDateOfBirth.setVisible(flag);
       lblNumCamisa.setVisible(flag);
       spnNumCamisa.setVisible(flag);
       
       lblTipoPosicion.setVisible(flag);
       cmbTipoPosicion.setVisible(flag);
       lblTelef.setVisible(flag);
       txtTelef.setVisible(flag);
       lblGenero.setVisible(flag);
       cmbGenero.setVisible(flag);
       lblPais.setVisible(flag);
       cmbPais.setVisible(flag);
       lblProvin.setVisible(flag);
       cmbProvin.setVisible(flag);
       lblCanton.setVisible(flag);
       cmbCanton.setVisible(flag);
       lblDistrito.setVisible(flag);
       cmbDistrito.setVisible(flag);
       lblDireccion.setVisible(flag);
       txtDireccion.setVisible(flag);
       
       lblAvatar.setVisible(flag);
       lblSelecFoto.setVisible(flag);
       btnLoadPhoto.setVisible(flag);
   }
   
    public void disablePlayerOptions(boolean flag){
       lblFechaNac.setVisible(flag);
       this.txtDateOfBirth.setVisible(flag);
       lblNumCamisa.setVisible(flag);
       spnNumCamisa.setVisible(flag);
   }
   
   
   public void showTechnicalStaffOptions(boolean flag){
       lblNombre.setVisible(flag);
       txtNombre.setVisible(flag);
       lblSegNombre.setVisible(flag);
       txtSegNombre.setVisible(flag);
       lblPrimerAp.setVisible(flag);
       txtPrimerAp.setVisible(flag);
       lblSegAp.setVisible(flag);
       txtSegAp.setVisible(flag);
       lblTipoIden.setVisible(flag);
       cmbTipoIden.setVisible(flag);
       lblIden.setVisible(flag);
       txtIden.setVisible(flag);
       lblCorreo.setVisible(flag);
       txtCorreo.setVisible(flag);
       
       lblEquipo.setVisible(flag);
       cmbEquipo.setVisible(flag);
       
       lblTipoPosicion.setVisible(flag);
       cmbTipoPosicion.setVisible(flag);
       lblTelef.setVisible(flag);
       txtTelef.setVisible(flag);
       lblGenero.setVisible(flag);
       cmbGenero.setVisible(flag);
       lblPais.setVisible(flag);
       cmbPais.setVisible(flag);
       lblProvin.setVisible(flag);
       cmbProvin.setVisible(flag);
       lblCanton.setVisible(flag);
       cmbCanton.setVisible(flag);
       lblDistrito.setVisible(flag);
       cmbDistrito.setVisible(flag);
       lblDireccion.setVisible(flag);
       txtDireccion.setVisible(flag);
       
       lblAvatar.setVisible(flag);
       lblSelecFoto.setVisible(flag);
       btnLoadPhoto.setVisible(flag);
   }
   
   
   public void disableTechnicalStaffOptions(boolean flag){
       lblEquipo.setVisible(flag);
       cmbEquipo.setVisible(flag);
       lblTipoPosicion.setVisible(flag);
       cmbTipoPosicion.setVisible(flag);
   }

   
   
    public void showManagerOptions(boolean flag){
       lblNombre.setVisible(flag);
       txtNombre.setVisible(flag);
       lblSegNombre.setVisible(flag);
       txtSegNombre.setVisible(flag);
       lblPrimerAp.setVisible(flag);
       txtPrimerAp.setVisible(flag);
       lblSegAp.setVisible(flag);
       txtSegAp.setVisible(flag);
       lblTipoIden.setVisible(flag);
       cmbTipoIden.setVisible(flag);
       lblIden.setVisible(flag);
       txtIden.setVisible(flag);
       lblCorreo.setVisible(flag);
       txtCorreo.setVisible(flag);
       
       this.lblCreateUsernamePassword.setVisible(flag);
       this.lblPassword.setVisible(flag);
       this.lblUsername.setVisible(flag);
       this.txtPassword.setVisible(flag);
       this.txtUsername.setVisible(flag);

       lblTelef.setVisible(flag);
       txtTelef.setVisible(flag);
       lblGenero.setVisible(flag);
       cmbGenero.setVisible(flag);
       lblPais.setVisible(flag);
       cmbPais.setVisible(flag);
       lblProvin.setVisible(flag);
       cmbProvin.setVisible(flag);
       lblCanton.setVisible(flag);
       cmbCanton.setVisible(flag);
       lblDistrito.setVisible(flag);
       cmbDistrito.setVisible(flag);
       lblDireccion.setVisible(flag);
       txtDireccion.setVisible(flag);
       
       lblAvatar.setVisible(flag);
       lblSelecFoto.setVisible(flag);
       btnLoadPhoto.setVisible(flag);
   }
   
    
   public void disableManagerOptions(boolean flag){
       this.lblCreateUsernamePassword.setVisible(flag);
       this.lblPassword.setVisible(flag);
       this.lblUsername.setVisible(flag);
       this.txtPassword.setVisible(flag);
       this.txtUsername.setVisible(flag);
   }
    
   
   
   //GETTERS AND SETTERS
   
   //---- GETTERS BUTTONS -------------------

    public JButton getBtnAccept() {
        return btnAccept;
    }

    public JButton getBtnBackAdminPerson() {
        return btnBackAdminPerson;
    }

    public JButton getBtnLoadPhoto() {
        return btnLoadPhoto;
    }

    public JRadioButton getRbtnAdd() {
        return rbtnAdd;
    }

    public JRadioButton getRbtnEdit() {
        return rbtnEdit;
    }

    public void setRbtnAddSelected() {
        this.rbtnAdd.setSelected(true);
    }

    public void setRbtnEditSelected() {
        this.rbtnEdit.setSelected(false);
    }
    
    

    //----- VALIDATIONS --------------------------
    public boolean validateTxtIdentification(){
        String chain=  txtIden.getText();
        if(" -    -    ".equals(chain)){
            return true;
        }
            
        return false;
    }
    
    public boolean validateTxtPhone(){
        String chain =  txtTelef.getText();
        if("    -    ".equals(chain)){
            //System.out.println("retorna vacio");
            return true;
        }
            
        return false;
    }
        
    public boolean validateTxtDateOfBirth(){
        if("  -  -    ".equals(txtDateOfBirth.getText())){
            return true;
        }
        
        return false;
    }
    
    //----- GETTER COMBO BOX AND LBL_AVATAR --------------------------
       
    public JLabel getLblAvatar() {
        return lblAvatar;
    }

    public String getTxtLblPersona() {
        return lblPersona.getText();
    }


    



    public String getTxtCmbPerson() {
        String typePerson = (String)cmbPersona.getSelectedItem();
        return typePerson;
    }
    
    public JComboBox<String> getCmbPerson() {
        return cmbPersona;
    }
    
    public String getSelectedPerson() {
        String person = (String)cmbPersona.getSelectedItem();
        return person;
    }
    
    public JComboBox<String> getCmbGender() {
        return cmbGenero;
    }
    
    public JComboBox<String> getCmbCountry() {
        return cmbPais;
    }
    
    public String getSelectedCountry() {
        String country = (String)cmbPais.getSelectedItem();
        return country;
    }

    public JComboBox<String> getCmbProvince() {
        return cmbProvin;
    }
    
    public String getSelectedProvince() {
        String province = (String)cmbProvin.getSelectedItem();
        return province;
    }
    
    public JComboBox<String> getCmbCanton() {
        return cmbCanton;
    }
    
    public String getSelectedCanton() {
        String canton = (String)cmbCanton.getSelectedItem();
        return canton;
    }
    
    public JComboBox<String> getCmbDistrict() {
        return cmbDistrito;
    }
    
    public String getSelectedDistrict() {
        String district = (String)cmbDistrito.getSelectedItem();
        return district;
    }

   //-------------GETTER TEXT --------------------------
    public String getTxtName() {
        return txtNombre.getText();
    }
    
    public String getTxtSecondName() {
        return txtSegNombre.getText();
    }
    
    public String getTxtFirstLastName() {
        return txtPrimerAp.getText();
    }
    
    public String getTxtSecondLastName() {
        return txtSegAp.getText();
    }
    
    public String getTxtMail() {
        return txtCorreo.getText();
    }
    
    public String getTxtAddress() {
        return txtDireccion.getText();
    }
    
    public int getTxtIdentification() {
        String chain = txtIden.getText();
        if(" -    -    ".equals(chain)){
            return 0;
        }else{
            String combination = chain.substring(0, 1) + chain.substring(2, 6)+ chain.substring(7);
            int identification = Integer.parseInt(combination);
            return identification;
        }
    }
    
    public int getTxtPhone() {
        String chain =  txtTelef.getText();
        if("    -    ".equals(chain)){
            return 0;
        }else{
            String combination = chain.substring(0, 4) + chain.substring(5);
            int phone = Integer.parseInt(combination);
            return phone;
        }
    }
    
    public String getTxtDateOfBirth() {
        if("  -  -    ".equals(txtDateOfBirth.getText())){
            return "N/A";      
        }else{
            return txtDateOfBirth.getText();
        }
    }
    
    
    public int getSpnNumTShirt() {
        String numberStr = spnNumCamisa.getValue().toString();
        int number = Integer.parseInt(numberStr);
        return number;
    }
    
    public String getSelectedTypeIdentification() {
        String typeIdentification = (String)cmbTipoIden.getSelectedItem();
        return typeIdentification;
    }
    
    public String getSelectedGender() {
        String gender = (String)cmbGenero.getSelectedItem();
        return gender;
    }
    
    public String getSelectedPosition() {
        String typePosition = (String)cmbTipoPosicion.getSelectedItem();
        return typePosition;
    }
    
    public JComboBox<String> getCmbTeam() {
        return cmbEquipo;
    }
    
    
    public String getSelectedTeam() {
        String team = (String)cmbEquipo.getSelectedItem();
        return team;
    }
    
    //-------------------- SETTERS TEXT ---------------------------------------

    public void setTxtName(String txtNombre) {
        this.txtNombre.setText(txtNombre);
    }
    
    public void setTxtSecondName(String txtSegNombre) {
        this.txtSegNombre.setText(txtSegNombre);
    }
    
    public void setTxtFirstLastName(String txtPrimerAp) {
        this.txtPrimerAp.setText(txtPrimerAp);
    }
    
    public void setTxtSecondLastName(String txtSegAp) {
        this.txtSegAp.setText(txtSegAp);
    }
    
    
    public void setTxtIdentification(int identification) {
        String numString = String.valueOf(identification);
        String combination = numString.substring(0, 1)+"-"+numString.substring(1, 5)+"-"+numString.substring(5);
        this.txtIden.setText(combination);
    }

    public void setSpnNumCamisa(int spnNumCamisa) {
        this.spnNumCamisa.setValue(spnNumCamisa);
    }
    
    public void setTxtMail(String mail) {
        txtCorreo.setText(mail);
    }
    
    public void setTxtAddress(String address) {
        txtDireccion.setText(address);
    }
    
    public void setTxtPhone(int phoneNumber) {
        String numString = String.valueOf(phoneNumber);
        String combination = numString.substring(0, 4)+"-"+numString.substring(4);
        this.txtTelef.setText(combination);
    }
    
    public void setTxtBirthDate(String birthdate) {
        String combination = birthdate.substring(8, 10)+"-"+birthdate.substring(5, 7)+"-"+birthdate.substring(0,4);
        this.txtDateOfBirth.setText(combination);
    }
    
    public void setTxtLblPerson(String lblPersona) {
        this.lblPersona.setText(lblPersona);
    }
    
    
    public void setTypeIdentification(String type) {
        cmbTipoIden.setSelectedItem(type);
    }
    
    
    public void setTeam(String team) {
        cmbEquipo.setSelectedItem(team);
    }

    public void setCountry(String pais) {
        this.cmbPais.setSelectedItem(pais);
    }

    public void setProvince(String cmbProvin) {
        this.cmbProvin.setSelectedItem(cmbProvin);
    }

    public void setCmbCanton(String cmbCanton) {
        this.cmbCanton.setSelectedItem(cmbCanton);
    }

    public void setCmbDistrict(String cmbDistrito) {
        this.cmbDistrito.setSelectedItem(cmbDistrito);
    }

    public void setGender(String cmbGenero) {
        this.cmbGenero.setSelectedItem(cmbGenero);
    }

    public void setPosition(String cmbTipoPosicion) {
        this.cmbTipoPosicion.setSelectedItem(cmbTipoPosicion);
    }
    
    public void setCmbPersona(String cmbPersona) {
        this.cmbPersona.setSelectedItem(cmbPersona);
    }
    
    
    
    
    
    
    
    
    

        
    //------------------------------------------------------------------------------------------------
    

    public JComboBox<String> getCmbTypeIdentification() {
        return cmbTipoIden;
    }

    public JComboBox<String> getCmbTypePosition() {
        return cmbTipoPosicion;
    }

    public String getTxtPassword() {
        String password = new String(txtPassword.getPassword());
        return password;
    }

    public String getTxtUsername() {
        return txtUsername.getText();
    }


    
    



    //------ CLEAN --------------
    public void cleanAll() {
       cleanFirstName();
       cleanSecondName();
       cleanFirstLastName();
       cleanSecondLastName();
       cleanIdentification();
       cleanBirthDate();
       cleanPhone();
       cleanMail();
       cleanAddress();
    }
    
    public void cleanFirstName() {
        this.txtNombre.setText("");
    }
    
    public void cleanFirstLastName() {
        this.txtPrimerAp.setText("");
    }
    
    public void cleanSecondName() {
        this.txtSegNombre.setText("");
    }
    
    public void cleanSecondLastName() {
        this.txtSegAp.setText("");
    }

    private void cleanIdentification() {
        this.txtIden.setText("");
    }
    
    private void cleanPhone() {
        this.txtTelef.setText("");
    }
    
    private void cleanBirthDate() {
        this.txtDateOfBirth.setText("");
    }

    public void cleanMail() {
        this.txtCorreo.setText("");
    }

    public void cleanAddress() {
        this.txtDireccion.setText("");
    }
    
    public void cleanPhoto(){
        ImageIcon image = new ImageIcon();
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(this.lblAvatar.getWidth(), this.lblAvatar.getHeight(), Image.SCALE_SMOOTH));
        this.lblAvatar.setIcon(icon);
    }
    
   
   
   
    private void btnBackAdminPersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackAdminPersonActionPerformed

    }//GEN-LAST:event_btnBackAdminPersonActionPerformed

    private void rbtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnAddActionPerformed
        //esconderMostrarTodo(true);
        lblPersona.setText("Tipo Persona:");
        
//        String tipoPersona = cmbPersona.getSelectedItem().toString();
//        if("Cuerpo Técnico".equals(tipoPersona)){
//           deshabilitarOpciones(false);
//        }
    }//GEN-LAST:event_rbtnAddActionPerformed

    private void rbtnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnEditActionPerformed
//        esconderMostrarTodo(true);
//        lblPersona.setText("Persona:");
//        
//        String tipoPersona = cmbPersona.getSelectedItem().toString();
//        if("Cuerpo Técnico".equals(tipoPersona)){
//           deshabilitarOpciones(false);
//        }
    }//GEN-LAST:event_rbtnEditActionPerformed

    private void cmbEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEquipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEquipoActionPerformed

    private void cmbGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbGeneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbGeneroActionPerformed

    private void btnLoadPhotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadPhotoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLoadPhotoActionPerformed

    private void btnAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptActionPerformed
        
    }//GEN-LAST:event_btnAcceptActionPerformed

    private void cmbTipoIdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoIdenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTipoIdenActionPerformed

    private void txtPrimerApActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrimerApActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrimerApActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void cmbPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPersonaActionPerformed
//       String tipoPersona = cmbPersona.getSelectedItem().toString();
//        
//       if((rbtnAdd.isSelected() || rbtnEdit.isSelected()) && "Cuerpo Técnico".equals(tipoPersona)){
//           deshabilitarOpciones(false);
//       }
//       if((rbtnAdd.isSelected() || rbtnEdit.isSelected()) && "Jugador".equals(tipoPersona)){
//           deshabilitarOpciones(true);
//       }
    }//GEN-LAST:event_cmbPersonaActionPerformed

    private void cmbTipoPosicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoPosicionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTipoPosicionActionPerformed

    private void txtUsernameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsernameKeyTyped
        if(this.getTxtUsername().length() >= 15){
            evt.consume();
        }
    }//GEN-LAST:event_txtUsernameKeyTyped

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void txtPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyTyped
        if(this.getTxtPassword().length() >= 16){
            evt.consume();
        }
    }//GEN-LAST:event_txtPasswordKeyTyped
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccept;
    private javax.swing.JButton btnBackAdminPerson;
    private javax.swing.ButtonGroup btnGroupAdmiPersonas;
    private javax.swing.JButton btnLoadPhoto;
    private javax.swing.JComboBox<String> cmbCanton;
    private javax.swing.JComboBox<String> cmbDistrito;
    private javax.swing.JComboBox<String> cmbEquipo;
    private javax.swing.JComboBox<String> cmbGenero;
    private javax.swing.JComboBox<String> cmbPais;
    private javax.swing.JComboBox<String> cmbPersona;
    private javax.swing.JComboBox<String> cmbProvin;
    private javax.swing.JComboBox<String> cmbTipoIden;
    private javax.swing.JComboBox<String> cmbTipoPosicion;
    private javax.swing.JLabel lblAdmiPersonas;
    private javax.swing.JLabel lblAvatar;
    private javax.swing.JLabel lblCanton;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblCreateUsernamePassword;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblDistrito;
    private javax.swing.JLabel lblEquipo;
    private javax.swing.JLabel lblFechaNac;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblIden;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNumCamisa;
    private javax.swing.JLabel lblPais;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPersona;
    private javax.swing.JLabel lblPrimerAp;
    private javax.swing.JLabel lblProvin;
    private javax.swing.JLabel lblSegAp;
    private javax.swing.JLabel lblSegNombre;
    private javax.swing.JLabel lblSelecFoto;
    private javax.swing.JLabel lblTelef;
    private javax.swing.JLabel lblTipoIden;
    private javax.swing.JLabel lblTipoPosicion;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPanel pnlAdminPersonas;
    private javax.swing.JRadioButton rbtnAdd;
    private javax.swing.JRadioButton rbtnEdit;
    private javax.swing.JSpinner spnNumCamisa;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JFormattedTextField txtDateOfBirth;
    private javax.swing.JTextArea txtDireccion;
    private javax.swing.JFormattedTextField txtIden;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPrimerAp;
    private javax.swing.JTextField txtSegAp;
    private javax.swing.JTextField txtSegNombre;
    private javax.swing.JFormattedTextField txtTelef;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
