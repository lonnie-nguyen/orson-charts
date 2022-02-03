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
    public void testEquals() {
        // test null
        assertThrows(IllegalArgumentException.class, () -> {
            Args.nullNotPermitted(null, "color");
        });

        // test negative
        assertThrows(IllegalArgumentException.class, () -> {
            Args.negativeNotPermitted(-5.0, "color");
        });

        // test positive required
        assertThrows(IllegalArgumentException.class, () -> {
            Args.positiveRequired(-5.0, "color");
        });
    }
}



		// finiteRequired

		// finitePositiveRequired

		// checkArrayBounds
		//IllegalArgumentException