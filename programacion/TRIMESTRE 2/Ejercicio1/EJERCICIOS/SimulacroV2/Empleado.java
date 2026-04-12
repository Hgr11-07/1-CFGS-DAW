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
		this.horasTrabajadas= horasTrabajadas;
		
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
		return "ID: " +this.id+ " | NOMBRE: " +this.nombre+ " | DEPARTAMENTO: " +this.departamento;
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
		
		for(int i=0; i<horasTrabajadas.length; i++) {
			for(int j=0; j<horasTrabajadas[i].length; j++) {
				if(j==0) 
					System.out.println("Día: " +(i+1)+" | Turno de mañana: " +horasTrabajadas[i][j]);
				else
					System.out.println("Día: " +(i+1)+" | Turno de tarde: " +horasTrabajadas[i][j]);
			}
		}
		
	}

}
