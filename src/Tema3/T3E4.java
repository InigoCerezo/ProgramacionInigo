package Tema3;

import java.text.DecimalFormat;
import java.util.Scanner;

public class T3E4 {
    public static void showMenu() {
        System.out.println("Conversor de dinero.");
        System.out.println("--------------------------------------");
        System.out.println("1 - Convertir dolares a euros");
        System.out.println("2 - Convertir euros a dolares");
        System.out.println("Ctro número - Salir");
    }
    public static double dollar2euro(double euros){
        return euros*0.853;
    }
    public static double euro2dollar(double dolla){
        return dolla*1.157;
    }
    public static void main(String[] args){
        int dinero;
        DecimalFormat df = new DecimalFormat("0.00");
        Scanner scanner = new Scanner(System.in);
        showMenu();
        int choose = scanner.nextInt();
        switch (choose) {
            case 1:
                System.out.println("Introduce una cantidad de dolares:");
                dinero = scanner.nextInt();
                System.out.println(df.format(dinero) +" dolares equivalen a "+ df.format(dollar2euro(dinero)) + " euros.");
                break;
            case 2:
                System.out.println("Introduce una cantidad de euros:");
                dinero = scanner.nextInt();
                System.out.println(df.format(dinero) +" euros equivalen a "+ df.format(euro2dollar(dinero)) + " dolares.");
                break;
            default:
                System.out.println("Saliendo");
                break;
        }
    }
}
