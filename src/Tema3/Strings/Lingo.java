package Tema3.Strings;

import java.util.Scanner;

public class Lingo {
//esto no es wordle?????
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Palabra secreta (puedes cambiarla o hacer una lista aleatoria)
        String secreto = "TIGRE";
        String intento;
        int intentosMax = 5;
        int LONGITUD = 5;
        boolean haGanado = false;
        System.out.println("--- JUEGO LINGO ---");
        System.out.println("Adivina la palabra de " + LONGITUD + " letras.");
        System.out.println("TIENES " + intentosMax + " INTENTOS.");
        System.out.println("Leyenda:");
        System.out.println(" [X] -> Letra correcta y en posición correcta");
        System.out.println(" (X) -> La letra existe pero en otra posición");
        System.out.println("  X  -> La letra no está en la palabra");
        System.out.println("-------------------------------------------");
        for (int i = 1; i <= intentosMax; i++) {
            System.out.print("Intento " + i + "/" + intentosMax + ": ");
            intento = scanner.nextLine().toUpperCase();
            // 1. Validar longitud
            if (intento.length() != LONGITUD) {
                System.out.println("Error: La palabra debe tener exactamente " + LONGITUD + " letras.");
                i--; // No gastamos el intento
            }
            // 2. Comprobar victoria inmediata
            if (intento.equals(secreto)) {
                haGanado = true;
                // Mostramos la palabra "bonita" antes de salir
                resultado(secreto, intento);
            }
            // 3. Procesar y mostrar pistas
            resultado(secreto, intento);
        }

        System.out.println("-------------------------------------------");
        if (haGanado) {
            System.out.println("¡FELICIDADES! Has adivinado la palabra.");
        } else {
            System.out.println("GAME OVER. Te has quedado sin intentos.");
            System.out.println("La palabra secreta era: " + secreto);
        }
    }

    public static void resultado(String secreto, String intento) {
        char[] sArr = secreto.toCharArray();
        char[] iArr = intento.toCharArray();
        // Array para guardar el estado de cada letra del intento
        // 0 = no está, 1 = mal posición (amarillo), 2 = correcta (verde)
        int[] estados = new int[5];

        // Array para marcar qué letras del secreto ya han sido "usadas" (emparejadas)
        boolean[] secretoUsado = new boolean[5];

        // --- PASADA 1: Buscar coincidencias EXACTAS (Verdes) ---
        for (int i = 0; i < 5; i++) {
            if (iArr[i] == sArr[i]) {
                estados[i] = 2;       // Marcamos como Correcto
                secretoUsado[i] = true; // Marcamos esta letra del secreto como "gastada"
            }
        }

        // --- PASADA 2: Buscar coincidencias PARCIALES (Amarillas) ---
        for (int i = 0; i < 5; i++) {
            if (estados[i] == 2) continue; // Si ya es verde, saltar

            // Buscamos si la letra iArr[i] existe en alguna posición no usada del secreto
            for (int j = 0; j < 5; j++) {
                if (!secretoUsado[j] && iArr[i] == sArr[j]) {
                    estados[i] = 1;       // Existe pero mal lugar
                    secretoUsado[j] = true; // Gastamos esa letra del secreto
                    break; // Solo emparejamos una vez por letra
                }
            }
        }

        // --- IMPRIMIR RESULTADO FORMATEADO ---
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            char letra = iArr[i];
            if (estados[i] == 2) {
                sb.append("[").append(letra).append("]"); // Correcto
            } else if (estados[i] == 1) {
                sb.append("(").append(letra).append(")"); // Mal lugar
            } else {
                sb.append(" ").append(letra).append(" "); // Incorrecto
            }
            sb.append(" "); // Espacio visual entre letras
        }
        System.out.println("Resultado: " + sb);
    }
}