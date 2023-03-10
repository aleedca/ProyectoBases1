/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Objects.News;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;

/**
 *
 * @author Isaac
 */
public class JF_News extends javax.swing.JFrame {
    
    private News NewsInfo;
    private boolean favorite;

    /**
     * Creates new form JF_NewsWindow
     */
    public JF_News() {
        initComponents();
        this.setLocationRelativeTo(this);
    }
    
    public void UpdateInfo(News news){
        this.NewsInfo = news;
        loadInfo();
    }
    
    private void loadInfo(){
        setImageLabel(this.lblPhoto,this.NewsInfo.getPhoto());
        this.lblTitle.setText(this.NewsInfo.getTitle());
        this.txtBody.setText(this.NewsInfo.getText());
        this.lblNewsType.setText(this.NewsInfo.getNewsType());
        this.lblAuthor.setText(this.NewsInfo.getAuthor());
        this.lblDate.setText(this.NewsInfo.getPublicationDate());
        this.setRatingIcons(this.NewsInfo.getRateNumber());
    }
    
    
    private void setImageLabel(JLabel labelName, String imageDirectory){
        ImageIcon image = new ImageIcon(imageDirectory);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT));
        labelName.setIcon(icon);
        this.repaint();
    }
    
    private void setButtonImage(JButton buttonName, String imageDirectory){
        ImageIcon image = new ImageIcon(imageDirectory);
        Icon icon = new ImageIcon(image.getImage());
        buttonName.setIcon(icon);
        this.repaint();
    }
    
    private void setRatingIcons(int pRating){
        
        if(pRating == 0){
            this.setImageLabel(lblStar1, "src/Images/emptyStar.png");
            this.setImageLabel(lblStar2, "src/Images/emptyStar.png");
            this.setImageLabel(lblStar3, "src/Images/emptyStar.png");
            this.setImageLabel(lblStar4, "src/Images/emptyStar.png");
            this.setImageLabel(lblStar5, "src/Images/emptyStar.png");
            this.lblRating.setText("0.0");
        }
        else if(pRating == 1){
            this.setImageLabel(lblStar1, "src/Images/fullStar.png");
            this.setImageLabel(lblStar2, "src/Images/emptyStar.png");
            this.setImageLabel(lblStar3, "src/Images/emptyStar.png");
            this.setImageLabel(lblStar4, "src/Images/emptyStar.png");
            this.setImageLabel(lblStar5, "src/Images/emptyStar.png");
            this.lblRating.setText("1.0");
        }
        else if(pRating == 2){
            this.setImageLabel(lblStar1, "src/Images/fullStar.png");
            this.setImageLabel(lblStar2, "src/Images/fullStar.png");
            this.setImageLabel(lblStar3, "src/Images/emptyStar.png");
            this.setImageLabel(lblStar4, "src/Images/emptyStar.png");
            this.setImageLabel(lblStar5, "src/Images/emptyStar.png");
            this.lblRating.setText("2.0");
        }
        else if(pRating == 3){
            this.setImageLabel(lblStar1, "src/Images/fullStar.png");
            this.setImageLabel(lblStar2, "src/Images/fullStar.png");
            this.setImageLabel(lblStar3, "src/Images/fullStar.png");
            this.setImageLabel(lblStar4, "src/Images/emptyStar.png");
            this.setImageLabel(lblStar5, "src/Images/emptyStar.png");
            this.lblRating.setText("3.0");
        }
        else if(pRating == 4){
            this.setImageLabel(lblStar1, "src/Images/fullStar.png");
            this.setImageLabel(lblStar2, "src/Images/fullStar.png");
            this.setImageLabel(lblStar3, "src/Images/fullStar.png");
            this.setImageLabel(lblStar4, "src/Images/fullStar.png");
            this.setImageLabel(lblStar5, "src/Images/emptyStar.png");
            this.lblRating.setText("4.0");
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

    public JButton getBtnBack() {
        return btnBack;
    }

    public JButton getBtnComment() {
        return btnComment;
    }

    public JButton getBtnRating() {
        return btnRating;
    }

    public JLabel getLblTitle() {
        return lblTitle;
    }

    public News getNewsInfo() {
        return NewsInfo;
    }

    public JTable getTblComments() {
        return tblComments;
    }

    public JTextArea getTxtComment() {
        return txtComment;
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
        lblRating = new javax.swing.JLabel();
        lblStar1 = new javax.swing.JLabel();
        lblStar2 = new javax.swing.JLabel();
        lblStar3 = new javax.swing.JLabel();
        lblStar4 = new javax.swing.JLabel();
        lblStar5 = new javax.swing.JLabel();
        btnComment = new javax.swing.JButton();
        btnRating = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblComments = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        label = new javax.swing.JLabel();
        lblNewsType = new javax.swing.JLabel();
        label1 = new javax.swing.JLabel();
        lblAuthor = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        txtBody = new javax.swing.JTextArea();
        txtComment = new javax.swing.JTextArea();
        btnFavorite = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1292, 746));

        jPanel1.setBackground(new java.awt.Color(86, 4, 44));
        jPanel1.setLayout(null);

        lblTitle.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 30)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("TITLE");
        jPanel1.add(lblTitle);
        lblTitle.setBounds(110, 70, 730, 60);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo.png"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(1090, 10, 190, 120);

        lblPhoto.setOpaque(true);
        jPanel1.add(lblPhoto);
        lblPhoto.setBounds(100, 140, 420, 240);

        lblRating.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 36)); // NOI18N
        lblRating.setForeground(new java.awt.Color(255, 255, 255));
        lblRating.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRating.setText("3");
        lblRating.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.add(lblRating);
        lblRating.setBounds(540, 190, 60, 40);

        lblStar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/emptyStar.png"))); // NOI18N
        jPanel1.add(lblStar1);
        lblStar1.setBounds(530, 130, 40, 40);

        lblStar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/emptyStar.png"))); // NOI18N
        jPanel1.add(lblStar2);
        lblStar2.setBounds(580, 130, 40, 40);

        lblStar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/emptyStar.png"))); // NOI18N
        jPanel1.add(lblStar3);
        lblStar3.setBounds(630, 130, 40, 40);

        lblStar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/emptyStar.png"))); // NOI18N
        jPanel1.add(lblStar4);
        lblStar4.setBounds(680, 130, 40, 40);

        lblStar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/emptyStar.png"))); // NOI18N
        jPanel1.add(lblStar5);
        lblStar5.setBounds(730, 130, 40, 40);

        btnComment.setBackground(new java.awt.Color(255, 204, 102));
        btnComment.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 12)); // NOI18N
        btnComment.setText("Comentar");
        jPanel1.add(btnComment);
        btnComment.setBounds(1147, 630, 100, 90);

        btnRating.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        btnRating.setText("Calificar");
        btnRating.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRatingActionPerformed(evt);
            }
        });
        jPanel1.add(btnRating);
        btnRating.setBounds(620, 190, 100, 40);

        tblComments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Usuario", "Comentario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblComments.setEnabled(false);
        tblComments.setRowHeight(30);
        tblComments.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblComments);
        if (tblComments.getColumnModel().getColumnCount() > 0) {
            tblComments.getColumnModel().getColumn(0).setMinWidth(100);
            tblComments.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblComments.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(870, 152, 380, 460);

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
        btnBack.setBounds(50, 80, 46, 40);

        label.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        label.setForeground(new java.awt.Color(255, 255, 255));
        label.setText("Fecha:");
        jPanel1.add(label);
        label.setBounds(540, 310, 60, 30);

        lblNewsType.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        lblNewsType.setForeground(new java.awt.Color(255, 255, 255));
        lblNewsType.setText("TITLE");
        jPanel1.add(lblNewsType);
        lblNewsType.setBounds(640, 250, 200, 30);

        label1.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 255, 255));
        label1.setText("Categoria:");
        jPanel1.add(label1);
        label1.setBounds(540, 250, 90, 30);

        lblAuthor.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        lblAuthor.setForeground(new java.awt.Color(255, 255, 255));
        lblAuthor.setText("TITLE");
        jPanel1.add(lblAuthor);
        lblAuthor.setBounds(640, 280, 200, 30);

        label2.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        label2.setForeground(new java.awt.Color(255, 255, 255));
        label2.setText("Autor:");
        jPanel1.add(label2);
        label2.setBounds(540, 280, 49, 30);

        lblDate.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        lblDate.setForeground(new java.awt.Color(255, 255, 255));
        lblDate.setText("TITLE");
        jPanel1.add(lblDate);
        lblDate.setBounds(640, 310, 200, 30);

        txtBody.setBackground(new java.awt.Color(86, 4, 44));
        txtBody.setColumns(20);
        txtBody.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        txtBody.setForeground(new java.awt.Color(255, 255, 255));
        txtBody.setLineWrap(true);
        txtBody.setRows(5);
        jPanel1.add(txtBody);
        txtBody.setBounds(100, 400, 730, 320);

        txtComment.setColumns(20);
        txtComment.setLineWrap(true);
        txtComment.setRows(5);
        txtComment.setPreferredSize(new java.awt.Dimension(282, 84));
        jPanel1.add(txtComment);
        txtComment.setBounds(870, 630, 270, 90);

        btnFavorite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/emptyHeart.png"))); // NOI18N
        btnFavorite.setBorderPainted(false);
        btnFavorite.setContentAreaFilled(false);
        btnFavorite.setFocusPainted(false);
        btnFavorite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFavoriteActionPerformed(evt);
            }
        });
        jPanel1.add(btnFavorite);
        btnFavorite.setBounds(730, 190, 46, 40);

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

    private void btnRatingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRatingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRatingActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnFavoriteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFavoriteActionPerformed
        if(this.favorite){
            this.favorite = false;
            setButtonImage(this.btnFavorite, "src/Images/emptyHeart.png");
        }else{
            this.favorite = true;
            setButtonImage(this.btnFavorite, "src/Images/fullHeart.png");
        }
        
    }//GEN-LAST:event_btnFavoriteActionPerformed

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
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnComment;
    private javax.swing.JButton btnFavorite;
    private javax.swing.JButton btnRating;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel lblAuthor;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblNewsType;
    private javax.swing.JLabel lblPhoto;
    private javax.swing.JLabel lblRating;
    private javax.swing.JLabel lblStar1;
    private javax.swing.JLabel lblStar2;
    private javax.swing.JLabel lblStar3;
    private javax.swing.JLabel lblStar4;
    private javax.swing.JLabel lblStar5;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblComments;
    private javax.swing.JTextArea txtBody;
    private javax.swing.JTextArea txtComment;
    // End of variables declaration//GEN-END:variables
}
