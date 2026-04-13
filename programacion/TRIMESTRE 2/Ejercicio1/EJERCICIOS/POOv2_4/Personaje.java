package POOv2_4;

public class Personaje {
	
	private String nombre;
	private Raza raza;
	private int fuerza;
	private int inteligencia;
	private int pvMax;
	private int pvAct;
	
	public Personaje(String nombre, Raza raza, int fuerza, int inteligencia, int pvMax) throws AtributosInvalidosException{
	
		this.nombre=nombre;
		if(fuerza>20||fuerza<0) {
			throw new AtributosInvalidosException();
		}
		this.fuerza=fuerza;
		if(inteligencia>20||inteligencia<0) {
			throw new AtributosInvalidosException();
		}
		this.inteligencia=inteligencia;
		if(pvMax<0||pvMax>100) {
			throw new AtributosInvalidosException();
		}
		this.pvMax=pvMax;
		this.pvAct=pvMax;
		
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setFuerza(int fuerza) throws AtributosInvalidosException {
		if(fuerza>20||fuerza<0) {
			throw new AtributosInvalidosException();
		}
		this.fuerza=fuerza;
	}
	
	public int getFuerza() {
		return this.fuerza;
	}
	
	public void setInteligencia(int inteligencia) throws AtributosInvalidosException {
		if(inteligencia>20||inteligencia>0) {
			throw new AtributosInvalidosException();
		}
		this.inteligencia=inteligencia;
	}
	
	public int getInteligencia() {
		return this.inteligencia;
	}
	
	public void setPVMax(int pvMax) throws AtributosInvalidosException {
		if(pvMax<0||pvMax>100) {
			throw new AtributosInvalidosException();
		}
		this.pvMax=pvMax;
	}
	
	public int getPVMax() {
		return this.pvMax;
	}
	
	public void setPVAct(int pvAct) throws AtributosInvalidosException {
		if(pvAct<0||pvAct>pvMax) {
			throw new AtributosInvalidosException();
		}
		this.pvAct=pvAct;
	}
	
	public int getPVAct() {
		return this.pvAct;
	}
	
	@Override
	
	public String toString() {
		return "NOMBRE: " +nombre+ " | FUERZA: " +fuerza+ " | INTELIGENCIA: " +inteligencia+ " | PV MÁXIMOS: " +pvMax+ " | PV ACTUALES: " +pvAct;
	}
	
}
