package POOv2_2;

public class SueldoNegativoException extends Exception{
	
	public SueldoNegativoException() {
		
		super("ERROR: El sueldo no puede ser menor que 0.");
		
	}

}
