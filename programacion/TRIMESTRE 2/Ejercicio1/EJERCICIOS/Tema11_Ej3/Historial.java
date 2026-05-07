package Tema11_Ej3;
import java.time.LocalDate;
import java.util.*;

public class Historial {
	
	private ArrayList<Pagina> historial;
	
	public Historial() {
		historial=new ArrayList<Pagina>();
	}
	
	public void insertarPagina(Pagina pag) throws PaginaWebException {
		
		if(historial.isEmpty()) {
			historial.add(pag);
		} else if(pag.getfechaHora().isAfter(historial.getLast().getfechaHora())) {
			historial.add(pag);
		} else
			throw new PaginaWebException();
	}
	
	public void consultarHistorial() {
		
		System.out.println("HISTORIAL: ");
		
		for(Pagina pag : historial) {
			System.out.println();
			System.out.println(pag.toString());
		}
		System.out.println();
	}
	
	public void consultarHistoriaDia(LocalDate dia) {
		
		System.out.println("HISTORIAL DEL DIA: " +dia);
		
		for(Pagina pag : historial) {
			if(dia.isEqual(pag.getfechaHora().toLocalDate())) {
				System.out.println();
				System.out.println(pag.toString());
			}
		}
		System.out.println();
	}
	
	public void borrarHistorial() {
		historial.clear();;
	}
}
