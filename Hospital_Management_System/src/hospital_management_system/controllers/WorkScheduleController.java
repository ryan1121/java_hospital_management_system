package hospital_management_system.controllers;

import hospital_management_system.models.DoctorSchedule;
import hospital_management_system.models.NurseSchedule;
import hospital_management_system.views.GUI_admin;
import hospital_management_system.views.Staff_Scheduling;
import hospital_management_system.MysqlConnect;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WorkScheduleController {


    private JTable doctorScheduleTable;
    private JTable nurseScheduleTable;
    private JScrollPane doctorScrollPane;
    private JScrollPane nurseScrollPane;
    private MysqlConnect mysqlConnect = new MysqlConnect();

    public WorkScheduleController(JTable doctorTable, JTable nurseTable, JScrollPane doctorPane, JScrollPane nursePane) {
        this.doctorScheduleTable = doctorTable;
        this.nurseScheduleTable = nurseTable;
        this.doctorScrollPane = doctorPane;
        this.nurseScrollPane = nursePane;
    }

    public void loadDoctorSchedule() {
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

        DefaultTableModel doctorModel = new DefaultTableModel(
            new String[]{"Doctor ID", "Name", "Date", "Start Time", "End Time", "Department", "Tasks"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make all cells non-editable
            }
        };

        for (DoctorSchedule schedule : schedules) {
            doctorModel.addRow(new Object[]{
                schedule.getDoctorID(),
                schedule.getName(),
                schedule.getDate(),
                schedule.getStartTime(),
                schedule.getEndTime(),
                schedule.getDepartment(),
                schedule.getAssignedTasks()
            });
        }

        setupTable(doctorScheduleTable, doctorModel, doctorScrollPane);
    }

    public void loadNurseSchedule() {
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

        DefaultTableModel nurseModel = new DefaultTableModel(
            new String[]{"Nurse ID", "Name", "Date", "Start Time", "End Time", "Department", "Tasks"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make all cells non-editable
            }
        };

        for (NurseSchedule schedule : schedules) {
            nurseModel.addRow(new Object[]{
                schedule.getNurseID(),
                schedule.getName(),
                schedule.getDate(),
                schedule.getStartTime(),
                schedule.getEndTime(),
                schedule.getDepartment(),
                schedule.getAssignedTasks()
            });
        }

        setupTable(nurseScheduleTable, nurseModel, nurseScrollPane);
    }

    private void setupTable(JTable table, DefaultTableModel model, JScrollPane scrollPane) {
        table.setModel(model);
        table.setIntercellSpacing(new Dimension(1, 1));
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(true);
        table.setCellSelectionEnabled(false);
        table.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                int column = table.columnAtPoint(e.getPoint());
                if (row >= 0 && column >= 0) {
                    Object value = table.getValueAt(row, column);
                    if (value != null) {
                        JPopupMenu popup = new JPopupMenu();
                        popup.add(new JLabel(value.toString()));
                        popup.show(table, e.getX(), e.getY());
                    }
                }
            }
        });
        scrollPane.setViewportView(table);
    }

    private static class CustomTableCellRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (value != null) {
                setToolTipText(value.toString());
            }
            return c;
        }
    }

    public static void openStaffScheduling(String role, JScrollPane doctorScrollPane) {
        try {
            Staff_Scheduling staffScheduling = new Staff_Scheduling();
            staffScheduling.setVisible(true);
            GUI_admin.getInstance().setRole(role); // Correctly set the role in GUI_admin instance
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(scrollPane, "Error opening scheduling form: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
