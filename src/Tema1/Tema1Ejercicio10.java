package Tema1;

import java.util.Scanner;

public class Tema1Ejercicio10 {
    public static void main(String[] args){
        System.out.println("Introduce un número:");
        Scanner a = new Scanner(System.in);
        double A = a.nextDouble();
        System.out.println("Introduce otro número:");
        Scanner b = new Scanner(System.in);
        double B = b.nextDouble();
        double suma = A + B;
        double resta = A - B;
        double producto = A * B;
        double division = A / B;
        double resto = A % B;
        System.out.println("La suma es: " + suma);
        System.out.println("La resta es: " + resta);
        System.out.println("El producto es: " + producto);
        System.out.println("La división es: " + division);
        System.out.println("El resto es: " + resto);
    }
}
