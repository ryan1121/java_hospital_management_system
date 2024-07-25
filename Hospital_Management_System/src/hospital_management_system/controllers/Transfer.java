package hospital_management_system.controllers;
import java.sql.SQLException;

import javax.swing.JOptionPane;


public class Transfer {
    public static String TransferID;
    public static String TransferPatientID;
    public static String TransferFrom;
    public static String TransferTo;
    public static String TransferDate;
    public static String TransferTime;
    public static String ReasonForTransfer;
    public static String StatusOfTransfer;
    public static javax.swing.JPanel PatientTransfer;

    public static javax.swing.JTextField TransferID_input;
    public static javax.swing.JTextField DateOfDiagnosis_textField;
    public static javax.swing.JTextArea DiagnosisDescription_TextArea;
    public static javax.swing.JTextArea treatmentPlanss_TextArea;

    public Transfer(
        javax.swing.JPanel PatientTransfer,
        javax.swing.JTextField PatientID_textField,
        javax.swing.JTextField DoctorID_textField,
        javax.swing.JTextField DiagnosisID_textField,
        javax.swing.JTextField DateOfDiagnosis_textField,
        javax.swing.JTextArea DiagnosisDescription_TextArea,
        javax.swing.JTextArea treatmentPlanss_TextArea
    ){
        this.PatientTransfer = PatientTransfer;
        this.TransferID = TransferID_input.getText();
        this.DoctorID = DoctorID_textField.getText();
        this.DiagnosisID = DiagnosisID_textField.getText();
        this.DateOfDiagnosis = DateOfDiagnosis_textField.getText();
        // 将日期格式调整为 YYYY-MM-DD
        this.DateOfDiagnosis = DateTimeUtils.formatDate(DateOfDiagnosis);

        this.DiagnosisDescription = DiagnosisDescription_TextArea.getText();
        this.treatmentPlans = treatmentPlanss_TextArea.getText();


        this.DiagnosisID_textField = DiagnosisID_textField;
        this.DateOfDiagnosis_textField = DateOfDiagnosis_textField;
        this.DiagnosisDescription_TextArea = DiagnosisDescription_TextArea;
        this.treatmentPlanss_TextArea = treatmentPlanss_TextArea;
    }
    

    public static void Diagnosis_SaveButtonActionPerformed(java.awt.event.ActionEvent evt, javax.swing.JTextField DiagnosisID_textField) {//GEN-FIRST:event_Diagnosis_SaveButtonActionPerformed
        // TODO add your handling code here:
        System.out.println("PatientID: " + PatientID);
        System.out.println("DoctorID: " + DoctorID);
        if (PatientID == null || PatientID.isEmpty() && (DoctorID == null || DoctorID.isEmpty())){
            JOptionPane.showMessageDialog(panel, "You MUST enter patient ID and doctor ID !!");
        } else if (PatientID == null || PatientID.isEmpty()) {
            System.out.println("Patient ID is blank");
            JOptionPane.showMessageDialog(panel, "You MUST enter patient ID !!");
        } else if (DoctorID == null || DoctorID.isEmpty()) {
            JOptionPane.showMessageDialog(panel, "You MUST enter doctor ID !!");
        } else {
            
            System.out.println(DiagnosisID);
            System.out.println(DateOfDiagnosis);
            System.out.println(DiagnosisDescription);
            System.out.println(treatmentPlans);

            // 创建 MysqlConnect 对象
            MysqlConnect db = new MysqlConnect();
            String[] values = {DiagnosisID, PatientID, DoctorID, DiagnosisDescription, DateOfDiagnosis, treatmentPlans};
            try {
                boolean saveResult = db.saveData("Diagnosis", "DiagnosisID, PatientID, DoctorID, DiagnosisDescription, DateOfDiagnosis, treatmentPlans", values);
                if (saveResult){
                    JOptionPane.showMessageDialog(panel, "Data saved successfully !");
                } else {
                    JOptionPane.showMessageDialog(panel, "Data saved unsuccessfully !");
                }
                setNewDiagnosisId(DiagnosisID_textField);    // reset the new diagnosis ID
            } catch (SQLException e) {
                System.err.println("Error while saving data!");
                JOptionPane.showMessageDialog(panel, "Error while saving data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        

    }//GEN-LAST:event_Diagnosis_SaveButtonActionPerformed


    public void Diagnosis_ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Diagnosis_ClearButtonActionPerformed
        // TODO add your handling code here:
        this.DiagnosisID_textField.setText("");
        this.DateOfDiagnosis_textField.setText("");
        this.DiagnosisDescription_TextArea.setText("");
        this.treatmentPlanss_TextArea.setText("");
    }//GEN-LAST:event_Diagnosis_ClearButtonActionPerformed


    public static String setNewDiagnosisId(javax.swing.JTextField DiagnosisID_textField){
        // 创建 MysqlConnect 对象
        MysqlConnect db = new MysqlConnect();
        String newDiagnosisId = db.generateNewId("diagnosis", "DI");
        
        DiagnosisID_textField.setText(newDiagnosisId);
        return newDiagnosisId;
    }
}
