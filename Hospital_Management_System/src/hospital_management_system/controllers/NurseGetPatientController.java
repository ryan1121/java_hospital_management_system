/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital_management_system.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import hospital_management_system.MysqlConnect;
import hospital_management_system.models.NurseGetPatientModel;
import hospital_management_system.utils.DateTimeUtils;

/**
 *
 * @author User
 */
public class NurseGetPatientController {
    private NurseGetPatientModel model;
    private JTextField patientIDField;
    private JTextField patientNameField;
    private JTextField patientDOBField;
    private JTextField patientPhoneField;
    private JTextField patientEmailField;
    private JTextField patientAddressField;
    private JTextField patientAddressLine2Field;
    private JTextField patientAddressLine3Field;
    private JTextField patientWardField;
    private JTextField patientBedNumberField;
    private JTextField patientRoomNumberField;
    private JComboBox<String> patientGenderComboBox;

    public NurseGetPatientController(JTextField patientIDField, JTextField patientNameField, JTextField patientDOBField,
                                 JTextField patientPhoneField, JTextField patientEmailField, JTextField patientAddressField,
                                 JTextField patientAddressLine2Field, JTextField patientAddressLine3Field,
                                 JTextField patientWardField, JTextField patientBedNumberField, JTextField patientRoomNumberField,
                                 JComboBox<String> patientGenderComboBox) {
        this.patientIDField = patientIDField;
        this.patientNameField = patientNameField;
        this.patientDOBField = patientDOBField;
        this.patientPhoneField = patientPhoneField;
        this.patientEmailField = patientEmailField;
        this.patientAddressField = patientAddressField;
        this.patientAddressLine2Field = patientAddressLine2Field;
        this.patientAddressLine3Field = patientAddressLine3Field;
        this.patientWardField = patientWardField;
        this.patientBedNumberField = patientBedNumberField;
        this.patientRoomNumberField = patientRoomNumberField;
        this.patientGenderComboBox = patientGenderComboBox;
    }

