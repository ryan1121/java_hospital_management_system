package hospital_management_system.controllers;

import hospital_management_system.models.ConsultationModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.TextField;

public class ConsultationController {
    private ConsultationModel model;
    private JPanel panel;
    private JTextField consultationIDTextField;
    private JTextField patientIDTextField;
    private JTextField doctorIDTextField;
    private JFormattedTextField dateOfConsultationTextField;
    private TextField notes_textField;
    private JButton saveButton;
    private JButton clearButton;

    public ConsultationController(
        JPanel panel,
        JTextField consultationIDTextField,
        JTextField patientIDTextField,
        JTextField doctorIDTextField,
        JFormattedTextField dateOfConsultationTextField,
        TextField notes_textField,
        JButton saveButton,
        JButton clearButton
    ) {
        this.panel = panel;
        this.consultationIDTextField = consultationIDTextField;
        this.patientIDTextField = patientIDTextField;
        this.doctorIDTextField = doctorIDTextField;
        this.dateOfConsultationTextField = dateOfConsultationTextField;
        this.notes_textField = notes_textField;
        this.saveButton = saveButton;
        this.clearButton = clearButton;

        this.saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSaveButtonActionPerformed(e);
            }
        });

        this.clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleClearButtonActionPerformed(e);
            }
        });

        // Set new Consultation ID
        ConsultationModel.setNewConsultationId(consultationIDTextField);
    }

    public void handleSaveButtonActionPerformed(ActionEvent evt) {
        this.model = new ConsultationModel(
            panel,
            consultationIDTextField,
            patientIDTextField,
            doctorIDTextField,
            dateOfConsultationTextField,
            notes_textField
        );
        String patientID = patientIDTextField.getText().trim();
        String doctorID = doctorIDTextField.getText().trim();
        System.out.println("Patient ID from Controller: " + patientID);
        System.out.println("Doctor ID from Controller: " + doctorID);
        if (model.save()) {
            ConsultationModel.setNewConsultationId(consultationIDTextField);  // reset the new consultation ID
        }
    }

    public void handleClearButtonActionPerformed(ActionEvent evt) {
        model.clear(dateOfConsultationTextField, notes_textField);
    }
}
