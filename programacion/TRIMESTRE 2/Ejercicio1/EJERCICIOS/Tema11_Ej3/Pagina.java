package Tema11_Ej3;

import java.time.LocalDateTime;

public class Pagina{
	
	private String url;
	private LocalDateTime fechaHora;

	public Pagina(String url) {
		this.url=url;
		fechaHora= LocalDateTime.now();
	}
	
	public String getUrl() {
		return this.url;
	}
	
	public LocalDateTime getfechaHora() {
		return this.fechaHora;
	}
	
	@Override
	public String toString() {
		return "URL: " +url+ " | Fecha Y Hora: " +fechaHora;
	}
}
