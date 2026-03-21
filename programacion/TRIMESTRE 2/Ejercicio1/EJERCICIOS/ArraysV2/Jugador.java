package ArraysV2;

public class Jugador {
	
	private String nombre;
	private char ficha;
	
	public Jugador(String nombre, char ficha) throws FichaInvalidaException{
		this.nombre=nombre;
		if(Character.toUpperCase(ficha)!='R' && Character.toUpperCase(ficha)!='A') {
			throw new FichaInvalidaException();
		}
		this.ficha=ficha;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public char getFicha() {
		return ficha;
	}
	
	public void setFicha(char ficha) throws FichaInvalidaException{
		if(Character.toUpperCase(ficha)!='R' && Character.toUpperCase(ficha)!='A') {
			throw new FichaInvalidaException();
		}
		this.ficha=ficha;
	}

}
