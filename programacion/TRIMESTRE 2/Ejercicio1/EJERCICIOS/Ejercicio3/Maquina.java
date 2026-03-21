package Ejercicio3;

import java.util.*;

public class Maquina {
	
	private double monedero;
	private int depositoCafe;
	private int depositoLeche;
	private int depositoVaso;
	private double precioCafe;
	private double precioLeche;
	private double precioCafeLeche;
	private double dineroUsuario;

	public Maquina() {
		monedero = 20;
		depositoCafe = 50;
		depositoLeche = 50;
		depositoVaso = 80;
		precioCafe = 1.00;
		precioLeche = 0.80;
		precioCafeLeche = 1.50;
	}

	public void setDineroUsuario(double dineroUsuario) {
		this.dineroUsuario = dineroUsuario;
	}
	
	public double getMonedero() {
		return this.monedero;
	}
	
	public int getDepositoCafe() {
		return this.depositoCafe;
	}
	
	public int getDepositoLeche() {
		return this.depositoLeche;
	}
	
	public int getDepositoVaso() {
		return this.depositoVaso;
	}

	public void echarseCafeSolo() {
		
		if(dineroUsuario < precioCafe) {
			System.out.println("ERROR: Dinero insuficiente. El café cuesta " + precioCafe + "€");
		} 
		else if(depositoCafe <= 0) {
			System.out.println("ERROR: No hay suficiente café.");
		} 
		else if(depositoVaso <= 0) {
			System.out.println("ERROR: No hay suficientes vasos.");
		} 
		else if((dineroUsuario - precioCafe) > monedero) {
			System.out.println("ERROR: La máquina no dispone de cambio suficiente.");
		} 
		else {
			depositoCafe--;
			depositoVaso--;
			
			double cambio = dineroUsuario - precioCafe;
			
			monedero += precioCafe;
			monedero -= cambio;
			
			System.out.println("Producto servido.");
			if(cambio > 0) {
				System.out.printf("Recoge tu cambio de %.2f euros.\n", cambio);
			}
		}
	}
	
	public void echarseLeche() {
		
		if(dineroUsuario < precioLeche) {
			System.out.println("ERROR: Dinero insuficiente. La leche cuesta " + precioLeche + "€");
		} 
		else if(depositoLeche <= 0) {
			System.out.println("ERROR: No hay suficiente leche.");
		} 
		else if(depositoVaso <= 0) {
			System.out.println("ERROR: No hay suficientes vasos.");
		} 
		else if((dineroUsuario - precioLeche) > monedero) {
			System.out.println("ERROR: La máquina no dispone de cambio suficiente.");
		} 
		else {
			depositoLeche--; // Descontar una dosis de leche
			depositoVaso--; // Descontar un vaso
			
			double cambio = dineroUsuario - precioLeche;
			
			monedero += precioLeche;
			monedero -= cambio;
			
			System.out.println("Producto servido.");
			if(cambio > 0) {
				System.out.printf("Recoge tu cambio de %.2f euros.\n", cambio);
			}
		}
	}
	
	public void echarseCafeLeche() {
		
		if(dineroUsuario < precioCafeLeche) {
			System.out.println("ERROR: Dinero insuficiente. El café con leche cuesta " + precioCafeLeche + "€");
		} 
		else if(depositoCafe <= 0) {
			System.out.println("ERROR: No hay suficiente café.");
		} 
		else if(depositoLeche <= 0) {
			System.out.println("ERROR: No hay suficiente leche.");
		} 
		else if(depositoVaso <= 0) {
			System.out.println("ERROR: No hay suficientes vasos.");
		} 
		else if((dineroUsuario - precioCafeLeche) > monedero) {
			System.out.println("ERROR: La máquina no dispone de cambio suficiente.");
		} 
		else {
			depositoCafe--;
			depositoLeche--;
			depositoVaso--;
			
			double cambio = dineroUsuario - precioCafeLeche;
			
			monedero += precioCafeLeche;
			monedero -= cambio;
			
			System.out.println("Producto servido.");
			
			if(cambio > 0) {
				System.out.println("Recoge tu cambio de " +cambio+ " euros.");
			}
		}
	}
	
	public void consultarMaquina() {
		System.out.println("ESTADO DE LA MÁQUINA");
		System.out.println("Dosis de café restantes: " + depositoCafe);
		System.out.println("Dosis de leche restantes: " + depositoLeche);
		System.out.println("Vasos restantes: " + depositoVaso);
		System.out.println("Dinero en la máquina: " +monedero+ " euros");
		System.out.println("");
	}
	
	public void llenarDepositos() {
		depositoCafe = 50;
		depositoLeche = 50;
		depositoVaso = 80;
		System.out.println("Depósitos rellenados correctamente.");
	}
	
	public double vaciarMonedero() {
		double dineroExtraido = monedero;
		monedero = 0;
		System.out.println("Se han extraído " +dineroExtraido+ " euros del monedero.");
		return dineroExtraido;
	}
}