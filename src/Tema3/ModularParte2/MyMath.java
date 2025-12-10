package Tema3.ModularParte2;

public class MyMath {
    /// ----------------------EJERCICIO 1
    public static double rectanglePerimeter(double a, double b) {
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
        return !isPrime(a, b);
    }
    /// ----------------------EJERCICIO 3
    /// //TODO: devolver el numero de digitos
    public static int longitudNumero(int a) {
        int divis = 1;
        while (a > 10) {
            a = a/10;
            divis++;
        }
        return divis;
    }
    /// ----------------------EJERCICIO 4
    /// //TODO: hacer una versión más fácil. Mirar mis soluciones
    public static int paresEnNumero(int a) {
        int divis = 0, par;
        while (a > 10) {
            par = a % 10;
            if (par%2 == 0){
                divis++;
            }
            a = a/10;
        }
        return divis;
    }
    /// ----------------------EJERCICIO 5
    public static int imparesEnNumero(int a) {
        int divis = 0, impar;
        while (a > 10) {
            impar = a % 10;
            if (impar %2 != 0){
                divis++;
            }
            a = a/10;
        }
        return divis;
    }
    /// ----------------------EJERCICIO 6
    public static int factorial(int a) {
        int b = 1;
        for (int i = 1; i <= a; i++) {
            b = b * i;
        }
        return b;
    }
    /// ----------------------EJERCICIO 7
    public static int factorialRecursive(int a) {
        if (a <= 1) {
            return 1;
        }else{
            return a * factorialRecursive(a-1);
        }
    }
    /// ----------------------EJERCICIO 8
    public static int segundoGrado(double a, double b, double c) {
        double discriminant;
        discriminant = (b*b) - (4 * a * c);
        if (discriminant > 0) {
            return 2;
        } else if (discriminant == 0) {
            return 1;
        } else {
            return 0;
        }

    }
    /// ----------------------EJERCICIO 9
    public static int sumaEntreNumeros(String a) {
        int suma = 0, par;
        for(int i=0;i<a.length();i++) {
            par = Integer.parseInt(a.charAt(a.length()-1-i) + "");
            suma = suma + par;
        }
        return suma;
    }
    /// ----------------------MENU
    public static void globalMenuP2() {
        System.out.println("Menu global.");//menu global
        System.out.println("--------------------------------------");
        System.out.println("a - Calcular el perímetro y el área de un círculo, cuadrado y rectángulo");
        System.out.println("b - Comprobador de números primos");
        System.out.println("c - indicador de dígitos de un número entero");
        System.out.println("d - indicador de dígitos pares de un número entero");
        System.out.println("e - indicador de dígitos impares de un número entero");
        System.out.println("f - Calculador del factorial de un número");
        System.out.println("g - Calculador del factorial recursivo de un número");
        System.out.println("h - Calculador de ecuaciones de segundo grado");
        System.out.println("i - Sumatorio de digitos de un número entero");
        System.out.println("Otra opción - Salir");
    }
}
