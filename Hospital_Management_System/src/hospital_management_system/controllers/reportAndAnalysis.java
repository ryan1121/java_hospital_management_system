package hospital_management_system.controllers;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import javax.swing.*;
import java.awt.*;

public class reportAndAnalysis {
    public static void main(String[] args) {
        // 创建数据集
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Male", 70);
        dataset.setValue("Female", 30);

        // 创建图表
        JFreeChart chart = ChartFactory.createPieChart(
                "Patient Gender Distribution",  // 图表标题
                dataset,                        // 数据集
                true,                           // 显示图例
                true,
                false
        );

        // 自定义图表外观
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setSectionPaint("Male", new Color(0, 0, 255));
        plot.setSectionPaint("Female", new Color(255, 0, 0));

        // 创建面板并添加图表
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(560, 370));

        // 创建窗口并显示
        JFrame frame = new JFrame();
        frame.setContentPane(chartPanel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

}
