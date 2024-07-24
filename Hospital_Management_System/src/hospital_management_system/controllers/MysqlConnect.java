package hospital_management_system.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
Example Usage: 
    // 创建 MysqlConnect 对象
    MysqlConnect db = new MysqlConnect();

    // 1. Get Data
    String[] values = {"3", "1", "2", "Severe Cold", "2024-07-21", "Rest and Medication"};
    try {
        boolean saveResult = db.saveData("Diagnosis", "DiagnosisID, PatientID, DoctorID, DiagnosisDescription, DateOfDiagnosis, treatmentPlans", values);
        System.out.println("Data saved: " + saveResult);
    } catch (SQLException e) {
        System.err.println("Error while saving data!");
        e.printStackTrace();
    }

    // 2. Save Data
    String[] values = {"3", "1", "2", "Severe Cold", "2024-07-21", "Rest and Medication"};
    boolean saveSuccess = db.saveData("Diagnosis", "DiagnosisID, PatientID, DoctorID, DiagnosisDescription, DateOfDiagnosis, treatmentPlans", values);
    System.out.println("Data saved: " + saveSuccess);

    // 3. Update Data
    boolean updateSuccess = db.updateData("Diagnosis", "DiagnosisDescription = 'Mild Cold'", "DiagnosisID = '3'");
    System.out.println("Data updated: " + updateSuccess);

    // 4. Delete Data
    boolean deleteSuccess = db.deleteData("Diagnosis", "DiagnosisID = '3'");
    System.out.println("Data deleted: " + deleteSuccess);

    // Generate New ID
    String newPatientId = db.generateNewId("Patients", "P");
    System.out.println("New Patient ID: " + newPatientId);
*/
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

    public boolean saveData(String tableName, String fieldNames, String[] values) throws SQLException {
        String query = "INSERT INTO " + tableName + " (" + fieldNames + ") VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            for (int i = 0; i < values.length; i++) {
                statement.setString(i + 1, values[i]);
            }
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.err.println("Cannot execute SQL query!");
            e.printStackTrace();
            throw e;
        }
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
        String query = "SELECT COUNT(*) AS total FROM " + tableName;
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                int total = resultSet.getInt("total") + 1;
                return idPrefix + String.format("%03d", total);
            }
        } catch (SQLException e) {
            System.err.println("Cannot execute SQL query!");
            e.printStackTrace();
        }
        return null;
    }
}
