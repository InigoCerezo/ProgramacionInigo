package Tema3.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;

public class parejas {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int pos1, pos2, parejasEncontradas = 0, totalParejas = 10;
        // 1. PREPARACIÓN DEL TABLERO
        // Creamos una lista con las parejas (10 parejas = 20 animales)
        // Usamos una lista primero para poder usar 'Collections.shuffle' fácilmente
        List<String> listaAnimales = new ArrayList<>();
        String[] tipos = {
        "León", "Mono", "Ardilla", "Gorrión", "Hiena", "Perro", "Jirafa", "Cebra", "Gato", "Ratón"
        };
        // bañadimos cada animal dos veces
        for (String animal : tipos) {
            listaAnimales.add(animal);
            listaAnimales.add(animal);
        }
        // barajamos aleatoriamente
        Collections.shuffle(listaAnimales);
        // Pasamos la lista a un Array fijo de 20 elementos (como pide el ejercicio)
        String[] tablero = listaAnimales.toArray(new String[0]);
        // 2. ARRAY DE VISIBILIDAD
        // quiero llorar
        boolean[] visible = new boolean[20];
        // 3. BUCLE DEL JUEGO
        while (parejasEncontradas < totalParejas) {
            // escoge la primera carta
            imprimirTablero(tablero, visible);
            pos1 = pedirPosicion(scanner, visible, -1); // -1 porque no hay carta previa
            // mostramos temporalmente la primera carta
            visible[pos1] = true;
            imprimirTablero(tablero, visible);
            // escoge la segunda carta
            pos2 = pedirPosicion(scanner, visible, pos1); // Pasamos pos1 para que no repita la misma
            // mostramos temporalmente la segunda carta
            visible[pos2] = true;
            if (tablero[pos1].equals(tablero[pos2])) {
                imprimirTablero(tablero, visible);
                System.out.println("\n¡CORRECTO! Has encontrado una pareja de " + tablero[pos1] + ".");
                parejasEncontradas++;
                // ya que has encontrado las parejas, estas se quedan en 'true' hasta que se acabe el juego
            } else {
                System.out.println("INCORRECTO. No son pareja.");
                System.out.println("Memoriza las cartas... se ocultarán en 3 segundos.");
                imprimirTablero(tablero, visible);
                // si tienes un comando para hacer esto pero mejor me lo dices
                Thread.sleep(3000);
                visible[pos1] = false;
                visible[pos2] = false;
                // ocultamos las cartas de nuevo y "limpiamos" la pantalla con saltos de línea
                limpiarPantalla();
            }
        }

        System.out.println("\n¡FELICIDADES! Has encontrado todas las parejas.");
        scanner.close();
    }

    // procedimiento para imprimir el tablero
    public static void imprimirTablero(String[] tablero, boolean[] visible) {
        System.out.println("--- TABLERO DE MEMORIA ---");
        for (int i = 0; i < tablero.length; i++) {
            // Salto de línea cada 10 elementos para que se vea bien (en mi opinion la cual es FACTO)
            if (i % 10 == 0 && i != 0) {
                System.out.println();
            }
            if (visible[i]) {// Si está visible, mostramos el nombre (ajustado a 8 espacios)
                System.out.printf("[%6s] ", tablero[i]);
            } else {// Si no, mostramos la posición (ajustado a 8 espacios también)
                System.out.printf("[%6s] ", "Pos " + (i + 1));
            }
        }
        System.out.println("\n--------------------------");
    }
    // función para pedir posición y validar que sea correcta
    public static int pedirPosicion(Scanner scanner, boolean[] visible, int cartaPrevia) {
        int pos = -1;
        boolean valida = false;
        while (!valida) {
            System.out.print("Elige una posición (1-20): ");
            if (scanner.hasNextInt()) {
                pos = scanner.nextInt()-1;
                if (pos >= 0 && pos < 20) {
                    if (visible[pos]) {//¿esa carta ya está visible?
                        System.out.println("¡Esa posición ya está descubierta! Elige otra.");
                    } else if (pos == cartaPrevia) {//¿es el segundo turno y levantas la misma carta?
                        System.out.println("¡No puedes elegir la misma carta dos veces!");
                    } else {
                        valida = true;
                    }
                } else {// ¿está fuera del rango?
                    System.out.println("Número fuera de rango. Debe ser entre 1 y 20.");
                }
            } else {
                System.out.println("Por favor, introduce un número válido.");
                scanner.next(); // Limpiar buffer
            }
        }
        return pos;
    }

    // limpieza de pantalla, si tienes otra función o metod de hacer esto me lo dices
    public static void limpiarPantalla() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}