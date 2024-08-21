/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital_management_system.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import hospital_management_system.MysqlConnect;

/**
 *
 * @author User
 */
public class NurseGetPatientModel {
    private String patientID;
    private String name;
    private String gender;
    private String dob;
    private String phone;
    private String email;
    private String address;
    private String address2;
    private String address3;
    private String ward;
    private String bedNumber;
    private String roomNumber;

    public NurseGetPatientModel(String patientID, String name, String gender, String dob, String phone, String email, 
                            String address, String address2, String address3, String ward, String bedNumber, String roomNumber) {
        this.patientID = patientID;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.address2 = address2;
        this.address3 = address3;
        this.ward = ward;
        this.bedNumber = bedNumber;
        this.roomNumber = roomNumber;
    }

    public boolean save() {
        MysqlConnect db = new MysqlConnect();
        String tableName = "Patients";
        String columns = "patient_id, patient_DOB, patient_gender, patient_phone, patient_name, patient_password, patient_email, patient_address, patient_address_line2, patient_address_line3";
        String[] values = {patientID, dob, gender, phone, name, "password", email, address, address2, address3};

        String bedTableName = "BedAllocation";
        String bedColumns = "bed_allocate_number, room_allocate_number, ward_allocate_number, bed_patient_id";
        String[] bedValues = {bedNumber,roomNumber,ward,patientID}; 

        try {
            // Save patient data
            boolean patientSaved = db.saveData(tableName, columns, values);
            boolean bedAllocationSaved = db.saveData(bedTableName, bedColumns, bedValues);
    
            return !(!patientSaved && !bedAllocationSaved); 
            // Return false if saving patient data fails
            // Return true if both saves are successful
            
        } catch (SQLException e) {
            System.err.println("Error while saving data: " + e.getMessage());
            return false;
        }
    }

    public ResultSet fetchPatient(String patientID) {
        MysqlConnect db = new MysqlConnect();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = db.getConnection();
            String query = "SELECT * FROM Patients WHERE patient_id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, patientID);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    public ResultSet fetchBedInfo(String patientID) {
        MysqlConnect db = new MysqlConnect();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = db.getConnection();
            String query = "SELECT bed_allocate_number, room_allocate_number, ward_allocate_number FROM BedAllocation WHERE bed_patient_id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, patientID);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(String bedNumber) {
        this.bedNumber = bedNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }
}
