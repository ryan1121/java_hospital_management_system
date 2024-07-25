/*
数据分析 - 按科室统计医生数量
*/
import hospital_management_system.MysqlConnect;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentDoctorStats {

    public static void main(String[] args) {
        MysqlConnect db = new MysqlConnect();
        DefaultPieDataset dataset = new DefaultPieDataset();

        String query = "SELECT doctor_department, COUNT(doctor_id) AS doctor_count FROM Doctors " +
                       "GROUP BY doctor_department";

        try (ResultSet rs = db.executeQuery(query)) {
            while (rs.next()) {
                String department = rs.getString("doctor_department");
                int count = rs.getInt("doctor_count");
                dataset.setValue(department, count);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JFreeChart chart = ChartFactory.createPieChart(
                "Doctor Count by Department",
                dataset,
                true,
                true,
                false
        );

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 370));

        JFrame frame = new JFrame("Department Doctor Stats");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(chartPanel);
        frame.pack();
        frame.setVisible(true);
    }
}
