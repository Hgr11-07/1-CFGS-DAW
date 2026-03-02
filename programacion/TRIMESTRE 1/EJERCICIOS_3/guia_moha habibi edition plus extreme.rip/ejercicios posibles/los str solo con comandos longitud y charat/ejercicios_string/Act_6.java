package ejercicios_string;

import java.util.Scanner;

public class Act_6 {

    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        String texto = pedirTexto();
        contarVocales(texto);
    }

    private static String pedirTexto() {
        System.out.println("Introduce el texto: ");
        return teclado.nextLine();
    }

    private static void contarVocales(String texto) {

        int a = 0, e = 0, i = 0, o = 0, u = 0;

        for (int j = 0; j < texto.length(); j++) {
            char c = texto.charAt(j);

            // Normalizar a minúscula para simplificar
            if (c >= 'A' && c <= 'Z') {
                c = (char)(c + 32);
            }

            if (c == 'a') a = 1;
            if (c == 'e') e = 1;
            if (c == 'i') i = 1;
            if (c == 'o') o = 1;
            if (c == 'u') u = 1;
        }

        int vocalesDiferentes = a + e + i + o + u;

        System.out.println("La frase tiene: " + vocalesDiferentes + " vocales diferentes");
    }
}
