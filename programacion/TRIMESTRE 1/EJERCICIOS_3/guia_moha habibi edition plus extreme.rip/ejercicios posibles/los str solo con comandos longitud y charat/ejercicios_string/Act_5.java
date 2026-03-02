package ejercicios_string;

import java.util.Scanner;

public class Act_5 {

    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

        String textoorig, textobusc, textoremplazar;

        textoorig = pedirtextoorig();
        textobusc = pedirtextobusc();
        textoremplazar = pedirtextoremplazar();

        remplazartexto(textoorig, textobusc, textoremplazar);
    }

    private static String pedirtextoorig() {
        System.out.println("Introduce un texto original: ");
        return teclado.nextLine();
    }

    private static String pedirtextobusc() {
        System.out.println("Introduce el texto a buscar: ");
        return teclado.nextLine();
    }

    private static String pedirtextoremplazar() {
        System.out.println("Introduce el texto a reemplazar: ");
        return teclado.nextLine();
    }

    private static void remplazartexto(String textoorig, String textobusc, String textoremplazar) {

        String resultado = "";
        int i = 0;

        while (i < textoorig.length()) {

            boolean coincide = true;

            // Comprobamos si queda espacio suficiente para comparar
            if (i + textobusc.length() <= textoorig.length()) {

                // Comprobación letra por letra
                for (int j = 0; j < textobusc.length(); j++) {
                    if (textoorig.charAt(i + j) != textobusc.charAt(j)) {
                        coincide = false;
                        break;
                    }
                }

            } else {
                coincide = false;
            }

            // Si coincide, sustituimos
            if (coincide) {
                resultado = resultado + textoremplazar;
                i = i + textobusc.length(); // saltamos palabra buscada
            } else {
                resultado = resultado + textoorig.charAt(i);
                i++;
            }
        }

        System.out.println("El texto modificado es:");
        System.out.println(resultado);
    }
}
