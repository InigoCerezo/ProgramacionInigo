package Tema2.Bucles;

import java.util.Scanner;

public class T2e25 {
    public static void main(String[] args) {
        System.out.println("Introduce un número");
        Scanner a = new Scanner(System.in);
        int num1 = a.nextInt();
        int factory = 1;
        for (int num2 = 1; num2 <= num1; num2++){
            factory = factory * num2;
        }
        System.out.println("El factorial de " + num1 + " es " + factory);
    }
}
