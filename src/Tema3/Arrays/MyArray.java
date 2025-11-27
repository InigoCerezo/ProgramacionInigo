package Tema3.Arrays;

import java.util.Scanner;

public class MyArray {
    public static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ", ");
        }
    }
    public static int minArray(int[] a) {
        int min = a[0]+99;
        for (int i = 0; i < a.length; i++) {
            if (min >= a[i]) {
                min = a[i];
            }
        }
        return min;
    }
    public static int maxArray(int[] a) {
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            if (max <= a[i]) {
                max = a[i];
            }
        }
        return max;
    }
    public static int avgArray(int[] a) {
        int avg = 0;
        for (int i = 0; i < a.length; i++) {
            avg += a[i];
        }
        return avg/a.length;
    }
    public static boolean finderArray(int[] a, int b) {
        boolean found = false;
        for (int i = 0; i < a.length && !found; i++) {
            if (a[i] == b) {
                found = true;
            }
        }
        return found;
    }
    public static int plusArray(int[] a, int b, int c) {
        return a[b] + a[c];
    }
    public static int minusArray(int[] a, int b, int c) {
        return a[b] - a[c];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int finder, val1, val2;
        int[] grades;
        grades = new int[]{30, 22, 84, 36, 58, 10, 20, 72, 64, 96, 18};
        printArray(grades);
        System.out.println();
        System.out.println("Nota máxima: " + maxArray(grades));
        System.out.println("Nota mínima: " + minArray(grades));
        System.out.println("Nota mínima: " + avgArray(grades));
        System.out.println("Escribe un número que esté en el array: ");
        finder = sc.nextInt();
        if (finderArray(grades, finder)) {
            System.out.println("Bravo, está dentro del array.");
        }else{
            System.out.println("Oh, Ese numero no está dentro del array.");
        }
        System.out.println("Ahora vamos a sumar dos vectores. Elige uno (por posición del array).");
        val1 = sc.nextInt();
        System.out.println("Elige otro (por posición del array).");
        val2 = sc.nextInt();
        System.out.println("La suma de los valores " + grades[val1] + " y " + grades[val2] + " es igual a: " + plusArray(grades, val1, val2));
    }
}
