/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Alexia
 */
public class JF_AdminOther extends javax.swing.JFrame {

    /**
     * Creates new form JF_AdminEvents
     */
    public JF_AdminOther() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupAdminOther = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        lblAdminOther = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        rbtnEquipo = new javax.swing.JRadioButton();
        rbtnEstadio = new javax.swing.JRadioButton();
        rbtnEvento = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        btnEditar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtNameTeam = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cmbCountry = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cmbContinent = new javax.swing.JComboBox<>();
        lblFlag = new javax.swing.JLabel();
        btnUploadFlag = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(86, 4, 44));
        jPanel1.setMaximumSize(new java.awt.Dimension(1280, 720));
        jPanel1.setMinimumSize(new java.awt.Dimension(1280, 720));
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 720));
        jPanel1.setLayout(null);

        btnBack.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/back.png"))); // NOI18N
        btnBack.setContentAreaFilled(false);
        btnBack.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/backPressed.png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack);
        btnBack.setBounds(46, 50, 46, 40);

        lblAdminOther.setFont(new java.awt.Font("Yu Gothic UI", 1, 36)); // NOI18N
        lblAdminOther.setForeground(new java.awt.Color(255, 255, 255));
        lblAdminOther.setText("Administrar Eventos, Estadios y Equipos");
        jPanel1.add(lblAdminOther);
        lblAdminOther.setBounds(110, 42, 690, 48);

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo.png"))); // NOI18N
        jPanel1.add(lblLogo);
        lblLogo.setBounds(1065, 6, 200, 125);

        btnEliminar.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        btnEliminar.setText("Eliminar");
        jPanel1.add(btnEliminar);
        btnEliminar.setBounds(920, 660, 180, 40);

        btnAdd.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        btnAdd.setText("Agregar");
        jPanel1.add(btnAdd);
        btnAdd.setBounds(480, 660, 180, 40);

        jList1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 0), 3));
        jList1.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(jList1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(40, 170, 280, 530);

        rbtnEquipo.setBackground(new java.awt.Color(86, 4, 44));
        rbtnEquipo.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        rbtnEquipo.setForeground(new java.awt.Color(255, 255, 255));
        rbtnEquipo.setText("Equipo");
        rbtnEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnEquipoActionPerformed(evt);
            }
        });
        jPanel1.add(rbtnEquipo);
        rbtnEquipo.setBounds(1060, 170, 120, 37);

        rbtnEstadio.setBackground(new java.awt.Color(86, 4, 44));
        rbtnEstadio.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        rbtnEstadio.setForeground(new java.awt.Color(255, 255, 255));
        rbtnEstadio.setText("Estadio");
        rbtnEstadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnEstadioActionPerformed(evt);
            }
        });
        jPanel1.add(rbtnEstadio);
        rbtnEstadio.setBounds(750, 170, 120, 37);

        rbtnEvento.setBackground(new java.awt.Color(86, 4, 44));
        rbtnEvento.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        rbtnEvento.setForeground(new java.awt.Color(255, 255, 255));
        rbtnEvento.setText("Evento");
        rbtnEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnEventoActionPerformed(evt);
            }
        });
        jPanel1.add(rbtnEvento);
        rbtnEvento.setBounds(430, 170, 130, 37);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(980, 170, 10, 450);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator2);
        jSeparator2.setBounds(640, 170, 10, 450);

        btnEditar.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        btnEditar.setText("Editar");
        jPanel1.add(btnEditar);
        btnEditar.setBounds(700, 660, 180, 40);

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("N??mero de grupos:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(360, 290, 170, 30);

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(360, 230, 100, 30);

        jTextField1.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jPanel1.add(jTextField1);
        jTextField1.setBounds(450, 230, 160, 30);

        jTextField2.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField2);
        jTextField2.setBounds(530, 290, 80, 30);

        jTextField3.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jPanel1.add(jTextField3);
        jTextField3.setBounds(780, 230, 160, 30);

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Distrito:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(680, 470, 100, 30);

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nombre:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(680, 230, 100, 30);

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Pa??s:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(680, 290, 80, 30);

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Provincia:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(680, 350, 100, 30);

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Cant??n:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(680, 410, 100, 30);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(780, 470, 160, 30);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jComboBox2);
        jComboBox2.setBounds(780, 290, 160, 30);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jComboBox3);
        jComboBox3.setBounds(780, 350, 160, 30);

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jComboBox4);
        jComboBox4.setBounds(780, 410, 160, 30);

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Nombre:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(1000, 230, 100, 30);

        txtNameTeam.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jPanel1.add(txtNameTeam);
        txtNameTeam.setBounds(1100, 230, 160, 30);

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Pa??s:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(1000, 360, 80, 30);

        cmbCountry.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cmbCountry);
        cmbCountry.setBounds(1100, 360, 160, 30);

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Continente:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(1000, 290, 100, 30);

        cmbContinent.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cmbContinent);
        cmbContinent.setBounds(1100, 290, 160, 30);

        lblFlag.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFlag.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/flags.jpg"))); // NOI18N
        lblFlag.setAlignmentX(0.5F);
        lblFlag.setMaximumSize(new java.awt.Dimension(180, 230));
        lblFlag.setMinimumSize(new java.awt.Dimension(180, 230));
        lblFlag.setPreferredSize(new java.awt.Dimension(180, 230));
        jPanel1.add(lblFlag);
        lblFlag.setBounds(1040, 410, 180, 110);

        btnUploadFlag.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btnUploadFlag.setText("Cargar foto");
        btnUploadFlag.setAlignmentY(0.0F);
        btnUploadFlag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadFlagActionPerformed(evt);
            }
        });
        jPanel1.add(btnUploadFlag);
        btnUploadFlag.setBounds(1070, 530, 120, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

    }//GEN-LAST:event_btnBackActionPerformed

    private void rbtnEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnEquipoActionPerformed
        
    }//GEN-LAST:event_rbtnEquipoActionPerformed

    private void rbtnEstadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnEstadioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnEstadioActionPerformed

    private void rbtnEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnEventoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnEventoActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void btnUploadFlagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadFlagActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUploadFlagActionPerformed

    public JButton getBtnAdd() {
        return btnAdd;
    }

    public void setBtnAdd(JButton btnAdd) {
        this.btnAdd = btnAdd;
    }

    

    public JButton getBtnBack() {
        return btnBack;
    }

    public void setBtnBack(JButton btnBack) {
        this.btnBack = btnBack;
    }

    public JButton getBtnEditar() {
        return btnEditar;
    }

    public void setBtnEditar(JButton btnEditar) {
        this.btnEditar = btnEditar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(JButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public JButton getBtnUploadFlag() {
        return btnUploadFlag;
    }

    public void setBtnUploadFlag(JButton btnUploadFlag) {
        this.btnUploadFlag = btnUploadFlag;
    }

    public JComboBox<String> getCmbContinent() {
        return cmbContinent;
    }

    public void setCmbContinent(JComboBox<String> cmbContinent) {
        this.cmbContinent = cmbContinent;
    }

    public JComboBox<String> getCmbCountry() {
        return cmbCountry;
    }

    public void setCmbCountry(JComboBox<String> cmbCountry) {
        this.cmbCountry = cmbCountry;
    }

    public JTextField getTxtNameTeam() {
        return txtNameTeam;
    }

    public void setTxtNameTeam(JTextField txtNameTeam) {
        this.txtNameTeam = txtNameTeam;
    }

    public JLabel getLblFlag() {
        return lblFlag;
    }

    public void setLblFlag(JLabel lblFlag) {
        this.lblFlag = lblFlag;
    }
    
    
    

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.ButtonGroup btnGroupAdminOther;
    private javax.swing.JButton btnUploadFlag;
    private javax.swing.JComboBox<String> cmbContinent;
    private javax.swing.JComboBox<String> cmbCountry;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel lblAdminOther;
    private javax.swing.JLabel lblFlag;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JRadioButton rbtnEquipo;
    private javax.swing.JRadioButton rbtnEstadio;
    private javax.swing.JRadioButton rbtnEvento;
    private javax.swing.JTextField txtNameTeam;
    // End of variables declaration//GEN-END:variables
}
