package hospital_management_system.models;

import hospital_management_system.MysqlConnect;
import hospital_management_system.utils.DateTimeUtils;
import java.sql.SQLException;
import javax.swing.*;

public class Transfer {
    private JTextField TransferID_input;
    private JTextField TransferPatientID_input;
    private JTextField TransferFrom_input;
    private JTextField TransferTo_input;
    private JFormattedTextField TransferDate_input;
    private JFormattedTextField TransferTime_input;
    private JTextArea ReasonForTransfer_input;
    private JComboBox<String> StatusOfTransfer_dropdown;

    public Transfer(
        JTextField TransferID_input,
        JTextField TransferPatientID_input,
        JTextField TransferFrom_input,
        JTextField TransferTo_input,
        JFormattedTextField TransferDate_input,
        JFormattedTextField TransferTime_input,
        JTextArea ReasonForTransfer_input,
        JComboBox<String> StatusOfTransfer_dropdown
    ) {
        this.TransferID_input = TransferID_input;
        this.TransferPatientID_input = TransferPatientID_input;
        this.TransferFrom_input = TransferFrom_input;
        this.TransferTo_input = TransferTo_input;
        this.TransferDate_input = TransferDate_input;
        this.TransferTime_input = TransferTime_input;
        this.ReasonForTransfer_input = ReasonForTransfer_input;
        this.StatusOfTransfer_dropdown = StatusOfTransfer_dropdown;
    }

    public boolean save() {
        String transferIDValue = TransferID_input.getText();
        String transferPatientIDValue = TransferPatientID_input.getText();
        String transferFromValue = TransferFrom_input.getText();
        String transferToValue = TransferTo_input.getText();
        String transferDateValue = DateTimeUtils.formatDate(TransferDate_input.getText());
        String transferTimeValue = DateTimeUtils.formatTime(TransferTime_input.getText());
        String reasonForTransferValue = ReasonForTransfer_input.getText();
        String statusOfTransferValue = (String) StatusOfTransfer_dropdown.getSelectedItem();

        if (transferPatientIDValue == null || transferPatientIDValue.isEmpty() || transferFromValue == null || transferFromValue.isEmpty()) {
            JOptionPane.showMessageDialog(null, "You MUST enter patient ID and transfer from field!");
            return false;
        }

        MysqlConnect db = new MysqlConnect();
        String[] transferValues = {transferIDValue, transferPatientIDValue, transferFromValue, transferToValue, transferDateValue, transferTimeValue, reasonForTransferValue, statusOfTransferValue};
        String newPatientHistoryID = db.generateNewId("PatientHistory", "H");
        String[] historyValues = {newPatientHistoryID, transferPatientIDValue, "Transfer", transferDateValue, "Transfer from " + transferFromValue + " to " + transferToValue + " for reason: " + reasonForTransferValue + ". Status: " + statusOfTransferValue};

        try {
            boolean saveTransferResult = db.saveData("TransferManagement", "TransferID, PatientID, TransferFrom, TransferTo, PatientTransferDate, TransferTime, ReasonForTransfer, StatusOfTransfer", transferValues);
            boolean saveHistoryResult = db.saveData("PatientHistory", "HistoryID, PatientID, EventType, EventDate, Details", historyValues);

            if (saveTransferResult && saveHistoryResult) {
                JOptionPane.showMessageDialog(null, "Data saved successfully!");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Data saved unsuccessfully!");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error while saving data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public void clear(
        JTextField TransferPatientID_input, 
        JTextField TransferFrom_input, 
        JTextField TransferTo_input, 
        JFormattedTextField TransferDate_input, 
        JFormattedTextField TransferTime_input, 
        JTextArea ReasonForTransfer_input, 
        JComboBox<String> StatusOfTransfer_dropdown
    ) {
        TransferPatientID_input.setText("");
        TransferFrom_input.setText("");
        TransferTo_input.setText("");
        TransferDate_input.setText("");
        TransferTime_input.setText("");
        ReasonForTransfer_input.setText("");
        StatusOfTransfer_dropdown.setSelectedIndex(0);
    }

    public static String setNewTransferId(JTextField TransferID_input) {
        MysqlConnect db = new MysqlConnect();
        String newTransferId = db.generateNewId("TransferManagement", "TR");
        TransferID_input.setText(newTransferId);
        return newTransferId;
    }
}
