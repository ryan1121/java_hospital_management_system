package hospital_management_system.controllers;

import hospital_management_system.models.BillingModel;
import hospital_management_system.models.InvoiceModel;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class BillingController {
    private BillingModel model;
    private JPanel Invoice;
    private JPanel InvoiceDetails;
    private JPanel ServiceDetails;
    private JTextField InvoiceID_input;
    private JTextField InvoicePatientID_input;
    private JTextField Description_input;
    private JFormattedTextField CostPerService_input;
    private JFormattedTextField ServiceDate;
    private JTextField ServiceQuantity_input;

    public BillingController(
        JPanel Invoice,
        JPanel InvoiceDetails,
        JPanel ServiceDetails,
        JTextField InvoiceID_input,
        JTextField InvoicePatientID_input,
        JTextField Description_input,
        JFormattedTextField CostPerService_input,
        JFormattedTextField ServiceDate,
        JTextField ServiceQuantity_input
    ) {
        this.Invoice = Invoice;
        this.InvoiceDetails = InvoiceDetails;
        this.ServiceDetails = ServiceDetails;
        this.InvoiceID_input = InvoiceID_input;
        this.InvoicePatientID_input = InvoicePatientID_input;
        this.Description_input = Description_input;
        this.CostPerService_input = CostPerService_input;
        this.ServiceDate = ServiceDate;
        this.ServiceQuantity_input = ServiceQuantity_input;
        this.model = new BillingModel(
            Invoice,
            InvoiceDetails,
            ServiceDetails,
            InvoiceID_input,
            InvoicePatientID_input,
            Description_input,
            CostPerService_input,
            ServiceDate,
            ServiceQuantity_input
        );
    }

    public void handleSaveButtonActionPerformed(ActionEvent evt) {
        if (model.save()) {
            BillingModel.setNewInvoiceId(InvoiceID_input);
        }
    }

    public void handleClearButtonActionPerformed(ActionEvent evt) {
        model.clear(InvoicePatientID_input, Description_input, CostPerService_input, ServiceDate, ServiceQuantity_input);
        BillingModel.setNewInvoiceId(InvoiceID_input);
    }
}
