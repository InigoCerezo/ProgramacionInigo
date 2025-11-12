package Tema3;

import java.text.DecimalFormat;
import java.util.Scanner;

public class T3E3 {
    public static boolean validRadius(int a){
        if(a>0){
            return true;
        }else{
            return false;
        }
    }
    public static double circlePerimeter(double a){
        return 2 * Math.PI * a;
    }
    public static double circleArea(double a){
        return Math.PI * (a*a);
    }
    public static void main(String[] args) throws InterruptedException {
        DecimalFormat df = new DecimalFormat("0.0000");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el radio de un circulo:");
        int radio = scanner.nextInt();
        boolean result = validRadius(radio);
        if(result){
            System.out.println("El radio es aceptable, calculando");
            Thread.sleep(1000);
            System.out.println("Perimetro del circulo: " + df.format(circlePerimeter(radio)));
            System.out.println("Area del circulo: " + df.format(circleArea(radio)));
        }else{
            System.out.println("El radio es negativo. Saliendo...");
        }
    }
}
