package Demo;

import org.jfree.chart3d.Chart3D;
import org.jfree.chart3d.Chart3DFactory;
import org.jfree.chart3d.data.xyz.XYZSeriesCollection;
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

}