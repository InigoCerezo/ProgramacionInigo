package Tema1;

import java.util.Scanner;

public class Tema1Ejercicio8 {
    public static void main(String[] args){
        System.out.println("Introduce un número:");
        Scanner a = new Scanner(System.in);
        int A = a.nextInt();
        System.out.println("Introduce otro número:");
        Scanner b = new Scanner(System.in);
        int B = b.nextInt();
        if(A > B) {
            System.out.println(A + " es mayor a " + B);
        } else if(A == B){
            System.out.println(A + " es igual a " + B);
        } else {
            System.out.println(B + " es mayor que " + A);
        }
    }
}
