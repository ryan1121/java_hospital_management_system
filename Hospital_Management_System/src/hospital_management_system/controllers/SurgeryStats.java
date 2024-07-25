/*
数据分析 - 每种手术类型的数量统计
*/
import hospital_management_system.MysqlConnect;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.plot.PlotOrientation;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SurgeryStats {

    public static void main(String[] args) {
        MysqlConnect db = new MysqlConnect();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        String query = "SELECT surgeryType, COUNT(*) AS count FROM Surgery GROUP BY surgeryType";
        try (ResultSet rs = db.executeQuery(query)) {
            while (rs.next()) {
                String surgeryType = rs.getString("surgeryType");
                int count = rs.getInt("count");
                dataset.addValue(count, "Surgery Types", surgeryType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JFreeChart chart = ChartFactory.createBarChart(
                "Surgery Type Count",         // chart title
                "Surgery Type",               // domain axis label
                "Number of Surgeries",        // range axis label
                dataset,                      // data
                PlotOrientation.VERTICAL,     // orientation
                true,                         // include legend
                true,                         // tooltips
                false                         // urls
        );

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 370));

        JFrame frame = new JFrame("Surgery Type Stats");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(chartPanel);
        frame.pack();
        frame.setVisible(true);
    }
}

