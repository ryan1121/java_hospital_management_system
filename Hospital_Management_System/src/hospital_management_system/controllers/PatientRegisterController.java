/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital_management_system.controllers;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import hospital_management_system.MysqlConnect;
import hospital_management_system.models.PatientRegisterModel;
import hospital_management_system.views.GUI_Patient_Register;
import hospital_management_system.views.GUI_patient;

/**
 *
 * @author User
 */
public class PatientRegisterController {
    private PatientRegisterModel model;
    private GUI_Patient_Register view;
    MysqlConnect db;

    public PatientRegisterController(PatientRegisterModel model, GUI_Patient_Register view) {
        this.model = model;
        this.view = view;
        db = new MysqlConnect();

        // Add action listeners to view buttons
        this.view.addSubmitListener(e -> submitForm());
        this.view.addResetListener(e -> resetForm());
    }

    private void submitForm() {
        // Get data from view
        model.setName(view.getRegisterName());
        model.setDob(view.getRegisterDOB());
        model.setPhone(view.getRegisterPhone());
        model.setEmail(view.getRegisterEmail());
        model.setAddress1(view.getRegisterAddress());
        model.setAddress2(view.getRegisterAddressLine2());
        model.setAddress3(view.getRegisterAddressLine3());
        model.setEmergencyName(view.getRegisterEmergencyName());
        model.setEmergencyRelation(view.getRegisterEmergencyRelation());
        model.setEmergencyPhone(view.getRegisterEmergencyPhone());
        model.setGender(view.getGender());

        // Validate data
        if (model.getName().isEmpty() || model.getDob().isEmpty() || model.getPhone().isEmpty() || model.getEmail().isEmpty() || model.getAddress1().isEmpty() || model.getGender() == null || model.getEmergencyName().isEmpty() || model.getEmergencyRelation().isEmpty() || model.getEmergencyPhone().isEmpty()) {
            JOptionPane.showMessageDialog(view, "Please fill in all required fields.", "Error", JOptionPane.ERROR_MESSAGE);
            
        } 
        else {
            if (isValidPhone(model.getPhone())) {
                System.out.println("Valid Phone");
                if (isValidEmail(model.getEmail())) {
                    System.out.println("Valid Email");
                    if (isValidPhone(model.getEmergencyPhone())) {
                        System.out.println("Valid Phone");
                        // Perform further processing, such as saving the data to a database or displaying it in a message dialog
                        String message = "Name: " + model.getName() + "\nDate of Birth: " + model.getDob() + "\nPhone: " + model.getPhone() + "\nEmail: " + model.getEmail() + "\nAddress: " + model.getAddress1() + ", " + model.getAddress2() + ", " + model.getAddress3() + "\nGender: " + model.getGender() + "\nEmergency Section" + "\nName: " + model.getEmergencyName() + "\nPhone: " + model.getEmergencyPhone() + "\nRelationship: " + model.getEmergencyRelation();
                        JOptionPane.showMessageDialog(view, message, "Registration Information", JOptionPane.INFORMATION_MESSAGE);
                        String newID = db.generateNewId("Patients", "P");

                        String tableName = "Patients";
                        String columns = "patient_id, patient_DOB, patient_gender, patient_phone, patient_name, patient_password, patient_email, patient_address, patient_address_line2, patient_address_line3, patient_emergency_name, patient_emergency_phone, patient_emergency_relationship";
                        String[] values = {newID, model.getDob(), model.getGender(), model.getPhone(), model.getName(), "password"+newID , model.getEmail(), model.getAddress1(), model.getAddress2(), model.getAddress3(), model.getEmergencyName(), model.getEmergencyPhone(), model.getEmergencyRelation()};

                        try {
                            boolean success = db.saveData(tableName, columns, values);
                            if (success) {
                                System.out.println("Data inserted successfully!");
                            } else {
                                System.out.println("Data insertion failed.");
                            }
                        } catch (SQLException e) {
                            System.err.println("Error occurred while inserting data.");
                            e.printStackTrace();
                        }

                        view.dispose();
                        GUI_patient Patient_GUI = new GUI_patient(newID);
                        Patient_GUI.setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(null, "Invalid Emergency Phone", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid Email", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Invalid Phone Number", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            
        }
    }

    private void resetForm() {
        view.setRegisterName("");
        view.setRegisterDOB("");
        view.setRegisterPhone("");
        view.setRegisterEmail("");
        view.setRegisterAddress("");
        view.setRegisterAddressLine2("");
        view.setRegisterAddressLine3("");
        view.setRegisterEmergencyName("");
        view.setRegisterEmergencyRelation("");
        view.setRegisterEmergencyPhone("");
        view.setGenderMale(false);
        view.setGenderFemale(false);
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
        String phoneRegex = "01\\d-\\d{7}";
        Pattern pattern = Pattern.compile(phoneRegex);
        if (phone == null) {
            return false;
        }
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }
}
