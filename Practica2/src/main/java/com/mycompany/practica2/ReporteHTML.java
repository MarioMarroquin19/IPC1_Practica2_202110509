package com.mycompany.practica2;

import static com.mycompany.practica2.AlmacenDatos.getAlmacenDatos;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class ReporteHTML {
    
    public static int numero1;
    public static String cursos;
    public static String tiempo;
    public static String pasos;
    
    public static void tiempo(String tiempo1){
        tiempo = tiempo1; 
        //System.out.println(tiempo);
    }
    
    public static void pasos(String pasos1){
        pasos = pasos1;
        
    }

    
    public void prueba1(){
        MiInicio inicio = new MiInicio();
        Ejecutar ejecutar = new Ejecutar();
         try {
            String ruta = "C:\\Users\\mario\\Documents\\NetBeansProjects\\Practica2\\ejemplo.html";
            String contenido = "<!DOCTYPE html>\n"+
                               "<html lang=\"en\">\n"+
                                "<head>\n"+
                                "<meta charset=\"UTF-8\">\n"+
                                "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"+
                                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"+
                                "<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\n"+
                                "<title>Reporte</title>\n"+
                                "</head>\n";
            
            String contenido2=   "<body>\n"+
                                " <div class=\"container\">\n"+
                                "<div class=\"datos\">\n"+
                                "<h1>Mario Ernesto Marroquin Perez</h1>\n"+
                                "<h2>202110509</h2>\n"+
                                "</div>\n";
            
            String detalles_orden="<div class=\"detalle_ordenamiento\">\n"+
                                   "<h2 class=\"titulo\">DETALLE DE ORDENAMIENTO</h2>\n"+
                                   "<h3>Algoritmo: <p>"+inicio.sendAlgoritmo()+"</p></p></h3>\n"+
                                   "<h3>Tipo: <p>"+inicio.sendTipo()+"</p></p></h3>\n"+
                                   "<h3>Velocidad: <p>"+inicio.sendVelocidad()+"</p></p></h3>\n"+
                                   "</div>\n";
            
            String detalles_ejecucion="<div class=\"detalle_ejecucion\">\n"+
                                      "<h2 class=\"titulo\">DETALLE DE EJECUCION</h2>\n"+
                                      "<h3 class=\"titulo2\">Tiempo: <p>"+tiempo+"</p></p></h3>\n"+
                                      "<h3 class=\"titulo2\">Pasos: <p>"+pasos+"</p></p></h3>\n"+
                                      "</div>\n";
            String estado_inicial="<div class=\"estado_inicial\">\n"+
                                  "<table border=\"1\">\n"+
                                  "<caption>ESTADO INICIAL</caption>\n"+
                                  "<tbody>\n"+
                                  "<tr>\n"+
                                  "<th class=\"color\">Curso</th>\n"+
                                    inicio.CursosEstadoInicial()+
                                  "</tr>\n"+
                                  "<tr>\n"+
                                  "<td class=\"color\">Nota</td>\n"+
                                   inicio.NotasEstadoInicial()+
                                   "</tr>\n"+
                                   "</tbody>\n"+
                                   "</table>\n"+
                                   "<img class =imagen src=\"grafica1.png\""+
                                   "alt="+"Gráfica de estado inicial>\n"+
                                   "</div>";
            
            
            String estado_final="<div class=\"estado_final\">\n"+
                    "<table border=\"1\">\n"+
                    "<caption>ESTADO FINAL</caption>\n"+
                    "<tbody>\n"+
                    "<tr>\n"+
                    "<th class=\"color_2\">Curso</th>\n"+
                    ejecutar.CursosEstadoFinal()+
                    "</tr>\n"+
                    "<tr>\n"+
                    "<td class=\"color_2\">Nota</td>\n"+
                    ejecutar.NotasEstadoFinal()+
                    "</tr>\n"+
                    "</tbody>\n"+
                    "</table>\n"+
                    "<img class =imagen src=\"grafica2.png\""+
                    "</div>\n"+
                    "<div class=\"footer\">\n"+
                    "<p>Reporte Mario Marroquin</p>\n"+
                    "</div>\n"+
                    "</div>\n"+
                    "</body>\n"+
                    "</html>\n";
            
            
            
            
            
            
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.write(contenido2);
            bw.write(detalles_orden);
            bw.write(detalles_ejecucion);
            bw.write(estado_inicial);
            bw.write(estado_final);
            bw.close();
            

            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }       
    }
    
   
    
    public static void abrir(){
         String osName = System.getProperty("os.name");
         String url = "C:\\Users\\mario\\Documents\\NetBeansProjects\\Practica2\\ejemplo.html";
    
        try{
        if (osName.startsWith("Windows")) {
        Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+url);    
        //Runtime obj = Runtime.getRuntime();
            //obj.exec("notepad");
        }
        }catch (Exception e) {
            e.printStackTrace();
        }       
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
