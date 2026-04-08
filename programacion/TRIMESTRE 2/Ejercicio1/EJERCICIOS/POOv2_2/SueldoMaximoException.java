package POOv2_2;

public class SueldoMaximoException extends Exception{
	
	public SueldoMaximoException() {
		super("ERROR: El sueldo no puede superar el sueldo máximo.");
	}
	
}
