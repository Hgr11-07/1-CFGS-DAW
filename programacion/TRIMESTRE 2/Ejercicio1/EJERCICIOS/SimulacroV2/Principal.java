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
				System.out.println("BIENVENIDO");
				System.out.println();
				break;
			case 1:
				id=pedirNombreIdDep("Introduce tu ID: ");
				nombre=pedirNombreIdDep("Introduce tu nombre: ");
				dep=pedirNombreIdDep("Introduce el departamento: ");
				departamento=Departamento.valueOf(dep.toUpperCase());
				incidencias=pedirIncidenciasDocumentos("¿Cuántas incidencias ha resuelto?: ");
				empleado1[i]= new Programador(id, nombre, departamento, horas2, incidencias);
				System.out.println("BIENVENIDO");
				System.out.println();
				break;
			case 2:
				id=pedirNombreIdDep("Introduce tu ID: ");
				nombre=pedirNombreIdDep("Introduce tu nombre: ");
				dep=pedirNombreIdDep("Introduce el departamento: ");
				departamento=Departamento.valueOf(dep.toUpperCase());
				documentosTramitados=pedirIncidenciasDocumentos("¿Cuantos documentos ha tramitado?");
				empleado1[i]= new Administrativo(id, nombre, departamento, horas3, documentosTramitados);
				System.out.println("BIENVENIDO");
				System.out.println();
				break;
			case 3:
				id=pedirNombreIdDep("Introduce tu ID: ");
				nombre=pedirNombreIdDep("Introduce tu nombre: ");
				dep=pedirNombreIdDep("Introduce el departamento: ");
				departamento=Departamento.valueOf(dep.toUpperCase());
				documentosTramitados=pedirIncidenciasDocumentos("¿Cuantos documentos ha tramitado?");
				empleado1[i]= new Administrativo(id, nombre, departamento, horas4, documentosTramitados);
				System.out.println("BIENVENIDO");
				System.out.println();
				break;
				
			}
		}
		
		for(int i=0; i<empleado1.length; i++) {
			
			System.out.println("DATOS: "+empleado1[i]);
			System.out.println("HORARIO COMPLETO: ");
			empleado1[i].mostrarHorario();
			System.out.println("HORAS TOTALES A LA SEMANA: " +empleado1[i].calcularHorasTotalesSemana());
			System.out.println("PRODUCTIVIDAD: " +empleado1[i].calcularProductividad());
			System.out.println("¿MERECE RECONOCIMIENTO? " +empleado1[i].mereceReconocimiento());
			System.out.println();
			
		}
		
		double mayor=empleado1[0].calcularProductividad();
		int indice=0;
		
		for (int i=0; i<empleado1.length; i++) {
			if(mayor<empleado1[i].calcularProductividad()) {
				mayor=empleado1[i].calcularProductividad();
				indice=i;
				
			}
		}
		
		System.out.println("EMPLEADO CON MAYOR PRODUCTIVIDAD: " +empleado1[indice]);
		
		for (int i=0; i<empleado1.length; i++) {
			if(empleado1[i] instanceof Programador) {
				contP++;	
			} else if(empleado1[i] instanceof Administrativo) {
				contA++;
			}
		}
		
		System.out.println("Hay " +contP+ " programadores y " +contA+ " administrativos.");
		
		double mediaManiana=0;
		double mediaTarde=0;
		
		for(int i=0; i<empleado1.length; i++) {
			for(int j=0; j<empleado1[i].getHorasTrabajadas().length; j++) {
				for(int k=0; k<empleado1[i].getHorasTrabajadas()[j].length; k++) {
					if(k==0)
						mediaManiana+=empleado1[i].getHorasTrabajadas()[j][k];
					else
						mediaTarde+=empleado1[i].getHorasTrabajadas()[j][k];
				}
			}
			
		}
		
		mediaManiana/=20;
		mediaTarde/=20;
		
		System.out.println("La media de horas trabajadas por la mañana es: " +mediaManiana);
		System.out.println("La media de horas trabajadas por la tarde es: " +mediaTarde);
		
		double maximo=empleado1[0].calcularHorasTotalesDia(0);
		int in=0;
		int em=0;
		
		for(int i=0; i<empleado1.length; i++) {
			for(int j=0; j<empleado1[i].getHorasTrabajadas().length; j++) {
					if(empleado1[i].calcularHorasTotalesDia(j)>maximo) {
						maximo=empleado1[i].calcularHorasTotalesDia(j);
						in=j;
						em=i;
					}
			}
		}
		
		System.out.println("El empleado que mas horas trabajó en un día es " +empleado1[em].getNombre()+ " el día " +(in+1)+ " con un total de " +maximo);
		
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
		teclado.nextLine();
		return n;
	}

}
