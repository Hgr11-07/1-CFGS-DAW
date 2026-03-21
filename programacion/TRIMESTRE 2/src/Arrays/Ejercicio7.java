package Arrays;
import java.util.*;

public class Ejercicio7 {

	public static void main(String[] args) {
		
		int numeros[]= {1, 3, 5, 7, 9};
		int inverso[];
		inverso=new int[numeros.length];
		int j=0;
		
		for(int i=(inverso.length-1); i>=0; i--) {
			inverso[j]=numeros[i];
			j++;
		}
		System.out.println(Arrays.toString(inverso));
	}
}
