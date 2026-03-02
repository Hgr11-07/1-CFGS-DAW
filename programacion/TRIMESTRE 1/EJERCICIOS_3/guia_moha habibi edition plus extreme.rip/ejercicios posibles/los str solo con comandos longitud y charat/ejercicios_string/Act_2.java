package ejercicios_string;

import java.util.Scanner;

public class Act_2 {

    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

        String cadena = pedirCadena();

        contarMinus(cadena);
        contarMayus(cadena);
        contarNum(cadena);
    }

    private static String pedirCadena() {
        System.out.println("Introduce una cadena de texto: ");
        String cadena = teclado.nextLine();
        return cadena;
    }

    private static void contarMinus(String cadena) {

        int minusculas = 0;

        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);

            // 'a' = 97, 'z' = 122
            if (c >= 'a' && c <= 'z') {
                minusculas++;
            }
        }

        System.out.println("La cadena de texto tiene " + minusculas + " minusculas");
    }

    private static void contarMayus(String cadena) {

        int mayusculas = 0;

        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);

            // 'A' = 65, 'Z' = 90
            if (c >= 'A' && c <= 'Z') {
                mayusculas++;
            }
        }

        System.out.println("La cadena de texto tiene " + mayusculas + " mayusculas");
    }

    private static void contarNum(String cadena) {

        int numeros = 0;

        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);

            // '0' = 48, '9' = 57
            if (c >= '0' && c <= '9') {
                numeros++;
            }
        }

        System.out.println("La cadena de texto tiene " + numeros + " numeros");
    }
}
