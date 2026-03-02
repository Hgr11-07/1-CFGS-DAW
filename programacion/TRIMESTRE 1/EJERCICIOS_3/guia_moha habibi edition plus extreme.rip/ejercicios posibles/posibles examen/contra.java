package ejercicios_str;

import java.util.Scanner;

public class contra {


    // ----- Método que verifica si la contraseña es válida -----
    public static boolean esValida(String pass) {
        if (pass.length() < 5) return false;

        boolean tieneNumero = false;

        int i = 0;
        while (i < pass.length()) {
            char c = pass.charAt(i);

            if (c >= '0' && c <= '9') {
                tieneNumero = true;
            }

            i++;
        }

        return tieneNumero;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String contrasena;

        do {
            System.out.print("Ingresa una contraseña: ");
            contrasena = sc.nextLine();

            if (!esValida(contrasena)) {
                System.out.println("Contraseña inválida. Debe tener mínimo 5 caracteres y un número.");
            }

        } while (!esValida(contrasena));

        System.out.println("Contraseña aceptada.");
    }
}
