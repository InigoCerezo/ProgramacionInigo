package Tema2.Condicionales;

import java.util.Scanner;

public class T2e18 {
    public static void main(String[] args) {
        System.out.println("Introduce un número: ");
        Scanner c = new Scanner(System.in);
        int num = c.nextInt();
        while (num < 0) {
            System.out.println("Fallo critico.");
            num = c.nextInt();
        }
        double root = Math.sqrt(num);
        System.out.println("La raiz es: " + root);
    }
}
