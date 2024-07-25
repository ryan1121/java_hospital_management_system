package hospital_management_system.controllers;

import hospital_management_system.models.MedicalRecordsModel;

import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.TextField;

public class MedicalRecordsController {
    private MedicalRecordsModel model;
    private JPanel panel;
    private JTextField medicalRecordIDTextField;
    private JTextField dateOfVisitTextField;
    private TextField notesTextField;
    private JTextArea treatmentPlansTextArea;

    public MedicalRecordsController(
        JPanel panel,
        JTextField patientIDTextField,
        JTextField doctorIDTextField,
        JTextField medicalRecordIDTextField,
        JTextField dateOfVisitTextField,
        TextField notesTextField,
        JTextArea treatmentPlansTextArea
    ) {
        this.panel = panel;
        this.medicalRecordIDTextField = medicalRecordIDTextField;
        this.dateOfVisitTextField = dateOfVisitTextField;
        this.notesTextField = notesTextField;
        this.treatmentPlansTextArea = treatmentPlansTextArea;
        this.model = new MedicalRecordsModel(
            panel,
            patientIDTextField,
            doctorIDTextField,
            medicalRecordIDTextField,
            dateOfVisitTextField,
            notesTextField,
            treatmentPlansTextArea
        );
    }

    public void handleSaveButtonActionPerformed(ActionEvent evt) {
        if (model.save()) {
            MedicalRecordsModel.setNewMedicalRecordId(medicalRecordIDTextField);  // reset the new medical record ID
        }
    }

    public void handleClearButtonActionPerformed(ActionEvent evt) {
        model.clear(dateOfVisitTextField, notesTextField, treatmentPlansTextArea);
    }
}
