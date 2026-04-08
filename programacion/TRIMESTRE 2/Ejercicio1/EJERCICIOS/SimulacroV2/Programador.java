package SimulacroV2;

public class Programador extends Empleado{
	
	int incidenciasResueltas;
	
	public Programador(String id, String nombre, Departamento departamento, double horasTrabajadas[][], int incidenciasResueltas){
		super(id, nombre, departamento, horasTrabajadas);
		this.incidenciasResueltas=incidenciasResueltas;
	}
	
	@Override
	public String toString() {
		return super.toString()+" | INCIDENCIAS RESUELTAS: " +incidenciasResueltas;
	}
	
	@Override
	public double calcularProductividad() {
		
		double productividad;
		
		productividad=calcularHorasTotalesSemana()+incidenciasResueltas*2;
		return productividad;
		
	}
	
	@Override
	public boolean mereceReconocimiento() {
		
		if(calcularProductividad()>=45) {
			return true;
		} else {
			return false;
		}
		
	}
	

}
