/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital_management_system.controllers;

import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

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

        if (bedAllocateNumber.isEmpty() || roomAllocateNumber.isEmpty() || wardAllocateNumber.isEmpty() || 
        department.isEmpty() || status.isEmpty() || bedType.isEmpty() || patientID.isEmpty() || 
        formattedAllocateDate.isEmpty() || preOccupation.isEmpty() || selectedEquipment.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all required fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        model = new BedAllocationModel(
            bedAllocateNumber, roomAllocateNumber, wardAllocateNumber, department, status, bedType,
            patientID, formattedAllocateDate, formattedDischargeDate, preOccupation, selectedEquipment
        );

        if (model.save()) {
            JOptionPane.showMessageDialog(null, "Data inserted successfully!");
            // Reset text fields after saving new bed allocation information
            MysqlConnect db = new MysqlConnect();
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
            JOptionPane.showMessageDialog(null, "No Data Update.");
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
    
                    // Set data to fields
                    bed_allocate_number.setText(bed);
                    room_allocate_number.setText(room);
                    ward_allocate_number.setText(ward);
                    bed_allocation_department.setText(dpt);
                    bed_allocation_status.setSelectedItem(bedStatus);
                    bed_type1.setSelectedItem(type);
                    bed_patient_id1.setText(bedPatientID);
                    discharge_date1.setText(discharge_date);
                    allocate_date1.setText(allocate_date);
                    pre_occ1.setText(patientStatus);
                    emergency_equipment.setSelectedValue(equipment, true);

                } else {
                    JOptionPane.showMessageDialog(null, "Information of this bed does not exist.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

}
