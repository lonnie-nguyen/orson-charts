package org.jfree.chart3d.export;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ExportFormatsTest {
	
	@Test
	public void testConstructor() {
		ExportFormats ef = new ExportFormats();
	}

	@Test
	public void testIsJFreeSVGAvailable() {
		// Not in classpath expect False
		assertFalse(ExportFormats.isJFreeSVGAvailable());
	}

	@Test
	public void testIsJFreePDFAvailable() {
		// Not in classpath expect False
		assertFalse(ExportFormats.isJFreePDFAvailable());
	}

}
