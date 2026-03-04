package POO4;

public class Jarra {
	
	private int capacidad; // Capacidad máxima de la jarra en litros
	private int agua;      // Cantidad de agua actual en la jarra
	
	// Constructor: recibe la capacidad máxima y el agua inicial
	// Lanza NumNegativoException si la capacidad es <= 0
	public Jarra(int capacidad, int agua) throws NumNegativoException {
		
		this.agua = agua;
		
		if(capacidad <= 0) { // Comprobamos el parámetro, no this.capacidad (que aún vale 0)
			throw new NumNegativoException();
		} else {
			this.capacidad = capacidad;
		}
	}
	
	// Setter de capacidad: igual que el constructor, valida el parámetro antes de asignarlo
	public void setCapacidad(int capacidad) throws NumNegativoException {
		if(capacidad <= 0) { // Comprobamos el parámetro, no this.capacidad
			throw new NumNegativoException();
		} else {
			this.capacidad = capacidad;
		}
	}
	
	// Getter de capacidad
	public int getCapacidad() {
		return this.capacidad;
	}
	
	// Setter de agua: asigna directamente la cantidad de agua
	public void setAgua(int agua) {
		this.agua = agua;
	}
	
	// Getter de agua
	public int getAgua() {
		return this.agua;
	}
	
	// Llena la jarra hasta su capacidad máxima
	public void llenarJarra() {
		this.agua = this.capacidad;
	}
	
	// Vacía la jarra completamente
	public void vaciarJarra() {
		this.agua = 0;
	}
}

