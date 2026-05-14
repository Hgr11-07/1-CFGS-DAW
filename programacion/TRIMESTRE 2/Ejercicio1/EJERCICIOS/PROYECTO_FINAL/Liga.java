package PROYECTO_FINAL;

import java.util.*;

public class Liga {

    private ArrayList<Equipo> equipos;
    private ArrayList<PersonaLiga> personas;
    private ArrayList<Incidencia> incidencias;
    private Queue<Partido> colaPartidos;
    private Stack<String> historial;
    private HashSet<Integer> idsRegistrados;
    private HashSet<String> nombresEquipos;
    private int[][] calendario;

    public Liga() {
        this.equipos = new ArrayList<>();
        this.personas = new ArrayList<>();
        this.incidencias = new ArrayList<>();
        this.colaPartidos = new LinkedList<>();
        this.historial = new Stack<>();
        this.idsRegistrados = new HashSet<>();
        this.nombresEquipos = new HashSet<>();
        this.calendario = null;
    }

    public ArrayList<Equipo> getEquipos() { 
    	return equipos; 
    }
    public ArrayList<PersonaLiga> getPersonas() { 
    	return personas; 
    }
    public ArrayList<Incidencia> getIncidencias() { 
    	return incidencias; 
    }
    public Queue<Partido> getColaPartidos() { 
    	return colaPartidos; 
    }
    public Stack<String> getHistorial() { 
    	return historial; 
    }
    public HashSet<Integer> getIdsRegistrados() { 
    	return idsRegistrados; 
    }
    public HashSet<String> getNombresEquipos() { 
    	return nombresEquipos; 
    }
    public int[][] getCalendario() { 
    	return calendario; 
    }

    public void setEquipos(ArrayList<Equipo> equipos) { 
    	this.equipos = equipos; 
    }
    public void setPersonas(ArrayList<PersonaLiga> personas) { 
    	this.personas = personas; 
    }
    public void setIncidencias(ArrayList<Incidencia> incidencias) { 
    	this.incidencias = incidencias; 
    }
    public void setColaPartidos(Queue<Partido> colaPartidos) { 
    	this.colaPartidos = colaPartidos; 
    }
    public void setHistorial(Stack<String> historial) { 
    	this.historial = historial; 
    }
    public void setIdsRegistrados(HashSet<Integer> idsRegistrados) { 
    	this.idsRegistrados = idsRegistrados; 
    }
    public void setNombresEquipos(HashSet<String> nombresEquipos) { 
    	this.nombresEquipos = nombresEquipos; 
    }
    public void setCalendario(int[][] calendario) { 
    	this.calendario = calendario; 
    }
    
    public void registrarPersona(PersonaLiga p) throws PersonaDuplicadaException {
    	
    	if(idsRegistrados.contains(p.getId())) {
    		throw new PersonaDuplicadaException("El jugador ya existe.");
    	}
    	
    	personas.add(p);
    	idsRegistrados.add(p.getId());
    	historial.push("Jug. Registrado: " +p.getNombre());
    
    }
    
    public void listarPersonas() {
    	
    	Iterator<PersonaLiga> i = personas.iterator();
    	int contador=1;
    	PersonaLiga p;
    	
    	if(personas.isEmpty()) {
    		System.out.println("Aún no hay jugadores registrados");
    		return;
    	}
    	
    	while(i.hasNext()) {
    		p=i.next();
    		System.out.println(contador+ ". " +p.getNombre()+ "	(@" +p.getNickname()+ ")");
    		System.out.println();
    		contador++;
    	}
    	
    }
    
    public PersonaLiga buscarPersona(int id) {
    	
    	Iterator<PersonaLiga> i = personas.iterator();
    	PersonaLiga p;
    	
    	while(i.hasNext()) {
    		p=i.next();
    		if(p!=null&&p.getId()==id) {
    			return p;
    		}
    	}
    	return null;
    }
    
    public void eliminarPersona(int id) throws PersonaNoEncontradaException {
    	
    	Iterator<PersonaLiga> i = personas.iterator();
    	PersonaLiga p;
    	boolean borrado=false;
    	
    	while(i.hasNext()){
    		p=i.next();
    		if(p!=null&&p.getId()==id) {
    			i.remove();
    			idsRegistrados.remove(p.getId());
    			historial.push("Jug. Borrado: " + p.getNombre());
    			borrado=true;
    			break;
    		}
    	}
    	
    	if(!borrado)
    		throw new PersonaNoEncontradaException("No se ha encontrado al jugador.");
    }
    
    public void registrarEquipo(Equipo e) throws EquipoDuplicadoException {
    	if(nombresEquipos.contains(e.getNombre())) {
    		throw new EquipoDuplicadoException("El equipo ya está registrado.");
    	}
    	
    	equipos.add(e);
    	nombresEquipos.add(e.getNombre());
    	historial.push("Eq. Registrado: " +e.getNombre());
    }
    
}
