/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;


import Controller.RequestController;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
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
        DefaultTableModel modelTable = (DefaultTableModel) tblMostViewedNews.getModel();
        modelTable.setRowCount(0);
        tblMostViewedNews.setModel(controller.showMostViewedNews());
    }
    
    public void showLastNews() throws SQLException{
        DefaultTableModel modelTable = (DefaultTableModel) tblLastNews.getModel();
        modelTable.setRowCount(0);
        tblLastNews.setModel(controller.showLastNews());
       
    }
    

    //GETTERS

    public JButton getBtnShowStats() {
        return btnShowStats;
    }

    public JTable getTblTodayMatches() {
        return tblTodayMatches;
    }

    public JTable getTblLastNews() {
        return tblLastNews;
    }

    public JTable getTblMostViewedNews() {
        return tblMostViewedNews;
    }

    public RequestController getController() {
        return controller;
    }
    
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
        btnExit = new javax.swing.JButton();
        btnSignUp = new javax.swing.JButton();
        btnAccount = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnOpAdm = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblMostViewedNews = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLastNews = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTodayMatches = new javax.swing.JTable();
        btnShowStats = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblMostViewedNews1 = new javax.swing.JTable();

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
        jLabel3.setBounds(50, 170, 440, 40);

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("??ltimas Noticias");
        pnlBackground.add(jLabel4);
        jLabel4.setBounds(540, 440, 690, 32);

        lblWelcome.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblWelcome.setForeground(new java.awt.Color(255, 255, 255));
        lblWelcome.setText("BIENVENIDX NOMBRE APELLIDO");
        pnlBackground.add(lblWelcome);
        lblWelcome.setBounds(30, 80, 580, 50);

        btnLogin.setBackground(new java.awt.Color(86, 4, 44));
        btnLogin.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Iniciar Sesi??n");
        btnLogin.setAlignmentY(0.0F);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        pnlBackground.add(btnLogin);
        btnLogin.setBounds(940, 70, 120, 30);

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
        jLabel6.setText("Noticias m??s vistas");
        pnlBackground.add(jLabel6);
        jLabel6.setBounds(540, 170, 680, 50);

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
        tblMostViewedNews.setShowVerticalLines(true);
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
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlBackground.add(jPanel4);
        jPanel4.setBounds(540, 230, 690, 190);

        jPanel2.setBackground(new java.awt.Color(254, 195, 16));
        jPanel2.setForeground(new java.awt.Color(254, 195, 16));

        tblLastNews.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        tblLastNews.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Noticia", "Publicaci??n"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class
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
        tblLastNews.setRowHeight(30);
        jScrollPane1.setViewportView(tblLastNews);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlBackground.add(jPanel2);
        jPanel2.setBounds(540, 480, 690, 200);

        tblTodayMatches.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        tblTodayMatches.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Equipo1", "Hora", "Equipo2"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTodayMatches.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblTodayMatches);
        if (tblTodayMatches.getColumnModel().getColumnCount() > 0) {
            tblTodayMatches.getColumnModel().getColumn(1).setMinWidth(70);
            tblTodayMatches.getColumnModel().getColumn(1).setPreferredWidth(70);
            tblTodayMatches.getColumnModel().getColumn(1).setMaxWidth(70);
        }

        pnlBackground.add(jScrollPane2);
        jScrollPane2.setBounds(70, 230, 410, 370);

        btnShowStats.setBackground(new java.awt.Color(255, 204, 51));
        btnShowStats.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        btnShowStats.setText("Ver Estad??sticas");
        pnlBackground.add(btnShowStats);
        btnShowStats.setBounds(70, 610, 410, 70);

        jPanel5.setBackground(new java.awt.Color(254, 195, 16));
        jPanel5.setForeground(new java.awt.Color(254, 195, 16));

        tblMostViewedNews1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        tblMostViewedNews1.setModel(new javax.swing.table.DefaultTableModel(
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
        tblMostViewedNews1.setRowHeight(30);
        tblMostViewedNews1.setShowGrid(false);
        tblMostViewedNews1.setShowVerticalLines(true);
        tblMostViewedNews1.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tblMostViewedNews1);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlBackground.add(jPanel5);
        jPanel5.setBounds(540, 230, 690, 190);

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
    private javax.swing.JButton btnShowStats;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JTable tblLastNews;
    private javax.swing.JTable tblMostViewedNews;
    private javax.swing.JTable tblMostViewedNews1;
    private javax.swing.JTable tblTodayMatches;
    // End of variables declaration//GEN-END:variables
}
