package hospital_management_system.models;

import hospital_management_system.MysqlConnect;
import hospital_management_system.utils.DateTimeUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

public class Payment {
    private JPanel panel;
    private JTextField InvoiceID_input;
    private JTextField PaymentID_input;
    private JTextField PaymentAmount_input;
    private JComboBox<String> PaymentMethod_dropdown;
    private JComboBox<String> PaymentStatus_dropdown;
    private JFormattedTextField PaymentProcessingDate_input;

    public Payment(
        JPanel panel,
        JTextField InvoiceID_input,
        JTextField PaymentID_input,
        JTextField PaymentAmount_input,
        JComboBox<String> PaymentMethod_dropdown,
        JComboBox<String> PaymentStatus_dropdown,
        JFormattedTextField PaymentProcessingDate_input
    ) {
        this.panel = panel;
        this.InvoiceID_input = InvoiceID_input;
        this.PaymentID_input = PaymentID_input;
        this.PaymentAmount_input = PaymentAmount_input;
        this.PaymentMethod_dropdown = PaymentMethod_dropdown;
        this.PaymentStatus_dropdown = PaymentStatus_dropdown;
        this.PaymentProcessingDate_input = PaymentProcessingDate_input;
        
    }
    
    public boolean isInvoiceIdValid() {
        String query = "SELECT 1 FROM invoice WHERE InvoiceID = ?";
        try (Connection conn = this.connect(); 
             PreparedStatement stmt = conn.prepareStatement(query)) {
    
            stmt.setString(1, this.invoiceID);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next(); // Returns true if a result is found
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean save() {
        String invoiceIDValue = InvoiceID_input.getText();
        String paymentIDValue = PaymentID_input.getText();
        String paymentAmountValue = PaymentAmount_input.getText();
        String paymentMethodValue = (String) PaymentMethod_dropdown.getSelectedItem();
        String paymentStatusValue = (String) PaymentStatus_dropdown.getSelectedItem();
        String paymentProcessingDate = DateTimeUtils.formatDate(PaymentProcessingDate_input.getText());
        
        if (!isInvoiceIdValid()) {
            JOptionPane.showMessageDialog(null, "Error: InvoiceID " + invoiceID + " does not exist in the invoice table.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        MysqlConnect db = new MysqlConnect();
        String[] paymentValues = {paymentIDValue, paymentProcessingDate, paymentMethodValue, paymentAmountValue, paymentStatusValue, invoiceIDValue};

        try {
            boolean savePaymentResult = db.saveData("Payment", "PaymentID, PaymentDate, PaymentMethod, PaymentAmount, PaymentStatus, InvoiceID", paymentValues);

            if (savePaymentResult) {
                JOptionPane.showMessageDialog(panel, "Payment data saved successfully!");
                return true;
            } else {
                JOptionPane.showMessageDialog(panel, "Payment data saved unsuccessfully!");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(panel, "Error while saving payment data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public void clear(
        JTextField PaymentAmount_input,
        JComboBox<String> PaymentMethod_dropdown,
        JComboBox<String> PaymentStatus_dropdown,
        JFormattedTextField PaymentProcessingDate_input
    ) {
        PaymentAmount_input.setText("");
        PaymentMethod_dropdown.setSelectedIndex(0);
        PaymentStatus_dropdown.setSelectedIndex(0);
        PaymentProcessingDate_input.setText("");
    }

    public static String setNewPaymentId(JTextField PaymentID_input) {
        MysqlConnect db = new MysqlConnect();
        String newPaymentID = db.generateNewId("Payment", "PAY");
        PaymentID_input.setText(newPaymentID);
        return newPaymentID;
    }

    // Getter and Setter methods
    public String getInvoiceID() {return InvoiceID_input.getText();}
    public void setInvoiceID(String invoiceID) {this.InvoiceID_input.setText(invoiceID);}

    public String getPaymentID() {return PaymentID_input.getText();}
    public void setPaymentID(String paymentID) {this.PaymentID_input.setText(paymentID);}

    public String getPaymentAmount() {return PaymentAmount_input.getText();}
    public void setPaymentAmount(String paymentAmount) {this.PaymentAmount_input.setText(paymentAmount);}

    public String getPaymentMethod() {return (String) PaymentMethod_dropdown.getSelectedItem();}
    public void setPaymentMethod(String paymentMethod) {this.PaymentMethod_dropdown.setSelectedItem(paymentMethod);}

    public String getPaymentStatus() {return (String) PaymentStatus_dropdown.getSelectedItem();}
    public void setPaymentStatus(String paymentStatus) {this.PaymentStatus_dropdown.setSelectedItem(paymentStatus);}

    public String getPaymentProcessingDate() {return PaymentProcessingDate_input.getText();}
    public void setPaymentProcessingDate(String paymentProcessingDate) {this.PaymentProcessingDate_input.setText(paymentProcessingDate);}
}
