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
public class AdminAddPatientModel {
    private String patientID;
    private String patientDOB;
    private String patientGender;
    private String patientPhone;
    private String patientName;
    private String patientPassword;
    private String patientEmail;
    private String patientAddress;
    private String patientAddressLine2;
    private String patientAddressLine3;
    private String patientEmergencyName;
    private String patientEmergencyPhone;
    private String patientEmergencyRelationship;
    private String insuranceID;
    private String providerName;
    private String policyNumber;

    public AdminAddPatientModel(String patientID, String patientDOB, String patientGender, String patientPhone, String patientName, 
                   String patientPassword, String patientEmail, String patientAddress, String patientAddressLine2, 
                   String patientAddressLine3, String patientEmergencyName, String patientEmergencyPhone, 
                   String patientEmergencyRelationship, String insuranceID, String providerName, String policyNumber) {
        this.patientID = patientID;
        this.patientDOB = patientDOB;
        this.patientGender = patientGender;
        this.patientPhone = patientPhone;
        this.patientName = patientName;
        this.patientPassword = patientPassword;
        this.patientEmail = patientEmail;
        this.patientAddress = patientAddress;
        this.patientAddressLine2 = patientAddressLine2;
        this.patientAddressLine3 = patientAddressLine3;
        this.patientEmergencyName = patientEmergencyName;
        this.patientEmergencyPhone = patientEmergencyPhone;
        this.patientEmergencyRelationship = patientEmergencyRelationship;
        this.insuranceID = insuranceID;
        this.providerName = providerName;
        this.policyNumber = policyNumber;
    }

    public boolean save() {
        MysqlConnect db = new MysqlConnect();
        String tableName = "Patients";
        String columns = "patient_id, patient_DOB, patient_gender, patient_phone, patient_name, patient_password, patient_email, patient_address, patient_address_line2, patient_address_line3, patient_emergency_name, patient_emergency_phone, patient_emergency_relationship, insuranceID, providerName, policyNumber";
        String[] values = {patientID, patientDOB, patientGender, patientPhone, patientName, patientPassword, patientEmail, patientAddress, patientAddressLine2, patientAddressLine3, patientEmergencyName, patientEmergencyPhone, patientEmergencyRelationship, insuranceID, providerName, policyNumber};

        try {
            return db.saveData(tableName, columns, values);
        } catch (SQLException e) {
            System.err.println("Error while saving data: " + e.getMessage());
            return false;
        }
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getPatientDOB() {
        return patientDOB;
    }

    public void setPatientDOB(String patientDOB) {
        this.patientDOB = patientDOB;
    }

    public String getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender;
    }

    public String getPatientPhone() {
        return patientPhone;
    }

    public void setPatientPhone(String patientPhone) {
        this.patientPhone = patientPhone;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientPassword() {
        return patientPassword;
    }

    public void setPatientPassword(String patientPassword) {
        this.patientPassword = patientPassword;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public String getPatientAddressLine2() {
        return patientAddressLine2;
    }

    public void setPatientAddressLine2(String patientAddressLine2) {
        this.patientAddressLine2 = patientAddressLine2;
    }

    public String getPatientAddressLine3() {
        return patientAddressLine3;
    }

    public void setPatientAddressLine3(String patientAddressLine3) {
        this.patientAddressLine3 = patientAddressLine3;
    }

    public String getPatientEmergencyName() {
        return patientEmergencyName;
    }

    public void setPatientEmergencyName(String patientEmergencyName) {
        this.patientEmergencyName = patientEmergencyName;
    }

    public String getPatientEmergencyPhone() {
        return patientEmergencyPhone;
    }

    public void setPatientEmergencyPhone(String patientEmergencyPhone) {
        this.patientEmergencyPhone = patientEmergencyPhone;
    }

    public String getPatientEmergencyRelationship() {
        return patientEmergencyRelationship;
    }

    public void setPatientEmergencyRelationship(String patientEmergencyRelationship) {
        this.patientEmergencyRelationship = patientEmergencyRelationship;
    }

    public String getInsuranceID() {
        return insuranceID;
    }

    public void setInsuranceID(String insuranceID) {
        this.insuranceID = insuranceID;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }
}
