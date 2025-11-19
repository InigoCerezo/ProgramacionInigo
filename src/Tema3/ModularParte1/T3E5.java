package Tema3.ModularParte1;

import java.util.Scanner;

public class T3E5 {
    public static void mutliplication(int a) { // throws InterruptedException
        System.out.println("Tabla de multiplicar del numero "+a+" al 10.");
        System.out.println("--------------------------------------");
        System.out.println(a +" * 1 = " + a*1);
        //Thread.sleep(200);
        System.out.println(a +" * 2 = " + a*2);
        //Thread.sleep(200);
        System.out.println(a +" * 3 = " + a*3);
        //Thread.sleep(200);
        System.out.println(a +" * 4 = " + a*4);
        //Thread.sleep(200);
        System.out.println(a +" * 5 = " + a*5);
        //Thread.sleep(200);
        System.out.println(a +" * 6 = " + a*6);
        //Thread.sleep(200);
        System.out.println(a +" * 7 = " + a*7);
        //Thread.sleep(200);
        System.out.println(a +" * 8 = " + a*8);
        //Thread.sleep(200);
        System.out.println(a +" * 9 = " + a*9);
        //Thread.sleep(200);
        System.out.println(a +" * 10 = " + a*10);
        //Thread.sleep(200);
    }
    public static void main(String[] args) throws InterruptedException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce un  número del 1 al 10");
        int a = scanner.nextInt();
        while(a < 1 || a > 10){
            System.out.println("Numero introducido incorrecto. Introducelo otra vez.");
            a = scanner.nextInt();
        }
        mutliplication(a);
    }
}
