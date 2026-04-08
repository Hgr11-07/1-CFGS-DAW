package POOv2_2;
import java.util.*;

public class Ejercicio_2 {
	
	public static Scanner teclado=new Scanner(System.in);
	
	public static void main(String[] args) {
		
		String nombre;
		double sueldo;
		int nave;
		Especialidad especialidad=null;
		String es;
		String departamento;
		boolean correcto=false;
		Operario operario=null;
		Informatico informatico=null;
		Directivo directivo=null;
		
		System.out.println("--INFORMACIÓN DE OPERARIO--");
		System.out.println();
		while(!correcto) {
			try {
				System.out.println("Introduce tu nombre: ");
				nombre=teclado.nextLine();
				System.out.println("Introduce tu sueldo: ");
				sueldo=teclado.nextDouble();
				System.out.println("¿En qué nave trabajas?: ");
				nave=teclado.nextInt();
				teclado.nextLine();
				operario = new Operario (nombre, sueldo, nave);
				correcto=true;
			}catch(SueldoNegativoException e) {
				System.out.println(e);
				teclado.nextLine();
			} catch (SueldoMaximoException e) {
				System.out.println(e);
				teclado.nextLine();
			} catch (NaveInvalidaException e) {
				System.out.println(e);
			}
		}
		
		correcto=false;
		
		System.out.println();
		System.out.println();
		System.out.println("--INFORMACIÓN DE PROGRAMADOR--");
		System.out.println();
		
		while(!correcto) {
			try {
				System.out.println("Introduce tu nombre: ");
				nombre=teclado.nextLine();
				System.out.println("Introduce tu sueldo: ");
				sueldo=teclado.nextDouble();
				teclado.nextLine();
				System.out.println("Introduce tu especialidad: ");
				es=teclado.nextLine();
				especialidad = Especialidad.valueOf(es.toUpperCase());
				informatico = new Informatico (nombre, sueldo, especialidad);
				correcto=true;
			}catch(SueldoNegativoException e) {
				System.out.println(e);
				teclado.nextLine();
			} catch (SueldoMaximoException e) {
				System.out.println(e);
				teclado.nextLine();
			} catch (IllegalArgumentException e) {
				System.out.println(e+" ERROR: Especialidad indefinida.");
			}
		}
		
		correcto=false;
		
		System.out.println();
		System.out.println();
		System.out.println("--INFORMACIÓN DE DIRECTIVO--");
		System.out.println();
		
		while(!correcto) {
			try {
				System.out.println("Introduce tu nombre: ");
				nombre=teclado.nextLine();
				System.out.println("Introduce tu sueldo: ");
				sueldo=teclado.nextDouble();
				teclado.nextLine();
				System.out.println("Introduce tu departamento: ");
				departamento=teclado.nextLine();
				directivo = new Directivo (nombre, sueldo, departamento);
				correcto=true;
			}catch(SueldoNegativoException e) {
				System.out.println(e);
				teclado.nextLine();
			} catch (SueldoMaximoException e) {
				System.out.println(e);
				teclado.nextLine();
			}
		}
		
		System.out.println();
		System.out.println(operario);
		System.out.println();
		System.out.println(informatico);
		System.out.println();
		System.out.println(directivo);
		
	}
}
