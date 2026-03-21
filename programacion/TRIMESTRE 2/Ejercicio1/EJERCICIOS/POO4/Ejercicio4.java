package POO4;

import java.util.*;

public class Ejercicio4 {
	
	public static Scanner teclado = new Scanner(System.in); // Scanner compartido por todos los métodos
	
	public static void main(String[] args) throws NumNegativoException {
		
		// Variables para almacenar los datos de las dos jarras
		int capacidad1 = 0;
		int agua1 = 0;
		int capacidad2 = 0;
		int agua2 = 0;
		int menu;
		char opcion;
		boolean correcto = false; // Bandera para controlar si la entrada fue válida
		Jarra jarra1 = null;
		Jarra jarra2 = null;
		int total=0;
		
		// Bucle que sigue pidiendo la capacidad de la jarra1 hasta que sea válida (positiva)
		while(!correcto) {
			try {
				capacidad1 = pedirCosas("Introduce la capacidad de la primera jarra: ");
				jarra1 = new Jarra(capacidad1, agua1); // Si capacidad <= 0 lanza NumNegativoException
				correcto = true; // Solo llega aquí si no hubo excepción
			} catch(NumNegativoException n) {
				System.out.println(n); // Muestra el mensaje de error
				// No hacemos nada más: el while vuelve a pedir un número nuevo
			}
		}
		correcto = false; // Reiniciamos la bandera para usarla con la segunda jarra
		
		// Bucle que sigue pidiendo la capacidad de la jarra2 hasta que sea válida
		while(!correcto) {
			try {
				capacidad2 = pedirCosas("Introduce la capacidad de la segunda jarra: ");
				jarra2 = new Jarra(capacidad2, agua2); // Si capacidad <= 0 lanza NumNegativoException
				correcto = true; // Solo llega aquí si no hubo excepción
			} catch(NumNegativoException m) {
				System.out.println(m); // Muestra el mensaje de error
				// No hacemos nada más: el while vuelve a pedir un número nuevo
			}
		}
		
		// Mostramos el menú por primera vez antes de entrar al bucle principal
		printMenu();
		menu = pedirCosas("¿Qué desea hacer?");
		
		// Bucle principal: se repite hasta que el usuario elija la opción 6 (salir)
		while(menu != 6) {
			
			switch(menu) {
			
			case 1: // Llenar una jarra a tope
				opcion = pedirOpcion("¿Qué jarra? (A/B)");
				opcion = Character.toUpperCase(opcion); // Normalizamos a mayúsculas
				if(opcion == 'A') {
					if(jarra1.getAgua()==jarra1.getCapacidad()) {
						System.out.println("La jarra ya está llena");
					}else if(jarra1.getAgua()!=0){
						total+=(jarra1.getCapacidad()-jarra1.getAgua());
						jarra1.llenarJarra();
					}else {
						total+=jarra1.getCapacidad();
						jarra1.llenarJarra();
					}
					
				} else {
					
					if(jarra2.getAgua()==jarra2.getCapacidad()) {
						System.out.println("La jarra ya está llena");
					}else if(jarra2.getAgua()!=0) {
						total+=(jarra2.getCapacidad()-jarra2.getAgua());
						jarra2.llenarJarra();
					}else {
						jarra2.llenarJarra();
						total+=jarra2.getCapacidad();
					}
					
				}
				break;
				
			case 2: // Vaciar una jarra por completo
				opcion = pedirOpcion("¿Qué jarra? (A/B)");
				opcion = Character.toUpperCase(opcion);
				if(opcion == 'A') {
					jarra1.vaciarJarra();
				} else {
					jarra2.vaciarJarra();
				}
				break;
			
			case 3: // Volcar el contenido de jarra1 en jarra2
				volcarJarra1en2(jarra1, jarra2);
				break;
			
			case 4: // Volcar el contenido de jarra2 en jarra1
				volcarJarra2en1(jarra1, jarra2);
				break;
				
			case 5: // Mostrar cuánta agua tiene cada jarra
				System.out.println("La primera jarra tiene " + jarra1.getAgua() + "L");
				System.out.println("La segunda jarra tiene " + jarra2.getAgua() + "L");
				break;
				
			default: // Opción no reconocida, pedimos de nuevo
				menu = pedirCosas("Introduce una opcion válida.");
			}
			
			// Al final de cada iteración volvemos a mostrar el menú y pedimos opción
			printMenu();
			menu = pedirCosas("¿Qué desea hacer?");
		}
		
		System.out.println("El total de agua que se ha gastado llenando jarras es " +total+ " litros.");
		System.out.println("Hasta luego.");
	}
	
	// Método genérico para pedir un número entero mostrando un mensaje
	public static int pedirCosas(String mensaje) {
		int n;
		System.out.println(mensaje);
		n = teclado.nextInt();
		return n;
	}
	
	// Método que imprime las opciones del menú
	public static void printMenu() {
		System.out.println("--MENU--");
		System.out.println("1. LLENAR JARRA");
		System.out.println("2. VACIAR JARRA");
		System.out.println("3. VOLCAR JARRA A EN B");
		System.out.println("4. VOLCAR JARRA B EN A");
		System.out.println("5. VER ESTADO DE LAS JARRAS");
		System.out.println("6. SALIR");
	}
	
	// Método para pedir al usuario que elija entre jarra A o jarra B
	// Filtra entradas inválidas en un bucle hasta recibir 'A' o 'B'
	public static char pedirOpcion(String mensaje) {
		char c;
		System.out.println(mensaje);
		c = teclado.next().charAt(0);
		
		while(Character.toUpperCase(c) != 'A' && Character.toUpperCase(c) != 'B') {
			System.out.println("Introduzca una opcion valida");
			c = teclado.next().charAt(0);
		}
		return c;
	}
	
	// Vuelca el agua de jarra1 en jarra2.
	// Si el agua total cabe en jarra2, se transfiere todo y jarra1 queda vacía.
	// Si no cabe, se llena jarra2 hasta su capacidad y jarra1 conserva el resto.
	public static void volcarJarra1en2(Jarra jarra1, Jarra jarra2) {
		if(jarra1.getAgua() + jarra2.getAgua() <= jarra2.getCapacidad()) {
			jarra2.setAgua(jarra2.getAgua() + jarra1.getAgua());
			jarra1.vaciarJarra();
		} else {
			jarra1.setAgua(jarra1.getAgua() - (jarra2.getCapacidad() - jarra2.getAgua()));
			jarra2.llenarJarra();
		}
	}
	
	// Vuelca el agua de jarra2 en jarra1.
	// Si el agua total cabe en jarra1, se transfiere todo y jarra2 queda vacía.
	// Si no cabe, se llena jarra1 hasta su capacidad y jarra2 conserva el resto.
	public static void volcarJarra2en1(Jarra jarra1, Jarra jarra2) {
		if(jarra2.getAgua() + jarra1.getAgua() <= jarra1.getCapacidad()) {
			jarra1.setAgua(jarra1.getAgua() + jarra2.getAgua());
			jarra2.vaciarJarra();
		} else {
			jarra2.setAgua(jarra2.getAgua() - (jarra1.getCapacidad() - jarra1.getAgua()));
			jarra1.llenarJarra();
		}
	}
}
