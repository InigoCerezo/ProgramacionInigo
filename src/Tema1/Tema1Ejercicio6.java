package ProgramaciónAna;

import java.util.Scanner;

public class Tema1Ejercicio6 {
    public static void main(String[] args) {
        System.out.println("Introduce un radio r en metros");
        Scanner r = new Scanner(System.in);
        int R = r.nextInt();
        float area = (float) (Math.PI * Math.pow(R, 2));
        System.out.println("El area del circulo es: " + area + " metros cuadrados.");
    }
}
