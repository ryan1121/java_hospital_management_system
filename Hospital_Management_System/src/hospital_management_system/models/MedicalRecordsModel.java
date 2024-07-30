package hospital_management_system.models;

import hospital_management_system.MysqlConnect;
import hospital_management_system.utils.DateTimeUtils;

import javax.swing.*;

import java.awt.TextField;
import java.sql.SQLException;

public class MedicalRecordsModel {
    private String patientID;
    private String doctorID;
    private String medicalRecordID;
    private String dateOfVisit;
    private String notes;
    private String treatmentPlans;
    private JPanel panel;

    public MedicalRecordsModel(
        JPanel panel,
        JTextField patientIDTextField,
        JTextField doctorIDTextField,
        JTextField medicalRecordIDTextField,
        JTextField dateOfVisitTextField,
        TextField notesTextField,
        JTextArea treatmentPlansTextArea
    ) {
        this.panel = panel;
        this.patientID = patientIDTextField.getText();
        this.doctorID = doctorIDTextField.getText();
        this.medicalRecordID = medicalRecordIDTextField.getText();
        this.dateOfVisit = DateTimeUtils.formatDate(dateOfVisitTextField.getText());
        this.notes = notesTextField.getText();
        this.treatmentPlans = treatmentPlansTextArea.getText();
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
            String[] medicalRecordValues = {medicalRecordID, patientID, doctorID, dateOfVisit, notes, treatmentPlans};
            String newPatientHistoryID = db.generateNewId("PatientHistory", "H");
            String[] historyValues = {newPatientHistoryID, patientID, "Medical Visit", dateOfVisit, "Visited Doctor ID " + doctorID + ". Notes: " + notes + ". Treatment plans: " + treatmentPlans};
    
            try {
                // Save Medical Records Data
                boolean saveMedicalRecordResult = db.saveData("MedicalRecords", "medicalRecordID, PatientID, DoctorID, DateOfVisit, notes, treatmentPlans", medicalRecordValues);
    
                // Save Patient History Data
                boolean saveHistoryResult = db.saveData("PatientHistory", "HistoryID, PatientID, EventType, EventDate, Details", historyValues);
    
                if (saveMedicalRecordResult && saveHistoryResult) {
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
    

    public void clear(JTextField dateOfVisitTextField, TextField notesTextField, JTextArea treatmentPlansTextArea) {
        dateOfVisitTextField.setText("");
        notesTextField.setText("");
        treatmentPlansTextArea.setText("");
    }

    public static String setNewMedicalRecordId(JTextField medicalRecordIDTextField) {
        MysqlConnect db = new MysqlConnect();
        String newMedicalRecordId = db.generateNewId("MedicalRecords", "MR");
        medicalRecordIDTextField.setText(newMedicalRecordId);
        return newMedicalRecordId;
    }

    // Getters and Setters
    public String getPatientID() { return patientID; }
    public void setPatientID(String patientID) { this.patientID = patientID; }

    public String getDoctorID() { return doctorID; }
    public void setDoctorID(String doctorID) { this.doctorID = doctorID; }

    public String getMedicalRecordID() { return medicalRecordID; }
    public void setMedicalRecordID(String medicalRecordID) { this.medicalRecordID = medicalRecordID; }

    public String getDateOfVisit() { return dateOfVisit; }
    public void setDateOfVisit(String dateOfVisit) { this.dateOfVisit = dateOfVisit; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public String getTreatmentPlans() { return treatmentPlans; }
    public void setTreatmentPlans(String treatmentPlans) { this.treatmentPlans = treatmentPlans; }
}
