package hospital_management_system.models;

import hospital_management_system.MysqlConnect;
import hospital_management_system.utils.DateTimeUtils;

import javax.swing.*;
import java.sql.SQLException;

public class Surgery {
    private String surgeryID;
    private String patientID;
    private String doctorID;
    private String surgeryType;
    private String dateOfSurgery;
    private String outcomes;
    private JPanel panel;

    public Surgery(
        JPanel panel,
        JTextField surgeryIDTextField,
        JTextField patientIDTextField,
        JTextField doctorIDTextField,
        JComboBox<String> surgeryTypeComboBox,
        JTextField dateOfSurgeryTextField,
        java.awt.TextField outcomesTextField
    ) {
        this.panel = panel;
        this.surgeryID = surgeryIDTextField.getText();
        this.patientID = patientIDTextField.getText();
        this.doctorID = doctorIDTextField.getText();
        setSurgeryType((String) surgeryTypeComboBox.getSelectedItem());
        setDateOfSurgery(DateTimeUtils.formatDate(dateOfSurgeryTextField.getText()));
        setOutcomes(outcomesTextField.getText());
    }

    public boolean save() {
        if (patientID == null || patientID.isEmpty() || doctorID == null || doctorID.isEmpty()) {
            JOptionPane.showMessageDialog(panel, "You MUST enter patient ID and doctor ID !!");
            return false;
        } else {
            MysqlConnect db = new MysqlConnect();
            String[] surgeryValues = {surgeryID, patientID, doctorID, surgeryType, dateOfSurgery, outcomes};
            String newPatientHistoryID = db.generateNewId("PatientHistory", "H");
            System.out.println("Check: "+newPatientHistoryID);
            
            String[] historyValues = {newPatientHistoryID, patientID, "Surgery", dateOfSurgery, "Surgery performed: " + surgeryType + " by Doctor ID " + doctorID + ". Outcomes: " + outcomes};
            
            try {
                // Save Surgery Data
                boolean saveSurgeryResult = db.saveData("Surgery", "surgeryID, PatientID, DoctorID, surgeryType, DateOfSurgery, Outcomes", surgeryValues);
                
                // Create a patientHistory model object
                PatientHistory patientHistoryObj = new PatientHistory();

                // Save Patient History Data
                boolean saveHistoryResult = patientHistoryObj.save(historyValues);

                if (saveSurgeryResult && saveHistoryResult) {
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
    
    

    public void clear(JComboBox<String> surgeryTypeComboBox, JTextField dateOfSurgeryTextField, java.awt.TextField outcomesTextField) {
        surgeryTypeComboBox.setSelectedIndex(-1);
        dateOfSurgeryTextField.setText("");
        outcomesTextField.setText("");
    }

    public static String setNewSurgeryId(JTextField surgeryIDTextField) {
        MysqlConnect db = new MysqlConnect();
        String newSurgeryId = db.generateNewId("Surgery", "S");
        surgeryIDTextField.setText(newSurgeryId);
        return newSurgeryId;
    }

    // Getters and Setters
    public String getSurgeryID() { return surgeryID; }
    public void setSurgeryID(String surgeryID) { this.surgeryID = surgeryID; }

    public String getSurgeryType() { return surgeryType; }
    public void setSurgeryType(String surgeryType) { this.surgeryType = surgeryType; }

    public String getDateOfSurgery() { return dateOfSurgery; }
    public void setDateOfSurgery(String dateOfSurgery) { this.dateOfSurgery = dateOfSurgery; }

    public String getOutcomes() { return outcomes; }
    public void setOutcomes(String outcomes) { this.outcomes = outcomes; }
}
