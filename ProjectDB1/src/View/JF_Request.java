/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author Nahomy
 */
public class JF_Request extends javax.swing.JFrame {

    /**
     * Creates new form JF_Request
     */
    public JF_Request() {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnBackRequest = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblWelcome = new javax.swing.JLabel();
        lblRequests1 = new javax.swing.JLabel();
        lblGroupList = new javax.swing.JLabel();
        lblTeamName1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblTeamName = new javax.swing.JLabel();
        lblMatchDate = new javax.swing.JLabel();
        lblStadium = new javax.swing.JLabel();
        lblFlag = new javax.swing.JLabel();
        txtTeamName1 = new javax.swing.JTextField();
        txtStadium = new javax.swing.JTextField();
        txtMatchDate = new javax.swing.JTextField();
        btnRequestGroupList = new javax.swing.JButton();
        lblMatchDateFormat = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtPlayer1Lastname = new javax.swing.JTextField();
        lblTeamName2 = new javax.swing.JLabel();
        txtTeamName3 = new javax.swing.JTextField();
        txtPlayer1Name = new javax.swing.JTextField();
        txtPlayer2Name = new javax.swing.JTextField();
        txtPlayer2Lastname = new javax.swing.JTextField();
        txtPosition = new javax.swing.JTextField();
        lblPlayer1Name = new javax.swing.JLabel();
        lblPlayer2Name = new javax.swing.JLabel();
        lblPlayer2Lastname = new javax.swing.JLabel();
        lblPlayer1Lastname = new javax.swing.JLabel();
        lblPosition = new javax.swing.JLabel();
        btnRequestTeamList = new javax.swing.JButton();
        lblTeamList = new javax.swing.JLabel();
        lblNewsList = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txtAuthorName = new javax.swing.JTextField();
        lblAuthorName = new javax.swing.JLabel();
        txtAuthorLastname = new javax.swing.JTextField();
        lblAuthorLastname = new javax.swing.JLabel();
        lblNewsDate = new javax.swing.JLabel();
        lblEvent = new javax.swing.JLabel();
        lblDateFormat = new javax.swing.JLabel();
        txtNewsDate = new javax.swing.JTextField();
        txtNewsEvent = new javax.swing.JTextField();
        btnRequestNewsList = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre*");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(86, 4, 44));

        btnBackRequest.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btnBackRequest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/back.png"))); // NOI18N
        btnBackRequest.setContentAreaFilled(false);
        btnBackRequest.setOpaque(true);
        btnBackRequest.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/backPressed.png"))); // NOI18N
        btnBackRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackRequestActionPerformed(evt);
            }
        });

        lblWelcome.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        lblWelcome.setForeground(new java.awt.Color(255, 255, 255));
        lblWelcome.setText("¡Bienvenid@!");
        lblWelcome.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblRequests1.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 36)); // NOI18N
        lblRequests1.setForeground(new java.awt.Color(255, 255, 255));
        lblRequests1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRequests1.setText("Consultas ");

        lblGroupList.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblGroupList.setForeground(new java.awt.Color(255, 255, 255));
        lblGroupList.setText("Rifa de grupos");

        lblTeamName1.setText("Nombre del equipo");

        lblTeamName.setText("Nombre del equipo");

        lblMatchDate.setText("Fecha del partido");

        lblStadium.setText("Estadio");

        lblFlag.setText("Bandera");

        btnRequestGroupList.setText("Consultar");
        btnRequestGroupList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestGroupListActionPerformed(evt);
            }
        });

        lblMatchDateFormat.setText("mm/dd/aaaa");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTeamName1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTeamName))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblMatchDateFormat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRequestGroupList)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtMatchDate, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtStadium, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblMatchDate)
                        .addGap(60, 60, 60)
                        .addComponent(lblStadium)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                        .addComponent(lblFlag)
                        .addGap(85, 85, 85))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTeamName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMatchDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStadium, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTeamName)
                    .addComponent(lblMatchDate)
                    .addComponent(lblStadium)
                    .addComponent(lblFlag))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnRequestGroupList))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblMatchDateFormat)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblTeamName2.setText("Nombre del equipo");

        txtTeamName3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTeamName3ActionPerformed(evt);
            }
        });

        txtPlayer1Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPlayer1NameActionPerformed(evt);
            }
        });

        lblPlayer1Name.setText("Nombre del jugador");

        lblPlayer2Name.setText("Segundo nombre");

        lblPlayer2Lastname.setText("Segundo Apellido");

        lblPlayer1Lastname.setText("Primer Apellido");

        lblPosition.setText("Posicion");

        btnRequestTeamList.setText("Consultar");
        btnRequestTeamList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestTeamListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTeamName3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTeamName2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(lblPlayer1Name, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtPlayer1Name, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(lblPlayer2Name, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 10, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtPlayer2Name, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPlayer1Lastname, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPlayer1Lastname, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPlayer2Lastname, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPlayer2Lastname, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRequestTeamList)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTeamName3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPlayer1Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPlayer2Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPlayer1Lastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTeamName2)
                    .addComponent(lblPlayer1Name)
                    .addComponent(lblPlayer2Name)
                    .addComponent(lblPlayer1Lastname))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPlayer2Lastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPosition)
                    .addComponent(lblPlayer2Lastname)
                    .addComponent(btnRequestTeamList))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        lblTeamList.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblTeamList.setForeground(new java.awt.Color(255, 255, 255));
        lblTeamList.setText("Listado de equipos");

        lblNewsList.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblNewsList.setForeground(new java.awt.Color(255, 255, 255));
        lblNewsList.setText("Listado de noticias");

        lblAuthorName.setText("Nombre del autor");

        lblAuthorLastname.setText("Apellido del autor");

        lblNewsDate.setText("Fecha de publicacion");

        lblEvent.setText("Evento");

        lblDateFormat.setText("mm/dd/aaaa");

        btnRequestNewsList.setText("Consultar");
        btnRequestNewsList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestNewsListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAuthorName, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAuthorName, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAuthorLastname, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAuthorLastname, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lblDateFormat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRequestNewsList)
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNewsDate, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNewsDate, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(lblEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 4, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(txtNewsEvent)
                                .addContainerGap())))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAuthorName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAuthorLastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNewsDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNewsEvent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAuthorName)
                    .addComponent(lblAuthorLastname)
                    .addComponent(lblEvent)
                    .addComponent(lblNewsDate))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDateFormat)
                    .addComponent(btnRequestNewsList))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBackRequest))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblTeamList)
                                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblGroupList))
                                        .addGap(227, 227, 227))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblNewsList)
                                        .addGap(270, 270, 270)))
                                .addComponent(lblTeamName1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1061, 1061, 1061)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(264, 264, 264)
                                        .addComponent(lblWelcome)
                                        .addGap(100, 100, 100))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblRequests1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(49, 49, 49)))
                                .addComponent(jLabel18)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(lblRequests1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblWelcome))
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblGroupList, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTeamName1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTeamList, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblNewsList, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addComponent(btnBackRequest))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRequestTeamListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestTeamListActionPerformed
        try {
            JF_RequestTeamList teamList = new JF_RequestTeamList();
            
            String teamName = txtTeamName3.getText();
            String playerFstName = txtPlayer1Name.getText();
            String playerSndName = txtPlayer2Name.getText();
            String playerFstLastName = txtPlayer1Lastname.getText();
            String playerSndLastName = txtPlayer2Lastname.getText();
            String position = txtPosition.getText();
            
            String outTeamName = "";
            String outPlayerFstName = "";
            String outPlayerSndName = "";
            String outPlayerFstLastName = "";
            String outPlayerSndLastName = "";
            String outPosition = "";

            if(!teamName.isEmpty()){
                outTeamName = teamName;
            }
            
            if(!playerFstName.isEmpty()){
                outPlayerFstName = playerFstName;
            }
            if(!playerSndName.isEmpty()){
                outPlayerSndName = playerSndName;
            }
            if(!playerFstLastName.isEmpty()){
                outPlayerFstLastName = playerFstLastName;
            }
            if(!playerSndLastName.isEmpty()){
                outPlayerSndLastName = playerSndLastName;
            }
            if(!position.isEmpty()){
                outPosition = position;
            }
            teamList.showTeamList(outTeamName,outPlayerFstName,outPlayerSndName,outPlayerFstLastName,outPlayerSndLastName,outPosition);
            
            
            teamList.setVisible(true);
            
        } catch (SQLException ex) {
            Logger.getLogger(JF_Request.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRequestTeamListActionPerformed

    private void btnRequestNewsListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestNewsListActionPerformed
        JF_RequestNewsList NewsList = new  JF_RequestNewsList();
        NewsList.setVisible(true);
    }//GEN-LAST:event_btnRequestNewsListActionPerformed

    private void btnRequestGroupListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestGroupListActionPerformed
        JF_RequestGroupList groupList = new JF_RequestGroupList();
            String teamName = txtTeamName1.getText();
            String matchDate = txtMatchDate.getText();
            String stadium = txtStadium.getText();
            //String teamFlag = 
            
            
            String outTeamName = "";
            String outMatchDate = "";
            String outStadium = "";
            //String outTeamFlag = "";
            
            if(!teamName.isEmpty()){
                outTeamName = teamName;
            }
            
            if(!matchDate.isEmpty()){
                outMatchDate = matchDate;
            }
            if(!stadium.isEmpty()){
                outStadium = stadium;
            
            groupList.setVisible(true);
            }                                                   


    }//GEN-LAST:event_btnRequestGroupListActionPerformed

    private void btnBackRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackRequestActionPerformed
        JF_Principal principal = new JF_Principal();
        principal.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnBackRequestActionPerformed

    private void txtTeamName3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTeamName3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTeamName3ActionPerformed

    private void txtPlayer1NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPlayer1NameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPlayer1NameActionPerformed

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
            java.util.logging.Logger.getLogger(JF_Request.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_Request.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_Request.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_Request.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JF_Request().setVisible(true);
            }
        });
    }
    
    //TeamList
    public JTextField getTxtTeamName3() {
        return txtTeamName3;
    }

    public JTextField getTxtPlayer1Name() {
        return txtPlayer1Name;
    }

    public JTextField getTxtPlayer2Name() {
        return txtPlayer2Name;
    }

    public JTextField getTxtPlayer1Lastname() {
        return txtPlayer1Lastname;
    }

    public JTextField getTxtPlayer2Lastname() {
        return txtPlayer2Lastname;
    }

    public JTextField getTxtPosition() {
        return txtPosition;
    }
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBackRequest;
    private javax.swing.JButton btnRequestGroupList;
    private javax.swing.JButton btnRequestNewsList;
    private javax.swing.JButton btnRequestTeamList;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblAuthorLastname;
    private javax.swing.JLabel lblAuthorName;
    private javax.swing.JLabel lblDateFormat;
    private javax.swing.JLabel lblEvent;
    private javax.swing.JLabel lblFlag;
    private javax.swing.JLabel lblGroupList;
    private javax.swing.JLabel lblMatchDate;
    private javax.swing.JLabel lblMatchDateFormat;
    private javax.swing.JLabel lblNewsDate;
    private javax.swing.JLabel lblNewsList;
    private javax.swing.JLabel lblPlayer1Lastname;
    private javax.swing.JLabel lblPlayer1Name;
    private javax.swing.JLabel lblPlayer2Lastname;
    private javax.swing.JLabel lblPlayer2Name;
    private javax.swing.JLabel lblPosition;
    private javax.swing.JLabel lblRequests1;
    private javax.swing.JLabel lblStadium;
    private javax.swing.JLabel lblTeamList;
    private javax.swing.JLabel lblTeamName;
    private javax.swing.JLabel lblTeamName1;
    private javax.swing.JLabel lblTeamName2;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JTextField txtAuthorLastname;
    private javax.swing.JTextField txtAuthorName;
    private javax.swing.JTextField txtMatchDate;
    private javax.swing.JTextField txtNewsDate;
    private javax.swing.JTextField txtNewsEvent;
    private javax.swing.JTextField txtPlayer1Lastname;
    private javax.swing.JTextField txtPlayer1Name;
    private javax.swing.JTextField txtPlayer2Lastname;
    private javax.swing.JTextField txtPlayer2Name;
    private javax.swing.JTextField txtPosition;
    private javax.swing.JTextField txtStadium;
    private javax.swing.JTextField txtTeamName1;
    private javax.swing.JTextField txtTeamName3;
    // End of variables declaration//GEN-END:variables
}
