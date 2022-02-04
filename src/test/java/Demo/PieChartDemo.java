package Demo;

import org.jfree.chart3d.*;
import org.jfree.chart3d.data.PieDataset3D;
import org.jfree.chart3d.data.StandardPieDataset3D;
import org.jfree.chart3d.graphics3d.swing.DisplayPanel3D;
import org.jfree.chart3d.label.StandardPieLabelGenerator;
import org.jfree.chart3d.plot.PiePlot3D;

import javax.swing.*;
import java.awt.*;

import static org.jfree.chart3d.label.StandardPieLabelGenerator.PERCENT_TEMPLATE;

/**
 * A demo of a pie chart.
 */
@SuppressWarnings("serial")
public class PieChartDemo extends JFrame {

    /**
     * Returns a panel containing the content for the demo.  This method is
     * used across all the individual demo applications to allow aggregation
     * into a single "umbrella" demo (OrsonChartsDemo).
     *
     * @return A panel containing the content for the demo.
     */
    public static JPanel createDemoPanel() {
        DemoPanel content = new DemoPanel(new BorderLayout());
        content.setPreferredSize(new Dimension(1024, 768));
        PieDataset3D<String> dataset = createDataset();
        final Chart3D chart = createChart(dataset);
        Chart3DPanel chartPanel = new Chart3DPanel(chart);
        chartPanel.setMargin(0.15);
        content.setChartPanel(chartPanel);
        chartPanel.zoomToFit(new Dimension(1024, 768));
        content.add(new DisplayPanel3D(chartPanel));
        JButton button = new JButton("Change the Data");
        button.addActionListener(e -> {
            PieDataset3D<String> dataset1 = createDataset();
            PiePlot3D plot = (PiePlot3D) chart.getPlot();
            plot.setDataset(dataset1);
        });
        content.add(button, BorderLayout.SOUTH);
        return content;
    }

    /**
     * Creates a sample dataset (hard-coded for the purpose of keeping the
     * demo self-contained - in practice you would normally read your data
     * from a file, database or other source).
     *
     * @return A sample dataset.
     */
    private static PieDataset3D<String> createDataset() {
        StandardPieDataset3D<String> dataset = new StandardPieDataset3D<>();
        dataset.add("United States", Math.random() * 30);
        dataset.add("France", Math.random() * 20);
        dataset.add("New Zealand", Math.random() * 12);
        dataset.add("United Kingdom", Math.random() * 43);
        dataset.add("Australia", Math.random() * 43);
        dataset.add("Canada", Math.random() * 43);
        return dataset;
    }

    /**
     * Creates a pie chart based on the supplied dataset.
     *
     * @param dataset  the dataset.
     *
     * @return A pie chart.
     */
    private static Chart3D createChart(PieDataset3D<String> dataset) {
        final Chart3D chart = Chart3DFactory.createPieChart("Orson Charts 3D",
                "For more info see: https://github.com/jfree/orson-charts/",
                dataset);
        chart.setTitleAnchor(TitleAnchor.TOP_LEFT);
        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setLegendLabelGenerator(new StandardPieLabelGenerator(PERCENT_TEMPLATE));
        plot.setSectionLabelGenerator(new StandardPieLabelGenerator(PERCENT_TEMPLATE));
        plot.setSectionColors(Colors.createFancyLightColors());
        return chart;
    }

    /**
     * Creates a new test app.
     *
     * @param title  the frame title.
     */
    public PieChartDemo(String title) {
        super(title);
        addWindowListener(new Exit());
        getContentPane().add(createDemoPanel());
    }

    /**
     * Starting point for the app.
     *
     * @param args  command line arguments (ignored).
     */
    public static void main(String[] args) {
        PieChartDemo app = new PieChartDemo("OrsonCharts: PieChart3DDemo2.java");
        app.pack();
        app.setVisible(true);
    }

}
