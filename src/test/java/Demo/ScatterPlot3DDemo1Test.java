package Demo;


import org.jfree.chart3d.Chart3D;
import org.jfree.chart3d.Chart3DFactory;
import org.jfree.chart3d.axis.LabelOrientation;
import org.jfree.chart3d.axis.LogAxis3D;
import org.jfree.chart3d.axis.NumberAxis3D;
import org.jfree.chart3d.data.xyz.XYZSeries;
import org.jfree.chart3d.data.xyz.XYZSeriesCollection;
import org.jfree.chart3d.graphics3d.Dimension3D;
import org.jfree.chart3d.label.StandardXYZLabelGenerator;
import org.jfree.chart3d.plot.XYZPlot;
import org.jfree.chart3d.style.ChartStyler;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;


import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests for the ScatterPlot3DDemo1 class.
 */
class ScatterPlot3DDemo1Test {

    @Test
    public void checkEquals(){
        XYZSeriesCollection<String> dataset = new XYZSeriesCollection<>();
        Chart3D chart1 = Chart3DFactory.createScatterChart("ScatterPlot3DDemo1",
                "Chart created with Orson Charts", dataset, "X", "Y", "Z");
        Chart3D chart2 = Chart3DFactory.createScatterChart("ScatterPlot3DDemo1",
                "Chart created with Orson Charts", dataset, "X", "Y", "Z");
        assertEquals(chart1,chart2);
    }

    @Test
    public void checkNull(){
        Executable executable = () -> Chart3DFactory.createScatterChart("ScatterPlot3DDemo1",
                "Chart created with Orson Charts", null, "X", "Y", "Z");
        assertThrows(IllegalArgumentException.class, executable);
    }

    @Test
    public void checkAxisChangeToLog() {
        XYZSeries<String> s1 = new XYZSeries<>("S1");
        for (int i = 0; i < 1000; i++) {
            s1.add(Math.random() * 100, Math.random() / 100, Math.random() * 100);
        }
        XYZSeriesCollection<String> dataset = new XYZSeriesCollection<>();
        dataset.add(s1);

        XYZSeries<String> s2 = new XYZSeries<>("S2");
        for (int i = 0; i < 1000; i++) {
            s2.add(Math.random() * 100, Math.random() / 100, Math.random() * 100);
        }
        XYZSeriesCollection<String> dataset2 = new XYZSeriesCollection<>();
        dataset.add(s2);

        Chart3D chart1 = Chart3DFactory.createScatterChart("Scatter plot Log Axis Test",
                "Normal to Log axis test", dataset, "X", "Y", "Z");
        Chart3D chart2 = Chart3DFactory.createScatterChart("Scatter plot Log Axis Test",
                "Normal to Log axis test", dataset2, "X", "Y", "Z");
        XYZPlot plot1 = (XYZPlot) chart1.getPlot();
        XYZPlot plot2 = (XYZPlot) chart2.getPlot();

        NumberAxis3D yAxis1 = new NumberAxis3D("Y (normal scale)");
        yAxis1.setTickLabelOrientation(LabelOrientation.PERPENDICULAR);
        yAxis1.receive(new ChartStyler(chart1.getStyle()));
        plot1.setYAxis(yAxis1);

        NumberAxis3D yAxis2 = new NumberAxis3D("Y (normal scale)");
        yAxis2.setTickLabelOrientation(LabelOrientation.PERPENDICULAR);
        yAxis2.receive(new ChartStyler(chart2.getStyle()));
        plot2.setYAxis(yAxis2);

        plot1.setDimensions(new Dimension3D(10.0, 4.0, 4.0));
        plot2.setDimensions(new Dimension3D(10.0, 4.0, 4.0));

        plot1.setLegendLabelGenerator(new StandardXYZLabelGenerator(
                StandardXYZLabelGenerator.COUNT_TEMPLATE));
        plot2.setLegendLabelGenerator(new StandardXYZLabelGenerator(
                StandardXYZLabelGenerator.COUNT_TEMPLATE));

        // change axis of chart 1 from normal scale to Logarithmic scale
        LogAxis3D logAxis = new LogAxis3D("Y (logarithmic scale)");
        logAxis.receive(new ChartStyler(chart1.getStyle()));
        plot1.setYAxis(logAxis);
        // test to see if the axis actually changed, ie. chart1 (log) != chart2 (normal axis)
        assertEquals(chart1, chart2);
    }

}