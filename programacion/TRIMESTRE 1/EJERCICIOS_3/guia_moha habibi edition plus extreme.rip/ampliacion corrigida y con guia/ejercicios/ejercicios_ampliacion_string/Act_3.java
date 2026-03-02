//3. Realizar un método que reciba como entrada dos cadenas de caracteres y devuelva una tercera
//cadena intercalando los caracteres de las palabras de las cadenas recibidas.
//Ejemplo: “abcdfgh” y “123” devolvería “a1b2c3dfgh”
package ejercicios_ampliacion_string;

import java.util.Scanner;

public class Act_3 {

    // Método que intercala los caracteres de dos cadenas
    public static String intercalar(String a, String b) {

        String resultado = "";

        int lenA = a.length();
        int lenB = b.length();

        int i = 0; // índice para a
        int j = 0; // índice para b

        // Mientras quede algún carácter por añadir
        while (i < lenA || j < lenB) {

            // Añadir carácter de la primera cadena si queda
            if (i < lenA) {
                resultado = resultado + a.charAt(i);
                i++;
            }

            // Añadir carácter de la segunda cadena si queda
            if (j < lenB) {
                resultado = resultado + b.charAt(j);
                j++;
            }
        }

        return resultado;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce la primera cadena: ");
        String cad1 = sc.nextLine();

        System.out.print("Introduce la segunda cadena: ");
        String cad2 = sc.nextLine();

        String intercalada = intercalar(cad1, cad2);

        System.out.println("La cadena intercalada es: " + intercalada);

        sc.close();
    }
}
