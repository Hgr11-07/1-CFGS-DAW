package POOv2_1;
import java.util.*;

public class CuentaCredito extends Cuenta {

    private double credito;
    private Scanner teclado;

    // Constructor por defecto: saldo 0€, crédito 100€
    public CuentaCredito(String titular, Scanner teclado) {
        super(titular);
        this.credito = 100;
        this.teclado = teclado;
    }

    //Valida que el crédito esté entre 0 y 300€
    public CuentaCredito(String titular, double credito, Scanner teclado) throws CuentaException {
        super(titular);
        if (credito < 0 || credito > 300) {
            throw new CuentaException("El crédito debe estar entre 0€ y 300€.");
        }
        this.credito = credito;
        this.teclado = teclado;
    }

    public double getCredito() {
        return credito;
    }

    // Lanza excepción si el valor no es válido
    public void setCredito(double credito) throws CuentaException {
        if (credito > 300) {
            throw new CuentaException("El crédito no puede superar los 300€.");
        }
        if (getSaldo() < -credito) {
            throw new CuentaException("No se puede reducir el crédito: el saldo actual ("
                + getSaldo() + "€) quedaría por debajo del nuevo límite (-" + credito + "€).");
        }
        this.credito = credito;
    }

    // Resta directamente con setSaldo(), permite saldo negativo dentro del crédito
    @Override
    public void sacarDinero() throws CuentaException {
        System.out.println("Introduce la cantidad a sacar: ");
        double retiro = teclado.nextDouble();

        if (retiro <= 0) {
            throw new CuentaException("El reintegro solo puede realizarse con cantidades positivas.");
        }
        if (getSaldo() - retiro < -credito) {
            throw new CuentaException("No tienes suficiente saldo ni crédito disponible.");
        }

        setSaldo(getSaldo() - retiro);
    }

    @Override
    public String toString() {
        return "Titular: " + getTitular() + " | Saldo: " + getSaldo() + "€ | Crédito: " + credito + "€";
    }

    public void mostrarMenu() {
        System.out.println("\n--MENÚ CUENTA CRÉDITO--");
        System.out.println("1. Ingresar dinero");
        System.out.println("2. Sacar dinero");
        System.out.println("3. Mostrar saldo y crédito");
        System.out.println("4. Salir");
    }

    public void tratarMenu() throws CuentaException {
        mostrarMenu();
        int opcion = pedirOpcion();

        while (opcion != 4) {
            switch (opcion) {
                case 1:
                    System.out.println("Introduce la cantidad a ingresar: ");
                    double ingreso = teclado.nextDouble();
                    super.realizarIngreso(ingreso);
                    break;
                case 2:
                    boolean correcto = false;
                    while (!correcto) {
                        try {
                            sacarDinero();
                            correcto = true;
                        } catch (CuentaException e) {
                            System.out.println(e.getMessage());
                            teclado.nextLine();
                        }
                    }
                    break;
                case 3:
                    System.out.println(toString());
                    break;
            }
            mostrarMenu();
            opcion = pedirOpcion();
        }
        System.out.println("Saliendo... " + toString());
    }

    private int pedirOpcion() {
        System.out.println("Introduce la opción: ");
        int n = teclado.nextInt();
        while (n < 1 || n > 4) {
            System.out.println("Opción no válida, introduce una opción entre 1 y 4: ");
            n = teclado.nextInt();
        }
        return n;
    }
}