package ExamenTema5;

public class PokemonOfensivo extends Pokemon{
	
	private int ataquesFuertes;
	
	public PokemonOfensivo(int numeroPokedex, String nombre, Tipo tipo, int nivelActual, Movimiento[] movimientos, int[][] aprendizaje, int ataquesFuertes) {
		
		super(numeroPokedex, nombre, tipo, nivelActual, movimientos, aprendizaje);
		
		this.ataquesFuertes=ataquesFuertes;
		
	}
	
	@Override
	public double calcularIndiceCombate() {
		
		double indice;
		
		indice=calcularPotenciaMediaDisponible()+ataquesFuertes*2;
		
		return indice;
		
	}
	
	@Override
	public boolean necesitaMejorar() {
		
		if(calcularMovimientosDisponibles()<2 || calcularPotenciaMediaDisponible()<50) {
			return true;
		}
		
		return false;
		
	}
	
	@Override
	public String toString() {
		
		return super.toString()+" | MovsFuertes: " +ataquesFuertes;
		
	}
	
}
