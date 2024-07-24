package hospital_management_system.controllers;
import java.sql.SQLException;

import javax.swing.JOptionPane;


public class Diagnosis {
    public static String patientID;
    public static String doctorID;
    public static String DiagnosisID;
    public static String dateOfDiagnosis;
    public static String DiagnosisDesc;
    public static String treatmentPlan;
    public static javax.swing.JPanel panel;

    public Diagnosis(
        javax.swing.JPanel panel,
        javax.swing.JTextField patientID_textField,
        javax.swing.JTextField doctorID_textField,
        javax.swing.JTextField DiagnosisID_textField,
        javax.swing.JTextField DateOfDiagnosis_textField,
        javax.swing.JTextArea DiagnosisDescription_TextArea,
        javax.swing.JTextArea treatmentPlans_TextArea
    ){
        this.patientID = patientID_textField.getText();
        this.doctorID = doctorID_textField.getText();
        this.DiagnosisID = DiagnosisID_textField.getText();
        this.dateOfDiagnosis = DateOfDiagnosis_textField.getText();
        // 将日期格式调整为 YYYY-MM-DD
        this.dateOfDiagnosis = DateUtils.formatDate(dateOfDiagnosis);

        this.DiagnosisDesc = DiagnosisDescription_TextArea.getText();
        this.treatmentPlan = treatmentPlans_TextArea.getText();
    }
    

    public static void Diagnosis_SaveButtonActionPerformed(java.awt.event.ActionEvent evt, javax.swing.JTextField DiagnosisID_textField) {//GEN-FIRST:event_Diagnosis_SaveButtonActionPerformed
        // TODO add your handling code here:
        System.out.println("PatientID: " + patientID);
        System.out.println("DoctorID: " + doctorID);
        if (patientID == null || patientID.isEmpty() && (doctorID == null || doctorID.isEmpty())){
            JOptionPane.showMessageDialog(panel, "You MUST enter patient ID and doctor ID !!");
        } else if (patientID == null || patientID.isEmpty()) {
            System.out.println("Patient ID is blank");
            JOptionPane.showMessageDialog(panel, "You MUST enter patient ID !!");
        } else if (doctorID == null || doctorID.isEmpty()) {
            JOptionPane.showMessageDialog(panel, "You MUST enter doctor ID !!");
        } else {
            
            System.out.println(DiagnosisID);
            System.out.println(dateOfDiagnosis);
            System.out.println(DiagnosisDesc);
            System.out.println(treatmentPlan);

            // 创建 MysqlConnect 对象
            MysqlConnect db = new MysqlConnect();
            String[] values = {DiagnosisID, patientID, doctorID, DiagnosisDesc, dateOfDiagnosis, treatmentPlan};
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
                e.printStackTrace();
                JOptionPane.showMessageDialog(panel, "Error while saving data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        }

        

    }//GEN-LAST:event_Diagnosis_SaveButtonActionPerformed


    public static String setNewDiagnosisId(javax.swing.JTextField DiagnosisID_textField){
        // 创建 MysqlConnect 对象
        MysqlConnect db = new MysqlConnect();
        String newDiagnosisId = db.generateNewId("diagnosis", "DI");
        
        DiagnosisID_textField.setText(newDiagnosisId);
        return newDiagnosisId;
    }
}
