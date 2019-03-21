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
public class Pantalla {
    
    private String dimensiones;
    private boolean esDesmontable;
    private boolean esTactil;

    public Pantalla() {
    }

    public Pantalla(String dimensiones, boolean esDesmontable, boolean esTactil) {
        this.dimensiones = dimensiones;
        this.esDesmontable = esDesmontable;
        this.esTactil = esTactil;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    public boolean isEsDesmontable() {
        return esDesmontable;
    }

    public void setEsDesmontable(boolean esDesmontable) {
        this.esDesmontable = esDesmontable;
    }

    public boolean isEsTactil() {
        return esTactil;
    }

    public void setEsTactil(boolean esTactil) {
        this.esTactil = esTactil;
    }

    @Override
    public String toString() {
        return "Pantalla\n" + "Dimensiones: " + dimensiones + " Es desmontable: " + (esDesmontable? "Sí":"No") + " Es táctil: " + (esTactil? "Sí":"No");
    }
    
    
    
}
