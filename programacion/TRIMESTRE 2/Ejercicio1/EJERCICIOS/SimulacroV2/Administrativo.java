package SimulacroV2;

public class Administrativo extends Empleado{
	
	private int documentosTramitados;
	
	public Administrativo(String id, String nombre, Departamento departamento, double horasTrabajadas[][], int documentosTramitados) {
		
		super(id, nombre, departamento, horasTrabajadas);
		this.documentosTramitados=documentosTramitados;
		
	}
	
	@Override
	public String toString() {
		return super.toString()+" | DOCUMENTOS TRAMITADOS: " +documentosTramitados;
	}
	
	@Override
	public double calcularProductividad() {
		
		double productividad;
		
		productividad=calcularHorasTotalesSemana()+documentosTramitados*0.5;
		return productividad;
		
	}
	
	@Override
	public boolean mereceReconocimiento() {
		
		if(calcularProductividad()>=40) {
			return true;
		} else {
			return false;
		}
		
	}

}
