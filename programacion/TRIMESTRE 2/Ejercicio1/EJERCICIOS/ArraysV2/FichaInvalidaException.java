package ArraysV2;

public class FichaInvalidaException extends Exception{
	
	public FichaInvalidaException() {
		super("ERROR: La ficha no existe.");
	}

}
