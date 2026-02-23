package Tema5.excepcion;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean b = true;
        double[] eggies = new double[5];
        try{
            for (int i = 0; i < eggies.length; i++) {
                System.out.println("Introduce un vector");
                double vector = sc.nextDouble();
                eggies[i] = vector;
            }
            System.out.println("Vector rellenado. Así ha quedado: " + Arrays.toString(eggies));
        } catch (InputMismatchException e){
            System.out.println("Eso no te ha dejado, codigo error: "+e);
        }
    }
}
