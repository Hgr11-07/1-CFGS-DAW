package EjercicioExc;

public class Excep {
	
	public static void main(String[] args) {
		
		
	int x=10;
	int y=0;
	int res=0;
	
	System.out.println("Inicio del programa.");
	
	try {
		res=division(x, y);
	}
	catch(DivisionEntreCeroExcep excepcion) {
		System.out.println(excepcion);
	}
	
	finally {
		System.out.println("Resultado: "+res);
	}
	
	}
	
	public static int division(int x, int y) throws DivisionEntreCeroExcep {
		
		int r=0;
		
		if(y==0) {
			throw new DivisionEntreCeroExcep();
		} else {
			r=x/y;
		}
		return r;
		
	}

}
