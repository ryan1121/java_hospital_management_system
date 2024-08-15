/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital_management_system.models;

import java.sql.SQLException;

import hospital_management_system.MysqlConnect;

/**
 *
 * @author User
 */
public class NurseAdmissionModel {
     private String admissionID;
    private String admissionDate;
    private String admittingStaffID;
    private String admissionStatus;
    private String admissionNotes;
    private String reason;
    private String admissionPatientID;
    private String insuranceDetails;
    private String medicalEquipmentNeed;

    // Constructor with parameters
    public NurseAdmissionModel(String admissionID, String admissionDate, String admittingStaffID,
                               String admissionStatus, String admissionNotes, String reason,
                               String admissionPatientID, String insuranceDetails, String medicalEquipmentNeed) {
        this.admissionID = admissionID;
        this.admissionDate = admissionDate;
        this.admittingStaffID = admittingStaffID;
        this.admissionStatus = admissionStatus;
        this.admissionNotes = admissionNotes;
        this.reason = reason;
        this.admissionPatientID = admissionPatientID;
        this.insuranceDetails = insuranceDetails;
        this.medicalEquipmentNeed = medicalEquipmentNeed;
    }

    // Default constructor
    public NurseAdmissionModel() {
        // Initialize fields if needed
    }

    public boolean save() {
        MysqlConnect db = new MysqlConnect();
        String tableName = "Admission";
        String columns = "Admission_ID, Admission_Date, Admitting_Staff_ID, Admission_Status, Admission_Notes, Reason, admission_Patient_ID, Insurance_Details, medical_equipment_need";
        String[] values = {
            admissionID, admissionDate, admittingStaffID, admissionStatus, admissionNotes,
            reason, admissionPatientID, insuranceDetails, medicalEquipmentNeed
        };

        try {
            return db.saveData(tableName, columns, values);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Getters and setters for all fields
    public String getAdmissionID() { return admissionID; }
    public void setAdmissionID(String admissionID) { this.admissionID = admissionID; }

    public String getAdmissionDate() { return admissionDate; }
    public void setAdmissionDate(String admissionDate) { this.admissionDate = admissionDate; }

    public String getAdmittingStaffID() { return admittingStaffID; }
    public void setAdmittingStaffID(String admittingStaffID) { this.admittingStaffID = admittingStaffID; }

    public String getAdmissionStatus() { return admissionStatus; }
    public void setAdmissionStatus(String admissionStatus) { this.admissionStatus = admissionStatus; }

    public String getAdmissionNotes() { return admissionNotes; }
    public void setAdmissionNotes(String admissionNotes) { this.admissionNotes = admissionNotes; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    public String getAdmissionPatientID() { return admissionPatientID; }
    public void setAdmissionPatientID(String admissionPatientID) { this.admissionPatientID = admissionPatientID; }

    public String getInsuranceDetails() { return insuranceDetails; }
    public void setInsuranceDetails(String insuranceDetails) { this.insuranceDetails = insuranceDetails; }

    public String getMedicalEquipmentNeed() { return medicalEquipmentNeed; }
    public void setMedicalEquipmentNeed(String medicalEquipmentNeed) { this.medicalEquipmentNeed = medicalEquipmentNeed; }
}
