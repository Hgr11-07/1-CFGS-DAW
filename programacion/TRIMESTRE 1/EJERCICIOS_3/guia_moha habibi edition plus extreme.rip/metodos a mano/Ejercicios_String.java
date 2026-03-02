package ejercicios_ampliacion_string;
import java.util.Scanner;
public class Ejercicios_String {
    // 1️⃣ Contar vocales en una frase
    public static int contarVocales(String texto) {
        int contador = 0;
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            // Convertimos manual a mayúscula para comparar
            if (c >= 'a' && c <= 'z') c = (char)(c - 32);

            if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                contador++;
            }
        }
        return contador;
    }

    // 2️⃣ Comprobar palíndromo
    public static boolean esPalindromo(String texto) {
        int len = texto.length();
        for (int i = 0; i < len / 2; i++) {
            char cInicio = texto.charAt(i);
            char cFin = texto.charAt(len - 1 - i);
            // Convertimos manual a mayúscula
            if (cInicio >= 'a' && cInicio <= 'z') cInicio -= 32;
            if (cFin >= 'a' && cFin <= 'z') cFin -= 32;

            if (cInicio != cFin) return false;
        }
        return true;
    }

    // 3️⃣ Contar cuántas veces aparece una letra
    public static int contarLetra(String texto, char letra) {
        int contador = 0;
        // Normalizamos la letra a mayúscula
        if (letra >= 'a' && letra <= 'z') letra = (char)(letra - 32);

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (c >= 'a' && c <= 'z') c = (char)(c - 32);

            if (c == letra) contador++;
        }
        return contador;
    }

    // 4️⃣ Convertir cadena a mayúsculas
    public static String aMayusculas(String texto) {
        String resultado = "";
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (c >= 'a' && c <= 'z') c = (char)(c - 32);
            resultado = resultado + c;
        }
        return resultado;
    }

    // 5️⃣ Obtener última palabra de una frase
    public static String ultimaPalabra(String texto) {
        String palabra = "";
        int len = texto.length();
        int i = len - 1;

        // Ignorar espacios al final
        while (i >= 0 && texto.charAt(i) == ' ') i--;

        // Recorrer al revés hasta encontrar espacio
        while (i >= 0 && texto.charAt(i) != ' ') {
            palabra = texto.charAt(i) + palabra;
            i--;
        }
        return palabra;
    }

    // 6️⃣ Quitar espacios duplicados
    public static String quitarEspaciosDuplicados(String texto) {
        String resultado = "";
        boolean espacioAnterior = false;
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (c == ' ') {
                if (!espacioAnterior) {
                    resultado = resultado + c;
                    espacioAnterior = true;
                }
            } else {
                resultado = resultado + c;
                espacioAnterior = false;
            }
        }
        return resultado;
    }

    // 7️⃣ Contar palabras en una frase
    public static int contarPalabras(String texto) {
        int contador = 0;
        boolean enPalabra = false;
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (c != ' ') {
                if (!enPalabra) {
                    contador++;
                    enPalabra = true;
                }
            } else {
                enPalabra = false;
            }
        }
        return contador;
    }

    // 8️⃣ Invertir cadena
    public static String invertirCadena(String texto) {
        String resultado = "";
        for (int i = texto.length() - 1; i >= 0; i--) {
            resultado = resultado + texto.charAt(i);
        }
        return resultado;
    }

    // 9️⃣ Comprobar "Guay del Paraguay"
    public static boolean esGuayDelParaguay(String texto, int N) {
        int len = texto.length();
        if (len < N * 2) return false;

        for (int i = 0; i < N; i++) {
            char inicio = texto.charAt(i);
            char fin = texto.charAt(len - N + i);

            // Normalizar a mayúscula
            if (inicio >= 'a' && inicio <= 'z') inicio -= 32;
            if (fin >= 'a' && fin <= 'z') fin -= 32;

            if (inicio != fin) return false;
        }
        return true;
    }

    // 🔟 Obtener iniciales de un nombre completo (3 palabras)
    public static String iniciales(String texto) {
        String resultado = "";
        boolean inicioPalabra = true;
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (c != ' ') {
                if (inicioPalabra) {
                    // Convertir a mayúscula
                    if (c >= 'a' && c <= 'z') c -= 32;
                    resultado = resultado + c + ".";
                    inicioPalabra = false;
                }
            } else {
                inicioPalabra = true;
            }
        }
        return resultado;
    }

    // 1️⃣1️⃣ Reemplazar carácter manualmente
    public static String reemplazarLetra(String texto, char buscar, char reemplazo) {
        String resultado = "";
        if (buscar >= 'a' && buscar <= 'z') buscar -= 32;
        if (reemplazo >= 'a' && reemplazo <= 'z') reemplazo -= 32;

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (c >= 'a' && c <= 'z') c -= 32;
            if (c == buscar) c = reemplazo;
            resultado = resultado + c;
        }
        return resultado;
    }

    // 1️⃣2️⃣ Extraer solo números de una cadena
    public static String extraerNumeros(String texto) {
        String resultado = "";
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (c >= '0' && c <= '9') resultado = resultado + c;
        }
        return resultado;
    }

    // 1️⃣3️⃣ Comprobar si cadena A está contenida en B
    public static boolean contieneCadena(String B, String A) {
        int lenB = B.length();
        int lenA = A.length();

        if (lenA > lenB) return false;

        for (int i = 0; i <= lenB - lenA; i++) {
            boolean match = true;
            for (int j = 0; j < lenA; j++) {
                char cB = B.charAt(i + j);
                char cA = A.charAt(j);

                // Normalizar mayúsculas
                if (cB >= 'a' && cB <= 'z') cB -= 32;
                if (cA >= 'a' && cA <= 'z') cA -= 32;

                if (cB != cA) {
                    match = false;
                    break;
                }
            }
            if (match) return true;
        }
        return false;
    }

    // 1️⃣4️⃣ Comparar dos cadenas sin equals
    public static boolean equalsManual(String A, String B) {
        if (A.length() != B.length()) return false;
        for (int i = 0; i < A.length(); i++) {
            char cA = A.charAt(i);
            char cB = B.charAt(i);

            if (cA >= 'a' && cA <= 'z') cA -= 32;
            if (cB >= 'a' && cB <= 'z') cB -= 32;

            if (cA != cB) return false;
        }
        return true;
    }

    // 1️⃣5️⃣ Contar consonantes
    public static int contarConsonantes(String texto) {
        int contador = 0;
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            // Normalizamos
            if (c >= 'a' && c <= 'z') c -= 32;

            if ((c >= 'A' && c <= 'Z') && !(c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')) {
                contador++;
            }
        }
        return contador;
    }

    // 🔹 MAIN para probar métodos
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Prueba de métodos con Strings y charAt:");

        String prueba = "Manolo juega al balonmano";
        System.out.println("Texto de prueba: " + prueba);
        System.out.println("Vocales: " + contarVocales(prueba));
        System.out.println("Es palíndromo: " + esPalindromo("ana"));
        System.out.println("Contar letra 'a': " + contarLetra(prueba, 'a'));
        System.out.println("A mayúsculas: " + aMayusculas(prueba));
        System.out.println("Última palabra: " + ultimaPalabra(prueba));
        System.out.println("Quitar espacios duplicados: " + quitarEspaciosDuplicados("hola   mundo  "));
        System.out.println("Contar palabras: " + contarPalabras(prueba));
        System.out.println("Invertir cadena: " + invertirCadena(prueba));
        System.out.println("Guay del Paraguay: " + esGuayDelParaguay(prueba, 4));
        System.out.println("Iniciales: " + iniciales("Juan Antonio Pérez"));
        System.out.println("Reemplazar letra 'a' por 'x': " + reemplazarLetra(prueba,'a','x'));
        System.out.println("Extraer números: " + extraerNumeros("abc123def456"));
        System.out.println("Contiene 'juega': " + contieneCadena(prueba, "juega"));
        System.out.println("Equals manual 'Ana' vs 'ana': " + equalsManual("Ana","ana"));
        System.out.println("Consonantes: " + contarConsonantes(prueba));

        sc.close();
    }

}
