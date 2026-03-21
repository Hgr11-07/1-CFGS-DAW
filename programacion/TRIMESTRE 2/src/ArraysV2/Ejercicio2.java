package ArraysV2;
import java.util.*;
 
public class Ejercicio2 {
	
	// Scanner compartido para toda la clase
	public static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		boolean correcto = false;
		Jugador jugadores[] = new Jugador[2];   // Array con los 2 jugadores
		char tablero[][] = new char[10][10];    // Tablero de 10x10
		Random random = new Random();
		int turno = random.nextInt(2) + 1;      // Turno inicial aleatorio: 1 o 2
		
		// Registro de los 2 jugadores con validación de ficha
		for (int i = 0; i < jugadores.length; i++) {
			correcto = false;
			while (!correcto) {
				try {
					String nombre = pedirNombre("Introduce el nombre del jugador: ");
					char ficha = pedirFicha("¿Qué ficha desea?");
					jugadores[i] = new Jugador(nombre, ficha); // Lanza excepción si la ficha no es R ni A
					teclado.nextLine(); // Limpiamos el teclado
					correcto = true;
					
				} catch (FichaInvalidaException e) {
					System.out.println(e);
					teclado.nextLine();
				}
			}
		}
		
		// Verificar que ambos jugadores no tengan la misma ficha
		while (jugadores[0].getFicha() == jugadores[1].getFicha()) {
			char ficha = pedirFicha("Introduce una ficha diferente: ");
			try {
				jugadores[1].setFicha(ficha);
			} catch (FichaInvalidaException e) {
				System.out.println(e);
			}
		}
		
		// Inicializar el tablero con espacios vacíos
		rellenarTablero(tablero);
		
		// Bucle principal del juego: continúa mientras no haya ganador ni tablero lleno
		while (!hayGanador(tablero) && !tableroLleno(tablero)) {
			hacerTurno(tablero, jugadores, turno);
			// Alternar turno entre jugador 1 y jugador 2
			if (turno == 1) {
				turno = 2;
			} else {
				turno = 1;
			}
		}
		
		// Mostrar tablero final
		mostrarTablero(tablero);
		
		// Determinar resultado: victoria o empate
		// Al salir del while, turno ya cambió al siguiente jugador,
		// por eso el ganador es el jugador contrario al turno actual
		if (hayGanador(tablero)) {
			switch (turno) {
				case 1:
					System.out.println("Ganó " + jugadores[1].getNombre());
					break;
				case 2:
					System.out.println("Ganó " + jugadores[0].getNombre());
			}
		} else {
			System.out.println("El juego acabó en empate.");
		}
	}
	
	// Pide y devuelve el nombre del jugador
	public static String pedirNombre(String mensaje) {
		String s;
		System.out.println(mensaje);
		s = teclado.nextLine();
		return s;
	}
	
	// Pide y devuelve un carácter de ficha (R o A)
	public static char pedirFicha(String mensaje) {
		char c;
		System.out.println(mensaje);
		c = teclado.next().charAt(0);
		return c;
	}
	
	// Pide y valida una columna entre 1 y 10
	public static int pedirColumna(String mensaje) {
		int n;
		System.out.println(mensaje);
		n = teclado.nextInt();
		while (n < 1 || n > 10) { // Repetir si el valor está fuera de rango
			System.out.println(mensaje);
			n = teclado.nextInt();
		}
		return n;
	}
	
	// Rellena el tablero entero con espacios
	public static void rellenarTablero(char tablero[][]) {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				tablero[i][j] = ' ';
			}
		}
	}
	
	// Muestra el tablero por pantalla con separadores visuales
	public static void mostrarTablero(char tablero[][]) {
		System.out.println(" 1 2 3 4 5 6 7 8 9 10"); // Cabecera con números de columna
		for (int i = 0; i < tablero.length; i++) {
			System.out.print("|");
			for (int j = 0; j < tablero[i].length; j++) {
				System.out.print(tablero[i][j] + "|");
			}
			System.out.println();
			for (int k = 0; k <= 20; k++) { // Línea separadora entre filas
				System.out.print("-");
			}
			System.out.println();
		}
	}
	
	// Devuelve true si todas las celdas del tablero están ocupadas
	public static boolean tableroLleno(char tablero[][]) {
		int vacia = 0;
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				if (tablero[i][j] == ' ') {
					vacia++;
				}
			}
		}
		if (vacia > 0)
			return false;
		else
			return true;
	}
	
	// Devuelve true si algún jugador tiene 4 fichas seguidas en horizontal o vertical
	public static boolean hayGanador(char tablero[][]) {
		
		int k;
		int encontrado;
		
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				
				// Comprobar 4 en raya HORIZONTAL desde la celda [i][j]
				k = 1;
				encontrado = 1;
				if (tablero[i][j] != ' ' && j + 3 < tablero[i].length) {
					while (j + k < tablero[i].length && tablero[i][j + k] == tablero[i][j]) {
						k++;
						encontrado++;
					}
				}
				if (encontrado == 4)
					return true;
				
				// Comprobar 4 en raya VERTICAL desde la celda [i][j]
				k = 1;
				encontrado = 1;
				if (tablero[i][j] != ' ' && i + 3 < tablero.length) {
					while (i + k < tablero.length && tablero[i + k][j] == tablero[i][j]) {
						k++;
						encontrado++;
					}
				}
				if (encontrado == 4)
					return true;
			}
		}
		return false;
	}
	
	// Gestiona el turno de un jugador: muestra el tablero, pide columna y coloca la ficha
	public static void hacerTurno(char tablero[][], Jugador jugadores[], int turno) {
		
		int columna;
		
		if (turno == 1) {
			System.out.println("Turno de " + jugadores[0].getNombre());
		} else {
			System.out.println("Turno de " + jugadores[1].getNombre());
		}
		mostrarTablero(tablero);
		columna = pedirColumna("¿Dónde desea colocar la ficha (1-10)?");
		colocarFicha(tablero, columna, turno, jugadores);
	}
	
	// Coloca la ficha del jugador actual en la posición más baja disponible de la columna
	// Si la columna está llena, pide otra columna al jugador
	public static void colocarFicha(char tablero[][], int columna, int turno, Jugador jugadores[]) {
		
		boolean colocada = false;
		
		while (!colocada) {
			if (tablero[0][columna - 1] != ' ') {
				// La fila 0 de esa columna está ocupada -> columna llena
				columna = pedirColumna("La columna está llena, elige otra (1-10):");
			} else {
				// Recorrer de abajo hacia arriba hasta encontrar la primera celda vacía
				for (int i = tablero.length - 1; i >= 0; i--) {
					if (tablero[i][columna - 1] == ' ') {
						tablero[i][columna - 1] = jugadores[turno - 1].getFicha();
						colocada = true;
						break;
					}
				}
			}
		}
	}
}