package Tema2.Condicionales;

import java.util.Scanner;

public class T2e10 {
    public static void main(String[] args){
        System.out.println("Introduce un número:");
        Scanner a = new Scanner(System.in);
        int Num1 = a.nextInt();
        System.out.println("Introduce otro número:");
        Scanner b = new Scanner(System.in);
        int Num2 = b.nextInt();
        System.out.println("Introduce el último número:");
        Scanner c = new Scanner(System.in);
        int Num3 = c.nextInt();
        if(Num1 < Num2 && Num2 < Num3) {
            System.out.println("Los números introducidos están de menor a mayor.");
        } else {
            System.out.println("Los números introducidos no están de menor a mayor.");
        } //hellll
    }
}
