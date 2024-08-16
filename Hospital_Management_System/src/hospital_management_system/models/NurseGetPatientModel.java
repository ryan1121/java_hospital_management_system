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
        Connection conn = null;
        PreparedStatement pstmtPatient = null;
        PreparedStatement pstmtBedAllocation = null;
    
        String patientSQL = "INSERT INTO Patients (patient_id, patient_DOB, patient_gender, patient_phone, patient_name, patient_password, patient_email, patient_address, patient_address_line2, patient_address_line3) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String bedAllocationSQL = "INSERT INTO BedAllocation (bed_allocate_number, room_allocate_number, ward_allocate_number, bed_patient_id) VALUES (?, ?, ?, ?)";
    
        try {
            conn = db.getConnection();
            conn.setAutoCommit(false); // Start transaction
    
            // Save patient data
            pstmtPatient = conn.prepareStatement(patientSQL);
            pstmtPatient.setString(1, patientID);
            pstmtPatient.setString(2, dob);
            pstmtPatient.setString(3, gender);
            pstmtPatient.setString(4, phone);
            pstmtPatient.setString(5, name);
            pstmtPatient.setString(6, "password"); // Consider a more secure method for storing passwords
            pstmtPatient.setString(7, email);
            pstmtPatient.setString(8, address);
            pstmtPatient.setString(9, address2);
            pstmtPatient.setString(10, address3);
    
            boolean patientSaved = pstmtPatient.executeUpdate() > 0;
    
            // Save bed allocation data
            pstmtBedAllocation = conn.prepareStatement(bedAllocationSQL);
            pstmtBedAllocation.setString(1, bedNumber);
            pstmtBedAllocation.setString(2, roomNumber);
            pstmtBedAllocation.setString(3, ward);
            pstmtBedAllocation.setString(4, patientID);
    
            boolean bedAllocationSaved = pstmtBedAllocation.executeUpdate() > 0;
    
            if (patientSaved && bedAllocationSaved) {
                conn.commit(); // Commit transaction if both saves are successful
                return true;
            } else {
                conn.rollback(); // Rollback transaction if any save fails
                return false;
            }
        } catch (SQLException e) {
            System.err.println("Error while saving data: " + e.getMessage());
            if (conn != null) {
                try {
                    conn.rollback(); // Rollback transaction on error
                } catch (SQLException ex) {
                    System.err.println("Error while rolling back transaction: " + ex.getMessage());
                }
            }
            return false;
        } finally {
            // Clean up resources
            try {
                if (pstmtPatient != null) pstmtPatient.close();
                if (pstmtBedAllocation != null) pstmtBedAllocation.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.err.println("Error while closing resources: " + e.getMessage());
            }
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
