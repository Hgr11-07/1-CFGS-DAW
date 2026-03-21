package POO4;

// Excepción personalizada que se lanza cuando se introduce un número negativo o cero
// donde se esperaba un valor positivo (por ejemplo, la capacidad de una jarra)
public class NumNegativoException extends Exception {
	
	// Constructor: llama al constructor de Exception con un mensaje descriptivo
	public NumNegativoException() {
		super("El número debe ser positivo.");
	}
}
