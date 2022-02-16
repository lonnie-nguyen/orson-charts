package org.jfree.chart3d.util;

import org.junit.jupiter.api.Test;
import org.jfree.chart3d.internal.Args;
import static org.junit.jupiter.api.Assertions.*;


/**
 * Some tests for the {@link Args} class.
 */
// NEW TESTS ADDED BY MSWE GROUP
public class ArgsTest {

    @Test
    public void testNullNotPermitted() {
        // test null
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
            Args.nullNotPermitted(null, "color"));
        String expectedMsg = "Null 'color' argument.";
        String actualMsg = exception.getMessage();
        assertEquals(expectedMsg, actualMsg);
    }

    @Test
    public void testNegativeNotPermitted() {
        // test negative
    	Exception exception = assertThrows(IllegalArgumentException.class, () ->
            Args.negativeNotPermitted(-5.0, "color"));
    	String expectedMsg = "Param 'color' cannot be negative";
    	String actualMsg = exception.getMessage();
    	assertEquals(expectedMsg, actualMsg);
        
        Args.negativeNotPermitted(-0.0, "color");
    }
    
    @Test
    public void testPositiveRequired() {
        // test positive required
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
            Args.positiveRequired(-5.0, "color"));
        String expectedMsg = "Param 'color' must be positive.";
        String actualMsg = exception.getMessage();
        assertEquals(expectedMsg, actualMsg);
    }
    
    @Test
    public void testFiniteRequired() {
    	// finiteRequired
    	Exception exception = assertThrows(IllegalArgumentException.class, () ->
    		Args.finiteRequired(Double.POSITIVE_INFINITY, "color"));
    	String expectedMsg = "Param 'color' must be finite.";
    	String actualMsg = exception.getMessage();
    	assertEquals(expectedMsg, actualMsg);
    }
    
    @Test
    public void testFinitePositiveRequired() {
    	// finitePositiveRequired
    	Exception exception = assertThrows(IllegalArgumentException.class, () ->
    		Args.finitePositiveRequired(Double.NEGATIVE_INFINITY, "color"));
    	String expectedMsg = "Param 'color' must be finite and positive.";
    	String actualMsg = exception.getMessage();
    	assertEquals(expectedMsg, actualMsg);
    }
    
    @Test
    public void testCheckArrayBounds() {
    	// checkArrayBounds
    	Exception exception = assertThrows(IllegalArgumentException.class, () ->
    		Args.checkArrayBounds(5, "color", 4));
    	String expectedMsg = "Requires 'color' in the range 0 to 3";
    	String actualMsg = exception.getMessage();
    	assertEquals(expectedMsg, actualMsg);
    }
}