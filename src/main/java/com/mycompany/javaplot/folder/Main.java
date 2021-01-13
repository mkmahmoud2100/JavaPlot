/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.javaplot.folder;

import com.panayotis.gnuplot.JavaPlot;
import com.panayotis.gnuplot.dataset.Point;
import com.panayotis.gnuplot.dataset.PointDataSet;
import com.panayotis.gnuplot.layout.StripeLayout;
import com.panayotis.gnuplot.plot.AbstractPlot;
import com.panayotis.gnuplot.plot.DataSetPlot;
import com.panayotis.gnuplot.plot.Graph;
import com.panayotis.gnuplot.plot.Plot;
import com.panayotis.gnuplot.style.NamedPlotColor;
import com.panayotis.gnuplot.style.PlotStyle;
import com.panayotis.gnuplot.style.Style;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

/**
 *
 * @author Teknik
 */
public class Main {

    public static void main(String argv[]) throws IOException {

//        PlotStyle ps = new PlotStyle(Style.LINES);
        JavaPlot p = new JavaPlot();

//        p.setTitle("LEDs on Ceiling");
        PlotStyle stl = new PlotStyle();
        stl.setStyle(Style.LINES);
        stl.setLineType(NamedPlotColor.DARK_BLUE);
        stl.setPointType(5);
        stl.setPointSize(8);

        p.setTitle("LEDs Distribution", "Arial", 20);
        p.getAxis("x").setLabel("X", "Arial", 15);
        p.getAxis("Y").setLabel("Y", "Arial", 15);
        p.getAxis("x").setBoundaries(-2.5, 2.5);
        p.getAxis("y").setBoundaries(-2.5, 2.5);
        p.setKey(JavaPlot.Key.OFF);
        PointDataSet dataset = new PointDataSet();
        double rad = 1;
        int n = 4;
        double x;
        double y;

        double theta = 2 * Math.PI / n;
        for (int i = 1; i <= n; i++) {
            x = (cos(theta * i) * rad);
            y = (sin(theta * i) * rad);
            Point point = new Point(x, y);
            dataset.add(point);
        }
         p.addPlot("sqrt(1-(x*x))");
        p.addPlot("-sqrt(1-(x*x))");
        rad = 2;
        n = 8;
        theta = 2 * Math.PI / n;
        for (int i = 1; i <= n; i++) {
            x = (cos(theta * i) * rad);
            y = (sin(theta * i) * rad);
            Point point = new Point(x, y);
            dataset.add(point);
        }
         p.addPlot("sqrt(2*2-(x*x))");
        p.addPlot("-sqrt(2*2-(x*x))");
        rad = 2.45;
        n = 8;
        theta = 2 * Math.PI / n;
        for (int i = 1; i <= n; i += 2) {
            if ((i % 2) == 1) {
                x = (cos(theta * i) * rad);
                y = (sin(theta * i) * rad);
                Point point = new Point(x, y);
                dataset.add(point);
            }
        }
         p.addPlot("sqrt(2.45*2.45-(x*x))");
        p.addPlot("-sqrt(2.45*2.45-(x*x))");
        StripeLayout l = new StripeLayout();
        l.setColumns(300);
        p.getPage().setLayout(l);
        p.addPlot(dataset);

      
       
        p.plot();

    }
}
