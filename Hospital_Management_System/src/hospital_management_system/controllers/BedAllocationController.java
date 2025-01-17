/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital_management_system.controllers;

import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import hospital_management_system.MysqlConnect;
import hospital_management_system.models.BedAllocationModel;
import hospital_management_system.models.NurseGetPatientModel;
import hospital_management_system.utils.DateTimeUtils;

/**
 *
 * @author User
 */
public class BedAllocationController {
    private BedAllocationModel model;
    private JTextField bed_allocate_number;
    private JTextField room_allocate_number;
    private JTextField ward_allocate_number;
    private JTextField bed_allocation_department;
    private JComboBox<String> bed_allocation_status;
    private JComboBox<String> bed_type1;
    private JTextField bed_patient_id1;
    private JTextField allocate_date1;
    private JTextField discharge_date1;
    private JTextField pre_occ1;
    private JList<String> emergency_equipment;

    public BedAllocationController(JTextField bed_allocate_number, JTextField room_allocate_number, JTextField ward_allocate_number,
                                   JTextField bed_allocation_department, JComboBox<String> bed_allocation_status,
                                   JComboBox<String> bed_type1, JTextField bed_patient_id1,
                                   JTextField allocate_date1, JTextField discharge_date1, JTextField pre_occ1,
                                   JList<String> emergency_equipment) {
        this.bed_allocate_number = bed_allocate_number;
        this.room_allocate_number = room_allocate_number;
        this.ward_allocate_number = ward_allocate_number;
        this.bed_allocation_department = bed_allocation_department;
        this.bed_allocation_status = bed_allocation_status;
        this.bed_type1 = bed_type1;
        this.bed_patient_id1 = bed_patient_id1;
        this.allocate_date1 = allocate_date1;
        this.discharge_date1 = discharge_date1;
        this.pre_occ1 = pre_occ1;
        this.emergency_equipment = emergency_equipment;
    }

