package hospital_management_system.controllers;
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
        this.DiagnosisDesc = DiagnosisDescription_TextArea.getText();
        this.treatmentPlan = treatmentPlans_TextArea.getText();
    }
    

    public static void Diagnosis_SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Diagnosis_SaveButtonActionPerformed
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
        }


        System.out.println(DiagnosisID);
        System.out.println(dateOfDiagnosis);
        System.out.println(DiagnosisDesc);
        System.out.println(treatmentPlan);


    }//GEN-LAST:event_Diagnosis_SaveButtonActionPerformed

}
