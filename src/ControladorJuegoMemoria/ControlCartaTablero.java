/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControladorJuegoMemoria;

import cartas.Carta;
import tableros.Tablero;

/**
 *
 * @author sharys
 */
public class ControlCartaTablero {
    public class controladorCartaTablero {
    public class TableroControl {

    private Tablero tablero;

    public TableroControl(Tablero tablero) {
        this.tablero = tablero;
    }

    public Carta obtenerCarta(int fila, int columna) {
        return tablero.obtenerCarta(fila, columna);
    }

    public void mostrarCarta(int fila, int columna) {

        Carta carta = tablero.obtenerCarta(fila, columna);

        if (carta != null) {
            carta.mostrar();
        }
    }

    public void ocultarCarta(int fila, int columna) {

        Carta carta = tablero.obtenerCarta(fila, columna);

        if (carta != null) {
            carta.ocultar();
        }
    }

    public boolean compararCartas(
            int fila1,
            int columna1,
            int fila2,
            int columna2) {

        return tablero.compararCartas(
                fila1,
                columna1,
                fila2,
                columna2
        );
    }

    public void marcarPareja(
            int fila1,
            int columna1,
            int fila2,
            int columna2) {

        Carta primeraCarta =
                tablero.obtenerCarta(fila1, columna1);

        Carta segundaCarta =
                tablero.obtenerCarta(fila2, columna2);

        if (primeraCarta != null && segundaCarta != null) {

            primeraCarta.marcarEncontrada();
            segundaCarta.marcarEncontrada();
        }
    }

    public String obtenerImagen(int fila, int columna) {

        Carta carta = tablero.obtenerCarta(fila, columna);

        if (carta == null) {
            return null;
        }

        return carta.getImagen();
    }

    public boolean cartaVisible(int fila, int columna) {

        Carta carta = tablero.obtenerCarta(fila, columna);

        if (carta == null) {
            return false;
        }

        return carta.isVisible();
    }

    public boolean cartaEncontrada(int fila, int columna) {

        Carta carta = tablero.obtenerCarta(fila, columna);

        if (carta == null) {
            return false;
        }

        return carta.isEncontrada();
    }

    public boolean juegoFinalizado() {
        return tablero.juegoFinalizado();
    }

    public void reiniciar() {
        tablero.reiniciarTablero();
    }

    public int obtenerFilas() {
        return tablero.getFilas();
    }

    public int obtenerColumnas() {
        return tablero.getColumnas();
    }
}
}
}
