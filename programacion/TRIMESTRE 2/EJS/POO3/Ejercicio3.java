package POO3;

public class Ejercicio3 {
	
	public static void main(String[] args) {

        // --- Crear categorías con su nombre e IVA correspondiente ---
        Categoria alimentacion = new Categoria("Alimentación", 4);   // IVA superreducido 4%
        Categoria electronica  = new Categoria("Electrónica", 21);   // IVA general 21%
        Categoria ropa         = new Categoria("Ropa", 10);          // IVA reducido 10%

        // --- Crear productos: el código se asigna automáticamente ---
        Producto p1 = new Producto("Leche entera 1L",        1.20,  alimentacion);
        Producto p2 = new Producto("Auriculares Bluetooth",  49.99, electronica);
        Producto p3 = new Producto("Camiseta algodón",       15.00, ropa);

        // --- Mostrar los productos recién creados ---
        System.out.println("=== Productos creados ===");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        // --- Probar los setters ---
        System.out.println("\n=== Modificaciones ===");

        // Actualizamos el precio de los auriculares
        p2.setPrecio(59.99);
        System.out.println("Nuevo precio auriculares → sin IVA: " + p2.getPrecio() + "€ | venta: " + p2.precioVenta() + "€");

        // Cambiamos la descripción de la leche
        p1.setDescripcion("Leche semidesnatada 1L");
        System.out.println("Nueva descripción p1: " + p1.getDescripcion());

        // Cambiamos el IVA de la categoría Ropa y vemos el efecto en p3
        ropa.setIva(21);
        System.out.println("Camiseta con IVA al 21% → venta: " + p3.precioVenta() + "€");
        ropa.setIva(10); // restauramos

        // --- Estado final de todos los productos ---
        System.out.println("\n=== Estado final ===");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }

}
