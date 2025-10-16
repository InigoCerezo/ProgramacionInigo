package Tema2.Bucles;

import java.util.Scanner;

public class T2e20 {
    public static void main(String[] args) {
        System.out.println("Introduce un número");
        Scanner a = new Scanner(System.in);
        int num1 = a.nextInt();
        System.out.println("Introduce otro número");
        Scanner b = new Scanner(System.in);
        int num2 = b.nextInt();
        while (num1 < num2){
            num1++;
            if(num1 % 2 == 1){
                System.out.println(num1);
            }
        }
        System.out.println("Proceso finalizado.");
    }
}
