package hospital_management_system.controllers;

import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import hospital_management_system.models.MedicalRecordsModel;
import javax.swing.JOptionPane;

public class MedicalRecordsController {
    private MedicalRecordsModel model;
    private JPanel panel;
    private JTextField patientIDTextField;
    private JTextField doctorIDTextField;
    private JTextField medicalRecordIDTextField;
    private JTextField dateOfVisitTextField;
    private java.awt.TextField notesTextField;
    private JTextArea treatmentPlansTextArea;

    public MedicalRecordsController(
        JPanel panel,
        JTextField patientIDTextField,
        JTextField doctorIDTextField,
        JTextField medicalRecordIDTextField,
        JTextField dateOfVisitTextField,
        java.awt.TextField notesTextField,
        JTextArea treatmentPlansTextArea
    ) {
        this.panel = panel;
        this.patientIDTextField = patientIDTextField;
        this.doctorIDTextField = doctorIDTextField;
        this.medicalRecordIDTextField = medicalRecordIDTextField;
        this.dateOfVisitTextField = dateOfVisitTextField;
        this.notesTextField = notesTextField;
        this.treatmentPlansTextArea = treatmentPlansTextArea;

        // Initialize the model with current values
        this.model = new MedicalRecordsModel(
            patientIDTextField.getText(),
            doctorIDTextField.getText(),
            medicalRecordIDTextField.getText(),
            dateOfVisitTextField.getText(),
            notesTextField.getText(),
            treatmentPlansTextArea.getText()
        );
    }

    public void handleSaveButtonActionPerformed(ActionEvent evt) {
        // Update model with current values
        model = new MedicalRecordsModel(
            patientIDTextField.getText(),
            doctorIDTextField.getText(),
            medicalRecordIDTextField.getText(),
            dateOfVisitTextField.getText(),
            notesTextField.getText(),
            treatmentPlansTextArea.getText()
        );
        
        if (model.save()) {
            MedicalRecordsModel.setNewMedicalRecordId(medicalRecordIDTextField);  // reset the new medical record ID
        } else {
            JOptionPane.showMessageDialog(panel, "Data saved unsuccessfully !");
        }
    }

    public void handleClearButtonActionPerformed(ActionEvent evt) {
        model.clear(dateOfVisitTextField, notesTextField, treatmentPlansTextArea);
    }
}
