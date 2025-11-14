package Tema2.Bucles;

import java.util.Scanner;

public class T2e23 {
    public static void main(String[] args) {
        System.out.println("Introduce un número positivo (Si introduces uno negativo, sales del programa)");
        Scanner a = new Scanner(System.in);
        int num1 = a.nextInt();
        int suma = 0;
        int divis = 0;
        while (num1 > 0) {
            suma = suma+num1;
            divis++;
            System.out.println("Introduce un número positivo (Si introduces uno negativo, sales del programa)");
            num1 = a.nextInt();
        }
        int noli = suma/divis;
        System.out.println("La media total de los números introducidos es: "+noli);
    }
}
