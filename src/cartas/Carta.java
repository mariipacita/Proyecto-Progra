/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cartas;

/**
 *
 * @author marii
 */
public class Carta {
    private String imagen;
    private boolean visible;
    private boolean encontrada;

    public String getImagen() {
        return imagen;
    }

    public boolean isVisible() {
        return visible;
    }

    public boolean isEncontrada() {
        return encontrada;
    }
    
    public Carta(String imagen, boolean visible, boolean encontrada) {
        this.imagen = imagen;
        this.visible = false;
        this.encontrada = false;
    }

    public void mostrar() {
        visible = true;
    }

    public void ocultar() {
         if (!encontrada) {
        visible = false;
    }
    }

    public void marcarEncontrada() {
        encontrada = true;
        visible = true;
    }

    public boolean esIgual(Carta otraCarta) {
        return imagen.equals(otraCarta.imagen);
    }
}

