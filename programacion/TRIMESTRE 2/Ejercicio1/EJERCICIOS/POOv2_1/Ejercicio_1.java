package POOv2_1;
import java.util.*;

public class Ejercicio_1 {

    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) throws CuentaException {

        System.out.println("Introduce el nombre del titular: ");
        String titular = teclado.nextLine();

        System.out.println("¿Deseas indicar un crédito personalizado? (s/n): ");
        String respuesta = teclado.nextLine();

        CuentaCredito cuenta;

        if (respuesta.equalsIgnoreCase("s")) {
            boolean creditoValido = false;
            double credito = 0;
            while (!creditoValido) {
                try {
                    System.out.println("Introduce el crédito (máximo 300€): ");
                    credito = teclado.nextDouble();
                    teclado.nextLine();
                    cuenta = new CuentaCredito(titular, credito, teclado);
                    creditoValido = true;
                    cuenta.tratarMenu();
                } catch (CuentaException e) {
                    System.out.println(e.getMessage());
                }
            }
        } else {
            cuenta = new CuentaCredito(titular, teclado);
            cuenta.tratarMenu();
        }
    }
}
