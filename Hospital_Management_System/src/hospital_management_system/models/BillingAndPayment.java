package hospital_management_system.models;

import hospital_management_system.MysqlConnect;
import hospital_management_system.utils.DateTimeUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class BillingAndPayment {
    private String invoiceID;
    private String patientID;
    private String serviceDate;
    private String description;
    private double costPerService;
    private int serviceQuantity;
    private JPanel panel;

    private double paymentAmount;
    private String paymentMethod;
    private String paymentStatus;
    private String paymentProcessingDate;

    private String newInvoiceId;

    public BillingAndPayment(
        JPanel panel,
        JTextField invoiceIDTextField,
        JTextField patientIDTextField,
        JFormattedTextField serviceDateTextField,
        JTextField descriptionTextField,
        JFormattedTextField costPerServiceTextField,
        JTextField serviceQuantityTextField,

        // Payment part
        JTextField paymentAmountInput,
        JComboBox<String> paymentMethodDropdown,
        JComboBox<String> paymentStatusDropdown,
        JFormattedTextField paymentProcessingDateInput
    ) {
        this.panel = panel;
        this.invoiceID = invoiceIDTextField.getText();
        this.patientID = patientIDTextField.getText();
        setServiceDate(serviceDateTextField.getText());
        setDescription(descriptionTextField.getText());

        // Set costPerService and serviceQuantity with validation
        if (!costPerServiceTextField.getText().isEmpty()) {
            setCostPerService(costPerServiceTextField.getText());
        } else {
            this.costPerService = 0;
        }
        
        if (!serviceQuantityTextField.getText().isEmpty()) {
            setServiceQuantity(serviceQuantityTextField.getText());
        } else {
            this.serviceQuantity = 0;
        }


        // Initialize payment details
        if (!paymentAmountInput.getText().isEmpty()) {
            setPaymentAmount(paymentAmountInput.getText());
        } else {
            this.paymentAmount = 0;
        }


        this.paymentMethod = (String) paymentMethodDropdown.getSelectedItem();
        this.paymentStatus = (String) paymentStatusDropdown.getSelectedItem();
        setPaymentProcessingDate(paymentProcessingDateInput.getText());

        // Initialize newInvoiceId
        setNewInvoiceId(invoiceIDTextField);
        
    }

    private double parseDouble(String value, String fieldName) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(panel, "Invalid input for " + fieldName + ". Please enter a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }

    public void setCostPerService(String costPerService) {
        System.out.println("Cost Per Service Input: " + costPerService);

        this.costPerService = parseDouble(costPerService, "cost per service");
    }

    public void setPaymentAmount(String paymentAmount) {
        this.paymentAmount = parseDouble(paymentAmount, "payment amount");
    }

    public void addService(DefaultTableModel invoiceTable) {
        System.out.println("costPerService: " + costPerService);
        System.out.println("serviceQuantity: " + serviceQuantity);

        if (invoiceID == null || invoiceID.isEmpty()) {
            JOptionPane.showMessageDialog(panel, "You MUST enter Invoice ID!");
            return;
        } else if (patientID == null || patientID.isEmpty()) {
            JOptionPane.showMessageDialog(panel, "You MUST enter patient ID!");
            return;
        }

        // Validate that costPerService and serviceQuantity are greater than zero
        if (costPerService <= 0 || serviceQuantity <= 0) {
            JOptionPane.showMessageDialog(panel, "Cost per service and quantity must be greater than zero!");
            return;
        }

        // Use BigDecimal for precise floating-point arithmetic
        BigDecimal cost = BigDecimal.valueOf(costPerService);
        BigDecimal quantity = BigDecimal.valueOf(serviceQuantity);
        BigDecimal total = cost.multiply(quantity);

        // Round total to two decimal places
        total = total.setScale(2, RoundingMode.HALF_UP);

        // Add the service to the top of the table
        invoiceTable.insertRow(0, new Object[]{description, cost, quantity, total});

        // Clear input fields
        clearFields();
    }

    public boolean save() {
        if (invoiceID == null || invoiceID.isEmpty()) {
            JOptionPane.showMessageDialog(panel, "You MUST enter Invoice ID!");
            return false;
        } else if (patientID == null || patientID.isEmpty()) {
            JOptionPane.showMessageDialog(panel, "You MUST enter patient ID!");
            return false;
        }

        if (invoiceID != null && !invoiceID.equals(newInvoiceId)) {
            JOptionPane.showMessageDialog(panel, "The new Invoice ID is " + newInvoiceId + "!!");
            return false;
        }

        MysqlConnect db = new MysqlConnect();
        String[] billingValues = {invoiceID, description, String.valueOf(costPerService), String.valueOf(serviceQuantity)};

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

    public void clear(
        JTextField InvoicePatientID_input,
        JFormattedTextField ServiceDate_input,
        JTextField Description_input,
        JFormattedTextField CostPerService_input,
        JTextField ServiceQuantity_input,
        JTextField PaymentAmount_input,
        JComboBox<String> PaymentMethod_dropdown,
        JComboBox<String> PaymentStatus_dropdown,
        JFormattedTextField PaymentProcessingDate_input
    ) {
        InvoicePatientID_input.setText("");
        ServiceDate_input.setText("");
        Description_input.setText("");
        CostPerService_input.setText("");
        ServiceQuantity_input.setText("");
        PaymentAmount_input.setText("");
        PaymentMethod_dropdown.setSelectedIndex(-1);
        PaymentStatus_dropdown.setSelectedIndex(-1);
        PaymentProcessingDate_input.setText("");
    }

    public String setNewInvoiceId(JTextField invoiceIDTextField) {
        MysqlConnect db = new MysqlConnect();
        newInvoiceId = db.generateNewId("Invoice", "INV");
        System.out.println("Generated New Invoice ID: " + newInvoiceId);
        
        invoiceIDTextField.setText(newInvoiceId);
        this.newInvoiceId = newInvoiceId;
        return newInvoiceId;
    }
    
    

    public static String setNewPaymentId(JTextField paymentIDInput) {
        MysqlConnect db = new MysqlConnect();
        String newPaymentID = db.generateNewId("Payment", "PAY");
        paymentIDInput.setText(newPaymentID);
        return newPaymentID;
    }

    // Getter and Setter methods

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

    public double getCostPerService() {
        return costPerService;
    }

    public int getServiceQuantity() {
        return serviceQuantity;
    }

    public void setServiceQuantity(String serviceQuantity) {
        try {
            this.serviceQuantity = Integer.parseInt(serviceQuantity);
        } catch (NumberFormatException e) {
            this.serviceQuantity = 0;
            JOptionPane.showMessageDialog(panel, "Invalid input for service quantity. Please enter a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setServiceDate(String ServiceDate) {
        this.serviceDate = DateTimeUtils.formatDate(ServiceDate);
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentProcessingDate() {
        return paymentProcessingDate;
    }

    public void setPaymentProcessingDate(String paymentProcessingDate) {
        this.paymentProcessingDate = DateTimeUtils.formatDate(paymentProcessingDate);
    }
    

    private void clearFields() {
        this.description = "";
        this.costPerService = 0;
        this.serviceQuantity = 0;
        this.paymentAmount = 0;
        this.paymentMethod = "";
        this.paymentStatus = "";
        this.paymentProcessingDate = "";
    }
}
