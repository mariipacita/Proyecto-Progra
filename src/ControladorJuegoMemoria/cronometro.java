/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControladorJuegoMemoria;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
/**
 *
 * @author Student
 */
public class cronometro {
    private Cronometro.cronometro cron;
    private jugadores.Jugador jugador;
    
    //timer en el mpodelo y en la vista hay que hacer otro para que se muestre

    public cronometro(Cronometro.cronometro cron, jugadores.Jugador jugador) {
        this.cron = cron;
        this.jugador = jugador;
    }

   

    

    
    
    public void iniciar(){
      cron.iniciarT();
        
    }
    public void parar(){
        cron.pararT();
    }
    
    public void reiniciarTiempo(){
        cron.pararT();
       cron.reinicioT();
       jugador.reiniciarJugador();
       
    }
    public void timepoObtenido(){
        cron.tiempoDurado();
    }
    
}
