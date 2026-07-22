/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jugadores;

/**
 *
 * @author gabri
 */
public class controlJugadores {
   private Jugador jugador;
   
    public void ParejasEncontradas(){
        jugador.ParejasCorrectas();
    }
    
    public void intentosEjecutados(){
        jugador.IntentosSum();
    }

    public controlJugadores(Jugador jugador) {
        this.jugador = jugador;
    }
    
    
    
    
    
    
    
    
    
    
    
}
