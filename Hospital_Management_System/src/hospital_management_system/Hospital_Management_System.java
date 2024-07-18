package hospital_management_system;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Hospital_Management_System {
    
    public static void mysql_connect(){
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "123456";

        System.out.println("Connecting database ...");
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find the driver in the classpath!", e);
        }
        
        // Try to establish a connection to the database
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // If connection is successful, print a success message
            System.out.println("Database connected!");
            
            // Execute SQL query
            try (Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery("SELECT * FROM designation")) {
                // Process the results
                while (resultSet.next()) {
                    // Retrieve data from the result set
                    String designationName = resultSet.getString("title");
                    // Print data or perform further processing
                    System.out.println("Designation Name: " + designationName);
                }
            }
        } catch (SQLException e) {
            // If an SQL exception occurs, print an error message
            System.err.println("Cannot connect to the database or execute SQL query!");
            // Print the stack trace for debugging purposes
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {

        // Create an object for the home page gui
        Role_Page_GUI home_pageGUI = new Role_Page_GUI();

        // Set the visibility of the GUI
        home_pageGUI.setVisible(true);

        // Wait for the login to complete
        while (home_pageGUI.isVisible()) {
            try {
                Thread.sleep(100); // Sleep for 100ms to avoid busy-waiting
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        // GUI_LOGIN Login_GUI = new GUI_LOGIN("Nurse");
        // Login_GUI.setVisible(true);

    }
}

