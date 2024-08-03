package hospital_management_system.models;

import hospital_management_system.MysqlConnect;
import hospital_management_system.utils.DateTimeUtils;

import javax.swing.*;
import java.sql.SQLException;
import java.awt.TextField;

public class Consultation {
    private String consultationID;
    private String patientID;
    private String doctorID;
    private String dateOfConsultation;
    private String notes;
    private JPanel panel;

    public Consultation(
        JPanel panel,
        JTextField consultationIDTextField,
        JTextField patientIDTextField,
        JTextField doctorIDTextField,
        JFormattedTextField dateOfConsultationTextField,
        TextField notes_textField
    ) {
        this.panel = panel;
        this.consultationID = consultationIDTextField.getText();
        this.patientID = patientIDTextField.getText();
        this.doctorID = doctorIDTextField.getText();
        setDateOfConsultation(DateTimeUtils.formatDate(dateOfConsultationTextField.getText()));
        setNotes(notes_textField.getText());
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
            String[] consultationValues = {consultationID, patientID, doctorID, dateOfConsultation, notes};

            // Generate new history ID and prepare history data
            String newHistoryID = db.generateNewId("PatientHistory", "H");
            String[] historyValues = {
                newHistoryID,
                patientID,
                "Consultation",
                dateOfConsultation,
                "Consultation with Doctor: " + doctorID + " Notes: " + notes
            };

            try {
                // Save Consultation Data
                boolean saveConsultationResult = db.saveData("Consultations", "ConsultationID, PatientID, DoctorID, DateOfConsultation, notes", consultationValues);

                // Save Patient History Data
                boolean saveHistoryResult = db.saveData("PatientHistory", "HistoryID, PatientID, EventType, EventDate, Details", historyValues);

                if (saveConsultationResult && saveHistoryResult) {
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

    public void clear(JTextField dateOfConsultationTextField, TextField notes_textField) {
        dateOfConsultationTextField.setText("");
        notes_textField.setText("");
    }

    public static String setNewConsultationId(JTextField consultationIDTextField) {
        MysqlConnect db = new MysqlConnect();
        String newConsultationId = db.generateNewId("Consultations", "C");
        consultationIDTextField.setText(newConsultationId);
        return newConsultationId;
    }

    // Getters and Setters
    public String getConsultationID() { return consultationID; }
    public void setConsultationID(String consultationID) { this.consultationID = consultationID; }

    public String getDateOfConsultation() { return dateOfConsultation; }
    public void setDateOfConsultation(String dateOfConsultation) { this.dateOfConsultation = dateOfConsultation; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes;}
}