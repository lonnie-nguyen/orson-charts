package org.jfree.chart3d;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

class Chart3DColorTest {

    @Test
    public void testChart3DColor() {
    	Color expectedColor = new Color(255, 0, 0, 100);
        Chart3DColor chart3DColor = new Chart3DColor(expectedColor);
        Color actualColor = chart3DColor.getColor();

        assertEquals(expectedColor, actualColor);
        
        Color newExpectedColor = new Color(253, 127, 127, 100);
        chart3DColor.setColor(newExpectedColor);
        Color newActualColor = chart3DColor.getColor();
        
        assertEquals(newExpectedColor, newActualColor);
        assertNotEquals(actualColor, newActualColor);
    }

}
