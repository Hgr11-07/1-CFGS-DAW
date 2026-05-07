package Tema11_Ej6;

import java.util.*;

public class Diccionario {
	
	private ArrayList<Palabra> diccionario;
	
	public Diccionario() {
		diccionario= new ArrayList<Palabra>();
	}
	
	public void añadirPalabra(Palabra p) {
		
		ArrayList<String> significado = new ArrayList<String>();
		
		if(diccionario.isEmpty()) {
			diccionario.add(p);
		}
		
	}
}
