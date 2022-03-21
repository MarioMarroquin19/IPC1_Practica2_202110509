package com.mycompany.practica2;

/**
 *
 * @author marroquin
 */
public class datos {
    private String Cursos;
    private int Notas;
   
    
    public datos(String Cursos, int Notas){
        this.Cursos = Cursos;
        this.Notas = Notas;
    }
    
   public String getCursos() {
        return Cursos;
    }

    public void setCursos(String Cursos) {
        this.Cursos = Cursos;
    }

    public int getNotas() {
        return Notas;
    }

    public void setNotas(int Notas) {
        this.Notas = Notas;
    }

         
}
