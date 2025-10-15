package Tema2;

import java.util.Scanner;

public class T2e15 {
    public static void main(String[] args) {
        System.out.println("Introduce un mes (por número):");
        Scanner a = new Scanner(System.in);
        int month = a.nextInt();
        System.out.println("Introduce un año:");
        Scanner b = new Scanner(System.in);
        int year = b.nextInt();
        boolean bisiesto = year%4==0 && (year%100!=0||year%400==0);
        if (month == 2 && bisiesto == true) {
            System.out.println("Dias del mes: 29");
        }else if (month == 2) {
            System.out.println("Dias del mes: 28");
        }else if ((month % 2 == 1 && month <=7) || ((month % 2 == 0 && month >=8)) ){
            System.out.println("Dias del mes: 31");
        }else if ((month % 2 == 0 && month <=7) || (month % 2 == 1 && month >=8)){
            System.out.println("Dias del mes: 30");
        }
    }
}
