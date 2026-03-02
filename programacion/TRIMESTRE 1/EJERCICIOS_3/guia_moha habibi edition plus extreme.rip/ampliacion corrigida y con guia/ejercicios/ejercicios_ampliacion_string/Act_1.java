//1. Realizar un programa que lea en una cadena el nombre completo de una persona (nombre y
//apellidos) y muestre por pantalla el nombre, apellido1 y apellido2. Si el nombre completo no es
//correcto mostrará un mensaje de error.
//Introduce el nombre completo: PEDRO PEREZ ALVAREZ
//El nombre es: PEDRO
//El primer apellido es:PEREZ
//El segundo apellido es: ALVAREZ
package ejercicios_ampliacion_string;
import java.util.Scanner;
public class Act_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el nombre completo: ");
        String linea = sc.nextLine();

        // Variables para ir guardando las 3 partes
        String nombre = "";
        String apellido1 = "";
        String apellido2 = "";

        int len = linea.length();

        // Comprobación rápida: no aceptamos espacios al inicio ni al final
        // (no usamos trim()).
        if (len == 0 || linea.charAt(0) == ' ' || linea.charAt(len - 1) == ' ') {
            System.out.println("Error: el formato del nombre no es correcto.");
            sc.close();
            return;
        }

        int tokenCount = 0;    // contará cuántos tokens (palabras) aparecen
        boolean inToken = false; // indica si estamos dentro de una palabra
        char c;

        for (int i = 0; i < len; i++) {
            c = linea.charAt(i);

            if (c == ' ') {
                // Si encontramos un espacio mientras NO estábamos en token:
                // significa que hay dos espacios seguidos -> formato inválido.
                if (!inToken) {
                    System.out.println("Error: hay espacios consecutivos o formato incorrecto.");
                    sc.close();
                    return;
                }
                // Si sí estábamos en un token, lo cerramos.
                tokenCount++;
                inToken = false;

                // Si ya hemos cerrado 3 tokens y aparece otro espacio o más texto,
                // entonces hay más de 3 partes -> error.
                if (tokenCount >= 3) {
                    System.out.println("Error: el nombre completo debe contener exactamente nombre y dos apellidos (3 palabras).");
                    sc.close();
                    return;
                }
            } else {
                // Carácter que forma parte de una palabra
                if (!inToken) {
                    // empezamos un nuevo token
                    inToken = true;
                }

                // según el token actual (tokenCount indica cuántos ya cerramos),
                // añadimos el carácter al String correspondiente.
                if (tokenCount == 0) {
                    nombre = nombre + c;       // primera palabra
                } else if (tokenCount == 1) {
                    apellido1 = apellido1 + c; // segunda palabra
                } else if (tokenCount == 2) {
                    apellido2 = apellido2 + c; // tercera palabra
                } else {
                    // Si tokenCount > 2 significa que ya había más de 3 tokens
                    // (aunque el código debería haber salido antes), ponemos error.
                    System.out.println("Error: el nombre completo debe contener exactamente nombre y dos apellidos (3 palabras).");
                    sc.close();
                    return;
                }
            }
        }

        // Si al final estábamos dentro de un token, lo cerramos (no había espacio final porque lo comprobamos).
        if (inToken) {
            tokenCount++;
        }

        // Debe haber exactamente 3 tokens
        if (tokenCount != 3) {
            System.out.println("Error: formato incorrecto. Debe introducir: nombre + primer apellido + segundo apellido (separados por un solo espacio).");
            sc.close();
            return;
        }

        // Mostrar resultado
        System.out.println("El nombre es: " + nombre);
        System.out.println("El primer apellido es: " + apellido1);
        System.out.println("El segundo apellido es: " + apellido2);

        sc.close();
    }
}

