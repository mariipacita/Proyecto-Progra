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
    protected int time;
    protected boolean activo;

    public int getTime() {
        return time;
    }

    public boolean isActivo() {
        return activo;
    }

    public cronometro( Timer timer) {
        this.time = 0;
        this.activo = false;
         this.timer = new Timer(1000, new ActionListener(){
             @Override
    public void actionPerformed(ActionEvent e) {
      }
     });
        
    }
    
    
    public void incio(){
        activo = true;
    }
    public void fin(){
        activo = false;
    }
    public void reinicioCronometro(){
        time = 0;
    }
    
    public void iniciarT(){
        timer.start();
        
    }
    public void pararT(){
        timer.stop();
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
