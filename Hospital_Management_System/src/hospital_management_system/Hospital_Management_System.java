package hospital_management_system;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Hospital_Management_System {
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

    }
}

