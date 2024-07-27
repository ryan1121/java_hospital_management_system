/*
数据分析 - 统计保险公司患者数量
*/
package hospital_management_system.controllers;

import hospital_management_system.MysqlConnect;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsuranceStats {

    public static void showInsuranceStats() {
        MysqlConnect db = new MysqlConnect();
        DefaultPieDataset dataset = new DefaultPieDataset();

        String query = "SELECT providerName, COUNT(patient_id) AS patient_count FROM Patients " +
                       "GROUP BY providerName";

        try (ResultSet rs = db.executeQuery(query)) {
            while (rs.next()) {
                String provider = rs.getString("providerName");
                int count = rs.getInt("patient_count");
                dataset.setValue(provider, count);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JFreeChart chart = ChartFactory.createPieChart(
                "Patient Count by Insurance Provider",
                dataset,
                true,
                true,
                false
        );

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 370));

        JFrame frame = new JFrame("Insurance Stats");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.add(chartPanel);
        frame.pack();
        frame.setVisible(true);
    }
}
