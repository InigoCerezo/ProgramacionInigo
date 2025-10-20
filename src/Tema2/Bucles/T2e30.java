package Tema2.Bucles;
import java.util.Scanner;
public class T2e30 {
    public static void main(String[] args) {
        char exit = 0;
        while (exit != 'Y' && exit != 'y'){
            System.out.println("Introduce un número.");
            Scanner a = new Scanner(System.in);
            double num1 = a.nextDouble();
            System.out.println("Introduce un operador (+,-,*,/,%).");
            char op = a.next().charAt(0);
            System.out.println("Introduce otro número.");
            double num2 = a.nextDouble();
            switch(op){
                case '+':
                    double suma = num1 + num2;
                    System.out.println("Suma: "+suma);
                    break;
                case '-':
                    double resta = num1 - num2;
                    System.out.println("Resta: "+resta);
                    break;
                case '*':
                    double prod = num1 * num2;
                    System.out.println("Multiplicación: "+ prod);
                    break;
                case '/':
                    double div = num1 % num2;
                    System.out.println("División: "+ div);
                    break;
                case '%':
                    double res = num1 % num2;
                    System.out.println("Resto: "+ res);
                    break;
                default:
                    System.out.println("Algo ha fallado.");
                    break;
            }
            System.out.println("¿Quieres salir?(Y/N)");
            Scanner b = new Scanner(System.in);
            exit = b.next().charAt(0);
        }
    }
}
