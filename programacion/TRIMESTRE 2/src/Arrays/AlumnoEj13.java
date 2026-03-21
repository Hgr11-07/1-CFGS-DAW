package Arrays;

import java.util.Arrays;

	public class AlumnoEj13 implements Comparable<AlumnoEj13> {
		String nombre;
		double nota;

    public AlumnoEj13(String nombre, double nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    @Override
    public int compareTo(AlumnoEj13 otro) {
        // Orden ascendente por nota
        return Double.compare(this.nota, otro.nota);
    }
}