    public void fetchPatientData() {
        String patientID = patientIDField.getText().trim();
        String name = patientNameField.getText();
        String gender = patientGenderComboBox.getSelectedItem().toString(); // Assuming it's a JComboBox
        String dob = patientDOBField.getText();
        String phone = patientPhoneField.getText();
        String email = patientEmailField.getText();
        String address = patientAddressField.getText();
        String addressLine2 = patientAddressLine2Field.getText();
        String addressLine3 = patientAddressLine3Field.getText();
        String ward = patientWardField.getText();
        String bedNumber = patientBedNumberField.getText();
        String roomNumber = patientRoomNumberField.getText();
        model = new NurseGetPatientModel (patientID, name,gender,dob,phone,email,address,addressLine2,addressLine3,ward,bedNumber,roomNumber );

        ResultSet patientResultSet = model.fetchPatient(patientID);

        try {
            if (patientResultSet != null && patientResultSet.next()) {
                // Extract patient data
                String name1 = patientResultSet.getString("patient_name");
                String gender1 = patientResultSet.getString("patient_gender");
                String dob1 = patientResultSet.getString("patient_DOB");
                String phone1 = patientResultSet.getString("patient_phone");
                String email1 = patientResultSet.getString("patient_email");
                String address1 = patientResultSet.getString("patient_address");
                String address2 = patientResultSet.getString("patient_address_line2");
                String address3 = patientResultSet.getString("patient_address_line3");

                SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd"); 
                SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
        
                Date date = inputFormat.parse(dob1);
                String formattedDOB = outputFormat.format(date);

                // Set data to fields
                patientNameField.setText(name1);
                patientDOBField.setText(formattedDOB);
                patientPhoneField.setText(phone1);
                patientEmailField.setText(email1);
                patientAddressField.setText(address1);
                patientAddressLine2Field.setText(address2);
                patientAddressLine3Field.setText(address3);

                // Fetch bed information
                ResultSet bedResultSet = model.fetchBedInfo(patientID);
                if (bedResultSet != null && bedResultSet.next()) {
                    patientWardField.setText(bedResultSet.getString("ward_allocate_number"));
                    patientBedNumberField.setText(bedResultSet.getString("bed_allocate_number"));
                    patientRoomNumberField.setText(bedResultSet.getString("room_allocate_number"));
                } else {
                    patientWardField.setText("");
                    patientBedNumberField.setText("");
                    patientRoomNumberField.setText("");
                }

                // Set gender in JComboBox
                DefaultComboBoxModel<String> comboBoxModel = (DefaultComboBoxModel<String>) patientGenderComboBox.getModel();
                if (comboBoxModel.getIndexOf(gender1) != -1) {
                    patientGenderComboBox.setSelectedItem(gender1);
                } else {
                    patientGenderComboBox.setSelectedIndex(0);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Patient does not exist. Ready to add new record!");
                MysqlConnect db = new MysqlConnect();
                String newId = db.generateNewId("Patients", "P");
                patientIDField.setText(newId);
                patientNameField.setText("");
                patientDOBField.setText("");
                patientPhoneField.setText("");
                patientEmailField.setText("");
                patientAddressField.setText("");
                patientAddressLine2Field.setText("");
                patientAddressLine3Field.setText("");
                patientWardField.setText("");
                patientBedNumberField.setText("");
                patientRoomNumberField.setText("");
                patientGenderComboBox.setSelectedItem(""); 
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
    }

    public void handleSaveActionPerformed() {
        String patientID = patientIDField.getText().trim();
        String patientDOB = DateTimeUtils.formatDate(patientDOBField.getText().trim());
        String patientGender = (String) patientGenderComboBox.getSelectedItem();
        String patientPhone = patientPhoneField.getText().trim();
        String patientName = patientNameField.getText().trim();
        String patientEmail = patientEmailField.getText().trim();
        String patientAddress = patientAddressField.getText().trim();
        String patientAddressLine2 = patientAddressLine2Field.getText().trim();
        String patientAddressLine3 = patientAddressLine3Field.getText().trim();
        String ward = patientWardField.getText().trim();
        String bedNumber = patientBedNumberField.getText().trim();
        String roomNumber = patientRoomNumberField.getText().trim();
    
        MysqlConnect db = new MysqlConnect();
    
        // Validate input
        if (isValidInput(patientID, patientDOB, patientPhone, patientName, patientEmail, patientAddress, ward, bedNumber, roomNumber)) {

            // Check if patientID exists in the database
            String conditionCheck = "patient_id = '" + patientID + "'";
            ResultSet patientExists = db.getData("Patients", conditionCheck);
                
            try{
                if (patientExists.next()) {
                    // Update existing record in Patients table
                    StringBuilder updateBuilder = new StringBuilder();
                    String condition = "patient_id = '" + patientID + "'";
                    String BedCondition = "bed_patient_id = '" + patientID + "'";
        
                    if (!patientID.isEmpty()) {
                        updateBuilder.append("patient_id = '").append(patientID).append("', ");
                    }
                    if (!patientName.isEmpty()) {
                        updateBuilder.append("patient_name = '").append(patientName).append("', ");
                    }
                    if (!patientGender.isEmpty()) {
                        updateBuilder.append("patient_gender = '").append(patientGender).append("', ");
                    }
                    if (!patientDOB.isEmpty()) {
                        updateBuilder.append("patient_DOB = '").append(patientDOB).append("', ");
                    }
                    if (!patientPhone.isEmpty()) {
                        updateBuilder.append("patient_phone = '").append(patientPhone).append("', ");
                    }
                    if (!patientEmail.isEmpty()) {
                        updateBuilder.append("patient_email = '").append(patientEmail).append("', ");
                    }
                    if (!patientAddress.isEmpty()) {
                        updateBuilder.append("patient_address = '").append(patientAddress).append("', ");
                    }
                    if (!patientAddressLine2.isEmpty()) {
                        updateBuilder.append("patient_address_line2 = '").append(patientAddressLine2).append("', ");
                    }
                    if (!patientAddressLine3.isEmpty()) {
                        updateBuilder.append("patient_address_line3 = '").append(patientAddressLine3).append("', ");
                    }
        
                    // Remove the last comma and space
                    String update = updateBuilder.toString();
                    if (update.endsWith(", ")) {
                        update = update.substring(0, update.length() - 2);
                    }
        
                    // Only perform the update if the update string is not empty
                    if (!update.isEmpty()) {
                        boolean updateSuccess = db.updateData("Patients", update, condition);
                        if (updateSuccess) {
                            JOptionPane.showMessageDialog(null, "Patient data updated successfully!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Failed to update patient data. Please try again.");
                        }
                    }
        
                    // Update BedAllocation table
                    updateBuilder.setLength(0); // Clear the updateBuilder
                    if (!ward.isEmpty()) {
                        updateBuilder.append("ward_allocate_number = '").append(ward).append("', ");
                    }
                    if (!bedNumber.isEmpty()) {
                        updateBuilder.append("bed_allocate_number = '").append(bedNumber).append("', ");
                    }
                    if (!roomNumber.isEmpty()) {
                        updateBuilder.append("room_allocate_number = '").append(roomNumber).append("', ");
                    }
        
                    // Remove the last comma and space
                    update = updateBuilder.toString();
                    if (update.endsWith(", ")) {
                        update = update.substring(0, update.length() - 2);
                    }
        
                    if (!update.isEmpty()) {
                        boolean bedUpdateSuccess = db.updateData("BedAllocation", update, BedCondition);
                        if (bedUpdateSuccess) {
                            JOptionPane.showMessageDialog(null, "Bed allocation updated successfully!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Failed to update bed allocation. Please try again.");
                        }
                    }
                } else {
                    // Save new patient data
                    NurseGetPatientModel patient = new NurseGetPatientModel(
                                                patientID, 
                                                patientName, 
                                                patientGender, 
                                                patientDOB,
                                                patientPhone,
                                                patientEmail, 
                                                patientAddress,
                                                patientAddressLine2,
                                                patientAddressLine3,
                                                ward,
                                                bedNumber,
                                                roomNumber
                                                );
        
                    boolean success = patient.save();
                    if (success) {
                        JOptionPane.showMessageDialog(null, "Data saved successfully!");
                        handleClearActionPerformed(); // Clear fields after successful save
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to save data. Please check your input and try again.");
                    }
                }
            }catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error checking bed allocation: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid input. Please ensure all fields are filled correctly.");
        }
    }

    private boolean isValidInput(String patientID, String patientDOB, String patientPhone, String patientName, String patientEmail, 
                                String patientAddress, String ward, String bedNumber, String roomNumber) {
        
        // First, validate the phone number
        if (!isValidPhone(patientPhone)) {
            JOptionPane.showMessageDialog(null, "Invalid phone number.");
            return false;
        }

        // Then, validate the email
        if (!isValidEmail(patientEmail)) {
            JOptionPane.showMessageDialog(null, "Invalid email address.");
            return false;
        }

        // Lastly, validate the remaining fields
        if (patientID.isEmpty() || patientDOB.isEmpty() || patientName.isEmpty() || patientAddress.isEmpty() || 
            ward.isEmpty() || bedNumber.isEmpty() || roomNumber.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all required fields.");
            return false;
        }

        return true;
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

    public void handleClearActionPerformed() {
        MysqlConnect db = new MysqlConnect();
        String newId = db.generateNewId("Patients", "P");
        patientIDField.setText(newId);
        patientNameField.setText("");
        patientDOBField.setText("");
        patientPhoneField.setText("");
        patientEmailField.setText("");
        patientAddressField.setText("");
        patientAddressLine2Field.setText("");
        patientAddressLine3Field.setText("");
        patientWardField.setText("");
        patientBedNumberField.setText("");
        patientRoomNumberField.setText("");
        patientGenderComboBox.setSelectedItem("");
    }
}
