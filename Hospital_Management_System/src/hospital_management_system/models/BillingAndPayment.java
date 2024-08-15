package hospital_management_system.models;

import hospital_management_system.MysqlConnect;
import hospital_management_system.utils.DateTimeUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class BillingAndPayment {
    public String invoiceID;
    public String patientID;
    public String serviceDate;
    public String description;
    public double costPerService;
    public int serviceQuantity;
    private JPanel panel;

    public double paymentAmount;
    public String paymentMethod;
    public String paymentStatus;
    public String paymentProcessingDate;

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

    public DefaultTableModel addService(DefaultTableModel invoiceTable) {
        System.out.println("costPerService: " + costPerService);
        System.out.println("serviceQuantity: " + serviceQuantity);

        if (invoiceID == null || invoiceID.isEmpty()) {
            JOptionPane.showMessageDialog(panel, "You MUST enter Invoice ID!");
            return invoiceTable;
        } else if (patientID == null || patientID.isEmpty()) {
            JOptionPane.showMessageDialog(panel, "You MUST enter patient ID!");
            return invoiceTable;
        }

        // Validate that costPerService and serviceQuantity are greater than zero
        if (costPerService <= 0 || serviceQuantity <= 0) {
            JOptionPane.showMessageDialog(panel, "Cost per service and quantity must be greater than zero!");
            return invoiceTable;
        }

        // Use BigDecimal for precise floating-point arithmetic
        BigDecimal cost = BigDecimal.valueOf(costPerService);
        BigDecimal quantity = BigDecimal.valueOf(serviceQuantity);
        BigDecimal total = cost.multiply(quantity);

        // Round total to two decimal places
        total = total.setScale(2, RoundingMode.HALF_UP);

        // Add the service to the top of the table
        invoiceTable.insertRow(0, new Object[]{description, cost, quantity, total});
        
        for (int i = 0; i < invoiceTable.getRowCount(); i++) {
            Object value = invoiceTable.getValueAt(i, 3);
            if (value != null) {
                System.out.println("Value at third column is " + value);
            } else {
                System.out.println("Null value found in row " + i + ", column 3");
            }
        }


        return invoiceTable;
    }

    public void save(DefaultTableModel invoiceTable) {
        try {
            MysqlConnect db = new MysqlConnect();
            
            if ((serviceDate == null||serviceDate.isEmpty()) && !paymentProcessingDate.isEmpty()) {
                // Case 2: When serviceDate is empty and paymentProcessingDate is not empty
                System.out.println("Case 2: When serviceDate is empty and paymentProcessingDate is not empty");

    
                // Update Invoice table for payment
                ResultSet rs = db.getData("Invoice", "InvoiceID = '" + invoiceID + "'");
                if (rs.next()) {
                    BigDecimal amountPaid = rs.getBigDecimal("AmountPaid");
                    BigDecimal balanceDue = rs.getBigDecimal("BalanceDue");
                    BigDecimal totalPayment = rs.getBigDecimal("TotalPayment");
                    BigDecimal payingAmount = new BigDecimal(paymentAmount);
                    
                    // Check if adding the payment would exceed the total payment
                    if (amountPaid.add(payingAmount).compareTo(totalPayment) > 0) {
                        // If amountPaid exceeds totalPayment, show a warning and stop the operation
                        JOptionPane.showMessageDialog(panel, "Payment exceeds the total amount due. Please enter a valid payment amount.");
                        return;
                    }
                    
                    amountPaid = amountPaid.add(payingAmount);
                    balanceDue = balanceDue.subtract(payingAmount);
    
                    String updateInvoice = "AmountPaid = " + amountPaid.toString() + ", BalanceDue = " + balanceDue.toString();
                    db.updateData("Invoice", updateInvoice, "InvoiceID = '" + invoiceID + "'");
                }
    
                // Save Payment data
                String[] paymentValues = {
                    db.generateNewId("Payment", "PAY"),
                    invoiceID,
                    String.valueOf(paymentAmount),
                    paymentProcessingDate,
                    paymentMethod,
                    paymentStatus
                };
                db.saveData("Payment", "PaymentID, InvoiceID, PaymentAmount, PaymentDate, PaymentMethod, PaymentStatus", paymentValues);
                
                JOptionPane.showMessageDialog(panel, "Payment data saved Successfully!");
                
                return;
            }
            
            // Calculate TotalPayment as the sum of the 4th column of the invoiceTable
            BigDecimal totalPayment = BigDecimal.ZERO;
            for (int i = 0; i < invoiceTable.getRowCount(); i++) {
                Object value = invoiceTable.getValueAt(i, 3);
                if (value != null) {
                    BigDecimal rowTotal = new BigDecimal(value.toString());
                    totalPayment = totalPayment.add(rowTotal);
                }
            }

            System.out.println("This is the totalPayment : " + totalPayment);

    
            // Set InvoiceDue as InvoiceDate + 3 months
            String invoiceDate = serviceDate; // Ensure serviceDate is not null
            if (invoiceDate == null || invoiceDate.isEmpty()) {
                throw new IllegalArgumentException("Service date cannot be null or empty.");
            }

            System.out.println("This is the invoiceDate : " + invoiceDate);


            String invoiceDue = DateTimeUtils.addMonths(invoiceDate, 3);

            
            if (serviceDate != null && !serviceDate.isEmpty() && (paymentProcessingDate == null || paymentProcessingDate.isEmpty())) {
                System.out.println("Case 1: When serviceDate is not empty and paymentProcessingDate is empty");
    
                // Save Invoice data
                String[] invoiceValues = {
                    invoiceID,
                    invoiceDate,
                    invoiceDue,
                    patientID,
                    totalPayment.toString(),
                    "0.00", // AmountPaid is initially 0
                    totalPayment.toString() // BalanceDue is equal to TotalPayment initially
                };
                db.saveData("Invoice", "InvoiceID, InvoiceDate, InvoiceDue, PatientID, TotalPayment, AmountPaid, BalanceDue", invoiceValues);
    
                // Save Billing data from the InvoiceTable
                for (int i = 0; i < invoiceTable.getRowCount(); i++) {
                    if (invoiceTable.getValueAt(i, 0) != null){
                        String[] billingValues = {
                            invoiceID,
                            invoiceTable.getValueAt(i, 0).toString(), // ServicesDescription
                            invoiceTable.getValueAt(i, 1).toString(), // CostPerService
                            invoiceTable.getValueAt(i, 2).toString(), // Quantity
                            invoiceTable.getValueAt(i, 3).toString()  // TotalPayment
                        };
                        db.saveData("Billing", "InvoiceID, ServicesDescription, CostPerService, Quantity, TotalPayment", billingValues);
                    }
                }
                
                JOptionPane.showMessageDialog(panel, "Billing data saved Successfully!");  
            } else {
                // Case 3: When both serviceDate and paymentProcessingDate are not empty
                System.out.println("Case 3: When both serviceDate and paymentProcessingDate are not empty");

                // Save Invoice data
                String[] invoiceValues = {
                    invoiceID,
                    invoiceDate,
                    invoiceDue,
                    patientID,
                    totalPayment.toString(),
                    "0.00", // AmountPaid is initially 0
                    totalPayment.toString() // BalanceDue is equal to TotalPayment initially
                };
                db.saveData("Invoice", "InvoiceID, InvoiceDate, InvoiceDue, PatientID, TotalPayment, AmountPaid, BalanceDue", invoiceValues);
    
                // Save Billing data from the InvoiceTable
                for (int i = 0; i < invoiceTable.getRowCount(); i++) {
                    if (invoiceTable.getValueAt(i, 0) != null){
                        String[] billingValues = {
                            invoiceID,
                            invoiceTable.getValueAt(i, 0).toString(), // ServicesDescription
                            invoiceTable.getValueAt(i, 1).toString(), // CostPerService
                            invoiceTable.getValueAt(i, 2).toString(), // Quantity
                            invoiceTable.getValueAt(i, 3).toString()  // TotalPayment
                        };
                        db.saveData("Billing", "InvoiceID, ServicesDescription, CostPerService, Quantity, TotalPayment", billingValues);
                    }
                }
                
                
                // Update Invoice table for payment
                ResultSet rs = db.getData("Invoice", "InvoiceID = '" + invoiceID + "'");
                if (rs.next()) {
                    BigDecimal amountPaid = rs.getBigDecimal("AmountPaid");
                    BigDecimal balanceDue = rs.getBigDecimal("BalanceDue");
                    BigDecimal payingAmount = new BigDecimal(paymentAmount);
    
                    amountPaid = amountPaid.add(payingAmount);
                    balanceDue = balanceDue.subtract(payingAmount);
    
                    String updateInvoice = "AmountPaid = " + amountPaid.toString() + ", BalanceDue = " + balanceDue.toString();
                    db.updateData("Invoice", updateInvoice, "InvoiceID = '" + invoiceID + "'");
                }
    
                // Save Payment data
                String[] paymentValues = {
                    db.generateNewId("Payment", "PAY"),
                    invoiceID,
                    String.valueOf(paymentAmount),
                    paymentProcessingDate,
                    paymentMethod,
                    paymentStatus
                };
                db.saveData("Payment", "PaymentID, InvoiceID, PaymentAmount, PaymentDate, PaymentMethod, PaymentStatus", paymentValues);
                
                JOptionPane.showMessageDialog(panel, "Billing & Payment Data saved Successfully!");
            }
            
        } catch (SQLException e) {
            System.err.println("Error occurred while saving data!");
            e.printStackTrace();
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
    
    private void clearFields() {
        this.description = "";
        this.costPerService = 0;
        this.serviceQuantity = 0;
        this.paymentAmount = 0;
        this.paymentMethod = "";
        this.paymentStatus = "";
        this.paymentProcessingDate = "";
    }

    
    
    
    // Getter and Setter methods
    public String getInvoiceID() {return invoiceID;}
    public void setInvoiceID(String invoiceID) {
        if (invoiceID != null && invoiceID.startsWith("INV")) {
            this.invoiceID = invoiceID;
        } else {
            JOptionPane.showMessageDialog(panel, "Invoice ID must start with 'INV'.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    // public void setInvoiceID(String invoiceID) {this.invoiceID = invoiceID;}
    
    public String getPatientID() {return patientID;}
    public void setPatientID(String patientID) {
        if (patientID != null && patientID.startsWith("P")) {
            this.patientID = patientID;
        } else {
            JOptionPane.showMessageDialog(panel, "Patient ID must start with 'P'.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    // public void setPatientID(String patientID) {this.patientID = patientID;}
    
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public double getCostPerService() {return costPerService;}

    public int getServiceQuantity() {return serviceQuantity;}
    public void setServiceQuantity(String serviceQuantity) {
        try {
            this.serviceQuantity = Integer.parseInt(serviceQuantity);
        } catch (NumberFormatException e) {
            this.serviceQuantity = 0;
            JOptionPane.showMessageDialog(panel, "Invalid input for service quantity. Please enter a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setServiceDate(String ServiceDate) {this.serviceDate = DateTimeUtils.formatDate(ServiceDate);}

    public double getPaymentAmount() {return paymentAmount;}

    public String getPaymentMethod() {return paymentMethod;}
    public void setPaymentMethod(String paymentMethod) {this.paymentMethod = paymentMethod;}

    public String getPaymentStatus() {return paymentStatus;}
    public void setPaymentStatus(String paymentStatus) {this.paymentStatus = paymentStatus;}

    public String getPaymentProcessingDate() {return paymentProcessingDate;}
    public void setPaymentProcessingDate(String paymentProcessingDate) {this.paymentProcessingDate = DateTimeUtils.formatDate(paymentProcessingDate);}

}
