package Tema2;

import java.util.Scanner;

public class T2e1 {
    public static void main(String[] args) {
        System.out.println("Introduce un lado del cuadrado:");
        Scanner value = new Scanner(System.in);
        int a = value.nextInt();
        int area = a*a;
        int perim = a*4;
        System.out.println("El area es: " + area + ", El perímetro es: " + perim);
    }
}
