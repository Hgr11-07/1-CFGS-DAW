package Ejercicio1;

import java.util.*;

public class Ejercicio_1 {
	
	private static Scanner teclado=new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Rectangulo rectangulito=new Rectangulo();
		
		double ancho;
		double largo;
		double area;
		double perimetro;
		
		try {
			System.out.println("Introduce el ancho del rectangulo");
			ancho=teclado.nextDouble();
			
			System.out.println("Introduce el largo del rectangulo");
			largo=teclado.nextDouble();
			
			rectangulito.setAncho(ancho);
			rectangulito.setLongitud(largo);
			area=rectangulito.calcularArea();
			perimetro=rectangulito.calcularPerimetro();
			System.out.println("El area es: " +area);
			System.out.println("El perímetro es: " +perimetro);
			
		} catch(InputMismatchException e) {
			System.out.println("Introduce un número válido. " +e);
		} finally {
			System.out.println("Programa finalizado.");
		}
		
		
		
	}
}
