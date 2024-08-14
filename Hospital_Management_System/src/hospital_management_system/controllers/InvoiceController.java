package hospital_management_system.controllers;

import hospital_management_system.models.Invoice;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.List;

public class InvoiceController {
    private Invoice model;
    private JPanel panel;
    private JLabel InvoiceNo_display;
    private JLabel InvoiceDate_display;
    private JLabel InvoiceDue_display;
    private JLabel TotalAmount_display;
    private JLabel AmountPaid_display;
    private JLabel BalanceDue_display;
    private JLabel PatientName_display;
    private JLabel PatientID_display;
    private JTable InvoiceTable;

    public InvoiceController(
        JPanel panel,
        JLabel invoiceNo_display,
        JLabel invoiceDate_display,
        JLabel invoiceDue_display,
        JLabel totalAmount_display,
        JLabel amountPaid_display,
        JLabel balanceDue_display,
        JLabel patientName_display,
        JLabel patientID_display,
        JTable invoiceTable
    ) {
        this.panel = panel;
        this.InvoiceNo_display = invoiceNo_display;
        this.InvoiceDate_display = invoiceDate_display;
        this.InvoiceDue_display = invoiceDue_display;
        this.TotalAmount_display = totalAmount_display;
        this.AmountPaid_display = amountPaid_display;
        this.BalanceDue_display = balanceDue_display;
        this.PatientName_display = patientName_display;
        this.PatientID_display = patientID_display;
        this.InvoiceTable = invoiceTable;
        this.model = new Invoice();
    }

    public boolean handleDisplayInvoiceData(String invoiceId, String patientId) {
        this.model = new Invoice();

        try {
            List<String> invoiceData = model.getInvoiceDetails(invoiceId, patientId);
            if (invoiceData != null) {
                System.out.println("check invoiceno: " + InvoiceNo_display + "," + invoiceId);
                InvoiceNo_display.setText(invoiceData.get(0)); // InvoiceID
                InvoiceDate_display.setText(invoiceData.get(1)); // InvoiceDate
                InvoiceDue_display.setText(invoiceData.get(2)); // InvoiceDue
                TotalAmount_display.setText(invoiceData.get(3)); // TotalPayment
                AmountPaid_display.setText(invoiceData.get(4)); // AmountPaid
                BalanceDue_display.setText(invoiceData.get(5)); // BalanceDue
                PatientName_display.setText("   " + invoiceData.get(6)); // patientName
                PatientID_display.setText("    " + patientId);

                // Fetch and display invoice items
                fillInvoiceTable(invoiceId);
                return true;
            } else {
                // Handle the case where no invoice data is found
                JOptionPane.showMessageDialog(panel, "No invoice data found for the given ID and patient.", "Data Not Found", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(panel, "Error fetching invoice data: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();

            return false;
        }
    }

    private void fillInvoiceTable(String invoiceId) {
        DefaultTableModel tableModel = (DefaultTableModel) InvoiceTable.getModel();
        tableModel.setRowCount(0);  // Clear existing rows
        
        try {
            List<List<String>> invoiceItems = model.getInvoiceItems(invoiceId);
            for (List<String> item : invoiceItems) {
                String description = item.get(0); // ServicesDescription
                double costPerService = Double.parseDouble(item.get(1)); // CostPerService
                int quantity = Integer.parseInt(item.get(2)); // Quantity
                double totalCost = Double.parseDouble(item.get(3)); // TotalPayment

                // Add row to table
                tableModel.addRow(new Object[]{description, costPerService, quantity, totalCost});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(panel, "Error fetching invoice items: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
