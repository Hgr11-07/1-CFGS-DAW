package Tienda;

// Excepción que se lanza cuando la puntuación no está entre 0 y 10
public class PuntuacionInvalidaException extends Exception {

    public PuntuacionInvalidaException() {
        super("ERROR: La puntuación debe estar entre 0 y 10.");
    }
}
