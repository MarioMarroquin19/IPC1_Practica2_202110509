package com.mycompany.practica2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartUtils;

/**
 *
 * @author marroquin
 */
public class RecibirCsv {
 public static int num;
      public static String cursito;
      public static int I =0, pasos=0, a=0,b=1,m=0;
      public static int []notas1 = new int [100];
      public static String [] CURSOS = new String [100];
      public static int x=0;
       
   public static void recibir(String ruta){
            String path = ruta;
            String linea = "";
            String encabezado;
            String encabezado1;
            String []encabezado2;

            //int i=0;
            
        try {
            BufferedReader br = new BufferedReader (new FileReader (path));
            encabezado = br.readLine();
            encabezado1 = encabezado.replace(';',',');
            encabezado2 = encabezado1.split(",");
            while ((linea = br.readLine()) != null ){
                
         
                String linea1 = linea.replace(';', ',');
                String Linea = linea1.replaceAll(System.getProperty("line.separator"),"");
                String[] linea2 = Linea.split("[\r\n]");

                for(String linea3: linea2){
                String [] atributos = Linea.trim().split(",") ;
                int notas = Integer.parseInt(atributos[1]);
                String cursos = String.valueOf(atributos[0]);
                if(notas != 0){
                notas1[I] = notas;
                CURSOS[I] = cursos;
                datos nuevoDato = new datos (atributos [0], notas);
                AlmacenDatos.colocarDatos(nuevoDato);
                I++;
                x++;
                }

                Ejecutar ejecutar = new Ejecutar();
                ejecutar.curso(atributos[0]);
                ejecutar.not(notas1);
                 
                
                   }
                
                Ordenamineto orden = new Ordenamineto();
               
                }
            br.close();
            String encabe = encabezado2[0];
            String encabez = encabezado2[1];
            AlmacenDatos.tituloGrafia(encabe,encabez);
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RecibirCsv.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException e) {
           e.printStackTrace();
        }
        }
   
   public static int equis(){
       return x;
   }
    

public static void bur(){
    int aux;
    boolean cambio = false;
    String cur;
   
    while(true){
        cambio = false;
       
            for(int i=0; i<notas1.length-1; i++){
                for(int k=0; k<notas1.length-1;k++){
                if(notas1[k]>notas1[k+1]){
                    aux = notas1[k];
                    notas1[k] = notas1 [k+1];
                    notas1[k+1] = aux;
                    pasos++;
                    cambio = true;
                    } 
                }
     
            }
            if(cambio == false)
                break;
    
    }
    
    AlmacenDatos.borrar();
    for(int j=0;j<notas1.length;j++){

        if(notas1[j]!= 0){ 
            cursito = CURSOS[a];
            datos nuevoDato = new datos (cursito,notas1[j]);
            AlmacenDatos.colocarDatos(nuevoDato);
            a++;
        }
     
    }
    System.out.println(CURSOS[a]);
 }
       
       
 
public static void burDes(){
    int aux;
    boolean cambio = false;
    String cur;
   int contador = 0;
    while(true){
        cambio = false;
       
            for(int i=0; i<notas1.length-1; i++){
                 
                for(int k=0; k<notas1.length-1;k++){
               
                if(notas1[k]>notas1[k+1]){
                    aux = notas1[k];
                    notas1[k] = notas1 [k+1];
                    notas1[k+1] = aux;
                   cambio = true;

                    }    
 
                }
     
            }
            if(cambio == false)
                break;
    
    }
    
    AlmacenDatos.borrar();
    for(int j=(notas1.length-1);j>=0;j--){

        if(notas1[j]!= 0 ){ 
            cursito = CURSOS[a];  
            datos nuevoDato = new datos (cursito,notas1[j]);
            AlmacenDatos.colocarDatos(nuevoDato);
           a++;
        }
     
    }
    
 }



public static void seleccion(){
    
        for (int i = 0; i < notas1.length - 1; i++) {
            for (int j = i + 1; j < notas1.length; j++) {
                if (notas1[i] > notas1[j]) {
                    int temporal = notas1[i];
                    notas1[i] = notas1[j];
                    notas1[j] = temporal;
                    pasos++;
                }
            }
        }
    AlmacenDatos.borrar();
    for(int j=0;j<notas1.length;j++){

        if(notas1[j]!= 0 ){ 
            cursito = CURSOS[a];  
            datos nuevoDato = new datos (cursito,notas1[j]);
            AlmacenDatos.colocarDatos(nuevoDato);
            a++;
            
        }
     //System.out.println(notas1[j]);
    }
}
    
public static void seleccionDes(){
    
        for (int i = 0; i < notas1.length - 1; i++) {
            for (int j = i + 1; j < notas1.length; j++) {
                if (notas1[i] < notas1[j]) {
                    int temporal = notas1[j];
                    notas1[j] = notas1[i];
                    notas1[i] = temporal;
                    pasos++;
                }
            }
        }
    AlmacenDatos.borrar();
    for(int j=0;j<notas1.length;j++){

        if(notas1[j]!= 0 ){ 
            cursito = CURSOS[a];  
            datos nuevoDato = new datos (cursito,notas1[j]);
            AlmacenDatos.colocarDatos(nuevoDato);
            a++;
            
        }
    }
    
}   
  

public static void insercion(){                                            
    int p, j;
    int aux;
    for (p = 1; p < notas1.length; p++){ // desde el segundo elemento hasta
              aux = notas1[p];           // el final, guardamos el elemento y
              j = p - 1;            // empezamos a comprobar con el anterior
              while ((j >= 0) && (aux < notas1[j])){ // mientras queden posiciones y el                                
                                                // valor de aux sea menor que los
                             notas1[j + 1] = notas1[j];   // de la izquierda, se desplaza a
                             j--;               // la derecha
              }
              notas1[j + 1] = aux;       // colocamos aux en su sitio
    }
    
    
     AlmacenDatos.borrar();
    for(int h=0;h<notas1.length;h++){

        if(notas1[h]!= 0 ){ 
            cursito = CURSOS[a];  
            datos nuevoDato = new datos (cursito,notas1[h]);
            AlmacenDatos.colocarDatos(nuevoDato);
            a++;
            
        }
    }
}   
    

public static void insercionDes(){                                            
    int p, j;
    int aux;
    for (p = 1; p < notas1.length; p++){
              aux = notas1[p];           
              j = p - 1;           
              while ((j >= 0) && (aux < notas1[j])){                            
                                                
                             notas1[j + 1] = notas1[j];   
                             j--;               
              }
              notas1[j + 1] = aux;      
    }
    
    
     AlmacenDatos.borrar();
    for(int h=(notas1.length-1);h>=0;h--){

        if(notas1[h]!= 0 ){ 
            cursito = CURSOS[a];  
            datos nuevoDato = new datos (cursito,notas1[h]);
            AlmacenDatos.colocarDatos(nuevoDato);
            a++;
            
        }
    }
}




    

public static void SeleccionDes(){
    
}
       
       
public static int NoPasos(){
    return pasos;
}       
}
      