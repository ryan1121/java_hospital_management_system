/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital_management_system.models;

import java.sql.SQLException;

import hospital_management_system.MysqlConnect;

/**
 *
 * @author User
 */
public class BedAllocationModel {
    private String bedAllocateNumber;
    private String roomAllocateNumber;
    private String wardAllocateNumber;
    private String department;
    private String status;
    private String bedType;
    private String patientID;
    private String allocateDate;
    private String dischargeDate;
    private String preOccupation;
    private String emergencyEquipment;

    // Constructor with parameters
    public BedAllocationModel(String bedAllocateNumber, String roomAllocateNumber, String wardAllocateNumber,
                              String department, String status, String bedType, String patientID,
                              String allocateDate, String dischargeDate, String preOccupation,
                              String emergencyEquipment) {
        this.bedAllocateNumber = bedAllocateNumber;
        this.roomAllocateNumber = roomAllocateNumber;
        this.wardAllocateNumber = wardAllocateNumber;
        this.department = department;
        this.status = status;
        this.bedType = bedType;
        this.patientID = patientID;
        this.allocateDate = allocateDate;
        this.dischargeDate = dischargeDate;
        this.preOccupation = preOccupation;
        this.emergencyEquipment = emergencyEquipment;
    }

    // Default constructor
    public BedAllocationModel() {
        // Initialize fields if needed
    }

    public boolean save() {
        MysqlConnect db = new MysqlConnect();
        String tableName = "BedAllocation";
        String columns = "bed_allocate_number, room_allocate_number, ward_allocate_number, bed_allocation_department, bed_allocation_status, bed_type, bed_patient_id, allocate_date, discharge_date, pre_occ, emergency_equipment";
        String[] values = {
            bedAllocateNumber, roomAllocateNumber, wardAllocateNumber, department, status, bedType,
            patientID, allocateDate, dischargeDate, preOccupation, emergencyEquipment
        };

        try {
            return db.saveData(tableName, columns, values);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Getters and setters for all fields
    public String getBedAllocateNumber() { return bedAllocateNumber; }
    public void setBedAllocateNumber(String bedAllocateNumber) { this.bedAllocateNumber = bedAllocateNumber; }

    public String getRoomAllocateNumber() { return roomAllocateNumber; }
    public void setRoomAllocateNumber(String roomAllocateNumber) { this.roomAllocateNumber = roomAllocateNumber; }

    public String getWardAllocateNumber() { return wardAllocateNumber; }
    public void setWardAllocateNumber(String wardAllocateNumber) { this.wardAllocateNumber = wardAllocateNumber; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getBedType() { return bedType; }
    public void setBedType(String bedType) { this.bedType = bedType; }

    public String getPatientID() { return patientID; }
    public void setPatientID(String patientID) { this.patientID = patientID; }

    public String getAllocateDate() { return allocateDate; }
    public void setAllocateDate(String allocateDate) { this.allocateDate = allocateDate; }

    public String getDischargeDate() { return dischargeDate; }
    public void setDischargeDate(String dischargeDate) { this.dischargeDate = dischargeDate; }

    public String getPreOccupation() { return preOccupation; }
    public void setPreOccupation(String preOccupation) { this.preOccupation = preOccupation; }

    public String getEmergencyEquipment() { return emergencyEquipment; }
    public void setEmergencyEquipment(String emergencyEquipment) { this.emergencyEquipment = emergencyEquipment; }
}
