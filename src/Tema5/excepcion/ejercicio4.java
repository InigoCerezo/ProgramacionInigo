package Tema5.excepcion;

import java.util.Random;
import java.util.Scanner;

public class ejercicio4 {
    static Scanner sc = new Scanner(System.in);
    static Random rd = new Random();
    static int rng = rd.nextInt(100) + 1;
    static int[] vector = new int[rng];

    public static void main(String[] args) {
        int n;
        boolean b = true;
        System.out.println(rng);
        for (int i = 0; i < rng; i++) {
            vector[i] = rd.nextInt(10) + 1;
        }
        while (b) {
            System.out.println("Ingrese un numero que esté dentro del array:");
            try {
                n = sc.nextInt();
                System.out.println("Posición: " + n + "Valor: " + vector[n]);
            } catch (Exception e) {
                System.out.println("Eso no te ha dejado. Código error:\n" + e);
                b = false;
            }
        }
    }
}
