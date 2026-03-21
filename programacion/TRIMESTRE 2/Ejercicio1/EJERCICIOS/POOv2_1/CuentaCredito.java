package POOv2_1;
import java.util.Scanner;
 
public class CuentaCredito extends Cuenta {
 
    private double credito;
    private Scanner teclado;
 
    // Constructor sin crédito: crédito por defecto 100€
    public CuentaCredito(String titular, Scanner teclado) {
        super(titular);
        this.credito = 100;
        this.teclado = teclado;
    }

    public CuentaCredito(String titular, double credito, Scanner teclado) throws CuentaException {
        super(titular);
        this.credito = credito;
        this.teclado = teclado;
    }
 
    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        if (credito <= 300 && getSaldo() >= -credito) {
            this.credito = credito;
        }
    }
 
    @Override
    public void sacarDinero() throws CuentaException {
        System.out.println("Introduce la cantidad a sacar: ");
        double retiro = teclado.nextDouble();
 
        if (retiro <= 0) {
            throw new CuentaException("El reintegro solo puede realizarse con cantidades positivas.");
        }
 
        if (getSaldo() - retiro < -credito) {
            throw new CuentaException("No tienes suficiente saldo ni crédito.");
        }
 
        if (retiro > getSaldo()) {
            double diferencia = retiro - getSaldo();
            super.realizarIngreso(diferencia);
        }
        super.realizarReintegro(retiro);
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
 
        int opcion;
        mostrarMenu();
        opcion = pedirOpcion();
        boolean correcto=false;
 
        while (opcion != 4) {
            switch (opcion) {
                case 1:
                    System.out.println("Introduce la cantidad a ingresar: ");
                    double ingreso = teclado.nextDouble();
                    super.realizarIngreso(ingreso);
                    break;
                case 2:
                	correcto=false;
                	while(!correcto) {
                		try {
                			sacarDinero();
                    		correcto=true;
                		} catch(CuentaException e) {
                			System.out.println(e);
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