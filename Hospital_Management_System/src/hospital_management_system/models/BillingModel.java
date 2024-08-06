package hospital_management_system.models;

import hospital_management_system.MysqlConnect;
import hospital_management_system.utils.DateTimeUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;

public class BillingModel {
    private String invoiceID;
    private String patientID;
    private String serviceDate;
    private String description;
    private String costPerService;
    private String serviceQuantity;
    private JPanel panel;

    public BillingModel(
        JPanel panel,
        JTextField invoiceIDTextField,
        JTextField patientIDTextField,
        JFormattedTextField serviceDateTextField,
        JTextField descriptionTextField,
        JFormattedTextField costPerServiceTextField,
        JTextField serviceQuantityTextField
    ) {
        this.panel = panel;
        this.invoiceID = invoiceIDTextField.getText();
        this.patientID = patientIDTextField.getText();
        this.serviceDate = DateTimeUtils.formatDate(serviceDateTextField.getText());
        this.description = descriptionTextField.getText();
        this.costPerService = costPerServiceTextField.getText();
        this.serviceQuantity = serviceQuantityTextField.getText();
    }

    public void addService(DefaultTableModel invoiceTable) {
        // Calculate total
        double cost = Double.parseDouble(costPerService);
        int qty = Integer.parseInt(serviceQuantity);
        double total = cost * qty;

        // Add service to table
        invoiceTable.addRow(new Object[]{description, cost, qty, total});

        // Clear input fields
        description = "";
        costPerService = "";
        serviceQuantity = "";
    }

    public boolean save() {
        if (patientID == null || patientID.isEmpty()) {
            JOptionPane.showMessageDialog(panel, "You MUST enter patient ID!");
            return false;
        }

        MysqlConnect db = new MysqlConnect();
        String[] billingValues = {invoiceID, description, costPerService, serviceQuantity};

        try {
            boolean saveBillingResult = db.saveData("Billing", "InvoiceID, ServicesDescription, CostPerService, Quantity", billingValues);

            if (saveBillingResult) {
                JOptionPane.showMessageDialog(panel, "Invoice data saved successfully!");
                return true;
            } else {
                JOptionPane.showMessageDialog(panel, "Invoice data saved unsuccessfully!");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(panel, "Error while saving invoice data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public void clear(JTextField patientIDTextField, JTextField descriptionTextField, JFormattedTextField costPerServiceTextField, JFormattedTextField serviceDateTextField, JTextField serviceQuantityTextField, DefaultTableModel invoiceTable) {
        patientIDTextField.setText("");
        descriptionTextField.setText("");
        costPerServiceTextField.setText("");
        serviceDateTextField.setText("");
        serviceQuantityTextField.setText("");
        invoiceTable.setRowCount(0);
    }

    public static String setNewInvoiceId(JTextField invoiceIDTextField) {
        MysqlConnect db = new MysqlConnect();
        String newInvoiceId = db.generateNewId("Invoice", "INV");
        invoiceIDTextField.setText(newInvoiceId);
        return newInvoiceId;
    }

    public String getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(String invoiceID) {
        this.invoiceID = invoiceID;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCostPerService() {
        return costPerService;
    }

    public void setCostPerService(String costPerService) {
        this.costPerService = costPerService;
    }

    public String getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(String serviceDate) {
        this.serviceDate = serviceDate;
    }

    public String getServiceQuantity() {
        return serviceQuantity;
    }

    public void setServiceQuantity(String serviceQuantity) {
        this.serviceQuantity = serviceQuantity;
    }
}
