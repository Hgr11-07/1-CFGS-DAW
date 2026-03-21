package Arrays;
import java.util.*;

public class Ejercicio8 {
	
	public static void main(String[] args) {
	
		int array[] = {1, 5, 8, 9, 12, 17};
		int copia[];
		copia=new int[array.length];
	
		for(int i=0; i<array.length; i++) {
			copia[i]=array[i];
		}
		System.out.println(Arrays.toString(copia));
	}
}
