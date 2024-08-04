/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hospital_management_system.views;

import java.util.Arrays;
import java.util.List;

import javax.management.relation.Role;
import javax.swing.JButton;
/**
 *
 * @author yc
 */
public class Data_Tables extends javax.swing.JFrame {
    private javax.swing.JButton PatientButton;
    private javax.swing.JButton AdminRoleButton;
    private javax.swing.JButton PrescriptionButton;
    private javax.swing.JButton DiagnosisButton;
    private javax.swing.JButton NurseStaffScheduleButton;
    private javax.swing.JButton InventotryButton;
    private javax.swing.JButton PatientHistoryButton;
    private javax.swing.JButton MedicalRecordsButton;
    private javax.swing.JButton AdmissionButton;
    private javax.swing.JButton DoctorButton;
    private javax.swing.JButton NurseButton;
    private javax.swing.JButton MedicalSupplyButton;
    private javax.swing.JButton AppointmentButton;
    private javax.swing.JButton BillingButton;
    private javax.swing.JButton SurgeryButton;
    private javax.swing.JButton PaymentButton;
    private javax.swing.JButton PatientTransferButton;
    private javax.swing.JButton AdminButton;
    private javax.swing.JButton BedAllocationButton;
    private javax.swing.JButton ConsultationsButton;
    private javax.swing.JButton InvoiceButton;
    private javax.swing.JLabel SelectRoleLabel;
    private javax.swing.JLabel SelectRoleLabel1;
    private javax.swing.JLabel TitleLabel;
    
    public List<String> getAllowedButtons(String role) {
        System.out.println("Current role is " + role);
        
        if (role.equals("Admin")) {
            return Arrays.asList("AdminButton", "PatientButton", "DoctorButton", "NurseButton", "PrescriptionButton", "DiagnosisButton", "NurseStaffScheduleButton", "InvoiceButton", "InventotryButton", "MedicalRecordsButton", "AdmissionButton", "BillingButton", "SurgeryButton", "PaymentButton", "PatientTransferButton", "BedAllocationButton", "ConsultationsButton", "MedicalSupplyButton", "AppointmentButton", "PatientHistoryButton");
        } else if (role.equals("Doctor")) {
            return Arrays.asList("PatientButton", "DoctorButton", "PrescriptionButton", "DiagnosisButton", "InvoiceButton", "MedicalRecordsButton", "AdmissionButton", "BillingButton", "SurgeryButton", "PaymentButton", "PatientTransferButton", "ConsultationsButton", "MedicalSupplyButton", "AppointmentButton", "PatientHistoryButton");
        } else if (role.equals("Nurse")) {
            return Arrays.asList("PatientButton", "NurseButton", "DiagnosisButton", "NurseStaffScheduleButton", "InvoiceButton", "InventotryButton", "MedicalRecordsButton", "AdmissionButton", "BillingButton", "SurgeryButton", "PaymentButton", "PatientTransferButton", "BedAllocationButton", "ConsultationsButton", "MedicalSupplyButton", "AppointmentButton", "PatientHistoryButton");
        } else {
            return Arrays.asList();
    }
    }

    public Data_Tables(String role) {
        initComponents();
        configureButtons(role);
    }
    
    private void configureButtons(String role) {
        List<String> allowedButtons = getAllowedButtons(role);
    
        for (java.awt.Component comp : getContentPane().getComponents()) {
            if (comp instanceof javax.swing.JButton) {
                javax.swing.JButton button = (javax.swing.JButton) comp;
                if (!allowedButtons.contains(button.getName())) {
                    button.setVisible(false);
                }
            }
        }
    }
    
    
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
        setTitle("Hospital Management System");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        java.awt.GridBagLayout layout = new java.awt.GridBagLayout();
        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
        getContentPane().setLayout(layout);
    
        TitleLabel = new javax.swing.JLabel();
        TitleLabel.setFont(new java.awt.Font("Segoe UI", 1, 18));
        TitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TitleLabel.setText("Hospital Management System");
    
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(TitleLabel, gbc);
    
        SelectRoleLabel1 = new javax.swing.JLabel();
        SelectRoleLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SelectRoleLabel1.setText("Welcome back, ");
        gbc.gridy = 1;
        getContentPane().add(SelectRoleLabel1, gbc);
    
        SelectRoleLabel = new javax.swing.JLabel();
        SelectRoleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SelectRoleLabel.setText("-- Please select the data tables for checking --");
        gbc.gridy = 2;
        getContentPane().add(SelectRoleLabel, gbc);
    
        // Initialize buttons
        initButton(PatientButton = new javax.swing.JButton(), "Patients", gbc, 0, 3);
        initButton(AdminRoleButton = new javax.swing.JButton(), "DoctorStaffScheduling", gbc, 1, 3);
        initButton(PrescriptionButton = new javax.swing.JButton(), "Prescription", gbc, 0, 4);
        initButton(DiagnosisButton = new javax.swing.JButton(), "Diagnosis", gbc, 1, 4);
        initButton(NurseStaffScheduleButton = new javax.swing.JButton(), "NurseStaffScheduling", gbc, 0, 5);
        initButton(InventotryButton = new javax.swing.JButton(), "InventoryManagement", gbc, 0, 6);
        initButton(PatientHistoryButton = new javax.swing.JButton(), "PatientHistory", gbc, 1, 6);
        initButton(MedicalRecordsButton = new javax.swing.JButton(), "MedicalRecords", gbc, 0, 7);
        initButton(AdmissionButton = new javax.swing.JButton(), "Admission", gbc, 1, 7);
        initButton(DoctorButton = new javax.swing.JButton(), "Doctors", gbc, 0, 8);
        initButton(NurseButton = new javax.swing.JButton(), "Nurse", gbc, 1, 8);
        initButton(MedicalSupplyButton = new javax.swing.JButton(), "MedicalSupplyManagement", gbc, 2, 8);
        initButton(AppointmentButton = new javax.swing.JButton(), "Appointment", gbc, 0, 9);
        initButton(BillingButton = new javax.swing.JButton(), "Billing", gbc, 1, 9);
        initButton(SurgeryButton = new javax.swing.JButton(), "Surgery", gbc, 0, 10);
        initButton(PaymentButton = new javax.swing.JButton(), "Payment", gbc, 1, 10);
        initButton(PatientTransferButton = new javax.swing.JButton(), "TransferManagement", gbc, 2, 10);
        initButton(AdminButton = new javax.swing.JButton(), "Admin", gbc, 2, 3);
        initButton(BedAllocationButton = new javax.swing.JButton(), "BedAllocation", gbc, 2, 4);
        initButton(ConsultationsButton = new javax.swing.JButton(), "Consultations", gbc, 2, 5);
        initButton(InvoiceButton = new javax.swing.JButton(), "Invoice", gbc, 2, 6);

        pack();
    }
    
    private void initButton(JButton button, String tableName, java.awt.GridBagConstraints gbc, int gridx, int gridy) {
        button.setText(tableName);
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        add(button, gbc);
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActionPerformed(evt, tableName);
            }
        });
    }

    
    private void buttonActionPerformed(java.awt.event.ActionEvent evt, String tableName) {
        check_data_gui checkDataGUI = new check_data_gui(tableName);
        checkDataGUI.setVisible(true);

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

}
