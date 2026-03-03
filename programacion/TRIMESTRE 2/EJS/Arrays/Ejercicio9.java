package Arrays;
import java.util.*;

public class Ejercicio9 {
	
	public static void main(String[] args) {
		
		int array1[] = {1, 5, 7, 8, 10};
		int array2[] = {1, 5, 7, 8, 10};
		
		if(array1.equals(array2)) {
			System.out.println("Tus arrays son exactamente iguales."); //Como están almacenados en espacios de memoria distintos los arrays no son iguales.
		}else {
			System.out.println("Tus arrays no son iguales."); //Si array1[]=array2[] sí que serían iguales, puesto que apuntan al mismo espacio de memoria.
		}
		if(Arrays.equals(array1, array2)) {
			System.out.println("Tus arrays son exactamente iguales."); //Como tienen el mismo contenido, son iguales los arrays.
		}else {
			System.out.println("Tus arrays no son iguales."); //Si array1 tuviese un numero maa dentro, serían distintos, pues su contenido interno sería diferente.
		}
	}

}
