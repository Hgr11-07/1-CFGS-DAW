package EjercicioExtra;

public class Producto {
    
    private String nombre;
    private double precio;
    private int stock;
    
    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public void setPrecio(double precio) {
        if(precio >= 0) {
            this.precio = precio;
        }
    }
    
    public double getPrecio() {
        return this.precio;
    }
    
    public void setStock(int stock) {
        if(stock >= 0) {
            this.stock = stock;
        }
    }
    
    public int getStock() {
        return this.stock;
    }
    
    public boolean venderCantidad(int cantidad) {
        if(cantidad > stock) {
            return false;
        } else {
            stock -= cantidad;
            return true;
        }
    }
    
    public String mostrarInfo() {
        return "Nombre: " + nombre + " | Precio: " + precio + "€ | Stock: " + stock + " unidades.";
    }
}
