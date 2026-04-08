package SimulacroV2;

public abstract class Empleado implements Reconocible{
	
	private String id;
	private String nombre;
	Departamento departamento;
	double horasTrabajadas[][];
	
	public Empleado(String id, String nombre, Departamento departamento, double horasTrabajadas[][]) {
		
		this.id=id;
		this.nombre=nombre;
		this.departamento=departamento;
		this.horasTrabajadas= new double [5][2];
		
	}
	
	public String getId() {
		return this.id;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public Departamento getDepartamento() {
		return this.departamento;
	}
	
	public double[][] getHorasTrabajadas() {
		return this.horasTrabajadas;
	}
	
	@Override
	public String toString() {
		return "ID: " +this.id+ " | NOMBRE: " +this.nombre+ " | DEPARTAMENTO: " +this.departamento+ " | HORAS TRABAJADAS: " +this.horasTrabajadas;
	}
	
	public double calcularHorasTotalesSemana() {
		
	double total=0;
		
		for(int i=0; i<horasTrabajadas.length; i++) {
			for(int j=0; j<horasTrabajadas[i].length; j++) {
				total=total+horasTrabajadas[i][j];
			}
		}
		
		return total;
		
	}
	
	public double calcularHorasTotalesDia(int dia) {	//5 dias x 2 turnos;
		
		double total=0;
		
		for (int i=0; i<horasTrabajadas.length; i++) {
			
			if(dia==i) {
				
				for (int j=0; j<horasTrabajadas[i].length; j++) {
					total=total+horasTrabajadas[i][j];
				}
			}
	
		}
		
		return total;
		
	}
	
	public abstract double calcularProductividad();
	
	public void mostrarHorario() {
		
	}

}
