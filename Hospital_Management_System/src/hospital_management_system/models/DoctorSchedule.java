package hospital_management_system.models;

import java.util.Date;

public class DoctorSchedule {
    private String doctorID;
    private String name;
    private Date date;
    private String startTime;
    private String endTime;
    private String department;
    private String assignedTasks;

    public DoctorSchedule(String doctorID, String name, Date date, String startTime, String endTime, String department, String assignedTasks) {
        this.doctorID = doctorID;
        this.name = name;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.department = department;
        this.assignedTasks = assignedTasks;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getDepartment() {
        return department;
    }

    public String getAssignedTasks() {
        return assignedTasks;
    }
}
