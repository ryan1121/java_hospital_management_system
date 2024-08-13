/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hospital_management_system.views;

import java.awt.Cursor;

/**
 *
 * @author yc
 */
public class Home_Page_GUI extends javax.swing.JFrame {

    /**
     * Creates new form test
     */
    
    // Define a variable to store the role type of login user
    String role;
    public static String username;

    public Home_Page_GUI(String role_type, String username) {
        initComponents();
        
        this.username = username; 
        this.role = role_type;  // assign the login role type to the variable
        SelectRoleLabel.setText("Welcome back, " + this.username);

        if (this.role == "Admin"){  // 只有admin可以看见以及使用data analysis的按钮
            dataAnalysisButton.setVisible(true);
        }
        // Set the initial size of the window
        this.setSize(415, 291);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TitleLabel = new javax.swing.JLabel();
        SelectRoleLabel = new javax.swing.JLabel();
        ManageInformationButton = new javax.swing.JButton();
        CheckDataButton = new javax.swing.JButton();
        SelectRoleLabel1 = new javax.swing.JLabel();
        dataAnalysisButton = new javax.swing.JButton();
        dataAnalysisButton.setVisible(false);
        LogoutButton = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TitleLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TitleLabel.setText("Hospital Management System");

        SelectRoleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SelectRoleLabel.setText("Welcome back, ");

        ManageInformationButton.setText("Manage Information");
        ManageInformationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManageInformationButtonActionPerformed(evt);
            }
        });

        CheckDataButton.setText("Check Data");
        CheckDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckDataButtonActionPerformed(evt);
            }
        });


        SelectRoleLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SelectRoleLabel1.setText("What would you like to do?");

        dataAnalysisButton.setText("Data Analysis");
        dataAnalysisButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataAnalysisButtonActionPerformed(evt);
            }
        });

        LogoutButton.setForeground(new java.awt.Color(255, 0, 0));
        LogoutButton.setText("Log Out");
        LogoutButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        LogoutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LogoutButtonMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(SelectRoleLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TitleLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SelectRoleLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(81, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(dataAnalysisButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ManageInformationButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CheckDataButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(177, 177, 177)
                .addComponent(LogoutButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TitleLabel)
                .addGap(18, 18, 18)
                .addComponent(SelectRoleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SelectRoleLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(ManageInformationButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CheckDataButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dataAnalysisButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LogoutButton)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ManageInformationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManageInformationButtonActionPerformed
        // TODO add your handling code here:

        // Check the role type and open the corresponding user interface
        if (this.role == "Doctor"){
            this.dispose(); // close the current GUI

            GUI_doctor Doctor_GUI = new GUI_doctor(this.username);
            Doctor_GUI.setVisible(true);
        } else if (this.role == "Nurse"){
            this.dispose(); // close the current GUI

            GUI_nurse Nurse_GUI = new GUI_nurse();
            Nurse_GUI.setVisible(true);
        } else if (this.role == "Admin"){
            this.dispose(); // close the current GUI

            GUI_admin Admin_GUI = new GUI_admin();
            Admin_GUI.setVisible(true);
        } else {    // this.role == "Patient"
            this.dispose(); // close the current GUI

            GUI_patient Patient_GUI = new GUI_patient();
            Patient_GUI.setVisible(true);
        }
    }//GEN-LAST:event_ManageInformationButtonActionPerformed

    private void CheckDataButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        // TODO add your handling code here:
        this.dispose();
        Data_Tables DataTableObj = new Data_Tables(this.role, this.username);

        DataTableObj.setVisible(true);
    }                                                  

    private void dataAnalysisButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataAnalysisButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
        GUI_Report_Select reportSelectGUI = new GUI_Report_Select(this.role, this.username);
        reportSelectGUI.setVisible(true);
    }//GEN-LAST:event_dataAnalysisButtonActionPerformed

    private void LogoutButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMousePressed
        // TODO add your handling code here:
        this.dispose();
    }
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CheckDataButton;
    private javax.swing.JLabel LogoutButton;
    private javax.swing.JButton ManageInformationButton;
    private javax.swing.JLabel SelectRoleLabel;
    private javax.swing.JLabel SelectRoleLabel1;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JButton dataAnalysisButton;
    // End of variables declaration//GEN-END:variables
}
