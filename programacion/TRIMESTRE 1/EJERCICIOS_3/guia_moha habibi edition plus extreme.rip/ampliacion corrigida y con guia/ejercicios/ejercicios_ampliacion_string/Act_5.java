mohammed//5. Realizar un programa que cree el diminutivo de un nombre que se solicitará por teclado.
//Si el nombre termina en O, se sustituye esta letra final por el sufijo “ITO” .
//Si termina en “A” , IDEM con el sufijo “ITA”.
//Si el nombre termina en E,I, o U se preguntará si es masculino o femenino y se procederá de la misma
//forma.
//Si el nombre termina en consonante se preguntará si es masculino o femenino y se procederá
//añadiendo ITO o ITA.
//Si no cumple ninguna de las anteriores condiciones, se mostrará por pantalla con “Nombre
//incorrecto”
//NOTAS:
//• El diminutivo se devolverá siempre en mayúsculas.
// Si el dato del sexo es incorrecto se volverá a solicitar.
//• Debe usarse un método para crear el diminutivo.
package ejercicios_ampliacion_string;

import java.util.Scanner;

public class Act_5 {

    // Método que crea el diminutivo según las reglas
    public static String crearDiminutivo(String nombre, char sexo) {

        int len = nombre.length();

        // Tomar la última letra manualmente
        char ultima = nombre.charAt(len - 1);

        // Convertimos todo a mayúsculas manualmente sumando/restando ASCII
        // (porque no podemos usar toUpperCase())
        String nombreMayus = "";
        for (int i = 0; i < len; i++) {
            char c = nombre.charAt(i);

            // Conversión manual a mayúscula
            if (c >= 'a' && c <= 'z') {
                c = (char)(c - 32); // Pasar a mayúscula
            }

            nombreMayus = nombreMayus + c;
        }

        // Última letra ya convertida a mayúscula
        ultima = nombreMayus.charAt(len - 1);

        String resultado = "";

        // CASO 1 → termina en O
        if (ultima == 'O') {
            // Quitamos la última letra (sin substring, se construye manual)
            for (int i = 0; i < len - 1; i++) {
                resultado = resultado + nombreMayus.charAt(i);
            }
            return resultado + "ITO";
        }

        // CASO 2 → termina en A
        if (ultima == 'A') {
            for (int i = 0; i < len - 1; i++) {
                resultado = resultado + nombreMayus.charAt(i);
            }
            return resultado + "ITA";
        }

        // CASO 3 → termina en E, I o U → depende del sexo
        if (ultima == 'E' || ultima == 'I' || ultima == 'U') {
            for (int i = 0; i < len - 1; i++) {
                resultado = resultado + nombreMayus.charAt(i);
            }
            if (sexo == 'M') {
                return resultado + "ITO";
            } else if (sexo == 'F') {
                return resultado + "ITA";
            }
        }

        // CASO 4 → consonante → depende del sexo
        if ( (ultima < 'A' || ultima > 'Z') == false ) {
            // No es letra inválida

            // Si NO es vocal:
            if (ultima != 'A' && ultima != 'E' && ultima != 'I' && ultima != 'O' && ultima != 'U') {

                // Se deja el nombre tal cual (no quitamos nada)
                resultado = nombreMayus;

                if (sexo == 'M') {
                    return resultado + "ITO";
                } else if (sexo == 'F') {
                    return resultado + "ITA";
                }
            }
        }

        // SI NO CUMPLE NINGUNA CONDICIÓN:
        return "Nombre incorrecto";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce un nombre: ");
        String nombre = sc.nextLine();

        // Convertir primera entrada a MAYÚSCULAS manualmente
        String nombreMayus = "";
        for (int i = 0; i < nombre.length(); i++) {
            char c = nombre.charAt(i);
            if (c >= 'a' && c <= 'z') c = (char)(c - 32);
            nombreMayus = nombreMayus + c;
        }

        char sexo = 'x';

        // **Pedir sexo solo cuando sea necesario**
        // Si acaba en A u O, no se pregunta
        char ultima = nombreMayus.charAt(nombreMayus.length() - 1);

        if (!(ultima == 'A' || ultima == 'O')) {
            // Repetir hasta que responda F o M
            do {
                System.out.print("¿Es masculino (M) o femenino (F)?: ");
                String entrada = sc.nextLine();

                if (entrada.length() == 1) {
                    sexo = entrada.charAt(0);

                    // Convertir sexo a mayúscula manualmente
                    if (sexo >= 'a' && sexo <= 'z') sexo = (char)(sexo - 32);
                }

            } while (sexo != 'M' && sexo != 'F');
        } else {
            // Para A y O no importa el sexo
            sexo = 'M'; // Valor dummy, no afecta
        }

        String diminutivo = crearDiminutivo(nombre, sexo);

        System.out.println("Diminutivo: " + diminutivo);

        sc.close();
    }
}
