package ExamenTema5;

public class Principal {
	
	public static void main(String[] args) {
		
		Movimiento[] movs1 = new Movimiento[4];
		movs1[0] = new Movimiento("Placaje", Tipo.PLANTA, 40);
		movs1[1] = new Movimiento("Placaje1", Tipo.FUEGO, 60);
		movs1[2] = new Movimiento("Placaje2", Tipo.PLANTA, 70);
		movs1[3] = new Movimiento("Placaje3", Tipo.PLANTA, 100);
		
		Movimiento[] movs2 = new Movimiento[4];
		movs2[0] = new Movimiento("Placaje", Tipo.PLANTA, 40);
		movs2[1] = new Movimiento("Placaje1", Tipo.FUEGO, 60);
		movs2[2] = new Movimiento("Placaje2", Tipo.PLANTA, 70);
		movs2[3] = new Movimiento("Placaje3", Tipo.PLANTA, 80);
		
		Movimiento[] movs3 = new Movimiento[4];
		movs3[0] = new Movimiento("Placaje", Tipo.PLANTA, 20);
		movs3[1] = new Movimiento("Placaje1", Tipo.FUEGO, 10);
		movs3[2] = new Movimiento("Placaje2", Tipo.PLANTA, 60);
		movs3[3] = new Movimiento("Placaje3", Tipo.PLANTA, 80);
		
		Movimiento[] movs4 = new Movimiento[4];
		movs4[0] = new Movimiento("Placaje", Tipo.PLANTA, 40);
		movs4[1] = new Movimiento("Placaje1", Tipo.FUEGO, 90);
		movs4[2] = new Movimiento("Placaje2", Tipo.PLANTA, 70);
		movs4[3] = new Movimiento("Placaje3", Tipo.PLANTA, 80);
		
		int[][] apr1 = {
				{3,40},
				{4,60},
				{2,70},
				{100,100},
			};
		
		int[][] apr2 = {
				{30,40},
				{40,60},
				{75,70},
				{100,80},
			};
		
		int[][] apr3 = {
				{30,20},
				{40,10},
				{75,60},
				{100,80},
			};
		
		int[][] apr4 = {
				{30,40},
				{40,90},
				{75,70},
				{100,80},
			};
		
		
		Pokemon[] pokemons = new Pokemon[4];
		
		pokemons[0]= new PokemonOfensivo(1, "Bulbasaur", Tipo.PLANTA, 5, movs1, apr1, 1) ;
		pokemons[1]= new PokemonOfensivo(2, "B", Tipo.PLANTA, 50, movs2, apr2, 2) ;
		pokemons[2]= new PokemonOfensivo(3, "Bu", Tipo.PLANTA, 10, movs3, apr3, 1) ;
		pokemons[3]= new PokemonOfensivo(4, "Bul", Tipo.AGUA, 100, movs4, apr4, 3) ;
		
		mostrarInfo(pokemons);
		mostrarMayorIndice(pokemons);
		contarTipos(pokemons);
		movMasPotente(pokemons);
		masMovs(pokemons);
		
		
	}
	
	public static void mostrarInfo(Pokemon[] pokemons) {
		
		for(int i=0; i<pokemons.length; i++) {
			
			System.out.println(pokemons[i].toString());
			pokemons[i].mostrarMovimientosDisponibles();
			System.out.println("Potencia Media:" +pokemons[i].calcularPotenciaMediaDisponible());
			System.out.println("Indice Combate: " +pokemons[i].calcularIndiceCombate());
			System.out.println("¿Necesita Mejora?: " +pokemons[i].necesitaMejorar());
			
		}
		
	}
	
	public static void mostrarMayorIndice(Pokemon[] pokemons) {
		
		double m;
		int in=0;
		m=pokemons[0].calcularIndiceCombate();
		
		for(int i=1; i<pokemons.length; i++) {
			
			if(pokemons[i].calcularIndiceCombate()>m) {
				
				m=pokemons[i].calcularIndiceCombate();
				in=i;
				
			}
			
		}
		
		System.out.println("MAYOR INDICE DE COMBATE ES:" +pokemons[in].getNombre()+ " DE TIPO " +pokemons[in].getTipo()+ " CON INDICE " +pokemons[in].calcularIndiceCombate());
		
	}
	
	public static void contarTipos(Pokemon[] pokemons) {
		
		int of=0;
		int def=0;
		
		for(int i=0; i<pokemons.length; i++) {
			
			if(pokemons[i] instanceof PokemonOfensivo) {
				of++;
			} else if(pokemons[i] instanceof PokemonDefensivo) {
				def++;
			}
			
		}
		
		System.out.println("Hay " +of+ " ofensivos y " +def+ " defensivos.");
		
	}
	
	public static void movMasPotente(Pokemon[] pokemons) {
		
		int mov=pokemons[0].getAprendizaje()[0][1];
		int indice=0;
		int indPoke=0;
		
		for(int i=0; i<pokemons.length; i++) {
			
			for(int j=0; j<pokemons[i].getAprendizaje().length; j++) {
				
				for(int k=0; k<pokemons[i].getAprendizaje()[j].length; k++) {
					
					if(pokemons[i].getAprendizaje()[j][1]>mov && pokemons[i].getAprendizaje()[j][0] <= pokemons[i].getNivelActual()) {
						
						mov=pokemons[i].getAprendizaje()[j][1];
						indice=j;
						indPoke=i;
						
					}
					
				}
				
			}
			
		}
		
		System.out.println("Movimiento mas potente: " +pokemons[indPoke].getMovimientos()[indice].getNombre()+ " de " +pokemons[indPoke].getNombre()+ " de potencia: " +pokemons[indPoke].getMovimientos()[indice].getPotencia());
		
	}
	
	public static void masMovs(Pokemon[] pokemons) {
		
		int mas=pokemons[0].calcularMovimientosDisponibles();
		int m=0;
		
		for(int i=1; i<pokemons.length; i++) {
			
			if(pokemons[i].calcularMovimientosDisponibles()>mas) {
				
				mas=pokemons[i].calcularMovimientosDisponibles();
				m=i;
				
			}
			
		}
		
		System.out.println("Pokemon con mas movs: " +pokemons[m].getNombre()+ " con " +pokemons[m].calcularMovimientosDisponibles());
		
	}
	

}
