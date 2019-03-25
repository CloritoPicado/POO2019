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

    /**
     *
     */
    public Pantalla() {
    }

    /**
     *
     * @param dimensiones
     * @param esDesmontable
     * @param esTactil
     */
    public Pantalla(String dimensiones, boolean esDesmontable, boolean esTactil) {
        this.dimensiones = dimensiones;
        this.esDesmontable = esDesmontable;
        this.esTactil = esTactil;
    }

    /**
     *
     * @return
     */
    public String getDimensiones() {
        return dimensiones;
    }

    /**
     *
     * @param dimensiones
     */
    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    /**
     *
     * @return
     */
    public boolean isEsDesmontable() {
        return esDesmontable;
    }

    /**
     *
     * @param esDesmontable
     */
    public void setEsDesmontable(boolean esDesmontable) {
        this.esDesmontable = esDesmontable;
    }

    /**
     *
     * @return
     */
    public boolean isEsTactil() {
        return esTactil;
    }

    /**
     *
     * @param esTactil
     */
    public void setEsTactil(boolean esTactil) {
        this.esTactil = esTactil;
    }

    @Override
    public String toString() {
        return "Pantalla\n" + "Dimensiones: " + dimensiones + " Es desmontable: " + (esDesmontable? "Sí":"No") + " Es táctil: " + (esTactil? "Sí":"No");
    }
    
    
    
}
