package ArraysV2;
import java.util.*;

public class Ejercicio3 {

	public static Scanner teclado=new Scanner(System.in);
	
	public static void main(String[] args) {
	    
	    String[] asignaturas = {
	        "Bases de Datos", "Programación", "Lenguajes de Marcas",
	        "Sistemas Informáticos", "Entornos de Desarrollo",
	        "Sostenibilidad", "IPE", "Digitalización"
	    };
	    
	    Random random = new Random();
	    Falta[][] faltas = new Falta[20][8];
	    
	    for(int i=0; i<faltas.length; i++) {
	        for(int j=0; j<faltas[i].length; j++) {
	            faltas[i][j] = new Falta(
	                random.nextInt(30)+1,
	                random.nextInt(30)+1,
	                random.nextInt(30)+1
	            );
	        }
	    }
	    
	    FaltasAlumnosAsignaturas faa = new FaltasAlumnosAsignaturas(20, asignaturas, faltas);
	    
	    System.out.println("=== Alumno con más faltas injustificadas por asignatura ===");
	    faa.verAlumnoInjustificadas();
	    
	    System.out.println("\n=== Alumnos con retrasos superiores a la media ===");
	    faa.alumnoSuperiorMedia();
	    
	    System.out.println();
	    
	    System.out.println("\n=== Asignatura con menor número de retrasos ===");
	    faa.asignaturaMenorRetraso();
	}
	
}
