/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package niveles;

/**
 *
 * @author sharys
 */
public enum Nivel {
  

    PRINCIPIANTE(8,4,4),
    INTERMEDIO(16,4,8),
    AVANZADO(32,8,8);

    private int parejas;
    private int filas;
    private int columnas;

    Nivel(int parejas, int filas, int columnas){
        this.parejas = parejas;
        this.filas = filas;
        this.columnas = columnas;
    }

    public int getParejas() {
        return parejas;
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

} 

