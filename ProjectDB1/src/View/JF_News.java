/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Objects.News;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Isaac
 */
public class JF_News extends javax.swing.JFrame {
    
    //private NewsClass NewsInfo = new NewsClass();

    /**
     * Creates new form JF_NewsWindow
     */
    public JF_News() {
        initComponents();
        this.setLocationRelativeTo(this);
        setRatingIcons(3.5);
        //this.setImageLabel(lblStar1, "src/Images/emptyStar.png");
    }
    
    private void setImageLabel(JLabel labelName, String imageDirectory){
        ImageIcon image = new ImageIcon(imageDirectory);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT));
        labelName.setIcon(icon);
        this.repaint();
    }
    
    private void setRatingIcons(double pRating){
        
        if(pRating == 0){
            this.setImageLabel(lblStar1, "src/Images/emptyStar.png");
            this.setImageLabel(lblStar2, "src/Images/emptyStar.png");
            this.setImageLabel(lblStar3, "src/Images/emptyStar.png");
            this.setImageLabel(lblStar4, "src/Images/emptyStar.png");
            this.setImageLabel(lblStar5, "src/Images/emptyStar.png");
            this.lblRating.setText("0.0");
        }
        else if(pRating == 0.5){
            this.setImageLabel(lblStar1, "src/Images/halfStar.png");
            this.setImageLabel(lblStar2, "src/Images/emptyStar.png");
            this.setImageLabel(lblStar3, "src/Images/emptyStar.png");
            this.setImageLabel(lblStar4, "src/Images/emptyStar.png");
            this.setImageLabel(lblStar5, "src/Images/emptyStar.png");
            this.lblRating.setText("0.5");
        }
        else if(pRating == 1){
            this.setImageLabel(lblStar1, "src/Images/fullStar.png");
            this.setImageLabel(lblStar2, "src/Images/emptyStar.png");
            this.setImageLabel(lblStar3, "src/Images/emptyStar.png");
            this.setImageLabel(lblStar4, "src/Images/emptyStar.png");
            this.setImageLabel(lblStar5, "src/Images/emptyStar.png");
            this.lblRating.setText("1.0");
        }
        else if(pRating == 1.5){
            this.setImageLabel(lblStar1, "src/Images/fullStar.png");
            this.setImageLabel(lblStar2, "src/Images/halfStar.png");
            this.setImageLabel(lblStar3, "src/Images/emptyStar.png");
            this.setImageLabel(lblStar4, "src/Images/emptyStar.png");
            this.setImageLabel(lblStar5, "src/Images/emptyStar.png");
            this.lblRating.setText("1.5");
        }
        else if(pRating == 2){
            this.setImageLabel(lblStar1, "src/Images/fullStar.png");
            this.setImageLabel(lblStar2, "src/Images/fullStar.png");
            this.setImageLabel(lblStar3, "src/Images/emptyStar.png");
            this.setImageLabel(lblStar4, "src/Images/emptyStar.png");
            this.setImageLabel(lblStar5, "src/Images/emptyStar.png");
            this.lblRating.setText("2.0");
        }
        else if(pRating == 2.5){
            this.setImageLabel(lblStar1, "src/Images/fullStar.png");
            this.setImageLabel(lblStar2, "src/Images/fullStar.png");
            this.setImageLabel(lblStar3, "src/Images/halfStar.png");
            this.setImageLabel(lblStar4, "src/Images/emptyStar.png");
            this.setImageLabel(lblStar5, "src/Images/emptyStar.png");
            this.lblRating.setText("2.5");
        }
        else if(pRating == 3){
            this.setImageLabel(lblStar1, "src/Images/fullStar.png");
            this.setImageLabel(lblStar2, "src/Images/fullStar.png");
            this.setImageLabel(lblStar3, "src/Images/fullStar.png");
            this.setImageLabel(lblStar4, "src/Images/emptyStar.png");
            this.setImageLabel(lblStar5, "src/Images/emptyStar.png");
            this.lblRating.setText("3.0");
        }
        else if(pRating == 3.5){
            this.setImageLabel(lblStar1, "src/Images/fullStar.png");
            this.setImageLabel(lblStar2, "src/Images/fullStar.png");
            this.setImageLabel(lblStar3, "src/Images/fullStar.png");
            this.setImageLabel(lblStar4, "src/Images/halfStar.png");
            this.setImageLabel(lblStar5, "src/Images/emptyStar.png");
            this.lblRating.setText("3.5");
        }
        else if(pRating == 4){
            this.setImageLabel(lblStar1, "src/Images/fullStar.png");
            this.setImageLabel(lblStar2, "src/Images/fullStar.png");
            this.setImageLabel(lblStar3, "src/Images/fullStar.png");
            this.setImageLabel(lblStar4, "src/Images/fullStar.png");
            this.setImageLabel(lblStar5, "src/Images/emptyStar.png");
            this.lblRating.setText("4.0");
        }
        else if(pRating == 4.5){
            this.setImageLabel(lblStar1, "src/Images/fullStar.png");
            this.setImageLabel(lblStar2, "src/Images/fullStar.png");
            this.setImageLabel(lblStar3, "src/Images/fullStar.png");
            this.setImageLabel(lblStar4, "src/Images/fullStar.png");
            this.setImageLabel(lblStar5, "src/Images/halfStar.png");
            this.lblRating.setText("4.5");
        }
        else if(pRating == 5){
            this.setImageLabel(lblStar1, "src/Images/fullStar.png");
            this.setImageLabel(lblStar2, "src/Images/fullStar.png");
            this.setImageLabel(lblStar3, "src/Images/fullStar.png");
            this.setImageLabel(lblStar4, "src/Images/fullStar.png");
            this.setImageLabel(lblStar5, "src/Images/fullStar.png");
            this.lblRating.setText("5.0");
        }
        
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
        lblTitle = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblPhoto = new javax.swing.JLabel();
        lblNewsBody = new javax.swing.JLabel();
        lblRating = new javax.swing.JLabel();
        lblStar1 = new javax.swing.JLabel();
        lblStar2 = new javax.swing.JLabel();
        lblStar3 = new javax.swing.JLabel();
        lblStar4 = new javax.swing.JLabel();
        lblStar5 = new javax.swing.JLabel();
        lblComments = new javax.swing.JLabel();
        btnComment = new javax.swing.JButton();
        fieldComment = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1292, 746));

        jPanel1.setBackground(new java.awt.Color(86, 4, 44));
        jPanel1.setLayout(null);

        lblTitle.setFont(new java.awt.Font("Yu Gothic UI", 1, 36)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("TITLE");
        jPanel1.add(lblTitle);
        lblTitle.setBounds(50, 50, 150, 60);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo.png"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(1090, 10, 190, 120);

        lblPhoto.setText("photo");
        lblPhoto.setOpaque(true);
        jPanel1.add(lblPhoto);
        lblPhoto.setBounds(50, 120, 420, 240);

        lblNewsBody.setText("jLabel4");
        lblNewsBody.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.add(lblNewsBody);
        lblNewsBody.setBounds(50, 380, 700, 340);

        lblRating.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 36)); // NOI18N
        lblRating.setForeground(new java.awt.Color(255, 255, 255));
        lblRating.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRating.setText("1.5");
        lblRating.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.add(lblRating);
        lblRating.setBounds(490, 180, 60, 40);

        lblStar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/emptyStar.png"))); // NOI18N
        jPanel1.add(lblStar1);
        lblStar1.setBounds(490, 120, 40, 40);

        lblStar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/emptyStar.png"))); // NOI18N
        jPanel1.add(lblStar2);
        lblStar2.setBounds(540, 120, 40, 40);

        lblStar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/emptyStar.png"))); // NOI18N
        jPanel1.add(lblStar3);
        lblStar3.setBounds(590, 120, 40, 40);

        lblStar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/emptyStar.png"))); // NOI18N
        jPanel1.add(lblStar4);
        lblStar4.setBounds(640, 120, 40, 40);

        lblStar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/emptyStar.png"))); // NOI18N
        jPanel1.add(lblStar5);
        lblStar5.setBounds(690, 120, 40, 40);

        lblComments.setBackground(new java.awt.Color(255, 255, 255));
        lblComments.setText("jLabel1");
        lblComments.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        lblComments.setOpaque(true);
        jPanel1.add(lblComments);
        lblComments.setBounds(870, 160, 350, 460);

        btnComment.setText("jButton1");
        jPanel1.add(btnComment);
        btnComment.setBounds(1140, 630, 75, 60);

        fieldComment.setText("jTextField1");
        jPanel1.add(fieldComment);
        fieldComment.setBounds(870, 630, 260, 60);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1292, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(JF_News.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_News.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_News.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_News.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JF_News().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComment;
    private javax.swing.JTextField fieldComment;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblComments;
    private javax.swing.JLabel lblNewsBody;
    private javax.swing.JLabel lblPhoto;
    private javax.swing.JLabel lblRating;
    private javax.swing.JLabel lblStar1;
    private javax.swing.JLabel lblStar2;
    private javax.swing.JLabel lblStar3;
    private javax.swing.JLabel lblStar4;
    private javax.swing.JLabel lblStar5;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
}
