package ejercicios_string;

import java.util.Scanner;

public class Act_13 {
    public static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        // ejercicio 1: simulador de partido
        ejercicio1();

        // ejercicio 2: fuerza bruta de claves
        ejercicio2();
    }

    // ========== ejercicio 1: simulador de partido ==========
    public static void ejercicio1() {
        // pedir nombres de los paises
        System.out.print("primer pais: ");
        String pais1 = teclado.nextLine();
        System.out.print("segundo pais: ");
        String pais2 = teclado.nextLine();

        // sorteo para el saque inicial
        String saque = numeroaleatorio() < 0.5 ? pais1 : pais2;
        System.out.println("-> " + saque + " al saque");

        int puntos1 = 0, puntos2 = 0;
        int set1 = 0, set2 = 0;
        int puntosvictoria = 21;
        int puntoscambiocampo = 7;

        while (set1 < 2 && set2 < 2) {
            System.out.println("set: " + set1 + " puntos: " + puntos1 + " [" + pais1 + "]");
            System.out.println("set: " + set2 + " puntos: " + puntos2 + " [" + pais2 + "]");

            while (!setpaisganador(puntos1, puntos2, puntosvictoria)) {
                System.out.println("-> " + saque + " al saque");
                System.out.print("quien gano el punto? (" + pais1 + "/" + pais2 + "): ");
                String ganador = teclado.nextLine();

                if (sonigualesignorecase(ganador, pais1)) {
                    puntos1++;
                    saque = pais1;
                } else if (sonigualesignorecase(ganador, pais2)) {
                    puntos2++;
                    saque = pais2;
                } else {
                    System.out.println("error. intenta de nuevo.");
                    continue;
                }

                if ((puntos1 + puntos2) % puntoscambiocampo == 0) {
                    System.out.println("-------------------------");
                    System.out.println("-----cambio de campo-----");
                    System.out.println("-------------------------");
                }

                System.out.println("set: " + set1 + " puntos: " + puntos1 + " [" + pais1 + "]");
                System.out.println("set: " + set2 + " puntos: " + puntos2 + " [" + pais2 + "]");
            }

            if (puntos1 > puntos2) {
                set1++;
                System.out.println("set ganado por " + pais1 + "!");
            } else {
                set2++;
                System.out.println("set ganado por " + pais2 + "!");
            }

            puntos1 = 0;
            puntos2 = 0;

            if (set1 == 1 && set2 == 1) {
                puntosvictoria = 15;
                puntoscambiocampo = 5;
            }
        }

        if (set1 > set2) {
            System.out.println("enhorabuena, el ganador es " + pais1 + "!!!!!");
        } else {
            System.out.println("enhorabuena, el ganador es " + pais2 + "!!!!!");
        }
    }

    public static boolean setpaisganador(int puntos1, int puntos2, int puntosvictoria) {
        boolean algunoGano = (puntos1 >= puntosvictoria) || (puntos2 >= puntosvictoria);
        boolean diferenciaSuficiente = valorabsoluto(puntos1 - puntos2) >= 2;
        return algunoGano && diferenciaSuficiente;
    }

    public static int valorabsoluto(int numero) {
        if (numero < 0) {
            return -numero;
        }
        return numero;
    }

    public static boolean sonigualesignorecase(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        for (int i = 0; i < s1.length(); i++) {
            char c1 = aminuscula(s1.charAt(i));
            char c2 = aminuscula(s2.charAt(i));
            if (c1 != c2) {
                return false;
            }
        }
        return true;
    }

    public static double numeroaleatorio() {
        long tiempo = System.nanoTime();
        return (double) (tiempo % 1000) / 1000.0;
    }

    // ========== ejercicio 2: fuerza bruta de claves ==========
    public static void ejercicio2() {
        String clave = generacionclaverandom();
        System.out.println("la combinacion es: " + clave);

        long comienzorandom = System.nanoTime();
        String claverandom = "";
        while (!soniguales(clave, claverandom)) {
            claverandom = generacionclaverandom();
        }
        long finrandom = System.nanoTime();
        System.out.println("encontrado de manera aleatoria: " + claverandom);
        System.out.println("por fuerza aleatoria tardo: " + (finrandom - comienzorandom) / 1e9 + " segundos");

        long inicioclavebruta = System.nanoTime();
        String clavebruta = "";
        boolean encontrado = false;

        for (char c1 = 'A'; c1 <= 'Z' && !encontrado; c1++) {
            for (char c2 = 'A'; c2 <= 'Z' && !encontrado; c2++) {
                for (char c3 = 'A'; c3 <= 'Z' && !encontrado; c3++) {
                    for (char c4 = 'A'; c4 <= 'Z' && !encontrado; c4++) {
                        clavebruta = construircadena(c1, c2, c3, c4);
                        if (soniguales(clave, clavebruta)) {
                            encontrado = true;
                        }
                    }
                }
            }
        }

        long finclavebruta = System.nanoTime();
        System.out.println("encontrado de manera secuencial: " + clavebruta);
        System.out.println("por fuerza bruta tardo: " + (finclavebruta - inicioclavebruta) / 1e9 + " segundos");

        long inicioclavejusta = System.nanoTime();
        String clavejusta = "";
        for (int i = 0; i < 4; i++) {
            for (char letra = 'A'; letra <= 'Z'; letra++) {
                if (clave.charAt(i) == letra) {
                    clavejusta = construircadenaconchar(clavejusta, letra);
                    break;
                }
            }
        }

        long finclavejusta = System.nanoTime();
        System.out.println("encontrado letra a letra: " + clavejusta);
        System.out.println("por fuerza justa tardo: " + (finclavejusta - inicioclavejusta) / 1e9 + " segundos");
    }

    public static String generacionclaverandom() {
        char c1 = generarletraaleatoria();
        char c2 = generarletraaleatoria();
        char c3 = generarletraaleatoria();
        char c4 = generarletraaleatoria();
        return construircadena(c1, c2, c3, c4);
    }

    public static char generarletraaleatoria() {
        long tiempo = System.nanoTime();
        int numero = (int) (tiempo % 26);
        return (char) ('A' + numero);
    }

    public static String construircadena(char c1, char c2, char c3, char c4) {
        String resultado = "";
        resultado += c1;
        resultado += c2;
        resultado += c3;
        resultado += c4;
        return resultado;
    }

    public static String construircadenaconchar(String s, char c) {
        String resultado = s;
        resultado += c;
        return resultado;
    }

    public static boolean soniguales(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static char aminuscula(char c) {
        if (c >= 'a' && c <= 'z') {
            return c;
        } else if (c >= 'A' && c <= 'Z') {
            return (char) (c + ('a' - 'A'));
        }
        return c;
    }
}

