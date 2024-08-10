package hospital_management_system.controllers;

import hospital_management_system.models.Surgery;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SurgeryController {
    private Surgery model;
    private JPanel panel;
    private JTextField surgeryIDTextField;
    private JComboBox<String> surgeryTypeComboBox;
    private JTextField dateOfSurgeryTextField;
    private JTextField outcomesTextField;

    public SurgeryController(
        JPanel panel,
        JTextField patientIDTextField,
        JTextField doctorIDTextField,
        JTextField surgeryIDTextField,
        JComboBox<String> surgeryTypeComboBox,
        JTextField dateOfSurgeryTextField,
        JTextField outcomesTextField
    ) {
        this.panel = panel;
        this.surgeryIDTextField = surgeryIDTextField;
        this.surgeryTypeComboBox = surgeryTypeComboBox;
        this.dateOfSurgeryTextField = dateOfSurgeryTextField;
        this.outcomesTextField = outcomesTextField;
        this.model = new Surgery(
            panel,
            surgeryIDTextField,
            patientIDTextField,
            doctorIDTextField,
            surgeryTypeComboBox,
            dateOfSurgeryTextField,
            outcomesTextField
        );
    }

    public void handleSaveButtonActionPerformed(ActionEvent evt) {
        if (model.save()) {
            Surgery.setNewSurgeryId(surgeryIDTextField);  // reset the new Surgery ID
        }
    }

    public void handleClearButtonActionPerformed(ActionEvent evt) {
        model.clear(surgeryTypeComboBox, dateOfSurgeryTextField, outcomesTextField);
    }
}
