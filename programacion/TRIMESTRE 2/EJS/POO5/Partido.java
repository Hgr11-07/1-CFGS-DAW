package POO5;

public class Partido {

    private int jornada;          // Jornada en la que se juega (entre 1 y 38)
    private Equipo local;         // Equipo que juega en casa
    private Equipo visitante;     // Equipo que juega fuera
    private int golesLocal;       // Goles del equipo local
    private int golesVisitante;   // Goles del equipo visitante
    private char quiniela;        // Resultado quiniela: '1', 'X' o '2'
    private boolean jugado;       // Indica si el partido ya se ha jugado o no

    // Constructor: recibe jornada, equipo local y equipo visitante
    // Lanza EquiposIgualesException si los dos equipos son el mismo
    // Lanza ResultadoInvalidoException si la jornada no está entre 1 y 38
    // Cuando se crea el partido todavía no se ha jugado, por eso jugado=false
    public Partido(int jornada, Equipo local, Equipo visitante) 
            throws EquiposIgualesException, ResultadoInvalidoException {

        // Comprobamos que los equipos sean diferentes
        if(local.equals(visitante)) {
            throw new EquiposIgualesException();
        }

        // Comprobamos que la jornada esté en el rango válido
        if(jornada < 1 || jornada > 38) {
            throw new ResultadoInvalidoException();
        }

        this.jornada = jornada;
        this.local = local;
        this.visitante = visitante;
        this.jugado = false; // El partido aún no se ha jugado al crearlo
    }

    // Getter de jornada (no tiene setter porque no es modificable)
    public int getJornada() {
        return this.jornada;
    }

    // Getter del equipo local (no tiene setter porque no es modificable)
    public Equipo getLocal() {
        return this.local;
    }

    // Getter del equipo visitante (no tiene setter porque no es modificable)
    public Equipo getVisitante() {
        return this.visitante;
    }

    // Getter de goles local
    public int getGolesLocal() {
        return this.golesLocal;
    }

    // Getter de goles visitante
    public int getGolesVisitante() {
        return this.golesVisitante;
    }

    // Getter del resultado de quiniela
    public char getQuiniela() {
        return this.quiniela;
    }

    // Getter para saber si el partido ya se jugó
    public boolean isJugado() {
        return this.jugado;
    }

    // Método que recibe el resultado en formato "X-Y", actualiza los goles,
    // calcula el resultado de quiniela y suma victoria al equipo ganador.
    // Lanza ResultadoInvalidoException si el formato es incorrecto o los goles son negativos.
    public void ponerResultado(String resultado) throws ResultadoInvalidoException {

        // Comprobamos que el string contenga exactamente un guion
        if(!resultado.contains("-")) {
            throw new ResultadoInvalidoException();
        }

        // Separamos el string por el guion para obtener los dos números
        String[] partes = resultado.split("-");

        // Debe haber exactamente dos partes (ej: "2-1" → ["2", "1"])
        if(partes.length != 2) {
            throw new ResultadoInvalidoException();
        }

        int gl;  // goles local
        int gv;  // goles visitante

        // Intentamos convertir las partes a enteros
        // Si no son números, parseInt lanza NumberFormatException → la capturamos y relanzamos
        try {
            gl = Integer.parseInt(partes[0].trim());
            gv = Integer.parseInt(partes[1].trim());
        } catch(NumberFormatException e) {
            throw new ResultadoInvalidoException();
        }

        // Los goles no pueden ser negativos
        if(gl < 0 || gv < 0) {
            throw new ResultadoInvalidoException();
        }

        // Asignamos los goles
        this.golesLocal = gl;
        this.golesVisitante = gv;

        // Calculamos el resultado de quiniela y sumamos victoria al equipo ganador
        if(gl > gv) {
            this.quiniela = '1';          // Gana el local
            local.sumarVictoria();
        } else if(gv > gl) {
            this.quiniela = '2';          // Gana el visitante
            visitante.sumarVictoria();
        } else {
            this.quiniela = 'X';          // Empate, nadie suma victoria
        }

        // Marcamos el partido como jugado
        this.jugado = true;
    }

    // toString: muestra información diferente según si el partido se ha jugado o no
    public String toString() {
        if(!jugado) {
            // Partido no jugado todavía
            return "Partido entre equipo local " + local.getNombre() +
                   " y equipo visitante " + visitante.getNombre() +
                   " todavía no se ha jugado";
        } else {
            // Partido ya acabado
            return "Partido entre equipo local " + local.getNombre() +
                   " y el equipo visitante " + visitante.getNombre() +
                   " jugado en el estadio " + local.getEstadio() +
                   " de la ciudad " + local.getCiudad() +
                   " ha finalizado con " + golesLocal + " goles de equipo local" +
                   " y " + golesVisitante + " goles de equipo visitante." +
                   " Resultado quiniela= " + quiniela;
        }
    }
}
