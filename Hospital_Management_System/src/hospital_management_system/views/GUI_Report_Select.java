/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hospital_management_system.views;

import hospital_management_system.controllers.*;
import javax.swing.*;
import java.awt.Cursor;


/**
 *
 * @author DELL
 */
public class GUI_Report_Select extends JFrame {
    private String role;
    private String username;
    
    /**
     * Creates new form GUI_Report_Select
     */
    public GUI_Report_Select(String role, String username) {
        this.role = role;
        this.username = username;
        
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

        jLabel1 = new JLabel();
        SelectReport = new JLabel();
        SelectRoleLabel = new JLabel();
        AgeGroupStatsButton = new JButton();
        DepartmentDoctorStatsButton = new JButton();
        InsuranceStatsButton = new JButton();
        InventoryStatsButton = new JButton();
        SurgeryStatsButton = new JButton();
        MonthlyInvoiceStatButton = new JButton();
        MonthlyPaymentStatButton = new JButton();
        ExpiringMedicalSuppliesButton = new JButton();
        backButton = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("Reporting and Analytics");

        SelectReport.setHorizontalAlignment(SwingConstants.CENTER);
        SelectReport.setText("What would you like to do?");

        SelectRoleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        SelectRoleLabel.setText("Welcome back, ");

        AgeGroupStatsButton.setText("Age Group Stats");
        AgeGroupStatsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgeGroupStatsButtonActionPerformed(evt);
            }
        });

        DepartmentDoctorStatsButton.setText("Department Doctor Stats");
        DepartmentDoctorStatsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DepartmentDoctorStatsButtonActionPerformed(evt);
            }
        });

        InsuranceStatsButton.setText("Insurance Stats");
        InsuranceStatsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsuranceStatsButtonActionPerformed(evt);
            }
        });

        InventoryStatsButton.setText("Inventory Stats");
        InventoryStatsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InventoryStatsButtonActionPerformed(evt);
            }
        });

        SurgeryStatsButton.setText("Surgery Stats");
        SurgeryStatsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SurgeryStatsButtonActionPerformed(evt);
            }
        });

        MonthlyInvoiceStatButton.setText("Monthyly Invoice Stats");
        MonthlyInvoiceStatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonthlyInvoiceStatButtonActionPerformed(evt);
            }
        });

        MonthlyPaymentStatButton.setText("Monthyly Payment Stats");
        MonthlyPaymentStatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonthlyPaymentStatButtonActionPerformed(evt);
            }
        });

        ExpiringMedicalSuppliesButton.setText("Expiring Medical Supplies");
        ExpiringMedicalSuppliesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExpiringMedicalSuppliesButtonActionPerformed(evt);
            }
        });

        backButton.setForeground(new java.awt.Color(0, 51, 255));
        backButton.setHorizontalAlignment(SwingConstants.LEFT);
        backButton.setText("Back");
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                // Implement the back functionality here
                backButtonActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 49, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(DepartmentDoctorStatsButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SurgeryStatsButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(InsuranceStatsButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AgeGroupStatsButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(ExpiringMedicalSuppliesButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(InventoryStatsButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(MonthlyPaymentStatButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(MonthlyInvoiceStatButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(52, 52, 52))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(backButton, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SelectRoleLabel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SelectReport, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SelectRoleLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(SelectReport, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(AgeGroupStatsButton)
                    .addComponent(MonthlyInvoiceStatButton))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(MonthlyPaymentStatButton)
                    .addComponent(InsuranceStatsButton))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(InventoryStatsButton)
                    .addComponent(SurgeryStatsButton))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(DepartmentDoctorStatsButton)
                    .addComponent(ExpiringMedicalSuppliesButton))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.MouseEvent evt){
        this.dispose();
        // Create an object for the home page gui
        Home_Page_GUI homepage_GUI = new Home_Page_GUI(this.role, this.username);
        homepage_GUI.setVisible(true);
    }

    private void MonthlyPaymentStatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonthlyPaymentStatButtonActionPerformed
        // TODO add your handling code here:
        MonthlyPaymentStats monthlyPaymentStatsObj = new MonthlyPaymentStats();
        monthlyPaymentStatsObj.showMonthlyPaymentStats();
        
    }//GEN-LAST:event_MonthlyPaymentStatButtonActionPerformed

    private void ExpiringMedicalSuppliesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExpiringMedicalSuppliesButtonActionPerformed
        // TODO add your handling code here:
        ExpiringMedicalSupplies expiringMedicalSuppliesObj = new ExpiringMedicalSupplies();
        expiringMedicalSuppliesObj.showExpiringMedicalSupplies();
    }//GEN-LAST:event_ExpiringMedicalSuppliesButtonActionPerformed

    private void AgeGroupStatsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgeGroupStatsButtonActionPerformed
        // TODO add your handling code here:
        AgeGroupStats AgeGroupStatsObj = new AgeGroupStats();
        AgeGroupStatsObj.showAgeGroupStats();
    }//GEN-LAST:event_AgeGroupStatsButtonActionPerformed

    private void InsuranceStatsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsuranceStatsButtonActionPerformed
        // TODO add your handling code here:
        InsuranceStats InsuranceStatsObj = new InsuranceStats();
        InsuranceStatsObj.showInsuranceStats();
    }//GEN-LAST:event_InsuranceStatsButtonActionPerformed

    private void SurgeryStatsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SurgeryStatsButtonActionPerformed
        // TODO add your handling code here:
        SurgeryStats SurgeryStatsObj = new SurgeryStats();
        SurgeryStatsObj.showSurgeryStats();
    }//GEN-LAST:event_SurgeryStatsButtonActionPerformed

    private void DepartmentDoctorStatsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DepartmentDoctorStatsButtonActionPerformed
        // TODO add your handling code here:
        DepartmentDoctorStats DepartmentDoctorStatsObj = new DepartmentDoctorStats();
        DepartmentDoctorStatsObj.showDepartmentDoctorStats();
    }//GEN-LAST:event_DepartmentDoctorStatsButtonActionPerformed

    private void MonthlyInvoiceStatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonthlyInvoiceStatButtonActionPerformed
        // TODO add your handling code here:
        MonthlyInvoiceStats MonthlyInvoiceStatObj = new MonthlyInvoiceStats();
        MonthlyInvoiceStatObj.showMonthlyInvoiceStats();
    }//GEN-LAST:event_MonthlyInvoiceStatButtonActionPerformed

    private void InventoryStatsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InventoryStatsButtonActionPerformed
        // TODO add your handling code here:
        InventoryStats InventoryStatsObj = new InventoryStats();
        InventoryStatsObj.showInventoryStats();
    }//GEN-LAST:event_InventoryStatsButtonActionPerformed

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
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI_Report_Select.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Report_Select.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Report_Select.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Report_Select.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Report_Select().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton AgeGroupStatsButton;
    private JButton DepartmentDoctorStatsButton;
    private JButton ExpiringMedicalSuppliesButton;
    private JButton InsuranceStatsButton;
    private JButton InventoryStatsButton;
    private JButton MonthlyInvoiceStatButton;
    private JButton MonthlyPaymentStatButton;
    private JLabel SelectReport;
    private JLabel SelectRoleLabel;
    private JButton SurgeryStatsButton;
    private JLabel backButton;
    private JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
