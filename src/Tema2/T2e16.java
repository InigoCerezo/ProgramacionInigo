package Tema2;

import java.util.Scanner;

public class T2e16 {
    public static void main(String[] args) {
        System.out.println("Introduce: 'D' (Dolar) o 'E' (Euro)");
        Scanner entrada=new Scanner(System.in);
        char moneda=entrada.next().charAt(0);
        System.out.println("Introduce un número:");
        Scanner value = new Scanner(System.in);
        double num = value.nextDouble();
        double dolar = num *1.17;
        double euro = num *0.86;
        if (moneda == 'D'){
            System.out.println("De euro a dolar, " + num + " equivalen a " + dolar);
        }else if(moneda == 'E'){
            System.out.println("De dolar a euro, " + num + " equivalen a " + euro);
        }else System.out.println("Fallo critico.");
    }
}
