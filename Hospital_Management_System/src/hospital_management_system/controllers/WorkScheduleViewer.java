package hospital_management_system.controllers;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import hospital_management_system.MysqlConnect;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;


public class WorkScheduleViewer {

    private MysqlConnect db;
    private JTable DoctorScheduleTable;
    private JTable NurseScheduleTable;
    private JScrollPane jScrollPane7;
    private JScrollPane jScrollPane11;

    public WorkScheduleViewer(JTable doctorTable, JTable nurseTable, JScrollPane scrollPane7, JScrollPane scrollPane11) {
        try {
            db = new MysqlConnect();
        } catch (Exception e) {
            System.err.println("Failed to initialize database connection.");
            e.printStackTrace();
            // Handle the error appropriately
        }
        this.DoctorScheduleTable = doctorTable;
        this.NurseScheduleTable = nurseTable;
        this.jScrollPane7 = scrollPane7;
        this.jScrollPane11 = scrollPane11;
    }

    public void loadDoctorSchedule() {
        // Correct SQL query to match table and column names
        String query = "SELECT d.doctor_id AS DoctorID, d.doctor_name AS Name, s.StaffScheduleDate AS Date, s.ShiftStartTime AS StartTime, " +
                        "s.ShiftEndTime AS EndTime, s.Department, s.AssignedTasks " +
                        "FROM DoctorStaffScheduling s " +
                        "JOIN Doctors d ON s.DoctorID = d.doctor_id";

        ResultSet resultSet = executeCustomQuery(query);

        if (resultSet != null) {
            try {
                DefaultTableModel doctorModel = new DefaultTableModel(
                    new String[] {"Doctor ID", "Name", "Date", "Start Time", "End Time", "Department", "Tasks"}, 0) {
                        @Override
                        public boolean isCellEditable(int row, int column) {
                            return false; // Make all cells non-editable
                        }
                    };

                while (resultSet.next()) {
                    Object[] row = new Object[7];
                    row[0] = resultSet.getString("DoctorID"); // Doctor ID
                    row[1] = resultSet.getString("Name"); // Name
                    row[2] = resultSet.getDate("Date"); // Date
                    row[3] = resultSet.getTime("StartTime"); // Start Time
                    row[4] = resultSet.getTime("EndTime"); // End Time
                    row[5] = resultSet.getString("Department"); // Department
                    row[6] = resultSet.getString("AssignedTasks"); // Tasks

                    doctorModel.addRow(row);
                    }

                DoctorScheduleTable.setModel(doctorModel);
                DoctorScheduleTable.setIntercellSpacing(new java.awt.Dimension(1, 1));
                DoctorScheduleTable.setShowHorizontalLines(true);
                DoctorScheduleTable.setShowVerticalLines(true);
                DoctorScheduleTable.setCellSelectionEnabled(false);

                // Use custom renderer
                DoctorScheduleTable.setDefaultRenderer(Object.class, new CustomTableCellRenderer());

                // Add mouse listener to show popup
                DoctorScheduleTable.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseMoved(MouseEvent e) {
                        int row = DoctorScheduleTable.rowAtPoint(e.getPoint());
                        int column = DoctorScheduleTable.columnAtPoint(e.getPoint());
                        if (row >= 0 && column >= 0) {
                            Object value = DoctorScheduleTable.getValueAt(row, column);
                            if (value != null) {
                                JPopupMenu popup = new JPopupMenu();
                                popup.add(new JLabel(value.toString()));
                                popup.show(DoctorScheduleTable, e.getX(), e.getY());
                            }
                        }
                    }
                });

                jScrollPane7.setViewportView(DoctorScheduleTable);

            } catch (SQLException e) {
                System.err.println("Error processing result set!");
                e.printStackTrace();
            }
        } else {
            System.out.println("No data found.");
        }
    }

    public void loadNurseSchedule() {
        // Correct SQL query to match table and column names
        String query = "SELECT n.nurse_id AS NurseID, n.nurse_name AS Name, s.StaffScheduleDate AS Date, s.ShiftStartTime AS StartTime, " +
                        "s.ShiftEndTime AS EndTime, s.Department, s.AssignedTasks " +
                        "FROM NurseStaffScheduling s " +
                        "JOIN Nurse n ON s.NurseID = n.nurse_id";
    
        ResultSet resultSet = executeCustomQuery(query);
    
        if (resultSet != null) {
            try {
                DefaultTableModel nurseModel = new DefaultTableModel(
                    new String[] {"Nurse ID", "Name", "Date", "Start Time", "End Time", "Department", "Tasks"}, 0) {
                        @Override
                        public boolean isCellEditable(int row, int column) {
                            return false; // Make all cells non-editable
                        }
                    };

                while (resultSet.next()) {
                    Object[] row = new Object[7];
                    row[0] = resultSet.getString("NurseID"); // Nurse ID
                    row[1] = resultSet.getString("Name"); // Name
                    row[2] = resultSet.getDate("Date"); // Date
                    row[3] = resultSet.getTime("StartTime"); // Start Time
                    row[4] = resultSet.getTime("EndTime"); // End Time
                    row[5] = resultSet.getString("Department"); // Department
                    row[6] = resultSet.getString("AssignedTasks"); // Tasks
    
                    nurseModel.addRow(row);
                }
    
                NurseScheduleTable.setModel(nurseModel);
                NurseScheduleTable.setIntercellSpacing(new java.awt.Dimension(1, 1));
                NurseScheduleTable.setShowHorizontalLines(true);
                NurseScheduleTable.setShowVerticalLines(true);
                NurseScheduleTable.setCellSelectionEnabled(false);
    
                // Use custom renderer
                NurseScheduleTable.setDefaultRenderer(Object.class, new CustomTableCellRenderer());

                // Add mouse listener to show popup
                NurseScheduleTable.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseMoved(MouseEvent e) {
                        int row = NurseScheduleTable.rowAtPoint(e.getPoint());
                        int column = NurseScheduleTable.columnAtPoint(e.getPoint());
                        if (row >= 0 && column >= 0) {
                            Object value = NurseScheduleTable.getValueAt(row, column);
                            if (value != null) {
                                JPopupMenu popup = new JPopupMenu();
                                popup.add(new JLabel(value.toString()));
                                popup.show(NurseScheduleTable, e.getX(), e.getY());
                            }
                        }
                    }
                });

                jScrollPane11.setViewportView(NurseScheduleTable);
    
            } catch (SQLException e) {
                System.err.println("Error processing result set!");
                e.printStackTrace();
            }
        } else {
            System.out.println("No data found.");
        }
    }    

    private ResultSet executeCustomQuery(String query) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management", "root", "123456");
            Statement statement = connection.createStatement();
            return statement.executeQuery(query);
        } catch (SQLException e) {
            System.err.println("Cannot execute SQL query!");
            e.printStackTrace();
            return null;
        }
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Initialize your GUI components here
            JTable doctorTable = new JTable();
            JTable nurseTable = new JTable();
            JScrollPane scrollPane7 = new JScrollPane(doctorTable);
            JScrollPane scrollPane11 = new JScrollPane(nurseTable);

            WorkScheduleViewer viewer = new WorkScheduleViewer(doctorTable, nurseTable, scrollPane7, scrollPane11);
            viewer.loadDoctorSchedule();
            viewer.loadNurseSchedule();
        });
    }
}
