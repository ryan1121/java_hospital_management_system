/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hospital_management_system;

/**
 *
 * @author yc
 */
public class Data_Tables extends javax.swing.JFrame {

    /**
     * Creates new form Data_Tables
     */
    public Data_Tables() {
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

        TitleLabel = new javax.swing.JLabel();
        SelectRoleLabel = new javax.swing.JLabel();
        DoctorRoleButton = new javax.swing.JButton();
        AdminRoleButton = new javax.swing.JButton();
        NurseRoleButton = new javax.swing.JButton();
        PatientRoleButton = new javax.swing.JButton();
        PatientRoleButton1 = new javax.swing.JButton();
        SelectRoleLabel1 = new javax.swing.JLabel();
        PatientRoleButton2 = new javax.swing.JButton();
        PatientRoleButton3 = new javax.swing.JButton();
        NurseRoleButton1 = new javax.swing.JButton();
        AdminRoleButton1 = new javax.swing.JButton();
        DoctorRoleButton1 = new javax.swing.JButton();
        DoctorRoleButton2 = new javax.swing.JButton();
        PatientRoleButton4 = new javax.swing.JButton();
        AdminRoleButton2 = new javax.swing.JButton();
        PatientRoleButton5 = new javax.swing.JButton();
        NurseRoleButton2 = new javax.swing.JButton();
        PatientRoleButton6 = new javax.swing.JButton();
        PatientRoleButton7 = new javax.swing.JButton();
        DoctorRoleButton3 = new javax.swing.JButton();
        AdminRoleButton3 = new javax.swing.JButton();
        NurseRoleButton3 = new javax.swing.JButton();
        PatientRoleButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TitleLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TitleLabel.setText("Hospital Management System");

        SelectRoleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SelectRoleLabel.setText("-- Please select the data tables for checking --");

        DoctorRoleButton.setText("Patient");
        DoctorRoleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DoctorRoleButtonActionPerformed(evt);
            }
        });

        AdminRoleButton.setText("Patient Care");

        NurseRoleButton.setText("Prescription");

        PatientRoleButton.setText("Diagnoses");

        PatientRoleButton1.setText("Staff Schedule");

        SelectRoleLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SelectRoleLabel1.setText("Welcome back, ");

        PatientRoleButton2.setText("Inventory");

        PatientRoleButton3.setText("Patient History");

        NurseRoleButton1.setText("Medical Records");

        AdminRoleButton1.setText("Admission");

        DoctorRoleButton1.setText("Doctor");
        DoctorRoleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DoctorRoleButton1ActionPerformed(evt);
            }
        });

        DoctorRoleButton2.setText("Nurse");
        DoctorRoleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DoctorRoleButton2ActionPerformed(evt);
            }
        });

        PatientRoleButton4.setText("Medical Supply");

        AdminRoleButton2.setText("Appointment");

        PatientRoleButton5.setText("Billing");

        NurseRoleButton2.setText("Surgeries");

        PatientRoleButton6.setText("Payment");

        PatientRoleButton7.setText("Patient Transfer");

        DoctorRoleButton3.setText("Admin");
        DoctorRoleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DoctorRoleButton3ActionPerformed(evt);
            }
        });

        AdminRoleButton3.setText("Bed Allocation");

        NurseRoleButton3.setText("Consultations");

        PatientRoleButton8.setText("Invoice");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SelectRoleLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DoctorRoleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AdminRoleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NurseRoleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PatientRoleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PatientRoleButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PatientRoleButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PatientRoleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(NurseRoleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AdminRoleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DoctorRoleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PatientRoleButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NurseRoleButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AdminRoleButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PatientRoleButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DoctorRoleButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DoctorRoleButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AdminRoleButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NurseRoleButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PatientRoleButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PatientRoleButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(PatientRoleButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(61, Short.MAX_VALUE))
            .addComponent(SelectRoleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(TitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TitleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SelectRoleLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SelectRoleLabel)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NurseRoleButton1)
                            .addComponent(AdminRoleButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PatientRoleButton3)
                            .addComponent(NurseRoleButton3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DoctorRoleButton)
                            .addComponent(DoctorRoleButton1)
                            .addComponent(DoctorRoleButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AdminRoleButton)
                            .addComponent(AdminRoleButton1)
                            .addComponent(DoctorRoleButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(NurseRoleButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PatientRoleButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PatientRoleButton1)
                            .addComponent(PatientRoleButton5)
                            .addComponent(PatientRoleButton6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PatientRoleButton8)
                            .addComponent(AdminRoleButton2)
                            .addComponent(PatientRoleButton7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PatientRoleButton2)
                            .addComponent(NurseRoleButton2)
                            .addComponent(PatientRoleButton4))))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DoctorRoleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DoctorRoleButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DoctorRoleButtonActionPerformed

    private void DoctorRoleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DoctorRoleButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DoctorRoleButton1ActionPerformed

    private void DoctorRoleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DoctorRoleButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DoctorRoleButton2ActionPerformed

    private void DoctorRoleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DoctorRoleButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DoctorRoleButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Data_Tables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Data_Tables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Data_Tables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Data_Tables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Data_Tables().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdminRoleButton;
    private javax.swing.JButton AdminRoleButton1;
    private javax.swing.JButton AdminRoleButton2;
    private javax.swing.JButton AdminRoleButton3;
    private javax.swing.JButton DoctorRoleButton;
    private javax.swing.JButton DoctorRoleButton1;
    private javax.swing.JButton DoctorRoleButton2;
    private javax.swing.JButton DoctorRoleButton3;
    private javax.swing.JButton NurseRoleButton;
    private javax.swing.JButton NurseRoleButton1;
    private javax.swing.JButton NurseRoleButton2;
    private javax.swing.JButton NurseRoleButton3;
    private javax.swing.JButton PatientRoleButton;
    private javax.swing.JButton PatientRoleButton1;
    private javax.swing.JButton PatientRoleButton2;
    private javax.swing.JButton PatientRoleButton3;
    private javax.swing.JButton PatientRoleButton4;
    private javax.swing.JButton PatientRoleButton5;
    private javax.swing.JButton PatientRoleButton6;
    private javax.swing.JButton PatientRoleButton7;
    private javax.swing.JButton PatientRoleButton8;
    private javax.swing.JLabel SelectRoleLabel;
    private javax.swing.JLabel SelectRoleLabel1;
    private javax.swing.JLabel TitleLabel;
    // End of variables declaration//GEN-END:variables
}