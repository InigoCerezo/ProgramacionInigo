package Tema3;

import java.util.Scanner;

public class T3E8 {
    public static boolean dateCheck(int a, int b, int c) {
        if  (b>12||b<0) {
            return false;
        }else if(b==2){
            if ((c%4==0 && (c%100!=0||c%400==0))&&a>29 ){
                return false;
            }else if(a>28){
                return false;
            }
        } else if ((b % 2 == 0 && b <7)||(b % 2 == 1 && b >=7)){
            if (a>30||a<0) {
                return false;
            }
        }else if((b % 2 == 1 && b <7)||(b % 2 == 0 && b >=7)){
            if (a>31||a<0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int dia, mes, anio;
        Scanner c = new Scanner(System.in);
        System.out.println("Introduce el día (Utiliza números):");
        dia = c.nextInt();
        System.out.println("Introduce el mes (Utiliza números):");
        mes = c.nextInt();
        System.out.println("Introduce el año (Utiliza números):");
        anio = c.nextInt();
        if (dateCheck(dia, mes, anio)) {
            System.out.println("La fecha es correcta, bien.");
        }else{
            System.out.println("La fecha es incorrecta, mal.");
        }
    }
}
