package Tema2.Bucles;

import java.util.Random;
import java.util.Scanner;

public class T2e28 {
    public static void main(String[] args) {
        Random tombola = new Random();
        int loteria = tombola.nextInt(99999);
        System.out.println("Tengo aquí el número de la lotería.");
        Scanner a = new Scanner(System.in);
        int num1;
        int fail = 0;
        int good = 0;
        while(fail < 5||good==1){
            System.out.println("Adivina el número.");
            num1 = a.nextInt();
            if (num1 != loteria){
                fail++;
                System.out.println("No, no era ese número.");
            } else {
                System.out.println("Bravo, lo has adivinado.");
                good++;
            }
            //System.out.println(loteria); //cosa mia para ver si funciona bien
        }
        if (fail == 5){
            System.out.println("Lo intentaste.");
        }
    }
}
