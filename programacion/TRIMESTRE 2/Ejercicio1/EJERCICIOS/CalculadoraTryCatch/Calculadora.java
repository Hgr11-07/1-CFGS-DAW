package CalculadoraTryCatch;

import java.util.*;

public class Calculadora {
	
	public static void main (String[] args) throws OperacionInvalidaException, DivisionEntreCeroException{
		
		Scanner sc=new Scanner(System.in);
		
		int a;
		int b;
		char op;
		
		a=leerEntero("Introduce el primer numero entero", sc);
		b=leerEntero("Introduce el segundo numero entero", sc);
		menu();
		op=leerOperacion(sc);
		calcular(a, b, op);
		
	}
	
	public static int leerEntero(String mensaje, Scanner sc){

		int n=0;
		boolean correcto=false;
		System.out.println(mensaje);
		
		while(!correcto) {
			try {
				n=sc.nextInt();
				correcto=true;
				
			}catch(InputMismatchException e) {
				System.out.println("ERROR: Introduce un numero entero " +e);
				sc.nextLine();
			}
		}
		return n;
	}
	
	public static char leerOperacion(Scanner sc) throws OperacionInvalidaException{
		
		char c='a';
		boolean correcto=false;
		
		while(!correcto) {
			try {
				c=sc.next().charAt(0);
				if(c!='+'&&c!='-'&&c!='*'&&c!='/') {
					throw new OperacionInvalidaException();
				}
				correcto=true;
			}catch(OperacionInvalidaException e) {
				System.out.println("ERROR: Operación inválida. " +e);
				sc.nextLine();
			}
			
			
		}
		return c;		
	}
	
	public static void menu(){
		
		System.out.println("¿QUÉ OPERACIÓN DESEA HACER?");
		System.out.println("Sumar (+)");
		System.out.println("Restar (-)");
		System.out.println("Multiplicar (*)");
		System.out.println("Dividir (/)");
	}
	
	public static void calcular(int a, int b, char op) throws DivisionEntreCeroException{
		
		Scanner sc=new Scanner(System.in);
		
		int res=0;
		boolean ok=false;
		
		switch(op) {
		
			case '+':
				res=a+b;
				break;
			
			case '-':
				res=a-b;
				break;
			
			case '*':
				res=a*b;
				break;
				
			case '/':
				while(!ok) {
					try {
						if(b==0) {
							throw new DivisionEntreCeroException();
						} else {
							ok=true;
						}
					}catch(DivisionEntreCeroException d) {
							System.out.println("ERROR: No se puede dividir entre cero " +d);
							b=leerEntero("Introduce el segundo numero entero", sc);
					}
				}
				
				res=a/b;
				break;
			}
		
		System.out.println(+a+ " " +op+ " " +b+ " = " +res);
	}
	
}
