package com.mycompany.practica2;

import java.awt.Dimension;
//import java.util.HashSet;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author mario
 */
public class GraficaBarras {

    public static int n1 = 40;
    public static String nombreGraf = "";
    

    public static void TituloGrafica(String nombre1) {
        nombreGraf = nombre1;
        
    }
    
    public static String tilGraf(){
        return nombreGraf;
    }

    public GraficaBarras() {
        //int notas = Integer.parseInt(s);
        /*DefaultCategoryDataset datos = new DefaultCategoryDataset();

        datos.setValue(n1, "Curso", "nota");

        //JFreeChart grafico_barras = ChartFactory.createBarChart("hola","nombreX","nombreY", datos);
        JFreeChart grafico_Barras = ChartFactory.createBarChart(nombreGraf, "x", "y", datos, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel panel = new ChartPanel(grafico_Barras);
        panel.setMouseWheelEnabled(true);
        panel.setPreferredSize(new Dimension(499,227));
        */
        
        
    }
    
    public static void panel(){
        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        datos.setValue(n1, "Curso", "nota");
       
        JFreeChart grafico_Barras = ChartFactory.createBarChart(nombreGraf, "x", "y", datos, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel panel = new ChartPanel(grafico_Barras);
        panel.setMouseWheelEnabled(true);
        panel.setPreferredSize(new Dimension(499,227));
  
    }

}