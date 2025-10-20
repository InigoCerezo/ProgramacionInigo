package Tema2.Bucles;

import java.util.Random;
import java.util.Scanner;

public class T2e28 {
    public static void main(String[] args) {
        Random tombola = new Random();
        int loteria = tombola.nextInt(99999);
        System.out.println("Tengo aquí el número de la lotería.");
        System.out.println("Adivina el número.");
        Scanner a = new Scanner(System.in);
        int num1 = a.nextInt();
        int fail = 0;
        while(num1 != loteria){
            fail++;
            System.out.println("No, no era ese número.");
            if (fail>5){
                break;
            }
            System.out.println("Adivina el número.");
            //System.out.println(loteria); //cosa mia para ver si funciona bien
            num1 = a.nextInt();
        }//oh espera el break te va a sacar del bucle sin saber si está correcto
        if (num1 == loteria){//ahora está mejor
        System.out.println("Bravo, lo has adivinado.");
        }
    }
}
