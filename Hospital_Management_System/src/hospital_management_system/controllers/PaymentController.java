package hospital_management_system.controllers;

import hospital_management_system.models.Payment;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import javax.swing.*;

public class PaymentController {
    private Payment model;
    private JPanel Payment;
    private JTextField PaymentID_input;
    private JTextField PaymentAmount_input;
    private JComboBox<String> PaymentMethod_dropdown;
    private JComboBox<String> PaymentStatus_dropdown;
    private JFormattedTextField PaymentProcessingDate_input;

    public PaymentController(
        JPanel Payment,
        JTextField PaymentID_input,
        JTextField PaymentAmount_input,
        JComboBox<String> PaymentMethod_dropdown,
        JComboBox<String> PaymentStatus_dropdown,
        JFormattedTextField PaymentProcessingDate_input
    ) {
        this.Payment = Payment;
        this.PaymentID_input = PaymentID_input;
        this.PaymentAmount_input = PaymentAmount_input;
        this.PaymentMethod_dropdown = PaymentMethod_dropdown;
        this.PaymentStatus_dropdown = PaymentStatus_dropdown;
        this.PaymentProcessingDate_input = PaymentProcessingDate_input;

        this.model = new Payment(
            Payment,
            PaymentID_input,
            PaymentAmount_input,
            PaymentMethod_dropdown,
            PaymentStatus_dropdown,
            PaymentProcessingDate_input
        );
    }

    public void handleSaveButtonActionPerformed(ActionEvent evt) {
        if (model.save()) {
            Payment.setNewPaymentId(PaymentID_input); // Reset the new transfer ID
            JOptionPane.showMessageDialog(Payment, "Payment data saved successfully!");
        } else {
            JOptionPane.showMessageDialog(Payment, "Failed to save payment data.");
        }
    }

    public void handleClearButtonActionPerformed(ActionEvent evt) {
        model.clear(PaymentAmount_input, PaymentMethod_dropdown, PaymentStatus_dropdown, PaymentProcessingDate_input); 
        Payment.setNewPaymentId(PaymentID_input); // Ensure the transferID is updated
    }
}
