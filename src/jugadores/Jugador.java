/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jugadores;

/**
 *
 * @author gabri
 */
public class Jugador {
    protected String name;
    protected int puntaje;
    protected int parejas;
    protected int intentos;
    
     public Jugador(String name) {
        this.name = name;
        this.puntaje = 0;
        this.parejas = 0;
        this.intentos= 0;
    }
    

    public String getName() {
        return name;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public int getIntentos() {
        return intentos;
    }

    public int getParejas() {
        return parejas;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public void setParejas(int parejas) {
        this.parejas = parejas;
    }

    public void ParejasCorrectas(){
        parejas++;
        puntaje += 100;
    }
    
    public void IntentosSum(){
        intentos ++;
        puntaje -=20;
    }
    
   public void reiniciarJugador() {
       puntaje = 0;
       parejas = 0;
       intentos = 0;
   }

}
