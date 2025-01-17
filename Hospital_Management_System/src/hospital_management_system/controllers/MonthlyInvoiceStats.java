/*
数据分析 - 每月发票总金额统计
*/
package hospital_management_system.controllers;

import hospital_management_system.MysqlConnect;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.axis.CategoryLabelPositions;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MonthlyInvoiceStats {

    public static void showMonthlyInvoiceStats() {
        MysqlConnect db = new MysqlConnect();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        String query = "SELECT DATE_FORMAT(InvoiceDate, '%Y-%m') AS Month, SUM(TotalPayment) AS TotalAmount " +
                       "FROM Invoice GROUP BY DATE_FORMAT(InvoiceDate, '%Y-%m')";
        try (ResultSet rs = db.executeQuery(query)) {
            while (rs.next()) {
                String month = rs.getString("Month");
                double totalAmount = rs.getDouble("TotalAmount");
                dataset.addValue(totalAmount, "Invoices", month);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "Monthly Invoice Total Amount",
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
        frame.setTitle("Monthly Invoice Total Amount");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setVisible(true);
    }
}
