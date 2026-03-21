package POOv2_1;
import java.util.*;
 
public class Ejercicio_1 {
 
    private static Scanner teclado = new Scanner(System.in);
 
    public static void main(String[] args) throws CuentaException {
 
        System.out.println("Introduce el nombre del titular: ");
        String titular = teclado.nextLine();
 
        CuentaCredito cuenta = new CuentaCredito(titular, teclado);
        cuenta.tratarMenu();
    }
}
