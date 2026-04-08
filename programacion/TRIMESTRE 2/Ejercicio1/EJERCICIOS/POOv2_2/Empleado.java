package POOv2_2;

public abstract class Empleado {
	
	private String nombre;
	private double sueldo;
	
	public Empleado(String nombre, double sueldo) throws SueldoNegativoException, SueldoMaximoException {
		this.nombre=nombre;
		setSueldo(sueldo);
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setSueldo(double sueldo) throws SueldoNegativoException, SueldoMaximoException{
		
		if(sueldo<0) {
			throw new SueldoNegativoException();
		} else if(sueldo>getSueldoMaximo()) {
			throw new SueldoMaximoException();
		}
		this.sueldo=sueldo;
	}
	
	public double getSueldo() {
		return this.sueldo;
	}
	
	@Override
	public String toString() {
		return "Empleado: " +nombre+ " | Sueldo: " +sueldo;
	}
	
	public abstract double getSueldoMaximo();
	
}
