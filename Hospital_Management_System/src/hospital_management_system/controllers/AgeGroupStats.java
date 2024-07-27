/*
数据分析 - 按年龄段统计患者数量
*/
package hospital_management_system.controllers;

import hospital_management_system.MysqlConnect;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.plot.PlotOrientation;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

public class AgeGroupStats {

    public static void showAgeGroupStats() {
        MysqlConnect db = new MysqlConnect();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        String query = "SELECT patient_id, patient_DOB FROM Patients";
        try (ResultSet rs = db.executeQuery(query)) {
            int[] ageGroups = new int[5]; // 0-18, 19-30, 31-40, 41-60, 61+

            while (rs.next()) {
                LocalDate dob = rs.getDate("patient_DOB").toLocalDate();
                int age = Period.between(dob, LocalDate.now()).getYears();
                
                if (age <= 18) ageGroups[0]++;
                else if (age <= 30) ageGroups[1]++;
                else if (age <= 40) ageGroups[2]++;
                else if (age <= 60) ageGroups[3]++;
                else ageGroups[4]++;
            }

            dataset.addValue(ageGroups[0], "Age Groups", "0-18");
            dataset.addValue(ageGroups[1], "Age Groups", "19-30");
            dataset.addValue(ageGroups[2], "Age Groups", "31-40");
            dataset.addValue(ageGroups[3], "Age Groups", "41-60");
            dataset.addValue(ageGroups[4], "Age Groups", "61+");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JFreeChart chart = ChartFactory.createBarChart(
                "Patient Count by Age Group", // chart title
                "Age Group",                  // domain axis label
                "Number of Patients",         // range axis label
                dataset,                      // data
                PlotOrientation.VERTICAL,     // orientation
                true,                         // include legend
                true,                         // tooltips
                false                         // urls
        );

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 370));

        JFrame frame = new JFrame("Age Group Stats");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.add(chartPanel);
        frame.pack();
        frame.setVisible(true);
    }
}
