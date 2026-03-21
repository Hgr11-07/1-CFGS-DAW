package Arrays;

import java.util.*;

public class Ejercicio13 {
    public static void main(String[] args) {

        AlumnoEj13[] alumnos = {
            new AlumnoEj13("Ana", 8.5),
            new AlumnoEj13("Luis", 7.2),
            new AlumnoEj13("Marta", 9.1)
        };

        // 1️4️ Buscar alumno con mejor nota
        AlumnoEj13 mejor = alumnos[0];
        for (AlumnoEj13 a : alumnos) {
            if (a.nota > mejor.nota) {
                mejor = a;
            }
        }
        System.out.println("Alumno con mejor nota: " + mejor.nombre + " (" + mejor.nota + ")");

        // 1️5️ Subir nota a todo
        for (AlumnoEj13 a : alumnos) {
        	
        	
            a.nota += 1;
        }

        System.out.println("\nNotas después de subir 1 punto:");
        for (AlumnoEj13 a : alumnos) {
            System.out.println(a.nombre + " → " + a.nota);
        }

        // 1️6️ Ordenar alumnos por nota
        Arrays.sort(alumnos);

        System.out.println("\nAlumnos ordenados por nota:");
        for (AlumnoEj13 a : alumnos) {
            System.out.println(a.nombre + " → " + a.nota);
        }
    }
}


