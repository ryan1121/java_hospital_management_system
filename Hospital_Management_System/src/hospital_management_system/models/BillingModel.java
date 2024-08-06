package hospital_management_system.models;

import hospital_management_system.MysqlConnect;
import hospital_management_system.utils.DateTimeUtils;

import java.sql.SQLException;
import javax.swing.*;

public class BillingModel {
    private JPanel Invoice;
    private JPanel InvoiceDetails;
    private JPanel ServiceDetails;
    private String InvoiceID_input;
    private String InvoicePatientID_input;
    private String Description_input;
    private String CostPerService_input;
    private String ServiceDate;
    private String ServiceQuantity_input;

    public BillingModel(
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
        this.InvoiceID_input = InvoiceID_input.getText();
        this.InvoicePatientID_input = InvoicePatientID_input.getText();
        this.Description_input = Description_input.getText();
        this.CostPerService_input = CostPerService_input.getText();
        this.ServiceDate = DateTimeUtils.formatDate(ServiceDate.getText());
        this.ServiceQuantity_input = ServiceQuantity_input.getText();
    }

    public boolean save() {
        if (InvoicePatientID_input == null || InvoicePatientID_input.isEmpty()) {
            JOptionPane.showMessageDialog(billingDetailsPanel, "You MUST enter patient ID!");
            return false;
        }

        MysqlConnect db = new MysqlConnect();
        String[] billingValues = {InvoiceID_input, Description_input, CostPerService_input, ServiceQuantity_input, TotalPayment};

        try {
            boolean saveBillingResult = db.saveData("Billing", "InvoiceID, ServicesDescription, CostPerService, Quantity, TotalPayment", billingValues);

            if (saveBillingResult) {
                JOptionPane.showMessageDialog(billingDetailsPanel, "Invoice data saved successfully!");
                return true;
            } else {
                JOptionPane.showMessageDialog(billingDetailsPanel, "Invoice data saved unsuccessfully!");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(billingDetailsPanel, "Error while saving invoice data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public void clear(
        JTextField InvoicePatientID_input,
        JTextField Description_input,
        JFormattedTextField CostPerService_input,
        JFormattedTextField ServiceDate,
        JTextField ServiceQuantity_input
    ) {
        InvoicePatientID_input.setText("");
        Description_input.setText("");
        CostPerService_input.setText("");
        ServiceDate.setText("");
        ServiceQuantity_input.setText("");
    }

    public static String setNewInvoiceId(JTextField InvoiceID_input) {
        MysqlConnect db = new MysqlConnect();
        String newInvoiceId = db.generateNewId("Invoice", "INV");
        InvoiceID_input.setText(newInvoiceId);
        return newInvoiceId;
    }

    public String getInvoiceID() {
        return InvoiceID_input;
    }

    public void setInvoiceID(String invoiceID) {
        this.InvoiceID_input = invoiceID;
    }

    public String getPatientID() {
        return InvoicePatientID_input;
    }

    public void setPatientID(String patientID) {
        this.InvoicePatientID_input = patientID;
    }

    public String getDescription() {
        return Description_input;
    }

    public void setDescription(String description) {
        this.Description_input = description;
    }

    public String getCostPerService() {
        return CostPerService_input;
    }

    public void setCostPerService(String costPerService) {
        this.CostPerService_input = costPerService;
    }

    public String getServiceDate() {
        return ServiceDate;
    }

    public void setServiceDate(String serviceDate) {
        this.ServiceDate = serviceDate;
    }

    public String getServiceQuantity() {
        return ServiceQuantity_input;
    }

    public void setServiceQuantity(String serviceQuantity) {
        this.ServiceQuantity_input = serviceQuantity;
    }
}
