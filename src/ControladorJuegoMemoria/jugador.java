/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControladorJuegoMemoria;

import jugadores.Jugador;

/**
 *
 * @author Student
 */
public class jugador {
     private Jugador jugador;

    
     
     
     
     
   
    public void ParejasEncontradas(){
        jugador.ParejasCorrectas();
    }
    
    public void intentosEjecutados(){
        jugador.IntentosSum();
    }

    
    public void reiniciar(){
        jugador.reiniciarJugador();
    }
    public jugador(Jugador jugador) {
        this.jugador = jugador;
    }
    public int obtenerPareja(){
        return jugador.getParejas();
    }
     public int obtenerMovimientos(){
         return jugador.getIntentos();
     }
    
}
