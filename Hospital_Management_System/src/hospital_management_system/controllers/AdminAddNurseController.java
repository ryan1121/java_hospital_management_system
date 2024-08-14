/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital_management_system.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import hospital_management_system.models.AdminAddNurseModel;

/**
 *
 * @author User
 */
public class AdminAddNurseController {
    private JTextField nurseIDField;
    private JTextField nurseNameField;
    private JTextField nursePhoneField;
    private JTextField nurseEmailField;
    private JTextField nursePositionField;
    private JTextField nurseDepartmentField;
    private JTextField nurseAssignedWardsField;
    private JTextField nurseSupervisingDoctorField;
    private JTextPane nurseQualificationsField;
    private JTextPane nurseExperienceField;
    private JButton saveButton;
    private JButton clearButton;

    public AdminAddNurseController(JTextField nurseIDField, JTextField nurseNameField, JTextField nursePhoneField, 
                           JTextField nurseEmailField, JTextField nursePositionField, JTextField nurseDepartmentField, 
                           JTextField nurseAssignedWardsField, JTextField nurseSupervisingDoctorField, 
                           JTextPane nurseQualificationsField, JTextPane nurseExperienceField, JButton saveButton, 
                           JButton clearButton) {
        this.nurseIDField = nurseIDField;
        this.nurseNameField = nurseNameField;
        this.nursePhoneField = nursePhoneField;
        this.nurseEmailField = nurseEmailField;
        this.nursePositionField = nursePositionField;
        this.nurseDepartmentField = nurseDepartmentField;
        this.nurseAssignedWardsField = nurseAssignedWardsField;
        this.nurseSupervisingDoctorField = nurseSupervisingDoctorField;
        this.nurseQualificationsField = nurseQualificationsField;
        this.nurseExperienceField = nurseExperienceField;
        this.saveButton = saveButton;
        this.clearButton = clearButton;

        this.saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                saveNurseActionPerformed(evt);
            }
        });

        this.clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                clearNurseActionPerformed(evt);
            }
        });
    }

    private void saveNurseActionPerformed(ActionEvent evt) {
        String nurseID = nurseIDField.getText();
        String nurseName = nurseNameField.getText();
        String nursePhone = nursePhoneField.getText();
        String nurseEmail = nurseEmailField.getText();
        String nursePosition = nursePositionField.getText();
        String nurseDepartment = nurseDepartmentField.getText();
        String nurseAssignedWards = nurseAssignedWardsField.getText();
        String nurseSupervisingDoctor = nurseSupervisingDoctorField.getText();
        String nurseQualifications = nurseQualificationsField.getText();
        String nurseExperience = nurseExperienceField.getText();

        AdminAddNurseModel nurse = new AdminAddNurseModel(nurseID, nurseName, "password", nurseEmail, nursePhone, nursePosition, nurseDepartment, nurseAssignedWards, nurseSupervisingDoctor, nurseQualifications, nurseExperience);

        boolean success = nurse.save();
        if (success) {
            JOptionPane.showMessageDialog(null, "Data saved successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Failed to save data.");
        }
    }

    private void clearNurseActionPerformed(ActionEvent evt) {
        nurseNameField.setText("");
        nursePhoneField.setText("");
        nurseEmailField.setText("");
        nursePositionField.setText("");
        nurseDepartmentField.setText("");
        nurseAssignedWardsField.setText("");
        nurseSupervisingDoctorField.setText("");
        nurseQualificationsField.setText("");
        nurseExperienceField.setText("");
    }
}
