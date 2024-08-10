/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hospital_management_system.views;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import hospital_management_system.MysqlConnect;



/**
 *
 * @author User
 */
public class GUI_LOGIN extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */

    // Define a variable to store the role type of login user
    String role;
    MysqlConnect db;

    public GUI_LOGIN(String role_type) {
        initComponents();
        if (!(role_type == "Patient")){ // if the role type is not patient
            register.setVisible(false); // disable the register button
        }

        this.role = role_type;  // assign the login role type to the variable
        db = new MysqlConnect();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        Username = new javax.swing.JTextPane();
        Password = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        register = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        login = new javax.swing.JButton();
        backButton = new javax.swing.JLabel();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Username.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Password.setText("jPasswordField1");

        jLabel1.setText("Password");

        jLabel2.setText("User ID");

        register.setForeground(new java.awt.Color(0, 51, 255));
        register.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        register.setText("Register");
        register.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                registerMousePressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("LOGIN");

        login.setText("Login");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        backButton.setForeground(new java.awt.Color(0, 51, 255));
        backButton.setText("Back");
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                backButtonMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(register, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 37, Short.MAX_VALUE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(register, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(login))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        // TODO add your handling code here:
        String ID = Username.getText();
        String password = new String(Password.getPassword());

        if (validateLogin(ID, password)) {
            JOptionPane.showMessageDialog(jFrame1, "Login successfully!");
            String name = getUserName(ID);
            if (!(this.role == "Patient")){ // if the role type is not patient
                this.dispose();
                // Create an object for the home page gui
                Home_Page_GUI homepage_GUI = new Home_Page_GUI(this.role, name);
                homepage_GUI.setVisible(true);
            } else {    // if the role type is patient
                GUI_patient PatientGUI = new GUI_patient(ID);
                PatientGUI.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(jFrame1, "Login Failed, please try again!");
        }
    }//GEN-LAST:event_loginActionPerformed

    private String getUserName(String userID) {
        String userName = null;
    
        String query = "";
        switch (role) {
            case "Admin":
                query = "SELECT admin_name FROM Admin WHERE admin_id = ?";
                break;
            case "Nurse":
                query = "SELECT nurse_name FROM Nurse WHERE nurse_id = ?";
                break;
            case "Doctor":
                query = "SELECT doctor_name FROM Doctors WHERE doctor_id = ?";
                break;
            case "Patient":
                query = "SELECT patient_name FROM Patients WHERE patient_id = ?";
                break;
            default:
                System.out.println("Invalid role");
                return null;
        }

        Connection conn = db.getConnection(); // Assuming you have this method to get the connection
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, userID);
            ResultSet rs = stmt.executeQuery();
            
            if (rs != null && rs.next()) {
                userName = rs.getString(1); // Get the first column in the result set
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return userName;

        // try (ResultSet rs = db.executeQuery(query)) {
        //     if (rs != null && rs.next()) {
        //         userName = rs.getString(1); // Get the first column in the result set
        //     }
        // } catch (SQLException e) {
        //     e.printStackTrace();
        // }
        
        // return userName;
    }

    private boolean validateLogin(String userID, String pw) {
        String query = "";
        switch (role) {
            case "Admin":
                query = "SELECT * FROM Admin WHERE admin_id = '" + userID + "' AND admin_password = '" + pw + "'";
                break;
            case "Nurse":
                query = "SELECT * FROM Nurse WHERE nurse_id = '" + userID + "' AND nurse_password = '" + pw + "'";
                break;
            case "Doctor":
                query = "SELECT * FROM Doctors WHERE doctor_id = '" + userID + "' AND doctor_password = '" + pw + "'";
                break;
            case "Patient":
                query = "SELECT * FROM Patients WHERE patient_id = '" + userID + "' AND patient_password = '" + pw + "'";
                break;
            default:
                return false;
        }

        try (ResultSet rs = db.executeQuery(query)) {
            if (rs != null && rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void registerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerMousePressed
        // TODO add your handling code here:
        this.dispose();

        GUI_Patient_Register Patient_Register_GUI = new GUI_Patient_Register();
        Patient_Register_GUI.setVisible(true);
    }//GEN-LAST:event_registerMousePressed

    private void backButtonMousePressed(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        this.dispose();

        Role_Page_GUI Role = new Role_Page_GUI();
        Role.setVisible(true);
    }

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
            java.util.logging.Logger.getLogger(GUI_LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_LOGIN("Nurse").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField Password;
    private javax.swing.JTextPane Username;
    private javax.swing.JLabel backButton;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton login;
    private javax.swing.JLabel register;
    // End of variables declaration//GEN-END:variables
}
