package SimulacroV3;

public class Responsable {
	
	private String dni;
	private String nombre;
	private int antiguedad;
	
	public Responsable(String dni, String nombre, int antiguedad) {
		this.dni=dni;
		this.nombre=nombre;
		this.antiguedad=antiguedad;
	}
	
	public String getDNI() {
		return this.dni;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public int getAntiguedad() {
		return this.antiguedad;
	}
	
	@Override
	public String toString() {
		return "DNI: "+dni+ " | Nombre: " +nombre+ " | Antiguedad: " +antiguedad;
	}
	
}
