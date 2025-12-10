package Tema3.Arrays;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Mosca {
    public static boolean porPoco(int index, int mosca) {
        // me compliqué mucho haciendo esto
        return Math.abs(index - mosca) == 1;
    }
    public static void main (String[] args){
        //Inicialización de variables
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int[] tablero = new int[15];
        int mosca = rand.nextInt(15);
        int eleccion, index, fail = 0;
        boolean gameOver = false;
        //preparando el juego
        Arrays.fill(tablero, 0);
        tablero[mosca] = 1;
        System.out.println("--------JUEGO: ATRAPA A LA MOSCA--------");
        System.out.println("----elige un número del 1 al 15 para acertar!----");
        System.out.println("CUIDADO: si estás muy cerca, la mosca cambiara de posición!");
        //bucle
        while (!gameOver){
            System.out.println("Introduce una posición (1-15)");
            //System.out.println(mosca+1);
            eleccion = sc.nextInt();
            while (eleccion<1 || eleccion>15){
                System.out.println("Introduce una posición valida (1-15)");
                eleccion = sc.nextInt();
            }
            index = eleccion-1;
            if (tablero[index] == 1){
                if (fail == 0){
                    System.out.println("¡Diana! ¡Atrapaste a la mosca y al primer intento!");
                }else{
                    System.out.println("¡Diana! ¡Atrapaste a la mosca!");
                    if (fail == 1){
                        System.out.println("Has fallado una vez.");
                    }else {
                        System.out.println("Has fallado unas " + fail + " veces.");
                    }
                }
                gameOver = true;
            }else if(porPoco(index, mosca)){
                fail++;
                System.out.println("¡Estabas muy muy cerca! ¡Pero la mosca ha salido volando y ahora esta en otro sitio!");
                tablero[mosca] = 0;
                mosca = rand.nextInt(15);
                tablero[mosca] = 1;
                //System.out.println(mosca+1);
            }else{
                System.out.println("No le diste a nada... ¡Continua!");
                fail++;
            }
        }
    }
}
