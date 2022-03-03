package org.jfree.chart3d;

import org.jfree.chart3d.data.xyz.XYZDataset;
import org.jfree.chart3d.data.xyz.XYZSeries;
import org.jfree.chart3d.data.xyz.XYZSeriesCollection;
import org.jfree.chart3d.graphics3d.Dimension3D;
import org.jfree.chart3d.graphics3d.ViewPoint3D;
import org.jfree.chart3d.label.StandardXYZLabelGenerator;
import org.jfree.chart3d.plot.XYZPlot;
import org.jfree.chart3d.renderer.xyz.ScatterXYZRenderer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Chart3DFactoryTest {

    @Test
    void testCreateScatterNormalAndLog() {
            XYZSeries<String> s1 = new XYZSeries<>("s1");
            for (int i = 0; i < 10; i++) {
                s1.add(Math.random() * 100, Math.random() / 100, Math.random() * 100);
            }
            XYZSeriesCollection<String> dataset = new XYZSeriesCollection<>();
            dataset.add(s1);

            boolean log_axis=true;
            Chart3D chartLog = Chart3DFactory.createScatterChartNormalOrLog("ScatterPlot3DDemo1",
                    "Chart created with Orson Charts", dataset, "X", "Y",
                    "Z", log_axis);
            XYZPlot plot = (XYZPlot) chartLog.getPlot();
            assertNotNull(chartLog);
            // assert log axis
            String axisType = plot.getXAxis().getClass().getSimpleName();
            assertEquals(axisType,"LogAxis3D");

            log_axis=false;
            Chart3D chartNormalAxis = Chart3DFactory.createScatterChartNormalOrLog("ScatterPlot3DDemo1",
                    "Chart created with Orson Charts", dataset, "X", "Y",
                    "Z", log_axis);
            plot = (XYZPlot) chartNormalAxis.getPlot();
            assertNotNull(chartNormalAxis);
            // assert log axis
            axisType = plot.getXAxis().getClass().getSimpleName();
            assertEquals(axisType,"NumberAxis3D");
        }


    }
