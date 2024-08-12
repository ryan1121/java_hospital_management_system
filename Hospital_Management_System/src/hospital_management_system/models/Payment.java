package hospital_management_system.models;

import hospital_management_system.MysqlConnect;
import hospital_management_system.utils.DateTimeUtils;
import java.sql.SQLException;
import javax.swing.*;

public class Payment {
    private JPanel Payment;
    private JTextField InvoiceID_input;
    private JTextField PaymentID_input;
    private JTextField PaymentAmount_input;
    private JComboBox<String> PaymentMethod_dropdown;
    private JComboBox<String> PaymentStatus_dropdown;
    private JFormattedTextField PaymentProcessingDate_input;

    public Payment(
        JPanel Payment,
        JTextField InvoiceID_input,
        JTextField PaymentID_input,
        JTextField PaymentAmount_input,
        JComboBox<String> PaymentMethod_dropdown,
        JComboBox<String> PaymentStatus_dropdown,
        JFormattedTextField PaymentProcessingDate_input
    ) {
        this.Payment = Payment;
        this.InvoiceID_input = InvoiceID_input;
        this.PaymentID_input = PaymentID_input;
        this.PaymentAmount_input = PaymentAmount_input;
        this.PaymentMethod_dropdown = PaymentMethod_dropdown;
        this.PaymentStatus_dropdown = PaymentStatus_dropdown;
        this.PaymentProcessingDate_input = PaymentProcessingDate_input;
    }

    public boolean save() {
        String invoiceIDValue = InvoiceID_input.getText();
        String paymentIDValue = PaymentID_input.getText();
        String paymentAmountValue = PaymentAmount_input.getText();
        String paymentMethodValue = (String) PaymentMethod_dropdown.getSelectedItem();
        String paymentStatusValue = (String) PaymentStatus_dropdown.getSelectedItem();
        String paymentProcessingDate = DateTimeUtils.formatDate(PaymentProcessingDate_input.getText());


        MysqlConnect db = new MysqlConnect();
        String[] paymentValues = {paymentIDValue, paymentProcessingDate, paymentAmountValue, paymentMethodValue, paymentStatusValue, invoiceIDValue};

        try {
            boolean savePaymentResult = db.saveData("Payment", "PaymentID, PaymentDate, PaymentMethod, PaymentAmount, PaymentStatus, InvoiceID", paymentValues);

            if (savePaymentResult) {
                JOptionPane.showMessageDialog(Payment, "Payment data saved successfully!");
                return true;
            } else {
                JOptionPane.showMessageDialog(Payment, "Payment data saved unsuccessfully!");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(Payment, "Error while saving payment data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
    public String getInvoiceID() { return InvoiceID_input; }
    public void setInvoiceID(String InvoiceID_input) { this.InvoiceID_input = InvoiceID_input; }

    public String getPaymentID() { return PaymentID_input; }
    public void setPaymentID(String PaymentID_input) { this.PaymentID_input = PaymentID_input; }
    
    public String getPaymentAmount() { return PaymentAmount_input; }
    public void setPaymentAmount(String PaymentAmount_input) { this.PaymentAmount_input = PaymentAmount_input; }
    
    public String getPaymentMethod() { return (String) PaymentMethod_dropdown; }
    public void setPaymentMethod(String PaymentMethod_dropdown) { this.PaymentMethod_dropdown = PaymentMethod_dropdown; }
    
    public String getPaymentStatus() { return (String) PaymentStatus_dropdown; }
    public void setPaymentStatus(String PaymentStatus_dropdown) { this.PaymentStatus_dropdown = PaymentStatus_dropdown; }
    
    public String getPaymentProcessingDate() { return PaymentProcessingDate_input; }
    public void setPaymentProcessingDate(String PaymentProcessingDate_input) { this.PaymentProcessingDate_input = PaymentProcessingDate_input; }
}
