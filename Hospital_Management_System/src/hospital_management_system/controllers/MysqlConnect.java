package hospital_management_system.controllers;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
Example usage: 
    // 1. Get Data
    try {
        ResultSet rs = db.getData("designation", "userID = 1");
        while (rs != null && rs.next()) {
            System.out.println("Title: " + rs.getString("title"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    // 2. Save Data
    boolean saveSuccess = db.saveData("designation", "title", "'New Title'");
    System.out.println("Data saved: " + saveSuccess);

    // 3. Update Data
    boolean updateSuccess = db.updateData("designation", "title = 'Updated Title'", "userID = 1");
    System.out.println("Data updated: " + updateSuccess);

    // 4. Delete Data
    boolean deleteSuccess = db.deleteData("designation", "userID = 1");
    System.out.println("Data deleted: " + deleteSuccess); 
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
            Statement statement = connection.createStatement();
            return statement.executeQuery(query);
        } catch (SQLException e) {
            System.err.println("Cannot execute SQL query!");
            e.printStackTrace();
            return null;
        }
    }

    public boolean saveData(String tableName, String fieldNames, String values) {
        String query = "INSERT INTO " + tableName + " (" + fieldNames + ") VALUES (" + values + ")";
        try (Statement statement = connection.createStatement()) {
            int rowsInserted = statement.executeUpdate(query);
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.err.println("Cannot execute SQL query!");
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateData(String tableName, String updates, String condition) {
        String query = "UPDATE " + tableName + " SET " + updates + " WHERE " + condition;
        try (Statement statement = connection.createStatement()) {
            int rowsUpdated = statement.executeUpdate(query);
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.err.println("Cannot execute SQL query!");
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteData(String tableName, String condition) {
        String query = "DELETE FROM " + tableName + " WHERE " + condition;
        try (Statement statement = connection.createStatement()) {
            int rowsDeleted = statement.executeUpdate(query);
            return rowsDeleted > 0;
        } catch (SQLException e) {
            System.err.println("Cannot execute SQL query!");
            e.printStackTrace();
            return false;
        }
    }
}
