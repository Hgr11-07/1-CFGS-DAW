package ejercicios_str;

public class vocales {


    // ----- Método que cuenta vocales -----
    public static int contarVocales(String texto) {
        int contador = 0;

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);

            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                contador++;
            }
        }

        return contador;
    }

    public static void main(String[] args) {
        String palabra = "Programacion";
        int vocales = contarVocales(palabra);

        System.out.println("La palabra tiene " + vocales + " vocales.");
    }
}
