package Tema3.ModularParte2;

import java.util.Scanner;

import static Tema3.ModularParte2.MyMath.*;

public class T3E10myMath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char getout='N', eleccion, choose;
        String str1;
        int num1, num2, num3, fail;
        //inicialización de variables
        while (getout == 'N'||getout=='n') {
            globalMenuP2();
            eleccion = sc.next().charAt(0);
            switch (eleccion) {
                case 'a'://Ejercicio 1
                    System.out.println("Elige: a) circulo, b) cuadrado, c) rectangulo");
                    choose = sc.next().charAt(0);
                    switch(choose) { //elección de modulos del ejercicio 1 los cuales hacen el trabajo
                        case 'a':
                            System.out.println("Introduce Radio: ");
                            num1 = sc.nextInt();
                            System.out.println("Area: " + circleArea(num1) + "\nPerimetro: " + circlePerimeter(num1));
                            break;
                        case 'b':
                            System.out.println("Introduce Lado: ");
                            num1 = sc.nextInt();
                            System.out.println("Area: " + squareArea(num1) + "\nPerimetro: " + squarePerimeter(num1));
                            break;
                        case 'c':
                            System.out.println("Introduce Base: ");
                            num1 = sc.nextInt();
                            System.out.println("Introduce Altura: ");
                            num2 = sc.nextInt();
                            System.out.println("Area: " + rectangleArea(num1, num2) + "\nPerimetro: " + rectanglePerimeter(num1, num2));
                            break;
                        default:
                            System.out.println("Opción invalida, Saliendo.");
                            break;
                    }
                    break;
                case 'b'://Ejercicio 2
                    System.out.println("Elige: a) Primos, b) No primos");
                    choose = sc.next().charAt(0);
                    switch(choose){
                        case 'a':
                            System.out.println("Introduce un número y te diré si es primo");
                            num1 = sc.nextInt();
                            if (num1 > 0) {
                                num2 = 2;
                                fail = 0;
                                while (num1 != num2) {
                                    if (!isPrime(num1, num2)) {//modulo encargado de asegurarse de que es primo
                                        fail++;//variable que sube si no es primo
                                    }
                                    num2++;
                                }
                                if (fail == 0) {
                                    System.out.println("El numero " + num1 + " es primo.");
                                }else{
                                    System.out.println(isPrime(num1, num2));
                                }
                            } else {
                                System.out.println("El numero no era positivo.");
                            }
                            break;
                        case 'b':
                            System.out.println("Introduce un número y te diré si no es primo");
                            num1 = sc.nextInt();
                            if (num1 > 0) {
                                num2 = 2;
                                fail = 0;
                                while (num1 != num2) {
                                    if (!isNotPrime(num1, num2)) {//modulo encargado de asegurarse de que es primo
                                        fail++;//variable que sube si es primo
                                    }
                                    num2++;
                                }
                                if (fail == 0) {
                                    System.out.println("El numero " + num1 + " no es primo.");
                                }else{
                                    System.out.println(!isNotPrime(num1, num2));
                                }
                            } else {
                                System.out.println("El numero no era positivo.");
                            }
                            break;
                        default:
                            System.out.println("Opción invalida, Saliendo.");
                            break;
                    }
                    break;
                case 'c'://Ejercicio 3
                    System.out.println("Introduce un número: ");
                    num1 = sc.nextInt();
                    System.out.println("El número dado tiene" + longitudNumero(num1) + " cifras.");
                    break;
                case 'd'://Ejercicio 4
                    System.out.println("Introduce un número: ");
                    num1 = sc.nextInt();
                    System.out.println("Numero par: " + paresEnNumero(num1));
                    break;
                case 'e'://Ejercicio 5
                    System.out.println("Introduce un número: ");
                    num1 = sc.nextInt();
                    System.out.println("Numero impar: " + imparesEnNumero(num1));
                    break;
                case 'f'://Ejercicio 6
                    System.out.println("Introduce un número: ");
                    num1 = sc.nextInt();
                    System.out.println("El factorial de "+num1+" es " +factorial(num1));
                    break;
                case 'g'://Ejercicio 7
                    System.out.println("Introduce un número: ");
                    num1 = sc.nextInt();
                    num2 = factorialRecursive(num1);
                    System.out.println("El factorial de "+num1+" es " +num2);
                    break;
                case 'h'://Ejercicio 8
                    System.out.println("Introduce el primer coeficiente (a): ");
                    num1 = sc.nextInt();
                    System.out.println("Introduce el segundo coeficiente (b):");
                    num2 = sc.nextInt();
                    System.out.println("Introduce el tercer coeficiente (c):");
                    num3 = sc.nextInt();
                    System.out.println("Soluciones posibles: "+ segundoGrado(num1, num2, num3));
                    break;
                case 'i'://Ejercicio 9
                    System.out.println("Introduce un número:");
                    str1 = sc.next();
                    System.out.println("La suma de los digitos del número "+str1+" es igual a: " + sumaEntreNumeros(str1));
                    break;
                default:
                    System.out.println("Opción no valida.");
                    break;
            }
            System.out.println("¿Quieres salir? (Y/N)"); //linea encargada de salir
            getout=sc.next().charAt(0);// cualquier otro carácter hace lo mismo que Y, lo cual es salir
        }
    }
}
