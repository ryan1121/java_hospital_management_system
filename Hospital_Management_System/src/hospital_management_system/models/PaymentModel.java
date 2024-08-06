package hospital_management_system.models;

import hospital_management_system.MysqlConnect;
import hospital_management_system.utils.DateTimeUtils;
import java.sql.SQLException;
import javax.swing.*;

public class PaymentModel {
    private String PaymentID_input;
    private String PaymentAmount_input;
    private String PaymentMethod_dropdown;
    private String PaymentStatus_dropdown;
    private String PaymentProcessingDate_input;
    private JPanel Payment;

    public PaymentModel(
        JPanel Payment,
        JTextField PaymentID_input,
        JTextField PaymentAmount_input,
        JComboBox<String> PaymentMethod_dropdown,
        JComboBox<String> PaymentStatus_dropdown,
        JFormattedTextField PaymentProcessingDate_input
    ) {
        this.Payment = Payment;
        this.PaymentID_input = PaymentID_input.getText();
        this.PaymentAmount_input = PaymentAmount_input.getText();
        this.PaymentMethod_dropdown = PaymentMethod_dropdown.getSelectedItem().toString();
        this.PaymentStatus_dropdown = PaymentStatus_dropdown.getSelectedItem().toString();
        this.PaymentProcessingDate_input = DateTimeUtils.formatDate(PaymentProcessingDate_input.getText());
    }

    public boolean save() {

        MysqlConnect db = new MysqlConnect();
        String[] paymentValues = {PaymentID_input, PaymentProcessingDate_input, PaymentMethod_dropdown, PaymentAmount_input, PaymentStatus_dropdown};

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

    public String getPaymentID_input() {
        return PaymentID_input;
    }

    public void setPaymentID_input(String PaymentID_input) {
        this.PaymentID_input = PaymentID_input;
    }

    public String getPaymentAmount_input() {
        return PaymentAmount_input;
    }

    public void setPaymentAmount_input(String PaymentAmount_input) {
        this.PaymentAmount_input = PaymentAmount_input;
    }

    public String getPaymentMethod_dropdown() {
        return PaymentMethod_dropdown;
    }

    public void setPaymentMethod_dropdown(String PaymentMethod_dropdown) {
        this.PaymentMethod_dropdown = PaymentMethod_dropdown;
    }

    public String getPaymentStatus_dropdown() {
        return PaymentStatus_dropdown;
    }

    public void setPaymentStatus_dropdown(String PaymentStatus_dropdown) {
        this.PaymentStatus_dropdown = PaymentStatus_dropdown;
    }

    public String getPaymentProcessingDate_input() {
        return PaymentProcessingDate_input;
    }

    public void setPaymentProcessingDate_input(String PaymentProcessingDate_input) {
        this.PaymentProcessingDate_input = PaymentProcessingDate_input;
    }
}
