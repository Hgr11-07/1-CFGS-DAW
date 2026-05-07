package Tema11_Ej3;
import java.time.LocalDate;
import java.util.*;

public class Ejercicio3 {
	
	public static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Historial h = new Historial();
		int opcion;
		
		mostrarMenu();
		opcion=pedirEntero("¿Qué desea hacer? (1-5):");
		System.out.println();
		
		while(opcion!=5) {
			
			tratarMenu(h, opcion);
			
			mostrarMenu();
			opcion=pedirEntero("¿Qué desea hacer? (1-5):");
			System.out.println();
		}
		
		System.out.println("PROGRAMA FINALIZADO.");
		
	}
	
	public static void mostrarMenu() {
		System.out.println("--MENÚ--");
		System.out.println();
		System.out.println("1. Nueva página consultada.");
		System.out.println("2. Consultar historial completo.");
		System.out.println("3. Consultar historial de un día.");
		System.out.println("4. Borrar historial completo.");
		System.out.println("5. Salir");
		System.out.println();
	}
	
	public static void tratarMenu(Historial h, int opcion) {
		
		String url;
		int dia;
		int mes;
		int año;
		LocalDate buscar;
		Pagina p;
		
			switch(opcion) {
			case 1:
				try {
					System.out.println("Introduzca la URL: ");
					url=teclado.nextLine();
					System.out.println();
					p = new Pagina(url);
					h.insertarPagina(p);
				} catch(PaginaWebException e) {
					System.out.println(e);
				}
				break;
				
			case 2:
				h.consultarHistorial();
				break;
			case 3:
				System.out.println("Introduce: ");
				dia=pedirEntero("Dia: ");
				mes=pedirEntero("Mes: ");
				año=pedirEntero("Año: ");
				buscar= LocalDate.of(año, mes, dia);
				h.consultarHistoriaDia(buscar);
				break;
			case 4:
				h.borrarHistorial();
				break;
			}
			
			
		}
	
	public static int pedirEntero(String mensaje) {
		
		int n;
		System.out.println(mensaje);
		n=teclado.nextInt();
		teclado.nextLine();
		return n;
		
	}

}
