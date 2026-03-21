package Arrays;

public class Ejercicio2 {

	public static void main(String [] args) {
		
		double arrayReal[]= {1.5, 20, 98.9, 23, 0.1};
		double suma=0;
		double media=0;
		
		for(int i=0; i<arrayReal.length; i++) {
		
		suma=suma+arrayReal[i];
		media=suma;
		}
		media=media/arrayReal.length;
		System.out.println("La suma es: "+suma);
		System.out.println("La media es: "+media);
	}
}
