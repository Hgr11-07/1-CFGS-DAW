package EjercicioExc;

public class Principal_7_1 {
	
	public static void main(String[] args) throws NumNegativoException, NumFueraDeRangoException, LongitudInvalidaException, CaracterInvalidoException {
	    // 1. Probar entero
	    int entero = MiEntradaSalida.solicitarEntero("Dime un numero entero: ");
	    
	    // 2. Probar positivo
	    int pos = MiEntradaSalida.solicitarEnteroPositivo("Dime un entero positivo: ");
	    
	    // 3. Probar rango
	    int rango = MiEntradaSalida.solicitarNumeroEnRango("Dime un entero entre 0-10: ", 0, 10);
	    
	    // 4. Probar carácter SN
	    char caracterSN = MiEntradaSalida.solicitarCaracterSN("Dime una opción entre S/N: ");
	    
	    //5. Probar cadena
	    String cadena = MiEntradaSalida.solicitarCadena("Dime una cadena de texto:");
	    
	    System.out.println("Entero: " + entero + " | EnteroPositivo: " + pos + " | EnteroRango: " + rango + " | CaracterSN: " + caracterSN + " | Cadena: " + cadena);
	}

}
