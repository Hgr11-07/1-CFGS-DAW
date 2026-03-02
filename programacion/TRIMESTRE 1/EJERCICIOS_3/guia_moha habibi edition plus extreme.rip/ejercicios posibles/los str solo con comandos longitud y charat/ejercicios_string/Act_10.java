package ejercicios_string;

import java.util.Scanner;

public class Act_10 {

    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

        // Pedir 10 URLs usando for (simple y permitido)
        for (int i = 0; i < 10; i++) {
            String url = pedirTexto();
            comprobar(url);
        }
    }

    private static String pedirTexto() {
        System.out.println("Introduce la dirección web:");
        String texto = teclado.nextLine();
        return texto;
    }

    private static boolean esValida(String url) {

        // 1. Comprobar longitud mínima
        if (url.length() < 15) {
            return false;
        }

        // 2. Comprobar que empieza por "http://www."
        String inicio = "http://www.";

        for (int i = 0; i < inicio.length(); i++) {
            if (url.charAt(i) != inicio.charAt(i)) {
                return false;
            }
        }

        // 3. Comprobar que termina en ".es" o ".com"
        int ult = url.length() - 1;

        boolean terminaEs = false;
        boolean terminaCom = false;

        // Para ".es"
        if (ult >= 2) {
            if (url.charAt(ult) == 's' &&
                url.charAt(ult - 1) == 'e' &&
                url.charAt(ult - 2) == '.') {
                terminaEs = true;
            }
        }

        // Para ".com"
        if (ult >= 3) {
            if (url.charAt(ult) == 'm' &&
                url.charAt(ult - 1) == 'o' &&
                url.charAt(ult - 2) == 'c' &&
                url.charAt(ult - 3) == '.') {
                terminaCom = true;
            }
        }

        if (!terminaEs && !terminaCom) {
            return false;
        }

        // 4. Comprobar la "dirección" entre "www." y la extensión
        // Debe tener al menos 1 letra o número y empezar con letra.

        int inicioDireccion = 11; // después de "http://www." (11 caracteres)
        int finDireccion = ult - 3; // antes de ".es" (3 chars) o ".com" (4 chars)
        if (terminaCom) {
            finDireccion = ult - 4;
        }

        // longitud mínima: al menos 1 carácter
        if (finDireccion < inicioDireccion) {
            return false;
        }

        // 4.1 La primera debe ser letra
        char primera = url.charAt(inicioDireccion);
        boolean esLetra = (primera >= 'A' && primera <= 'Z') ||
                          (primera >= 'a' && primera <= 'z');

        if (!esLetra) {
            return false;
        }

        // 4.2 Las demás pueden ser letras o números (sin espacios)
        for (int i = inicioDireccion; i <= finDireccion; i++) {
            char c = url.charAt(i);

            boolean letra = (c >= 'A' && c <= 'Z') ||
                            (c >= 'a' && c <= 'z');
            boolean numero = (c >= '0' && c <= '9');

            if (!letra && !numero) {
                return false;
            }
        }

        return true; // Si pasó todas las pruebas, es válida
    }

    private static void comprobar(String url) {
        if (esValida(url)) {
            System.out.println(url + " --> ES válida");
        } else {
            System.out.println(url + " --> NO es válida");
        }
    }
}
