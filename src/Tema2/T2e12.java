package Tema2;

import java.util.Scanner;

public class T2e12 {
    public static void main(String[] args){
        System.out.println("Introduce un número:");
        Scanner a = new Scanner(System.in);
        int A = a.nextInt();
        System.out.println("Introduce otro número:");
        Scanner b = new Scanner(System.in);
        int B = b.nextInt();
        System.out.println("Introduce el último número:");
        Scanner c = new Scanner(System.in);
        int C = c.nextInt();
        if(A > B && B > C) {
            System.out.println("Números introducidos de mayor a menor: "+A+", "+B+", "+C);
        } else if(A > C && B < C) {
            System.out.println("Números introducidos de menor a mayor: "+A+", "+C+", "+B);
        } else if(A < B && A > C){
            System.out.println("Números introducidos de menor a mayor: "+B+", "+A+", "+C);
        } else if(C < B && C > A){
            System.out.println("Números introducidos de menor a mayor: "+B+", "+C+", "+A);
        } else if(A < C && A > B){
            System.out.println("Números introducidos de menor a mayor: "+C+", "+A+", "+B);
        } else if(B < C && A < B){
            System.out.println("Números introducidos de menor a mayor: "+C+", "+B+", "+A);
        }
    }
}
