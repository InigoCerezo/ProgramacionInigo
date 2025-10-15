package Tema2;

import java.util.Scanner;

public class T2e17 {
    public static void main(String[] args) {
        System.out.println("Introduce forma: 0. Cuadrado / 1. Rectangulo / 2. Triangulo");
        Scanner c = new Scanner(System.in);
        int shape = c.nextInt();
        switch (shape) {
            case 0:
                System.out.println("Introduce lado:");
                Scanner a = new Scanner(System.in);
                double base = a.nextDouble();
                double area = base * 2;
                double perm = base * 4;
                System.out.println("El area es: " + area + ", El perímetro es: " + perm);
            case 1:
                System.out.println("Introduce base:");
                a = new Scanner(System.in);
                base = a.nextInt();
                System.out.println("Introduce altura:");
                Scanner b = new Scanner(System.in);
                double altura = b.nextInt();
                area = (base * altura);
                perm = (base + altura)*2;
                System.out.println("El area es: " + area + ", El perímetro es: " + perm);
            case 2:
                System.out.println("Introduce base:");
                a = new Scanner(System.in);
                base = a.nextInt();
                System.out.println("Introduce altura:");
                b = new Scanner(System.in);
                altura = b.nextInt();
                area = (base * altura) / 2;
                System.out.println("El area es: " + area);
            default:
                System.out.println("bruh.");
        }
    }
}
