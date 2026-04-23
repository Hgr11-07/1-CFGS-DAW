package ExamenTema5;

public class PokemonDefensivo extends Pokemon{
	
	int resistencia;
	
	public PokemonDefensivo(int numeroPokedex, String nombre, Tipo tipo, int nivelActual, Movimiento[] movimientos, int[][] aprendizaje, int resistencia) {
		
		super(numeroPokedex, nombre, tipo, nivelActual, movimientos, aprendizaje);
		
		this.resistencia=resistencia;
		
	}
	
	@Override
	public double calcularIndiceCombate() {
		
		double indice;
		
		indice=calcularPotenciaMediaDisponible()+resistencia*1.5;
		
		return indice;
	}
	
	@Override
	public boolean necesitaMejorar() {
		
		if(calcularMovimientosDisponibles()==0 || getNivelActual()<20) {
			return true;
		}
		
		return false;
		
	}
	
}
