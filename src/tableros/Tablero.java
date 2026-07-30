/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableros;
import cartas.Carta;
import java.util.ArrayList;
import niveles.Nivel;
/**
 *
 * @author marii
 */
public class Tablero {
    private Carta[][] cartas;
    private int filas;
    private int columnas;
    private String[] imagenes;
    
    public Carta[][] getCartas() {
        return cartas;
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }
    
    public Tablero(int filas, int columnas, String[] imagenes) {
        this.filas = filas;
        this.columnas = columnas;
        this.imagenes = imagenes;
        this.cartas = new Carta[filas][columnas];

        inicializarTablero();
        }
        
    public void inicializarTablero() {

        int cantidadCartas = filas * columnas;
        int cantidadParejas = cantidadCartas / 2;

        if (cantidadCartas % 2 != 0) {
            throw new IllegalArgumentException("La cantidad de cartas debe ser par");
        }

        if (imagenes.length < cantidadParejas) {
            throw new IllegalArgumentException("No hay suficientes imágenes para crear las parejas");
        }

        ArrayList<Carta> listaCartas = new ArrayList<>();

        for (int i = 0; i < cantidadParejas; i++) {

            listaCartas.add(new Carta(imagenes[i]));
            listaCartas.add(new Carta(imagenes[i]));
        }

        int posicion = 0;

        for (int fila = 0; fila < filas; fila++) {

            for (int columna = 0; columna < columnas; columna++) {

                cartas[fila][columna] = listaCartas.get(posicion);
                posicion++;
            }
        }
    }

   public Carta obtenerCarta(int fila, int columna) {

        if (fila < 0 || fila >= filas
                || columna < 0 || columna >= columnas) {
            return null;
        }
        return cartas[fila][columna];
    }
   public boolean compararCartas(
            int fila1,
            int columna1,
            int fila2,
            int columna2) {

        Carta primeraCarta = obtenerCarta(fila1, columna1);
        Carta segundaCarta = obtenerCarta(fila2, columna2);

        if (primeraCarta == null || segundaCarta == null) {
            return false;
        }
        return primeraCarta.esIgual(segundaCarta);
    }
   
   public boolean juegoFinalizado() {

        for (int fila = 0; fila < filas; fila++) {

            for (int columna = 0; columna < columnas; columna++) {

                if (!cartas[fila][columna].isEncontrada()) {
                    return false;
                }
            }
        }
        
    return true;
    }
   
  public void reiniciarTablero() {
        cartas = new Carta[filas][columnas];
        inicializarTablero();
    }
  
  public Tablero(Nivel nivel, String[] imagenes) {
      this.imagenes = imagenes;

    switch (nivel) {

        case PRINCIPIANTE:
            filas = 4;
            columnas = 4;
            break;

        case INTERMEDIO:
            filas = 4;
            columnas = 8;
            break;

        case AVANZADO:
            filas = 8;
            columnas = 8;
            break;
    }

    cartas = new Carta[filas][columnas];

   inicializarTablero();  
}
 }
