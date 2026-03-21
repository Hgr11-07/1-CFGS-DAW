package ExamenTema4;

public class ProductoInvalidoException extends Exception{	//Excepcion personalizada que extiende de la clase Exception

	public ProductoInvalidoException() {	//Constructor que llama al de la superclase e imprime un mensaje.
		super ("ERROR: El producto posee atributos inválidos.");
	}
	
}
