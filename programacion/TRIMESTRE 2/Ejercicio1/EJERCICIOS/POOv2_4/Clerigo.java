package POOv2_4;

public class Clerigo extends Personaje{
	
	private String dios;
	
	public Clerigo(String nombre, Raza raza, int fuerza, int inteligencia, int pvMax, String dios) throws AtributosInvalidosException{
		
		super(nombre, raza, fuerza, inteligencia, pvMax);
		
		if(inteligencia<12||inteligencia>16||fuerza<18) {
			throw new AtributosInvalidosException();
		}
		
		this.dios=dios;
		
	}
	
	public void curar(Personaje personaje) throws AtributosInvalidosException {
		
		personaje.setPVAct(personaje.getPVAct()+10);
		
	}
	
	@Override
	public String toString() {
		return super.toString()+" | Dios: " +dios;
	}

}
