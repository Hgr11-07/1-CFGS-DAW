package Tema11_Ej1;
import java.util.*;

public class Ejercicio1Integer {

	public static void main(String[] args) {
		Equipo equipo1, equipo2, equipo3, equipoFusionado, equipoInterseccion;

		equipo1 = new Equipo("Equipo 1");
		equipo2 = new Equipo("Equipo 2");
		equipo3 = new Equipo("Equipo 3");

		try {

			crearEquipo1(equipo1);
			crearEquipo2(equipo2);
			crearEquipo3(equipo3);

			// Borramos el 2 del equipo 1

			equipo1.borrarAlumno(Integer.valueOf(4));

			System.out.println(equipo1);
			System.out.println(equipo2);
			System.out.println(equipo3);

			equipoFusionado = equipo1.fusionDeEquipos(equipo2, "Equipo 1 unido 2");

			equipoInterseccion = equipo3.intersecionDeEquipos(equipo2, "Equipo 3 intersecci�n 2");

			System.out.println(equipoFusionado);
			System.out.println(equipoInterseccion);
		} catch (EquipoException e) {
			System.out.println(e.getMessage());
		}

	}

	private static void crearEquipo1(Equipo equipo1) {
		Integer nuevoAlumno;

		try {
			nuevoAlumno = Integer.valueOf(2);
			equipo1.insertarAlumno(nuevoAlumno);

			nuevoAlumno = Integer.valueOf(4);
			equipo1.insertarAlumno(nuevoAlumno);
			nuevoAlumno = Integer.valueOf(6);
			equipo1.insertarAlumno(nuevoAlumno);
			nuevoAlumno = Integer.valueOf(9);
			equipo1.insertarAlumno(nuevoAlumno);

			// Este no va a entrar
			nuevoAlumno = Integer.valueOf(2);
			equipo1.insertarAlumno(nuevoAlumno);
		} catch (EquipoException ex) {
			System.out.println(ex.getMessage());
		}

	}

	private static void crearEquipo2(Equipo equipo2) throws EquipoException {
		Integer nuevoAlumno;
		try {
			nuevoAlumno = Integer.valueOf(22);
			equipo2.insertarAlumno(nuevoAlumno);

			nuevoAlumno = Integer.valueOf(8);
			equipo2.insertarAlumno(nuevoAlumno);
			nuevoAlumno = Integer.valueOf(100);
			equipo2.insertarAlumno(nuevoAlumno);
			nuevoAlumno = Integer.valueOf(93);
			equipo2.insertarAlumno(nuevoAlumno);
		} catch (EquipoException ex) {
			System.out.println(ex.getMessage());
		}

	}

	private static void crearEquipo3(Equipo equipo3) throws EquipoException {
		Integer nuevoAlumno;
		try {
			nuevoAlumno = Integer.valueOf(12);
			equipo3.insertarAlumno(nuevoAlumno);

			nuevoAlumno = Integer.valueOf(14);
			equipo3.insertarAlumno(nuevoAlumno);
			nuevoAlumno = Integer.valueOf(8);
			equipo3.insertarAlumno(nuevoAlumno);
			nuevoAlumno = Integer.valueOf(93);
			equipo3.insertarAlumno(nuevoAlumno);
		} catch (EquipoException ex) {
			System.out.println(ex.getMessage());
		}

	}

}
