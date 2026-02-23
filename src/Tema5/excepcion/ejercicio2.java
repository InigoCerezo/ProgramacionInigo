package Tema5.excepcion;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ejercicio2 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un número");
        try{
            int numero1 = sc.nextInt();
            System.out.println("Introduce otro número");
            int numero2 = sc.nextInt();
            int div = numero1/numero2;
            System.out.println("División: "+ div);
        } catch (InputMismatchException | ArithmeticException e) {
            System.out.println("Valor introducido invalido, error: "+e.getMessage());
        }
    }
}
