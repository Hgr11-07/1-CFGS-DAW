package SimulacroV2;
import java.util.*;

public class Principal {
	
	public static Scanner teclado = new Scanner (System.in);
	
	public static void main(String[] args) {
		
		String id;
		String nombre;
		String dep;
		Departamento departamento = null;
		int contP=0;
		int contA=0;
		
		double[][] horas1 = {
				{4, 3},
				{4, 4},
				{5, 3},
				{4, 4},
				{3, 2}
				};
		
		double[][] horas2 = {
				{4, 5},
				{1, 6},
				{4, 2},
				{1, 7},
				{4, 2}
				};
		
		double[][] horas3 = {
				{6, 1},
				{3, 2},
				{4, 6},
				{2, 8},
				{3, 9}
				};
		
		double[][] horas4 = {
				{6, 5},
				{1, 4},
				{2, 3},
				{6, 4},
				{2, 2}
				};
		
		int incidencias;
		int documentosTramitados;
		
		Empleado empleado1[] = new Empleado[4];
		
		for(int i=0; i<empleado1.length; i++) {
			switch(i) {
			case 0:
				id=pedirNombreIdDep("Introduce tu ID: ");
				nombre=pedirNombreIdDep("Introduce tu nombre: ");
				dep=pedirNombreIdDep("Introduce el departamento: ");
				departamento=Departamento.valueOf(dep.toUpperCase());
				incidencias=pedirIncidenciasDocumentos("¿Cuántas incidencias ha resuelto?: ");
				empleado1[i]= new Programador(id, nombre, departamento, horas1, incidencias);
				break;
			case 1:
				id=pedirNombreIdDep("Introduce tu ID: ");
				nombre=pedirNombreIdDep("Introduce tu nombre: ");
				dep=pedirNombreIdDep("Introduce el departamento: ");
				departamento=Departamento.valueOf(dep.toUpperCase());
				incidencias=pedirIncidenciasDocumentos("¿Cuántas incidencias ha resuelto?: ");
				empleado1[i]= new Programador(id, nombre, departamento, horas2, incidencias);
				break;
			case 2:
				id=pedirNombreIdDep("Introduce tu ID: ");
				nombre=pedirNombreIdDep("Introduce tu nombre: ");
				dep=pedirNombreIdDep("Introduce el departamento: ");
				departamento=Departamento.valueOf(dep.toUpperCase());
				documentosTramitados=pedirIncidenciasDocumentos("¿Cuantos documentos ha tramitado?");
				empleado1[i]= new Administrativo(id, nombre, departamento, horas3, documentosTramitados);
				break;
			case 3:
				id=pedirNombreIdDep("Introduce tu ID: ");
				nombre=pedirNombreIdDep("Introduce tu nombre: ");
				dep=pedirNombreIdDep("Introduce el departamento: ");
				departamento=Departamento.valueOf(dep.toUpperCase());
				documentosTramitados=pedirIncidenciasDocumentos("¿Cuantos documentos ha tramitado?");
				empleado1[i]= new Administrativo(id, nombre, departamento, horas4, documentosTramitados);
				break;
				
			}
		}
		
		for(int j=0; j<empleado1.length; j++) {
			
			System.out.println("DATOS: "+empleado1[j]);
			System.out.print("HORARIO COMPLETO: ");
			empleado1[j].mostrarHorario();
			System.out.println("HORAS TOTALES A LA SEMANA: " +empleado1[j].calcularHorasTotalesSemana());
			System.out.println("PRODUCTIVIDAD: " +empleado1[j].calcularProductividad());
			System.out.println("¿MERECE RECONOCIMIENTO? " +empleado1[j].mereceReconocimiento());
			
		}
		
		double mayor=empleado1[0].calcularProductividad();
		int indice=0;
		
		for (int k=0; k<empleado1.length; k++) {
			if(mayor<empleado1[k].calcularProductividad()) {
				mayor=empleado1[k].calcularProductividad();
				indice=k;
				
			}
		}
		
		System.out.println("EMPLEADO CON MAYOR PRODUCTIVIDAD: " +empleado1[indice]);
		
		for (int l=0; l<empleado1.length; l++) {
			if(empleado1[l] instanceof Programador) {
				contP++;	
			} else if(empleado1[l] instanceof Administrativo) {
				contA++;
			}
		}
		
		System.out.println("Hay " +contP+ " programadores y " +contA+ " administrativos.");
		
		double mediaManiana;
		double mediaTarde;
		
	}
	
	public static String pedirNombreIdDep(String mensaje) {
		
		String s;
		System.out.println(mensaje);
		s=teclado.nextLine();
		return s;
		
	}
	
	public static int pedirIncidenciasDocumentos(String mensaje) {
		int n;
		System.out.println(mensaje);
		n=teclado.nextInt();
		return n;
	}

}
