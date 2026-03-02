//4. Realizar un método que permita saber si un texto es o no “Guay del Paraguay”. Se considera que una
//cadena es “Guay del Paraguay” si las 4 primeras letras y las 4 últimas son iguales entre sí. El número 4
//debe crearse como constante de manera que el programa siga funcionando si se cambia el valor de
//dicha constante.
//Ejemplos de frases “Guay del Paraguay””:
//“Manolo juega al balonmano”
//“Ponedle más marcarpone”
//NOTA: La longitud de la cadena para que sea “Guay del Paraguay” será de
//al menos 4* 2 caracteres. El método lo controlará.
package ejercicios_ampliacion_string;

import java.util.Scanner;

public class Act_4 {

    // Constante que define cuántas letras deben coincidir al principio y al final
    public static final int N = 4;

    // Método auxiliar: normaliza una letra a "mayúscula" si está en 'a'..'z'.
    // No usamos toUpperCase(); lo hacemos por manipulación de códigos char.
    private static char normalizarMayus(char c) {
        if (c >= 'a' && c <= 'z') {
            return (char) (c - 32); // 'a'->'A', etc.
        }
        return c;
    }

    // Método que determina si una cadena es "Guay del Paraguay"
    public static boolean esGuay(String texto) {

        int len = texto.length();

        // La cadena debe tener al menos N*2 caracteres
        if (len < N * 2) {
            return false;
        }

        // Comparamos las N primeras letras con las N últimas letra a letra,
        // normalizando mayúsculas/minúsculas manualmente al comparar.
        for (int i = 0; i < N; i++) {
            char cInicio = texto.charAt(i);
            char cFin = texto.charAt(len - N + i);

            // Normalizamos ambos caracteres (si son minúsculas las pasamos a mayúsculas)
            cInicio = normalizarMayus(cInicio);
            cFin = normalizarMayus(cFin);

            // Si difieren, no es "Guay del Paraguay"
            if (cInicio != cFin) {
                return false;
            }
        }

        // Si todos coinciden, es "Guay del Paraguay"
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce un texto: ");
        String frase = sc.nextLine();

        if (esGuay(frase)) {
            System.out.println("La frase ES Guay del Paraguay.");
        } else {
            System.out.println("La frase NO es Guay del Paraguay.");
        }

        sc.close();
    }
}
