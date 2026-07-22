/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cronometro;

/**
 *
 * @author gabri
 */
public class cronometro {
    
    protected int time;
    protected boolean activo;

    public int getTime() {
        return time;
    }

    public boolean isActivo() {
        return activo;
    }

    public cronometro() {
        this.time = 0;
        this.activo = false;
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
