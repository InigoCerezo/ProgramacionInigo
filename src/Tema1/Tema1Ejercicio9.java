package ProgramaciónAna;

import java.util.Scanner;

public class Tema1Ejercicio9 {
    public static void main(String[] args){
        System.out.println("Introduce un número:");
        Scanner a = new Scanner(System.in);
        int A = a.nextInt();
        System.out.println("Introduce otro número:");
        Scanner b = new Scanner(System.in);
        int B = b.nextInt();
        int suma = A + B;
        int resta = A - B;
        int producto = A * B;
        int division = A / B;
        int resto = A % B;
        System.out.println("La suma es: " + suma);
        System.out.println("La resta es: " + resta);
        System.out.println("El producto es: " + producto);
        System.out.println("La división es: " + division);
        System.out.println("El resto es: " + resto);
    }
}
