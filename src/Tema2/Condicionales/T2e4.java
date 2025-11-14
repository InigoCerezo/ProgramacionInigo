package Tema2.Condicionales;

import java.util.Scanner;

public class T2e4 {
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
        if(Num1 > Num2 && Num1 > Num3) {
            System.out.println("El primer número es el más mayor.");
        } else if(Num1 < Num2 && Num2 > Num3){
            System.out.println("El segundo número es el más mayor.");
        } else if(Num1 < Num3 && Num2 < Num3){
            System.out.println("El tercer número es el más mayor.");
        } else {
            System.out.println("...Hay dos o más números identicos.");
        }
    }
}
