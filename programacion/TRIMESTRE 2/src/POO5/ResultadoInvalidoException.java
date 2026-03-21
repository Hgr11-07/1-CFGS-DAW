package POO5;

// Excepción que se lanza cuando el formato del resultado no es correcto (ej: "abc")
public class ResultadoInvalidoException extends Exception {

    public ResultadoInvalidoException() {
        super("ERROR: El formato del resultado no es válido. Use el formato 'X-Y' (ej: 2-1)");
    }
}
