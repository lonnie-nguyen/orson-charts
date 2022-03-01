package org.jfree.chart3d.util;

import org.jfree.chart3d.internal.TextUtils;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


public class TextUtilsTest {
    private FontMetrics fm;

    @BeforeEach
    public void setup() {
        fm = mock(FontMetrics.class);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getTextBoundsTest(){
        int x = 1, y = 2, ascent = 7, height = 10, width = 5;

        when(this.fm.stringWidth(any())).thenReturn(width);
        when(this.fm.getHeight()).thenReturn(height);
        when(this.fm.getAscent()).thenReturn(ascent);

        Rectangle2D rectangle2D = TextUtils.getTextBounds("meaningless test string", x, y, this.fm);

        Assertions.assertEquals(rectangle2D.getX(), x);
        Assertions.assertEquals(rectangle2D.getY(), y - ascent);
        Assertions.assertEquals(rectangle2D.getWidth(), width);
        Assertions.assertEquals(rectangle2D.getHeight(), height);

        verify(this.fm, times(1)).stringWidth(any());
        verify(this.fm, times(1)).getHeight();
        verify(this.fm, times(1)).getAscent();
    }
}
