/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Sanjeewa Kulathunga
 */
public class MyReservations extends javax.swing.JFrame {

    /**
     * Creates new form MyMediaList
     */
    public MyReservations() {
        initComponents();
    }

    public JButton getBtnexm1() {
        return btnexm1;
    }

    public JButton getBtnexm2() {
        return btnexm2;
    }

    public JButton getBtnexm3() {
        return btnexm3;
    }

    public JButton getBtnmedia1() {
        return btnmedia1;
    }

    public JButton getBtnmedia2() {
        return btnmedia2;
    }

    public JButton getBtnmedia3() {
        return btnmedia3;
    }

    public JButton getBtnrtm1() {
        return btnrtm1;
    }

    public JButton getBtnrtm2() {
        return btnrtm2;
    }

    public JButton getBtnrtm3() {
        return btnrtm3;
    }

    public JLabel getLblAvailableM1() {
        return lblAvailableM1;
    }

    public JLabel getLblAvailableM2() {
        return lblAvailableM2;
    }

    public JLabel getLblAvailableM3() {
        return lblAvailableM3;
    }
    public int DisplayConfirmBox(String error){
        return JOptionPane.showConfirmDialog(this,error, "Digital Library",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
    }
    public void DisplayInfo(String info){
        JOptionPane.showMessageDialog(this,info,"Alert",JOptionPane.INFORMATION_MESSAGE);
    }
    public void addExtend1Listener(ActionListener listnerforbutton){
        btnexm1.addActionListener(listnerforbutton);
    }
    public void addExtend2Listener(ActionListener listnerforbutton){
        btnexm2.addActionListener(listnerforbutton);
    }
    public void addExtend3Listener(ActionListener listnerforbutton){
        btnexm3.addActionListener(listnerforbutton);
    }
    public void addReturnM1Listener(ActionListener listnerforbutton){
        btnrtm1.addActionListener(listnerforbutton);
    }
    public void addReturnM2Listener(ActionListener listnerforbutton){
        btnrtm2.addActionListener(listnerforbutton);
    }
    public void addReturnM3Listener(ActionListener listnerforbutton){
        btnrtm3.addActionListener(listnerforbutton);
    }
    public void addMediaListener(ActionListener listnerforbutton){
        btnmedia1.addActionListener(listnerforbutton);
        btnmedia2.addActionListener(listnerforbutton);
        btnmedia3.addActionListener(listnerforbutton);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnrtm1 = new javax.swing.JButton();
        lblAvailableM1 = new javax.swing.JLabel();
        btnexm1 = new javax.swing.JButton();
        btnmedia1 = new javax.swing.JButton();
        lblAvailableM2 = new javax.swing.JLabel();
        btnmedia2 = new javax.swing.JButton();
        btnexm2 = new javax.swing.JButton();
        btnrtm2 = new javax.swing.JButton();
        lblAvailableM3 = new javax.swing.JLabel();
        btnmedia3 = new javax.swing.JButton();
        btnexm3 = new javax.swing.JButton();
        btnrtm3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 175, 240));
        jPanel1.setPreferredSize(new java.awt.Dimension(1024, 160));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/reservations.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(216, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(168, 168, 168))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        jPanel2.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Click on each media to view");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(0, 10, 1020, 20);

        btnrtm1.setBackground(new java.awt.Color(204, 255, 204));
        btnrtm1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnrtm1.setText("Return Media");
        jPanel2.add(btnrtm1);
        btnrtm1.setBounds(50, 580, 280, 40);

        lblAvailableM1.setBackground(new java.awt.Color(255, 255, 0));
        lblAvailableM1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblAvailableM1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAvailableM1.setText("Available until 2022-01-10");
        lblAvailableM1.setOpaque(true);
        jPanel2.add(lblAvailableM1);
        lblAvailableM1.setBounds(50, 50, 280, 30);

        btnexm1.setBackground(new java.awt.Color(204, 255, 204));
        btnexm1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnexm1.setText("Extend Time");
        jPanel2.add(btnexm1);
        btnexm1.setBounds(50, 520, 280, 40);

        btnmedia1.setBackground(new java.awt.Color(255, 255, 0));
        btnmedia1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Media/blank.jpg"))); // NOI18N
        jPanel2.add(btnmedia1);
        btnmedia1.setBounds(50, 80, 280, 420);

        lblAvailableM2.setBackground(new java.awt.Color(255, 255, 0));
        lblAvailableM2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblAvailableM2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAvailableM2.setText("Available until 2022-01-10");
        lblAvailableM2.setOpaque(true);
        jPanel2.add(lblAvailableM2);
        lblAvailableM2.setBounds(380, 50, 280, 30);

        btnmedia2.setBackground(new java.awt.Color(255, 255, 0));
        btnmedia2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Media/blank.jpg"))); // NOI18N
        jPanel2.add(btnmedia2);
        btnmedia2.setBounds(380, 80, 280, 420);

        btnexm2.setBackground(new java.awt.Color(204, 255, 204));
        btnexm2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnexm2.setText("Extend Time");
        jPanel2.add(btnexm2);
        btnexm2.setBounds(380, 520, 280, 40);

        btnrtm2.setBackground(new java.awt.Color(204, 255, 204));
        btnrtm2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnrtm2.setText("Return Media");
        jPanel2.add(btnrtm2);
        btnrtm2.setBounds(380, 580, 280, 40);

        lblAvailableM3.setBackground(new java.awt.Color(255, 255, 0));
        lblAvailableM3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblAvailableM3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAvailableM3.setText("Available until 2022-01-10");
        lblAvailableM3.setOpaque(true);
        jPanel2.add(lblAvailableM3);
        lblAvailableM3.setBounds(700, 50, 280, 30);

        btnmedia3.setBackground(new java.awt.Color(255, 255, 0));
        btnmedia3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Media/blank.jpg"))); // NOI18N
        jPanel2.add(btnmedia3);
        btnmedia3.setBounds(700, 80, 280, 420);

        btnexm3.setBackground(new java.awt.Color(204, 255, 204));
        btnexm3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnexm3.setText("Extend Time");
        jPanel2.add(btnexm3);
        btnexm3.setBounds(700, 520, 280, 40);

        btnrtm3.setBackground(new java.awt.Color(204, 255, 204));
        btnrtm3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnrtm3.setText("Return Media");
        jPanel2.add(btnrtm3);
        btnrtm3.setBounds(700, 580, 280, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/back.jpg"))); // NOI18N
        jPanel2.add(jLabel1);
        jLabel1.setBounds(0, -20, 1024, 660);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnexm1;
    private javax.swing.JButton btnexm2;
    private javax.swing.JButton btnexm3;
    private javax.swing.JButton btnmedia1;
    private javax.swing.JButton btnmedia2;
    private javax.swing.JButton btnmedia3;
    private javax.swing.JButton btnrtm1;
    private javax.swing.JButton btnrtm2;
    private javax.swing.JButton btnrtm3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblAvailableM1;
    private javax.swing.JLabel lblAvailableM2;
    private javax.swing.JLabel lblAvailableM3;
    // End of variables declaration//GEN-END:variables
}
