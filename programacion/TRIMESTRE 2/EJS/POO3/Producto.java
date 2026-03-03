package POO3;

public class Producto {
	
	private int codigo;
	private String descripcion;
	private double precio;
	private Categoria categoria;
	
	public Producto(int codigo, String descripcion, double precio, Categoria categoria) {
		this.codigo=codigo;
		this.descripcion=descripcion;
		this.precio=precio;
		this.categoria=categoria;
	}
	
	public void setCodigo(int codigo) {
		this.codigo=codigo;
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion=descripcion;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
	public void setPrecio(double precio) {
		this.precio=precio;
	}
	
	public double getPrecio() {
		return this.precio;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria=categoria;
	}
	
	public Categoria getCategoria() {
		return this.categoria;
	}
	
}
