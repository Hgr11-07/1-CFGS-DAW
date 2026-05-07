package PROYECTO_FINAL;

public class Entrenador extends PersonaLiga{
	
	private int experiencia;
	private String especialidad;
	private int victoriasTotales;
	
	public Entrenador(int id, String nombre, String nickname, int edad, double salarioBase, int experiencia, String especialidad, int victoriasTotales) {
		super(id, nombre, nickname, edad, salarioBase);
		this.experiencia=experiencia;
		this.especialidad=especialidad;
		this.victoriasTotales=victoriasTotales;
	}
	
	public int getExperiencia() {
		return this.experiencia;
	}
	
	public String getEspecialidad() {
		return this.especialidad;
	}
	
	public int getVictoriasTotales() {
		return this.victoriasTotales;
	}
	
	public void setExperiencia(int experiencia) {
		this.experiencia=experiencia;
	}
	
	public void setEspecialidad(String especialidad) {
		this.especialidad=especialidad;
	}
	
	public void setVictoriasTotales(int victoriasTotales) {
		this.victoriasTotales=victoriasTotales;
	}
	
	@Override
	public String toString() {
		return super.toString()+" | Experiencia: " +experiencia+ " | Especialidad: " +especialidad+ " | Victorias Totales: " +victoriasTotales;
	}
	
	@Override
	public double calcularCosteMensual() {
		
		double salarioMensual;
		
		salarioMensual=getSalarioBase()+(victoriasTotales*10)+(experiencia*100);
		
		return salarioMensual;
		
	}
	
	public void mostrarResumen() {
		super.mostrarResumen();
		System.out.println("Es Entrenador");
		System.out.println("Años de Experiencia: " +experiencia);
		System.out.println("Especialidad: " +especialidad);
		System.out.println("Victorias Totales: "+victoriasTotales);
	}
	
}
