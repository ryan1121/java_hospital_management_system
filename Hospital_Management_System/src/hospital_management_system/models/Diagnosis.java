package hospital_management_system.models;
import hospital_management_system.MysqlConnect;
import hospital_management_system.utils.DateTimeUtils;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.*;

public class Diagnosis {
    private String patientID;
    private String doctorID;
    private String diagnosisID;
    private String dateOfDiagnosis;
    private String diagnosisDescription;
    private String treatmentPlans;
    private JPanel panel;

    public Diagnosis(
        JPanel panel,
        JTextField patientIDTextField,
        JTextField doctorIDTextField,
        JTextField diagnosisIDTextField,
        JTextField dateOfDiagnosisTextField,
        JTextArea diagnosisDescriptionTextArea,
        JTextArea treatmentPlansTextArea
    ) {
        this.panel = panel;
        this.patientID = patientIDTextField.getText();
        this.doctorID = doctorIDTextField.getText();
        setDiagnosisID(diagnosisIDTextField.getText());
        setDateOfDiagnosis(DateTimeUtils.formatDate(dateOfDiagnosisTextField.getText()));
        setDiagnosisDescription(diagnosisDescriptionTextArea.getText());
        setTreatmentPlans(treatmentPlansTextArea.getText());
    }

    public boolean save() {
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
            String[] diagnosisValues = {diagnosisID, patientID, doctorID, diagnosisDescription, dateOfDiagnosis, treatmentPlans};
            String newPatientHistoryID = db.generateNewId("PatientHistory", "H");
            String[] historyValues = {newPatientHistoryID, patientID, "Diagnosis", dateOfDiagnosis, "Diagnosis performed: " + diagnosisDescription + " by Doctor ID " + doctorID + ". Treatment plans: " + treatmentPlans};
    
            try {
                // Save Diagnosis Data
                boolean saveDiagnosisResult = db.saveData("Diagnosis", "DiagnosisID, PatientID, DoctorID, DiagnosisDescription, DateOfDiagnosis, treatmentPlans", diagnosisValues);
    
                // Save Patient History Data
                boolean saveHistoryResult = db.saveData("PatientHistory", "HistoryID, PatientID, EventType, EventDate, Details", historyValues);
    
                if (saveDiagnosisResult && saveHistoryResult) {
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
    
    public void clear(JTextField dateOfDiagnosisTextField, JTextArea diagnosisDescriptionTextArea, JTextArea treatmentPlansTextArea) {
        dateOfDiagnosisTextField.setText("");
        diagnosisDescriptionTextArea.setText("");
        treatmentPlansTextArea.setText("");
    }

    public static String setNewDiagnosisId(JTextField diagnosisIDTextField) {
        MysqlConnect db = new MysqlConnect();
        String newDiagnosisId = db.generateNewId("diagnosis", "DI");
        diagnosisIDTextField.setText(newDiagnosisId);
        return newDiagnosisId;
    }

    public String getDiagnosisID() { return diagnosisID; }
    public void setDiagnosisID(String diagnosisID) { this.diagnosisID = diagnosisID; }

    public String getDateOfDiagnosis() { return dateOfDiagnosis; }
    public void setDateOfDiagnosis(String dateOfDiagnosis) { this.dateOfDiagnosis = dateOfDiagnosis; }

    public String getDiagnosisDescription() { return diagnosisDescription; }
    public void setDiagnosisDescription(String diagnosisDescription) { this.diagnosisDescription = diagnosisDescription; }

    public String getTreatmentPlans() { return treatmentPlans; }
    public void setTreatmentPlans(String treatmentPlans) { this.treatmentPlans = treatmentPlans; }
}
