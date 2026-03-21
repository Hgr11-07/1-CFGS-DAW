package Poo2;

public class Linea {
	
	private Punto puntoA;
	private Punto puntoB;
	
	

	public Linea(Punto puntoA, Punto puntoB) throws PuntosIgualesException {

		this.puntoA=puntoA;
		this.puntoB=puntoB;
		
		if(puntoA.getPuntoX()==puntoB.getPuntoX()&&puntoA.getPuntoY()==puntoB.getPuntoY()) {
			throw new PuntosIgualesException();
		}
	}
	
	public void setPuntoA(Punto puntoA) {
		this.puntoA=puntoA;
	}
	public Punto getPuntoA() {
		return this.puntoA;
	}
	public void setPuntoB(Punto puntoB) {
		this.puntoB=puntoB;
	}
	public Punto getPuntoB() {
		return this.puntoB;
	}
	
	@Override
	public boolean equals(Object obj) { //(2,1)(3,2) (3,2)(2,1)
		
		Linea l = (Linea) obj;
		
	    if(this.puntoA.getPuntoX() == l.puntoA.getPuntoX() && this.puntoA.getPuntoY() == l.puntoA.getPuntoY() && this.puntoB.getPuntoX() == l.puntoB.getPuntoX() && this.puntoB.getPuntoY() == l.puntoB.getPuntoY()) {
	        return true;
	    }

	    if(this.puntoA.getPuntoX() == l.puntoB.getPuntoX() && this.puntoA.getPuntoY() == l.puntoB.getPuntoY() && this.puntoB.getPuntoX() == l.puntoA.getPuntoX() && this.puntoB.getPuntoY() == l.puntoA.getPuntoY()) {
	        return true;
	    }

	    return false;
	}
	
	public void moverDerecha(double distancia) {

		this.puntoA.setPuntoX(distancia+this.puntoA.getPuntoX());
		this.puntoB.setPuntoX(distancia+this.puntoB.getPuntoX());
		
	}
	
	public void moverIzquierda(double distancia) {

		this.puntoA.setPuntoX(this.puntoA.getPuntoX()-distancia);
		this.puntoB.setPuntoX(this.puntoB.getPuntoX()-distancia);
		
	}
	
	public void moverArriba(double distancia) {

		this.puntoA.setPuntoY(distancia+this.puntoA.getPuntoY());
		this.puntoB.setPuntoY(distancia+this.puntoB.getPuntoY());
		
	}
	
	public void moverAbajo(double distancia) {

		this.puntoA.setPuntoY(this.puntoA.getPuntoY()-distancia);
		this.puntoB.setPuntoY(this.puntoB.getPuntoY()-distancia);
		
	}
	
	public String mostrarLinea() {
		
		return "[("+this.puntoA.getPuntoX()+","+this.puntoA.getPuntoY()+"),("+this.puntoB.getPuntoX()+","+this.puntoB.getPuntoY()+")]";
		
	}
	
	
}
