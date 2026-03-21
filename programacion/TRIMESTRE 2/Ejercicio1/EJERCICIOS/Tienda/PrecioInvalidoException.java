package Tienda;

// Excepción que se lanza cuando se introduce un precio negativo
public class PrecioInvalidoException extends Exception {

    public PrecioInvalidoException() {
        super("ERROR: El precio no puede ser negativo.");
    }
}
