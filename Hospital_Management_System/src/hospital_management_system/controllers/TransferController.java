package hospital_management_system.controllers;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import javax.swing.*;
import hospital_management_system.models.Transfer;

public class TransferController {
    private Transfer model;
    private JPanel PatientTransfer;
    private JTextField TransferID_input;
    private JTextField TransferPatientID_input;
    private JTextField TransferFrom_input;
    private JTextField TransferTo_input;
    private JFormattedTextField TransferDate_input;
    private JFormattedTextField TransferTime_input;
    private JTextArea ReasonForTransfer_input;
    private JComboBox<String> StatusOfTransfer_dropdown;

    public TransferController(
        JPanel PatientTransfer,
        JTextField TransferID_input,
        JTextField TransferPatientID_input,
        JTextField TransferFrom_input,
        JTextField TransferTo_input,
        JFormattedTextField TransferDate_input,
        JFormattedTextField TransferTime_input,
        JTextArea ReasonForTransfer_input,
        JComboBox<String> StatusOfTransfer_dropdown
    ) {
        this.PatientTransfer = PatientTransfer;
        this.TransferID_input = TransferID_input;
        this.TransferPatientID_input = TransferPatientID_input;
        this.TransferFrom_input = TransferFrom_input;
        this.TransferTo_input = TransferTo_input;
        this.TransferDate_input = TransferDate_input;
        this.TransferTime_input = TransferTime_input;
        this.ReasonForTransfer_input = ReasonForTransfer_input;
        this.StatusOfTransfer_dropdown = StatusOfTransfer_dropdown;
        this.model = new Transfer(
            TransferID_input,
            TransferPatientID_input,
            TransferFrom_input,
            TransferTo_input,
            TransferDate_input,
            TransferTime_input,
            ReasonForTransfer_input,
            StatusOfTransfer_dropdown
        );
    }

    public void handleSaveButtonActionPerformed(ActionEvent evt) {
        this.model = new Transfer(
            TransferID_input,
            TransferPatientID_input,
            TransferFrom_input,
            TransferTo_input,
            TransferDate_input,
            TransferTime_input,
            ReasonForTransfer_input,
            StatusOfTransfer_dropdown
        );
        
        if (model.save()) {
            Transfer.setNewTransferId(TransferID_input);  // Reset the new transfer ID
        } 
    }

    public void handleClearButtonActionPerformed(ActionEvent evt) {
        model.clear(TransferPatientID_input, TransferFrom_input, TransferTo_input, TransferDate_input, TransferTime_input, ReasonForTransfer_input, StatusOfTransfer_dropdown);
        Transfer.setNewTransferId(TransferID_input); // Ensure the transferID is updated
    }
}
