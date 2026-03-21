package EjercicioExtra;

import java.util.*;

public class MainProducto {
    
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        
        Producto producto1 = new Producto("Pantalon", 20.00, 100);
        Producto producto2 = new Producto("Camiseta", 30.00, 200);
        Producto producto3 = new Producto("Jersey", 5.00, 10);
        
        System.out.println("INFO INICIAL:");
        System.out.println(producto1.mostrarInfo());
        System.out.println(producto2.mostrarInfo());
        System.out.println(producto3.mostrarInfo());
        System.out.println();
        
        int opcion = opcionVenta();
        
        while(opcion != 4) {
            
            System.out.print("¿Cuántas unidades desea vender? ");
            int cantidad = teclado.nextInt();
            
            switch(opcion) {
                case 1: {
                    if(!producto1.venderCantidad(cantidad)) {
                        System.out.println("No hay suficiente stock.");
                    } else {
                        System.out.println("Venta completada.");
                    }
                    break;
                }
                case 2: {
                    if(!producto2.venderCantidad(cantidad)) {
                        System.out.println("No hay suficiente stock.");
                    } else {
                        System.out.println("Venta completada.");
                    }
                    break;
                }
                case 3: {
                    if(!producto3.venderCantidad(cantidad)) {
                        System.out.println("No hay suficiente stock.");
                    } else {
                        System.out.println("Venta completada.");
                    }
                    break;
                }
            }
            
            System.out.println("NUEVA INFO:");
            System.out.println(producto1.mostrarInfo());
            System.out.println(producto2.mostrarInfo());
            System.out.println(producto3.mostrarInfo());
            System.out.println();
            
            opcion = opcionVenta();
        }
        
    }
    
    public static int opcionVenta() {
        int opcion;
        
        System.out.println("¿Qué producto quieres vender?");
        System.out.println("1. Pantalón");
        System.out.println("2. Camiseta");
        System.out.println("3. Jersey");
        System.out.println("4. Salir");
        System.out.print("Opción: ");
        opcion = teclado.nextInt();
        
        while(opcion < 1 || opcion > 4) {
            System.out.print("Opción inválida. Prueba de nuevo: ");
            opcion = teclado.nextInt();
        }
        return opcion;
    }
}
