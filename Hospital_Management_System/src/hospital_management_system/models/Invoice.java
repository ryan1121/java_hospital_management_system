package hospital_management_system.models;

import hospital_management_system.MysqlConnect;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class Invoice {
    private MysqlConnect db;

    public Invoice() {
        db = new MysqlConnect();
    }

    public List<String> getInvoiceDetails(String invoiceId, String patientId) throws SQLException {
        String query = "SELECT Invoice.InvoiceID, Invoice.InvoiceDate, Invoice.InvoiceDue, Invoice.TotalPayment, " +
                       "Invoice.AmountPaid, Invoice.BalanceDue, Patients.patient_name " +
                       "FROM Invoice " +
                       "JOIN Patients ON Invoice.PatientID = Patients.patient_id " +
                       "WHERE Invoice.InvoiceID = ? AND Invoice.PatientID = ?";
        try (PreparedStatement stmt = db.getConnection().prepareStatement(query)) {
            stmt.setString(1, invoiceId);
            stmt.setString(2, patientId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    List<String> invoiceDetails = new ArrayList<>();
                    invoiceDetails.add(rs.getString("InvoiceID"));
                    invoiceDetails.add(rs.getString("InvoiceDate"));
                    invoiceDetails.add(rs.getString("InvoiceDue"));
                    invoiceDetails.add(rs.getString("TotalPayment"));
                    invoiceDetails.add(rs.getString("AmountPaid"));
                    invoiceDetails.add(rs.getString("BalanceDue"));
                    invoiceDetails.add(rs.getString("patient_name"));
                    return invoiceDetails;
                } else {
                    return null;
                }
            }
        }
    }

    public List<List<String>> getInvoiceItems(String invoiceId) throws SQLException {
        String query = "SELECT ServicesDescription, CostPerService, Quantity, TotalPayment FROM Billing WHERE InvoiceID = ?";
        try (PreparedStatement stmt = db.getConnection().prepareStatement(query)) {
            stmt.setString(1, invoiceId);
            try (ResultSet rs = stmt.executeQuery()) {
                List<List<String>> invoiceItems = new ArrayList<>();
                while (rs.next()) {
                    List<String> item = new ArrayList<>();
                    item.add(rs.getString("ServicesDescription"));
                    item.add(rs.getString("CostPerService"));
                    item.add(rs.getString("Quantity"));
                    item.add(rs.getString("TotalPayment"));
                    invoiceItems.add(item);
                }
                return invoiceItems;
            }
        }
    }
}
