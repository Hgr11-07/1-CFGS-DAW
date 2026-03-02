package ejercicios_string;

import java.util.Scanner;

public class Act_1 {

    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

        String frase = pedirFrase();
        char caracter = pedirCaracter();

        contarCaracter(frase, caracter);
    }

    private static String pedirFrase() {
        System.out.println("Ingrese una frase:");
        String frase = teclado.nextLine();
        return frase;
    }

    private static char pedirCaracter() {
        System.out.println("Ingrese el carácter:");
        char caracter = teclado.next().charAt(0);
        return caracter;
    }

    private static void contarCaracter(String frase, char caracter) {

        int contador = 0;

        // Convertimos el caracter a minúscula sin usar toLowerCase()
        // usando el truco permitido con charAt()
        if (caracter >= 'A' && caracter <= 'Z') {
            caracter = (char)(caracter + 32); // A → a (ASCII)
        }

        for (int i = 0; i < frase.length(); i++) {

            char c = frase.charAt(i);

            // Convertimos cada carácter de la frase a minúscula
            if (c >= 'A' && c <= 'Z') {
                c = (char)(c + 32);
            }

            if (c == caracter) {
                contador++;
            }
        }

        System.out.println("El carácter '" + caracter + "' aparece " + contador + " veces.");
    }
}
