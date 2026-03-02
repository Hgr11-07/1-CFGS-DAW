package ejercicios_string;
import java.util.Scanner;

public class Act_8 {
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        String usuario = pedirUsuario();
        String contrasena = pedirContrasena();
        System.out.println("Bienvenido " + usuario);
    }

    private static String pedirUsuario() {
        System.out.println("Introduce el usuario: ");
        String usuario = teclado.nextLine();
        while (!usuarioValido(usuario)) {
            System.out.println("Usuario inválido. Solo letras y máximo 30 caracteres. Intenta de nuevo:");
            usuario = teclado.nextLine();
        }
        return usuario;
    }

    private static boolean usuarioValido(String usuario) {
        if (usuario.length() > 30 || usuario.length() == 0) return false;
        for (int i = 0; i < usuario.length(); i++) {
            char c = usuario.charAt(i);
            if (!((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))) return false;
        }
        return true;
    }

    private static String pedirContrasena() {
        System.out.println("Introduce la contraseña: ");
        String contrasena = teclado.nextLine();
        while (!contrasenaValida(contrasena)) {
            System.out.println("Contraseña inválida. Debe tener al menos 7 caracteres, una letra, un dígito y un caracter no alfanumérico:");
            contrasena = teclado.nextLine();
        }
        return contrasena;
    }

    private static boolean contrasenaValida(String contrasena) {
        if (contrasena.length() < 7) return false;

        boolean tieneLetra = false;
        boolean tieneNumero = false;
        boolean tieneNoAlfa = false;

        for (int i = 0; i < contrasena.length(); i++) {
            char c = contrasena.charAt(i);
            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) tieneLetra = true;
            else if (c >= '0' && c <= '9') tieneNumero = true;
            else tieneNoAlfa = true;
        }

        return tieneLetra && tieneNumero && tieneNoAlfa;
    }
}

}