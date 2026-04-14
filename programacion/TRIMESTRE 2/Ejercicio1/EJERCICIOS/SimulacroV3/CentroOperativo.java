package SimulacroV3;

public abstract class CentroOperativo implements Supervisable{
	
	private String codigo;
	private Zona zona;
	private Responsable responsable;
	private int operaciones[][];
	private int incidencias[][];
	
	public CentroOperativo(String codigo, Zona zona, Responsable responsable, int operaciones[][], int incidencias[][]) {
		
		this.codigo=codigo;
		this.zona=zona;
		this.responsable=responsable;
		this.operaciones=operaciones;
		this.incidencias=incidencias;
		
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public Zona getZona() {
		return zona;
	}
	
	public Responsable getResponsable() {
		return responsable;
	}
	
	public int[][] getOperaciones(){
		return operaciones;
	}
	
	public int[][] getIncidencias() {
		return incidencias;
	}
	
	public String toString() {
		return "Codigo: " +codigo+ " | Zona: " +zona+ " | Responsable: " +responsable+ " | Operaciones: " +operaciones+ " | Incidencias: " +incidencias;
	}
	
	public int calcularTotalOperaciones() {
		
		int total=0;
		
		for(int i=0; i<operaciones.length; i++) {
			for(int j=0; j<operaciones[i].length; j++) {
				total+=operaciones[i][j];
			}
		}
		
		return total;
		
	}
	
	public int calcularTotalIncidencias() {

		int total=0;
		
		for(int i=0; i<incidencias.length; i++) {
			for(int j=0; j<incidencias[i].length; j++) {
				total+=incidencias[i][j];
			}
		}
		
		return total;
		
	}
	
	public int calcularOperacionesDia(int dia) {
		
		int total=0;
		
		for(int i=0; i<incidencias.length; i++) {
			
			if(dia==i) {
				
				for(int j=0; j<incidencias[i].length; j++) {
					total+=incidencias[i][j];
				}
				
			}
			
		}
		
		return total;
		
	}
	
	
	
}
