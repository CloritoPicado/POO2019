/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package radio;
import java.util.*;

/**
 *
 * @author Patrixito
 */
public class Bluetooth {

    
    private boolean encendido;
    private boolean vinculado;
    private List<Dispositivo> dispVinculados;
    
    public Bluetooth() {
    }

    public Bluetooth(boolean encendido, boolean vinculado, List<Dispositivo> disVinculados) {
        this.encendido = encendido;
        this.vinculado = vinculado;
        this.dispVinculados = disVinculados;
    }
    
    
    public void encender()
    {
        this.encendido = true;
    }

    public List<Dispositivo> getDisVinculados() {
        return dispVinculados;
    }

    public void setDisVinculados(List<Dispositivo> disVinculados) {
        this.dispVinculados = disVinculados;
    }
    
    public void apagar()
    {
        this.encendido = false;
    }

    public boolean isEncendido() {
        return encendido;
    }

    public void setEncendido(boolean encendido) {
        this.encendido = encendido;
    }

    public boolean isVinculado() {
        return vinculado;
    }

    public void setVinculado(boolean vinculado) {
        this.vinculado = vinculado;
    }
    
    public boolean vincularDispositivo(Dispositivo unDispositivo)
    {
        return dispVinculados.add(unDispositivo);
    }
    
    public void buscarDispositivos()
    {
        
    }
}
