/*
数据分析 - 库存中各类物品的数量
*/
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

public class InventoryStats {

    public static void main(String[] args) {
        MysqlConnect db = new MysqlConnect();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        String query = "SELECT ItemName, InventoryStockQuantity FROM InventoryManagement";
        try (ResultSet rs = db.executeQuery(query)) {
            while (rs.next()) {
                String itemName = rs.getString("ItemName");
                int quantity = rs.getInt("InventoryStockQuantity");
                dataset.addValue(quantity, "Inventory Items", itemName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JFreeChart chart = ChartFactory.createBarChart(
                "Inventory Stock Quantity",  // chart title
                "Item Name",                 // domain axis label
                "Stock Quantity",            // range axis label
                dataset,                     // data
                PlotOrientation.VERTICAL,    // orientation
                true,                        // include legend
                true,                        // tooltips
                false                        // urls
        );

        // Customize the plot
        CategoryPlot plot = chart.getCategoryPlot();
        CategoryAxis xAxis = plot.getDomainAxis();
        xAxis.setLabel("Item Name");
        xAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45); // Rotate labels 45 degrees

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));

        JFrame frame = new JFrame("Inventory Stats");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(chartPanel);
        frame.pack();
        frame.setVisible(true);
    }
}
