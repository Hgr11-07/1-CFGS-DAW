package PROYECTO_FINAL;

public class Partido {
	
	private int id;
	private int jornada;
	private Equipo equipoLocal;
	private Equipo equipoVisitante;
	private int puntuacionLocal;
	private int puntuacionVisitante;
	private Jugador mvp;
	private boolean disputado;

	public Partido(int id, int jornada, Equipo equipoLocal, Equipo equipoVisitante) {
		this.id = id;
		this.jornada = jornada;
		this.equipoLocal = equipoLocal;
		this.equipoVisitante = equipoVisitante;
		this.puntuacionLocal = 0;
		this.puntuacionVisitante = 0;
		this.mvp = null;
		this.disputado = false;
	}

	public int getId() { 
		return id; 
	}
	
	public int getJornada() { 
		return jornada; 
	}
	
	public Equipo getEquipoLocal() { 
		return equipoLocal;
	}
	
	public Equipo getEquipoVisitante() { 
		return equipoVisitante; 
	}
	
	public int getPuntuacionLocal() { 
		return puntuacionLocal; 
	}
	
	public int getPuntuacionVisitante() { 
		return puntuacionVisitante; 
	}
	
	public Jugador getMvp() { 
		return mvp; 
	}
	
	public boolean isDisputado() { 
		return disputado; 
	}

	public void setId(int id) { 
		this.id = id; 
	}
	
	public void setJornada(int jornada) { 
		this.jornada = jornada; 
	}
	
	public void setEquipoLocal(Equipo equipoLocal) { 
		this.equipoLocal = equipoLocal; 
	}
	
	public void setEquipoVisitante(Equipo equipoVisitante) { 
		this.equipoVisitante = equipoVisitante; 
	}
	
	public void setPuntuacionLocal(int puntuacionLocal) { 
		this.puntuacionLocal = puntuacionLocal; 
	}
	
	public void setPuntuacionVisitante(int puntuacionVisitante) { 
		this.puntuacionVisitante = puntuacionVisitante; 
	}
	
	public void setMvp(Jugador mvp) { 
		this.mvp = mvp; 
	}
	
	public void setDisputado(boolean disputado) { 
		this.disputado = disputado; 
	}
	
	@Override
	public String toString() {
		return "Partido #" + id + " | Jornada: " + jornada + " | " + equipoLocal.getNombre() + " vs " + equipoVisitante.getNombre() + " | " + puntuacionLocal + " - " + puntuacionVisitante + " | Disputado: " + disputado;
	}
	
	public void registrarResultado(int puntosLocal, int puntosVisitante, Jugador mvp) throws PartidoDisputadoException, PartidoInvalidoException, MvpInvalidoException{
		
		Equipo ganador;
		boolean encontrado=false;
		
		if(disputado)
			throw new PartidoDisputadoException("El partido ya se ha disputado.");
		if(equipoLocal.equals(equipoVisitante))
			throw new PartidoInvalidoException("El partido tiene dos equipos iguales.");
		
		if(mvp!=null) {
			
			for(int i=0; i<equipoLocal.getTitulares().length; i++) {
				if(equipoLocal.getTitulares()[i]!=null&&mvp.equals(equipoLocal.getTitulares()[i])) {
					encontrado=true;
					break;
				}
			}
			
			for(int i=0; i<equipoVisitante.getTitulares().length; i++) {
				if(equipoVisitante.getTitulares()[i]!=null&&mvp.equals(equipoVisitante.getTitulares()[i])) {
					encontrado=true;
					break;
				}
			}
			
			if(encontrado)
				mvp.setMvpsTotales(mvp.getMvpsTotales()+1);
			else
				throw new MvpInvalidoException("El MVP no está en ninguno de los dos equipos.");
		}
		
		this.puntuacionLocal=puntosLocal;
		this.puntuacionVisitante=puntosVisitante;
		this.mvp=mvp;
		this.disputado=true;
		ganador=calcularGanador();
		
		
		equipoLocal.setPuntosFavor(equipoLocal.getPuntosFavor()+this.puntuacionLocal);
		equipoLocal.setPuntosContra(equipoLocal.getPuntosContra()+this.puntuacionVisitante);
		equipoVisitante.setPuntosContra(equipoVisitante.getPuntosContra()+this.puntuacionLocal);
		equipoVisitante.setPuntosFavor(equipoVisitante.getPuntosFavor()+this.puntuacionVisitante);
		
		if(ganador!=null) {
			if(ganador.equals(equipoLocal)) {
				equipoLocal.setVictorias((equipoLocal.getVictorias())+1);
				equipoVisitante.setDerrotas(equipoVisitante.getDerrotas()+1);
			} else {
				equipoVisitante.setVictorias((equipoVisitante.getVictorias())+1);
				equipoLocal.setDerrotas(equipoLocal.getDerrotas()+1);
			}

		}
		
		for(int i=0; i<equipoLocal.getTitulares().length; i++) {
			if(equipoLocal.getTitulares()[i]!=null)
				equipoLocal.getTitulares()[i].setPartidasJugadas(equipoLocal.getTitulares()[i].getPartidasJugadas()+1);
		}
		for(int i=0; i<equipoVisitante.getTitulares().length; i++) {
			if(equipoVisitante.getTitulares()[i]!=null)
				equipoVisitante.getTitulares()[i].setPartidasJugadas(equipoVisitante.getTitulares()[i].getPartidasJugadas()+1);
		}
	}
	
	public Equipo calcularGanador() {
	    if (this.puntuacionLocal > this.puntuacionVisitante) {
	        return this.equipoLocal;
	    } else if (this.puntuacionVisitante > this.puntuacionLocal) {
	        return this.equipoVisitante;
	    }
	    return null;
	}
	
}
