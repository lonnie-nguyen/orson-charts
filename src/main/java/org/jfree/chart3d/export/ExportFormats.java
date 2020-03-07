/* ===========================================================
 * Orson Charts : a 3D chart library for the Java(tm) platform
 * ===========================================================
 * 
 * (C)opyright 2013-2020, by Object Refinery Limited.  All rights reserved.
 * 
 * http://www.object-refinery.com/orsoncharts/index.html
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * [Oracle and Java are registered trademarks of Oracle and/or its affiliates. 
 * Other names may be trademarks of their respective owners.]
 * 
 * If you do not wish to be bound by the terms of the GPL, an alternative
 * commercial license can be purchased.  For details, please see visit the
 * Orson Charts home page:
 * 
 * http://www.object-refinery.com/orsoncharts/index.html
 * 
 */

package org.jfree.chart3d.export;

/**
 * Utility methods related to export formats.
 * 
 * @since 1.2
 */
public class ExportFormats {

    /**
     * Returns {@code true} if JFreeSVG is on the classpath, and 
     * {@code false} otherwise.  The JFreeSVG library can be found at
     * http://www.jfree.org/jfreesvg/
     * 
     * @return A boolean.
     * 
     * @since 1.2
     */
    public static boolean isJFreeSVGAvailable() {
        Class<?> svgClass = null;
        try {
            svgClass = Class.forName("org.jfree.svg.SVGGraphics2D");
        } catch (ClassNotFoundException e) {
            // svgClass will be null so the function will return false
        }
        return (svgClass != null);
    }

    /**
     * Returns {@code true} if {@code JFreePDF} is on the classpath, and 
     * {@code false} otherwise.  The JFreePDF library can be found at
     * https://github.com/jfree/jfreepdf
     * 
     * @return A boolean.
     */
    public static boolean isJFreePDFAvailable() {
        Class<?> pdfDocumentClass = null;
        try {
            pdfDocumentClass = Class.forName("org.jfree.pdf.PDFDocument");
        } catch (ClassNotFoundException e) {
            // pdfDocument class will be null so the function will return false
        }
        return (pdfDocumentClass != null);
    }
    
}
