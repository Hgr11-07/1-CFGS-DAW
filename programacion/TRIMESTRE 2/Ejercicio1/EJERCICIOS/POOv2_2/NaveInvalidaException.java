package POOv2_2;

public class NaveInvalidaException extends Exception{

	public NaveInvalidaException() {
		
		super("ERROR: El número de la nave es incorrecto (1-5).");
		
	}
	
}
