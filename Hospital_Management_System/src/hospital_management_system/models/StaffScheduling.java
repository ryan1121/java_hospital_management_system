package hospital_management_system.models;

import hospital_management_system.utils.DateTimeUtils;

public class StaffScheduling {
    private String staffID;
    private String shiftDate;
    private String shiftStartTime;
    private String shiftEndTime;
    private String department;
    private String tasks;

    public StaffScheduling(String staffID, String shiftDate, String shiftStartTime, String shiftEndTime, String department, String tasks) {
        this.staffID = staffID;
        this.shiftDate = shiftDate;
        this.shiftStartTime = shiftStartTime;
        this.shiftEndTime = shiftEndTime;
        this.department = department;
        this.tasks = tasks;
    }

    public String getStaffID() {
        return staffID;
    }

    public String getShiftDate() {
        return shiftDate;
    }

    public String getShiftStartTime() {
        return shiftStartTime;
    }

    public String getShiftEndTime() {
        return shiftEndTime;
    }

    public String getDepartment() {
        return department;
    }

    public String getTasks() {
        return tasks;
    }

    public boolean isValid() {
        return !staffID.isEmpty() && !shiftDate.isEmpty() && !shiftStartTime.isEmpty() &&
               !shiftEndTime.isEmpty() && !department.isEmpty() && !tasks.isEmpty();
    }

    public String[] getFormattedDateTime() {
        String formattedDate = DateTimeUtils.formatDate(shiftDate);
        String formattedStartTime = DateTimeUtils.formatTime(shiftStartTime);
        String formattedEndTime = DateTimeUtils.formatTime(shiftEndTime);

        if (formattedDate == null || formattedStartTime == null || formattedEndTime == null) {
            return null;
        }
        return new String[]{formattedDate, formattedStartTime, formattedEndTime};
    }
}
