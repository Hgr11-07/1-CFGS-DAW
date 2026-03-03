package Arrays;

import java.util.*;

public class Ejercicio11 {
	
	public static void main(String[] args) {
		
		int array[]= {1, 2, 4, 5, 9, 10};
		
		array=multiplicarPorDos(array);
		
		System.out.println("El array es: " +Arrays.toString(array));
		
	}
	
	public static int[] multiplicarPorDos(int array[]) {
		
		for(int i=0; i<array.length; i++) {
			
			array[i]*=2;
			
		}
		return array;
	}
	
}
