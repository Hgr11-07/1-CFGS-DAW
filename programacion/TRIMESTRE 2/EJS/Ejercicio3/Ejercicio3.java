package Ejercicio3;

import java.util.*;

public class Ejercicio3 {
	
	private static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int opcion;
		Maquina maquina1 = new Maquina();
		
		System.out.println("Bienvenido a la máquina de café.");
		System.out.println();
		
		do {
			mostrarMenú();
			opcion = opcionMenú();
			accionesMenú(opcion, maquina1);
		} while(opcion != 5);
		
		System.out.println("Máquina apagada.");
	}
	
	public static double pedirDinero() {
		
		double dinero;
		System.out.println("¿Cuánto dinero desea introducir?");
		dinero = teclado.nextDouble();
		
		while(dinero < 0) {
			System.out.println("No puedes introducir esa cantidad.");
			System.out.println("¿Cuánto dinero desea introducir?");
			dinero = teclado.nextDouble();
		}
		
		return dinero;
	}
	
	public static void mostrarMenú() {
		System.out.println("MENÚ");
		System.out.println("1. Servir café solo (1 euro).");
		System.out.println("2. Servir leche sola (0.80 euros).");
		System.out.println("3. Servir café con leche (1.5 euros)");
		System.out.println("4. Consultar estado de la máquina.");
		System.out.println("5. Apagar máquina y salir.");
		System.out.print("Seleccione una opción: ");
	}
	
	public static int opcionMenú() {
		
		int opcion;
		
		opcion = teclado.nextInt();
		
		while(opcion < 1 || opcion > 5) {
			System.out.println("Opción no válida.");
			System.out.print("Seleccione una opción (1-5): ");
			opcion = teclado.nextInt();
		}
		
		return opcion;
	}
	
	public static void accionesMenú(int opcion, Maquina maquina) {
		
		double dinero;
		
		switch(opcion) {
			case 1: {
				dinero = pedirDinero();
				maquina.setDineroUsuario(dinero);
				maquina.echarseCafeSolo();
				break;
			}
			case 2: {
				dinero = pedirDinero();
				maquina.setDineroUsuario(dinero);
				maquina.echarseLeche();
				break;
			}
			case 3: {
				dinero = pedirDinero();
				maquina.setDineroUsuario(dinero);
				maquina.echarseCafeLeche();
				break;
			}
			case 4: {
				maquina.consultarMaquina();
				break;
			}
			case 5: {
				break;
			}
		}
	}
}
