package ArraysV2;
import java.util.*;

public class Ejercicio1 {

    public static void main(String[] args) {

        double sumas[] = {0, 0, 0, 0, 0};
        String asignatura[] = {"Programación", "Base de Datos", "Sistemas Informáticos", "Lenguajes de Marcas", "Entornos de Desarrollo"};

        int cont5=0, cont4=0, cont3=0, cont2=0, cont1=0, cont0=0;
        int suspenso[] = new int[30];
        double calificaciones[][] = new double[30][5];
        Random random = new Random();

        for(int i=0; i<calificaciones.length; i++) {
            suspenso[i] = 0;
            for(int j=0; j<calificaciones[i].length; j++) {
            	
                calificaciones[i][j] = random.nextDouble(10) + 1;

                if(calificaciones[i][j] < 5) {
                    suspenso[i]++;
                }

                sumas[j] += calificaciones[i][j];
            }

            switch(suspenso[i]) {
                case 5: 
                	cont5++; 
                	break;
                case 4: 
                	cont4++; 
                	break;
                case 3: 
                	cont3++; 
                	break;
                case 2: 
                	cont2++; 
                	break;
                case 1: 
                	cont1++; 
                	break;
                case 0: 
                	cont0++; 
                	break;
            }
        }

        System.out.println("Hay " + cont5 + " alumnos con 5 suspensas.");
        System.out.println("Hay " + cont4 + " alumnos con 4 suspensas.");
        System.out.println("Hay " + cont3 + " alumnos con 3 suspensas.");
        System.out.println("Hay " + cont2 + " alumnos con 2 suspensas.");
        System.out.println("Hay " + cont1 + " alumnos con 1 suspensa.");
        System.out.println("Hay " + cont0 + " alumnos con 0 suspensas.");

        for(int k=0; k<sumas.length; k++) {
            System.out.println("La nota media de " +asignatura[k]+ " es: "+sumas[k]/30);
        }
    }
}
