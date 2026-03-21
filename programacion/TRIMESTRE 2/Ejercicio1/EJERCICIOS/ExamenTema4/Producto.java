package ExamenTema4;

public class Producto implements Comparable <Producto>{	//Creamos la clase producto con el implements para poder sobreescribir el compareTo
	
	private String nombre;	//Creamos tres atributos privados por la encapsulación, un String, un double y un int.
	private double precio;
	private int stock;
	
	public Producto(String nombre, double precio, int stock) throws ProductoInvalidoException{	//Creamos el constructor al que le pasamos por parámetros un string, un double y un int y que pueda lanzar la excepcion personalizada.
		
		this.nombre=nombre;	//Le asignamos al atributo del objeto en ejecucion lo que le pasamos por parámetro
		
		if(precio<=0||stock<0) {	//Si el precio o el stock son incorrectos, se lanza una excepcion que se trabaja en el main, si no el programa sigue su curso.
			throw new ProductoInvalidoException();
		}
		this.precio=precio;
		this.stock=stock;
	}
	
	public void setNombre(String nombre) {	//Metodo setter por si hay que actualizar el nombre de un producto más adelante
		this.nombre=nombre;
	}
	
	public String getNombre() {	//Método getter para devolver el nombre del producto.
		return this.nombre;
	}
	
	public void setPrecio(double precio) throws ProductoInvalidoException{	//Metodo setter que actualiza el precio del producto si no es erróneo, si lo es, lanza la excepcion personalizada.
		if(precio<=0) {
			throw new ProductoInvalidoException();
		}
		this.precio=precio;
	}
	
	public double getPrecio() {
		return this.precio;
	}
	
	public void setStock(int stock) throws ProductoInvalidoException{ //Metodo setter que actualiza el stock del producto si no es erróneo, si lo es, lanza la excepcion personalizada.
		if(stock<0) {
			throw new ProductoInvalidoException();
		}
		this.stock=stock;
	}
	
	public int getStock() {
		return this.stock;
	}
	
	public String toString() { //Metodo toString para ver el contenido del objeto de manera más organizada.
        return "Producto: " +nombre+ " || Precio: " + precio+ " || Stock: " +stock;
    }
 
	@Override
	public int compareTo(Producto p) { //Sobreescribimos metodo compareTo para ordenar por precio, ya que arrays.sort llama a compareTo. Devuelve un positivo si es mayor, un negativo si es menor, y un 0 si son iguales.
		if(this.precio>p.precio) {
			return 1;
		}
		else if(this.precio<p.precio) {
			return -1;
		}else {
			return 0;
		}
	}

}
