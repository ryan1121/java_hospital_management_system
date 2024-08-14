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
public class AdminInfoModel {
    private String adminID;
    private String adminName;
    private String adminPhone;
    private String adminEmail;

    public AdminInfoModel(String adminID, String adminName, String adminPhone, String adminEmail) {
        this.adminID = adminID;
        this.adminName = adminName;
        this.adminPhone = adminPhone;
        this.adminEmail = adminEmail;
    }

    public boolean save() {
        MysqlConnect db = new MysqlConnect();
        String tableName = "Admin";
        String condition = "admin_id = '" + adminID + "'";

        try {
            // Only update fields that are not null or empty
            StringBuilder updateBuilder = new StringBuilder();
            if (adminName != null && !adminName.isEmpty()) {
                updateBuilder.append("admin_name = '").append(adminName).append("', ");
            }
            if (adminPhone != null && !adminPhone.isEmpty()) {
                updateBuilder.append("admin_phone = '").append(adminPhone).append("', ");
            }
            if (adminEmail != null && !adminEmail.isEmpty()) {
                updateBuilder.append("admin_email = '").append(adminEmail).append("', ");
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

    public static AdminInfoModel fetchAdmin(String adminName) {
        MysqlConnect db = new MysqlConnect();
        String tableName = "Admin";
        String query = "SELECT * FROM " + tableName + " WHERE admin_name = ?";
        try (Connection connection = db.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
            preparedStatement.setString(1, adminName);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String id = resultSet.getString("admin_id");
                String name = resultSet.getString("admin_name");
                String phone = resultSet.getString("admin_phone");
                String email = resultSet.getString("admin_email");

                return new AdminInfoModel(id, name, phone, email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Getters and setters
    public String getAdminID() { return adminID; }
    public void setAdminID(String adminID) { this.adminID = adminID; }

    public String getAdminName() { return adminName; }
    public void setAdminName(String adminName) { this.adminName = adminName; }

    public String getAdminPhone() { return adminPhone; }
    public void setAdminPhone(String adminPhone) { this.adminPhone = adminPhone; }

    public String getAdminEmail() { return adminEmail; }
    public void setAdminEmail(String adminEmail) { this.adminEmail = adminEmail; }
}
