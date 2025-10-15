package Tema2.Condicionales;

import java.util.Scanner;

public class T2e6 {
    public static void main(String[] args){
        System.out.println("Introduce un número:");
        Scanner a = new Scanner(System.in);
        int Num1 = a.nextInt();
        if(Num1 > 0) {
            System.out.println("El número introducido es positivo.");
        } else if(Num1 == 0){
            System.out.println("El número introducido es cero.");
        } else {
            System.out.println("El número introducido es negativo.");
        }
    }
}
