/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegos;

import Cronometro.cronometro;
import cartas.Carta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
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
    private Carta primeraCarta;
    private Carta segundaCarta;
    
    public Juego(Jugador jugador, Nivel nivel,String[] imagenes){
        this.jugador = jugador;
        this.nivel = nivel;
        this.tablero = new Tablero(nivel, imagenes);
        this.Cronometro = new cronometro();
       
       
    }
    public void iniciarPartida() {
        tablero.inicializarTablero();
        Cronometro.iniciarT();

}

public void seleccionarCarta(int fila, int columna) {

    Carta carta = tablero.obtenerCarta(fila, columna);
    if (carta == null || carta.isEncontrada()) {
        return;
    }
    carta.mostrar();
    if (primeraCarta == null) {
        primeraCarta = carta;     
    } else if (segundaCarta == null) {    
        segundaCarta = carta;     
        verificarPareja();
    }
}


public void verificarPareja() {
   
    if (primeraCarta.esIgual(segundaCarta)) {

        primeraCarta.marcarEncontrada();
        segundaCarta.marcarEncontrada();

        actualizarJugador();
        
        if (tablero.juegoFinalizado()){
            finalizarJuego();
        }
    } else {
        Timer timer = new Timer(2000, new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e) {
        
        primeraCarta.ocultar();
        segundaCarta.ocultar();
    
        primeraCarta = null;
        segundaCarta = null;
            }
        });
        timer.setRepeats(false);
        timer.start();
        
        return;
}
}


public void actualizarJugador() {
    jugador.ParejasCorrectas();

}



public void finalizarJuego() {
    Cronometro.pararT();

    System.out.println("Juego terminado");
    System.out.println("Puntaje: " + jugador.getPuntaje());
    System.out.println("Parejas encontradas: " + jugador.getParejas());
  
}


public void reiniciarPartida() {

    tablero.reiniciarTablero();
    Cronometro.reinicioT();

    jugador.reiniciarJugador();
    
    primeraCarta = null;
    segundaCarta = null;

 }
}

    
