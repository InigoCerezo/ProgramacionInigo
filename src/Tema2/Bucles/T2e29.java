package Tema2.Bucles;

import java.util.Random;
import java.util.Scanner;

public class T2e29 {
    public static void main(String[] args) {
        Random rnd = new Random();
        int highlow = rnd.nextInt(100);
        System.out.println("Estoy pensando en un número.");
        System.out.println("Adivina el número.");
        Scanner a = new Scanner(System.in);
        int num1 = a.nextInt();
        //int fail = 0;
        while(num1 != highlow){
            //fail++;
            System.out.println("No, no era ese número.");
            if (num1 > highlow){
                System.out.println("El número que quiero es menor.");
            }else{
                System.out.println("El número que quiero es mayor.");
            }
            System.out.println("Adivina el número.");
            //System.out.println(highlow); //cosa mia para ver si funciona bien
            num1 = a.nextInt();
        }
        System.out.println("Bravo, lo has adivinado.");
        /*
        //lol
        if(fail == 1){
        System.out.println("Te ha costado una vez.")
        }else{
        System.out.println("Te ha costado unas " + fail + " veces.)
        }
         */
   }
}
