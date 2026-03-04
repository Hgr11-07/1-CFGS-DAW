package POO5;

// Excepción que se lanza cuando se intenta crear un partido con dos equipos iguales
public class EquiposIgualesException extends Exception {

    public EquiposIgualesException() {
        super("ERROR: Los dos equipos del partido no pueden ser el mismo.");
    }
}
