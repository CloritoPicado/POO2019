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

    public Equalizador() {
    }

    public Equalizador(int volumen, int bajos, int agudos) {
        this.volumen = volumen;
        this.bajos = bajos;
        this.agudos = agudos;
    }

    public int getVolumen() {
        return volumen;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    public int getBajos() {
        return bajos;
    }

    public void setBajos(int bajos) {
        this.bajos = bajos;
    }

    public int getAgudos() {
        return agudos;
    }

    public void setAgudos(int agudos) {
        this.agudos = agudos;
    }

    @Override
    public String toString() {
        return "Equalizador\n" + "Volumen: " + volumen + " Bajos: " + bajos + " Agudos: " + agudos;
    }
    
    
    
}
