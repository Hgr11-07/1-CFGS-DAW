package POOv2_2;

public class Directivo extends Empleado{
	
	private String departamento;
	
	public Directivo(String nombre, double sueldo, String departamento) throws SueldoNegativoException, SueldoMaximoException {
		super(nombre, sueldo);
		this.departamento=departamento;
	}
	
	public void setDepartamento(String departamento) {
		this.departamento=departamento;
	}
	
	public String getDepartamento() {
		return this.departamento;
	}
	
	@Override
	public double getSueldoMaximo() {
		return 3500;
	}
	
	@Override
	public String toString() {
		return super.toString() + " | Puesto: Directivo | Departamento: " +departamento;
	}
	
}
