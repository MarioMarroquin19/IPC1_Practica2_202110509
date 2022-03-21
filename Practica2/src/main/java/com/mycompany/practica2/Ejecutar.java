package com.mycompany.practica2;

import static com.mycompany.practica2.AlmacenDatos.getAlmacenDatos;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author mario
 */
public class Ejecutar extends javax.swing.JFrame {
    public static int num;
    public static int [] arreglo = new int [100];
    public static int mili =0;
    public static int seg = 0;
    public static int min =0;
    public static int hora = 0;
    public static String TIEMPO;
    public static String curso;
    public static int [] notas;
    public static int paso=0;
    private JFreeChart barras;
    public String pass="";
    public String numerito;
    public static String notas1="";
    public static String cursos1="";
    public static int u=0;
    
    public static boolean estado = true;

    /**
     * Creates new form Ejecutar
     */
    public Ejecutar() {
        initComponents();
    }
    
    
    public void ponerTiempo(){
        Tiempo.setText(Cronometro.cronome());
    }
    
    
        public static boolean parar(){
        estado = false;
        return estado;
    }

    
    
   public void tiempo1(){
       
    Thread cronometro = new Thread(){
          public void run(){
              for (;;){
                  if(estado == true){
                     try{
                          Thread.sleep(1);
                         if(mili>=1000){
                             mili = 0;
                             seg++;
                         }
                         if(seg >= 60){
                             mili=0;
                             seg=0;
                             min++;
                         }
                         if(min>=60){
                             mili=0;
                             seg=0;
                             min=0;
                             hora++;
                         }
                         mili+=6;
                         Tiempo.setText(hora+ ":"+min+ ":"+seg+":"+mili);
                         String hor= String.valueOf(hora);
                         String minu = String.valueOf(min);
                         String segu = String.valueOf(seg);
                         String milis = String.valueOf(mili);
                         String tiem= (hor+ ":"+minu+ ":"+segu+":"+milis);
                         //System.out.println(tiem);
                         ReporteHTML reporte = new ReporteHTML();
                         ReporteHTML.tiempo(tiem);
                         

                     } catch(Exception e){
                      
                  }
                  }else{
                      break;
                  }
              }
          }  
          
        };
    
        cronometro.start();
      
        
    }
    
   

public void caracteristicas(){
    MiInicio inicio = new MiInicio();
    labelAlgoritmo.setText(inicio.sendAlgoritmo());
    labelTipo.setText(inicio.sendTipo());
    labelVelocidad.setText(inicio.sendVelocidad());
}
    
    
 public static String curso(String atributos){
     curso = atributos;
     return curso; 
 }
 
 
  public static int [] not(int [] array){
    notas = array;   
    return notas;
 }
    

public void Burbuja(){
      
    Thread burbuja = new Thread(){
    public void run(){
    int aux;
    boolean cambio = false;
    int pasos =0;
        try {
        Thread.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(Ejecutar.class.getName()).log(Level.SEVERE, null, ex);
        }

            }
       };
    burbuja.start();
}
    

    
public void burbuja(){
    Thread bur = new Thread(){
    public void run(){
    int aux;
    boolean cambio = false;
    int pasos =0;
    DefaultCategoryDataset datos = new DefaultCategoryDataset();
    try {
        
        for (datos dato : getAlmacenDatos()) {
            if (dato != null) {
                int numero1 = dato.getNotas();
                String curs = dato.getCursos();
                String numero2 =String.valueOf(numero1);
                
                datos.setValue(numero1, curs, "Oden"+" "+MiInicio.tip);
                

                System.out.println(u+"  "+RecibirCsv.equis());
                
                if( u==0 || u>=RecibirCsv.equis()){
                    
                notas1+="<th>"+numero2+"</th>";
                cursos1+="<th>"+dato.getCursos()+"</th>";
                
                }
                u++;
                
                
                barras = ChartFactory.createBarChart(GraficaBarras.tilGraf(), AlmacenDatos.encabezado1, AlmacenDatos.encabezado2, datos, PlotOrientation.VERTICAL, true, true, false);
                    ChartPanel panel = new ChartPanel(barras);
                    panel.setMouseWheelEnabled(true);
                    panel.setPreferredSize(new Dimension(546, 237));
                    panelGrafica.setLayout(new BorderLayout());
                    panelGrafica.add(panel, BorderLayout.NORTH);
                    pack();
                    repaint();
                    MiInicio inicio = new MiInicio();
                     if (inicio.sendVelocidad().equals("Rápida")){
                         Thread.sleep(100);
                     }
                     
                    if (inicio.sendVelocidad().equals("Media")){
                         Thread.sleep(500);
                     }
                     
                    if (inicio.sendVelocidad().equals("Baja")){
                         Thread.sleep(800);
                     }
                    
                    paso++;
                    pass = String.valueOf(paso);
                    labelPasos.setText(pass);
                    retPasos(pass);    
                   
                    
            }
        }

        estado=false;
           ReporteHTML reporte = new ReporteHTML();
           ReporteHTML.pasos(pass);
           reporte.prueba1();
           generarImg();
           ReporteHTML.abrir();
            
            
            
            } catch (InterruptedException ex) {
            Logger.getLogger(Ejecutar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    };
    bur.start();  

}
     public String CursosEstadoFinal(){
     return cursos1;
 }
        
 
  public String NotasEstadoFinal(){
     return notas1;
    }
   

public String retTiempo(){
    return hora+ ":"+min+ ":"+seg+":"+mili;
}

public String retPasos(String num){
    numerito = num;
    return numerito;
}

public String RetPasos(){
    return numerito;
}
  
public void generarImg(){
    try{
        final File file = new File("grafica2.png");
        ChartUtils.saveChartAsPNG(file, barras, 800,  400);
        //this.dispose();
        
    }catch(IOException e){
        System.out.println("Erro en la img");
    } 
}  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        Tiempo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        labelPasos = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        labelAlgoritmo = new javax.swing.JLabel();
        labelTipo = new javax.swing.JLabel();
        labelVelocidad = new javax.swing.JLabel();
        panelGrafica = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));

        jLabel3.setText("Tiempo:");

        Tiempo.setText("00 : 00 : 00 : 0000");

        jLabel1.setText("Pasos:");

        labelPasos.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Tiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelPasos)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Tiempo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labelPasos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setText("Ejecutación");

        jLabel5.setText("Características del ordenamiento");

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255)));

        jLabel6.setText("Algoritmo:");

        jLabel7.setText("Tipo:");

        jLabel8.setText("Velocidad:");

        labelAlgoritmo.setText("a");

        labelTipo.setText("b");

        labelVelocidad.setText("c");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelAlgoritmo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelVelocidad, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(labelAlgoritmo)
                    .addComponent(labelTipo)
                    .addComponent(labelVelocidad))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelGrafica.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255)));

        javax.swing.GroupLayout panelGraficaLayout = new javax.swing.GroupLayout(panelGrafica);
        panelGrafica.setLayout(panelGraficaLayout);
        panelGraficaLayout.setHorizontalGroup(
            panelGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelGraficaLayout.setVerticalGroup(
            panelGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 324, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelGrafica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(panelGrafica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Tiempo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelAlgoritmo;
    private javax.swing.JLabel labelPasos;
    private javax.swing.JLabel labelTipo;
    private javax.swing.JLabel labelVelocidad;
    private javax.swing.JPanel panelGrafica;
    // End of variables declaration//GEN-END:variables


    





}
