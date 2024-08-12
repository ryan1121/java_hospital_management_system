package hospital_management_system.controllers;

import hospital_management_system.models.Invoice;
import hospital_management_system.views.GUI_admin;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class InvoiceController {
    private Invoice model;
    private JTextField invoiceIDField;
    private JTextField patientIDField;
    private JLabel patientNameLabel;
    private JLabel invoiceDateLabel;
    private JLabel invoiceDueLabel;
    private JLabel totalAmountLabel;
    private JLabel amountPaidLabel;
    private JLabel balanceDueLabel;

    public InvoiceController(
        JTextField invoiceIDField,
        JTextField patientIDField,
        JLabel patientNameLabel,
        JLabel invoiceDateLabel,
        JLabel invoiceDueLabel,
        JLabel totalAmountLabel,
        JLabel amountPaidLabel,
        JLabel balanceDueLabel
    ) {
        this.invoiceIDField = invoiceIDField;
        this.patientIDField = patientIDField;
        this.patientNameLabel = patientNameLabel;
        this.invoiceDateLabel = invoiceDateLabel;
        this.invoiceDueLabel = invoiceDueLabel;
        this.totalAmountLabel = totalAmountLabel;
        this.amountPaidLabel = amountPaidLabel;
        this.balanceDueLabel = balanceDueLabel;

        this.model = new Invoice(invoiceIDField, patientIDField)
    }

    public static void viewInvoice(Invoice model) {
        try {
            // Create an instance of the GUI for viewing invoices
            GUI_Invoice invoice = new GUI_Invoice();
    
            // Create the controller for the invoice view
            InvoiceController invoiceController = new InvoiceController(
                invoice.getInvoiceIDField(),          // JTextField for Invoice ID input
                invoice.getPatientIDField(),          // JTextField for Patient ID input
                invoice.getPatientNameLabel(),        // JLabel to display patient name
                invoice.getInvoiceDateLabel(),        // JLabel to display invoice date
                invoice.getInvoiceDueLabel(),         // JLabel to display invoice due date
                invoice.getTotalAmountLabel(),        // JLabel to display total amount
                invoice.getAmountPaidLabel(),         // JLabel to display amount paid
                invoice.getBalanceDueLabel()          // JLabel to display balance due
            );
    
            // Set the invoice ID and patient ID in the view
            invoice.getInvoiceIDField().setText(invoiceID);
            invoice.getPatientIDField().setText(patientID);
    
            // Load invoice data and update the view
            invoiceController.handleCheckButtonActionPerformed(null);
    
            // Make the invoice view visible
            invoice.setVisible(true);
    
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error opening invoice view: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateView() {
        patientNameLabel.setText(model.getPatientName());
        invoiceDateLabel.setText(model.getInvoiceDate());
        invoiceDueLabel.setText(model.getInvoiceDue());
        totalAmountLabel.setText(String.format("%.2f", model.getTotalAmount()));
        amountPaidLabel.setText(String.format("%.2f", model.getAmountPaid()));
        balanceDueLabel.setText(String.format("%.2f", model.getBalanceDue()));
    }
}
