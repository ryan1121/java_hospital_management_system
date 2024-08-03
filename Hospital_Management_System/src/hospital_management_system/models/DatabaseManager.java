package hospital_management_system.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hospital_management_system.MysqlConnect;

public class DatabaseManager {
    private MysqlConnect mysqlConnect;

    public DatabaseManager() {
        try {
            this.mysqlConnect = new MysqlConnect();
        } catch (Exception e) {
            System.err.println("Error initializing DatabaseManager: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<DoctorSchedule> fetchDoctorSchedules() {
        List<DoctorSchedule> schedules = new ArrayList<>();
        String query = "SELECT d.doctor_id AS DoctorID, d.doctor_name AS Name, s.StaffScheduleDate AS Date, s.ShiftStartTime AS StartTime, " +
                       "s.ShiftEndTime AS EndTime, s.Department, s.AssignedTasks " +
                       "FROM DoctorStaffScheduling s " +
                       "JOIN Doctors d ON s.DoctorID = d.doctor_id";

        try (ResultSet resultSet = mysqlConnect.executeQuery(query)) {
            while (resultSet.next()) {
                DoctorSchedule schedule = new DoctorSchedule(
                    resultSet.getString("DoctorID"),
                    resultSet.getString("Name"),
                    resultSet.getDate("Date"),
                    resultSet.getTime("StartTime").toString(),
                    resultSet.getTime("EndTime").toString(),
                    resultSet.getString("Department"),
                    resultSet.getString("AssignedTasks")
                );
                schedules.add(schedule);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error fetching doctor schedules!");
        }
        return schedules;
    }

    public List<NurseSchedule> fetchNurseSchedules() {
        List<NurseSchedule> schedules = new ArrayList<>();
        String query = "SELECT n.nurse_id AS NurseID, n.nurse_name AS Name, s.StaffScheduleDate AS Date, s.ShiftStartTime AS StartTime, " +
                       "s.ShiftEndTime AS EndTime, s.Department, s.AssignedTasks " +
                       "FROM NurseStaffScheduling s " +
                       "JOIN Nurse n ON s.NurseID = n.nurse_id";

        try (ResultSet resultSet = mysqlConnect.executeQuery(query)) {
            while (resultSet.next()) {
                NurseSchedule schedule = new NurseSchedule(
                    resultSet.getString("NurseID"),
                    resultSet.getString("Name"),
                    resultSet.getDate("Date"),
                    resultSet.getTime("StartTime").toString(),
                    resultSet.getTime("EndTime").toString(),
                    resultSet.getString("Department"),
                    resultSet.getString("AssignedTasks")
                );
                schedules.add(schedule);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error fetching nurse schedules!");
        }
        return schedules;
    }
}
