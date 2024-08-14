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
public class AdminAddDoctorModel {
    private String doctorID;
    private String doctorName;
    private String doctorPassword;
    private String doctorPhone;
    private String doctorEmail;
    private String doctorSpecialization;
    private String doctorDepartment;
    private String doctorExperience;
    private String doctorQualifications;
    private String doctorStatus;

    public AdminAddDoctorModel(String doctorID, String doctorName, String doctorPassword, String doctorPhone, String doctorEmail, 
                   String doctorSpecialization, String doctorDepartment, String doctorExperience, String doctorQualifications, String doctorStatus) {
        this.doctorID = doctorID;
        this.doctorName = doctorName;
        this.doctorPassword = doctorPassword;
        this.doctorPhone = doctorPhone;
        this.doctorEmail = doctorEmail;
        this.doctorSpecialization = doctorSpecialization;
        this.doctorDepartment = doctorDepartment;
        this.doctorExperience = doctorExperience;
        this.doctorQualifications = doctorQualifications;
        this.doctorStatus = doctorStatus;
    }

    public boolean save() {
        MysqlConnect db = new MysqlConnect();
        String tableName = "Doctors";
        String columns = "doctor_id, doctor_name, doctor_password, doctor_phone, doctor_email, doctor_specialization, doctor_department, doctor_status, doctor_experience, doctor_qualifications";
        String[] values = {doctorID, doctorName, doctorPassword, doctorPhone, doctorEmail, doctorSpecialization, doctorDepartment, doctorStatus, doctorExperience, doctorQualifications};

        try {
            return db.saveData(tableName, columns, values);
        } catch (SQLException e) {
            System.err.println("Error while saving data: " + e.getMessage());
            return false;
        }
    }

    public String getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorPassword() {
        return doctorPassword;
    }

    public void setDoctorPassword(String doctorPassword) {
        this.doctorPassword = doctorPassword;
    }

    public String getDoctorPhone() {
        return doctorPhone;
    }

    public void setDoctorPhone(String doctorPhone) {
        this.doctorPhone = doctorPhone;
    }

    public String getDoctorEmail() {
        return doctorEmail;
    }

    public void setDoctorEmail(String doctorEmail) {
        this.doctorEmail = doctorEmail;
    }

    public String getDoctorSpecialization() {
        return doctorSpecialization;
    }

    public void setDoctorSpecialization(String doctorSpecialization) {
        this.doctorSpecialization = doctorSpecialization;
    }

    public String getDoctorDepartment() {
        return doctorDepartment;
    }

    public void setDoctorDepartment(String doctorDepartment) {
        this.doctorDepartment = doctorDepartment;
    }

    public String getDoctorExperience() {
        return doctorExperience;
    }

    public void setDoctorExperience(String doctorExperience) {
        this.doctorExperience = doctorExperience;
    }

    public String getDoctorQualifications() {
        return doctorQualifications;
    }

    public void setDoctorStatus(String doctorStatus) {
        this.doctorStatus = doctorStatus;
    }

    public void getDoctorStatus(String doctorStatus) {
        this.doctorStatus = doctorStatus;
    }
}
