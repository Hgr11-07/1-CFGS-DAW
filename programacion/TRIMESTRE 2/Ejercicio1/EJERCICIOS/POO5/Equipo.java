package POO5;

public class Equipo {

    private String nombre;   // Nombre del equipo
    private String estadio;  // Nombre del estadio donde juega
    private String ciudad;   // Ciudad del equipo
    private int partidosGanados; // Número de partidos ganados (empieza en 0)

    // Constructor: recibe nombre, estadio y ciudad
    // Los partidos ganados empiezan en 0 automáticamente
    public Equipo(String nombre, String estadio, String ciudad) {
        this.nombre = nombre;
        this.estadio = estadio;
        this.ciudad = ciudad;
        this.partidosGanados = 0;
    }

    // Getter del nombre (usado para comparar equipos)
    public String getNombre() {
        return this.nombre;
    }

    // Getter del estadio
    public String getEstadio() {
        return this.estadio;
    }

    // Getter de la ciudad
    public String getCiudad() {
        return this.ciudad;
    }

    // Getter de partidos ganados
    public int getPartidosGanados() {
        return this.partidosGanados;
    }

    // Suma un partido ganado al equipo (se llama desde ponerResultado)
    public void sumarVictoria() {
        this.partidosGanados++;
    }

    // Dos equipos son iguales si tienen el mismo nombre (ignorando mayúsculas)
    public boolean equals(Equipo otro) {
        return this.nombre.equalsIgnoreCase(otro.nombre);
    }

    // toString para mostrar la información del equipo
    public String toString() {
        return "Equipo: " + nombre + " | Estadio: " + estadio + 
               " | Ciudad: " + ciudad + " | Partidos ganados: " + partidosGanados;
    }
}
