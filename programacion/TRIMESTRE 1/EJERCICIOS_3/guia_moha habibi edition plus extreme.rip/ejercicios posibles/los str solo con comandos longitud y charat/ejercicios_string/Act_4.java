package ejercicios_string;

import java.util.Scanner;

public class Act_4 {

    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

        String frase, palabra;

        frase = pedirFrase();
        palabra = pedirPalabra();

        encontrada(frase, palabra);
    }

    private static String pedirFrase() {
        System.out.println("Introduce una frase: ");
        String frase = teclado.nextLine();

        String resultado = "";

        // Pasar todo a minúsculas sin usar métodos prohibidos
        for (int i = 0; i < frase.length(); i++) {
            char c = frase.charAt(i);

            if (c >= 'A' && c <= 'Z') {
                resultado = resultado + (char)(c + 32);
            } else {
                resultado = resultado + c;
            }
        }

        return resultado;
    }

    private static String pedirPalabra() {
        System.out.println("Introduce una palabra: ");
        String palabra = teclado.nextLine();

        String resultado = "";

        // Pasar todo a minúsculas
        for (int i = 0; i < palabra.length(); i++) {
            char c = palabra.charAt(i);

            if (c >= 'A' && c <= 'Z') {
                resultado = resultado + (char)(c + 32);
            } else {
                resultado = resultado + c;
            }
        }

        return resultado;
    }

    private static void encontrada(String frase, String palabra) {

        int pos = 0; // posición dentro de la palabra

        for (int i = 0; i < frase.length(); i++) {

            if (frase.charAt(i) == palabra.charAt(pos)) {
                pos++; // coinciden → avanzar en la palabra
            }

            if (pos == palabra.length()) {
                System.out.println("Encontrada");
                return;
            }
        }

        System.out.println("No se encuentra");
    }
}
