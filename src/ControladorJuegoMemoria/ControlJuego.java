/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControladorJuegoMemoria;


    import juegos.Juego;

/**
 *
 * @author sharys
 */
public class ControlJuego {
    private Juego juego;
    
    public ControlJuego(Juego juego){
        this.juego = juego;
    }
    
    public void iniciarPartida() {
        juego.iniciarPartida();
    }        
    
    public void seleccionarCarta(int fila, int columna){
        juego.seleccionarCarta(fila, columna);
    }
    
    public void actualizarJugador(){
        juego.actualizarJugador();
    }
    
    public void finalizarJuego(){
        juego.finalizarJuego();
    }
    
    public void reiniciarPartida(){
        juego.reiniciarPartida();
    }
    
    public Juego getJuego(){
        return juego;
    }
}


