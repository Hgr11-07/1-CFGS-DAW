package Arrays;
import java.util.*;

public class Ejercicio10 {
	
	public static void main(String[] args) {
		
		int array1[] = {1, 2, 3, 4, 5};
		int array2[]=array1.clone();
		
		for(int a=0; a<array1.length; a++) {
			array1[a]=a;
		}
		System.out.println(Arrays.toString(array1));
		System.out.println(Arrays.toString(array2));
	}

}
