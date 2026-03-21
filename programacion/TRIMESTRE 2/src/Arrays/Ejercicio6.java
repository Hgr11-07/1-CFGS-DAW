package Arrays;

public class Ejercicio6 {
	
	public static void main(String[] args) {
		
		int arrayEnteros[] = {2, 30, 4, 10, 70, 55, 32, 80, 99, 87};
		int par=0;
		int impar=0;
		
		for(int i=0; i<arrayEnteros.length; i++) {
			
			if(arrayEnteros[i]%2==0) {
				par++;
			} else {
				impar++;
			}	
		}
		System.out.println("Hay " +par+ " números pares y " +impar+ " números impares.");
	}

}
