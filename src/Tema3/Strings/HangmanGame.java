package Tema3.Strings;

import java.util.Scanner;
import java.util.Arrays;

public class HangmanGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //varialbe
        String shushface, input;
        char[] progreso;
        char letra;
        int bodyparts = 6;
        boolean juegoTerminado = false, haGanado = false, acierto;
        // --- TURNO JUGADOR 1 ---
        System.out.println("--- JUEGO DEL AHORCADO ---");
        System.out.print("JUGADOR 1: Introduce la palabra secreta: ");
        shushface = sc.nextLine().toUpperCase();
        while (shushface.trim().isEmpty()) {// Validación simple para asegurar que hay palabra
            System.out.print("Por favor, introduce una palabra válida: ");
            shushface = sc.nextLine().toUpperCase();
        }
        limpiarPantalla();
        // --- PREPARACIÓN JUEGO ---
        // Array de caracteres para mostrar el progreso (ej: _ _ A _ _)
        progreso = new char[shushface.length()];
        Arrays.fill(progreso, '_');
        // --- TURNO JUGADOR 2 ---
        System.out.println("JUGADOR 2: ¡Es hora de adivinar!");

        while (!juegoTerminado) {
            dibujarAhorcado(bodyparts);
            mostrarProgreso(progreso);
            System.out.print("\nIntroduce una letra o intenta resolver la palabra: ");
            input = sc.nextLine().toUpperCase();
            // Validación de entrada vacía
            if (input.isEmpty()) continue;

            // OPCIÓN A: INTENTAR RESOLVER (Si escribe más de 1 letra)
            if (input.length() > 1) {
                if (input.equals(shushface)) {
                    haGanado = true;
                    juegoTerminado = true;
                    // Rellenamos el progreso para que se vea bonito al final
                    progreso = shushface.toCharArray();
                } else {
                    System.out.println(">>> ¡Incorrecto! Esa no es la palabra.");
                    bodyparts--;
                }
            }
            // OPCIÓN B: JUGAR UNA LETRA
            else {
                letra = input.charAt(0);
                acierto = false;

                // Buscar la letra en la palabra secreta
                for (int i = 0; i < shushface.length(); i++) {
                    if (shushface.charAt(i) == letra) {
                        progreso[i] = letra;
                        acierto = true;
                    }
                }

                if (acierto) {
                    System.out.println(">>> ¡Bien hecho! La letra '" + letra + "' está.");
                    // Comprobar si ya completó la palabra letra por letra
                    if (String.valueOf(progreso).equals(shushface)) {
                        haGanado = true;
                        juegoTerminado = true;
                    }
                } else {
                    System.out.println(">>> Fallaste. La letra '" + letra + "' no está.");
                    bodyparts--;
                }
            }

            // Verificar si se acabaron los intentos
            if (bodyparts == 0) {
                juegoTerminado = true;
                haGanado = false;
            }
        }

        // --- FIN DEL JUEGO ---
        dibujarAhorcado(bodyparts); // Dibujo final
        mostrarProgreso(progreso);

        System.out.println("\n------------------------------------------------");
        if (haGanado) {
            System.out.println("¡FELICIDADES! Has salvado al ahorcado.");
        } else {
            System.out.println("GAME OVER. Has sido ahorcado.");
            System.out.println("La palabra era: " + shushface);
        }
        System.out.println("------------------------------------------------");
    }

    // ocultando la entrada del Jugador 1
    public static void limpiarPantalla() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public static void mostrarProgreso(char[] progreso) {
        System.out.print("Palabra: ");
        for (char c : progreso) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public static void dibujarAhorcado(int tally) {
        System.out.println("\nIntentos restantes: " + tally);
        switch (tally) {
            case 6:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("=========");
                break;
            case 5:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("=========");
                break;
            case 4:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println("  |   |");
                System.out.println("      |");
                System.out.println("=========");
                break;
            case 3:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println(" /|   |");
                System.out.println("      |");
                System.out.println("=========");
                break;
            case 2:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println(" /|\\  |");
                System.out.println("      |");
                System.out.println("=========");
                break;
            case 1:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println(" /|\\  |");
                System.out.println(" /    |");
                System.out.println("=========");
                break;
            case 0:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println(" /|\\  |");
                System.out.println(" / \\  |");
                System.out.println("=========");
                break;
        }
    }
}
