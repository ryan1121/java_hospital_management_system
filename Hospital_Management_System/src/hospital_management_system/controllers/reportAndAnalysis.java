import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.JFrame;

public class reportAndAnalysis {

    public static void main(String[] args) {
        // 创建数据集
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category A", 40);
        dataset.setValue("Category B", 30);
        dataset.setValue("Category C", 20);
        dataset.setValue("Category D", 10);

        // 创建饼图
        JFreeChart chart = ChartFactory.createPieChart(
                "Pie Chart Example",
                dataset,
                true,
                true,
                false
        );

        // 将图表添加到面板中
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 370));

        // 创建并显示窗口
        JFrame frame = new JFrame("JFreeChart Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(chartPanel);
        frame.pack();
        frame.setVisible(true);
    }
}
