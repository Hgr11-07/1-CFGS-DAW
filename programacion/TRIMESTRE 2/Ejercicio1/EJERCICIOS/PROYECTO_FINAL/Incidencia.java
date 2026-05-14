package PROYECTO_FINAL;

public class Incidencia {

    private int id;
    private String descripcion;
    private TipoIncidencia tipo;
    private Equipo equipo;
    private Jugador jugador;

    public Incidencia(int id, String descripcion, TipoIncidencia tipo, Equipo equipo, Jugador jugador) {
        this.id = id;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.equipo = equipo;
        this.jugador = jugador;
    }

    public int getId() { 
    	return id; 
    }
    public String getDescripcion() { 
    	return descripcion; 
    }
    public TipoIncidencia getTipo() { 
    	return tipo; 
    }
    public Equipo getEquipo() { 
    	return equipo; 
    }
    public Jugador getJugador() { 
    	return jugador; 
    }

    public void setId(int id) { 
    	this.id = id; 
    }
    public void setDescripcion(String descripcion) { 
    	this.descripcion = descripcion; 
    }
    public void setTipo(TipoIncidencia tipo) { 
    	this.tipo = tipo; 
    }
    public void setEquipo(Equipo equipo) { 
    	this.equipo = equipo; 
    }
    public void setJugador(Jugador jugador) { 
    	this.jugador = jugador; 
    }
    
    @Override
    public String toString() {
        String nombreJugador;
        if(jugador != null)
            nombreJugador = jugador.getNickname();
        else
            nombreJugador = "N/A";
        
        return "Incidencia #" + id + " | Tipo: " + tipo + " | Equipo: " + equipo.getNombre() +
               " | Jugador: " + nombreJugador + " | Descripcion: " + descripcion;
    }
    
    public void aplicarSancion() throws JugadorInvalidoException{
    	
    	if(tipo==TipoIncidencia.SANCION || tipo==TipoIncidencia.EXPULSION) {
    		if(jugador==null) {
    			throw new JugadorInvalidoException("El jugador no existe.");
    		}
    		jugador.setSancionado(true);
    	}
    	
    }

}
