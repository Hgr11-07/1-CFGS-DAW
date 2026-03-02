package ejercicios_string;

import java.util.Scanner;

public class Act_3 {

    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        String palabra = pedirPalabra();
        palabra = quitarEspacios(palabra); // ← importante para palíndromos con frases

        if (esPalindromo(palabra)) {
            System.out.println("La palabra es un palindromo");
        } else {
            System.out.println("La palabra no es un palindromo");
        }
    }

    // Pide la palabra o frase
    public static String pedirPalabra() {
        System.out.println("Ingrese una palabra o frase: ");
        String palabra = teclado.nextLine();
        return palabra;
    }

    // Elimina espacios SIN usar métodos prohibidos
    public static String quitarEspacios(String texto) {
        String sinEspacios = "";
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (c != ' ') {        // solo salta espacios
                sinEspacios = sinEspacios + c;
            }
        }
        return sinEspacios;
    }

    public static boolean esPalindromo(String palabra) {

        int inicio = 0;
        int fin = palabra.length() - 1;  // ← corregido

        while (inicio < fin) {

            char c1 = palabra.charAt(inicio);
            char c2 = palabra.charAt(fin);

            // Normalizar a minúscula sin toLowerCase()
            if (c1 >= 'A' && c1 <= 'Z') c1 = (char)(c1 + 32);
            if (c2 >= 'A' && c2 <= 'Z') c2 = (char)(c2 + 32);

            // Si no coinciden → no es palíndromo
            if (c1 != c2) {
                return false;
            }

            inicio++;
            fin--;
        }

        return true;
    }
}
