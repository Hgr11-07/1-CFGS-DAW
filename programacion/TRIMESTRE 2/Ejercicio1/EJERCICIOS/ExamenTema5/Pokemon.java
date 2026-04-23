package ExamenTema5;

public abstract class Pokemon implements Entrenable{
	
	private int numeroPokedex;
	private String nombre;
	private Tipo tipo;
	private int nivelActual;
	private Movimiento[] movimientos;
	private int[][] aprendizaje;
	
	public Pokemon(int numeroPokedex, String nombre, Tipo tipo, int nivelActual, Movimiento[] movimientos, int[][] aprendizaje) {
		
		this.numeroPokedex=numeroPokedex;
		this.nombre=nombre;
		this.tipo=tipo;
		this.nivelActual=nivelActual;
		this.movimientos=movimientos;
		this.aprendizaje=aprendizaje;
		
	}
	
	public int getNumeroPokedex() {
		return this.numeroPokedex;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public Tipo getTipo() {
		return this.tipo;
	}
	
	public int getNivelActual() {
		return this.nivelActual;
	}
	
	public Movimiento[] getMovimientos() {
		return this.movimientos;
	}
	
	public int[][] getAprendizaje(){
		return this.aprendizaje;
	}
	
	@Override
	public String toString() {
		return "Nº Pokedex: " +numeroPokedex+ " | Nombre: " +nombre+ " | Tipo: " +tipo+ " | Nivel Actual: " +nivelActual;
	}
	
	public int calcularMovimientosDisponibles() {
		
		int n=0;
		
		for(int i=0; i<aprendizaje.length; i++){ 
				
				if(nivelActual>aprendizaje[i][0]) {
					n++;
				}
				
		}
		
		return n;
	}
	
	public double calcularPotenciaMediaDisponible() {
		
		double media=0;
		int cont=0;
		
		for(int i=0; i<aprendizaje.length; i++) {
				
				media+=aprendizaje[i][1];
				cont++;
			
		}
		
		return (media/cont);
		
	}
	
	public void mostrarMovimientosDisponibles() {
		
		for(int i=0; i<aprendizaje.length; i++) {
			
			if(nivelActual>aprendizaje[i][0]) {
				
				System.out.println(movimientos[i].getNombre());
				
			}
		}
		
	}
	
	public abstract double calcularIndiceCombate();
	
}
