package hospital_management_system.controllers;

import hospital_management_system.models.SurgeryModel;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SurgeryController {
    private SurgeryModel model;
    private JPanel panel;
    private JTextField surgeryIDTextField;
    private JComboBox<String> surgeryTypeComboBox;
    private JTextField dateOfSurgeryTextField;
    private java.awt.TextField outcomesTextField;

    public SurgeryController(
        JPanel panel,
        JTextField patientIDTextField,
        JTextField doctorIDTextField,
        JTextField surgeryIDTextField,
        JComboBox<String> surgeryTypeComboBox,
        JTextField dateOfSurgeryTextField,
        java.awt.TextField outcomesTextField
    ) {
        this.panel = panel;
        this.surgeryIDTextField = surgeryIDTextField;
        this.surgeryTypeComboBox = surgeryTypeComboBox;
        this.dateOfSurgeryTextField = dateOfSurgeryTextField;
        this.outcomesTextField = outcomesTextField;
        this.model = new SurgeryModel(
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
            SurgeryModel.setNewSurgeryId(surgeryIDTextField);  // reset the new Surgery ID
        }
    }

    public void handleClearButtonActionPerformed(ActionEvent evt) {
        model.clear(surgeryTypeComboBox, dateOfSurgeryTextField, outcomesTextField);
    }
}
