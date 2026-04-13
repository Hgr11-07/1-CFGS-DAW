package POOv2_4;

public class Mago extends Personaje{
	
	private String hechizos[];
	
	public Mago(String nombre, Raza raza, int fuerza, int inteligencia, int pvMax) throws AtributosInvalidosException {
		
		super(nombre, raza, fuerza, inteligencia, pvMax);
		
		if(inteligencia<17||fuerza>15) {
			throw new AtributosInvalidosException();
		}
		
		this.hechizos=new String[4];
		
	}
	
	public void aprendeHechizo(String hechizo) {
		
		for(int i=0; i<hechizos.length; i++) {
			if(hechizos[i]==null) {
				hechizos[i]=hechizo;
				break;
			}
		}
		
	}
	
	
	
}
