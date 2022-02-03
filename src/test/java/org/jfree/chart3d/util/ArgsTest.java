import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.jfree.chart3d.internal.Args;
import org.jfree.chart3d.TestUtils;


/**
 * Some tests for the {@link Args} class.
 */
public class RangeTest {

    @Test
    public void testEquals() {
        
		// NEW TESTS ADDED BY MSWE GROUP 
		
		// test null
		assertThrows(IllegalArgumentException.class, () -> {Args.nullNotPermitted(null, "color");});
		
		// test negative
		assertThrows(IllegalArgumentException.class, () -> {Args.negativeNotPermitted(-5.0, "color");});
		
		// test positive required
		assertThrows(IllegalArgumentException.class, () -> {Args.positiveRequired(-5.0, "color");});
		       Range range1 = new Range(0, 10);
        Range range2 = new Range(0, 10);
        assertEquals(range1, range2);
		
		
		
		// finiteRequired
		
		// finitePositiveRequired
		
		// checkArrayBounds
		//IllegalArgumentException