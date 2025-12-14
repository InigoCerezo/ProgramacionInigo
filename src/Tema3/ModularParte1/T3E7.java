package Tema3.ModularParte1;

import java.util.Scanner;

public class T3E7 {
    public static boolean isprime(int a, int b) {
        if (a % b != 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int num1, check, fail;
        System.out.println("Introduce un número positivo. Te dire si es primo.");
        Scanner scanner = new Scanner(System.in);
        num1 = scanner.nextInt();
        while (num1!=0) {
            if (num1>0) {
                check = 2;
                fail = 0;
                while (num1 != check) {
                    if (!isprime(num1, check)) {
                        fail++;
                    }
                    check++;
                }
                if (fail == 0) {
                    System.out.println("El numero " + num1 + " es primo.");
                } else {
                    System.out.println("El numero " + num1 + " no es primo.");
                }
            }  else {
                System.out.println("El numero no era positivo.");
            }
            System.out.println("Introduce otro numero positivo y te diré si es primo.");
            System.out.println("(Introduce cero para salir).");
            num1 = scanner.nextInt();
        }
    }
}