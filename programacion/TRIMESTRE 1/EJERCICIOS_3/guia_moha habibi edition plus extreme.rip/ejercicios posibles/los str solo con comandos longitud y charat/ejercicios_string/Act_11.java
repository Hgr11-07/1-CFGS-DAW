package ejercicios_string;

import java.util.Scanner;

public class Act_11 {

    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Juego del ahorcado");
        System.out.println();

        String secreta = pedirTexto("Introduce la palabra secreta:");
        char letra = pedirLetra("Prueba con una letra");

        intentos(letra, secreta);
    }

    private static String pedirTexto(String mensaje) {
        System.out.println(mensaje);
        String texto = teclado.nextLine();

        // “limpiar pantalla”
        for (int i = 0; i < 25; i++) {
            System.out.println();
        }
        return texto;
    }

    private static char pedirLetra(String mensaje) {
        System.out.println(mensaje);
        char c = teclado.next().charAt(0);

        while (!((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))) {
            System.out.println("Caracter no válido. " + mensaje);
            c = teclado.next().charAt(0);
        }
        return c;
    }

    // Comprobar si una letra ya se ha usado
    private static boolean yaProbada(char letra, String probadas) {

        for (int i = 0; i < probadas.length(); i++) {
            char p = probadas.charAt(i);

            if (letra == p) return true;

            // Comparación sin distinguir mayúsc/minúsculas
            if (letra >= 'A' && letra <= 'Z' && p == letra + 32) return true;
            if (letra >= 'a' && letra <= 'z' && p == letra - 32) return true;
        }
        return false;
    }

    private static String comprobarLetra(char letra, String secreta, String progresoViejo) {

        String nuevo = "";
        int coincidencias = 0;

        for (int i = 0; i < secreta.length(); i++) {

            char c = secreta.charAt(i);
            boolean coincide =
                   letra == c
                || (letra >= 'A' && letra <= 'Z' && c == letra + 32)
                || (letra >= 'a' && letra <= 'z' && c == letra - 32);

            if (coincide) {
                nuevo = nuevo + c;
                coincidencias++;
            } else {
                nuevo = nuevo + progresoViejo.charAt(i);
            }
        }

        if (coincidencias > 0) {
            System.out.println("Tu letra está " + coincidencias + " vez/ces\n");
        } else {
            System.out.println("Tu letra no está");
        }

        return nuevo;
    }

    private static void intentos(char letra, String secreta) {

        int intentos = 1;
        int fallos = 0;

        // Crear progreso inicial (****)
        String progreso = "";
        for (int i = 0; i < secreta.length(); i++) {
            progreso = progreso + "*";
        }

        String letrasProbadas = "";

        while (fallos != 7) {

            System.out.println("Intento " + intentos + " — Fallos: " + fallos);

            // Evitar repetir letras
            if (yaProbada(letra, letrasProbadas)) {
                System.out.println("Ya probaste esa letra, prueba otra.");
                letra = pedirLetra("Prueba con una letra");
                continue;
            }

            // Registrar letra probada
            letrasProbadas = letrasProbadas + letra;

            String nuevoProgreso = comprobarLetra(letra, secreta, progreso);

            // NO puedo usar equals(), así que comparo carácter a carácter
            boolean igual = true;
            if (nuevoProgreso.length() == progreso.length()) {
                for (int i = 0; i < progreso.length(); i++) {
                    if (nuevoProgreso.charAt(i) != progreso.charAt(i)) {
                        igual = false;
                        break;
                    }
                }
            }

            if (igual) {
                fallos++;
            }

            progreso = nuevoProgreso;
            System.out.println("Palabra: " + progreso);

            // Comprobar si está completa (sin '*')
            boolean completa = true;
            for (int i = 0; i < progreso.length(); i++) {
                if (progreso.charAt(i) == '*') {
                    completa = false;
                    break;
                }
            }

            if (completa) {
                System.out.println("¡Has ganado!");
                return;
            }

            letra = pedirLetra("Prueba con una letra");
            intentos++;
        }

        System.out.println("Has perdido");
    }
}

