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
public class MemoriaExterna {
    
    private TipoMemoria tipo;
    private Object contenido;

    /**
     *
     */
    public MemoriaExterna() {
    }

    /**
     *
     * @param tipo
     * @param contenido
     */
    public MemoriaExterna(TipoMemoria tipo, Object contenido) {
        this.tipo = tipo;
        this.contenido = contenido;
    }

    /**
     *
     * @return
     */
    public TipoMemoria getTipo() {
        return tipo;
    }

    /**
     *
     * @param tipo
     */
    public void setTipo(TipoMemoria tipo) {
        this.tipo = tipo;
    }

    /**
     *
     * @return
     */
    public Object getContenido() {
        return contenido;
    }

    /**
     *
     * @param contenido
     */
    public void setContenido(Object contenido) {
        this.contenido = contenido;
    }
    
    

    @Override
    public String toString() {
        return "Memoria Externa\nTipo de memoria: "+ this.tipo+ " \nContenido: "+ this.contenido;
    }
    
    
    
}
