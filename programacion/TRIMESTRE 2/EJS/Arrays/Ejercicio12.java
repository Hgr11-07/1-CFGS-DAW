package Arrays;

import java.util.*;

public class Ejercicio12 {
	
	public static void main(String[] args) {
		
		int array[]= {1, 2, 4, 5, 9, 10};
		
		multiplicarPorDos(array);
		
		System.out.println();
		System.out.println("El array original es: " +Arrays.toString(array));
		
	}
	
	public static void multiplicarPorDos(int array[]) {
		
		for (int resultado : array){
			
			resultado*=2;
			System.out.print(+resultado+ ", ");
			
		}
		
	}
	
}
