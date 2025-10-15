package Tema2.Condicionales;

import java.util.Scanner;

public class T2e5 {
    public static void main(String[] args) {
        System.out.println("Introduce un número:");
        Scanner a = new Scanner(System.in);
        int Num1 = a.nextInt();
        System.out.println("Introduce otro número:");
        Scanner b = new Scanner(System.in);
        int Num2 = b.nextInt();
        System.out.println("Introduce el último número:");
        Scanner c = new Scanner(System.in);
        int Num3 = c.nextInt();
        double Dec= (double)(Num1+Num2+Num3)/3;
        int Nodec= (Num1+Num2+Num3)/3;
        System.out.println("La media es: " + Dec);
        System.out.println("La media (sin decimales) es: " + Nodec);
    }
}
