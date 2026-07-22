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
    
private cronometro cronometro;
    
    private Timer timer;

    public CotrolCronometro(cronometro cronometro, Timer timer) {
        this.cronometro =new cronometro();
        this.timer = new Timer(1000, new ActionListener(){
             @Override
    public void actionPerformed(ActionEvent e) {
      }
     });
    }
    
    public void iniciar(){
        timer.start();
    }
    public void parar(){
        timer.stop();
    }
    
    public void regresarTiempo(){
        timer.stop();
        cronometro.reinicioCronometro();
    }
    public int timepoObtenido(){
        return cronometro.getTime();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  }





    
