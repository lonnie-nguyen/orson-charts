package org.jfree.chart3d.export;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

import org.jfree.chart3d.Chart3D;
import org.jfree.chart3d.Chart3DFactory;
import org.jfree.chart3d.Orientation;
import org.jfree.chart3d.TitleAnchor;
import org.jfree.chart3d.data.StandardPieDataset3D;
import org.jfree.chart3d.legend.LegendAnchor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

public class ExportUtilsTest {
	
	@Test
	public void testExportUtilsClass() {
		ExportUtils eu = new ExportUtils();
	}
	
	@Test
	public void testWriteAsSVGClasspathDependency() {
		// Create Pie Chart
		StandardPieDataset3D<String> dataset = new StandardPieDataset3D<>();
        dataset.add("Milk Products", 11625);
        dataset.add("Meat", 5114);
        dataset.add("Wood/Logs", 3060);
        dataset.add("Crude Oil", 2023);
        dataset.add("Machinery", 1865);
        dataset.add("Fruit", 1587);
        dataset.add("Fish", 1367);
        dataset.add("Wine", 1177);
        dataset.add("Other", 18870);
        
        Chart3D chart = Chart3DFactory.createPieChart(
                "New Zealand Exports 2012", 
                "http://www.stats.govt.nz/browse_for_stats/snapshots-of-nz/nz-in-profile-2013.aspx", 
                dataset);
        chart.setTitleAnchor(TitleAnchor.TOP_LEFT);
        chart.setLegendPosition(LegendAnchor.BOTTOM_CENTER,
                Orientation.HORIZONTAL);
        
        // Create PDF file
        File file = new File("piechart1." + ExportFormat.SVG);
        
        // Call method
        assertThrows(IllegalStateException.class, () -> ExportUtils.writeAsSVG(chart, 600, 300, file));
	}
	
	@Test
	public void testWriteAsPDFClasspathDependency() {
		// Create Pie Chart
		StandardPieDataset3D<String> dataset = new StandardPieDataset3D<>();
        dataset.add("Milk Products", 11625);
        dataset.add("Meat", 5114);
        dataset.add("Wood/Logs", 3060);
        dataset.add("Crude Oil", 2023);
        dataset.add("Machinery", 1865);
        dataset.add("Fruit", 1587);
        dataset.add("Fish", 1367);
        dataset.add("Wine", 1177);
        dataset.add("Other", 18870);
        
        Chart3D chart = Chart3DFactory.createPieChart(
                "New Zealand Exports 2012", 
                "http://www.stats.govt.nz/browse_for_stats/snapshots-of-nz/nz-in-profile-2013.aspx", 
                dataset);
        chart.setTitleAnchor(TitleAnchor.TOP_LEFT);
        chart.setLegendPosition(LegendAnchor.BOTTOM_CENTER,
                Orientation.HORIZONTAL);
        
        // Create PDF file
        File file = new File("piechart1." + ExportFormat.PDF);
        
        // Call method
        assertThrows(IllegalStateException.class, () -> ExportUtils.writeAsPDF(chart, 600, 300, file));
	}

	@Test
    @EnabledOnOs({OS.WINDOWS})
	public void testWriteAsPNG() throws IOException {
		// Create Pie Chart
		StandardPieDataset3D<String> dataset = new StandardPieDataset3D<>();
        dataset.add("Milk Products", 11625);
        dataset.add("Meat", 5114);
        dataset.add("Wood/Logs", 3060);
        dataset.add("Crude Oil", 2023);
        dataset.add("Machinery", 1865);
        dataset.add("Fruit", 1587);
        dataset.add("Fish", 1367);
        dataset.add("Wine", 1177);
        dataset.add("Other", 18870);
        
        Chart3D chart = Chart3DFactory.createPieChart(
                "New Zealand Exports 2012", 
                "http://www.stats.govt.nz/browse_for_stats/snapshots-of-nz/nz-in-profile-2013.aspx", 
                dataset);
        chart.setTitleAnchor(TitleAnchor.TOP_LEFT);
        chart.setLegendPosition(LegendAnchor.BOTTOM_CENTER,
                Orientation.HORIZONTAL);
        
        // Create PNG file
        File file = new File("piechart1." + ExportFormat.PNG);
        File file2 = new File("piechart2." + ExportFormat.PNG);
        
        // Call method
		ExportUtils.writeAsPNG(chart, 600, 300, file);

        // Get a BufferedImage from actual and expected png image files and compare their RGB arrays
        BufferedImage piechart1png = ImageIO.read(new File("piechart1.PNG"));
        BufferedImage piechart2png = ImageIO.read(new File("piechart2.PNG"));

        int w1 = piechart1png.getWidth();
        int h1 = piechart1png.getHeight();
        int[] RGBarray1 = new int[w1 * h1];
        piechart1png.getRGB(0,0,w1,h1,RGBarray1,0,w1);

        int w2 = piechart2png.getWidth();
        int h2 = piechart2png.getHeight();
        int[] RGBarray2 = new int[w2 * h2];
        piechart2png.getRGB(0,0,w2,h2,RGBarray2,0,w2);

        assertArrayEquals(RGBarray1,RGBarray2);

        assertNotNull(file);

	}

	@Test
    @EnabledOnOs({OS.WINDOWS})
	public void testWriteAsJPEG() throws IOException {
		// Create Pie Chart
		StandardPieDataset3D<String> dataset = new StandardPieDataset3D<>();
        dataset.add("Milk Products", 11625);
        dataset.add("Meat", 5114);
        dataset.add("Wood/Logs", 3060);
        dataset.add("Crude Oil", 2023);
        dataset.add("Machinery", 1865);
        dataset.add("Fruit", 1587);
        dataset.add("Fish", 1367);
        dataset.add("Wine", 1177);
        dataset.add("Other", 18870);
        
        Chart3D chart = Chart3DFactory.createPieChart(
                "New Zealand Exports 2012", 
                "http://www.stats.govt.nz/browse_for_stats/snapshots-of-nz/nz-in-profile-2013.aspx", 
                dataset);
        chart.setTitleAnchor(TitleAnchor.TOP_LEFT);
        chart.setLegendPosition(LegendAnchor.BOTTOM_CENTER,
                Orientation.HORIZONTAL);
        
        // Create JPEG file
        File file = new File("piechart1." + ExportFormat.JPEG);
        File file2 = new File("piechart2." + ExportFormat.JPEG);
		
        // Call method
        ExportUtils.writeAsJPEG(chart, 600, 300, file);

        // Get a BufferedImage from actual and expected jpeg image files and compare their RGB arrays
        BufferedImage piechart1jpg = ImageIO.read(new File("piechart1.JPEG"));
        BufferedImage piechart2jpg = ImageIO.read(new File("piechart2.JPEG"));

        int w1 = piechart1jpg.getWidth();
        int h1 = piechart1jpg.getHeight();
        int[] RGBarray1 = piechart1jpg.getRGB(0,0,w1,h1,null,0,w1);

        int w2 = piechart2jpg.getWidth();
        int h2 = piechart2jpg.getHeight();
        int[] RGBarray2 = piechart2jpg.getRGB(0,0,w2,h2,null,0,w2);

        assertArrayEquals(RGBarray1,RGBarray2);

        assertNotNull(file);

	}
}
