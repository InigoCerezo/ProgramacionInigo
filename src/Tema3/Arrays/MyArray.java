package Tema3.Arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MyArray {
    public static void globalMenuP3() {
        System.out.println("Menu global.");//menu global
        System.out.println("--------------------------------------");
        System.out.println("a - Imprimir array");
        System.out.println("b - Ver el valor máximo del array");
        System.out.println("c - Ver el valor mínimo del array");
        System.out.println("d - Sacar la media del array");
        System.out.println("e - Buscador de dígitos del array");
        System.out.println("f - Calculador de suma de dos vectores");
        System.out.println("g - Calculador de resta de dos vectores");
        System.out.println("h - Calculador de producto escalar de dos vectores");
        System.out.println("i - Inversión del orden de un array");
        System.out.println("j - Procedimiento de inversión del orden de un array");
        System.out.println("k - Indicador de arrays capicua");
        System.out.println("l - Introductor de vectores de array");
        System.out.println("Otra opción - Salir");
    }
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
    public static int plusArray(int[] a, int[] b, int c, int d) {
        return a[c] + b[d];
    }
    public static int minusArray(int[] a, int [] b, int c, int d) {
        return a[c] - b[d];
    }
    public static int scalarArray(int[] a, int[] b, int c, int d, int e, int f) {
        return (a[c] * b[d]) + (a[e] * b[f]);
    }
    public static int[] inverseArray(int[] array) {
        int[] auxiliar = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int j = array.length-i-1;
            auxiliar[j] = array[i];
        }
        return auxiliar;
    }
    public static boolean cicArray(int[] array) {
        int cap = 0;
        int cua = array.length-1;
        while (cap < cua){
            cap++;
            cua--;
        }
        return false;
    }
    public static void inverseVoidArray(int[] a) {
        Collections.reverse(Arrays.asList(a));
        System.out.println(Arrays.toString(inverseArray(a)));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int finder, val1, val2, val3, val4;
        int[] grades, marks;
        char choose, eleccion, exit = 'n';
        grades = new int[]{30, 22, 84, 36, 58, 18};
        marks = new int[]{20, 17, 44, 32, 6, 85};
        while (exit != 'y' || exit != 'Y'){
            globalMenuP3();
            choose = sc.next().charAt(0);
            switch (choose){
                case 'a':
                    System.out.println("Array 1 (grades): ");
                    printArray(grades);
                    System.out.println("\n\nArray 2 (marks): ");
                    printArray(marks);
                    System.out.println();
                    break;
                case 'b':
                    System.out.println("Nota máxima: " + maxArray(grades));
                    break;
                case 'c':
                    System.out.println("Nota mínima: " + minArray(grades));
                    break;
                case 'd':
                    System.out.println("Nota mínima: " + avgArray(grades));
                    break;
                case 'e':
                    System.out.println("Escribe un número que esté en el array: ");
                    finder = sc.nextInt();
                    if (finderArray(grades, finder)) {
                        if (finderArray(marks, finder)){
                            System.out.println("Bravo, está dentro de los dos arrays.");
                        }else{
                            System.out.println("Bravo, está dentro del primer array.");
                        }
                    }else if (finderArray(marks, finder)) {
                        System.out.println("Bravo, está dentro del segundo array");
                    }else{
                        System.out.println("Oh, Ese numero no está dentro del array.");
                    }
                    break;
                case 'f':
                    System.out.println("Ahora vamos a sumar dos vectores. Elige uno (por posición del array).");
                    val1 = sc.nextInt();
                    System.out.println("Elige otro (2do array).");
                    val2 = sc.nextInt();
                    System.out.println("La suma de los valores " + grades[val1] + " y " + marks[val2] + " es igual a: " + plusArray(grades, marks, val1, val2));
                    break;
                case 'g':
                    System.out.println("Ahora vamos a restar dos vectores. Elige uno (por posición del array).");
                    val1 = sc.nextInt();
                    System.out.println("Elige otro (2do array).");
                    val2 = sc.nextInt();
                    System.out.println("La resta de los valores " + grades[val1] + " y " + marks[val2] + " es igual a: " + minusArray(grades, marks, val1, val2));
                    break;
                case 'h':
                    System.out.println("Vamos a sacar el producto escalar de dos vectores. Elige uno (del 1er array, por posición del array).");
                    val1 = sc.nextInt();
                    System.out.println("Elige otro (2do array).");
                    val2 = sc.nextInt();
                    System.out.println("Elige otro.");
                    val3 = sc.nextInt();
                    System.out.println("Elige otro. (2do array).");
                    val4 = sc.nextInt();
                    System.out.println("Valores utilizados: " + grades[val1] + ", " + marks[val2] + ", " + grades[val3] + ", " + marks[val4]);
                    System.out.println("El producto escalar es igual a: " + scalarArray(grades, marks, val1, val2, val3, val4));
                    break;
                case 'i':
                    System.out.println("Elige un array (G o M): ");
                    eleccion = sc.next().charAt(0);
                    switch(eleccion){
                        case 'g':
                        case 'G':
                            System.out.println(Arrays.toString(inverseArray(grades)));
                            break;
                        case 'm':
                        case 'M':
                            System.out.println(Arrays.toString(inverseArray(grades)));
                            break;
                    }
                    break;
                case 'j':
                    System.out.println("Elige un array (G o M): ");
                    eleccion = sc.next().charAt(0);
                    switch(eleccion){
                        case 'g':
                        case 'G':
                            inverseVoidArray(grades);
                            break;
                        case 'm':
                        case 'M':
                            inverseVoidArray(marks);
                            break;
                    }
                    inverseVoidArray(grades);
                    break;
                case 'k':
                    cicArray(grades);
                    break;
                case 'l':
                    System.out.println("Elige un array (G o M): ");
                    eleccion = sc.next().charAt(0);
                    switch(eleccion){
                        case 'g':
                        case 'G':
                            System.out.println("Introduce un caracter para introducirlo al array: ");
                            System.out.println("Cantidad de vectores del array: " + grades.length);
                            val1 = sc.nextInt();
                            grades = Arrays.copyOf(grades, grades.length + 1);
                            grades[grades.length - 1] = val1;
                            printArray(grades);
                            System.out.println();
                            break;
                        case 'm':
                        case 'M':
                            System.out.println("Introduce un caracter para introducirlo al array: ");
                            System.out.println("Cantidad de vectores del array: " + marks.length);
                            val1 = sc.nextInt();
                            marks = Arrays.copyOf(marks, marks.length + 1);
                            marks[marks.length - 1] = val1;
                            printArray(marks);
                            System.out.println();
                            break;
                        default:
                            System.out.println("Opcion incorrecta.");
                            break;
                    }
                default:
                    break;
            }
            System.out.println("¿Quieres salir? (Y/N)"); //linea encargada de salir
            exit=sc.next().charAt(0);// otro caracter hace lo mismo que n, no salir
        }
    }
}
