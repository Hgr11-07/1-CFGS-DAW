package Ejercicio2;

import java.util.*;

public class Cuenta {
	
	private static Scanner teclado=new Scanner(System.in);

	private double saldo;
	
	public Cuenta() {
		
	}
	
	public void setSaldo(double saldo) {
		this.saldo=saldo;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public double reintegro() {
		
		double retirar;
		double total;
		
		System.out.println("Introduzca la cantidad a retirar:");
		retirar=teclado.nextDouble();
		
		while(retirar>saldo) {
			
			System.out.println("No dispones de saldo suficiente.");
			System.out.println("Introduzca la cantidad a retirar:");
			retirar=teclado.nextDouble();
			
		}
		
		total=this.saldo-retirar;
		return total;
		
	}
	
	public double ingreso() {
		
		double ingreso;
		double total;
		
		System.out.println("Introduzca la cantidad a ingresar:");
		ingreso=teclado.nextDouble();
		
		total=this.saldo+ingreso;
		return total;
		
	}
	
	
}
