package Poo2;
import java.util.*;

public class Ejercicio2 {
	
	public static Scanner teclado=new Scanner(System.in);
	
	public static void main(String[] args) {
		
		boolean correcto = false;
		int opcion;
		Linea linea1 = null;
		
		System.out.println("Introduce las coordenadas de la línea: ");
		System.out.println("Primer punto:");
		double ax = pedirPuntos("Coordenada x:");
		double ay = pedirPuntos("Coordenada Y:");
		System.out.println("Segundo punto:");
		double bx = pedirPuntos("Coordenada x:");
		double by = pedirPuntos("Coordenada Y:");

		Punto puntoA = new Punto(ax, ay);
		Punto puntoB = new Punto(bx, by);
	    while(!correcto) {
		   try {
		   linea1 = new Linea(puntoA, puntoB);
		   correcto = true;
		    } catch (PuntosIgualesException e) {
		        System.out.println(e);
		        System.out.println("Segundo punto:");
		        bx = pedirPuntos("Coordenada x:");
		        by = pedirPuntos("Coordenada Y:");
		        puntoB = new Punto(bx, by);
		    	}
        	}
	    System.out.println();
	    System.out.println();
	    System.out.println();
	    System.out.println();
	    menu();
	    opcion=pedirOpcion("Introduce tu opcion");
	    tratarMenu(opcion, linea1);

	}
	
	public static double pedirPuntos(String mensaje) {
		double punto;
		System.out.println(mensaje);
		punto=teclado.nextDouble();
		return punto;
	}
	
	public static void menu() {
		
		System.out.println("--MENU--");
		System.out.println();
		System.out.println("1. Mover línea.");
		System.out.println("2. Mostrar línea.");
		System.out.println("3. Salir");
		
	}
	
	public static int pedirOpcion(String mensaje) {
		int o;
		System.out.println(mensaje);
		o=teclado.nextInt();
		return o;
	}
	
	public static void tratarMenu(int opcion, Linea linea1) {
		
		char direccion;
		double distancia;
		
		while(opcion!=3) {
			
			switch(opcion) {
			
			case 1:
				
				direccion=pedirDireccion();
				direccion = Character.toUpperCase(direccion);
				
				switch(direccion) {
	
				case 'A':
					distancia=pedirPuntos("Introduce la distancia a mover: ");
					linea1.moverArriba(distancia);
					break;
				case 'B':
					distancia=pedirPuntos("Introduce la distancia a mover: ");
					linea1.moverAbajo(distancia);
					break;
				case 'I':
					distancia=pedirPuntos("Introduce la distancia a mover: ");
					linea1.moverIzquierda(distancia);
					break;
				case 'D':
					distancia=pedirPuntos("Introduce la distancia a mover: ");
					linea1.moverDerecha(distancia);
					break;
				default:
				    System.out.println("Opción no válida, intenta de nuevo.");
				}
				
				break;
			
			case 2:
				System.out.println(linea1.mostrarLinea());
				break;
				
			default:
			    System.out.println("Opción no válida, intenta de nuevo.");
			
			}
			menu();
			opcion=pedirOpcion("Introduce tu opción: ");
		}
		System.out.println("Hasta luego.");
	}
	
	public static char pedirDireccion() {
		
		char c;
		System.out.println("¿Hacia qué dirección? (A-Arriba, B-Abajo, I-Izquierda, D-Derecha): ");
		c=teclado.next().charAt(0);
		return c;
	}

}
