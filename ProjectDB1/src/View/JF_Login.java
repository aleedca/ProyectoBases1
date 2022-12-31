/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

//import Controller.OperationsController;
import javax.swing.JButton;
//import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Mariana
 */
public class JF_Login extends javax.swing.JFrame {

    public JF_Login() {
        initComponents();
        //OperationsController controller = new OperationsController();
    }

    //GETTERS
    public String getTxtPasswordLogin() {
        String passwordLogin = new String(txtPasswordLogin.getPassword());
        return passwordLogin;
    }

    public String getTxtUsernameLogin() {
        String usernameLogin = txtUsernameLogin.getText();
        return usernameLogin;
    }

    public JButton getBtnLogin() {
        return btnLogin;
    }

    public JButton getBtnBack() {
        return btnBack;
    }
    
    
    
    //Clean
    public void cleanPasswordLogin() {
        this.txtPasswordLogin.setText("");
    }

    public void cleanUsernameLogin() {
        this.txtUsernameLogin.setText("");
    }
    
    
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnlLogin = new javax.swing.JPanel();
        lbUsername = new javax.swing.JLabel();
        lbPassword = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        txtUsernameLogin = new javax.swing.JTextField();
        txtPasswordLogin = new javax.swing.JPasswordField();
        lbWelcome = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(141, 28, 61));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(86, 4, 44));
        jPanel1.setLayout(null);

        pnlLogin.setBackground(new java.awt.Color(254, 195, 16));
        pnlLogin.setLayout(null);

        lbUsername.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        lbUsername.setText("Username");
        pnlLogin.add(lbUsername);
        lbUsername.setBounds(30, 20, 62, 20);

        lbPassword.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        lbPassword.setText("Password");
        pnlLogin.add(lbPassword);
        lbPassword.setBounds(30, 50, 59, 20);

        btnLogin.setBackground(new java.awt.Color(73, 188, 227));
        btnLogin.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("LOGIN");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        pnlLogin.add(btnLogin);
        btnLogin.setBounds(30, 90, 203, 37);

        txtUsernameLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameLoginActionPerformed(evt);
            }
        });
        pnlLogin.add(txtUsernameLogin);
        txtUsernameLogin.setBounds(100, 20, 130, 22);

        txtPasswordLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordLoginActionPerformed(evt);
            }
        });
        pnlLogin.add(txtPasswordLogin);
        txtPasswordLogin.setBounds(100, 50, 130, 20);

        jPanel1.add(pnlLogin);
        pnlLogin.setBounds(90, 190, 260, 150);

        lbWelcome.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        lbWelcome.setForeground(new java.awt.Color(255, 255, 255));
        lbWelcome.setText("BIENVENIDO");
        jPanel1.add(lbWelcome);
        lbWelcome.setBounds(150, 140, 140, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(120, 20, 200, 120);

        btnBack.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/back.png"))); // NOI18N
        btnBack.setBorderPainted(false);
        btnBack.setContentAreaFilled(false);
        btnBack.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/backPressed.png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack);
        btnBack.setBounds(20, 360, 46, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
  
    }//GEN-LAST:event_btnLoginActionPerformed

    private void txtUsernameLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameLoginActionPerformed

    private void txtPasswordLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordLoginActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

    }//GEN-LAST:event_btnBackActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbPassword;
    private javax.swing.JLabel lbUsername;
    private javax.swing.JLabel lbWelcome;
    private javax.swing.JPanel pnlLogin;
    private javax.swing.JPasswordField txtPasswordLogin;
    private javax.swing.JTextField txtUsernameLogin;
    // End of variables declaration//GEN-END:variables
}
