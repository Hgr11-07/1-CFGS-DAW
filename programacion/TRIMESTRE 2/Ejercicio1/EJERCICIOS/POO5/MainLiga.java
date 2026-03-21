package POO5;

public class MainLiga {

    public static void main(String[] args) {

        // Creamos tres equipos con nombre, estadio y ciudad
        Equipo realMadrid  = new Equipo("Real Madrid",  "Santiago Bernabéu", "Madrid");
        Equipo barcelona   = new Equipo("Barcelona",    "Spotify Camp Nou",  "Barcelona");
        Equipo atletico    = new Equipo("Atlético",     "Cívitas Metropolitano", "Madrid");

        // -----------------------------------------------------------------------
        // PRIMER PARTIDO: Real Madrid vs Barcelona, jornada 1, resultado "2-1"
        // Independiente de si hay error, el programa sigue adelante
        // -----------------------------------------------------------------------
        try {
            Partido partido1 = new Partido(1, realMadrid, barcelona);
            partido1.ponerResultado("2-1");
            System.out.println("Primer partido creado: " + partido1);
        } catch(EquiposIgualesException | ResultadoInvalidoException e) {
            // Si falla la creación o el resultado, mostramos el error y continuamos
            System.out.println(e.getMessage());
        }

        // -----------------------------------------------------------------------
        // SEGUNDO Y TERCER PARTIDO: se crean en un bucle que se repite hasta que
        // ambos se creen correctamente sin errores
        // -----------------------------------------------------------------------
        Partido partido2 = null;
        Partido partido3 = null;
        boolean correcto = false;

        // Bucle que se repite si cualquiera de los dos partidos falla
        while(!correcto) {
            try {
                // Partido 2: Barcelona vs Atlético, jornada 2, resultado "0-0"
                partido2 = new Partido(2, barcelona, atletico);
                partido2.ponerResultado("0-0");

                // Partido 3: Atlético vs Real Madrid, jornada 3, resultado "1-2"
                partido3 = new Partido(3, atletico, realMadrid);
                partido3.ponerResultado("1-2");

                correcto = true; // Solo llega aquí si los dos se crearon bien
            } catch(EquiposIgualesException | ResultadoInvalidoException e) {
                // Si falla cualquiera de los dos, mostramos el error y el bucle repite
                System.out.println(e.getMessage());
            }
        }

        // -----------------------------------------------------------------------
        // Mostramos la información de los dos partidos creados en el bucle
        // -----------------------------------------------------------------------
        System.out.println("\n--- INFORMACIÓN DE LOS PARTIDOS ---");
        System.out.println(partido2);
        System.out.println(partido3);

        // -----------------------------------------------------------------------
        // Mostramos la información de los equipos participantes
        // -----------------------------------------------------------------------
        System.out.println("\n--- INFORMACIÓN DE LOS EQUIPOS ---");
        System.out.println(realMadrid);
        System.out.println(barcelona);
        System.out.println(atletico);
    }
}
