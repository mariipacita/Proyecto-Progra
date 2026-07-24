/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegos;

import Cronometro.cronometro;
import jugadores.Jugador;
import niveles.Nivel;
import tableros.Tablero;

/**
 *
 * @author sharys
 */
public class Juego {
    private Tablero tablero;
    private Jugador jugador;
    private cronometro Cronometro;
    private Nivel nivel;
    
    
    public Juego(Jugador jugador, Nivel nivel){
        this.jugador = jugador;
        this.nivel = nivel;
        this.tablero = new Tablero(nivel);
        this.Cronometro = new cronometro();
    }
    
    public void iniciarPartida() {

}

public void seleccionarCarta(int fila, int columna) {

}

public void verificarPareja() {

}

public void actualizarJugador() {

}

public void finalizarJuego() {

}

public void reiniciarPartida() {

}
}
    
