package POOv2_4;
import java.util.*;

public class Principal {
	
	public static Scanner teclado=new Scanner(System.in);
	
	    public static void main(String[] args) {
	        try {
	            // Crear Mago A
	            Mago magoA = new Mago("Gandalf", Raza.HUMANO, 10, 18, 80);
	            // Crear Mago B
	            Mago magoB = new Mago("Saruman", Raza.ELFO, 12, 19, 90);
	            // Crear Clérigo C
	            Clerigo clerigoC = new Clerigo("Benedictus", Raza.ENANO, 18, 14, 70, "Pelor");

	            // Imprimir datos de los tres personajes
	            System.out.println("=== DATOS INICIALES ===");
	            System.out.println(magoA);
	            System.out.println(magoB);
	            System.out.println(clerigoC);

	            // El Mago A aprende 2 hechizos
	            magoA.aprendeHechizo("Bola de Fuego");
	            magoA.aprendeHechizo("Rayo Helado");

	            // El Mago B aprende 1 hechizo
	            magoB.aprendeHechizo("Tormenta Eléctrica");

	            // Imprimir datos de los Magos
	            System.out.println("\n=== DATOS MAGOS TRAS APRENDER HECHIZOS ===");
	            System.out.println(magoA);
	            System.out.println(magoB);

	            // El Mago A lanza un hechizo sobre el Mago B
	            System.out.println("\n=== MAGO A lanza 'Bola de Fuego' sobre MAGO B ===");
	            magoA.lanzaHechizo(magoB, "Bola de Fuego");

	            // El Mago B lanza un hechizo sobre el Mago A
	            System.out.println("=== MAGO B lanza 'Tormenta Eléctrica' sobre MAGO A ===");
	            magoB.lanzaHechizo(magoA, "Tormenta Eléctrica");

	            // El Clérigo cura al Mago B
	            System.out.println("=== CLÉRIGO C cura al MAGO B ===");
	            clerigoC.curar(magoB);

	            // El Mago A lanza un hechizo sobre el Mago B
	            System.out.println("=== MAGO A lanza 'Rayo Helado' sobre MAGO B ===");
	            magoA.lanzaHechizo(magoB, "Rayo Helado");

	            // Imprimir datos finales de los tres personajes
	            System.out.println("\n=== DATOS FINALES ===");
	            System.out.println(magoA);
	            System.out.println(magoB);
	            System.out.println(clerigoC);

	        } catch (AtributosInvalidosException e) {
	            System.out.println("Error al crear/modificar personaje: " + e.getMessage());
	        
	        }
	    }
}
