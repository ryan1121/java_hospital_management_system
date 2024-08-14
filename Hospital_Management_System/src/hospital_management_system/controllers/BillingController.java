package hospital_management_system.controllers;

import hospital_management_system.models.BillingAndPayment;
import hospital_management_system.utils.DateTimeUtils;
import hospital_management_system.views.GUI_Invoice;

import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class BillingController {
    private BillingAndPayment model;
    private JPanel Invoice;

    private DefaultTableModel invoiceTableModel;
    private JTextField InvoiceID_input;
    private JTextField InvoicePatientID_input;
    private JFormattedTextField ServiceDate_input;
    private JTextField Description_input;
    private JFormattedTextField CostPerService_input;
    private JTextField ServiceQuantity_input;

    // Payment part
    private JTextField PaymentAmount_input;
    private JComboBox<String> PaymentMethod_dropdown;
    private JComboBox<String> PaymentStatus_dropdown;
    private JFormattedTextField PaymentProcessingDate_input;


    public BillingController(
        DefaultTableModel invoiceTableModel,
        JPanel Invoice,
        JTextField InvoiceID_input,
        JTextField InvoicePatientID_input,
        JFormattedTextField ServiceDate_input,
        JTextField Description_input,
        JFormattedTextField CostPerService_input,
        JTextField ServiceQuantity_input,

        // Payment part
        JTextField PaymentAmount_input,
        JComboBox<String> PaymentMethod_dropdown,
        JComboBox<String> PaymentStatus_dropdown,
        JFormattedTextField PaymentProcessingDate_input
    ) {
        this.invoiceTableModel = invoiceTableModel;
        this.Invoice = Invoice;
        this.InvoiceID_input = InvoiceID_input;
        this.InvoicePatientID_input = InvoicePatientID_input;
        this.ServiceDate_input = ServiceDate_input;
        this.Description_input = Description_input;
        this.CostPerService_input = CostPerService_input;
        this.ServiceQuantity_input = ServiceQuantity_input;

        // Initialize Payment-related fields
        this.PaymentAmount_input = PaymentAmount_input;
        this.PaymentMethod_dropdown = PaymentMethod_dropdown;
        this.PaymentStatus_dropdown = PaymentStatus_dropdown;
        this.PaymentProcessingDate_input = PaymentProcessingDate_input;
        this.model  = new BillingAndPayment(
            Invoice, InvoiceID_input, InvoicePatientID_input, ServiceDate_input, Description_input, CostPerService_input, ServiceQuantity_input, PaymentAmount_input, PaymentMethod_dropdown, PaymentStatus_dropdown, PaymentProcessingDate_input
        );
    }

    public void handleAddServiceButtonActionPerformed(ActionEvent evt) {
        if (InvoiceID_input.getText().isEmpty() || InvoicePatientID_input.getText().isEmpty() || 
            ServiceDate_input.getText().isEmpty() || Description_input.getText().isEmpty() ||
            CostPerService_input.getText().isEmpty() || ServiceQuantity_input.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all required fields.");
            return;
        }
        
        this.model.invoiceID = InvoiceID_input.getText();
        this.model.patientID = InvoicePatientID_input.getText();
        this.model.setServiceDate(ServiceDate_input.getText());
        this.model.setDescription(Description_input.getText());
        this.model.setCostPerService(CostPerService_input.getText());
        this.model.setServiceQuantity(ServiceQuantity_input.getText());

        // Disable the ID buttons to avoid user alter the id when saving new Invoice
        InvoiceID_input.setEnabled(false);
        InvoicePatientID_input.setEnabled(false);
        
        // Update the invoiceTableModel after added service
        this.invoiceTableModel = model.addService(this.invoiceTableModel);
    }

    public void handleSaveButtonActionPerformed(ActionEvent evt) {
        this.model.invoiceID = InvoiceID_input.getText();
        this.model.setPaymentAmount(PaymentAmount_input.getText());
        this.model.paymentMethod = (String) PaymentMethod_dropdown.getSelectedItem();
        this.model.paymentStatus = (String) PaymentStatus_dropdown.getSelectedItem();
        this.model.paymentProcessingDate = DateTimeUtils.formatDate(PaymentProcessingDate_input.getText());
        // Enable the ID buttons
        InvoiceID_input.setEnabled(true);
        InvoicePatientID_input.setEnabled(true);
        model.save(this.invoiceTableModel);
    }

    public void handleClearButtonActionPerformed(ActionEvent evt) {
        model.clear(
            InvoicePatientID_input,
            ServiceDate_input,
            Description_input,
            CostPerService_input,
            ServiceQuantity_input,
            PaymentAmount_input,
            PaymentMethod_dropdown,
            PaymentStatus_dropdown,
            PaymentProcessingDate_input
        );

        // Clear the table model
        this.invoiceTableModel.setRowCount(0);
    }

    public void handleCheckButtonActionPerformed(ActionEvent evt) {
        // Fetch and display invoice data
        String invoiceID = InvoiceID_input.getText();
        String patientID = InvoicePatientID_input.getText();

        if (invoiceID.isEmpty() || patientID.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter both Invoice ID and Patient ID.");
            return;
        }

        InvoiceModel invoiceModel = new InvoiceModel();
        GUI_Invoice invoiceDetails = invoiceModel.getInvoiceDetails(invoiceID, patientID);

        if (invoiceDetails != null) {
            GUI_Invoice invoiceView = new GUI_Invoice();
            invoiceView.setInvoiceData(invoiceDetails);
            invoiceView.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "No invoice found for the provided IDs.");
        }
    }
}
