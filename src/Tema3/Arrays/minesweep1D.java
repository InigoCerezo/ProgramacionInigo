package Tema3.Arrays;
//pilgrammed es un juegazo que no tienes idea, es una pena que esté medio muerto porque es MUY bueno a pesar de no ser serio
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class minesweep1D {
    public static void main(String[] args) {
        //valores
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        boolean gameOver = false, ganador = false;
        int pos, bombaPlantada = 0, espacio = 20, valor = -1, tally = 0;
        int safeTileTally = 0, totalSafe;
        int minas = rand.nextInt(8) + 1;
        //tablero
        int[] tablero = new int[espacio];
        boolean[] eyes = new boolean[espacio]; // 👀
        Arrays.fill(tablero, 0);
        //plantando las minas
        while (bombaPlantada < minas){
            pos = rand.nextInt(espacio);
            if (tablero[pos] != valor){
                tablero[pos] = valor;
                bombaPlantada++;
            }
        }
        //lo de las pistas
        for (int i = 0; i < espacio; i++){
            if (tablero[i] != valor){
                tally = 0;
                if (i>0 && tablero[i-1] == valor){
                    tally++;
                }
                if (i < espacio - 1 && tablero[i+1] == valor){
                    tally++;
                }
                tablero[i] = tally;
            }
        }
        totalSafe = espacio - minas;
        //esto solo sale al principio y nunca mas
        System.out.println("--- BUSCAMINAS 1D ---");
        System.out.println("Hay " + minas + " minas escondidas en 20 casillas.");
        System.out.println("Pistas: 1 = una mina al lado, 2 = entre dos minas, 0 = libre.");
        while (!gameOver){
            checkIt(tablero, eyes, false);
            pos = kaboom(sc, eyes, espacio);
            if (tablero[pos] == valor){
                System.out.println("JAJAJAJJAJAJAJAJAJAJAJAJAJJAJAJAAJJAJAJAAAAAAAJAJAJA");
                Arrays.fill(eyes, true);
                checkIt(tablero, eyes, true);
                gameOver = true;
            }else {
                eyes[pos] = true;
                safeTileTally++;
                if (safeTileTally == totalSafe){
                    gameOver = true;
                    ganador = true;
                }
            }
        }
        if (ganador) {
            System.out.println("\n¡ENHORABUENA! Has despejado todo el campo de minas.");
            //yay, yippie
            checkIt(tablero, eyes, true);
        } else {
            System.out.println("\nHAS PERDIDO, JAJAJAJAJAJAJJAJA");
        }
    }

    public static void checkIt(int[] tablero, boolean[] eyes, boolean gameOver) {
        System.out.println("Estado del campo:");
        System.out.print("|");
        for (int i = 0; i < tablero.length; i++) {
            if (eyes[i]) {
                if (tablero[i] == -1) {// si es mina
                    System.out.print(" * |");
                } else { // si no es mina
                    System.out.print(" " + tablero[i] + " |");
                }
            } else {
                // Si es fin del juego y es una mina que no explotó (en caso de ganar), la mostramos como bandera o mina
                if (gameOver && tablero[i] == -1 && !eyes[i]) {
                    System.out.print(" M |");
                } else {
                    System.out.print(" ? |"); 
                }
            }
        }
    }
    public static int kaboom(Scanner sc, boolean[] eyes, int size){
        int point = -1;
        boolean valida = false;
        while (!valida){
            System.out.println("Elige casilla a descubrir (de 1 a " + size + "): ");
            if (sc.hasNextInt()){
                point = sc.nextInt() - 1;
                if (point >= 0 && point <= size){
                    if (eyes[point]){
                        System.out.println("Casilla ya descubierta. Acción invalidada.");
                    } else {
                        valida = true;
                    }
                } else {
                    System.out.println("Fuera de rango.");
                }
            }else {
                System.out.println("Entrada no válida");
                sc.next();
            }
        }
        return point;
    }
}
