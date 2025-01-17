/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital_management_system.controllers;

import java.awt.event.ActionEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import hospital_management_system.models.NurseInfoModel;

/**
 *
 * @author User
 */
public class NurseInfoController {
    private NurseInfoModel model;
    private JTextField nurseIDField;
    private JTextField nurseNameField;
    private JTextField nursePhoneField;
    private JTextField nurseEmailField;
    private JTextField nurseDepartmentField;
    private JTextField nursePositionField;
    private JTextField nurseAssignWardsField;
    private JTextField nurseSupervisingDoctorField;
    private JTextPane nurseExperienceField;
    private JTextPane nurseQualificationsField;
    private JComboBox<String> nurseStatusField;

    public NurseInfoController(JTextField nurseIDField, JTextField nurseNameField, JTextField nursePhoneField,
                               JTextField nurseEmailField, JTextField nurseDepartmentField, JTextField nursePositionField,
                               JTextField nurseAssignWardsField, JTextField nurseSupervisingDoctorField, 
                               JTextPane nurseExperienceField, JTextPane nurseQualificationsField, JComboBox<String> nurseStatusField) {
        this.nurseIDField = nurseIDField;
        this.nurseNameField = nurseNameField;
        this.nursePhoneField = nursePhoneField;
        this.nurseEmailField = nurseEmailField;
        this.nurseDepartmentField = nurseDepartmentField;
        this.nursePositionField = nursePositionField;
        this.nurseAssignWardsField = nurseAssignWardsField;
        this.nurseSupervisingDoctorField = nurseSupervisingDoctorField;
        this.nurseExperienceField = nurseExperienceField;
        this.nurseQualificationsField = nurseQualificationsField;
        this.nurseStatusField = nurseStatusField;
    }

    public void handleSaveActionPerformed(ActionEvent evt) {
        String nurseID = nurseIDField.getText();
        String nurseName = nurseNameField.getText();
        String nursePhone = nursePhoneField.getText();
        String nurseEmail = nurseEmailField.getText();
        String nurseDepartment = nurseDepartmentField.getText();
        String nursePosition = nursePositionField.getText();
        String nurseAssignWards = nurseAssignWardsField.getText();
        String nurseSupervisingDoctor = nurseSupervisingDoctorField.getText();
        String nurseExperience = nurseExperienceField.getText();
        String nurseQualifications = nurseQualificationsField.getText();
        String nurseStatus = nurseStatusField.getSelectedItem().toString();
        
        if (isValidPhone(nursePhone)) {
            if (isValidEmail(nurseEmail)) {
                model = new NurseInfoModel(nurseID, nurseName, nursePhone, nurseEmail, nurseDepartment, 
                                   nursePosition, nurseAssignWards, nurseSupervisingDoctor, 
                                   nurseExperience, nurseQualifications, nurseStatus);

                if (model.save()) {
                    JOptionPane.showMessageDialog(null, "Data saved successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "No Data Update. Data save failed.");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Invalid Email !");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Invalid Phone Number!");
        }
    }

    public void handleClearActionPerformed(ActionEvent evt) {
        nurseNameField.setText("");
        nursePhoneField.setText("");
        nurseEmailField.setText("");
        nurseDepartmentField.setText("");
        nursePositionField.setText("");
        nurseAssignWardsField.setText("");
        nurseSupervisingDoctorField.setText("");
        nurseExperienceField.setText("");
        nurseQualificationsField.setText("");
        nurseStatusField.setSelectedItem("");
    }

    public void fetchDataDisplay(String nurseName) {
        model = NurseInfoModel.fetchNurse(nurseName);
        if (model != null) {
            nurseIDField.setText(model.getNurseID());
            nurseNameField.setText(model.getNurseName());
            nursePhoneField.setText(model.getNursePhone());
            nurseEmailField.setText(model.getNurseEmail());
            nurseDepartmentField.setText(model.getNurseDepartment());
            nursePositionField.setText(model.getNursePosition());
            nurseAssignWardsField.setText(model.getNurseAssignWards());
            nurseSupervisingDoctorField.setText(model.getNurseSupervisingDoctor());
            nurseExperienceField.setText(model.getNurseExperience());
            nurseQualificationsField.setText(model.getNurseQualifications());
            nurseStatusField.setSelectedItem(model.getNurseStatus());
        } else {
            JOptionPane.showMessageDialog(null, "No data found for the given nurse name.");
        }
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        if (email == null) {
            return false;
        }
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean isValidPhone(String phone) {
        String phoneRegex = "01\\d-\\d{7,8}";
        Pattern pattern = Pattern.compile(phoneRegex);
        if (phone == null) {
            return false;
        }
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }
}
