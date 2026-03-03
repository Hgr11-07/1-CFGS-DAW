package Simulacro;

import Arrays.AlumnoEj13;

public class Alumno implements Comparable<Alumno>{
	
	private String nombre;
	private double nota;
	
	public Alumno(String nombre, double nota) throws NotaInvalidaException{	//constructor que lanza la excepcion
		
		if(nota<0||nota>10) {
			throw new NotaInvalidaException();
		} else {
			this.nota=nota;
		}
		this.nombre=nombre;
		
	}
	
	public String getNombre() { //metodos getter y setter
		return this.nombre;
	}
	
	public void setNota(double nota) {
		this.nota=nota;
	}
	
	public double getNota() {
		return this.nota;
	}
	
	
	 public String toString() { //metodo tostring para ver el contenido del objeto
	        return "Alumno: " +nombre+ " || Nota: " + nota;
	    }
	 
	 @Override
	 public int compareTo(Alumno a) { //Sobreescribimos metodo compareTo
		if(this.nota>a.nota) {
			return 1;
		}
		else if(this.nota<a.nota) {
			return -1;
		}else {
			return 0;
		}
	 }
}
