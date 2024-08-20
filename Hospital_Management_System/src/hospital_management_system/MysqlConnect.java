package hospital_management_system;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

public class MysqlConnect {
    private final String url = "jdbc:mysql://localhost:3306/hospital_management";
    private final String username = "root";
    private final String password = "123456";
    private Connection connection;

    public MysqlConnect() {
        connect();
    }

    private void connect() {
        System.out.println("Connecting database ...");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded!");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected!");
        } catch (ClassNotFoundException | SQLException e) {
            throw new IllegalStateException("Cannot connect to the database!", e);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public ResultSet executeQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            return statement.executeQuery(query);
        } catch (SQLException e) {
            System.err.println("Cannot execute SQL query!");
            e.printStackTrace();
            return null;
        }
    }
    
    public String[] getTableColumns(String tableName) {
        String query = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = ? ORDER BY ORDINAL_POSITION";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, tableName);
            ResultSet rs = statement.executeQuery();
            ArrayList<String> columns = new ArrayList<>();
            while (rs.next()) {
                columns.add(rs.getString("COLUMN_NAME"));
            }
            return columns.toArray(new String[0]);
        } catch (SQLException e) {
            System.err.println("Cannot execute SQL query!");
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet getData(String tableName, String condition) {
        String query = "SELECT * FROM " + tableName + " WHERE " + condition;
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            return statement.executeQuery();
        } catch (SQLException e) {
            System.err.println("Cannot execute SQL query!");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param tableName 
     * @param columns 
     * @param values 
     * @return
     * @throws SQLException 
     */
    public boolean saveData(String tableName, String columns, String[] values) throws SQLException {
        String placeholders = String.join(", ", Collections.nCopies(values.length, "?"));
        String sql = "INSERT INTO " + tableName + " (" + columns + ") VALUES (" + placeholders + ")";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            for (int i = 0; i < values.length; i++) {
                stmt.setString(i + 1, values[i]);
            }
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Cannot execute SQL query!");
            e.printStackTrace();
            throw e;
        }
    }
    
    public int executeUpdate(String query) {
        try {
            Statement statement = connection.createStatement();
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public String getPrimaryKeyColumn(String tableName) {
        String primaryKeyColumn = null;

        try {
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet primaryKeys = metaData.getPrimaryKeys(null, null, tableName);

            if (primaryKeys.next()) {
                primaryKeyColumn = primaryKeys.getString("COLUMN_NAME");
            }

            primaryKeys.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return primaryKeyColumn;

    }
    public boolean updateData(String tableName, String updates, String condition) {
        String query = "UPDATE " + tableName + " SET " + updates + " WHERE " + condition;
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.err.println("Cannot execute SQL query!");
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteData(String tableName, String condition) {
        String query = "DELETE FROM " + tableName + " WHERE " + condition;
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            System.err.println("Cannot execute SQL query!");
            e.printStackTrace();
            return false;
        }
    }

    public String generateNewId(String tableName, String idPrefix) {
        String idColumnName = "";
    
        if (tableName.equalsIgnoreCase("Patients")) {
            idColumnName = "patient_id";
        } else if (tableName.equalsIgnoreCase("Doctors")) {
            idColumnName = "doctor_id";
        } else if (tableName.equalsIgnoreCase("Nurse")) {
            idColumnName = "nurse_id";
        } else if (tableName.equalsIgnoreCase("PatientCare")) {
            idColumnName = "Primary_doctor_id";
        } else if (tableName.equalsIgnoreCase("Admission")) {
            idColumnName = "Admission_ID";
        } else if (tableName.equalsIgnoreCase("Appointment")) {
            idColumnName = "Appointment_ID";
        } else if (tableName.equalsIgnoreCase("BedAllocation")) {
            idColumnName = "bed_allocate_number";
        } else if (tableName.equalsIgnoreCase("Admin")) {
            idColumnName = "admin_id";
        } else if (tableName.equalsIgnoreCase("Prescription")) {
            idColumnName = "PrescriptionID";
        } else if (tableName.equalsIgnoreCase("MedicalRecords")) {
            idColumnName = "medicalRecordID";
        } else if (tableName.equalsIgnoreCase("Surgery")) {
            idColumnName = "surgeryID";
        } else if (tableName.equalsIgnoreCase("Consultations")) {
            idColumnName = "ConsultationID";
        } else if (tableName.equalsIgnoreCase("Diagnosis")) {
            idColumnName = "DiagnosisID";
        } else if (tableName.equalsIgnoreCase("PatientHistory")) {
            idColumnName = "HistoryID";
        } else if (tableName.equalsIgnoreCase("Invoice")) {
            idColumnName = "InvoiceID";
        } else if (tableName.equalsIgnoreCase("Billing")) {
            idColumnName = "InvoiceID";  
        } else if (tableName.equalsIgnoreCase("DoctorStaffScheduling")) {
            idColumnName = "DoctorID"; 
        } else if (tableName.equalsIgnoreCase("NurseStaffScheduling")) {
            idColumnName = "NurseID"; 
        } else if (tableName.equalsIgnoreCase("InventoryManagement")) {
            idColumnName = "InventoryID";
        } else if (tableName.equalsIgnoreCase("MedicalSupplyManagement")) {
            idColumnName = "SupplyID";
        } else if (tableName.equalsIgnoreCase("TransferManagement")) {
            idColumnName = "TransferID";
        } else if (tableName.equalsIgnoreCase("Payment")) {
            idColumnName = "PaymentID";
        }
    
        String query = "SELECT MAX(CAST(SUBSTRING(" + idColumnName + ", LENGTH(?) + 1) AS UNSIGNED)) AS max_id FROM " + tableName;
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, idPrefix);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String maxId = resultSet.getString("max_id");
                    if (maxId != null) {
                        int newIdNum = Integer.parseInt(maxId) + 1;
                        return idPrefix + String.format("%03d", newIdNum);
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Cannot execute SQL query!");
            e.printStackTrace();
        }
        return idPrefix + "001"; 
    }
    
}
