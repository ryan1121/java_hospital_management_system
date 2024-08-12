package hospital_management_system.models;

import hospital_management_system.MysqlConnect;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Invoice {
    private String invoiceID;
    private String patientID;
    private String patientName;
    private String invoiceDate;
    private String invoiceDue;
    private double totalAmount;
    private double amountPaid;
    private double balanceDue;

    public Invoice(String invoiceID, String patientID) {
        this.invoiceID = invoiceID;
        this.patientID = patientID;
    }

    // Method to load invoice data from the database
    public void loadInvoiceData() throws SQLException {
        MysqlConnect db = new MysqlConnect();
        Connection conn = db.getConnection();
        String sql = "SELECT * FROM invoices WHERE InvoiceID = ? AND PatientID = ?";
        
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, invoiceID);
            pst.setString(2, patientID);
            
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    this.invoiceID = rs.getString("InvoiceID");
                    this.invoiceDate = rs.getString("InvoiceDate");
                    this.invoiceDue = rs.getString("InvoiceDue");
                    this.patientID = rs.getString("PatientID");
                    this.patientName = rs.getString("PatientName");
                    this.totalAmount = rs.getDouble("TotalAmount");
                    this.amountPaid = rs.getDouble("AmountPaid");
                    this.balanceDue = rs.getDouble("BalanceDue");
                }
            }
        }
    }

    // // Method to load invoice table data
    // public DefaultTableModel loadInvoiceTableData() {
    //     MysqlConnect db = new MysqlConnect();
    //     Connection conn = db.getConnection();
    //     String query = "SELECT * FROM Billing WHERE InvoiceID = '" + invoiceID + "'";
    //     DefaultTableModel tableModel = new DefaultTableModel();

    //     try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
    //         // Define column names
    //         Vector<String> columnNames = new Vector<>();
    //         columnNames.add("InvoiceID");
    //         columnNames.add("ServicesDescription");
    //         columnNames.add("CostPerService");
    //         columnNames.add("Quantity");
    //         columnNames.add("TotalPayment");

    //         tableModel.setColumnIdentifiers(columnNames);

    //         // Add rows to the table model
    //         while (rs.next()) {
    //             Vector<Object> row = new Vector<>();
    //             row.add(rs.getString("InvoiceID"));
    //             row.add(rs.getString("ServicesDescription"));
    //             row.add(rs.getString("CostPerService"));
    //             row.add(rs.getString("Quantity"));
    //             row.add(rs.getString("TotalPayment"));
    //             tableModel.addRow(row);
    //         }
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     } finally {
    //         db.closeConnection(conn);
    //     }
    //     return tableModel;
    // }

    // Getters for the invoice fields
    public JTextField getInvoiceIDField() {return invoiceIDField;}
    public void setInvoiceIDField(JTextField invoiceIDField) {this.invoiceIDField = invoiceIDField;}

    public JTextField getPatientIDField() {return patientIDField;}
    public void setPatientIDField(JTextField patientIDField) {this.patientIDField = patientIDField;}

    public JLabel getPatientNameLabel() {return patientNameLabel;}
    public void setPatientNameLabel(JLabel patientNameLabel) {this.patientNameLabel = patientNameLabel;}

    public JLabel getInvoiceDateLabel() {return invoiceDateLabel;}
    public void setInvoiceDateLabel(JLabel invoiceDateLabel) {this.invoiceDateLabel = invoiceDateLabel;}

    public JLabel getInvoiceDueLabel() {return invoiceDueLabel;}
    public void setInvoiceDueLabel(JLabel invoiceDueLabel) {this.invoiceDueLabel = invoiceDueLabel;}

    public JLabel getTotalAmountLabel() {return totalAmountLabel;}
    public void setTotalAmountLabel(JLabel totalAmountLabel) {this.totalAmountLabel = totalAmountLabel;}

    public JLabel getAmountPaidLabel() {return amountPaidLabel;}
    public void setAmountPaidLabel(JLabel amountPaidLabel) {this.amountPaidLabel = amountPaidLabel;}

    public JLabel getBalanceDueLabel() {return balanceDueLabel;}
    public void setBalanceDueLabel(JLabel balanceDueLabel) {this.balanceDueLabel = balanceDueLabel;}

    public List<ServiceDetail> getServiceDetails() {return serviceDetails;}
    public void setServiceDetails(List<ServiceDetail> serviceDetails) {this.serviceDetails = serviceDetails;}

}
