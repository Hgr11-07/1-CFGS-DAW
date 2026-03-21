package POO3;

//Clase que representa la categoría de un producto
public class Categoria {

 // Nombre de la categoría (ej: "Alimentación", "Electrónica")
 private String nombre;

 // IVA aplicable a los productos de esta categoría (ej: 21.0 para el 21%)
 private double iva;

 // Constructor: inicializa la categoría con nombre e IVA
 public Categoria(String nombre, double iva) {
     this.nombre = nombre;
     this.iva = iva;
 }

 // Getter: devuelve el nombre de la categoría
 public String getNombre() {
     return nombre;
 }

 // Setter: permite modificar el nombre de la categoría
 public void setNombre(String nombre) {
     this.nombre = nombre;
 }

 // Getter: devuelve el IVA de la categoría
 public double getIva() {
     return iva;
 }

 // Setter: permite modificar el IVA de la categoría
 public void setIva(double iva) {
     this.iva = iva;
 }

 // Representación legible de la categoría
 @Override
 public String toString() {
     return nombre + " (IVA: " + iva + "%)";
 }
}
