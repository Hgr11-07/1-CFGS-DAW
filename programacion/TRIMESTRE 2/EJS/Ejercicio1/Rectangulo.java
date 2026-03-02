package Ejercicio1;

public class Rectangulo {

	private double longitud;
	private double ancho;
	
	public Rectangulo(){
		longitud=1;
		ancho=1;
	}
		
	public void setLongitud (double longitud){
		
		if(longitud>0&&longitud<20) {
			this.longitud=longitud;	
		}
	}
	
	public double getLongitud() {
		
		return this.longitud;
		
	}
	
	public void setAncho(double ancho) {
		
		if(ancho>0&&ancho<20) {
			
			this.ancho=ancho;	
		}
		
	}
	
	public double getAncho() {
		
		return this.ancho;
		
	}
	
	public double calcularPerimetro() {
		
		double perimetro=2*this.longitud+2*this.ancho;
		
		return perimetro;
	}
	
	public double calcularArea() {
		
		double area=this.longitud*this.ancho;
		
		return area;
		
	}
	
}
