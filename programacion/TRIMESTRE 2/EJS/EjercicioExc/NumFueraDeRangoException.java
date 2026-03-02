package EjercicioExc;

public class NumFueraDeRangoException extends Exception{
	
	public NumFueraDeRangoException(){
		super("Introduce un número dentro del rango.");
	}
}
