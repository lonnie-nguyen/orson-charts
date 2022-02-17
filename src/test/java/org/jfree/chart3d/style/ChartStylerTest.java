package org.jfree.chart3d.style;


import java.awt.Color;

import org.jfree.chart3d.marker.CategoryMarker;
import org.jfree.chart3d.marker.NumberMarker;
import org.jfree.chart3d.marker.RangeMarker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the {@link ChartStylerTest} class.
 */
public class ChartStylerTest {

    @Test
    // tests branches in method in chart3D\style\ChartStyler: styleMarker(Marker marker)
    // styleMarker method applies the current style to a marker
    // if statement with 3 branches of execution depending on the type of Marker passed in
    // ie. CategoryMarker / NumberMarker / RangeMarker
    public void testStyleMarker() {
        StandardChartStyle default_style = new StandardChartStyle();
        CategoryMarker cm = new CategoryMarker("category");
        ChartStyler styler = new ChartStyler(default_style);
        styler.styleMarker(cm);
        assertNotNull(styler);

        NumberMarker nm = new NumberMarker(1.0);
        styler.styleMarker(nm);
        assertNotNull(styler);

        RangeMarker rm = new RangeMarker(1.0, 2.0);
        styler.styleMarker(rm);
        assertNotNull(styler);

    }
}
