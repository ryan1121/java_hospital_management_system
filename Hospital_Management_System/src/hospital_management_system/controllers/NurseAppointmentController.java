/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital_management_system.controllers;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import hospital_management_system.MysqlConnect;
import hospital_management_system.models.NurseAppointmentModel;
import hospital_management_system.utils.DateTimeUtils;

/**
 *
 * @author User
 */
public class NurseAppointmentController {
    private NurseAppointmentModel model;
    private JTextField Appointment_ID;
    private JTextField app_patient_id;
    private JTextField app_doctor_id;
    private JTextField app_date;
    private JTextField app_time;
    private JTextField appointment_notes;
    private JTextField appointment_type;
    private JTextField app_status;
    private JTextField app_reason;
    private JTextField app_location;
    private JTextField nurse_id;
    private JTextField booking_date;
    private JTextField app_cancel;

    public NurseAppointmentController(JTextField Appointment_ID, JTextField app_patient_id, JTextField app_doctor_id,
                                      JTextField app_date, JTextField app_time, JTextField appointment_notes,
                                      JTextField appointment_type, JTextField app_status, JTextField app_reason,
                                      JTextField app_location, JTextField nurse_id, JTextField booking_date, 
                                      JTextField app_cancel) {
        this.Appointment_ID = Appointment_ID;
        this.app_patient_id = app_patient_id;
        this.app_doctor_id = app_doctor_id;
        this.app_date = app_date;
        this.app_time = app_time;
        this.appointment_notes = appointment_notes;
        this.appointment_type = appointment_type;
        this.app_status = app_status;
        this.app_reason = app_reason;
        this.app_location = app_location;
        this.nurse_id = nurse_id;
        this.booking_date = booking_date;
        this.app_cancel = app_cancel;
    }

    public void handleSaveActionPerformed(ActionEvent evt) {
        String appointmentID = Appointment_ID.getText();
        String formattedAppDate = DateTimeUtils.formatDate(app_date.getText());
        String formattedBookingDate = DateTimeUtils.formatDate(booking_date.getText());
        String formattedTime = DateTimeUtils.formatTime(app_time.getText());
        String trytime = DateTimeUtils.formatTime("8:00 PM");
        System.out.println(trytime);

        if (formattedTime == null) {
            System.out.println("Invalid time format. Please enter the time in 'h:mm a' format.");
            return;
        }

        var patientID = app_patient_id.getText();
        String doctorID = app_doctor_id.getText();
        String notes = appointment_notes.getText();
        String appointmentType = appointment_type.getText();
        String status = app_status.getText();
        String reason = app_reason.getText();
        String location = app_location.getText();
        String admittingStaffID = nurse_id.getText();
        String cancelReason = app_cancel.getText();

        model = new NurseAppointmentModel(
            appointmentID, patientID, doctorID, formattedAppDate, formattedTime, notes, 
            appointmentType, status, reason, location, admittingStaffID, formattedBookingDate, cancelReason
        );

        if (model.save()) {
            JOptionPane.showMessageDialog(null, "Data inserted successfully!");
            // Generate new Appointment ID and clear fields
            MysqlConnect db = new MysqlConnect();
            String newAppointmentId = db.generateNewId("Appointment", "AP");
            Appointment_ID.setText(newAppointmentId);
            app_patient_id.setText("");
            app_doctor_id.setText("");
            app_date.setText("");
            app_time.setText("");
            app_reason.setText("");
            appointment_type.setText("");
            app_location.setText("");
            appointment_notes.setText("");
            app_cancel.setText("");
            booking_date.setText("");
            app_status.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Data insertion failed.");
        }
    }

    public void handleClearActionPerformed(ActionEvent evt) {
        app_patient_id.setText("");
        app_doctor_id.setText("");
        app_date.setText("");
        app_time.setText("");
        app_reason.setText("");
        appointment_type.setText("");
        app_location.setText("");
        appointment_notes.setText("");
        app_cancel.setText("");
        booking_date.setText("");
        app_status.setText("");
    }
}
