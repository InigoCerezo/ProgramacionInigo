package Tema2;

import java.util.Scanner;

public class T2e7 {
    public static void main(String[] args) {
        System.out.println("Introduce un número:");
        Scanner value = new Scanner(System.in);
        int Num1 = value.nextInt();
        System.out.println("Introduce otro número");
        Scanner eulav = new Scanner(System.in);
        int Num2 = eulav.nextInt();
        if(Num1 > Num2) {
            int jiji = Num1 - Num2;
            System.out.println(Num1 + " menos " + Num2 + " Es igual a " + jiji);
        } else if(Num1 == Num2){
            System.out.println(Num1 + " menos " + Num2 + " Es igual a cero.");
        } else {
            int jiji = Num2 - Num1;
            System.out.println(Num2 + " menos " + Num1 + " Es igual a " + jiji);
        }
    }
}
