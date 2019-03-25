/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radio;

/**
 *
 * @author Patrixito
 */
public class Emisora {
    
    private float frecuencia;
    private String nombre;

    /**
     *
     * @param frecuencia
     * @param nombre
     */
    public Emisora(float frecuencia, String nombre) {
        this.frecuencia = frecuencia;
        this.nombre = nombre;
    }

    /**
     *
     */
    public Emisora() {
    }

    /**
     *
     * @return
     */
    public float getFrecuencia() {
        return frecuencia;
    }

    /**
     *
     * @param frecuencia
     */
    public void setFrecuencia(float frecuencia) {
        this.frecuencia = frecuencia;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        String result = String.format("\nEmisora\nNombre: " + this.nombre + " Frecuencia: " + "%.1f", this.frecuencia);
        return result;
        
        //return "\nEmisora\nNombre: " + this.nombre + " Frecuencia: " + this.frecuencia;
    }
    
    
    
}
