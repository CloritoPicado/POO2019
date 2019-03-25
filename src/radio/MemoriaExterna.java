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

    public MemoriaExterna() {
    }

    public MemoriaExterna(TipoMemoria tipo, Object contenido) {
        this.tipo = tipo;
        this.contenido = contenido;
    }

    public TipoMemoria getTipo() {
        return tipo;
    }

    public void setTipo(TipoMemoria tipo) {
        this.tipo = tipo;
    }

    public Object getContenido() {
        return contenido;
    }

    public void setContenido(Object contenido) {
        this.contenido = contenido;
    }
    
    

    @Override
    public String toString() {
        return "Memoria Externa\nTipo de memoria: "+ this.tipo+ " \nContenido: "+ this.contenido;
    }
    
    
    
}
