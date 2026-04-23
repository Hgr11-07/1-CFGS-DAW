package ExamenTema5;

public class Movimiento {
	
	String nombre;
	Tipo tipo;
	int potencia;
	
	public Movimiento(String nombre, Tipo tipo, int potencia) {
		this.nombre=nombre;
		this.tipo=tipo;
		this.potencia=potencia;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public Tipo getTipo() {
		return this.tipo;
	}
	
	public int getPotencia() {
		return this.potencia;
	}
	
	@Override
	
	public String toString() {
		return "Nombre: "+nombre+ " | Tipo: "+tipo+ " | Potencia: " +potencia;
	}

}
