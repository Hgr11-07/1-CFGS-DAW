package Arrays;

public class Ejercicio5 {
	
	public static void main(String[] args) {
		
		int arrayEnteros[] = {1, 10, 800, 5, 90, 42, 6, 54, 101, 73};
		int mayor=0;
		
		for(int a=0; a<arrayEnteros.length; a++) {
			if(a==0) {
				mayor=arrayEnteros[0];
			}else if(mayor<arrayEnteros[a]) {
				mayor=arrayEnteros[a];
			}
			
		}
		System.out.println("El número más grande es: " +mayor);
		
	}

}
