package EjercicioExc;

public class CaracterInvalidoException extends Exception{
	
	public CaracterInvalidoException(){
		super ("Error. Introduce un caracter válido");
	}
}
