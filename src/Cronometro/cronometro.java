/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cronometro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author gabri
 */
public class cronometro {
     private Timer timer;
    protected int duracion;
  

   
 

   public cronometro(int duracion) {
    this.duracion = duracion;

    timer = new Timer(1000, new ActionListener() {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            // Aquí irá la lógica para contar el tiempo
        }
    });

}
        
    
    
    
    public void reinicioT(){
       timer.restart();
    }
    
    public void iniciarT(){
        timer.start();
        
    }
    public void pararT(){
        timer.stop();
    }
    
    public void tiempoDurado(){
        
    }
    
    
    
    
    
    
    
    
    
    
    
}
