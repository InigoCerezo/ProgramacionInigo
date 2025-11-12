package Tema3;

import java.util.Scanner;

public class T3E1 {
    public static int numberSign(int a){
        if(a==0){
            return 0;
        }else if(a<0){
            return -1;
        }else{
            return 1;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce un número y te dire si es positivo, negativo, o cero:");
        int deafth = scanner.nextInt();
        int result = numberSign(deafth);
        if(result==0){
            System.out.println("El número es cero.");
        }else if(result<0){
            System.out.println("El número es negativo.");
        }else{
            System.out.println("El número es positivo");
        }
    }
}
