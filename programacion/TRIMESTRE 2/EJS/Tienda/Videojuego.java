package Tienda;

public class Videojuego implements Comparable<Videojuego> {

    private String titulo;      // Título del juego (no modificable, sin setter)
    private String genero;      // Género del juego (acción, RPG, deportes...)
    private double precio;      // Precio en euros (no puede ser negativo)
    private double puntuacion;  // Puntuación del 0 al 10

    // Constructor: lanza excepciones si precio < 0 o puntuación fuera de rango
    public Videojuego(String titulo, String genero, double precio, double puntuacion)
            throws PrecioInvalidoException, PuntuacionInvalidaException {

        // Título no es modificable pero sí se asigna en el constructor
        this.titulo = titulo;
        this.genero = genero;

        // Validamos el precio antes de asignarlo
        if(precio < 0) {
            throw new PrecioInvalidoException();
        } else {
            this.precio = precio;
        }

        // Validamos la puntuación antes de asignarla
        if(puntuacion < 0 || puntuacion > 10) {
            throw new PuntuacionInvalidaException();
        } else {
            this.puntuacion = puntuacion;
        }
    }

    // Getter del título (sin setter porque no es modificable)
    public String getTitulo() {
        return this.titulo;
    }

    // Getter y setter del género
    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    // Getter y setter del precio con validación
    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) throws PrecioInvalidoException {
        if(precio < 0) {
            throw new PrecioInvalidoException();
        } else {
            this.precio = precio;
        }
    }

    // Getter y setter de puntuación con validación
    public double getPuntuacion() {
        return this.puntuacion;
    }

    public void setPuntuacion(double puntuacion) throws PuntuacionInvalidaException {
        if(puntuacion < 0 || puntuacion > 10) {
            throw new PuntuacionInvalidaException();
        } else {
            this.puntuacion = puntuacion;
        }
    }

    // Sobreescribimos compareTo para ordenar por puntuación de MAYOR a MENOR
    // (invertimos el orden natural: devolvemos 1 si this es MENOR que el otro)
    @Override
    public int compareTo(Videojuego otro) {
        if(this.puntuacion > otro.puntuacion) {
            return -1; // this va antes (mayor puntuación primero)
        } else if(this.puntuacion < otro.puntuacion) {
            return 1;  // otro va antes
        } else {
            return 0;  // misma puntuación, mismo orden
        }
    }

    // toString para mostrar la información del videojuego
    @Override
    public String toString() {
        return "Videojuego: " + titulo +
               " | Género: " + genero +
               " | Precio: " + precio + "€" +
               " | Puntuación: " + puntuacion + "/10";
    }
}
