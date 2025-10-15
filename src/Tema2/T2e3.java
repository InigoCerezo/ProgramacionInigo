package Tema2;

import java.util.Scanner;

public class T2e3 {
    public static void main(String[] args) {
        System.out.println("Introduce la base del triángulo");
        Scanner value = new Scanner(System.in);
        int a = value.nextInt();
        System.out.println("Introduce la hipotenusa del triangulo");
        Scanner eulav = new Scanner(System.in);
        int b = eulav.nextInt();
        float area = (float)(a*b)/2;
        System.out.println("El area es: " + area);
    }
}
