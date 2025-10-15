package Tema2;

import java.util.Scanner;

public class T2e14 {
    public static void main(String[] args) {
        System.out.println("Introduce la cantidad de personas:");
        Scanner a = new Scanner(System.in);
        int peeble = a.nextInt();
        System.out.println("Introduce los minutos:");
        Scanner b = new Scanner(System.in);
        int dayze = b.nextInt();
        float price = dayze * peeble * 15;
        double discont = (double)price * 0.75;
        if (peeble >= 5 && dayze >= 7) {
            System.out.println("Precio total: "+price+" euros");
        }
        System.out.println("Precio total: "+ discont +" euros");
    }
}
