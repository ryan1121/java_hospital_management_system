package hospital_management_system.models;

import hospital_management_system.MysqlConnect;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientHistory {
    private String historyID;
    private String patientID;
    private String eventType;
    private String eventDate;
    private String details;

    public PatientHistory() {
        // Default constructor
    }

    public PatientHistory(String historyID, String patientID, String eventType, String eventDate, String details) {
        this.historyID = historyID;
        this.patientID = patientID;
        this.eventType = eventType;
        this.eventDate = eventDate;
        this.details = details;
    }

    public boolean save(String[] historyValues) {
        MysqlConnect db = new MysqlConnect();
        try {
            // Save Patient History Data
            return db.saveData("PatientHistory", "HistoryID, PatientID, EventType, EventDate, Details", historyValues);
        } catch (SQLException e) {
            System.err.println("Error while saving data: " + e.getMessage());
            return false;
        }
    }

    public ResultSet getPatientHistory(String patientID) {
        MysqlConnect db = new MysqlConnect();
        String condition = "PatientID = '" + patientID + "'";
        return db.getData("PatientHistory", condition);
    }

    // Getters and Setters
    public String getHistoryID() { return historyID; }
    public void setHistoryID(String historyID) { this.historyID = historyID; }

    public String getPatientID() { return patientID; }
    public void setPatientID(String patientID) { this.patientID = patientID; }

    public String getEventType() { return eventType; }
    public void setEventType(String eventType) { this.eventType = eventType; }

    public String getEventDate() { return eventDate; }
    public void setEventDate(String eventDate) { this.eventDate = eventDate; }

    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }
}
