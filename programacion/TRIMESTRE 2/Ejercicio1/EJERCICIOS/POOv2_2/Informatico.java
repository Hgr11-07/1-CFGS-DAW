package POOv2_2;

public class Informatico extends Empleado{
	
	private Especialidad especialidad;
	
	public Informatico(String nombre, double sueldo, Especialidad especialidad) throws SueldoNegativoException, SueldoMaximoException {
		super(nombre, sueldo);
		this.especialidad=especialidad;
	}
	
	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad=especialidad;
	}
	
	public Especialidad getEspecialidad() {
		return this.especialidad;
	}
	
	@Override
	public double getSueldoMaximo() {
		return 2500;
	}
	
	@Override
	public String toString() {
		return super.toString() + " | Puesto: Informático | Especialidad: " +especialidad;
	}
	
}
