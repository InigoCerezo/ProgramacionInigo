package Tema3.ModularParte2;

import java.util.Scanner;

public class T3E10myMath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = Integer.toString(a).length();
        System.out.println("El número " + a + " tiene " + b + " dígitos");
    }
}
