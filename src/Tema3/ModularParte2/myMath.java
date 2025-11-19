package Tema3.ModularParte2;

public class myMath {
    /// ----------------------EJERCICIO 1
    public static double rectnglePerimeter(double a, double b) {
        return (a * 2) + (b * 2);
    }
    public static double rectangleArea(double a, double b) {
        return (a * b);
    }
    public static double squarePerimeter(double a) {
        return a * 4;
    }
    public static double squareArea(double a) {
        return (a * 2);
    }
    public static double circlePerimeter(double a) {
        return 2 * Math.PI * a;
    }
    public static double circleArea(double a) {
        return Math.PI * (a * a);
    }

    /// ----------------------EJERCICIO 2
    public static boolean isPrime(int a, int b) {
        return a % b != 0;
    }
    public static boolean isNotPrime(int a, int b) {
        return a % b == 0;
    }
    /// ----------------------EJERCICIO 3
    public static void longitudNumero(int a) {
        int b = Integer.toString(a).length();
        System.out.println("El número " + a + " tiene " + b + " dígitos");
    }
    /// ----------------------EJERCICIO 4
    public static void paresEnNumero(String a) {
        for(int i=0;i<a.length();i++) {
            int par = Integer.parseInt(a.charAt(a.length()-1-i) + "");
            if (par % 2 == 0) {
                System.out.println(par);
            }
        }
    }

}
