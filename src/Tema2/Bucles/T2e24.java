package Tema2.Bucles;

import java.util.Scanner;

public class T2e24 {
    public static void main(String[] args) {
        System.out.println("Introduce la nota del alumno (Introduce número negativo para salir)");
        Scanner a = new Scanner(System.in);
        int nota = a.nextInt();
        int bien = 0;
        int mal = 0;
        while (nota > 0) {
            if(nota > 10) { //foolproof check
                System.out.println("Introduce una nota de verdad.");
            } else if(nota >=5 ){
                bien++;
                System.out.println("Introduce la nota del alumno (Introduce número negativo para salir)");
            }else{
                mal++;
                System.out.println("Introduce la nota del alumno (Introduce número negativo para salir)");
            }
            nota = a.nextInt();
        }
        System.out.println("Alumnos aprobados: "+bien);
        System.out.println("Alumnos suspendidos: "+mal);
    }
}
