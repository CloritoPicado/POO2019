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
public class Banda {
    
    private TipoBanda tipo;
    private List<Emisora> emisoras;

    /**
     *
     */
    public Banda() {
    }

    /**
     *
     * @param tipo
     * @param emisoras
     */
    public Banda(TipoBanda tipo, List<Emisora> emisoras) {
        this.tipo = tipo;
        this.emisoras = emisoras;
    }

    /**
     *
     * @return
     */
    public TipoBanda getTipo() {
        return tipo;
    }

    /**
     *
     * @param tipo
     */
    public void setTipo(TipoBanda tipo) {
        this.tipo = tipo;
    }

    /**
     *
     * @return
     */
    public List<Emisora> getEmisoras() {
        return emisoras;
    }

    /**
     *
     * @param emisoras
     */
    public void setEmisoras(List<Emisora> emisoras) {
        this.emisoras = emisoras;
    }

    @Override
    public String toString() {
        return "Banda\nTipo de Banda: "+ this.tipo+ " \nLista de emisoras: "+ emisoras.toString();
    }
    
    
    
}
