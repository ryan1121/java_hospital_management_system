package hospital_management_system.models;

import hospital_management_system.MysqlConnect;
import hospital_management_system.utils.DateTimeUtils;

import javax.swing.*;
import java.sql.SQLException;

public class PatientHistory {
    private String historyID;
    private String eventType;
    private String eventDate;
    private String details;

    public boolean save(String[] historyValues) {
        MysqlConnect db = new MysqlConnect();
        try {
            // Save Patient History Data
            boolean saveHistoryResult = db.saveData("PatientHistory", "HistoryID, PatientID, EventType, EventDate, Details", historyValues);
            return saveHistoryResult;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(panel, "Error while saving data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    // Getters and Setters
    public String getHistoryID() { return historyID; }
    public void setHistoryID(String historyID) { this.historyID = historyID; }

    public String getEventType() { return eventType; }
    public void setEventType(String eventType) { this.eventType = eventType; }

    public String getEventDate() { return eventDate; }
    public void setEventDate(String eventDate) { this.eventDate = eventDate; }

    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }
}
