package ejercicios_string;

import java.util.Scanner;

public class Act_12 {

    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

        String textocompleto, usuario, organizacion, fin;

        textocompleto = pedirtexto();

        usuario = separarusuario(textocompleto);
        comprobarusuario(usuario);

        organizacion = separarorga(textocompleto);
        comprobarorga(organizacion);

        fin = separarfin(textocompleto);
        comprobarfin(fin);
    }

    private static String pedirtexto() {
        System.out.println("Introduce la dirección de correo: ");
        String texto = teclado.nextLine();
        return texto;
    }

    // ---- SEPARA USUARIO (antes de @) ----
    private static String separarusuario(String textocompleto) {

        String texto = "";

        for (int i = 0; i < textocompleto.length(); i++) {
            char c = textocompleto.charAt(i);
            if (c == '@') break;
            texto = texto + c;
        }
        return texto;
    }

    private static void comprobarusuario(String usuario) {

        if (usuario.length() < 1) {
            System.out.println("Usuario Incorrecto");
            return;
        }

        char primera = usuario.charAt(0);

        if (!((primera >= 'A' && primera <= 'Z') ||
              (primera >= 'a' && primera <= 'z'))) {
            System.out.println("Usuario Incorrecto");
            return;
        }

        for (int i = 0; i < usuario.length(); i++) {
            char c = usuario.charAt(i);

            if (!((c >= 'A' && c <= 'Z') ||
                  (c >= 'a' && c <= 'z') ||
                  (c >= '0' && c <= '9') ||
                   c == '.')) {
                System.out.println("Usuario Incorrecto");
                return;
            }
        }

        System.out.println("Usuario Correcto");
    }

    // ---- SEPARA ORGANIZACIÓN (entre @ y .) ----
    private static String separarorga(String textocompleto) {

        String organizacion = "";
        boolean arrobaEncontrado = false;

        for (int i = 0; i < textocompleto.length(); i++) {

            char c = textocompleto.charAt(i);

            if (c == '@') {
                arrobaEncontrado = true;
                continue;
            }

            if (arrobaEncontrado) {
                if (c == '.') break;
                organizacion = organizacion + c;
            }
        }
        return organizacion;
    }

    private static void comprobarorga(String organizacion) {

        if (organizacion.length() < 1) {
            System.out.println("Organizacion Incorrecta");
            return;
        }

        char primera = organizacion.charAt(0);

        if (!((primera >= 'A' && primera <= 'Z') ||
              (primera >= 'a' && primera <= 'z'))) {
            System.out.println("Organizacion Incorrecta");
            return;
        }

        for (int i = 0; i < organizacion.length(); i++) {
            char c = organizacion.charAt(i);

            if (!((c >= 'A' && c <= 'Z') ||
                  (c >= 'a' && c <= 'z') ||
                  (c >= '0' && c <= '9'))) {
                System.out.println("Organizacion Incorrecta");
                return;
            }
        }

        System.out.println("Organizacion Correcta");
    }

    // ---- SEPARA FIN (después del último '.') ----
    private static String separarfin(String textocompleto) {

        String fin = "";
        boolean puntoEncontrado = false;

        for (int i = 0; i < textocompleto.length(); i++) {
            char c = textocompleto.charAt(i);

            if (c == '.') {
                puntoEncontrado = true;
                fin = ""; // reset, este será el último punto
                continue;
            }

            if (puntoEncontrado) {
                fin = fin + c;
            }
        }
        return fin;
    }

    private static void comprobarfin(String fin) {

        if (fin.length() < 2 || fin.length() > 3) {
            System.out.println("Fin Incorrecto");
            return;
        }

        for (int i = 0; i < fin.length(); i++) {

            char c = fin.charAt(i);

            if (!((c >= 'A' && c <= 'Z') ||
                  (c >= 'a' && c <= 'z'))) {
                System.out.println("Fin Incorrecto");
                return;
            }
        }

        System.out.println("Fin Correcto");
    }
}
