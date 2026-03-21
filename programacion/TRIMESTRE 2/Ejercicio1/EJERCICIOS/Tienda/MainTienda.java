package Tienda;

import java.util.Arrays;
import java.util.Scanner;

public class MainTienda {

    public static Scanner teclado = new Scanner(System.in); // Scanner compartido

    public static void main(String[] args) {

        // Array de 5 videojuegos
        Videojuego[] catalogo = new Videojuego[5];

        // -----------------------------------------------------------------------
        // Rellenamos el array pidiendo datos por teclado
        // Cada posición tiene su propio bucle con bandera hasta crearse bien
        // -----------------------------------------------------------------------
        for(int i = 0; i < catalogo.length; i++) {

            boolean correcto = false;

            while(!correcto) {
                try {
                    String titulo  = pedirTexto("Introduce el título del videojuego " + (i+1) + ": ");
                    String genero  = pedirTexto("Introduce el género: ");
                    double precio  = pedirDecimal("Introduce el precio (€): ");
                    double puntuacion = pedirDecimal("Introduce la puntuación (0-10): ");

                    catalogo[i] = new Videojuego(titulo, genero, precio, puntuacion);
                    correcto = true; // Solo llega aquí si no hubo ninguna excepción

                } catch(PrecioInvalidoException | PuntuacionInvalidaException e) {
                    // Mostramos el error y el bucle vuelve a pedir los datos
                    System.out.println(e.getMessage());
                }
            }
        }

        // -----------------------------------------------------------------------
        // Mostramos el catálogo sin ordenar
        // -----------------------------------------------------------------------
        System.out.println("\n--- CATÁLOGO SIN ORDENAR ---");
        for(Videojuego v : catalogo) {
            System.out.println(v);
        }

        // -----------------------------------------------------------------------
        // Ordenamos el array usando Arrays.sort(), que internamente usa compareTo
        // Como compareTo está sobreescrito, ordena de mayor a menor puntuación
        // -----------------------------------------------------------------------
        Arrays.sort(catalogo);

        System.out.println("\n--- CATÁLOGO ORDENADO POR PUNTUACIÓN (mayor a menor) ---");
        for(Videojuego v : catalogo) {
            System.out.println(v);
        }

        // -----------------------------------------------------------------------
        // Mejor y peor videojuego
        // Tras ordenar: el primero es el mejor y el último es el peor
        // -----------------------------------------------------------------------
        System.out.println("\n--- MEJOR Y PEOR VIDEOJUEGO ---");
        System.out.println("Mejor puntuación → " + catalogo[0]);
        System.out.println("Peor puntuación  → " + catalogo[catalogo.length - 1]);

        // -----------------------------------------------------------------------
        // Subimos el precio un 10% a los juegos con puntuación > 8
        // Si el nuevo precio supera 100€ lo dejamos en 100€
        // -----------------------------------------------------------------------
        System.out.println("\n--- SUBIDA DE PRECIO (puntuación > 8) ---");
        for(Videojuego v : catalogo) {
            if(v.getPuntuacion() > 8) {
                double nuevoPrecio = v.getPrecio() * 1.10; // Subimos un 10%

                // Si supera 100€ lo limitamos a 100€
                if(nuevoPrecio > 100) {
                    nuevoPrecio = 100;
                }

                try {
                    v.setPrecio(nuevoPrecio);
                    System.out.println("Precio actualizado → " + v.getTitulo() + ": " + nuevoPrecio + "€");
                } catch(PrecioInvalidoException e) {
                    // No debería ocurrir nunca porque el precio viene de uno ya válido * 1.10
                    System.out.println(e.getMessage());
                }
            }
        }

        // -----------------------------------------------------------------------
        // Mostramos el catálogo final con los precios actualizados
        // -----------------------------------------------------------------------
        System.out.println("\n--- CATÁLOGO FINAL ---");
        for(Videojuego v : catalogo) {
            System.out.println(v);
        }
    }

    // Método para pedir una cadena de texto mostrando un mensaje
    public static String pedirTexto(String mensaje) {
        System.out.print(mensaje);
        return teclado.nextLine();
    }

    // Método para pedir un número decimal mostrando un mensaje
    public static double pedirDecimal(String mensaje) {
        System.out.print(mensaje);
        double n = teclado.nextDouble();
        teclado.nextLine(); // Limpiamos el salto de línea que deja nextDouble
        return n;
    }
}
