package com.mycompany.practica2;

/**
 *
 * @author marroquin
 */
public class Ordenamineto {

 public static int num;
 public static int [] arreglo = new int [100];
 public int numero;
    
    
public void Burbuja(String atributos,int [] array){
    int aux;
    boolean cambio = false;
    int pasos =0;
    while(true){
        cambio = false;
            for(int i=1; i<array.length; i++){
                if(array[i]<array[i-1]){
                    aux = array[i];
                    array[i] = array [i-1];
                    array[i-1] = aux;
                    cambio = true;
                    //retorno = aux;
                    //pasos++;
                    
                }
            }
            if(cambio == false)
                break;
    }
    int i=0;
    for(int j=0;j<array.length;j++){
        
        if(array[j]!= 0){
            arreglo [i] = array [j];
            //System.out.println(i);
            num = array[j];
            //System.out.println(arreglo[i]);   
            i++;
            //retornar(num);
        }
     
    }
    
}
    
/*public int retornar(int numero){
    
    return numero;
}*/

public int retorno(){
    for(int i=0; i<arreglo.length;i++){
        if(arreglo[i]!=0){
        numero = arreglo[i];
        }
    }
    return numero;
}
    
public void Imprimir(){
     for(int i=0; i<arreglo.length;i++){
         if(arreglo[i] != 0){
        System.out.println(arreglo[i]);
         }
    }
}
    
    
    
}
