package hospital_management_system.models;

import hospital_management_system.MysqlConnect;
import hospital_management_system.utils.DateTimeUtils;
import java.sql.SQLException;
import javax.swing.*;

public class Transfer {
    private String transferID;
    private String transferPatientID;
    private String transferFrom;
    private String transferTo;
    private String transferDate;
    private String transferTime;
    private String reasonForTransfer;
    private String statusOfTransfer;

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
        this.transferID = TransferID_input.getText();
        this.transferPatientID = TransferPatientID_input.getText();
        this.transferFrom = TransferFrom_input.getText();
        this.transferTo = TransferTo_input.getText();
        setTransferDate(DateTimeUtils.formatDate(TransferDate_input.getText()));
        setTransferTime(DateTimeUtils.formatTime(TransferTime_input.getText()));
        setReasonForTransfer(ReasonForTransfer_input.getText());
        setStatusOfTransfer((String) StatusOfTransfer_dropdown.getSelectedItem());
    }

    public boolean save() {
        if ((transferPatientID == null || transferPatientID.isEmpty()) || (transferFrom == null || transferFrom.isEmpty())) {
            JOptionPane.showMessageDialog(null, "You MUST enter patient ID and transfer from field!");
            return false;
        } else {
            MysqlConnect db = new MysqlConnect();
            String[] transferValues = {transferID, transferPatientID, transferFrom, transferTo, transferDate, transferTime, reasonForTransfer, statusOfTransfer};
            String newPatientHistoryID = db.generateNewId("PatientHistory", "H");
            String[] historyValues = {newPatientHistoryID, transferPatientID, "Transfer", transferDate, "Transfer from " + transferFrom + " to " + transferTo + " for reason: " + reasonForTransfer + ". Status: " + statusOfTransfer};
    
            try {
                // Save Transfer Data
                boolean saveTransferResult = db.saveData("TransferManagement", "TransferID, PatientID, TransferFrom, TransferTo, PatientTransferDate, TransferTime, ReasonForTransfer, StatusOfTransfer", transferValues);
                
                /// Create a patientHistory model object
                PatientHistory patientHistoryObj = new PatientHistory();
    
                // Save Patient History Data
                boolean saveHistoryResult = patientHistoryObj.save(historyValues);

                if (saveTransferResult && saveHistoryResult) {
                    JOptionPane.showMessageDialog(null, "Data saved successfully!");
                    return true;
                } else {
                    return false;
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error while saving data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
    }

    public void clear(JTextField TransferPatientID_input, JTextField TransferFrom_input, JTextField TransferTo_input, JFormattedTextField TransferDate_input, JFormattedTextField TransferTime_input, JTextArea ReasonForTransfer_input, JComboBox<String> StatusOfTransfer_dropdown) {
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

    public String getTransferID() { return transferID; }
    public void setTransferID(String transferID) { this.transferID = transferID; }

    public String getTransferPatientID() { return transferPatientID; }
    public void setTransferPatientID(String transferPatientID) { this.transferPatientID = transferPatientID; }

    public String getTransferFrom() { return transferFrom; }
    public void setTransferFrom(String transferFrom) { this.transferFrom = transferFrom; }

    public String getTransferTo() { return transferTo; }
    public void setTransferTo(String transferTo) { this.transferTo = transferTo; }

    public String getTransferDate() { return transferDate; }
    public void setTransferDate(String transferDate) { this.transferDate = transferDate; }

    public String getTransferTime() { return transferTime; }
    public void setTransferTime(String transferTime) { this.transferTime = transferTime; }

    public String getReasonForTransfer() { return reasonForTransfer; }
    public void setReasonForTransfer(String reasonForTransfer) { this.reasonForTransfer = reasonForTransfer; }

    public String getStatusOfTransfer() { return statusOfTransfer; }
    public void setStatusOfTransfer(String statusOfTransfer) { this.statusOfTransfer = statusOfTransfer; }
}
