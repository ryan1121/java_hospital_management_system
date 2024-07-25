package hospital_management_system.models;
import hospital_management_system.MysqlConnect;
import hospital_management_system.controllers.*;
import hospital_management_system.utils.DateTimeUtils;

import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DiagnosisModel {
    private String patientID;
    private String doctorID;
    private String diagnosisID;
    private String dateOfDiagnosis;
    private String diagnosisDescription;
    private String treatmentPlans;
    private javax.swing.JPanel panel;

    public DiagnosisModel(
        javax.swing.JPanel panel,
        javax.swing.JTextField patientIDTextField,
        javax.swing.JTextField doctorIDTextField,
        javax.swing.JTextField diagnosisIDTextField,
        javax.swing.JTextField dateOfDiagnosisTextField,
        javax.swing.JTextArea diagnosisDescriptionTextArea,
        javax.swing.JTextArea treatmentPlansTextArea
    ) {
        this.panel = panel;
        this.patientID = patientIDTextField.getText();
        this.doctorID = doctorIDTextField.getText();
        this.diagnosisID = diagnosisIDTextField.getText();
        this.dateOfDiagnosis = DateTimeUtils.formatDate(dateOfDiagnosisTextField.getText());
        this.diagnosisDescription = diagnosisDescriptionTextArea.getText();
        this.treatmentPlans = treatmentPlansTextArea.getText();
    }

    public boolean save() {
        System.out.println("PatientID: " + patientID);
        System.out.println("DoctorID: " + doctorID);
        if ((patientID == null || patientID.isEmpty()) && (doctorID == null || doctorID.isEmpty())) {
            JOptionPane.showMessageDialog(panel, "You MUST enter patient ID and doctor ID !!");
            return false;
        } else if (patientID == null || patientID.isEmpty()) {
            JOptionPane.showMessageDialog(panel, "You MUST enter patient ID !!");
            return false;
        } else if (doctorID == null || doctorID.isEmpty()) {
            JOptionPane.showMessageDialog(panel, "You MUST enter doctor ID !!");
            return false;
        } else {
            MysqlConnect db = new MysqlConnect();
            String[] values = {diagnosisID, patientID, doctorID, diagnosisDescription, dateOfDiagnosis, treatmentPlans};
            try {
                boolean saveResult = db.saveData("Diagnosis", "DiagnosisID, PatientID, DoctorID, DiagnosisDescription, DateOfDiagnosis, treatmentPlans", values);
                if (saveResult) {
                    JOptionPane.showMessageDialog(panel, "Data saved successfully !");
                    return true;
                } else {
                    JOptionPane.showMessageDialog(panel, "Data saved unsuccessfully !");
                    return false;
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(panel, "Error while saving data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
    }

    public void clear(javax.swing.JTextField dateOfDiagnosisTextField, javax.swing.JTextArea diagnosisDescriptionTextArea, javax.swing.JTextArea treatmentPlansTextArea) {
        dateOfDiagnosisTextField.setText("");
        diagnosisDescriptionTextArea.setText("");
        treatmentPlansTextArea.setText("");
    }

    public static String setNewDiagnosisId(javax.swing.JTextField diagnosisIDTextField) {
        MysqlConnect db = new MysqlConnect();
        String newDiagnosisId = db.generateNewId("diagnosis", "DI");
        diagnosisIDTextField.setText(newDiagnosisId);
        return newDiagnosisId;
    }

    // Getters and Setters
    public String getPatientID() { return patientID; }
    public void setPatientID(String patientID) { this.patientID = patientID; }

    public String getDoctorID() { return doctorID; }
    public void setDoctorID(String doctorID) { this.doctorID = doctorID; }

    public String getDiagnosisID() { return diagnosisID; }
    public void setDiagnosisID(String diagnosisID) { this.diagnosisID = diagnosisID; }

    public String getDateOfDiagnosis() { return dateOfDiagnosis; }
    public void setDateOfDiagnosis(String dateOfDiagnosis) { this.dateOfDiagnosis = dateOfDiagnosis; }

    public String getDiagnosisDescription() { return diagnosisDescription; }
    public void setDiagnosisDescription(String diagnosisDescription) { this.diagnosisDescription = diagnosisDescription; }

    public String getTreatmentPlans() { return treatmentPlans; }
    public void setTreatmentPlans(String treatmentPlans) { this.treatmentPlans = treatmentPlans; }
}
