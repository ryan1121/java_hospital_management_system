package hospital_management_system.controllers;

import hospital_management_system.models.BillingModel;
import hospital_management_system.views.GUI_Invoice;

import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class BillingController {
    private BillingModel model;
    private JPanel Invoice;

    private JTextField InvoiceID_input;
    private JTextField InvoicePatientID_input;
    private JFormattedTextField ServiceDate_input;
    private JTextField Description_input;
    private JFormattedTextField CostPerService_input;
    private JTextField ServiceQuantity_input;

    public BillingController(
        JPanel Invoice,
        JTextField InvoiceID_input,
        JTextField InvoicePatientID_input,
        JFormattedTextField ServiceDate_input,
        JTextField Description_input,
        JFormattedTextField CostPerService_input,
        JTextField ServiceQuantity_input
    ) {
        this.Invoice = Invoice;
        this.InvoiceID_input = InvoiceID_input;
        this.InvoicePatientID_input = InvoicePatientID_input;
        this.ServiceDate_input = ServiceDate_input;
        this.Description_input = Description_input;
        this.CostPerService_input = CostPerService_input;
        this.ServiceQuantity_input = ServiceQuantity_input;

        this.model  = new BillingModel(
            Invoice,
            InvoiceID_input,
            InvoicePatientID_input,
            ServiceDate_input,
            Description_input,
            CostPerService_input,
            ServiceQuantity_input
        );

    }

    public void handleAddServiceButtonActionPerformed(ActionEvent evt) {
        model.addService();
    }

    public void handleSaveInvoiceButtonActionPerformed(ActionEvent evt) {
        model.save();
    }

    public void handleClearButtonActionPerformed(ActionEvent evt) {
        model.clear();

        BillingModel.setNewInvoiceId(InvoiceID_input);
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
