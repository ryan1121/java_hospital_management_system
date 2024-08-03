package hospital_management_system.controllers;

import hospital_management_system.models.Diagnosis;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JPanel;

public class DiagnosisController {
    private Diagnosis model;
    private JPanel panel;
    private JTextField diagnosisIDTextField;
    private JTextField dateOfDiagnosisTextField;
    private JTextArea diagnosisDescriptionTextArea;
    private JTextArea treatmentPlansTextArea;

    public DiagnosisController(
        JPanel panel,
        JTextField patientIDTextField,
        JTextField doctorIDTextField,
        JTextField diagnosisIDTextField,
        JTextField dateOfDiagnosisTextField,
        JTextArea diagnosisDescriptionTextArea,
        JTextArea treatmentPlansTextArea
    ) {
        this.panel = panel;
        this.diagnosisIDTextField = diagnosisIDTextField;
        this.dateOfDiagnosisTextField = dateOfDiagnosisTextField;
        this.diagnosisDescriptionTextArea = diagnosisDescriptionTextArea;
        this.treatmentPlansTextArea = treatmentPlansTextArea;
        this.model = new Diagnosis(
            panel,
            patientIDTextField,
            doctorIDTextField,
            diagnosisIDTextField,
            dateOfDiagnosisTextField,
            diagnosisDescriptionTextArea,
            treatmentPlansTextArea
        );

    }

    public void handleSaveButtonActionPerformed(ActionEvent evt) {
        if (model.save()) {
            Diagnosis.setNewDiagnosisId(diagnosisIDTextField);  // reset the new diagnosis ID
        }
    }

    public void handleClearButtonActionPerformed(ActionEvent evt) {
        model.clear(dateOfDiagnosisTextField, diagnosisDescriptionTextArea, treatmentPlansTextArea);
    }
}
