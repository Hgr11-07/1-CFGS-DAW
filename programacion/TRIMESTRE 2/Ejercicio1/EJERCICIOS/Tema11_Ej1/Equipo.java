package Tema11_Ej1;
import java.util.*;

public class Equipo<T> {
	private String nombreEquipo;
	private HashSet<T> conjuntoAlumnos;

	public Equipo(String nombre) {

		setNombreEquipo(nombre);
		conjuntoAlumnos = new HashSet<T>();
	}

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public void insertarAlumno(T nuevo) throws EquipoException {

		boolean insertado;

		insertado = conjuntoAlumnos.add(nuevo);
		if (!insertado)
			throw new EquipoException("No se puede insertar el alumno");
	}

	public void borrarAlumno(T borrar) throws EquipoException {

		if (!conjuntoAlumnos.contains(borrar))
			throw new EquipoException("No se puede borrar. Ese alumno no está en el equipo");
		conjuntoAlumnos.remove(borrar);
	}

	/**
	 * Devuelve una cadena con el listado de los Alumnos
	 * 
	 * @return Cadena con el listado de Alumnos
	 */
	public String listadoDeAlumnos() {
		
		StringBuilder cadena = new StringBuilder(conjuntoAlumnos.size() * 20);

		for (T t : conjuntoAlumnos) {

			cadena.append(t + "\n");
		}
		return cadena.toString();
	}

	public T buscarAlumno(T buscado) {

		T encontrao = null;
		boolean encontrado = false;
		T t;

		Iterator<T> iterator = conjuntoAlumnos.iterator();
		while (iterator.hasNext() && !encontrado) {

			t = iterator.next();
			if (t.equals(buscado)) {
				encontrao = t;
				encontrado = true;
			}
		}
		return encontrao;
	}

	/**
	 * Une mi equipo con otro, devolviendo el nuevo equipo creado
	 * 
	 * @param otro   Otro equipo que se va a unir
	 * @param nombre Nombre del nuevo equipo
	 * @return nuevo equipo resultado de unir los dos anteriores
	 */
	public Equipo fusionDeEquipos(Equipo<T> otro, String nombre) {
		Equipo nuevoEquipo;

		nuevoEquipo = new Equipo(nombre);

		for (T t : this.conjuntoAlumnos) {

			try {
				nuevoEquipo.insertarAlumno(t);
			} catch (EquipoException e) {
				// Si se produce esta excepción es porque
				// el elemento está repetido.
				// Si se repite el elemento, se pasa al siguiente
			}
		}
		
		
		
		for (T t : otro.conjuntoAlumnos) {
			try {
				nuevoEquipo.insertarAlumno(t);
			} catch (EquipoException e) {
				// Si se produce esta excepción es porque
				// el elemento está repetido.
				// Si se repite el elemento, se pasa al siguiente
			}
		}

		return nuevoEquipo;

	}

	/**
	 * Crea un nuevo equipo con los elementos que están en los dos equipos (this y
	 * otro)
	 * 
	 * @param otro   Otro equipo
	 * @param nombre Nombre del nuevo equipo intersección
	 * @return Equipo resultado de la intersección
	 */
	public Equipo intersecionDeEquipos(Equipo otro, String nombre) {
		Equipo nuevoEquipo;

		nuevoEquipo = new Equipo(nombre);

		for (T t : this.conjuntoAlumnos) {

			if (otro.conjuntoAlumnos.contains(t)) {

				try {
					nuevoEquipo.insertarAlumno(t);
				} catch (EquipoException e) {
					// Esta excepción nunca se a va dar
					// Hay que tratarla porque lo obliga la sintaxis de Java
				}
			}
		}

		return nuevoEquipo;

	}

	@Override
	public String toString() {
		return "Nombre Equipo: " + nombreEquipo + "\nAlumnos:\n" + listadoDeAlumnos();
	}

}
