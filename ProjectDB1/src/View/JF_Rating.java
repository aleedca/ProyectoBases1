/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Isaac
 */
public class JF_Rating extends javax.swing.JFrame {

    /**
     * Creates new form JF_Rating
     */
    public JF_Rating() {
        initComponents();
        this.setLocationRelativeTo(this);
    }
    
    
    private void setImageLabel(JButton buttonName, String imageDirectory){
        ImageIcon image = new ImageIcon(imageDirectory);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(buttonName.getWidth(), buttonName.getHeight(), Image.SCALE_DEFAULT));
        buttonName.setIcon(icon);
        this.repaint();
    }
    
    public void setRatingIcons(int pRating){
        
        if(pRating == 0){
            this.setImageLabel(btnStar1, "src/Images/emptyStar.png");
            this.setImageLabel(btnStar2, "src/Images/emptyStar.png");
            this.setImageLabel(btnStar3, "src/Images/emptyStar.png");
            this.setImageLabel(btnStar4, "src/Images/emptyStar.png");
            this.setImageLabel(btnStar5, "src/Images/emptyStar.png");
        }
        else if(pRating == 1){
            this.setImageLabel(btnStar1, "src/Images/fullStar.png");
            this.setImageLabel(btnStar2, "src/Images/emptyStar.png");
            this.setImageLabel(btnStar3, "src/Images/emptyStar.png");
            this.setImageLabel(btnStar4, "src/Images/emptyStar.png");
            this.setImageLabel(btnStar5, "src/Images/emptyStar.png");
        }
        else if(pRating == 2){
            this.setImageLabel(btnStar1, "src/Images/fullStar.png");
            this.setImageLabel(btnStar2, "src/Images/fullStar.png");
            this.setImageLabel(btnStar3, "src/Images/emptyStar.png");
            this.setImageLabel(btnStar4, "src/Images/emptyStar.png");
            this.setImageLabel(btnStar5, "src/Images/emptyStar.png");
        }
        else if(pRating == 3){
            this.setImageLabel(btnStar1, "src/Images/fullStar.png");
            this.setImageLabel(btnStar2, "src/Images/fullStar.png");
            this.setImageLabel(btnStar3, "src/Images/fullStar.png");
            this.setImageLabel(btnStar4, "src/Images/emptyStar.png");
            this.setImageLabel(btnStar5, "src/Images/emptyStar.png");
        }
        else if(pRating == 4){
            this.setImageLabel(btnStar1, "src/Images/fullStar.png");
            this.setImageLabel(btnStar2, "src/Images/fullStar.png");
            this.setImageLabel(btnStar3, "src/Images/fullStar.png");
            this.setImageLabel(btnStar4, "src/Images/fullStar.png");
            this.setImageLabel(btnStar5, "src/Images/emptyStar.png");
        }
        else if(pRating == 5){
            this.setImageLabel(btnStar1, "src/Images/fullStar.png");
            this.setImageLabel(btnStar2, "src/Images/fullStar.png");
            this.setImageLabel(btnStar3, "src/Images/fullStar.png");
            this.setImageLabel(btnStar4, "src/Images/fullStar.png");
            this.setImageLabel(btnStar5, "src/Images/fullStar.png");
        }
        
    }

    public void setTitle(String title){
        this.lblTitleNews.setText(title);
    }
    
    public JLabel getLblTitleNews() {
        return lblTitleNews;
    }

    public JButton getBtnBack() {
        return btnBack;
    }

    public JButton getBtnConfirm() {
        return btnConfirm;
    }

    public JButton getBtnStar1() {
        return btnStar1;
    }

    public JButton getBtnStar2() {
        return btnStar2;
    }

    public JButton getBtnStar3() {
        return btnStar3;
    }

    public JButton getBtnStar4() {
        return btnStar4;
    }

    public JButton getBtnStar5() {
        return btnStar5;
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
        lblTitleNews = new javax.swing.JLabel();
        btnStar5 = new javax.swing.JButton();
        btnStar1 = new javax.swing.JButton();
        btnStar2 = new javax.swing.JButton();
        btnStar3 = new javax.swing.JButton();
        btnStar4 = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        btnConfirm = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(460, 450));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(86, 4, 44));
        jPanel1.setMaximumSize(new java.awt.Dimension(460, 450));
        jPanel1.setMinimumSize(new java.awt.Dimension(460, 450));
        jPanel1.setPreferredSize(new java.awt.Dimension(460, 450));
        jPanel1.setLayout(null);

        lblTitleNews.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTitleNews.setForeground(new java.awt.Color(255, 255, 255));
        lblTitleNews.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitleNews.setText("Title");
        jPanel1.add(lblTitleNews);
        lblTitleNews.setBounds(10, 100, 440, 80);

        btnStar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/emptyStar.png"))); // NOI18N
        btnStar5.setContentAreaFilled(false);
        btnStar5.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fullStar.png"))); // NOI18N
        btnStar5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fullStar.png"))); // NOI18N
        jPanel1.add(btnStar5);
        btnStar5.setBounds(310, 220, 40, 40);

        btnStar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/emptyStar.png"))); // NOI18N
        btnStar1.setContentAreaFilled(false);
        btnStar1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fullStar.png"))); // NOI18N
        btnStar1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fullStar.png"))); // NOI18N
        jPanel1.add(btnStar1);
        btnStar1.setBounds(110, 220, 40, 40);

        btnStar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/emptyStar.png"))); // NOI18N
        btnStar2.setContentAreaFilled(false);
        btnStar2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fullStar.png"))); // NOI18N
        btnStar2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fullStar.png"))); // NOI18N
        jPanel1.add(btnStar2);
        btnStar2.setBounds(160, 220, 40, 40);

        btnStar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/emptyStar.png"))); // NOI18N
        btnStar3.setContentAreaFilled(false);
        btnStar3.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fullStar.png"))); // NOI18N
        btnStar3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fullStar.png"))); // NOI18N
        jPanel1.add(btnStar3);
        btnStar3.setBounds(210, 220, 40, 40);

        btnStar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/emptyStar.png"))); // NOI18N
        btnStar4.setContentAreaFilled(false);
        btnStar4.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fullStar.png"))); // NOI18N
        btnStar4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fullStar.png"))); // NOI18N
        jPanel1.add(btnStar4);
        btnStar4.setBounds(260, 220, 40, 40);

        lblTitle.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 36)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Calificación");
        jPanel1.add(lblTitle);
        lblTitle.setBounds(90, 10, 280, 60);

        btnConfirm.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        btnConfirm.setText("CONFIRMAR");
        jPanel1.add(btnConfirm);
        btnConfirm.setBounds(170, 350, 120, 27);

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
        btnBack.setBounds(20, 20, 46, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(JF_Rating.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_Rating.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_Rating.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_Rating.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JF_Rating().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnStar1;
    private javax.swing.JButton btnStar2;
    private javax.swing.JButton btnStar3;
    private javax.swing.JButton btnStar4;
    private javax.swing.JButton btnStar5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitleNews;
    // End of variables declaration//GEN-END:variables
}
