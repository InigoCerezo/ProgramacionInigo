package Tema2;

import java.util.Scanner;

public class T2e11 {
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
        if((Num1-Num2==-1 && Num2-Num3==-1)|| ((Num1-Num2==1 && Num2-Num3==1)))   {
            System.out.println("Los números introducidos son consecutivos.");
        } else {
            System.out.println("Los números introducidos no son consecutivos.");
        }
    }
}
