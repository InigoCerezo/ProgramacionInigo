package Tema3;

import java.text.DecimalFormat;
import java.util.Scanner;

import static Tema3.T3E1.numberSign;
import static Tema3.T3E2.isAdult;
import static Tema3.T3E3.*;
import static Tema3.T3E4.dollar2euro;
import static Tema3.T3E4.euro2dollar;
import static Tema3.T3E5.mutliplication;
import static Tema3.T3E7.isprime;
import static Tema3.T3E8.dateCheck;

public class T3E10 {
    public static void globalMenu() {
        System.out.println("Menu global.");
        System.out.println("--------------------------------------");
        System.out.println("1 - Comprobar si un número es positivo o negativo");
        System.out.println("2 - Comprobar si un número es mayor de edad o menor");
        System.out.println("3 - Calcular el area y la longitud de un circulo");
        System.out.println("4 - Cambiar de divisa de dolares a euros o viceversa");
        System.out.println("5 - Mostrar la tabla de multiplicar de un número del 1 al 10");
        System.out.println("6 - Automáticamente mostrar las tablas de multiplicar del 1 al 10");
        System.out.println("7 - Comprobador de números primos");
        System.out.println("8 - Comprobador de fechas");
        System.out.println("9 - Comprobar si un número es positivo o negativo");
        System.out.println("Otro número - Salir");
    }
    public static void main(String[] args) {
        Scanner es = new Scanner(System.in);
        int eleccion, deafth, answer, radio, choose, failure, dia, mes, anio;;
        double dinero;
        boolean result;
        globalMenu();
        eleccion = es.nextInt();
        switch (eleccion) {
            case 1:
                System.out.println("Introduce un número y te dire si es positivo, negativo, o cero:");
                deafth = es.nextInt();
                answer = numberSign(deafth);
                if(answer ==0){
                    System.out.println("El número es cero.");
                }else if(answer <0){
                    System.out.println("El número es negativo.");
                }else{
                    System.out.println("El número es positivo");
                }
                break;
            case 2:
                System.out.println("Introduce una edad:");
                deafth = es.nextInt();
                result = isAdult(deafth);
                if(result){
                    System.out.println("Es mayor de edad");
                }else{
                    System.out.println("Es menor de edad");
                }
                break;
            case 3:
                DecimalFormat df = new DecimalFormat("0.0000");
                Scanner scanner = new Scanner(System.in);
                System.out.println("Introduce el radio de un circulo:");
                radio = scanner.nextInt();
                result = validRadius(radio);
                if(result){
                    System.out.println("El radio es aceptable, calculando");
                    System.out.println("Perimetro del circulo: " + df.format(circlePerimeter(radio)));
                    System.out.println("Area del circulo: " + df.format(circleArea(radio)));
                }else{
                    System.out.println("El radio es negativo. Saliendo...");
                }
                break;
            case 4:
                DecimalFormat money = new DecimalFormat("0.00");
                choose = es.nextInt();
                switch (choose) {
                    case 1:
                        System.out.println("Introduce una cantidad de dolares:");
                        dinero = es.nextDouble();
                        System.out.println(money.format(dinero) +" dolares equivalen a "+ money.format(dollar2euro(dinero)) + " euros.");
                        break;
                    case 2:
                        System.out.println("Introduce una cantidad de euros:");
                        dinero = es.nextDouble();
                        System.out.println(money.format(dinero) +" euros equivalen a "+ money.format(euro2dollar(dinero)) + " dolares.");
                        break;
                    default:
                        System.out.println("Saliendo");
                        break;
                }
                break;
            case 5:
                System.out.println("Introduce un  número del 1 al 10");
                deafth = es.nextInt();
                while(deafth < 1 || deafth > 10){
                    System.out.println("Numero introducido incorrecto. Introducelo otra vez.");
                    deafth = es.nextInt();
                }
                mutliplication(deafth);
                break;
            case 6:
                deafth = 1;
                while(deafth != 11){
                    mutliplication(deafth);
                    deafth++;
                }
                break;
            case 7:
                deafth = es.nextInt();
                while (deafth!=0) {
                    if (deafth > 0) {
                        answer = 2;
                        failure = 0;
                        while (deafth != answer) {
                            if (!isprime(deafth, answer)) {
                                failure++;
                            }
                            answer++;
                        }
                        if (failure == 0) {
                            System.out.println("El numero " + deafth + " es primo.");
                        } else {
                            System.out.println("El numero " + deafth + " no es primo.");
                        }
                    } else {
                        System.out.println("El numero no era positivo.");
                    }
                    System.out.println("Introduce otro numero positivo y te diré si es primo.");
                    System.out.println("(Introduce cero para salir).");
                    deafth = es.nextInt();
                }
                break;
            case 8:
                System.out.println("Introduce el día (Utiliza números):");
                dia = es.nextInt();
                System.out.println("Introduce el mes (Utiliza números):");
                mes = es.nextInt();
                System.out.println("Introduce el año (Utiliza números):");
                anio = es.nextInt();
                if (dateCheck(dia, mes, anio)) {
                    System.out.println("La fecha es correcta, bien.");
                }else{
                    System.out.println("La fecha es incorrecta, mal.");
                }
                break;
            case 9:
                break;
            default:
                break;
        }
    }
}
