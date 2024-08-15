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
public class NurseAppointmentModel {
    private String appointmentID;
    private String patientID;
    private String doctorID;
    private String appointmentDate;
    private String appointmentTime;
    private String notes;
    private String appointmentType;
    private String status;
    private String reason;
    private String location;
    private String admittingStaffID;
    private String bookingDate;
    private String cancelReason;

    // Constructor with parameters
    public NurseAppointmentModel(String appointmentID, String patientID, String doctorID,
                                 String appointmentDate, String appointmentTime, String notes,
                                 String appointmentType, String status, String reason,
                                 String location, String admittingStaffID, String bookingDate,
                                 String cancelReason) {
        this.appointmentID = appointmentID;
        this.patientID = patientID;
        this.doctorID = doctorID;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.notes = notes;
        this.appointmentType = appointmentType;
        this.status = status;
        this.reason = reason;
        this.location = location;
        this.admittingStaffID = admittingStaffID;
        this.bookingDate = bookingDate;
        this.cancelReason = cancelReason;
    }

    // Default constructor
    public NurseAppointmentModel() {
        // Initialize fields if needed
    }

    public boolean save() {
        MysqlConnect db = new MysqlConnect();
        String tableName = "Appointment";
        String columns = "Appointment_ID, app_patient_id, app_doctor_id, app_date, app_time, appointment_notes, appointment_type, app_status, app_reason, app_location, Admitting_Staff_ID, booking_date, app_cancel";
        String[] values = {
            appointmentID, patientID, doctorID, appointmentDate, appointmentTime, notes,
            appointmentType, status, reason, location, admittingStaffID, bookingDate, cancelReason
        };

        try {
            return db.saveData(tableName, columns, values);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Getters and setters for all fields
    public String getAppointmentID() { return appointmentID; }
    public void setAppointmentID(String appointmentID) { this.appointmentID = appointmentID; }

    public String getPatientID() { return patientID; }
    public void setPatientID(String patientID) { this.patientID = patientID; }

    public String getDoctorID() { return doctorID; }
    public void setDoctorID(String doctorID) { this.doctorID = doctorID; }

    public String getAppointmentDate() { return appointmentDate; }
    public void setAppointmentDate(String appointmentDate) { this.appointmentDate = appointmentDate; }

    public String getAppointmentTime() { return appointmentTime; }
    public void setAppointmentTime(String appointmentTime) { this.appointmentTime = appointmentTime; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public String getAppointmentType() { return appointmentType; }
    public void setAppointmentType(String appointmentType) { this.appointmentType = appointmentType; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getAdmittingStaffID() { return admittingStaffID; }
    public void setAdmittingStaffID(String admittingStaffID) { this.admittingStaffID = admittingStaffID; }

    public String getBookingDate() { return bookingDate; }
    public void setBookingDate(String bookingDate) { this.bookingDate = bookingDate; }

    public String getCancelReason() { return cancelReason; }
    public void setCancelReason(String cancelReason) { this.cancelReason = cancelReason; }
}
