package ArraysV2;

public class FaltasAlumnosAsignaturas{
	
	private int numAlumnos;
	private String asignaturas[];
	private Falta faltas[][];
	
	public FaltasAlumnosAsignaturas(int numAlumnos, String asignaturas[], Falta faltas[][]) {
		this.numAlumnos=numAlumnos;
		this.asignaturas=asignaturas;
		this.faltas=faltas;
	}
	
	public int getNumAlumnos() {
		return this.numAlumnos;
	}
	
	public String[] getAsignatura() {
		return this.asignaturas;
	}
	
	public Falta[][] getFaltas(){
		return this.faltas;
	}
	
	public void verAlumnoInjustificadas() {
		
		int maximo;
		int numAlumno=0;
		
		for(int i=0; i<faltas[0].length; i++) {
			maximo=faltas[0][i].getInjustificadas();
			for(int j=0; j<faltas.length; j++) {
				
				if(maximo<faltas[j][i].getInjustificadas()) {
					maximo=faltas[j][i].getInjustificadas();
					numAlumno=j;
				}
				
			}
			System.out.println("Asignatura: " +asignaturas[i]+ " | Número de Alumno: " +numAlumno+ " | Injustificadas: " +maximo );
		}
		
	}
	
	public void alumnoSuperiorMedia() {
		
		int media=0;
		int sumaRetrasos=0;
		
		System.out.print("Los alumnos con nota superior a la media son: ");
		
		for(int i=0; i<faltas.length; i++) {

			for(int j=0; j<faltas[i].length; j++) {
				
				media+=faltas[i][j].getRetrasos();

			}
		}
		
		media/=faltas.length;
		
		for(int k=0; k<faltas.length; k++) {
			sumaRetrasos=0;
			for(int l=0; l<faltas[k].length; l++) {
				sumaRetrasos+=faltas[k][l].getRetrasos();
			}
			if(sumaRetrasos>media) {
				System.out.print(k+ ", ");
			}
		}
		
	}
	
	public void asignaturaMenorRetraso() {
		
		int sumaRetraso=0;
		int minimo=0;
		int indice=0;
		
		for(int i=0; i<faltas[0].length; i++) {
			sumaRetraso=0;
			for(int j=0; j<faltas.length; j++) {
				sumaRetraso+=faltas[j][i].getRetrasos();
			}
			if(i==0) {
				minimo=sumaRetraso;
			}
			if(sumaRetraso<minimo) {
				minimo=sumaRetraso;
				indice=i;
			}
		}
		
		System.out.println("La asignatura con menos retrasos es " +asignaturas[indice]+ " con " +minimo+ " retrasos.");
		
	}
	
}
