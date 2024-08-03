package hospital_management_system.controllers;

import hospital_management_system.models.PrescriptionModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrescriptionController {
    private PrescriptionModel model;
    private JPanel panel;
    private JTextField prescriptionIDTextField;
    private JTextField patientIDTextField;
    private JTextField doctorIDTextField;
    private JComboBox<String> Medication_comboxBox;
    private JSpinner dosage_Spinner;
    private JTextField prescriptionDateTextField;
    private JTextArea instructionsTextArea;
    private JButton saveButton;
    private JButton clearButton;

    public PrescriptionController(
        JPanel panel,
        JTextField prescriptionIDTextField,
        JTextField patientIDTextField,
        JTextField doctorIDTextField,
        JComboBox<String> Medication_comboxBox,
        JSpinner dosage_Spinner,
        JTextField prescriptionDateTextField,
        JTextArea instructionsTextArea,
        JButton saveButton,
        JButton clearButton
    ) {
        this.panel = panel;
        this.prescriptionIDTextField = prescriptionIDTextField;
        this.patientIDTextField = patientIDTextField;
        this.doctorIDTextField = doctorIDTextField;
        this.Medication_comboxBox = Medication_comboxBox;
        this.dosage_Spinner = dosage_Spinner;
        this.prescriptionDateTextField = prescriptionDateTextField;
        this.instructionsTextArea = instructionsTextArea;
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

        // Set new Prescription ID
        PrescriptionModel.setNewPrescriptionId(prescriptionIDTextField);
    }

    public void handleSaveButtonActionPerformed(ActionEvent evt) {
        // 在创建 PrescriptionModel 前读取最新的输入值
        this.model = new PrescriptionModel(
            panel,
            prescriptionIDTextField,
            patientIDTextField,
            doctorIDTextField,
            Medication_comboxBox,
            dosage_Spinner,
            prescriptionDateTextField,
            instructionsTextArea
        );
        String patientID = patientIDTextField.getText().trim();
        String doctorID = doctorIDTextField.getText().trim();
        System.out.println("Patient ID from Controller: " + patientID);
        System.out.println("Doctor ID from Controller: " + doctorID);
        if (model.save()) {
            PrescriptionModel.setNewPrescriptionId(prescriptionIDTextField);  // reset the new prescription ID
        }
    }

    public void handleClearButtonActionPerformed(ActionEvent evt) {
        model.clear(Medication_comboxBox, dosage_Spinner, prescriptionDateTextField, instructionsTextArea);
    }
}
