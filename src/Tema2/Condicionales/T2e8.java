package Tema2.Condicionales;

import java.util.Scanner;

public class T2e8 {
    public static void main(String[] args) {
        System.out.println("Introduce un número:");
        Scanner value = new Scanner(System.in);
        double euro = value.nextDouble();
        double dolar = euro * 1.17;
        System.out.println("De euro a dolar, " + euro + " equivalen a " + dolar);
    }
}
