package hospital_management_system.controllers;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import hospital_management_system.controllers.DateTimeUtils;

public class Transfer {
    public static String TransferID;
    public static String TransferPatientID;
    public static String TransferFrom;
    public static String TransferTo;
    public static String TransferDate;
    public static String TransferTime;
    public static String ReasonForTransfer;
    public static String StatusOfTransfer;
    public static javax.swing.JPanel PatientTransfer;

    public static javax.swing.JTextField TransferID_input;
    public static javax.swing.JTextField TransferPatientID_input;
    public static javax.swing.JTextField TransferFrom_input;
    public static javax.swing.JTextField TransferTo_input;
    public static javax.swing.JFormattedTextField PatientTransferDate;
    public static javax.swing.JFormattedTextField TransferTime_input;
    public static javax.swing.JTextArea ReasonForTransfer_input;
    public static javax.swing.JComboBox<String> StatusOfTransfer_dropdown;

    public Transfer(
        javax.swing.JPanel PatientTransfer,
        javax.swing.JTextField TransferID_input,
        javax.swing.JTextField TransferPatientID_input,
        javax.swing.JTextField TransferFrom_input,
        javax.swing.JTextField TransferTo_input,
        javax.swing.JFormattedTextField PatientTransferDate,
        javax.swing.JFormattedTextField TransferTime_input,
        javax.swing.JTextArea ReasonForTransfer_input,
        javax.swing.JComboBox<String> StatusOfTransfer_dropdown
    ) {
        this.PatientTransfer = PatientTransfer;
        this.TransferID_input = TransferID_input;
        this.TransferPatientID_input = TransferPatientID_input;
        this.TransferFrom_input = TransferFrom_input;
        this.TransferTo_input = TransferTo_input;
        this.PatientTransferDate = PatientTransferDate;
        this.TransferTime_input = TransferTime_input;
        this.ReasonForTransfer_input = ReasonForTransfer_input;
        this.StatusOfTransfer_dropdown = StatusOfTransfer_dropdown;

        this.TransferID = TransferID_input.getText();
        this.TransferPatientID = TransferPatientID_input.getText();
        this.TransferFrom = TransferFrom_input.getText();
        this.TransferTo = TransferTo_input.getText();
        this.TransferDate = DateTimeUtils.formatDate(PatientTransferDate.getText());
        this.TransferTime = DateTimeUtils.formatTime(TransferTime_input.getText());
        this.ReasonForTransfer = ReasonForTransfer_input.getText();
        this.StatusOfTransfer = (String) StatusOfTransfer_dropdown.getSelectedItem();
    }

    public static void Transfer_saveButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (TransferPatientID == null || TransferPatientID.isEmpty() || TransferFrom == null || TransferFrom.isEmpty()) {
            JOptionPane.showMessageDialog(PatientTransfer, "You MUST enter patient ID and transfer from field !!");
        } else {
            System.out.println(TransferID);
            System.out.println(TransferPatientID);
            System.out.println(TransferFrom);
            System.out.println(TransferTo);
            System.out.println(TransferDate);
            System.out.println(TransferTime);
            System.out.println(ReasonForTransfer);
            System.out.println(StatusOfTransfer);

            MysqlConnect db = new MysqlConnect();
            String[] values = {TransferID, TransferPatientID, TransferFrom, TransferTo, TransferDate, TransferTime, ReasonForTransfer, StatusOfTransfer};
            try {
                boolean saveResult = db.saveData("Transfers", "TransferID, TransferPatientID, TransferFrom, TransferTo, TransferDate, TransferTime, ReasonForTransfer, StatusOfTransfer", values);
                if (saveResult) {
                    JOptionPane.showMessageDialog(PatientTransfer, "Data saved successfully!");
                } else {
                    JOptionPane.showMessageDialog(PatientTransfer, "Data saved unsuccessfully!");
                }
                setNewTransferId(TransferID_input);
            } catch (SQLException e) {
                System.err.println("Error while saving data!");
                JOptionPane.showMessageDialog(PatientTransfer, "Error while saving data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void Transfer_clearButtonActionPerformed(java.awt.event.ActionEvent evt) {
        TransferID_input.setText("");
        TransferPatientID_input.setText("");
        TransferFrom_input.setText("");
        TransferTo_input.setText("");
        PatientTransferDate.setText("");
        TransferTime_input.setText("");
        ReasonForTransfer_input.setText("");
        StatusOfTransfer_dropdown.setSelectedIndex(0);
    }

    public static String setNewTransferId(javax.swing.JTextField TransferID_input) {
        MysqlConnect db = new MysqlConnect();
        String newTransferId = db.generateNewId("transfers", "T");
        
        TransferID_input.setText(newTransferId);
        return newTransferId;
    }
}
