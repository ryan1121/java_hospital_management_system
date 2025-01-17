/*
数据分析 - 每种手术类型的数量统计
*/
package hospital_management_system.controllers;

import hospital_management_system.MysqlConnect;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SurgeryStats {

    public static void showSurgeryStats() {
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

        // Customize the plot
        CategoryPlot plot = chart.getCategoryPlot();
        CategoryAxis xAxis = plot.getDomainAxis();
        xAxis.setLabel("Surgery Type");
        xAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45); // Rotate labels 45 degrees

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));

        JFrame frame = new JFrame("Surgery Type Stats");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.add(chartPanel);
        frame.pack();
        frame.setVisible(true);
    }
}
