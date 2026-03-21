package Arrays;

public class Ejercicio1 {

	public static void main(String[] args) {
		
		int array[]= {10, 2, 35, 41, 6};
		
		System.out.println("CON FOR:");
		System.out.println();
		for(int a=0; a<array.length; a++) {
			int mostrar=a+1;
			System.out.println("Elemento " +mostrar+ ": " +array[a]);
			
		}
		System.out.println();
		System.out.println("CON FOR EACH:");
		System.out.println();
		int n=1
				
				
				;
		for(int num : array) {
			System.out.println("Elemento " +n+ ": " +num);
			n++;
		}
	}
}
