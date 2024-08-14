/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital_management_system.controllers;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import hospital_management_system.models.AdminInfoModel;

/**
 *
 * @author User
 */
public class AdminInfoController {
    private AdminInfoModel model;
    private JTextField adminIDField;
    private JTextField adminNameField;
    private JTextField adminPhoneField;
    private JTextField adminEmailField;

    public AdminInfoController(JTextField adminIDField, JTextField adminNameField, JTextField adminPhoneField, JTextField adminEmailField) {
        this.adminIDField = adminIDField;
        this.adminNameField = adminNameField;
        this.adminPhoneField = adminPhoneField;
        this.adminEmailField = adminEmailField;
    }

    public void handleSaveActionPerformed(ActionEvent evt) {
        String adminID = adminIDField.getText();
        String adminName = adminNameField.getText();
        String adminPhone = adminPhoneField.getText();
        String adminEmail = adminEmailField.getText();

        model = new AdminInfoModel(adminID, adminName, adminPhone, adminEmail);

        if (model.save()) {
            JOptionPane.showMessageDialog(null, "Data saved successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Data save failed.");
        }
    }

    public void handleClearActionPerformed(ActionEvent evt) {
        adminNameField.setText("");
        adminPhoneField.setText("");
        adminEmailField.setText("");
    }

    public void fetchDataDisplay(String adminName) {
        model = AdminInfoModel.fetchAdmin(adminName);
        if (model != null) {
            adminIDField.setText(model.getAdminID());
            adminNameField.setText(model.getAdminName());
            adminPhoneField.setText(model.getAdminPhone());
            adminEmailField.setText(model.getAdminEmail());
        } else {
            JOptionPane.showMessageDialog(null, "No data found for the given ID.");
        }
    }
}
