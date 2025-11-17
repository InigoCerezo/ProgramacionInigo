package Tema3;

import java.text.DecimalFormat;
import java.util.Scanner;

import static Tema3.T3E1.numberSign;
import static Tema3.T3E2.isAdult;
import static Tema3.T3E3.*;
import static Tema3.T3E4.*;
import static Tema3.T3E5.mutliplication;
import static Tema3.T3E7.isprime;
import static Tema3.T3E8.dateCheck;
import static Tema3.T3E9.piramide;

public class T3E10 {
    public static void globalMenu() {
        System.out.println("Menu global.");//menu global
        System.out.println("--------------------------------------");
        System.out.println("a - Comprobar si un número es positivo o negativo");
        System.out.println("b - Comprobar si un número es mayor de edad o menor");
        System.out.println("c - Calcular el area y la longitud de un circulo");
        System.out.println("d - Cambiar de divisa de dolares a euros o viceversa");
        System.out.println("e - Mostrar la tabla de multiplicar de un número del 1 al 10");
        System.out.println("f - Automáticamente mostrar las tablas de multiplicar del 1 al 10");
        System.out.println("g - Comprobador de números primos");
        System.out.println("h - Comprobador de fechas");
        System.out.println("i - Comprobar si un número es positivo o negativo");
        System.out.println("Otra opción - Salir");
    }
    public static void main(String[] args) {
        Scanner es = new Scanner(System.in);
        int num1, num2, radio, choose, failure, dia, mes, anio, altura;
        double dinero;
        boolean result;
        char getout='N', eleccion, caracter;
        //inicialización de variables
        while (getout == 'N'||getout=='n') {
            globalMenu();
            eleccion = es.next().charAt(0);
            switch (eleccion) {
                case 'a':
                    System.out.println("Introduce un número y te dire si es positivo, negativo, o cero:");
                    num1 = es.nextInt();
                    num2 = numberSign(num1);//modulo del ejercicio 1 la cual hace el trabajo
                    if (num2 == 0) {
                        System.out.println("El número es cero.");
                    } else if (num2 < 0) {
                        System.out.println("El número es negativo.");
                    } else {
                        System.out.println("El número es positivo");
                    }
                    break;
                case 'b':
                    System.out.println("Introduce una edad:");
                    num1 = es.nextInt();
                    result = isAdult(num1);//modulo del ejercicio 2 la cual hace el trabajo
                    if (result) {
                        System.out.println("Es mayor de edad");
                    } else {
                        System.out.println("Es menor de edad");
                    }
                    break;
                case 'c'://Ejercicio 3
                    DecimalFormat df = new DecimalFormat("0.0000");
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Introduce el radio de un circulo:");
                    radio = scanner.nextInt();
                    result = validRadius(radio);//modulo del ejercicio 3 que se asegura de que no entren números negativos o ceros
                    if (result) {
                        System.out.println("El radio es aceptable, calculando");
                        System.out.println("Perimetro del circulo: " + df.format(circlePerimeter(radio)));//modulo que calcula la longitud
                        System.out.println("Area del circulo: " + df.format(circleArea(radio)));//modulo que calcula la superficie
                    } else {
                        System.out.println("El radio es negativo. Saliendo...");
                    }
                    break;
                case 'd'://Ejercicio 4
                    DecimalFormat money = new DecimalFormat("0.00");
                    showMenu();//menu del ejercicio 4
                    choose = es.nextInt();
                    switch (choose) {
                        case 1://switch case que se encarga de cambiar de dolar a euro
                            System.out.println("Introduce una cantidad de dolares:");
                            dinero = es.nextDouble();
                            System.out.println(money.format(dinero) + " dolares equivalen a " + money.format(dollar2euro(dinero)) + " euros.");
                            break;
                        case 2://switch case que se encarga de cambiar de euro a dolar
                            System.out.println("Introduce una cantidad de euros:");
                            dinero = es.nextDouble();
                            System.out.println(money.format(dinero) + " euros equivalen a " + money.format(euro2dollar(dinero)) + " dolares.");
                            break;
                        default://switch case que se encarga de salir si no hay opciones
                            System.out.println("Saliendo");
                            break;
                    }
                    break;
                case 'e'://Ejercicio 5
                    System.out.println("Introduce un número entero del 1 al 10");
                    num1 = es.nextInt();
                    while (num1 < 1 || num1 > 10) { //bucle que se asegura de que el valor sea del 1 al 10
                        System.out.println("Numero introducido incorrecto. Introducelo otra vez.");
                        num1 = es.nextInt();
                    }
                    mutliplication(num1);//modulo que muestra tablas de multiplicación
                    break;
                case 'f'://Ejercicio 6
                    num1 = 1;
                    while (num1 != 11) {//bucle que no sale hasta que num1 sea 11
                        mutliplication(num1);//modulo que muestra tablas de multiplicación por cada num1
                        num1++;
                    }
                    break;
                case 'g'://Ejercicio 7
                    System.out.println("Introduce un número y te diré si es primo");
                    System.out.println("(Introduce cero para salir).");
                    num1 = es.nextInt();
                    while (num1 != 0) {
                        if (num1 > 0) {
                            num2 = 2;
                            failure = 0;
                            while (num1 != num2) {
                                if (!isprime(num1, num2)) {//modulo encargado de asegurarse de que es primo
                                    failure++;//variable que sube si no es primo
                                }
                                num2++;
                            }
                            if (failure == 0) {
                                System.out.println("El numero " + num1 + " es primo.");
                            } else {
                                System.out.println("El numero " + num1 + " no es primo.");
                            }
                        } else {
                            System.out.println("El numero no era positivo.");
                        }
                        System.out.println("Introduce otro numero positivo y te diré si es primo.");
                        System.out.println("(Introduce cero para salir).");
                        num1 = es.nextInt();
                    }
                    break;
                case 'h'://Ejercicio 8
                    System.out.println("Introduce el día (Utiliza números):");
                    dia = es.nextInt();
                    System.out.println("Introduce el mes (Utiliza números):");
                    mes = es.nextInt();
                    System.out.println("Introduce el año (Utiliza números):");
                    anio = es.nextInt();
                    if (dateCheck(dia, mes, anio)) {//modulo encargado de asegurarse de que la fecha es válida
                        System.out.println(dia+"/"+mes+"/"+anio);
                        System.out.println("La fecha es correcta, bien.");
                    } else {
                        System.out.println(dia+"/"+mes+"/"+anio+"?");
                        System.out.println("La fecha es incorrecta, mal.");
                    }
                    break;
                case 'i'://Ejercicio 9
                    System.out.println("Introduce la altura del triangulo:");
                    altura = es.nextInt();
                    System.out.println("Ahora introduce un carácter:");
                    caracter = es.next().charAt(0);
                    piramide(altura, caracter);//modulo encargado de construir la pirámide
                    System.out.println();
                    break;
                default:
                    System.out.println("Opción no valida.");
                    break;
            }
            System.out.println("¿Quieres salir? (Y/N)"); //linea encargada de salir
            getout=es.next().charAt(0);// cualquier otro carácter hace lo mismo que Y, lo cual es salir
        }
    }
}
