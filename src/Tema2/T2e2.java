package Tema2;

import java.util.Scanner;

public class T2e2 {
    public static void main(String[] args) {
        System.out.println("Introduce un lado del rectángulo:");
        Scanner value = new Scanner(System.in);
        int a = value.nextInt();
        System.out.println("Introduce otro lado del rectángulo:");
        Scanner eulav = new Scanner(System.in);
        int b = eulav.nextInt();
        int area = a*b;
        int perim = 2*(a+b);
        System.out.println("El area es: " + area + ", El perímetro es: " + perim);
    }
}
