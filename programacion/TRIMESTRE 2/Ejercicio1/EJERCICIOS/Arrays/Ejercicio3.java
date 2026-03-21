package Arrays;

public class Ejercicio3 {

	public static void main(String[] args) {
		
		int[] numeros= {4, -3, 7, 0, -2, 8};
		int contPositivo=0;
		int contNegativo=0;
		
		
		for(int i=0; i<numeros.length; i++) {
			
			if(numeros[i]>0) {
				contPositivo++;
			}
		}
		
		System.out.println("Hay " +contPositivo+ " positivos.");
		
	}
}
