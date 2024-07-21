import java.sql.*;

public class MysqlConnect {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "root";
    private static final String password = "123456";

    private Connection connection;

    public MysqlConnect() {
        connectDatabase();
    }

    private void connectDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded!");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected!");
        } catch (ClassNotFoundException | SQLException e) {
            throw new IllegalStateException("Cannot connect to the database!", e);
        }
    }

    // Getter method to retrieve data
    public void getData(String tableName, String fieldName) {
        String query = "SELECT " + fieldName + " FROM " + tableName;
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                String data = resultSet.getString(fieldName);
                System.out.println(fieldName + ": " + data);
            }
        } catch (SQLException e) {
            System.err.println("Cannot execute SQL query!");
            e.printStackTrace();
        }
    }

    // Setter method to save data
    public void saveData(String tableName, String[] fields, String[] values) {
        if (fields.length != values.length) {
            throw new IllegalArgumentException("Fields and values length must match.");
        }

        StringBuilder fieldList = new StringBuilder();
        StringBuilder valueList = new StringBuilder();

        for (String field : fields) {
            fieldList.append(field).append(",");
        }

        for (String value : values) {
            valueList.append("'").append(value).append("',");
        }

        // Remove trailing commas
        fieldList.setLength(fieldList.length() - 1);
        valueList.setLength(valueList.length() - 1);

        String query = "INSERT INTO " + tableName + " (" + fieldList + ") VALUES (" + valueList + ")";

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
            System.out.println("Data saved successfully!");
        } catch (SQLException e) {
            System.err.println("Cannot execute SQL query!");
            e.printStackTrace();
        }
    }

    // Setter method to update data
    public void updateData(String tableName, String[] fields, String[] values, String condition) {
        if (fields.length != values.length) {
            throw new IllegalArgumentException("Fields and values length must match.");
        }

        StringBuilder updateList = new StringBuilder();

        for (int i = 0; i < fields.length; i++) {
            updateList.append(fields[i]).append(" = '").append(values[i]).append("',");
        }

        // Remove trailing comma
        updateList.setLength(updateList.length() - 1);

        String query = "UPDATE " + tableName + " SET " + updateList + " WHERE " + condition;

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
            System.out.println("Data updated successfully!");
        } catch (SQLException e) {
            System.err.println("Cannot execute SQL query!");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MysqlConnect db = new MysqlConnect();

        // Example usage:
        db.getData("designation", "title");
        
        String[] fields = {"field1", "field2"};
        String[] values = {"value1", "value2"};
        db.saveData("your_table_name", fields, values);
        
        String[] updateFields = {"field1"};
        String[] updateValues = {"new_value1"};
        db.updateData("your_table_name", updateFields, updateValues, "field2 = 'value2'");
    }
}
