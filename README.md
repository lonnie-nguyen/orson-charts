Orson Charts
============

(C)opyright 2013-2020, by Object Refinery Limited.  All rights reserved.

Version 2.0, not yet released.


Overview
--------
Orson Charts is a 3D chart library for the Java(tm) platform that can generate a wide variety of 3D charts for use in client-side applications (JavaFX and Swing) and server-side applications (with export to PDF, SVG, PNG and JPEG). 

![Orson Charts sample](http://www.object-refinery.com/orsoncharts/images/orsoncharts_fx.png)

Key features include:

- multiple chart types: pie charts, bar charts (regular and stacked), line charts, area charts, scatter charts and surface plots;
- mouse-enabled chart viewers in JavaFX and Swing provide 360 degree rotation and zooming for precise end-user view control;
- configurable tool tip support;
- interactive charts (mouse event support on all chart elements);
- flexible data sources; 
- JSON format data import and export;
- regular and logarithmic axis scales;
- auto-adaptive axis labeling;
- value and range marker annotations
- support for PDF, SVG, PNG and JPG export of charts for reporting;
- a clean and well-documented API with a high degree of chart configurability.

Orson Charts is very easy to use, and includes comprehensive Javadocs.  It is licensed under the terms of the GNU General Public License version 3 or later.  For companies that do not wish to be bound by the terms of the GPLv3, a commercial license can be purchased from Object Refinery Limited.  The license permits royalty-free redistribution of the Orson Charts runtime jar file.  Orson Charts requires JDK/JRE 11 or later.  To use Orson Charts with JavaFX requires the Orson Charts FX extension project.


Documentation
-------------
The Javadoc generated documentation is the principal source of documentation for Orson Charts:

http://www.object-refinery.com/orsoncharts/javadoc/index.html

If there are topics that are not covered or not clear in the documentation, please let us know so that we can improve the coverage.


Demos
-----
Demo applications can be found in the following projects at GitHub:

* [JFree-Demos](https://github.com/jfree/jfree-demos "JFree-Demos Project Page at GitHub")
* [JFree-FXDemos](https://github.com/jfree/jfree-fxdemos "JFree-FXDemos Project Page at GitHub")


Building
--------
You can build Orson Charts using Maven by issuing the following command from the root directory of the project:

    mvn clean install

The build requires JDK 11 or later.  


Reporting Bugs
--------------
If you find a bug in Orson Charts, please file a bug report at:

https://github.com/jfree/orson-charts/issues


More Info
---------
You can find out more about Orson Charts at:

http://www.object-refinery.com/orsoncharts/

If you have any questions, don't hesitate to send a mail to info@object-refinery.com.


History
-------

Version 2.0 : not yet released

- created a Java module (`org.jfree.chart3d`)


Version 1.7 : 17-Nov-2017

- removed JavaFX support to a separate project [Orson Charts FX](https://github.com/jfree/orson-charts-fx);
- fixed cell content bug in `GridElement`;
- fixed bug in `GradientColorScale`;
- protect from `NullPointerException` in `AbstractValueAxis3D`;
- streamline build by removing Ant build support and moving demo code to external projects.


Version 1.6 : 2-Nov-2016

- added `remove()` method to `XYZSeries` and added change notification mechanism;
- added `remove()` and `removeAll()` methods to `XYZSeriesCollection` and added change notification;
- added generics to source files;
- updated `FXGraphics2D` to version 1.5;
- updated `JFreeSVG` to version 3.2.


Version 1.5 : 28-Jan-2016

- added new `LineXYZRenderer`;
- added option to invert axes;
- fix exception when setting a new dataset using `CategoryPlot3D.setDataset()`:
- fix direction of mouse wheel zooming in JavaFX;
- included FXGraphics2D version 1.3 as a dependency;
- updated OrsonPDF to version 1.7;
- updated JFreeSVG to version 3.0;
- added `pom.xml` for Maven builds;
- JavaFX demos brought up to match the Swing demos;
- various Javadoc improvements.


Version 1.4 : 27-May-2014

- added JavaFX support;
- added support to marker elements and item labels for `KEY_BEGIN_ELEMENT` and `KEY_END_ELEMENT` rendering hints;
- added `JPEG` export option;
- added `minAutoRangeLength` attribute in `AbstractValueAxis3D` (this fixes a bug for plots where the length of the data range is zero, for example scatter plots with a single value);
- fixed endless loop in axis range code for datasets with infinite values;
- fixed bug in hinting for tick labels on `NumberAxis3D`;
- fixed `Utils.js` functions that didn't work with Internet Explorer 9.


Version 1.3 : 11-Apr-2014

- added chart mouse event and tooltip support for the chart viewer in Swing;
- added item label support;
- added `JSON` format data import and export;
- new utility methods to extract an `XYZDataset` from a `CategoryDataset3D`;
- fixed a clipping issue for panels with borders assigned;
- added rendering hints for SVG output via JFreeSVG (to support tool-tips 
and mouse events on chart elements);
- added JavaScript utility library to support JFreeSVG export;


Version 1.2 : 7-Mar-2014

- added value and range markers for numerical axes, and category markers for category axes;
- added a `tickLabelOrientation` attribute for axes so that tick labels can be drawn either perpendicular or parallel to the axis line;
- added a logarithmic axis;
- added theme support, with several built-in themes;
- added template driven label generators for pie section labels and category axis labels;
- added export to `JPEG`, plus options to configure the available export types;
- optimized the rendering code to reduce memory usage;
- put in place a localisation mechanism, and added German and Italian translations;
- made the projection distance configurable in the chart viewer;
- added series accessors for `XYZSeriesCollection`;
- added `yDimensionOverride` attribute for `CategoryPlot3D`;
- fixed an issue with the `StackedBarRenderer` and negative values;
- incorporated various other bug fixes.


Version 1.1 : 23-Dec-2013

- added surface plots (via the new `SurfaceRenderer` class and `Chart3DFactory.createSurfaceChart()`);
- added `ColorScale` and supporting classes for use by the surface charts;
- added orientation attribute to control the chart legend orientation;
- optimized rendering code for improved performance;
- added missing change events for gridline attributes in `CategoryPlot3D`;
- added constants including `SCALE_TO_FIT_TARGET` and `CENTER_NO_SCALING` to the `Fit2D` class;
- added `setColors(Color...)` to `AbstractCategoryRenderer3D` and `AbstractXYZRenderer3D`;


Version 1.0 : 17-Nov-2013

This is the first public release of Orson Charts, we welcome your feedback and suggestions.
