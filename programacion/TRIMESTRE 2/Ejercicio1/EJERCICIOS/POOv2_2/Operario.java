package POOv2_2;

public class Operario extends Empleado{
	
	private int nave;
	
	public Operario(String nombre, double sueldo, int nave) throws SueldoNegativoException, SueldoMaximoException, NaveInvalidaException {
		super(nombre, sueldo);
		setNave(nave);
	}
	
	public void setNave(int nave) throws NaveInvalidaException {
		if(nave<1||nave>5) {
			throw new NaveInvalidaException();
		}
		this.nave=nave;
	}
	
	public int getNave() {
		return this.nave;
	}	
	
	@Override
	public double getSueldoMaximo() {
		return 1200;
	}
	
	@Override
	public String toString() {
		return super.toString()+" | Puesto: Operario | Nave: " +nave;
	}

}
