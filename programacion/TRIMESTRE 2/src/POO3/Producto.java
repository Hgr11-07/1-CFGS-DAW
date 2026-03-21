package POO3;

//Clase que representa un producto con código único, descripción, precio y categoría
public class Producto {

 // Variable de clase: lleva la cuenta del último código asignado (compartida por todos los objetos)
 private static int ultimoCodigo = 0;

 // Código único del producto, asignado automáticamente al crearse
 private int codigo;

 // Descripción del producto (ej: "Leche entera 1L")
 private String descripcion;

 // Precio del producto sin IVA
 private double precio;

 // Categoría a la que pertenece el producto (objeto de la clase Categoria)
 private Categoria categoria;

 // Constructor: incrementa el contador y asigna el siguiente código disponible
 public Producto(String descripcion, double precio, Categoria categoria) {
     ultimoCodigo++;                  // Se incrementa el contador de clase
     this.codigo = ultimoCodigo;      // El código de este producto es único e irrepetible
     this.descripcion = descripcion;
     this.precio = precio;
     this.categoria = categoria;
 }

 // Getter: devuelve el código único del producto (no tiene setter, no debe cambiar)
 public int getCodigo() {
     return codigo;
 }

 // Getter: devuelve la descripción del producto
 public String getDescripcion() {
     return descripcion;
 }

 // Setter: permite modificar la descripción del producto
 public void setDescripcion(String descripcion) {
     this.descripcion = descripcion;
 }

 // Getter: devuelve el precio sin IVA
 public double getPrecio() {
     return precio;
 }

 // Setter: permite modificar el precio sin IVA
 public void setPrecio(double precio) {
     this.precio = precio;
 }

 // Getter: devuelve la categoría del producto
 public Categoria getCategoria() {
     return categoria;
 }

 // Setter: permite cambiar la categoría del producto
 public void setCategoria(Categoria categoria) {
     this.categoria = categoria;
 }

 // Calcula el precio de venta aplicando el IVA de su categoría
 // Fórmula: precio * (1 + iva / 100)
 public double precioVenta() {
     return precio * (1 + categoria.getIva() / 100);
 }

 // Representación legible del producto con todos sus datos
 @Override
 public String toString() {
     return "[#" + codigo + "] " + descripcion + " | Sin IVA: " + precio + "€ | Venta: " + precioVenta() + "€ | Categoría: " + categoria;
 }
}