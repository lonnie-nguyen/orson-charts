package org.jfree.chart3d.export;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.jfree.chart3d.Chart3D;
import org.jfree.chart3d.Chart3DFactory;
import org.jfree.chart3d.Orientation;
import org.jfree.chart3d.TitleAnchor;
import org.jfree.chart3d.data.StandardPieDataset3D;
import org.jfree.chart3d.legend.LegendAnchor;
import org.junit.jupiter.api.Test;

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
	public void testWriteAsPNG() throws FileNotFoundException, IOException {
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
        
        // Call method
		ExportUtils.writeAsPNG(chart, 600, 300, file);

        // Get a BufferedImage from actual and expected png image files
        BufferedImage piechart1png = ImageIO.read(new File("piechart1.PNG"));
        BufferedImage piechart2png = ImageIO.read(new File("piechart2.PNG"));
        
        // Get pixel data of BufferedImages as byte array
        byte[] actual = ((DataBufferByte) piechart1png.getData().getDataBuffer()).getData();
        byte[] expected = ((DataBufferByte) piechart2png.getData().getDataBuffer()).getData();
		
        assertNotNull(file);
        assertArrayEquals(expected, actual); // Compare byte arrays
	}

	@Test
	public void testWriteAsJPEG() throws FileNotFoundException, IOException {
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
		
        // Call method
        ExportUtils.writeAsJPEG(chart, 600, 300, file);

        // Get a BufferedImage from actual and expected jpeg image files
        BufferedImage piechart1jpg = ImageIO.read(new File("piechart1.JPEG"));
        BufferedImage piechart2jpg = ImageIO.read(new File("piechart2.JPEG"));
        
        // Get pixel data of BufferedImages as byte array
        byte[] actual = ((DataBufferByte) piechart1jpg.getData().getDataBuffer()).getData();
        byte[] expected = ((DataBufferByte) piechart2jpg.getData().getDataBuffer()).getData();
		
        assertNotNull(file);
        assertArrayEquals(expected, actual); // Compare byte arrays
	}

}
