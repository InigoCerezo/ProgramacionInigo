package Tema5.excepcion;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ejercicio1 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un número");
        try{
        int numero = sc.nextInt();
        System.out.println("Valor introducido: "+numero);
        } catch (InputMismatchException e) {
            System.out.println("Valor introducido invalido, error: "+e);
        }
    }
}
