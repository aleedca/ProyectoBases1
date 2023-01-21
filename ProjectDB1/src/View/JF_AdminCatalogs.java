/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Alexia
 */
public class JF_AdminCatalogs extends javax.swing.JFrame {

    /**
     * Creates new form JF_AdminCatalogos
     */
    public JF_AdminCatalogs() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbCatalogo = new javax.swing.JComboBox<>();
        btnAceptar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtAgregar = new javax.swing.JTextField();
        lblOpciones = new javax.swing.JLabel();
        txtModificar = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        lblCatalogo = new javax.swing.JLabel();
        lblAgregar = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        cmbSeleccionar = new javax.swing.JComboBox<>();
        lblSeleccionar = new javax.swing.JLabel();
        lblModificar = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblOpciones = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1280, 720));

        jPanel1.setBackground(new java.awt.Color(86, 4, 44));
        jPanel1.setMaximumSize(new java.awt.Dimension(1280, 720));
        jPanel1.setMinimumSize(new java.awt.Dimension(1280, 720));
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 720));
        jPanel1.setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(1065, 6, 200, 125);

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Administrar Catálogos");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(126, 66, 445, 48);

        cmbCatalogo.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        cmbCatalogo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un catálogo", "Tipo de Identificación", "Género", "Posición", "País", "Provincia", "Cantón", "Distrito", "Estado de Noticia", "Tipo de Noticia" }));
        cmbCatalogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCatalogoActionPerformed(evt);
            }
        });
        jPanel1.add(cmbCatalogo);
        cmbCatalogo.setBounds(263, 214, 346, 38);

        btnAceptar.setBackground(new java.awt.Color(0, 153, 0));
        btnAceptar.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptar.setText("Aceptar");
        jPanel1.add(btnAceptar);
        btnAceptar.setBounds(330, 660, 196, 39);
        btnAceptar.setVisible(false);

        btnModificar.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        btnModificar.setText("Modificar");
        jPanel1.add(btnModificar);
        btnModificar.setBounds(470, 480, 196, 39);

        btnEliminar.setBackground(new java.awt.Color(204, 0, 0));
        btnEliminar.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar);
        btnEliminar.setBounds(810, 660, 360, 39);

        txtAgregar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(txtAgregar);
        txtAgregar.setBounds(180, 360, 260, 40);

        lblOpciones.setFont(new java.awt.Font("Yu Gothic UI", 0, 23)); // NOI18N
        lblOpciones.setForeground(new java.awt.Color(255, 255, 255));
        lblOpciones.setText("Lista Catálogo");
        jPanel1.add(lblOpciones);
        lblOpciones.setBounds(806, 201, 367, 47);

        txtModificar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(txtModificar);
        txtModificar.setBounds(180, 480, 260, 40);

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
        btnBack.setBounds(62, 74, 46, 40);

        lblCatalogo.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        lblCatalogo.setForeground(new java.awt.Color(255, 255, 255));
        lblCatalogo.setText("Catálogo");
        jPanel1.add(lblCatalogo);
        lblCatalogo.setBounds(113, 217, 144, 32);

        lblAgregar.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblAgregar.setForeground(new java.awt.Color(255, 255, 255));
        lblAgregar.setText("Agregar ");
        jPanel1.add(lblAgregar);
        lblAgregar.setBounds(180, 330, 260, 25);

        btnAgregar.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar);
        btnAgregar.setBounds(470, 360, 196, 39);

        cmbSeleccionar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbSeleccionar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cmbSeleccionar);
        cmbSeleccionar.setBounds(440, 560, 220, 40);
        cmbSeleccionar.setVisible(false);

        lblSeleccionar.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lblSeleccionar.setForeground(new java.awt.Color(255, 255, 255));
        lblSeleccionar.setText("Seleccione");
        jPanel1.add(lblSeleccionar);
        lblSeleccionar.setBounds(180, 560, 250, 27);
        lblSeleccionar.setVisible(false);

        lblModificar.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblModificar.setForeground(new java.awt.Color(255, 255, 255));
        lblModificar.setText("Modificar");
        jPanel1.add(lblModificar);
        lblModificar.setBounds(180, 450, 260, 25);

        tblOpciones.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        tblOpciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblOpciones.setRowHeight(40);
        tblOpciones.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblOpciones);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(810, 250, 360, 390);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public JButton getBtnModificar() {
        return btnModificar;
    }

    
    public JLabel getLblCatalogo() {
        return lblCatalogo;
    }

    public void setLblCatalogoJLabel (JLabel lblCatalogo) {
        this.lblCatalogo = lblCatalogo;
    }

    public JLabel getLblAgregar() {
        return lblAgregar;
    }

    public void setLblAgregar(JLabel lblAgregar) {
        this.lblAgregar = lblAgregar;
    }

    public JLabel getLblModificar() {
        return lblModificar;
    }

    public void setLblModificar(JLabel lblModificar) {
        this.lblModificar = lblModificar;
    }

    public JLabel getLblOpciones() {
        return lblOpciones;
    }

    public void setLblOpciones(JLabel lblOpciones) {
        this.lblOpciones = lblOpciones;
    }

    
    public JComboBox<String> getCmbCatalogo() {
        return cmbCatalogo;
    }

    public void setCmbCatalogo(JComboBox<String> cmbCatalogo) {
        this.cmbCatalogo = cmbCatalogo;
    }

    public String getTextAgregar() {
        return txtAgregar.getText();
    }

    public void setTextAgregar(String text) {
        this.txtAgregar.setText(text);
    }

    public String getTextModificar() {
        return txtModificar.getText();
    }

    public void setjTextField3(String text) {
        this.txtModificar.setText(text);
    }
    
    public JButton getBtnBack() {
        return btnBack;
    }

    public void setBtnBack(JButton btnBack) {
        this.btnBack = btnBack;
    }

    public JTable getTblOpciones() {
        return tblOpciones;
    }

    public void setTblOpciones(JTable tblOpciones) {
        this.tblOpciones = tblOpciones;
    }

    public JComboBox<String> getCmbSeleccionar() {
        return cmbSeleccionar;
    }

    public void setCmbSeleccionar(JComboBox<String> cmbSeleccionar) {
        this.cmbSeleccionar = cmbSeleccionar;
    }
    
    public JLabel getLblSeleccionar() {
        return lblSeleccionar;
    }

    public JButton getBtnAceptar() {
        return btnAceptar;
    }
    
    
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // validar si de verdad desea eliminar el item seleccionado de la lista
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

    }//GEN-LAST:event_btnBackActionPerformed

    private void cmbCatalogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCatalogoActionPerformed
        
    }//GEN-LAST:event_cmbCatalogoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

    }//GEN-LAST:event_btnAgregarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> cmbCatalogo;
    private javax.swing.JComboBox<String> cmbSeleccionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAgregar;
    private javax.swing.JLabel lblCatalogo;
    private javax.swing.JLabel lblModificar;
    private javax.swing.JLabel lblOpciones;
    private javax.swing.JLabel lblSeleccionar;
    private javax.swing.JTable tblOpciones;
    private javax.swing.JTextField txtAgregar;
    private javax.swing.JTextField txtModificar;
    // End of variables declaration//GEN-END:variables
}
