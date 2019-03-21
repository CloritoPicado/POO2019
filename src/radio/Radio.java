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
public class Radio {
    private String marca;
    private String dimensiones;
    private List<Emisora> memoriaAM;
    private List<Emisora> memoriaFM;
    private TipoBanda bandaActual;
    private Emisora emisoraActual;
    private Bluetooth elBluetooth;
    private List<MemoriaExterna> memoriasExternas;
    private MemoriaExterna memExtSeleccionada;
    private boolean encendido;
    /**
     * @param args the command line arguments
     */
    
    
    
    public Radio()
    {
    }

    public Radio(String marca, String dimensiones, List<Emisora> memoriaAM, List<Emisora> memoriaFM, TipoBanda bandaActual, Emisora emisoraActual, Bluetooth elBluetooth, List<MemoriaExterna> memoriasExternas, MemoriaExterna memExtSeleccionada, boolean encendido) {
        this.marca = marca;
        this.dimensiones = dimensiones;
        this.memoriaAM = memoriaAM;
        this.memoriaFM = memoriaFM;
        this.bandaActual = bandaActual;
        this.emisoraActual = emisoraActual;
        this.elBluetooth = elBluetooth;
        this.memoriasExternas = memoriasExternas;
        this.memExtSeleccionada = memExtSeleccionada;
        this.encendido = encendido;
    }

    /*******************Getter-Setters********************/
    
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    public List<Emisora> getMemoriaAM() {
        return memoriaAM;
    }

    public void setMemoriaAM(List<Emisora> memoriaAM) {
        this.memoriaAM = memoriaAM;
    }

    public List<Emisora> getMemoriaFM() {
        return memoriaFM;
    }

    public void setMemoriaFM(List<Emisora> memoriaFM) {
        this.memoriaFM = memoriaFM;
    }

    public TipoBanda getBandaActual() {
        return bandaActual;
    }

    public void setBandaActual(TipoBanda bandaActual) {
        this.bandaActual = bandaActual;
    }

    public Emisora getEmisoraActual() {
        return emisoraActual;
    }

    public void setEmisoraActual(Emisora emisoraActual) {
        this.emisoraActual = emisoraActual;
    }

    public Bluetooth getElBluetooth() {
        return elBluetooth;
    }

    public void setElBluetooth(Bluetooth elBluetooth) {
        this.elBluetooth = elBluetooth;
    }

    public List<MemoriaExterna> getMemoriasExternas() {
        return memoriasExternas;
    }

    public void setMemoriasExternas(List<MemoriaExterna> memoriasExternas) {
        this.memoriasExternas = memoriasExternas;
    }

    public MemoriaExterna getMemExtSeleccionada() {
        return memExtSeleccionada;
    }

    public void setMemExtSeleccionada(MemoriaExterna memExtSeleccionada) {
        this.memExtSeleccionada = memExtSeleccionada;
    }

    public boolean isEncendido() {
        return encendido;
    }

    public void setEncendido(boolean encendido) {
        this.encendido = encendido;
    }
    
    /******************************************************/

    public void encender() {
        this.encendido = true;
    }
    
    public void apagar()
    {
        this.encendido = false;
    }
    
    public void asignarEmisoraAMemoria(TipoBanda banda, int numMemoria, Emisora emisora)
    {
        
    }    
    
    public Emisora getMemoria(TipoBanda banda, int posicion)
    {
        return null;
    }
    
    public void hacerScan(Banda laBanda)
    {
        
    }
    
    public void setSigEmisora(TipoBanda banda)
    {
        
    }
    
    public void setAntEmisora(TipoBanda banda)
    {
        
    }
    
    public void reproducirEmisora()
    {
        
    }
    
    public void reproducirDesdeBluetooth()
    {
        
    }
    
    public void reproducirDesdeMemoriaExterna()
    {
        
    }
    
    public static void main(String[] args) {
        
        
        // TODO code application logic here
    }
    
}
