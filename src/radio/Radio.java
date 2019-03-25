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
    private Modo modo;
    private Emisora emisoraActual;
    private Bluetooth elBluetooth;
    private List<MemoriaExterna> memoriasExternas;
    private MemoriaExterna memExtSeleccionada;
    private boolean encendido;
    private boolean detenerse = true;
    private Equalizador elEqualizador = new Equalizador();
    /**
     */
    
    
    
    public Radio()
    {
       this.encendido = true;
       this.bandaActual = TipoBanda.FM;
       this.emisoraActual = new Emisora(94.3f, "Radio Reloj");
       this.modo = Modo.Radio;
       crearFavoritas();
    }
    
    /**
     * 
     */
    public void crearFavoritas()
    {
        List<Emisora> favoritasAM = new ArrayList<>();
        List<Emisora> favoritasFM = new ArrayList<>();
        
        favoritasAM.add(new Emisora(600f, "Seiscientos"));
        favoritasAM.add(new Emisora(800f, "Ochocientos"));
        
        favoritasFM.add(new Emisora(94.3f, "Radio Reloj"));
        favoritasFM.add(new Emisora(94.7f, "Radio 94.7"));
        favoritasFM.add(new Emisora(101f, "Radio Disney"));
        
        this.setMemoriaAM(favoritasAM);
        this.setMemoriaFM(favoritasFM);
        
    }
    
    /**
     *
     * @param emisora Description Agrega una emisora AM a la lista de favoritos en una posición vacía, o sino la primera posición.
     */
    public void agregarAM(Emisora emisora)
    {
        if(memoriaAM.size() < 6)
        {
            memoriaAM.add(emisora);
        }
        else
            memoriaAM.set(0, emisora);
    }
    
    /**
     *
     * @param emisora Description Agrega una emisora FM a la lista de favoritos en una posición vacía, o sino la primera posición.
     */
    public void agregarFM(Emisora emisora)
    {
        if(memoriaFM.size() < 18)
        {
            memoriaFM.add(emisora);
        }
        else
            memoriaFM.set(0, emisora);
    }

    /**
     *
     * @param marca
     * @param dimensiones
     * @param memoriaAM
     * @param memoriaFM
     * @param bandaActual
     * @param emisoraActual
     * @param elBluetooth
     * @param memoriasExternas
     * @param memExtSeleccionada
     * @param encendido
     * @param modo
     */
    public Radio(String marca, String dimensiones, List<Emisora> memoriaAM, List<Emisora> memoriaFM, TipoBanda bandaActual, Emisora emisoraActual, Bluetooth elBluetooth, List<MemoriaExterna> memoriasExternas, MemoriaExterna memExtSeleccionada, boolean encendido, Modo modo) {
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
        this.modo = modo;
    }

    /*******************Getter-Setter
     * @return s********************/
    public Modo getModo() {
        return modo;
    }
    
    /**
     *
     * @param modo
     */
    public void setModo(Modo modo) {
        this.modo = modo;
    }

    /**
     *
     * @return
     */
    public String getMarca() {
        return marca;
    }

    /**
     *
     * @param marca
     */
    public void setMarca(String marca) {
        this.marca = marca;
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
    public List<Emisora> getMemoriaAM() {
        return memoriaAM;
    }

    /**
     *
     * @param memoriaAM
     */
    public void setMemoriaAM(List<Emisora> memoriaAM) {
        this.memoriaAM = memoriaAM;
    }

    /**
     *
     * @return
     */
    public List<Emisora> getMemoriaFM() {
        return memoriaFM;
    }

    /**
     *
     * @param memoriaFM
     */
    public void setMemoriaFM(List<Emisora> memoriaFM) {
        this.memoriaFM = memoriaFM;
    }

    /**
     *
     * @return
     */
    public TipoBanda getBandaActual() {
        return bandaActual;
    }

    /**
     *
     * @param bandaActual
     */
    public void setBandaActual(TipoBanda bandaActual) {
        this.bandaActual = bandaActual;
    }

    /**
     *
     * @return
     */
    public Emisora getEmisoraActual() {
        return emisoraActual;
    }

    /**
     *
     * @param emisoraActual
     */
    public void setEmisoraActual(Emisora emisoraActual) {
        this.emisoraActual = emisoraActual;
    }

    /**
     *
     * @return
     */
    public Bluetooth getElBluetooth() {
        return elBluetooth;
    }

    /**
     *
     * @param elBluetooth
     */
    public void setElBluetooth(Bluetooth elBluetooth) {
        this.elBluetooth = elBluetooth;
    }

    /**
     *
     * @return
     */
    public List<MemoriaExterna> getMemoriasExternas() {
        return memoriasExternas;
    }

    /**
     *
     * @param memoriasExternas
     */
    public void setMemoriasExternas(List<MemoriaExterna> memoriasExternas) {
        this.memoriasExternas = memoriasExternas;
    }

    /**
     *
     * @return
     */
    public MemoriaExterna getMemExtSeleccionada() {
        return memExtSeleccionada;
    }

    /**
     *
     * @param memExtSeleccionada
     */
    public void setMemExtSeleccionada(MemoriaExterna memExtSeleccionada) {
        this.memExtSeleccionada = memExtSeleccionada;
    }

    /**
     *
     * @return
     */
    public boolean isEncendido() {
        return encendido;
    }

    /**
     *
     * @param encendido
     */
    public void setEncendido(boolean encendido) {
        this.encendido = encendido;
    }

    /**
     *
     * @return
     */
    public Equalizador getElEqualizador() {
        return elEqualizador;
    }

    /**
     *
     * @param elEqualizador
     */
    public void setElEqualizador(Equalizador elEqualizador) {
        this.elEqualizador = elEqualizador;
    }
    
    /**
     * @return ****************************************************/

    public boolean isDetenerse() {
        return detenerse;
    }

    /**
     *
     * @param detenerse
     */
    public void setDetenerse(boolean detenerse) {
        this.detenerse = detenerse;
    }

    /**
     *
     */
    public void encender() {
        this.encendido = true;
    }
    
    /**
     *
     */
    public void apagar()
    {
        this.encendido = false;
    }
    
    /**
     *
     * @param banda
     * @param numMemoria
     * @param emisora
     */
    public void asignarEmisoraAMemoria(TipoBanda banda, int numMemoria, Emisora emisora)
    {
        
    }    
    
    /**
     *
     * @param banda
     * @param posicion
     * @return
     */
    public Emisora getMemoria(TipoBanda banda, int posicion)
    {
        return null;
    }
    
    /**
     *
     * @param laBanda
     */
    public void hacerScan(Banda laBanda)
    {
        
    }
    
    /**
     *
     * @param banda
     */
    public void setSigEmisora(TipoBanda banda)
    {
        
    }
    
    /**
     *
     * @param banda
     */
    public void setAntEmisora(TipoBanda banda)
    {
        
    }
    
    /**
     *
     */
    public void reproducirEmisora()
    {
        
    }
    
    /**
     *
     */
    public void reproducirDesdeBluetooth()
    {
        
    }
    
    /**
     *
     */
    public void reproducirDesdeMemoriaExterna()
    {
        
    }
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        
        
        // TODO code application logic here
    }
    
    
}
