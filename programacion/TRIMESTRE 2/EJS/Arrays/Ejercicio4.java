package Arrays;

import java.util.*;

public class Ejercicio4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		int num;
		int posicion=-1;
		int i=0;
		int arrayInt[] = {1, 6, 80, 443, 2, 71};
		System.out.println("Introduce un número: ");
		num = sc.nextInt();
		
		while (i < arrayInt.length && posicion == -1) {
		    if (arrayInt[i] == num) {
		        posicion = i;
		    }else {
		    	i++;
		    }
		}
		
		if(posicion==-1) {
			System.out.println("No se encontró tu número");
		} else {
			System.out.println("El número está en la " +(posicion+1)+ " posición");
		}
		
		
	}
}
