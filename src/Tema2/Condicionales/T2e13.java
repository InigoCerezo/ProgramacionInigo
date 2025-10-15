package Tema2.Condicionales;

import java.util.Scanner;

public class T2e13 {
    public static void main(String[] args) {
        System.out.println("Introduce la hora:");
        Scanner a = new Scanner(System.in);
        int h = a.nextInt();
        while (h < 0 || h > 23){
            System.out.println("bruh.");
            System.out.println("Introduce la hora:");
            h = a.nextInt();
        }
        System.out.println("Introduce los minutos:");
        Scanner b = new Scanner(System.in);
        int min = b.nextInt();
        while (min < 0 || min > 60){
            System.out.println("bruh.");
            System.out.println("Introduce los minutos:");
            min = b.nextInt();
        }
        System.out.println("Introduce el último número:");
        Scanner c = new Scanner(System.in);
        int seg = c.nextInt();
        while (seg < 0 || seg > 60){
            System.out.println("bruh.");
            System.out.println("Introduce los segundos:");
            seg = c.nextInt();
        }
        int Timepasses = h;
        int Timecounts = min;
        int Timeticks = seg + 1;
        //seg = seg++;
        if (Timeticks == 60) {
            Timecounts = min + 1;
            Timeticks = 0;
        }
        if (Timecounts == 60) {
            Timepasses = h + 1;
            Timecounts = 0;
        }
        if (Timepasses == 24) {
            Timepasses = 0;
        }
        System.out.println("Resultado: " + Timepasses + ":" + Timecounts + ":" + Timeticks);
    }
}
