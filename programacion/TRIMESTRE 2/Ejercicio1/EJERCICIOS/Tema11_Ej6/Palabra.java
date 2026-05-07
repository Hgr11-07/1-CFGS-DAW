package Tema11_Ej6;

import java.util.ArrayList;

public class Palabra {
	
	private String nombre;
	private ArrayList<String> significado;
	
	public Palabra(String nombre) {
		
		this.nombre=nombre;
		significado = new ArrayList<String>();
		
	}
	
	public String getNombre() {
		return nombre;
	}
	
	@Override
	public String toString() {
		return "Nombre: " +nombre;
	}
	
	public void mostrarSignificados() {
		
		for(String s : significado) {
			System.out.println(s);
		}
		
	}

}
