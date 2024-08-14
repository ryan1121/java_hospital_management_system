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

import hospital_management_system.models.AdminAddPatientModel;
import hospital_management_system.utils.DateTimeUtils;

/**
 *
 * @author User
 */
public class AdminAddPatientController {
     private JTextField patientIDField;
    private JTextField patientDOBField;
    private JComboBox<String> patientGenderComboBox;
    private JTextField patientPhoneField;
    private JTextField patientNameField;
    private JTextField patientEmailField;
    private JTextField patientAddressField;
    private JTextField patientAddressLine2Field;
    private JTextField patientAddressLine3Field;
    private JTextField patientEmergencyNameField;
    private JTextField patientEmergencyPhoneField;
    private JTextField patientEmergencyRelationshipField;
    private JTextField insuranceIDField;
    private JTextField providerNameField;
    private JTextField policyNumberField;
    private JButton saveButton;
    private JButton clearButton;

    public AdminAddPatientController(JTextField patientIDField, JTextField patientDOBField, JComboBox<String> patientGenderComboBox, 
                             JTextField patientPhoneField, JTextField patientNameField, JTextField patientEmailField, 
                             JTextField patientAddressField, JTextField patientAddressLine2Field, JTextField patientAddressLine3Field, 
                             JTextField patientEmergencyNameField, JTextField patientEmergencyPhoneField, JTextField patientEmergencyRelationshipField, 
                             JTextField insuranceIDField, JTextField providerNameField, JTextField policyNumberField, JButton saveButton, 
                             JButton clearButton) {
        this.patientIDField = patientIDField;
        this.patientDOBField = patientDOBField;
        this.patientGenderComboBox = patientGenderComboBox;
        this.patientPhoneField = patientPhoneField;
        this.patientNameField = patientNameField;
        this.patientEmailField = patientEmailField;
        this.patientAddressField = patientAddressField;
        this.patientAddressLine2Field = patientAddressLine2Field;
        this.patientAddressLine3Field = patientAddressLine3Field;
        this.patientEmergencyNameField = patientEmergencyNameField;
        this.patientEmergencyPhoneField = patientEmergencyPhoneField;
        this.patientEmergencyRelationshipField = patientEmergencyRelationshipField;
        this.insuranceIDField = insuranceIDField;
        this.providerNameField = providerNameField;
        this.policyNumberField = policyNumberField;
        this.saveButton = saveButton;
        this.clearButton = clearButton;

        this.saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                savePatientActionPerformed(evt);
            }
        });

        this.clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                clearPatientActionPerformed(evt);
            }
        });
    }

    private void savePatientActionPerformed(ActionEvent evt) {
        String patientID = patientIDField.getText();
        String patientDOB = DateTimeUtils.formatDate(patientDOBField.getText());
        String patientGender = (String) patientGenderComboBox.getSelectedItem();
        String patientPhone = patientPhoneField.getText();
        String patientName = patientNameField.getText();
        String patientEmail = patientEmailField.getText();
        String patientAddress = patientAddressField.getText();
        String patientAddressLine2 = patientAddressLine2Field.getText();
        String patientAddressLine3 = patientAddressLine3Field.getText();
        String patientEmergencyName = patientEmergencyNameField.getText();
        String patientEmergencyPhone = patientEmergencyPhoneField.getText();
        String patientEmergencyRelationship = patientEmergencyRelationshipField.getText();
        String insuranceID = insuranceIDField.getText();
        String providerName = providerNameField.getText();
        String policyNumber = policyNumberField.getText();

        AdminAddPatientModel patient = new AdminAddPatientModel(patientID, patientDOB, patientGender, patientPhone, patientName, "password", patientEmail, 
                                      patientAddress, patientAddressLine2, patientAddressLine3, patientEmergencyName, patientEmergencyPhone, 
                                      patientEmergencyRelationship, insuranceID, providerName, policyNumber);

        boolean success = patient.save();
        if (success) {
            JOptionPane.showMessageDialog(null, "Data saved successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Failed to save data.");
        }
    }

    private void clearPatientActionPerformed(ActionEvent evt) {
        patientDOBField.setText("");
        patientPhoneField.setText("");
        patientNameField.setText("");
        patientEmailField.setText("");
        patientAddressField.setText("");
        patientAddressLine2Field.setText("");
        patientAddressLine3Field.setText("");
        patientEmergencyNameField.setText("");
        patientEmergencyPhoneField.setText("");
        patientEmergencyRelationshipField.setText("");
        insuranceIDField.setText("");
        providerNameField.setText("");
        policyNumberField.setText("");
    }
}
