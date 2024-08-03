package hospital_management_system.models;

import hospital_management_system.MysqlConnect;
import hospital_management_system.utils.DateTimeUtils;

import javax.swing.*;
import java.sql.SQLException;

public class Prescription {
    private String prescriptionID;
    private String patientID;
    private String doctorID;
    private String medication;
    private String dosage;
    private String prescriptionDate;
    private String instructions;
    private JPanel panel;

    public Prescription(
        JPanel panel,
        JTextField prescriptionIDTextField,
        JTextField patientIDTextField,
        JTextField doctorIDTextField,
        JComboBox<String> Medication_comboxBox,
        JSpinner dosage_Spinner,
        JTextField prescriptionDateTextField,
        JTextArea instructionsTextArea
    ) {
        this.panel = panel;
        this.prescriptionID = prescriptionIDTextField.getText();
        this.patientID = patientIDTextField.getText();
        this.doctorID = doctorIDTextField.getText();
        this.medication = (String) Medication_comboxBox.getSelectedItem();
        this.dosage = dosage_Spinner.getValue().toString();
        this.prescriptionDate = DateTimeUtils.formatDate(prescriptionDateTextField.getText());
        this.instructions = instructionsTextArea.getText();
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
            String[] prescriptionValues = {prescriptionID, patientID, doctorID, medication, dosage+"mg", prescriptionDate, instructions};
            String newPatientHistoryID = db.generateNewId("PatientHistory", "H");
            String[] historyValues = {newPatientHistoryID, patientID, "Prescription", prescriptionDate, "Prescription issued: " + medication + " Dosage: " + dosage + "mg . Instructions: " + instructions};

            try {
                // Save Prescription Data
                boolean savePrescriptionResult = db.saveData("Prescription", "PrescriptionID, PatientID, DoctorID, Medication, Dosage, PrescriptionDate, Instructions", prescriptionValues);

                // Save Patient History Data
                boolean saveHistoryResult = db.saveData("PatientHistory", "HistoryID, PatientID, EventType, EventDate, Details", historyValues);

                if (savePrescriptionResult && saveHistoryResult) {
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

    public void clear(JComboBox<String> Medication_comboxBox, JSpinner dosage_Spinner, JTextField prescriptionDateTextField, JTextArea instructionsTextArea) {
        Medication_comboxBox.setSelectedIndex(-1);
        dosage_Spinner.setValue(0);
        prescriptionDateTextField.setText("");
        instructionsTextArea.setText("");
    }

    public static String setNewPrescriptionId(JTextField prescriptionIDTextField) {
        MysqlConnect db = new MysqlConnect();
        String newPrescriptionId = db.generateNewId("Prescription", "PR");
        prescriptionIDTextField.setText(newPrescriptionId);
        return newPrescriptionId;
    }

    // Getters and Setters
    public String getPrescriptionID() { return prescriptionID; }
    public void setPrescriptionID(String prescriptionID) { this.prescriptionID = prescriptionID; }

    public String getPatientID() { return patientID; }
    public void setPatientID(String patientID) { this.patientID = patientID; }

    public String getDoctorID() { return doctorID; }
    public void setDoctorID(String doctorID) { this.doctorID = doctorID; }

    public String getMedication() { return medication; }
    public void setMedication(String medication) { this.medication = medication; }

    public String getDosage() { return dosage; }
    public void setDosage(String dosage) { this.dosage = dosage; }

    public String getPrescriptionDate() { return prescriptionDate; }
    public void setPrescriptionDate(String prescriptionDate) { this.prescriptionDate = prescriptionDate; }

    public String getInstructions() { return instructions; }
    public void setInstructions(String instructions) { this.instructions = instructions; }
}
