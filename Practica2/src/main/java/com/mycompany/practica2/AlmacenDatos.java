
package com.mycompany.practica2;

/**
 *
 * @author marroquin
 */
public class AlmacenDatos {
  private static datos[] almacenDatos = new datos[100]; //Arreglo de objetos tipo Comic
  private static datos [] almacenNotas = new datos[100];
  private static int [] notass = new int [100];
  private static int cantidadDatos = 0;
  static String imprimir;
  static String encabezado1;
  static String encabezado2;
    
  
  
    public static void colocarDatos(datos nuevoDatos) { 
    for(int i = 0; i < almacenDatos.length; i++) {
        if(almacenDatos[i] == null) {
          almacenDatos[i] = nuevoDatos;
          cantidadDatos++; //Incrementar la cantidad de comics con cada Comic agregado
          
          return;
        }
    }
  }
    
    public static void colocarNota(datos nuevoDatos1){
        for(int i = 0; i < almacenNotas.length; i++) {
        if(almacenNotas[i] == null) {
          almacenNotas[i] = nuevoDatos1;
          //notass[i] = almacenNotas[i];
          cantidadDatos++; //Incrementar la cantidad de comics con cada Comic agregado
          
          return;
        }
    }
    }
    
    
    
   public static void tituloGrafia(String encabe,String encabez){
       encabezado1 = encabe;
       encabezado2 = encabez;
      
   }
  
       public static datos[] getAlmacenDatos() {
        return almacenDatos;
    }
       

       public String toString (){
           return this.toString();
       }
  
    public String titulo1(){
        return encabezado1;
    }
    
    public String titulo2(){
        return encabezado2;
    }
    
    
    public static void OrdenarBurbuja(){
        int aux;
        boolean cambios = false;
        while(true){
            cambios = false;
            for(int i=1; i<almacenNotas.length;i++){
                //aux = Integer.parseInt(almacenNotas[i]);
                //if(almacenNotas[i]<almacenNotas[i-1]){
                almacenNotas[i] = almacenNotas[i+1];
                almacenNotas[i-1] = almacenNotas[i];
                cambios = true;
                    }
                //}
            if(cambios == false){
            break;
            }
        }

    }
    
    
  public static void borrar(){
    for(int i = 0; i < almacenDatos.length; i++) {
        if(almacenDatos[i] != null) {
          almacenDatos[i] = null;
          return;
                }
            }
        }
}
