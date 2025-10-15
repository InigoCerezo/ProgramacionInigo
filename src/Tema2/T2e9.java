package Tema2;

import java.util.Scanner;

public class T2e9 {
    public static void main(String[] args) {
        System.out.println("Introduce un número:");
        Scanner value = new Scanner(System.in);
        double dolar = value.nextDouble();
        double euro = dolar * 0.86;
        System.out.println("De dolar a euro, " + dolar + " equivalen a " + euro);
    }
}
