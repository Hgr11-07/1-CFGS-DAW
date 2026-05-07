package PROYECTO_FINAL;

public abstract class PersonaLiga {
	
	private int id;
	private String nombre;
	private String nickname;
	private int edad;
	private double salarioBase;
	
	public PersonaLiga(int id, String nombre, String nickname, int edad, double salarioBase) {
		
		this.id=id;
		this.nombre=nombre;
		this.nickname=nickname;
		this.edad=edad;
		this.salarioBase=salarioBase;
		
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getNickname() {
		return this.nickname;
	}
	
	public int getEdad() {
		return this.edad;
	}
	
	public double getSalarioBase() {
		return this.salarioBase;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public void setNickname(String nickname) {
		this.nickname=nickname;
	}
	
	public void setEdad(int edad) {
		this.edad=edad;
	}
	
	public void setSalarioBase(double salarioBase) {
		this.salarioBase=salarioBase;
	}
	
	@Override
	public String toString() {
		return "ID: " +id+ " | NOMBRE: " +nombre+ " | NICKNAME: " +nickname+ " | EDAD: " +edad+ " | SALARIO BASE: " +salarioBase;
	}
	
	public void mostrarResumen() {
		System.out.println("-- RESUMEN -- ");
		System.out.println("ID: " +id);
		System.out.println("Nombre: " +nombre+ "  ("+nickname+")");
		System.out.println("Edad: " +edad);
		System.out.println("Salario Base: " +salarioBase);
	}
	
	public abstract double calcularCosteMensual();
	
}
