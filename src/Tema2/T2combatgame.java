package Tema2;
import java.util.Scanner;

public class T2combatgame {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("juego");
        Scanner a = new Scanner(System.in);
        int pat1 = 999;
        int pvd1 = 999;
        int pdf1 = 999;
        int vel1 = 999;
        System.out.println("JUGADOR 1:");
        do{
            System.out.println("Introduce los puntos de vida.");
            pvd1 = a.nextInt();
            while (pvd1 > 200 || pvd1 <= 0){
                System.out.println("Valor no admitido. Introducelos de nuevo.");
                pvd1 = a.nextInt();
            }
            System.out.println("Introduce los puntos de ataque.");
            pat1 = a.nextInt();
            while (pat1 > 200 || pat1 <= 0){
                System.out.println("Valor no admitido. Introducelos de nuevo.");
                pat1 = a.nextInt();
            }
            System.out.println("Introduce los puntos de defensa.");
            pdf1 = a.nextInt();
            while (pdf1 > 200 || pdf1 <= 0){
                System.out.println("Valor no admitido. Introducelos de nuevo.");
                pdf1 = a.nextInt();
            }
            System.out.println("Introduce los puntos de velocidad.");
            vel1 = a.nextInt();
            while (vel1 > 200 || vel1 <= 0){
                System.out.println("Valor no admitido. Introducelos de nuevo.");
                vel1 = a.nextInt();
            }
            if (pat1 + pvd1 + pdf1 + vel1 > 500){
                System.out.println("La suma de todo no puede ser más de 500.");
            }else{
                break;
            }
        }
        while (pat1 + pvd1 + pdf1 + vel1 > 500);
        Thread.sleep(1000);
        System.out.println("ok");
        Thread.sleep(200);
        System.out.println("bien");
        Thread.sleep(200);
        System.out.println("bien");
        Thread.sleep(1000);
        int pat2 = 999;
        int pvd2 = 999;
        int pdf2 = 999;
        int vel2 = 999;
        System.out.println("JUGADOR 2:");
        do{
            System.out.println("Introduce los puntos de vida.");
            pvd2 = a.nextInt();
            while (pvd2 > 200|| pvd2 <= 0){
                System.out.println("Valor no admitido. Introducelos de nuevo.");
                pvd2 = a.nextInt();
            }
            System.out.println("Introduce los puntos de ataque.");
            pat2 = a.nextInt();
            while (pat2 > 200|| pat2 <= 0){
                System.out.println("Valor no admitido. Introducelos de nuevo.");
                pat2 = a.nextInt();
            }
            System.out.println("Introduce los puntos de defensa.");
            pdf2 = a.nextInt();
            while (pdf2 > 200|| pdf2 <= 0){
                System.out.println("Valor no admitido. Introducelos de nuevo.");
                pdf2 = a.nextInt();
            }
            System.out.println("Introduce los puntos de velocidad.");
            vel2 = a.nextInt();
            while (vel2 > 200|| vel2 <= 0){
                System.out.println("Valor no admitido. Introducelos de nuevo.");
                vel2 = a.nextInt();
            }
            if (pat1 + pvd1 + pdf1 + vel1 > 500){
                System.out.println("La suma de todo no puede ser más de 500.");
            }else{
                break;
            }
        }
        while (pat2 + pvd2 + pdf2 + vel2 > 500);
    }
}
