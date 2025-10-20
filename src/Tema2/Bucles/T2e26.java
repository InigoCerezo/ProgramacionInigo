package Tema2.Bucles;

import java.util.Scanner;

public class T2e26 {
    public static void main(String[] args) {
        System.out.println("Introduce un número");
        Scanner a = new Scanner(System.in);
        int num1 = a.nextInt();
        int fail = 0;
        for (int check = 2; num1 % check == 0; check++) {
            fail++;
        }
        if (fail > 1){
            System.out.println("El número no es primo");
        }else {
            System.out.println("El número ES primo");
        }
    }
}
