/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital_management_system.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import hospital_management_system.MysqlConnect;
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
        // Retrieve values from text fields and combo box
        String doctorID = doctorIDField.getText().trim();
        String doctorName = doctorNameField.getText().trim();
        String doctorPhone = doctorPhoneField.getText().trim();
        String doctorEmail = doctorEmailField.getText().trim();
        String doctorSpecialization = doctorSpecializationField.getText().trim();
        String doctorDepartment = doctorDepartmentField.getText().trim();
        String doctorExperience = doctorExperienceField.getText().trim();
        String doctorQualifications = doctorQualificationsField.getText().trim();
        String doctorStatus = doctorStatusComboBox.getSelectedItem().toString().trim();
        
        if (isValidPhone(doctorPhone)) {
            if (isValidEmail(doctorEmail)) {
                if (!doctorID.isEmpty() && !doctorName.isEmpty() && !doctorPhone.isEmpty() && !doctorEmail.isEmpty() &&
                !doctorSpecialization.isEmpty() && !doctorDepartment.isEmpty() && !doctorExperience.isEmpty() &&
                !doctorQualifications.isEmpty() && !doctorStatus.isEmpty()) {
                    // Proceed with saving the data if all fields are filled
                    AdminAddDoctorModel doctor = new AdminAddDoctorModel(doctorID, doctorName, "password", doctorPhone, doctorEmail, 
                                                                        doctorSpecialization, doctorDepartment, doctorExperience, 
                                                                        doctorQualifications, doctorStatus);
            
                    boolean success = doctor.save();
                    if (success) {
                        JOptionPane.showMessageDialog(null, "Data saved successfully!");
                        MysqlConnect db = new MysqlConnect();
                        String newDoctorId = db.generateNewId("Doctors", "D");
                        doctorIDField.setText(newDoctorId);
                        doctorNameField.setText("");
                        doctorPhoneField.setText("");
                        doctorEmailField.setText("");
                        doctorSpecializationField.setText("");
                        doctorDepartmentField.setText("");
                        doctorExperienceField.setText("");
                        doctorQualificationsField.setText("");
                        doctorStatusComboBox.setSelectedItem("");
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to save data.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
   
                } else {
                    JOptionPane.showMessageDialog(null, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Invalid Email !");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Invalid Phone Number!");
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
        doctorStatusComboBox.setSelectedItem("");
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
