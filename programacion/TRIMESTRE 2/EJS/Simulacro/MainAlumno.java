package Simulacro;
import java.util.*;

import Arrays.AlumnoEj13;

public class MainAlumno {
	
	public static Scanner teclado=new Scanner(System.in);
	
	public static void main(String[] args) throws NotaInvalidaException{
		
		String nombre;
		double nota=0;
		Alumno arrayAlumno[]= new Alumno[5];	//Creamos un array que contiene Alumnos de longitud 5.
		Alumno alumno1=null;	//Inicializamos en null, da igual ya que será modificado luego.
		Alumno alumno2=null;
		Alumno alumno3=null;
		Alumno alumno4=null;
		Alumno alumno5=null;
		
		try {	//Primer bloque try que intenta asignar nombre y nota al alumno1
		
		nombre=pedirNombre("Introduce el nombre del alumno: ");	//Pedimos nombre y nota
		nota=pedirNota("Introduce la nota del alumno: ");
		alumno1=new Alumno(nombre, nota);
		}catch(NotaInvalidaException n) {	//Bloque catch que atrapa la excepción si la nota no cumple los requisitos
			while(nota<0||nota>10) {
				System.out.println(n);
				nota=pedirNota("Introduce la nota del alumno:");
			}
			
		}
		teclado.nextLine();	//Limpiamos el teclado
		try {
			nombre=pedirNombre("Introduce el nombre del alumno: ");
			nota=pedirNota("Introduce la nota del alumno: ");
			alumno2=new Alumno(nombre, nota);
			}catch(NotaInvalidaException n) {
				while(nota<0||nota>10) {
					System.out.println(n);
					nota=pedirNota("Introduce la nota del alumno:");
				}
			}
		teclado.nextLine();	
		try {
			nombre=pedirNombre("Introduce el nombre del alumno: ");
			nota=pedirNota("Introduce la nota del alumno: ");
			alumno3=new Alumno(nombre, nota);
			}catch(NotaInvalidaException n) {
				while(nota<0||nota>10) {
					System.out.println(n);
					nota=pedirNota("Introduce la nota del alumno:");
				}
			}
		teclado.nextLine();	
		try {
			nombre=pedirNombre("Introduce el nombre del alumno: ");
			nota=pedirNota("Introduce la nota del alumno: ");
			alumno4=new Alumno(nombre, nota);
			}catch(NotaInvalidaException n) {
				while(nota<0||nota>10) {
					System.out.println(n);
					nota=pedirNota("Introduce la nota del alumno:");
				}
			}
		teclado.nextLine();	
		try {
			
			nombre=pedirNombre("Introduce el nombre del alumno: ");
			nota=pedirNota("Introduce la nota del alumno: ");
			alumno5=new Alumno(nombre, nota);
			}catch(NotaInvalidaException n) {
				while(nota<0||nota>10) {
					System.out.println(n);
					nota=pedirNota("Introduce la nota del alumno:");
				}
			}
		teclado.nextLine();	
		
		arrayAlumno[0]=alumno1;	//Asignamos cada objeto alumno a cada posicion del array
		arrayAlumno[1]=alumno2;
		arrayAlumno[2]=alumno3;
		arrayAlumno[3]=alumno4;
		arrayAlumno[4]=alumno5;
		
		System.out.println("Alumnos:");
		
		System.out.println(Arrays.toString(arrayAlumno)); //Mostramos el contenido del array
		
        Arrays.sort(arrayAlumno); 	//Ordenamos el array de peor a mejor nota

        System.out.println("Alumnos ordenados por nota:");
        for (Alumno a : arrayAlumno) {	//Bucle para mostrar uno a uno los alumnos con sus notas
            System.out.println(a.getNombre() + " : " + a.getNota());
        }
		
        Alumno mejor = arrayAlumno[0];	//Bucle para ver el alumno con mejor nota, que actualiza la nota si la anterior era peor.
        for (Alumno a : arrayAlumno) {
            if (a.getNota() > mejor.getNota()) {
                mejor = a;
            }
        }
        System.out.println("Alumno con mejor nota: " + mejor.getNombre() + " (" + mejor.getNota() + ")");
        
        for (Alumno a : arrayAlumno) {	//Bucle que suma uno a cada nota si no es 10
        	if(!(a.getNota()>9&&a.getNota()<=10)) {
        		a.setNota(a.getNota()+1);
        	}
        }
        System.out.println("Alumnos nuevos:");
        for (Alumno a : arrayAlumno) {	//Bucle para mostrar uno a uno los alumnos con sus notas
            System.out.println(a.getNombre() + " : " + a.getNota());
        }
        
        
	}
	
	public static String pedirNombre(String mensaje) {	//Metodo para pedir el nombre
		
		String s;
		System.out.print(mensaje);
		s=teclado.nextLine();
		return s;
		
	}
	
	public static double pedirNota(String mensaje) { //Metodo para pedir la nota
		
		double n;
		System.out.print(mensaje);
		n=teclado.nextDouble();
		return n;
		
	}

}
