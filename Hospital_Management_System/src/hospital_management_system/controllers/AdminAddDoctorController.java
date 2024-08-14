/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital_management_system.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import hospital_management_system.models.AdminAddDoctorModel;

/**
 *
 * @author User
 */
public class AdminAddDoctorController {
    private JTextField doctorIDField;
    private JTextField doctorNameField;
    private JTextField doctorPhoneField;
    private JTextField doctorEmailField;
    private JTextField doctorSpecializationField;
    private JTextField doctorDepartmentField;
    private JTextPane doctorExperienceField;
    private JTextPane doctorQualificationsField;
    private JButton saveButton;
    private JButton clearButton;
    private JComboBox<String> doctorStatusComboBox;

    public AdminAddDoctorController(JTextField doctorIDField, JTextField doctorNameField, JTextField doctorPhoneField, 
                            JTextField doctorEmailField, JTextField doctorSpecializationField, JTextField doctorDepartmentField, 
                            JTextPane doctorExperienceField, JTextPane doctorQualificationsField, JButton saveButton, 
                            JButton clearButton, JComboBox<String> doctorStatusComboBox) {
        this.doctorIDField = doctorIDField;
        this.doctorNameField = doctorNameField;
        this.doctorPhoneField = doctorPhoneField;
        this.doctorEmailField = doctorEmailField;
        this.doctorSpecializationField = doctorSpecializationField;
        this.doctorDepartmentField = doctorDepartmentField;
        this.doctorExperienceField = doctorExperienceField;
        this.doctorQualificationsField = doctorQualificationsField;
        this.saveButton = saveButton;
        this.clearButton = clearButton;
        this.doctorStatusComboBox = doctorStatusComboBox;

        this.saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                saveDoctorActionPerformed(evt);
            }
        });

        this.clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                clearDoctorActionPerformed(evt);
            }
        });
    }

    private void saveDoctorActionPerformed(ActionEvent evt) {
        String doctorID = doctorIDField.getText();
        String doctorName = doctorNameField.getText();
        String doctorPhone = doctorPhoneField.getText();
        String doctorEmail = doctorEmailField.getText();
        String doctorSpecialization = doctorSpecializationField.getText();
        String doctorDepartment = doctorDepartmentField.getText();
        String doctorExperience = doctorExperienceField.getText();
        String doctorQualifications = doctorQualificationsField.getText();
        String doctorStatus = doctorStatusComboBox.getSelectedItem().toString();
        

        AdminAddDoctorModel doctor = new AdminAddDoctorModel(doctorID, doctorName, "password", doctorPhone, doctorEmail, doctorSpecialization, doctorDepartment, doctorExperience, doctorQualifications, doctorStatus);

        boolean success = doctor.save();
        if (success) {
            JOptionPane.showMessageDialog(null, "Data saved successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Failed to save data.");
        }
    }

    private void clearDoctorActionPerformed(ActionEvent evt) {
        doctorNameField.setText("");
        doctorPhoneField.setText("");
        doctorEmailField.setText("");
        doctorSpecializationField.setText("");
        doctorDepartmentField.setText("");
        doctorExperienceField.setText("");
        doctorQualificationsField.setText("");
    }

}
