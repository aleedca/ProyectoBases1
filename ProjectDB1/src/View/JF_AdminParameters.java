/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

/**
 *
 * @author Alexia
 */
public class JF_AdminParameters extends javax.swing.JFrame {

    /**
     * Creates new form JF_AdminParameters
     */
    public JF_AdminParameters() {
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

        btnGroupParametros = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        lblAdminOther = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblParametros = new javax.swing.JTable();
        rbtnAgregar = new javax.swing.JRadioButton();
        rbtnEditar = new javax.swing.JRadioButton();
        lblEntradaParametro = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        txtEntrada = new javax.swing.JTextField();
        lblNombreParametro = new javax.swing.JLabel();

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
        lblAdminOther.setText("Administrar Parámetros");
        jPanel1.add(lblAdminOther);
        lblAdminOther.setBounds(110, 42, 690, 48);

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo.png"))); // NOI18N
        jPanel1.add(lblLogo);
        lblLogo.setBounds(1065, 6, 200, 125);

        tblParametros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Entrada"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblParametros);
        if (tblParametros.getColumnModel().getColumnCount() > 0) {
            tblParametros.getColumnModel().getColumn(0).setMinWidth(10);
            tblParametros.getColumnModel().getColumn(1).setMinWidth(350);
            tblParametros.getColumnModel().getColumn(2).setMinWidth(100);
        }

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(50, 180, 610, 480);

        rbtnAgregar.setBackground(new java.awt.Color(86, 4, 44));
        btnGroupParametros.add(rbtnAgregar);
        rbtnAgregar.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        rbtnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        rbtnAgregar.setText("Agregar");
        rbtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(rbtnAgregar);
        rbtnAgregar.setBounds(810, 180, 150, 37);
        rbtnAgregar.setSelected(true);

        rbtnEditar.setBackground(new java.awt.Color(86, 4, 44));
        btnGroupParametros.add(rbtnEditar);
        rbtnEditar.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        rbtnEditar.setForeground(new java.awt.Color(255, 255, 255));
        rbtnEditar.setText("Editar");
        rbtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(rbtnEditar);
        rbtnEditar.setBounds(1040, 180, 100, 37);

        lblEntradaParametro.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        lblEntradaParametro.setForeground(new java.awt.Color(255, 255, 255));
        lblEntradaParametro.setText("Entrada del parámetro:");
        jPanel1.add(lblEntradaParametro);
        lblEntradaParametro.setBounds(730, 420, 220, 30);

        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtNombre);
        txtNombre.setBounds(960, 360, 250, 30);

        btnAceptar.setBackground(new java.awt.Color(86, 4, 44));
        btnAceptar.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptar.setText("Aceptar");
        btnAceptar.setBorderPainted(false);
        jPanel1.add(btnAceptar);
        btnAceptar.setBounds(920, 630, 130, 40);

        txtEntrada.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtEntrada);
        txtEntrada.setBounds(960, 420, 250, 30);

        lblNombreParametro.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        lblNombreParametro.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreParametro.setText("Nombre del parámetro:");
        jPanel1.add(lblNombreParametro);
        lblNombreParametro.setBounds(730, 360, 220, 30);

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

    private void rbtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnAgregarActionPerformed

    }//GEN-LAST:event_rbtnAgregarActionPerformed

    private void rbtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnEditarActionPerformed

    }//GEN-LAST:event_rbtnEditarActionPerformed

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
            java.util.logging.Logger.getLogger(JF_AdminParameters.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_AdminParameters.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_AdminParameters.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_AdminParameters.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JF_AdminParameters().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnBack;
    private javax.swing.ButtonGroup btnGroupParametros;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAdminOther;
    private javax.swing.JLabel lblEntradaParametro;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNombreParametro;
    private javax.swing.JRadioButton rbtnAgregar;
    private javax.swing.JRadioButton rbtnEditar;
    private javax.swing.JTable tblParametros;
    private javax.swing.JTextField txtEntrada;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
