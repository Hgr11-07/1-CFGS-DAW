package EjercicioExc;

import java.util.*;

public class MiEntradaSalida {
	
	private static Scanner teclado = new Scanner(System.in);

	//Solicita un número entero. Controla errores de formato (letras en lugar de números).
	public static int solicitarEntero(String mensaje) {
		int num = 0;
		boolean correcto = false;
		while(!correcto) {
			try {
				System.out.println(mensaje);
				num = teclado.nextInt(); // Intento de lectura de entero
				correcto = true;         // Si llega aquí, el dato es válido
                teclado.nextLine();      // Limpieza del salto de línea del buffer
			} catch (Exception e){
				System.out.println("Error. Introduce un número entero. " + e);
				teclado.nextLine();      // Limpieza del buffer en caso de error de entrada
			}	
		}
		return num;
	}
	
	//Solicita un entero mayor que cero. Lanza excepción propia si es negativo o cero.
	public static int solicitarEnteroPositivo(String mensaje) throws NumNegativoException {
		int num = 0;
		boolean correcto = false;
		while(!correcto) {
			try {
				System.out.println(mensaje);
				num = teclado.nextInt();
				if(num > 0) {
					correcto = true;
                    teclado.nextLine();
				} else {
					// Disparo manual de excepción personalizada para lógica de negocio
					throw new NumNegativoException();
				}
			} catch (NumNegativoException n) {
				System.out.println("Error: " + n); // Captura específica de error negativo
			} catch (Exception e) {
				System.out.println("Error: " + e); // Captura de error de formato
				teclado.nextLine();
			}
		}
		return num;
	}
	
	//Solicita un entero dentro de unos límites. Valida el rango mediante excepciones.
	public static int solicitarNumeroEnRango(String mensaje, int limInf, int limSup) throws NumFueraDeRangoException {
		int num = 0;
		boolean correcto = false;
		while(!correcto) {
			try {
				System.out.println(mensaje);
				num = teclado.nextInt();
				if(num >= limInf && num <= limSup) {
					correcto = true;
                    teclado.nextLine();
				} else {
					throw new NumFueraDeRangoException();
				}
			} catch(NumFueraDeRangoException r) {
				System.out.println("Error: " + r);
			} catch (Exception e) {
				System.out.println("Error: " + e);
				teclado.nextLine();
			}
		}
		return num;
	}
	
	//Solicita un carácter único. Valida que la longitud de la entrada sea exactamente 1.
	public static char solicitarCaracter(String mensaje) throws LongitudInvalidaException {
		char c = ' ';
		String comprobar;
		boolean correcto = false;
		while(!correcto) {
			try {
				System.out.println(mensaje);
				comprobar = teclado.nextLine(); 
				if(comprobar.length() != 1) {
					throw new LongitudInvalidaException();
				} else {
					c = comprobar.charAt(0);
					correcto = true;
				}
			} catch(LongitudInvalidaException l) {
				System.out.println("Error: " + l);
			}
		}
		return c;
	}
	
	//Solicita 'S' o 'N'. Valida tanto la longitud como el contenido del carácter.
	public static char solicitarCaracterSN(String mensaje) throws LongitudInvalidaException, CaracterInvalidoException {
		char c = ' ';
		String comprobar;
		boolean correcto = false;
		while(!correcto) {
			try {
				System.out.println(mensaje);
				comprobar = teclado.nextLine().toUpperCase(); // Normalización a mayúsculas
				if(comprobar.length() != 1) {
					throw new LongitudInvalidaException();
				} else if (!comprobar.equals("S") && !comprobar.equals("N")) {
					// Validación de contenido específico mediante excepción personalizada
					throw new CaracterInvalidoException();
				} else {
					c = comprobar.charAt(0);
					correcto = true;
				}
			} catch(LongitudInvalidaException l) {
				System.out.println("Error longitud: " + l);
			} catch(CaracterInvalidoException ch) {
				System.out.println("Error carácter: " + ch);
			}
		}
		return c;
	}
	
	//Solicita una cadena de texto. Asegura que la entrada no sea un String vacío.
	public static String solicitarCadena(String mensaje) throws LongitudInvalidaException {
		String s = "";
		boolean correcto = false;
		while(!correcto) {
			try {
				System.out.println(mensaje);
				s = teclado.nextLine();
				if(s.length() < 1) {
					throw new LongitudInvalidaException();
				} else {
                    correcto = true; // Confirmación de salida del bucle
                }
			} catch(LongitudInvalidaException lon) {
				System.out.println("Error: Cadena vacía. " + lon);
			}
		}
		return s;
	}
}