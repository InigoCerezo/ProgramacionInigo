package Tema5.excepcion;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ejercicio5 {
    static boolean b = true;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int num;
        char letra;
        while (b) {
            System.out.println("Introduce el numero: ");
            try{
                num = sc.nextInt();
                System.out.println("Introduce la letra (A o B, X para salir): ");
                letra = sc.next().charAt(0);
                letra = Character.toUpperCase(letra);
                switch(letra){
                    case 'A':
                        printPositive(num);
                        break;
                    case 'B':
                        printNegative(num);
                        break;
                    case 'X':
                        b = false;
                        break;
                    default:
                        System.out.println("La letra no es valida");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error fatal: "+e.getMessage());
                b = false;
            }
            catch (Exception e) {
                System.out.println("Error: " +e.getMessage());
            }
        }
    }
    public static void printPositive(int p) throws Exception{
        if (p < 0){
            System.out.println("no es positivo");
            throw new Exception();
        }else{
            System.out.println("Positivo");
        }
    }
    public static void printNegative(int n) throws Exception{
        if (n >= 0){
            throw new Exception("no es negativo");
        }else{
            System.out.println("Negativo");
        }
    }
}
