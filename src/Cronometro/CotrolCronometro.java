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
public class CotrolCronometro {
    
private cronometro cron;
    
    

    public CotrolCronometro(cronometro cronometro, Timer timer) {
        this.cron =new cronometro();
       
    }
    
    public void iniciarC(){
        cron.iniciar();
        
    }
    public void pararC(){
        cron.parar();
    }
    
    public void regresarTiempo(){
        timer.stop();
        cronometro.reinicioCronometro();
    }
    public int timepoObtenido(){
        return cronometro.getTime();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  }





    
