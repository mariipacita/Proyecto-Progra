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
    protected int duracion ;
    protected int min;
    protected int seg;
  

   
 

   public cronometro() {
    this.duracion = 0;

    timer = new Timer(1000, new ActionListener() {
       @Override
        public void actionPerformed(ActionEvent e) {
            
             duracion++;
           
            
        }
    });

}

    public Timer getTimer() {
        return timer;
    }

    public int getDuracion() {
        return duracion;
    }

    public int getMin() {
        return min;
    }

    public int getSeg() {
        return seg;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }
        
    
    
    
    public void reinicioT(){
       timer.restart();
       duracion=0;
    }
    
    public void iniciarT(){
        timer.start();
        
    }
    public void pararT(){
        if (timer.equals(900)){

        timer.stop();
        }
    }
    
    public void tiempoDurado(){
          min= duracion/60;
             seg= duracion%60;
      
    }


    
    
    
    
    
    
    
    
    
    
}
