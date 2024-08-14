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
public class AdminAddNurseModel {
    private String nurseID;
    private String nurseName;
    private String nursePassword;
    private String nurseEmail;
    private String nursePhone;
    private String nursePosition;
    private String nurseDepartment;
    private String nurseAssignedWards;
    private String nurseSupervisingDoctor;
    private String nurseQualifications;
    private String nurseExperience;

    public AdminAddNurseModel(String nurseID, String nurseName, String nursePassword, String nurseEmail, String nursePhone, 
                 String nursePosition, String nurseDepartment, String nurseAssignedWards, String nurseSupervisingDoctor,
                 String nurseQualifications, String nurseExperience) {
        this.nurseID = nurseID;
        this.nurseName = nurseName;
        this.nursePassword = nursePassword;
        this.nurseEmail = nurseEmail;
        this.nursePhone = nursePhone;
        this.nursePosition = nursePosition;
        this.nurseDepartment = nurseDepartment;
        this.nurseAssignedWards = nurseAssignedWards;
        this.nurseSupervisingDoctor = nurseSupervisingDoctor;
        this.nurseQualifications = nurseQualifications;
        this.nurseExperience = nurseExperience;
    }

    public boolean save() {
        MysqlConnect db = new MysqlConnect();
        String tableName = "Nurse";
        String columns = "nurse_id, nurse_name, nurse_password, nurse_email, nurse_phone, nurse_position, nurse_department, nurse_assign_wards, nurse_supervising_doctor, nurse_qualifications, nurse_experience";
        String[] values = {nurseID, nurseName, nursePassword, nurseEmail, nursePhone, nursePosition, nurseDepartment, nurseAssignedWards, nurseSupervisingDoctor, nurseQualifications, nurseExperience};

        try {
            return db.saveData(tableName, columns, values);
        } catch (SQLException e) {
            System.err.println("Error while saving data: " + e.getMessage());
            return false;
        }
    }

    public String getNurseID() {
        return nurseID;
    }

    public void setNurseID(String nurseID) {
        this.nurseID = nurseID;
    }

    public String getNurseName() {
        return nurseName;
    }

    public void setNurseName(String nurseName) {
        this.nurseName = nurseName;
    }

    public String getNursePassword() {
        return nursePassword;
    }

    public void setNursePassword(String nursePassword) {
        this.nursePassword = nursePassword;
    }

    public String getNurseEmail() {
        return nurseEmail;
    }

    public void setNurseEmail(String nurseEmail) {
        this.nurseEmail = nurseEmail;
    }

    public String getNursePhone() {
        return nursePhone;
    }

    public void setNursePhone(String nursePhone) {
        this.nursePhone = nursePhone;
    }

    public String getNursePosition() {
        return nursePosition;
    }

    public void setNursePosition(String nursePosition) {
        this.nursePosition = nursePosition;
    }

    public String getNurseDepartment() {
        return nurseDepartment;
    }

    public void setNurseDepartment(String nurseDepartment) {
        this.nurseDepartment = nurseDepartment;
    }

    public String getNurseAssignedWards() {
        return nurseAssignedWards;
    }

    public void setNurseAssignedWards(String nurseAssignedWards) {
        this.nurseAssignedWards = nurseAssignedWards;
    }

    public String getNurseSupervisingDoctor() {
        return nurseSupervisingDoctor;
    }

    public void setNurseSupervisingDoctor(String nurseSupervisingDoctor) {
        this.nurseSupervisingDoctor = nurseSupervisingDoctor;
    }

    public String getNurseQualifications() {
        return nurseQualifications;
    }

    public void setNurseQualifications(String nurseQualifications) {
        this.nurseQualifications = nurseQualifications;
    }

    public String getNurseExperience() {
        return nurseExperience;
    }

    public void setNurseExperience(String nurseExperience) {
        this.nurseExperience = nurseExperience;
    }
}
