/*
数据分析 - 即将过期的医疗物品
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ExpiringMedicalSupplies {

    public static void showExpiringMedicalSupplies() {
        MysqlConnect db = new MysqlConnect();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Define the date range for expiring supplies (next 30 days)
        LocalDate today = LocalDate.now();
        LocalDate next30Days = today.plusDays(30);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String todayStr = today.format(formatter);
        String next30DaysStr = next30Days.format(formatter);

        String query = "SELECT SupplyName, SupplyStockQuantity, SupplyExpiryDate " +
                       "FROM MedicalSupplyManagement " +
                       "WHERE SupplyExpiryDate BETWEEN '" + todayStr + "' AND '" + next30DaysStr + "'";
        
        try (ResultSet rs = db.executeQuery(query)) {
            while (rs.next()) {
                String supplyName = rs.getString("SupplyName");
                int stockQuantity = rs.getInt("SupplyStockQuantity");
                dataset.addValue(stockQuantity, "Medical Supplies", supplyName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JFreeChart chart = ChartFactory.createBarChart(
                "Expiring Medical Supplies",  // chart title
                "Supply Name",                // domain axis label
                "Stock Quantity",             // range axis label
                dataset,                      // data
                PlotOrientation.VERTICAL,     // orientation
                true,                         // include legend
                true,                         // tooltips
                false                         // urls
        );

        // Customize the plot
        CategoryPlot plot = chart.getCategoryPlot();
        CategoryAxis xAxis = plot.getDomainAxis();
        xAxis.setLabel("Supply Name");
        xAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45); // Rotate labels 45 degrees

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));

        JFrame frame = new JFrame("Expiring Medical Supplies");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.add(chartPanel);
        frame.pack();
        frame.setVisible(true);
    }
}
