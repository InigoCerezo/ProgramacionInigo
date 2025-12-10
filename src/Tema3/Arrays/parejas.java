package Tema3.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;

public class parejas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 1. PREPARACIÓN DEL TABLERO
        // Creamos una lista con las parejas (10 parejas = 20 animales)
        // Usamos una lista primero para poder usar 'Collections.shuffle' fácilmente
        List<String> listaAnimales = new ArrayList<>();
        String[] tipos = {
                "León", "Mandril", "Suricata", "Facóquero", "Hiena",
                "Elefante", "Jirafa", "Cebra", "Rinoceronte", "Hipopótamo"
        };

        // Añadimos cada animal dos veces
        for (String animal : tipos) {
            listaAnimales.add(animal);
            listaAnimales.add(animal);
        }

        // Barajamos aleatoriamente
        Collections.shuffle(listaAnimales);

        // Pasamos la lista a un Array fijo de 20 elementos (como pide el ejercicio)
        String[] tablero = listaAnimales.toArray(new String[0]);

        // 2. ARRAY DE VISIBILIDAD
        // true = se muestra el animal, false = se muestra oculto
        boolean[] visible = new boolean[20];

        int parejasEncontradas = 0;
        int totalParejas = 10;

        // 3. BUCLE DEL JUEGO
        while (parejasEncontradas < totalParejas) {

            // --- TURNO: PRIMERA CARTA ---
            imprimirTablero(tablero, visible);
            int pos1 = pedirPosicion(scanner, visible, -1); // -1 porque no hay carta previa

            // Mostramos temporalmente la primera carta
            visible[pos1] = true;
            imprimirTablero(tablero, visible);

            // --- TURNO: SEGUNDA CARTA ---
            int pos2 = pedirPosicion(scanner, visible, pos1); // Pasamos pos1 para que no repita la misma

            // Mostramos temporalmente la segunda carta
            visible[pos2] = true;
            imprimirTablero(tablero, visible);

            // --- COMPROBACIÓN ---
            if (tablero[pos1].equals(tablero[pos2])) {
                System.out.println("\n¡CORRECTO! Has encontrado una pareja de " + tablero[pos1] + ".");
                parejasEncontradas++;
                // No cambiamos 'visible' a false, se quedan true para siempre
            } else {
                System.out.println("\nINCORRECTO. No son pareja.");
                try {
                    // Esperamos 3 segundos para que el jugador memorice
                    System.out.println("Memoriza las cartas... se ocultarán en 3 segundos.");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Ocultamos las cartas de nuevo
                visible[pos1] = false;
                visible[pos2] = false;

                // "Limpiamos" la pantalla con saltos de línea
                limpiarPantalla();
            }
        }

        System.out.println("\n¡FELICIDADES! Has encontrado todas las parejas.");
        scanner.close();
    }

    // Método para imprimir el tablero
    // Muestra el animal si visible[i] es true, o el número de posición si es false
    public static void imprimirTablero(String[] tablero, boolean[] visible) {
        System.out.println("\n--- TABLERO DE MEMORIA ---");
        for (int i = 0; i < tablero.length; i++) {
            // Salto de línea cada 5 elementos para que se vea como una cuadrícula (4x5)
            if (i % 5 == 0 && i != 0) {
                System.out.println();
            }

            if (visible[i]) {
                // Si está visible, mostramos el nombre (ajustado a 12 espacios para que quede bonito)
                System.out.printf("[%10s] ", tablero[i]);
            } else {
                // Si no, mostramos la posición
                System.out.printf("[%10s] ", "Pos " + i);
            }
        }
        System.out.println("\n--------------------------");
    }

    // Método para pedir posición y validar que sea correcta
    public static int pedirPosicion(Scanner scanner, boolean[] visible, int cartaPrevia) {
        int pos = -1;
        boolean valida = false;

        while (!valida) {
            System.out.print("Elige una posición (0-19): ");
            if (scanner.hasNextInt()) {
                pos = scanner.nextInt();

                // Validaciones:
                // 1. Que esté dentro del rango 0-19
                // 2. Que no esté ya visible (ya encontrada o seleccionada en este turno)
                // 3. Que no sea la misma carta que acabamos de levantar (si es el segundo turno)
                if (pos >= 0 && pos < 20) {
                    if (visible[pos]) {
                        System.out.println("¡Esa posición ya está descubierta! Elige otra.");
                    } else if (pos == cartaPrevia) {
                        System.out.println("¡No puedes elegir la misma carta dos veces!");
                    } else {
                        valida = true;
                    }
                } else {
                    System.out.println("Número fuera de rango. Debe ser entre 0 y 19.");
                }
            } else {
                System.out.println("Por favor, introduce un número válido.");
                scanner.next(); // Limpiar buffer
            }
        }
        return pos;
    }

    // Método para simular limpieza de pantalla
    public static void limpiarPantalla() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}