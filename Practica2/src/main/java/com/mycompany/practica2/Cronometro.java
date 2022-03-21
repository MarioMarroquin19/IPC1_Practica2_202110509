
package com.mycompany.practica2;


public class Cronometro {
    
    public static int mili =0;
    public static int seg = 0;
    public static int min =0;
    public static int hora = 0;
    public static String TIEMPO;
    
    public static boolean estado1 = true;
    
    
    
    public static boolean parar(){
        estado1 = false;
        return estado1;
    }
    
    
    public static void tiempo1(boolean estado){
       
    Thread cronometro = new Thread(){
          public void run(){
              for (;;){
                  if(estado == true){
                     try{
                         sleep(1);
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
                         String hora1 = String.valueOf(hora);
                         String min1 = String.valueOf(min);
                         String seg1 = String.valueOf(seg);
                         crono(hora1 + ":"+min1+ ":"+seg1);
                         mili++;
                         //Ejecutar.Tiempo.setText(cronome());
                         //Ejecutar.ponerTiempo();
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
    


        
    
    public static void crono(String tiempo){
        TIEMPO = tiempo;
    }
    
    
    public static String cronome(){
        return TIEMPO;
    }
    
}
