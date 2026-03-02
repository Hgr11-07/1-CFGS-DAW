package Ejercicio2;

import java.util.*;

public class Ejercicio2 {
	
	private static Scanner teclado=new Scanner (System.in);
	
	public static void main(String[] args) {
		
		double saldo;
		
		System.out.println("Introduzca su saldo inicial: ");
		saldo=teclado.nextDouble();
		
		menu(saldo);
		
		
	}
	
	public static void menu(double saldo) {
		
		Cuenta cuenta1=new Cuenta();
		cuenta1.setSaldo(saldo);
		
		double total=saldo;
		int opcion;
		
		ensenarMenu();
		
		opcion=teclado.nextInt();
		
		while(opcion<1||opcion>4) {
		
			System.out.println("Introduce una opción válida");
			opcion=teclado.nextInt();
			
		}
			while(opcion>0&&opcion<5) {
			
				if(opcion!=4) {
					
					opciones(opcion, total);
					ensenarMenu();
					opcion=teclado.nextInt();
				
				} else {
					if(confirmacion(saldo)==true) {
						break;
					} else {
						ensenarMenu();
						opcion=teclado.nextInt();
					}
				
				}
			}
		
	}
	
	public static void ensenarMenu() {

		System.out.println("1.Retirar dinero.");
		System.out.println("2.Ingresar dinero.");
		System.out.println("3.Consultar saldo y operaciones.");
		System.out.println("4.Finalizar");
		System.out.println();
		System.out.println("Introduzca el número de la operación que desee realizar:");
	
	}
	
	public static boolean confirmacion(double total){
		
		char confirmar;
		
		System.out.println("¿Seguro que desea salir? (S/N)");
		confirmar=teclado.next().charAt(0);
		
		while(confirmar!='S'&&confirmar!='N') {
			System.out.println("Introduce una opción válida");
			confirmar=teclado.next().charAt(0);
		}
		
		if(confirmar=='S') {
			
			System.out.println("Su saldo es: "+total);
			return true;
			
		}else return false;
		
	}
	
	public static void opciones(int opcion, double total) {
		
		int contRetirar=0;
		int contIngresar=0;
		
		Cuenta cuenta1=new Cuenta();
		
		
		switch(opcion) {
		
		case 1:
			total=cuenta1.reintegro();
			cuenta1.setSaldo(total);
			contRetirar++;
			break;
		case 2:
			total=cuenta1.ingreso();
			cuenta1.setSaldo(total);
			contIngresar++;
			break;
		case 3:
			System.out.println("Su saldo es: "+total);
			System.out.println("Ha hecho " +contRetirar+ " reintegros y " +contIngresar+ " ingresos.");
			break;
		}
		
	}

}
