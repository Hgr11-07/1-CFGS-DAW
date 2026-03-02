package ejercicios_string;
import java.util.Scanner;
public class Act_9 {
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        String linea = pedirFrase();
        int sumaTotal = sumarNumeros(linea);
        System.out.println("La suma de los numeros de la frase es: " + sumaTotal);
    }

    // Método para pedir la frase
    private static String pedirFrase() {
        System.out.println("Introduce una frase:");
        return teclado.nextLine();
    }

    // Método que recorre la cadena y suma todos los números encontrados
    private static int sumarNumeros(String linea) {
        int suma = 0;
        int numeroActual = 0;

        for (int i = 0; i < linea.length(); i++) {
            char c = linea.charAt(i);
            if (c >= '0' && c <= '9') { // Si es un dígito
                numeroActual = numeroActual * 10 + (c - '0');
            } else { // No es dígito, sumamos el número actual y reiniciamos
                suma += numeroActual;
                numeroActual = 0;
            }
        }

        suma += numeroActual; // Sumamos el último número si existe
        return suma;
    }
}
