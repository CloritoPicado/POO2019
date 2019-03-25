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
public class Equalizador {
    
    private int volumen;
    private int bajos;
    private int agudos;

    /**
     *
     */
    public Equalizador() {
    }

    /**
     *
     * @param volumen
     * @param bajos
     * @param agudos
     */
    public Equalizador(int volumen, int bajos, int agudos) {
        this.volumen = volumen;
        this.bajos = bajos;
        this.agudos = agudos;
    }

    /**
     *
     * @return
     */
    public int getVolumen() {
        return volumen;
    }

    /**
     *
     * @param volumen
     */
    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    /**
     *
     * @return
     */
    public int getBajos() {
        return bajos;
    }

    /**
     *
     * @param bajos
     */
    public void setBajos(int bajos) {
        this.bajos = bajos;
    }

    /**
     *
     * @return
     */
    public int getAgudos() {
        return agudos;
    }

    /**
     *
     * @param agudos
     */
    public void setAgudos(int agudos) {
        this.agudos = agudos;
    }

    @Override
    public String toString() {
        return "Equalizador\n" + "Volumen: " + volumen + " Bajos: " + bajos + " Agudos: " + agudos;
    }
    
    
    
}
