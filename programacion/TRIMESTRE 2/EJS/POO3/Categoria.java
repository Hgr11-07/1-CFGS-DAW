package POO3;

public class Categoria {
	
	private String nombre;
	private double iva;
	
	public Categoria( String nombre, double IVA) {
		this.nombre=nombre;
		this.iva=iva;
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setIva(double iva) {
		this.iva=iva;
	}
	
	public double getIva() {
		return this.iva;
	}

}
