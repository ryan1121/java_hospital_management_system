/*
数据分析 - 每月支付总金额统计
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

public class MonthlyPaymentStats {

    public static void showMonthlyPaymentStats() {
        MysqlConnect db = new MysqlConnect();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        String query = "SELECT DATE_FORMAT(PaymentDate, '%Y-%m') AS Month, SUM(PaymentAmount) AS TotalAmount " +
                       "FROM Payment GROUP BY DATE_FORMAT(PaymentDate, '%Y-%m')";
        try (ResultSet rs = db.executeQuery(query)) {
            while (rs.next()) {
                String month = rs.getString("Month");
                double totalAmount = rs.getDouble("TotalAmount");
                dataset.addValue(totalAmount, "Payments", month);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "Monthly Payment Total Amount",
                "Month",
                "Total Amount",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        // Customize the plot
        CategoryPlot plot = barChart.getCategoryPlot();
        CategoryAxis xAxis = plot.getDomainAxis();
        xAxis.setLabel("Month");
        xAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45); // Rotate labels 45 degrees

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));

        JFrame frame = new JFrame();
        frame.setContentPane(chartPanel);
        frame.pack();
        frame.setTitle("Monthly Payment Total Amount");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setVisible(true);
    }
}
