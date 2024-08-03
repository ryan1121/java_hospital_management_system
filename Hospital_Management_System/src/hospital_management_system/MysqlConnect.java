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

    2. Execute command
    // 查询每个部门的患者数量
    String query = "SELECT doctor_department, COUNT(patient_id) AS patient_count FROM Patients " +
                    "JOIN Doctors ON Patients.doctor_id = Doctors.doctor_id " +
                    "GROUP BY doctor_department";

    try (ResultSet rs = db.executeQuery(query)) {
        while (rs.next()) {
            String department = rs.getString("doctor_department");
            int count = rs.getInt("patient_count");
            dataset.setValue(department, count);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
        
    // 3. Save Data
    String[] values = {"3", "1", "2", "Severe Cold", "2024-07-21", "Rest and Medication"};
    boolean saveSuccess = db.saveData("Diagnosis", "DiagnosisID, PatientID, DoctorID, DiagnosisDescription, DateOfDiagnosis, treatmentPlans", values);
    System.out.println("Data saved: " + saveSuccess);

    // 4. Update Data
    boolean updateSuccess = db.updateData("Diagnosis", "DiagnosisDescription = 'Mild Cold'", "DiagnosisID = '3'");
    System.out.println("Data updated: " + updateSuccess);

    // 5. Delete Data
    boolean deleteSuccess = db.deleteData("Diagnosis", "DiagnosisID = '3'");
    System.out.println("Data deleted: " + deleteSuccess);

    // 6. Generate New ID
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
        String query = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = ?";
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
     * 保存数据到指定的表中
     * @param tableName 表名
     * @param columns 列名，以逗号分隔
     * @param values 插入的值
     * @return 如果插入成功返回 true，否则返回 false
     * @throws SQLException SQL 执行异常
     */
    public boolean saveData(String tableName, String columns, String[] values) throws SQLException {
        // 构建 SQL 插入语句
        String placeholders = String.join(", ", Collections.nCopies(values.length, "?"));
        String sql = "INSERT INTO " + tableName + " (" + columns + ") VALUES (" + placeholders + ")";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            // 设置参数
            for (int i = 0; i < values.length; i++) {
                stmt.setString(i + 1, values[i]);
            }
            
            // 执行插入操作
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
