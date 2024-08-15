/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital_management_system.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import hospital_management_system.MysqlConnect;

/**
 *
 * @author User
 */
public class NurseInfoModel {
    private String nurseID;
    private String nurseName;
    private String nursePhone;
    private String nurseEmail;
    private String nurseDepartment;
    private String nursePosition;
    private String nurseAssignWards;
    private String nurseSupervisingDoctor;
    private String nurseExperience;
    private String nurseQualifications;
    private String nurseStatus;

    public NurseInfoModel(String nurseID, String nurseName, String nursePhone, String nurseEmail, String nurseDepartment,
                          String nursePosition, String nurseAssignWards, String nurseSupervisingDoctor,
                          String nurseExperience, String nurseQualifications, String nurseStatus) {
        this.nurseID = nurseID;
        this.nurseName = nurseName;
        this.nursePhone = nursePhone;
        this.nurseEmail = nurseEmail;
        this.nurseDepartment = nurseDepartment;
        this.nursePosition = nursePosition;
        this.nurseAssignWards = nurseAssignWards;
        this.nurseSupervisingDoctor = nurseSupervisingDoctor;
        this.nurseExperience = nurseExperience;
        this.nurseQualifications = nurseQualifications;
        this.nurseStatus = nurseStatus;
    }

    public boolean save() {
        MysqlConnect db = new MysqlConnect();
        String tableName = "Nurse";
        String condition = "nurse_id = '" + nurseID + "'";

        try {
            // Only update fields that are not null or empty
            StringBuilder updateBuilder = new StringBuilder();
            if (nurseName != null && !nurseName.isEmpty()) {
                updateBuilder.append("nurse_name = '").append(nurseName).append("', ");
            }
            if (nursePhone != null && !nursePhone.isEmpty()) {
                updateBuilder.append("nurse_phone = '").append(nursePhone).append("', ");
            }
            if (nurseEmail != null && !nurseEmail.isEmpty()) {
                updateBuilder.append("nurse_email = '").append(nurseEmail).append("', ");
            }
            if (nurseDepartment != null && !nurseDepartment.isEmpty()) {
                updateBuilder.append("nurse_department = '").append(nurseDepartment).append("', ");
            }
            if (nursePosition != null && !nursePosition.isEmpty()) {
                updateBuilder.append("nurse_position = '").append(nursePosition).append("', ");
            }
            if (nurseAssignWards != null && !nurseAssignWards.isEmpty()) {
                updateBuilder.append("nurse_assign_wards = '").append(nurseAssignWards).append("', ");
            }
            if (nurseSupervisingDoctor != null && !nurseSupervisingDoctor.isEmpty()) {
                updateBuilder.append("nurse_supervising_doctor = '").append(nurseSupervisingDoctor).append("', ");
            }
            if (nurseExperience != null && !nurseExperience.isEmpty()) {
                updateBuilder.append("nurse_experience = '").append(nurseExperience).append("', ");
            }
            if (nurseQualifications != null && !nurseQualifications.isEmpty()) {
                updateBuilder.append("nurse_qualifications = '").append(nurseQualifications).append("', ");
            }
            if (nurseStatus != null && !nurseStatus.isEmpty()) {
                updateBuilder.append("nurse_status = '").append(nurseStatus).append("', ");
            }

            String update = updateBuilder.toString();
            if (update.endsWith(", ")) {
                update = update.substring(0, update.length() - 2); // Remove trailing comma
            }

            if (!update.isEmpty()) {
                return db.updateData(tableName, update, condition);
            } else {
                System.out.println("No data to update.");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error while saving data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public static NurseInfoModel fetchNurse(String nurseName) {
        MysqlConnect db = new MysqlConnect();
        String tableName = "Nurse";
        String query = "SELECT * FROM " + tableName + " WHERE nurse_name = ?";
        try (Connection connection = db.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
            preparedStatement.setString(1, nurseName);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String id = resultSet.getString("nurse_id");
                String name = resultSet.getString("nurse_name");
                String phone = resultSet.getString("nurse_phone");
                String email = resultSet.getString("nurse_email");
                String department = resultSet.getString("nurse_department");
                String position = resultSet.getString("nurse_position");
                String assignWards = resultSet.getString("nurse_assign_wards");
                String supervisingDoctor = resultSet.getString("nurse_supervising_doctor");
                String experience = resultSet.getString("nurse_experience");
                String qualifications = resultSet.getString("nurse_qualifications");
                String status = resultSet.getString("nurse_status");

                return new NurseInfoModel(id, name, phone, email, department, position, assignWards,
                                          supervisingDoctor, experience, qualifications, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Getters and setters
    public String getNurseID() { return nurseID; }
    public void setNurseID(String nurseID) { this.nurseID = nurseID; }

    public String getNurseName() { return nurseName; }
    public void setNurseName(String nurseName) { this.nurseName = nurseName; }

    public String getNursePhone() { return nursePhone; }
    public void setNursePhone(String nursePhone) { this.nursePhone = nursePhone; }

    public String getNurseEmail() { return nurseEmail; }
    public void setNurseEmail(String nurseEmail) { this.nurseEmail = nurseEmail; }

    public String getNurseDepartment() { return nurseDepartment; }
    public void setNurseDepartment(String nurseDepartment) { this.nurseDepartment = nurseDepartment; }

    public String getNursePosition() { return nursePosition; }
    public void setNursePosition(String nursePosition) { this.nursePosition = nursePosition; }

    public String getNurseAssignWards() { return nurseAssignWards; }
    public void setNurseAssignWards(String nurseAssignWards) { this.nurseAssignWards = nurseAssignWards; }

    public String getNurseSupervisingDoctor() { return nurseSupervisingDoctor; }
    public void setNurseSupervisingDoctor(String nurseSupervisingDoctor) { this.nurseSupervisingDoctor = nurseSupervisingDoctor; }

    public String getNurseExperience() { return nurseExperience; }
    public void setNurseExperience(String nurseExperience) { this.nurseExperience = nurseExperience; }

    public String getNurseQualifications() { return nurseQualifications; }
    public void setNurseQualifications(String nurseQualifications) { this.nurseQualifications = nurseQualifications; }

    public String getNurseStatus() { return nurseStatus; }
    public void setNurseStatus(String nurseStatus) { this.nurseStatus = nurseStatus; }
}
