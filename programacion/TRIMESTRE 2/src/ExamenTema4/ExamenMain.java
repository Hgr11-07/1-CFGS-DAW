package ExamenTema4;
import java.util.*;

public class ExamenMain {	//Creamos la clase examenMain
	
	public static Scanner teclado=new Scanner(System.in);	//Creamos el objeto teclado de tipo Scanner con el constructor Scanner
	
	public static void main(String[] args) throws ProductoInvalidoException {	//Creamos el main que lanza la excepcion personalizada.
		
		Producto catalogo[]= new Producto[5];	//Creamos un array que almacena Productos (objetos) llamado catalogo con longitud 5.
		
		for(int i=0; i<catalogo.length; i++) {		//Bucle para  recorrer el array, para que se vayan asignando los valores correspondientes a los objetos que almacena catalogo.
			
			boolean correcto=false;	//Inicializamos un booleano en falso para que entre al bucle
			
			while(!correcto) {	//Bucle hecho para filtrar los datos erróneos, no puedes salir de él hasta que los datos sean correctos.
				try {	//Bloque try que tratará de asignar los valores a las variables nombre, precio y stock
					String nombre=pedirNombre("Introduce el nombre del artículo: ");	//Variable a la que le pasamos el resultado que devuelve el metodo pedirNombre
					double precio=pedirPrecio("Introduce el precio: ");	//Variable a la que le pasamos el resultado que devuelve el metodo pedirPrecio
					int stock=pedirStock("Introduce la cantidad disponible: ");	//Variable a la que le pasamos el resultado que devuelve el metodo pedirStock
					
					catalogo[i]=new Producto(nombre, precio, stock);	//Asignamos los valores de nombre precio y stock pedidos el nuevo objeto creado que está en la posicion i del array.
					correcto=true;	//Pasamos correcto a true para salir del bucle
					teclado.nextLine();	//Limpiamos el teclado
					
				}catch(ProductoInvalidoException p) {	//Bloque catch que atrapa y maneja la excepcion personalizada
					System.out.println(p);	//Imprimimos el mensaje de la excepcion personalizada.
					teclado.nextLine();	//Limpiamos el teclado
				}catch(InputMismatchException z) {	//Bloque catch que atrapa y maneja la excepcion InputMismatchException
					System.out.println(z);	//Imprimimos el mensaje de la excepcion.
					teclado.nextLine();	//Limpiamos el teclado
				}
			
			}
			
		}
		
		System.out.println("--- CATÁLOGO ---");	//Imprimimos uno a uno los objetos del array con un bucle for each
        for(Producto p : catalogo) {
            System.out.println(p);
        }
        System.out.println(); //Salto de línea para claridad
        
        Arrays.sort(catalogo);	//Ordenamos el array
        
        System.out.println("--- CATÁLOGO ORDENADO ---");
        for(Producto p : catalogo) {	//Imprimimos uno a uno los objetos del array con un bucle for each
            System.out.println(p);
        }
		
        Producto mayor=catalogo[0];	//Asignamos el primer objeto del array al nuevo objeto mayor, por si es el del precio mas alto.
      //Bucle for each para ver el producto más caro, que actualiza el precio si el anterior era más bajo.
        for (Producto p : catalogo) {
        	if(p.getPrecio()>mayor.getPrecio()) {
        		mayor=p;
        	}
        }
        
        System.out.println(); //Salto de línea para claridad
        System.out.println("Producto más caro: "+mayor);	//Imprime el producto con precio mayor
        System.out.println(); //Salto de línea para claridad
        
        for (Producto r: catalogo) {	//Bucle for each que quita 2 al stock de cada producto si el stock no es menor que 2, en ese caso, le deja en 0. 
        	
        	if(r.getStock()-2<0) {
        		r.setStock(0);
        	} else {
        		r.setStock(r.getStock()-2);
        	}
        }
        
        System.out.println("--- CATÁLOGO FINAL ---");
        
        for(Producto p : catalogo) {
            System.out.println(p);
        }
	}
	
	//Método que devuelve un String que pide al usuario por teclado
	public static String pedirNombre(String mensaje) {
		
		String s;
		System.out.println(mensaje);
		s=teclado.nextLine();
		return s;
	}
	
	//Método que devuelve un double que pide al usuario por teclado
	public static double pedirPrecio(String mensaje) {
		
		double d;
		System.out.println(mensaje);
		d=teclado.nextDouble();
		return d;
	}
	
	//Método que devuelve un int que pide al usuario por teclado
	public static int pedirStock(String mensaje) {
		
		int i;
		System.out.println(mensaje);
		i=teclado.nextInt();
		return i;
	}

}
