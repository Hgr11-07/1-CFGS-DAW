package ejercicios_string;
import java.util.Scanner;

public class Act_7 {

    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        String texto = pedirTexto();
        String textoSinEspacios = quitarEspacios(texto);
        ordenarTexto(textoSinEspacios);
    }

    private static String pedirTexto() {
        System.out.println("Introduce el texto: ");
        return teclado.nextLine();
    }

    private static String quitarEspacios(String texto) {
        String resultado = "";
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (c != ' ') {
                resultado += c;
            }
        }
        return resultado;
    }

    private static void ordenarTexto(String textoSinEspacios) {
        String consonantes = "";
        String vocales = "";

        for (int i = 0; i < textoSinEspacios.length(); i++) {
            char c = textoSinEspacios.charAt(i);
            // Convertimos a minúscula solo para facilitar la comparación
            char cMinus = (c >= 'A' && c <= 'Z') ? (char)(c + 32) : c;

            if (cMinus == 'a' || cMinus == 'e' || cMinus == 'i' || cMinus == 'o' || cMinus == 'u') {
                vocales += c;
            } else {
                consonantes += c;
            }
        }

        String textoOrdenado = consonantes + vocales;
        System.out.println("El texto ordenado es: " + textoOrdenado);
    }
}
