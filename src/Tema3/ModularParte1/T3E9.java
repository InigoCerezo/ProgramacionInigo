package Tema3.ModularParte1;

import java.util.Scanner;

public class T3E9 {
    public static void piramide(int alt, char car) {
        int base = alt * 2 - 1;
        for (int i = 0; i < alt; i++) {
            for (int t = 0; t < base; t++) {
                if (t >= alt - 1 - i && t <= alt - 1 + i)
                    System.out.print(car);
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la altura de un triangulo y yo intentaré recrearlo");
        int altura = sc.nextInt();
        System.out.println("Ahora introduce un carácter cualquiera:");
        char caracter = sc.next().charAt(0);
        piramide(altura, caracter);
        System.out.println();
    }
}
