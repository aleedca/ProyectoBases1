/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;


import Controller.RequestController;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Nahomy
 */
public class JF_Principal extends javax.swing.JFrame {
    private final RequestController controller = new RequestController();

    public JF_Principal() throws SQLException {
        initComponents();
        

    }
    
    public void showMostViewedNews() throws SQLException{
        tblMostViewedNews.setModel(controller.showMostViewedNews());
        
        /*DefaultTableModel mostViewedNews = (DefaultTableModel) this.tblMostViewedNews.getModel();
        RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(mostViewedNews);
        tblMostViewedNews.setRowSorter(sorter);
        tblMostViewedNews.getRowSorter().toggleSortOrder(1);*/
    }
    

    //GETTERS

    public JButton getBtnAccount() {
        return btnAccount;
    }

    public JButton getBtnExit() {
        return btnExit;
    }

    public JButton getBtnLogin() {
        return btnLogin;
    }

    public JButton getBtnOpAdm() {
        return btnOpAdm;
    }

    public JButton getBtnRequests() {
        return btnRequests;
    }

    public JButton getBtnSignUp() {
        return btnSignUp;
    }

    public JLabel getLblWelcome() {
        return lblWelcome;
    }
    
    
    
    //SETTER
    public void setTxtLblWelcome(String lblWelcome) {
        this.lblWelcome.setText(lblWelcome);
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        pnlBackground = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnRequests = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblWelcome = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        btnExit = new javax.swing.JButton();
        btnSignUp = new javax.swing.JButton();
        btnAccount = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnOpAdm = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblMostViewedNews = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1285, 752));
        setResizable(false);

        pnlBackground.setBackground(new java.awt.Color(86, 4, 44));
        pnlBackground.setMaximumSize(new java.awt.Dimension(1280, 720));
        pnlBackground.setMinimumSize(new java.awt.Dimension(1280, 720));
        pnlBackground.setLayout(null);
        pnlBackground.add(jLabel1);
        jLabel1.setBounds(19, 44, 0, 0);

        btnRequests.setBackground(new java.awt.Color(86, 4, 44));
        btnRequests.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btnRequests.setForeground(new java.awt.Color(255, 255, 255));
        btnRequests.setText("Consultas");
        btnRequests.setAlignmentY(0.0F);
        btnRequests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestsActionPerformed(evt);
            }
        });
        pnlBackground.add(btnRequests);
        btnRequests.setBounds(660, 70, 120, 30);
        pnlBackground.add(jLabel17);
        jLabel17.setBounds(582, 44, 0, 0);
        pnlBackground.add(jLabel19);
        jLabel19.setBounds(19, 44, 0, 0);

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo.png"))); // NOI18N
        pnlBackground.add(jLabel18);
        jLabel18.setBounds(1070, 10, 200, 125);

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Partidos de hoy");
        pnlBackground.add(jLabel3);
        jLabel3.setBounds(40, 170, 440, 40);

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Últimas Noticias");
        pnlBackground.add(jLabel4);
        jLabel4.setBounds(691, 440, 550, 32);

        lblWelcome.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblWelcome.setForeground(new java.awt.Color(255, 255, 255));
        lblWelcome.setText("BIENVENIDX NOMBRE APELLIDO");
        pnlBackground.add(lblWelcome);
        lblWelcome.setBounds(30, 80, 580, 50);

        btnLogin.setBackground(new java.awt.Color(86, 4, 44));
        btnLogin.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Iniciar Sesión");
        btnLogin.setAlignmentY(0.0F);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        pnlBackground.add(btnLogin);
        btnLogin.setBounds(940, 70, 120, 30);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );

        pnlBackground.add(jPanel1);
        jPanel1.setBounds(40, 220, 440, 420);

        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlBackground.add(jPanel3);
        jPanel3.setBounds(690, 490, 550, 190);

        btnExit.setBackground(new java.awt.Color(86, 4, 44));
        btnExit.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setText("Salir");
        btnExit.setAlignmentY(0.0F);
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        pnlBackground.add(btnExit);
        btnExit.setBounds(940, 70, 120, 30);

        btnSignUp.setBackground(new java.awt.Color(86, 4, 44));
        btnSignUp.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btnSignUp.setForeground(new java.awt.Color(255, 255, 255));
        btnSignUp.setText("Registrar");
        btnSignUp.setAlignmentY(0.0F);
        btnSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUpActionPerformed(evt);
            }
        });
        pnlBackground.add(btnSignUp);
        btnSignUp.setBounds(800, 70, 120, 30);

        btnAccount.setBackground(new java.awt.Color(86, 4, 44));
        btnAccount.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btnAccount.setForeground(new java.awt.Color(255, 255, 255));
        btnAccount.setText("Mi cuenta");
        btnAccount.setAlignmentY(0.0F);
        btnAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccountActionPerformed(evt);
            }
        });
        pnlBackground.add(btnAccount);
        btnAccount.setBounds(800, 70, 120, 30);

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Noticias más vistas");
        pnlBackground.add(jLabel6);
        jLabel6.setBounds(550, 170, 680, 50);

        btnOpAdm.setBackground(new java.awt.Color(86, 4, 44));
        btnOpAdm.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btnOpAdm.setForeground(new java.awt.Color(255, 255, 255));
        btnOpAdm.setText("Menu Admin");
        btnOpAdm.setAlignmentY(0.0F);
        btnOpAdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpAdmActionPerformed(evt);
            }
        });
        pnlBackground.add(btnOpAdm);
        btnOpAdm.setBounds(520, 70, 120, 30);

        jPanel4.setBackground(new java.awt.Color(254, 195, 16));
        jPanel4.setForeground(new java.awt.Color(254, 195, 16));

        tblMostViewedNews.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        tblMostViewedNews.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Noticia ", "Visualizaciones"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMostViewedNews.setRowHeight(30);
        tblMostViewedNews.setShowGrid(false);
        tblMostViewedNews.setShowHorizontalLines(false);
        tblMostViewedNews.setShowVerticalLines(false);
        tblMostViewedNews.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblMostViewedNews);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        pnlBackground.add(jPanel4);
        jPanel4.setBounds(550, 230, 690, 190);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 1292, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed

    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnRequestsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestsActionPerformed

    }//GEN-LAST:event_btnRequestsActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignUpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSignUpActionPerformed

    private void btnAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAccountActionPerformed

    private void btnOpAdmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpAdmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOpAdmActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccount;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnOpAdm;
    private javax.swing.JButton btnRequests;
    private javax.swing.JButton btnSignUp;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList<String> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JTable tblMostViewedNews;
    // End of variables declaration//GEN-END:variables
}
