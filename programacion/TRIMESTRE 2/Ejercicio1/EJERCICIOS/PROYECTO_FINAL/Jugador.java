package PROYECTO_FINAL;

public class Jugador extends PersonaLiga implements Entrenable{
	
	private Rol rol;
	private double nivelMecanico;
	private double nivelEstrategico;
	private int partidasJugadas;
	private int mvpsTotales;
	private boolean sancionado;
	
	public Jugador(int id, String nombre, String nickname, int edad, double salarioBase, Rol rol, double nivelMecanico, double nivelEstrategico, int partidasJugadas, int mvpsTotales, boolean sancionado) {
		
		super(id, nombre, nickname, edad, salarioBase);
		this.rol=rol;
		this.nivelMecanico=nivelMecanico;
		this.nivelEstrategico=nivelEstrategico;
		this.partidasJugadas=partidasJugadas;
		this.mvpsTotales=mvpsTotales;
		this.sancionado=sancionado;
	}
	
	public Rol getRol() {
		return this.rol;
	}
	
	public double getNivelMecanico() {
		return this.nivelMecanico;
	}
	
	public double getNivelEstrategico() {
		return this.nivelEstrategico;
	}
	
	public int getPartidasJugadas() {
		return this.partidasJugadas;
	}
	
	public int getMvpsTotales() {
		return this.mvpsTotales;
	}
	
	public boolean getSancionado() {
		return this.sancionado;
	}
	
	public void setRol(Rol rol) {
		this.rol=rol;
	}
	
	public void setNivelMecanico(double nivelMecanico) {
		this.nivelMecanico=nivelMecanico;
	}
	
	public void setNivelEstrategico(double nivelEstrategico) {
		this.nivelEstrategico=nivelEstrategico;
	}
	
	public void setPartidasJugadas(int partidasJugadas) {
		this.partidasJugadas=partidasJugadas;
	}
	
	public void setMvpsTotales(int mvpsTotales) {
		this.mvpsTotales=mvpsTotales;
	}
	
	public void setSancionado(boolean sancionado) {
		this.sancionado=sancionado;
	}
	
	@Override
	public String toString() {
		return super.toString()+" | Rol: " +rol+ " | Nivel Mecánico: " +nivelMecanico+ " | Nivel Estrategico: " +nivelEstrategico+ " | Partidas Jugadas: " +partidasJugadas+ " | MVPs Totales: " +mvpsTotales+ " | Sancionado: " +sancionado;
	}
	
	@Override
	public double calcularCosteMensual() {
		
		double salarioMensual;
		
		salarioMensual=getSalarioBase()+(mvpsTotales*100);
		
		if(partidasJugadas>=500)
			salarioMensual+=300;
		
		return salarioMensual;
	}
	
	public void mostrarResumen() {
		super.mostrarResumen();
		System.out.println("Es Jugador");
		System.out.println("Rol: " +rol);
		System.out.println("Nivel Mecánico: " +nivelMecanico);
		System.out.println("Nivel Estratégico: " +nivelEstrategico);
		System.out.println("Partidas Jugadas: " +partidasJugadas);
		System.out.println("MVPs Totales: " +mvpsTotales);
		if(sancionado)
			System.out.println("¿Está sancionado?: Sí");
		else
			System.out.println("¿Está sancionado?: No");
	}

	@Override
	public void entrenar() {
		nivelMecanico++;
		nivelEstrategico++;
	}

	@Override
	public double calcularRendimiento() {
		double rendimiento;
		rendimiento=(nivelMecanico+nivelEstrategico)/2;
		
		if(partidasJugadas>0 && (double)mvpsTotales/partidasJugadas>=0.5) {
			rendimiento+=5;
		}
		
		if(rendimiento>10) {
			rendimiento=10;
		}
		
		return rendimiento;
	}
}
