package hospital_management_system.controllers;

import java.sql.SQLException;

import javax.swing.JOptionPane;

public class MedicalRecords {
    public static javax.swing.JPanel panel;
    public static String PatientID;
    public static String DoctorID;
    
    public static String medicalRecordID;
    public static String DateOfVisit;
    public static String notes;
    public static String medical_record_treatmentPlans;
    
    public static javax.swing.JTextField medicalRecordID_textField;
    public static javax.swing.JTextField medicalRecord_dateOfVisitTextField;
    public static java.awt.TextField medicalRecord_notesTextField;
    public static javax.swing.JTextArea medical_record_treatmentPlansTextField;

    public MedicalRecords(
        javax.swing.JPanel panel,
        javax.swing.JTextField patientID_textField,
        javax.swing.JTextField doctorID_textField,
        javax.swing.JTextField medicalRecordID_textField,
        javax.swing.JTextField medicalRecord_dateOfVisitTextField,
        java.awt.TextField medicalRecord_notesTextField,
        javax.swing.JTextArea medical_record_treatmentPlansTextField
    ){
        this.panel = panel;
        this.PatientID = patientID_textField.getText();
        this.DoctorID = doctorID_textField.getText();
        
        this.medicalRecordID = medicalRecordID_textField.getText();
        this.DateOfVisit = medicalRecord_dateOfVisitTextField.getText();
        // 将日期格式调整为 YYYY-MM-DD
        this.DateOfVisit = DateTimeUtils.formatDate(DateOfVisit);
        this.notes = medicalRecord_notesTextField.getText();
        this.medical_record_treatmentPlans = medical_record_treatmentPlansTextField.getText();
        
        this.medicalRecordID_textField = medicalRecordID_textField;
        this.medicalRecord_dateOfVisitTextField = medicalRecord_dateOfVisitTextField;
        this.medicalRecord_notesTextField = medicalRecord_notesTextField;
        this.medical_record_treatmentPlansTextField = medical_record_treatmentPlansTextField;

    }
    

    public static void MedRecord_SaveButtonActionPerformed(java.awt.event.ActionEvent evt, javax.swing.JTextField medicalRecordID_textField) {//GEN-FIRST:event_SurgManage_ClearButtonActionPerformed
        // TODO add your handling code here:
        if (PatientID == null || PatientID.isEmpty() && (DoctorID == null || DoctorID.isEmpty())){
            JOptionPane.showMessageDialog(panel, "You MUST enter patient ID and doctor ID !!");
        } else if (PatientID == null || PatientID.isEmpty()) {
            System.out.println("Patient ID is blank");
            JOptionPane.showMessageDialog(panel, "You MUST enter patient ID !!");
        } else if (DoctorID == null || DoctorID.isEmpty()) {
            JOptionPane.showMessageDialog(panel, "You MUST enter doctor ID !!");
        } else {

            // 创建 MysqlConnect 对象
            MysqlConnect db = new MysqlConnect();
            String[] values = {medicalRecordID, PatientID, DoctorID, DateOfVisit, notes, medical_record_treatmentPlans};
            try {
                boolean saveResult = db.saveData("MedicalRecords", "medicalRecordID, PatientID, DoctorID, DateOfVisit, notes, medical_record_treatmentPlans", values);
                if (saveResult){
                    JOptionPane.showMessageDialog(panel, "Data saved successfully !");
                } else {
                    JOptionPane.showMessageDialog(panel, "Data saved unsuccessfully !");
                }
                setNewMedicalRecordId(medicalRecordID_textField);    // reset the new diagnosis ID
            } catch (SQLException e) {
                System.err.println("Error while saving data!");
                JOptionPane.showMessageDialog(panel, "Error while saving data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }


        }

        

    }//GEN-LAST:event_SurgManage_ClearButtonActionPerformed


    public void MedRecord_ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Surgery_ClearButtonActionPerformed
        // TODO add your handling code here:
        medicalRecord_dateOfVisitTextField.setText("");
        medicalRecord_notesTextField.setText("");
        medical_record_treatmentPlansTextField.setText("");
    }//GEN-LAST:event_Surgery_ClearButtonActionPerformed


    public static String setNewMedicalRecordId(javax.swing.JTextField medicalRecordID){
        // 创建 MysqlConnect 对象
        MysqlConnect db = new MysqlConnect();
        String newSurgeryId = db.generateNewId("MedicalRecords", "MR");
        
        medicalRecordID.setText(newSurgeryId);
        return newSurgeryId;
    }
}