    public void handleSaveActionPerformed(ActionEvent evt) {
        String bedAllocateNumber = bed_allocate_number.getText();
        String roomAllocateNumber = room_allocate_number.getText();
        String wardAllocateNumber = ward_allocate_number.getText();
        String department = bed_allocation_department.getText();
        String status = bed_allocation_status.getSelectedItem().toString();
        String bedType = bed_type1.getSelectedItem().toString();
        String patientID = bed_patient_id1.getText();
        String formattedAllocateDate = DateTimeUtils.formatDate(allocate_date1.getText());
        String formattedDischargeDate = DateTimeUtils.formatDate(discharge_date1.getText());
        String preOccupation = pre_occ1.getText();
        String selectedEquipment = emergency_equipment.getSelectedValue();
    
        // Validate input fields
        if (bedAllocateNumber.isEmpty() || roomAllocateNumber.isEmpty() || wardAllocateNumber.isEmpty() || 
            department.isEmpty() || status.isEmpty() || bedType.isEmpty() || patientID.isEmpty() || 
            formattedAllocateDate.isEmpty() || preOccupation.isEmpty() || selectedEquipment.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all required fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    
        // Initialize database connection
        MysqlConnect db = new MysqlConnect();

        model = new BedAllocationModel(
            bedAllocateNumber, roomAllocateNumber, wardAllocateNumber, department, status, bedType,
            patientID, formattedAllocateDate, formattedDischargeDate, preOccupation, selectedEquipment
        );
    
        // Check if the bed allocation number exists
        String condition = "bed_allocate_number = '" + bedAllocateNumber + "'";
        ResultSet bedExistsResult = db.getData("BedAllocation", condition);
    
        try {
            if (bedExistsResult.next()) {
                // Record exists, perform update
                StringBuilder updateBuilder = new StringBuilder();
    
                // Only update fields that are not empty
                if (!roomAllocateNumber.isEmpty()) {
                    updateBuilder.append("room_allocate_number = '").append(roomAllocateNumber).append("', ");
                }
                if (!wardAllocateNumber.isEmpty()) {
                    updateBuilder.append("ward_allocate_number = '").append(wardAllocateNumber).append("', ");
                }
                if (!department.isEmpty()) {
                    updateBuilder.append("bed_allocation_department = '").append(department).append("', ");
                }
                if (!status.isEmpty()) {
                    updateBuilder.append("bed_allocation_status = '").append(status).append("', ");
                }
                if (!bedType.isEmpty()) {
                    updateBuilder.append("bed_type = '").append(bedType).append("', ");
                }
                if (!patientID.isEmpty()) {
                    updateBuilder.append("bed_patient_id = '").append(patientID).append("', ");
                }
                if (!formattedAllocateDate.isEmpty()) {
                    updateBuilder.append("allocate_date = '").append(formattedAllocateDate).append("', ");
                }
                if (!formattedDischargeDate.isEmpty()) {
                    updateBuilder.append("discharge_date = '").append(formattedDischargeDate).append("', ");
                }
                if (!preOccupation.isEmpty()) {
                    updateBuilder.append("pre_occ = '").append(preOccupation).append("', ");
                }
                if (!selectedEquipment.isEmpty()) {
                    updateBuilder.append("emergency_equipment = '").append(selectedEquipment).append("', ");
                }
    
                // Remove the last comma and space
                String update = updateBuilder.toString();
                if (update.endsWith(", ")) {
                    update = update.substring(0, update.length() - 2);
                }
    
                // Only perform the update if the update string is not empty
                if (!update.isEmpty()) {
                    boolean updateSuccess = db.updateData("BedAllocation", update, condition);
                    if (updateSuccess) {
                        JOptionPane.showMessageDialog(null, "Data updated successfully!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to update data. Please try again.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "There is no data to update!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                // Record does not exist, perform insert
                boolean saveSuccess = model.save();
                if (saveSuccess) {
                    JOptionPane.showMessageDialog(null, "Data inserted successfully!");
    
                    // Reset text fields after saving new bed allocation information
                    String newBedNo = db.generateNewId("BedAllocation", "B");
                    bed_allocate_number.setText(newBedNo);
                    room_allocate_number.setText("");
                    ward_allocate_number.setText("");
                    bed_allocation_department.setText("");
                    bed_patient_id1.setText("");
                    discharge_date1.setText("");
                    allocate_date1.setText("");
                    pre_occ1.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to insert data. Please try again.");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error checking bed allocation: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void handleClearActionPerformed(ActionEvent evt) {
        bed_allocate_number.setText("");
        room_allocate_number.setText("");
        ward_allocate_number.setText("");
        bed_allocation_department.setText("");
        bed_patient_id1.setText("");
        discharge_date1.setText("");
        allocate_date1.setText("");
        pre_occ1.setText("");
    }

    public void handleCheckActionPerformed(ActionEvent evt) {
        String bedAllocateNumber = bed_allocate_number.getText();
        String roomAllocateNumber = room_allocate_number.getText();
        String wardAllocateNumber = ward_allocate_number.getText();
        String department = bed_allocation_department.getText();
        String status = bed_allocation_status.getSelectedItem().toString();
        String bedType = bed_type1.getSelectedItem().toString();
        String patientID = bed_patient_id1.getText();
        String formattedAllocateDate = DateTimeUtils.formatDate(allocate_date1.getText());
        String formattedDischargeDate = DateTimeUtils.formatDate(discharge_date1.getText());
        String preOccupation = pre_occ1.getText();
        String selectedEquipment = emergency_equipment.getSelectedValue();

        model = new BedAllocationModel (bedAllocateNumber, roomAllocateNumber, wardAllocateNumber, department, status, bedType,
                                        patientID, formattedAllocateDate, formattedDischargeDate, preOccupation, selectedEquipment);
    
        ResultSet bedResultSet = model.fetchBedInfo(bedAllocateNumber);
    
            try {
                if (bedResultSet != null && bedResultSet.next()) {
                    // Extract patient data
                    String bed = bedResultSet.getString("bed_allocate_number");
                    String room = bedResultSet.getString("room_allocate_number");
                    String ward = bedResultSet.getString("ward_allocate_number");
                    String dpt = bedResultSet.getString("bed_allocation_department");
                    String bedStatus = bedResultSet.getString("bed_allocation_status");
                    String type = bedResultSet.getString("bed_type");
                    String bedPatientID = bedResultSet.getString("bed_patient_id");
                    String allocate_date = bedResultSet.getString("allocate_date");
                    String discharge_date = bedResultSet.getString("discharge_date");
                    String patientStatus = bedResultSet.getString("pre_occ");
                    String equipment = bedResultSet.getString("emergency_equipment");

                    SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd"); 
                    SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
            
                    Date date = inputFormat.parse(allocate_date);
                    String formattedAllocationDate = outputFormat.format(date);

                    Date date2 = inputFormat.parse(discharge_date);
                    String formattedDisDate = outputFormat.format(date2);
    
                    // Set data to fields
                    bed_allocate_number.setText(bed);
                    room_allocate_number.setText(room);
                    ward_allocate_number.setText(ward);
                    bed_allocation_department.setText(dpt);
                    bed_allocation_status.setSelectedItem(bedStatus);
                    bed_type1.setSelectedItem(type);
                    bed_patient_id1.setText(bedPatientID);
                    discharge_date1.setText(formattedDisDate);
                    allocate_date1.setText(formattedAllocationDate);
                    pre_occ1.setText(patientStatus);
                    emergency_equipment.setSelectedValue(equipment, true);

                } else {
                    JOptionPane.showMessageDialog(null, "Information of this bed does not exist.");
                }
            } catch (SQLException | ParseException e) {
                e.printStackTrace();
            }
        }

}
