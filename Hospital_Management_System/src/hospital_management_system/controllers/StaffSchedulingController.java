package hospital_management_system.controllers;

import hospital_management_system.MysqlConnect;
import hospital_management_system.models.StaffSchedulingModel;
import javax.swing.JOptionPane;

public class StaffSchedulingController {
    private StaffSchedulingModel model;

    public StaffSchedulingController(StaffSchedulingModel model) {
        this.model = model;
    }

    public boolean saveSchedule(String role) {
        // Check if the role is null or empty
        if (role == null || role.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Role cannot be null or empty", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Check if all required fields in the model are filled
        if (!model.isValid()) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Format date and time values
        String[] formattedValues = model.getFormattedDateTime();
        if (formattedValues == null) {
            JOptionPane.showMessageDialog(null, "Invalid date or time format", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        try {
            MysqlConnect db = new MysqlConnect();
            
            // Prepare values for the SQL query
            String[] values = {
                model.getStaffID(),
                formattedValues[0], // Date
                formattedValues[1], // Start Time
                formattedValues[2], // End Time
                model.getDepartment(),
                model.getTasks()
            };

            // Determine the table name and columns based on the role
            String columns;
            String tableName;
            if (role.equalsIgnoreCase("Doctor")) {
                columns = "DoctorID, StaffScheduleDate, ShiftStartTime, ShiftEndTime, Department, AssignedTasks";
                tableName = "DoctorStaffScheduling";
            } else if (role.equalsIgnoreCase("Nurse")) {
                columns = "NurseID, StaffScheduleDate, ShiftStartTime, ShiftEndTime, Department, AssignedTasks";
                tableName = "NurseStaffScheduling";
            } else {
                JOptionPane.showMessageDialog(null, "Unknown role: " + role, "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            // Save data to the database
            if (db.saveData(tableName, columns, values)) {
                JOptionPane.showMessageDialog(null, "Data saved successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Cannot execute SQL query!", "Database Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error while saving data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
