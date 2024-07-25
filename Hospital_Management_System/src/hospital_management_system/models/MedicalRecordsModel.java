package hospital_management_system.models;

import java.sql.SQLException;
import hospital_management_system.utils.DateTimeUtils;
import hospital_management_system.MysqlConnect;

public class MedicalRecordsModel {
    private String patientID;
    private String doctorID;
    private String medicalRecordID;
    private String dateOfVisit;
    private String notes;
    private String treatmentPlans;
    
    public MedicalRecordsModel(
        String patientID,
        String doctorID,
        String medicalRecordID,
        String dateOfVisit,
        String notes,
        String treatmentPlans
    ) {
        this.patientID = patientID;
        this.doctorID = doctorID;
        this.medicalRecordID = medicalRecordID;
        this.dateOfVisit = DateTimeUtils.formatDate(dateOfVisit);
        this.notes = notes;
        this.treatmentPlans = treatmentPlans;
    }
    
    public boolean save() {
        MysqlConnect db = new MysqlConnect();
        String[] values = {medicalRecordID, patientID, doctorID, dateOfVisit, notes, treatmentPlans};
        try {
            return db.saveData("MedicalRecords", "medicalRecordID, PatientID, DoctorID, DateOfVisit, notes, medical_record_treatmentPlans", values);
        } catch (SQLException e) {
            System.err.println("Error while saving data!");
            e.printStackTrace();
            return false;
        }
    }

    public static String setNewMedicalRecordId(javax.swing.JTextField medicalRecordIDTextField) {
        MysqlConnect db = new MysqlConnect();
        String newMedicalRecordId = db.generateNewId("MedicalRecords", "MR");
        medicalRecordIDTextField.setText(newMedicalRecordId);
        return newMedicalRecordId;
    }
    
    public void clear(javax.swing.JTextField dateOfVisitTextField, java.awt.TextField notesTextField, javax.swing.JTextArea treatmentPlansTextArea) {
        dateOfVisitTextField.setText("");
        notesTextField.setText("");
        treatmentPlansTextArea.setText("");
    }
}
